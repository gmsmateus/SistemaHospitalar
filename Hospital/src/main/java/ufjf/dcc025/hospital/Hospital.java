package ufjf.dcc025.hospital;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import ufjf.dcc025.hospital.usuarios.Usuario;
import ufjf.dcc025.hospital.usuarios.médico.Agenda;
import ufjf.dcc025.hospital.usuarios.médico.Medico;
import ufjf.dcc025.hospital.usuarios.paciente.Paciente;
import ufjf.dcc025.hospital.exception.UsuarioNaoEncontradoException;
import ufjf.dcc025.hospital.exception.DadosInvalidosException;
import ufjf.dcc025.hospital.servicos_hospital.Consulta;
/**
 *classe central do sistema do hospital
 *é responsavel por gerenciar o cadastro e acesso aos usuarios
 * @author mjjun
 */

public class Hospital {
    //private List<Medico> medicos;
    //private List<Paciente> pacientes;
    private List<Usuario> usuarios;
    private List<Consulta> consultas;

    public Hospital(){
        //this.medicos = new ArrayList<>();
        //this.pacientes = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }

    //Parte do cadastro
    public void cadastrarMedico(Medico medico){
        boolean existe = usuarios.stream()
                .anyMatch(u->u.getCpf().equals(medico.getCpf()));
        if(existe){
            throw new DadosInvalidosException("Medico já cadastrado com esse CPF");
        }
        usuarios.add(medico);
    }

    public void cadastrarPaciente(Paciente paciente){
        boolean existe = usuarios.stream()
                .anyMatch(u->u.getCpf().equals(paciente.getCpf()));
        if(existe){
            throw new DadosInvalidosException("Paciente já cadastrado com esse CPF");
        }
        usuarios.add(paciente);
    }

    //parte da busca
    public Medico buscarMedicoPorCpf(String cpf){
        return usuarios.stream()
            .filter(u -> u instanceof Medico)
            .map(u -> (Medico) u)
            .filter(m -> m.getCpf().equals(cpf))
            .findFirst()
            .orElseThrow(() ->
                new UsuarioNaoEncontradoException("Médico não encontrado"));
}
    public Paciente buscarPacientePorCpf(String cpf){
        return usuarios.stream()
            .filter(u -> u instanceof Paciente)
            .map(u -> (Paciente) u)
            .filter(p -> p.getCpf().equals(cpf))
            .findFirst()
            .orElseThrow(() ->
                new UsuarioNaoEncontradoException("Paciente não encontrado"));
}

    //parte da listagem
    public List<Medico> listarMedicos(){
        return usuarios.stream()
            .filter(u -> u instanceof Medico)
            .map(u -> (Medico) u)
            .toList();
    }

    public List<Paciente> listarPacientes(){
        return usuarios.stream()
            .filter(u -> u instanceof Paciente)
            .map(u -> (Paciente) u)
            .toList();
    }

    //registra uma nova consulta
    public void registrarConsulta(Consulta consulta){
        consultas.add(consulta);
    }
    //lista com todas consultas
    public List<Consulta> listarConsultas(){
        return new ArrayList<>(consultas);
    }
    //lista de consultas de um medico
    public List<Consulta> listarConsultasPorMedico(Medico medico){
        return consultas.stream()
                .filter(c -> c.getMedico().equals(medico))
                .filter(c -> !c.isRealizada())
                .toList();
    }
    //lista de consultas de um paciente
    public List<Consulta> listarConsultasPorPaciente(Paciente paciente){
        return consultas.stream()
                .filter(c -> c.getPaciente().equals(paciente))
                .filter(c -> !c.isRealizada())
                .toList();
    }

    public Usuario login(String login, String senha){
        Usuario usuario = usuarios.stream()
            .filter(u -> u.getLogin().equals(login))
            .findFirst()
            .orElseThrow(() ->
                new UsuarioNaoEncontradoException("Usuario não encontrado"));
        if(!usuario.validarSenha(senha)){
            throw new DadosInvalidosException("Senha incorreta!");
        }

        return usuario;
    }

    public void marcarConsulta(String cpfMedico, String cpfPaciente, LocalDate data, LocalTime hora){
        Medico medico = buscarMedicoPorCpf(cpfMedico);
        Paciente paciente = buscarPacientePorCpf(cpfPaciente);

        if(medico.getAgenda() == null){
            throw new DadosInvalidosException("Médico não possui agenda definida");
        }
        LocalDateTime horario = LocalDateTime.of(data, hora);
        validarHorarioConsulta(medico, data, hora);
        validarConflitoHorario(medico, data, hora);
        Consulta consulta = new Consulta(medico, paciente, horario);
        consultas.add(consulta);
    }

    private void validarHorarioConsulta(Medico medico, LocalDate data, LocalTime hora){
        Agenda agenda = medico.getAgenda();
        //primeiro vou verificar o dia da semana
        if(!agenda.getDia().equals(data.getDayOfWeek())){
            throw new DadosInvalidosException("Médico não atende neste dia");
        }
        //agora vou verificar o intervalo do horario
        if(hora.isBefore(agenda.getHoraInicio())|| hora.isAfter(agenda.getHoraFim())){
            throw new DadosInvalidosException("Horário fora do período de atendimento");
        }
        //verifica o encaixe da duração agora
        long minutosDesdeInicio = java.time.Duration.between(agenda.getHoraInicio(), hora).toMinutes();
        if(minutosDesdeInicio % agenda.getDuracaoConsultas()!=0){
            throw new DadosInvalidosException("Horário não compativel com a duração da consulta");
        }
    }

    private void validarConflitoHorario(Medico medico, LocalDate data, LocalTime hora){
        boolean conflito = consultas.stream()
                .anyMatch(c->
                    c.getMedico().equals(medico) && 
                    c.getDataHora().toLocalDate().equals(data) &&
                    c.getDataHora().toLocalTime().equals(hora)
                );
        if(conflito){
            throw new DadosInvalidosException("Médico ja possui consulta marcada nesse horario");
        }
    }

    public void cancelarConsulta(Consulta consulta){
        boolean removida = consultas.remove(consulta);

        if(!removida){
            throw new UsuarioNaoEncontradoException("Consulta não encontrada para cancelamento");
        }
    }

    public void reagendarConsulta(Consulta consulta, LocalDate novaData, LocalTime novaHora){
        if(!consultas.contains(consulta)){
            throw new UsuarioNaoEncontradoException("Consulta não encontrada");
        }

        //ja reaproveito para validar o horario
        validarHorarioConsulta(consulta.getMedico(), novaData, novaHora);
        consulta.reagendar(novaData, novaHora);
    }

    public List<Consulta> listarConsultasDoDia(LocalDate data){
        return consultas.stream()
                .filter(c -> c.getDataHora().toLocalDate().equals(data))
                .toList();
    }

    public void finalizarConsulta(Consulta consulta){
        if(!consultas.contains(consulta)){
            throw new UsuarioNaoEncontradoException("Consulta não encontrada");
        }
        if(consulta.isRealizada()){
            throw new DadosInvalidosException("Consulta já foi realizada");
        }
        consulta.marcarConcluida();
    }

}
