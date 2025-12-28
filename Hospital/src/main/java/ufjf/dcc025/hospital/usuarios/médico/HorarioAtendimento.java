package ufjf.dcc025.hospital.usuarios.médico;
/**
 * Representa um horario de atendimento do medico.
 */

public class HorarioAtendimento {
    private String diaSemana;
    private String horaInicio;
    private String horaFim;
    private int tempoConsulta; //tempo em minutos

    public HorarioAtendimento(String diaSemana, String horaInicio, String horaFim, int tempoConsulta){
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.tempoConsulta = tempoConsulta;
    }

    public String getDiaSemana(){
        return diaSemana;
    }

    public String getHoraInicio(){
        return horaInicio;
    }

    public String getHoraFim(){
        return horaFim;
    }

    public int getTempoConsulta(){
        return tempoConsulta;
    }

    @Override
    public String toString(){
        return diaSemana + " - " + horaInicio + " às " + horaFim + " (Tempo de consulta: " + tempoConsulta + " minutos)";
    }
}
