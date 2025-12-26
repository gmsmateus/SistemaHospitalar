package ufjf.dcc025.hospital.usuarios.paciente;

import java.util.List;
import java.util.ArrayList;
import ufjf.dcc025.hospital.exception.DadosInvalidosException;
import ufjf.dcc025.hospital.usuarios.Usuario;



public class Paciente extends Usuario{

    //private List<Consulta> consultas;
    //private List<exame> exames; 
    
    private String telefone;
    private String endereco;
    private String historico;
    
    public Paciente(String nome, String cpf, String login, String senha, String historico, String endereco , String telefone) throws DadosInvalidosException{
        super(nome, cpf, login, senha);
        
        if(telefone == null || telefone.trim().isEmpty()){
            throw new DadosInvalidosException ("É obrigatório um número de telefone");
        }
        
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new DadosInvalidosException("Endereço é obrigatório.");
        }
                
        this.historico = historico;
        this.endereco = endereco;
        this.telefone = telefone;
   
        //this.consultas = new ArrayList<>();
        //this.exames = new ArrayList<>();
        
    }
    
    public String getHistorico(){ return historico; }
    
    public void setHistorico(String historico){
        this.historico = historico;
    }

    public String getTelefone(){ return telefone; }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getEndereco(){ return endereco; }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    @Override
    public String getTipo() {
        return "PACIENTE";
    }
    
    @Override
    public String toString(){
        return getTipo() +  ": " + nome + " CPF: "  + cpf;
    }
}
