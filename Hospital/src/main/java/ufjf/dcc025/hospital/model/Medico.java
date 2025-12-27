package ufjf.dcc025.hospital.model;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author mjjun
 */

///herança da classe usuario, ja que o medico também é um usuario do sistema
public class Medico extends Usuario{
    private String especialidade;
    private boolean ativo;
    //cada medico vai ter uma agenda de consultas que começa vazia
    private List<Consulta> agenda;

    ///construtor do medico
    public Medico(String nome, String cpf, String especialidade){
        super(nome, cpf);
        this.especialidade = especialidade;
        this.ativo = true;
        this.agenda = new ArrayList<>();
    }

    public void adicionarConsulta(Consulta consulta){
        agenda.add(consulta);
    }

    public String getEspecialidade(){
        return especialidade;
    }

    public boolean isAtivo(){
        return ativo;
    }
    
    public void desativar(){
        this.ativo = false;
    }

    public void ativar(){
        this.ativo=true;
    }

    //metodo para facilitar a visualização dos dados do medico
    @Override
    public String toString(){
    return "Medico{" +
            "nome='" + nome + '\'' +
            ", cpf='" + cpf + '\'' +
            ", especialidade='" + especialidade + '\'' +
            ", ativo=" + ativo +
            '}';
    }
}