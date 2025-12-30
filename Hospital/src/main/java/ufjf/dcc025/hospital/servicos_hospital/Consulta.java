package ufjf.dcc025.hospital.servicos_hospital;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import ufjf.dcc025.hospital.usuarios.médico.Medico;
import ufjf.dcc025.hospital.usuarios.paciente.Paciente;
/**
 *representa uma cosulta medica no hospital
 * @author mjjun
 */
public class Consulta {
    private Medico medico;
    private Paciente paciente;
    private LocalDateTime dataHora;
    private boolean realizada;
    //private boolean cancelada;

    public Consulta(Medico medico, Paciente paciente, LocalDateTime dataHora){
        this.medico = medico;
        this.paciente = paciente;
        this.dataHora = dataHora;
        this.realizada = false;
    }

    public Medico getMedico(){
        return medico;
    }

    public Paciente getPaciente(){
        return paciente;
    }

    public LocalDateTime getDataHora(){
        return dataHora;
    }

    public boolean isRealizada(){
        return realizada;
    }

    public void marcarConcluida(){
        this.realizada = true;
    }

    public void reagendar(LocalDate novaData, LocalTime novaHora){
        this.dataHora = LocalDateTime.of(novaData, novaHora);
    }

}
