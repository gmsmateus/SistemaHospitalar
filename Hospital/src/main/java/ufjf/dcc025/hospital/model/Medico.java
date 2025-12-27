package ufjf.dcc025.hospital.model;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author mjjun
 */


/**
 * Representa um medico do sistema hospitalar.
 * O medico é um tipo de usuario que possui uma especialidade,
 * um status de atividade e uma agenda de consultas.
 */
public class Medico extends Usuario{
    private String especialidade;
    private boolean ativo;
    //cada medico vai ter uma agenda de consultas que começa vazia
    private List<Consulta> agenda;

    /**
    * Cria um medico com nome, CPF e especialidade.
    *
    * @param nome nome do medico
    * @param cpf cpf do medico
    * @param especialidade especialidade medica
    */

    public Medico(String nome, String cpf, String especialidade){
        super(nome, cpf);
        this.especialidade = especialidade;
        this.ativo = true;
        this.agenda = new ArrayList<>();
    }

    /**
    * Adiciona uma consulta a agenda do medico.
    *
    * @param consulta consulta a ser adicionada
    */  
    public void adicionarConsulta(Consulta consulta){
        //verifica se o medico está ativo antes de adicionar a consulta
        if(!ativo){
            throw new IllegalStateException("Médico está inativo, então não pode adicionar consultas.");
        }
        else{
            this.agenda.add(consulta);
        }
    }

    public List<Consulta> getAgenda(){
        return agenda;
    }

    public String getEspecialidade(){
        return especialidade;
    }

    /**
    * Verifica se o medico esta ativo no sistema.
    *
    * @return true se estiver ativo, false caso contrario
    */
    public boolean isAtivo(){
        return ativo;
    }
    
    /**
    * Desativa o medico no sistema.
    */
    public void desativar(){
        this.ativo = false;
    }

    /**
    * Ativa o medico no sistema.
    */
    public void ativar(){
        this.ativo=true;
    }

    /**
    * Retorna uma representacao em texto do medico.
    *
    * @return string com os dados do medico
    */
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