package ufjf.dcc025.hospital.usuarios.médico;

import java.util.ArrayList;
import java.util.List;
import ufjf.dcc025.hospital.servicos_hospital.Consulta;

public class Agenda {
    
    private List<Consulta> consultas;
    private DiaSemana dia;
    private String horarioInicial;
    private String horarioFinal;
    private int duracao;
    private int vagas;
    
    
    //int numConsultas;
    
    public Agenda(DiaSemana dia, String horarioInicial , String horarioFinal, int duracao ){
        consultas = new ArrayList<>();
        this.dia = dia;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.duracao = duracao;
        
        vagas = calculaPeriodoAtendimento(horarioInicial, horarioFinal, duracao);
    }
    
    private int calculaPeriodoAtendimento(String horarioInicial, String HorarioFinal, int duracao){
        
        Horario inicio = new Horario(horarioInicial);
        Horario fim = new Horario(HorarioFinal);

        return (fim.converteEmMinutos() - inicio.converteEmMinutos()) / duracao;
    }
    
    public boolean agendar(Consulta novaConsulta){
        if(consultas.size() < vagas){
            consultas.add(novaConsulta);
            //notificar medico da a nova consulta agendada
            return true;
        }
        return false; // agenda cheia
    }
    
    public void alterarTurno(String novoInicio, String novoFim) {
    this.horarioInicial = novoInicio;
    this.horarioFinal = novoFim;
    
    // Recalcula as vagas com base nos novos horários
    this.vagas = calculaPeriodoAtendimento(this.horarioInicial, this.horarioFinal, this.duracao);
    // avisar o medico da alteracao na agenda 
}
    
    
    public List<Consulta> getConsultas() { return consultas; }
    public int getVagasDisponiveis() { return vagas - consultas.size(); }
    public DiaSemana getDia() { return dia; }
    
    public void setDuracao(int novaDuracao){
        if(duracao >= 1){
            duracao = novaDuracao;
            vagas = calculaPeriodoAtendimento(horarioInicial, horarioFinal, duracao);
            // informar o medico das mudancas
        }
    } 
}
