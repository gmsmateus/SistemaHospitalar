package ufjf.dcc025.hospital.usuarios;

import ufjf.dcc025.hospital.exception.DadosInvalidosException;


public abstract class Usuario {
    
   protected String email;
   protected String senha;
   protected String nome;
    
    
    public Usuario(String nome, String email, String senha) throws DadosInvalidosException {
        
        validarCamposBasicos(nome,email, senha);
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    } 
    
    private void validarCamposBasicos(String nome, String email, String senha) throws DadosInvalidosException{
        
        if (nome  == null || nome.isEmpty()) throw new DadosInvalidosException("Nome não informado");
        if (email == null || email.isEmpty()) throw new DadosInvalidosException("E-mail inválido");
        if (senha == null || senha.isEmpty()) throw new DadosInvalidosException("Senha inválido");
    }
    
    public abstract String getTipo();
 
    public String getNome(){ return nome; }
    
    public void setNome(String nome)throws DadosInvalidosException{
        if(nome == null || nome.trim().isEmpty())
            throw new DadosInvalidosException("Nome não informado");
        
        this.nome = nome;
    }
    
    public String getEmail(){ return email; }
    
    public void setEmail(String email)throws DadosInvalidosException{
        if(email == null || email.trim().isEmpty())
            throw new DadosInvalidosException("E-mail inválido");
        
        this.email = email;
    }
        
    public void setSenha(String senha)throws DadosInvalidosException{
        if (senha == null || senha.trim().isEmpty())
            throw new DadosInvalidosException("Senha inválida");
        
        this.senha = senha;
    }
    
    public boolean validarSenha(String senhaDigitada){
        return this.senha.equals(senhaDigitada);
    }
}
