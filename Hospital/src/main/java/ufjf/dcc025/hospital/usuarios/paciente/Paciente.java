package ufjf.dcc025.hospital.usuarios.paciente;

import java.util.List;
import java.util.ArrayList;
import ufjf.dcc025.hospital.exception.DadosInvalidosException;
import ufjf.dcc025.hospital.servicos_hospital.Atestado;
import ufjf.dcc025.hospital.servicos_hospital.Consulta;
import ufjf.dcc025.hospital.usuarios.Usuario;
import ufjf.dcc025.hospital.servicos_hospital.Exame;
import ufjf.dcc025.hospital.servicos_hospital.Receita;



public class Paciente extends Usuario{

    private List<Atestado> atestados;
    private List<Consulta> consultas;
    private List<Exame> exames; 
    private List<Receita> receitas;
    
    
    private String telefone;
    private String endereco;
    private Historico historico;
    private StatusVisita status; // ainda não inicializado   (ex de inicialização status.APTO/INAPTO)

    public Paciente(String nome, String email, String senha, Historico historico, String endereco , String telefone) throws DadosInvalidosException{
        super(nome ,email, senha);
        
        if(telefone == null || telefone.trim().isEmpty()){
            throw new DadosInvalidosException ("É obrigatório um número de telefone");
        }
        
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new DadosInvalidosException("Endereço é obrigatório.");
        }
                
        this.historico = historico;
        this.endereco = endereco;
        this.telefone = telefone;
   
        this.consultas = new ArrayList<>();
        this.exames = new ArrayList<>();
        
    }
    
    public Historico getHistorico(){ return historico; }
    
    public void setHistorico(Historico historico){
        this.historico = historico;
    }

    public String getTelefone(){ return telefone; }
    
    public void setTelefone(String telefone) throws DadosInvalidosException{
        
        if(telefone == null || telefone.trim().isEmpty())
            throw new DadosInvalidosException("Número de telefone vazio");
        this.telefone = telefone;
    }
    
    public String getEndereco(){ return endereco; }
    
    public void setEndereco(String endereco) throws DadosInvalidosException{
        
        if(endereco == null || endereco.trim().isEmpty())
            throw new DadosInvalidosException("Endereço em branco!");
        
        this.endereco = endereco;
    }
    
    @Override
    public String getTipo() {
        return "PACIENTE";
    }
    
    @Override
    public String toString(){
        return getTipo() +  ": " + nome;
    }
}
