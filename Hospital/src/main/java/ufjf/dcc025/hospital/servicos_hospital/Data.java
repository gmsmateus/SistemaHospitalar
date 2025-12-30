package ufjf.dcc025.hospital.servicos_hospital;

import java.time.LocalDate;
import ufjf.dcc025.hospital.exception.DataInvalidaException;


public class Data {
    
    private int dia;
    private int mes;
    private int ano;
    
    public Data(String dataStr) throws DataInvalidaException{
        
        try{
            String[] partes = dataStr.split("/");
            datValida(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]), Integer.parseInt(partes[2]));
        } catch(Exception e){
            throw new DataInvalidaException("Formato invalido para data deve ser DD/MM/AAAA");
        }
    }
   
    private void datValida(int dia, int mes , int ano)throws DataInvalidaException{
        
        if (mes < 1 || mes > 12) {
            throw new DataInvalidaException("Mês " + mes + " é inválido.");
        }
        
        if (dia < 1 || dia > 31) { 
            throw new DataInvalidaException("Dia " + dia + " é inválido.");
        }
           
        int anoAtual = LocalDate.now().getYear();
        
        if(ano < anoAtual){
            throw new DataInvalidaException("Ano "+ ano + "é invalido.");
        }
        
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public int getDia() { return dia; }
    public int getMes() { return mes; }
    public int getAno() { return ano; }
    
    @Override
    public String toString(){
        return dia + "/" + mes + "/" + ano;
    }
}
