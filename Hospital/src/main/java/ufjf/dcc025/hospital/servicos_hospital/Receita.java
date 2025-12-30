package ufjf.dcc025.hospital.servicos_hospital;

import ufjf.dcc025.hospital.exception.DataInvalidaException;
import ufjf.dcc025.hospital.usuarios.médico.Medico;
import ufjf.dcc025.hospital.usuarios.paciente.Paciente;

public class Receita {
    
    private Data validade;
    private Data dataEmissao;
    
    private String medicamento;
    private String quantidade;
    private Paciente paciente;
    private Medico medico;
    
    public Receita(String medicamento , String quantidade , Paciente paciente , Medico medico , String dataEmissao , String validade) throws DataInvalidaException{
        
        this.medicamento = medicamento;
        this.quantidade = quantidade;
        this.paciente = paciente;
        this.medico = medico;
        this.dataEmissao = new Data(dataEmissao);
        this.validade = new Data(validade);
        
    }
    
    public String getMedicamento() { return medicamento; }
    public Data getDataEmissao() { return dataEmissao; }
    public Data getValidade() { return validade; }
    
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
