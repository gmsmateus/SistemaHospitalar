package ufjf.dcc025.hospital.model;


public abstract class Usuario {
    
   protected String nome;
   protected String cpf;
   protected String login;
   protected String senha;
    
    
    public Usuario(String nome , String cpf, String login, String senha){
        
        this.nome = nome;
        this.cpf = cpf;
        this . login = login;
        this.senha = senha;
    } 
    
    public abstract String getTipo();
    
}
