package ufjf.dcc025.hospital.model;
import java.util.List;
import java.util.ArrayList;
/**
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

    //horarios de atendimento definidos pelo medico
    private List<HorarioAtendimento> horariosAtendimento;

    //lista de historico clinico dos pacientes atendidos
    private List<HistoricoClinico> historicos;

    /**
    * Cria um medico com nome, CPF e especialidade.
    * @param nome nome do medico
    * @param cpf cpf do medico
    * @param especialidade especialidade medica
    */
    public Medico(String nome, String cpf, String especialidade){
        super(nome, cpf);
        if(especialidade == null || especialidade.isBlank()){
            throw new IllegalArgumentException("A especialidade do medico não pode ser vazia");
        }
        this.especialidade = especialidade;
        this.ativo = true;
        this.agenda = new ArrayList<>();
        this.historicos = new ArrayList<>();
        this.horariosAtendimento = new ArrayList<>();
    }

    /**
    * Adiciona uma consulta a agenda do medico.
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

    /**
    * Retorna a lista de consultas do medico.
    * @return lista de consultas
    */
    public List<Consulta> getAgenda(){
        return new ArrayList<>(agenda);
    }

    /**
     * retorna todos os historicos clinicos dos pacientes
     * @return lista de historicos
     */
    public List<HistoricoClinico> getHistoricos(){
        return new ArrayList<>(historicos);
    }
    /**
     * retorna a quantidade de consultas na agenda do medico
     * @return numero de consultas
     */
    public int quantidadeConsultas(){
        return agenda.size();
    }

    /**
     * verifica o medico possui uma consulta especifica
     * @param consulta a consulta a ser verificada
     * @return verdade se a consulta exisir, falso caso contrario
     */

    public boolean possuiConsulta(Consulta consulta){
        return agenda.contains(consulta);
    }


    /**
     * remove uma consulta da agenda do medico
     * @param consulta a consulta a ser removida
    */
    public void removerConsulta(Consulta consulta){
        if(!ativo){
            throw new IllegalStateException("Medico está inativo, então não pode remover consultas.");
        }
        agenda.remove(consulta);
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

    /**
     * Emite um atestado medico para um paciente 
     *  @param paciente nome do paciente
     *  @param descricao descricao do atestado
     *  @return string que representa o atestado 
     */    
    public String emitirAtestado(String paciente, String descricao){
        return "Atestado Médico\nPaciente:" + paciente + "\nDescrição: " + descricao + "\nMedico: " + nome;
    }

     /**
      * Prescreve uma receita medica para um paciente 
      * @param paciente nome do paciente
      * @param medicamentos lista de medicamentos 
      * @return String representando a receita
      */
     public String preescreverReceitaString(String paciente, List<String> medicamentos){
        return "Receita Médica\nPaciente: " + paciente + "\nMedicamentos: " + String.join(", ", medicamentos) + "\nMedico: " + nome;
     }

     /**
      * Define um horario de atendimento do medico
      * @param horario horario de atendimento
      */
     public void adicionarHorarioAtendimento(HorarioAtendimento horario){
        horariosAtendimento.add(horario);
     }

     /**
      * retorna os horarios de atendimento do medico
      * @return lita de horarios
      */
     public List<HorarioAtendimento> getHorariosAtendimento(){
        return new ArrayList<>(horariosAtendimento);
     }

     /**
      * registra a falta de um paciente em uma consulta
      * @param consulta consulta em que o paciente faltou
      */
     public void registrarFaltaPaciente(Consulta consulta){
        if(!agenda.contains(consulta)){
            throw new IllegalArgumentException("Consulta não pertence à agenda do médico!");
        }
        consulta.registrarFalta();
     }

     /**
      * retorna as consultas em que o paciente faltou
      * @return lista de consultas com faltas
      */
     public List<Consulta> getConsultasComFaltas(){
        List<Consulta> faltas = new ArrayList<>();
        for(int i=0; i < agenda.size(); i++){
            Consulta consulta = agenda.get(i);
            if(!consulta.isCompareceu()){
                faltas.add(consulta);
            }
        }
        return faltas;
     }
  
}   