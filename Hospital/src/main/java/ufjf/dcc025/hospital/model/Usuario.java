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
    
    public String getNome(){ return nome; }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getCpf(){ return cpf; }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
 
    public String getLogin(){ return login; }
    
    public void setLogin(String login){
        this.login = login;
    }
        
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public boolean validarSenha(String senhaDigitada){
        return this.senha.equals(senhaDigitada);
    }

    
}
