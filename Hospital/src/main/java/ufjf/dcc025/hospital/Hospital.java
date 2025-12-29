package ufjf.dcc025.hospital;

import java.util.ArrayList;
import java.util.List;
//import ufjf.dcc025.hospital.usuarios.Usuario;
import ufjf.dcc025.hospital.usuarios.médico.Medico;
import ufjf.dcc025.hospital.usuarios.paciente.Paciente;
import ufjf.dcc025.hospital.exception.UsuarioNaoEncontradoException;
import ufjf.dcc025.hospital.exception.DadosInvalidosException;
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
        boolean existe = medicos.stream()
                .anyMatch(m->m.getCpf().equals(medico.getCpf()));
        if(existe){
            throw new DadosInvalidosException("Medico já cadastrado com esse CPF");
        }
        medicos.add(medico);
    }

    public void cadastrarPaciente(Paciente paciente){
        boolean existe = pacientes.stream()
                .anyMatch(p->p.getCpf().equals(paciente.getCpf()));
        if(existe){
            throw new DadosInvalidosException("Paciente já cadastrado com esse CPF");
        }
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
