package ufjf.dcc025.hospital.usuarios;

import ufjf.dcc025.hospital.exception.DadosInvalidosException;


public abstract class Usuario {
    
   protected String nome;
   protected String cpf;
   protected String login;
   protected String senha;
    
    
    public Usuario(String nome , String cpf, String login, String senha) throws DadosInvalidosException {
        
        validarCamposBasicos(nome, cpf, login, senha);
        this.nome = nome;
        this.cpf = cpf;
        this . login = login;
        this.senha = senha;
    } 
    
    private void validarCamposBasicos(String nome, String cpf, String login, String senha) throws DadosInvalidosException{
        
        if (nome == null || nome.isEmpty()) throw new DadosInvalidosException("Nome inválido");
        if (cpf == null || cpf.length() != 11) throw new DadosInvalidosException("CPF deve ter 11 dígitos");
        if (login == null || login.isEmpty()) throw new DadosInvalidosException("Login inválido");
        if (senha == null || senha.isEmpty()) throw new DadosInvalidosException("Senha inválido");
    }
    
    public abstract String getTipo();
    
    public String getNome(){ return nome; }
    
    public void setNome(String nome)throws DadosInvalidosException{
        if(nome == null || nome.trim().isEmpty())
            throw new DadosInvalidosException("Nome inválido");
        
        this.nome = nome;
    }
    
    public String getCpf(){ return cpf; }
    
    public void setCpf(String cpf) throws DadosInvalidosException{
        if (cpf == null || cpf.length() != 11) 
            throw new DadosInvalidosException("CPF deve conter 11 dígitos numéricos");
         
        this.cpf = cpf;
    }
 
    public String getLogin(){ return login; }
    
    public void setLogin(String login)throws DadosInvalidosException{
        if(login == null || login.trim().isEmpty())
            throw new DadosInvalidosException("Login inválido");
        
        this.login = login;
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
