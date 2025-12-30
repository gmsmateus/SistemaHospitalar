package ufjf.dcc025.hospital.usuarios.paciente;

import java.util.ArrayList;
//import java.util.Collections; necessário para retornar listas imutáveis
import java.util.List;
import ufjf.dcc025.hospital.servicos_hospital.Consulta;
import ufjf.dcc025.hospital.servicos_hospital.Exame;

public class Historico {
    
    private final List<Consulta> consultas;
    private final List<Exame> exames;
    
    public Historico(){
        this.consultas = new ArrayList<>();
        this.exames = new ArrayList<>();
    }
    
    /* Retornando lista imutavel
    public List<Consulta> getConsultas(){
        return Collections.unmodifiableList(this.consultas);   
    } */
    
    public void adicionaConsulta(Consulta consulta) {
        if (consulta != null) {
            this.consultas.add(consulta);
        }
    }
    
    public void adicionaExame(Exame exame) {
        if (exame != null) {
            this.exames.add(exame);
        }
    }
    
     public List<Consulta> getConsultas(){
        return new ArrayList<>(this.consultas);   
    }
    
    public List<Exame> getExames(){
        return new ArrayList<>(this.exames); 
    }
}