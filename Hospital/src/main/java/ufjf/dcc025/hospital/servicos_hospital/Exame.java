package ufjf.dcc025.hospital.servicos_hospital;

//import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import ufjf.dcc025.hospital.usuarios.medico.Medico;
import ufjf.dcc025.hospital.usuarios.paciente.Paciente;

/**
 * Representa um exame médico solicitado para um paciente
 */

public class Exame {
    
    private String tipoExame;
    private String resultado;

    private LocalDate data;
    private LocalTime horario;

    private Medico medico;
    private Paciente paciente;

    private boolean realizado;
    
    public Exame(String tipoExame, LocalDate data, LocalTime horario, Medico medico, Paciente paciente){
        
        this.data = data;
        this.horario = horario;
        this.medico = medico;
        this.paciente = paciente;
        this.tipoExame = tipoExame;
        
        this.resultado = "Aguardando Realização.";
        this.realizado = false;
    }
    
    //GETTERS//
    public String getTipoExame(){
        return tipoExame;
    }
    public String getResultado(){
        return resultado;
    }
    public LocalDate getData(){
        return data;
    }
    public LocalTime getHorario(){
        return horario;
    }
    public Medico getMedico(){
        return medico;
    }
    public Paciente getPaciente(){
        return paciente;
    }
    public boolean isRealizado(){
        return realizado;
    }

    /*
    *Registra o resultado do exame
    */
    public void setResultado(String resultado) {
        this.resultado = resultado;
        this.realizado = true;
    }
    
    @Override
    public String toString() {
        // Formata a data para o padrão brasileiro ao imprimir
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("""
            ========== LAUDO DE EXAME ==========
            PACIENTE: %s
            MÉDICO SOLICITANTE: %s
            EXAME: %s
            DATA: %s | HORÁRIO: %s
            ------------------------------------
            RESULTADO: %s
            =====================================""", 
            paciente.getNome(), medico.getNome(), tipoExame, 
            data.format(dtf), horario, resultado);
    }
    
}
