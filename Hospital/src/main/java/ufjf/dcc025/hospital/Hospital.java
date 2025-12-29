package ufjf.dcc025.hospital;

import java.util.ArrayList;
import java.util.List;
//import ufjf.dcc025.hospital.usuarios.Usuario;
import ufjf.dcc025.hospital.usuarios.médico.Medico;
import ufjf.dcc025.hospital.usuarios.paciente.Paciente;
import ufjf.dcc025.hospital.exception.UsuarioNaoEncontradoException;
/**
 *classe central do sistema do hospital
 *é responsavel por gerenciar o cadastro e acesso aos usuarios
 * @author mjjun
 */
public class Hospital {
    private List<Medico> medicos;
    private List<Paciente> pacientes;

    public Hospital(){
        this.medicos = new ArrayList<>();
        this.pacientes = new ArrayList<>();
    }

    //Parte do cadastro
    public void cadastrarMedico(Medico medico){
        medicos.add(medico);
    }

    public void cadastrarPaciente(Paciente paciente){
        pacientes.add(paciente);
    }

    //parte da busca
    public Medico buscarMedicoPorCpf(String cpf){
        return medicos.stream()
                .filter(m -> m.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(()->
                    new UsuarioNaoEncontradoException("Medico não encontrado"));
    }
    public Paciente buscarPacientePorCpf(String cpf){
        return pacientes.stream()
                .filter(p -> p.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(()->
                    new UsuarioNaoEncontradoException("Paciente não encontrado"));
    }

    //parte da listagem
    public List<Medico> listarMedicos(){
        return new ArrayList<>(medicos);
    }
    public List<Paciente> listarPacientes(){
        return new ArrayList<>(pacientes);
    }

}
