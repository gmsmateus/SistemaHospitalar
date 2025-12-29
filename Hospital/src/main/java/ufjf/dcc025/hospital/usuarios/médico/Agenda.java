package ufjf.dcc025.hospital.usuarios.médico;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Agenda {
    private DayOfWeek dia;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private int duracaoConsultas; //em minutos
    
    public Agenda(DayOfWeek dia, LocalTime inicio, LocalTime fim, int duracaoConsulta){
        this.dia = dia;
        this.horaInicio = inicio;
        this.horaFim = fim;
        this.duracaoConsultas = duracaoConsulta;
    }

    public DayOfWeek getDia(){
        return dia;
    }
    public LocalTime getHoraInicio(){
        return horaInicio;
    }
    public LocalTime getHoraFim(){
        return horaFim;
    }
    public int getDuracaoConsultas(){
        return duracaoConsultas;
    }
}
