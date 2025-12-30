package ufjf.dcc025.hospital.servicos_hospital;

import java.time.LocalDate;
import ufjf.dcc025.hospital.usuarios.medico.Medico;
import ufjf.dcc025.hospital.usuarios.paciente.Paciente;

public class Receita {
    
    private LocalDate validade;
    private LocalDate dataEmissao;
    
    private String medicamento;
    private String quantidade;
    private Paciente paciente;
    private Medico medico;
    
    public Receita(String medicamento , String quantidade , Paciente paciente , Medico medico , LocalDate dataEmissao , LocalDate validade){
        
        this.medicamento = medicamento;
        this.quantidade = quantidade;
        this.paciente = paciente;
        this.medico = medico;
        this.dataEmissao = dataEmissao;
        this.validade = validade;
        
    }
    
    public String getMedicamento() { return medicamento; }
    
    
    @Override
    public String toString() {
    return """
           ==========================================
                        RECEITA MÉDICA               
           ==========================================
           MÉDICO: """ + medico.getNome() + "\n" +
           "PACIENTE: " + paciente.getNome() + "\n" +
           "------------------------------------------\n" +
           "MEDICAMENTO: " + medicamento + "\n" +
           "QUANTIDADE: " + quantidade + "\n" +
           "------------------------------------------\n" +
           "DATA DE EMISSÃO: " + dataEmissao + "\n" +
           "VALIDADE: " + validade + "\n" +
           "==========================================";
    }
}
