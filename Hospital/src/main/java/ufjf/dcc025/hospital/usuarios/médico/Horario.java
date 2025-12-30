package ufjf.dcc025.hospital.usuarios.médico;


public class Horario {
    
    private int hora; 
    private int minuto;
    
    public Horario(String horarioStr){
        String[] partes = horarioStr.split(":");
     
        ehHorarioValido(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]));
    }
    
    private void ehHorarioValido(int hora, int minuto){
        if((hora >=0 && hora <= 23) && (minuto >= 0 && minuto <= 59)){
            this .hora = hora;
            this.minuto = minuto;
        }
        // Lança execao de horario invalido
    }
    
    public int converteEmMinutos(){
        return (hora * 60) + minuto;
    }
    
    @Override
    public String toString(){
        return "Horario: " + hora + ":" +minuto;
    }
}
