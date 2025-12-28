package ufjf.dcc025.hospital.servicos_hospital;

import ufjf.dcc025.hospital.usuarios.médico.Medico;
import ufjf.dcc025.hospital.usuarios.paciente.Paciente;


public class Consulta {
    
    private String dia;
    private String horario;
    private String duracao;
    private Medico medicoResponsavel;
    private Paciente paciente;
    
    //private boolean marcada;
    
    public Consulta(String dia , String horario, String duracao, Medico medico, Paciente paciente){
         
        this.dia = dia;
        this.horario = horario;
        this.duracao = duracao;
        this.paciente = paciente;
        medicoResponsavel = medico;
        //marcada = true;
    }
    
    public String getDia(){ return dia; }
    
    public void alterarDia(String novoDia){
        dia = novoDia;
    }
    
    public String getHorario(){ return horario; }
    
    public void alterarHorario(String novoHorario){
        horario = novoHorario;
    }
    
    public String getDuracao(){ return duracao; }
    
    public void alterarDuracao(String novaDuracao){
        duracao = novaDuracao;
    }
    
    public Medico getMedicoResponsavel() { return medicoResponsavel; }
    
    public Paciente getPaciente(){ return paciente; }
    
    /*
    public void desmarcar(){
        marcada = false;
    }
    */
    
}
