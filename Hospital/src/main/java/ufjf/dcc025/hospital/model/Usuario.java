package ufjf.dcc025.hospital.model;

/**
 *
 * @author mjjun
 */

//classe base para os usuarios do sistema

public class Usuario {
    protected String nome;
    protected String cpf;

    public Usuario(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }
}
