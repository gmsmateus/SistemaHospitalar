package ufjf.dcc025.hospital.model;

/**
 *
 * @author mjjun
 */

///herança da classe usuario, ja que o medico também é um usuario do sistema
public class Medico extends Usuario{
    private String especialidade;
    private boolean ativo;

    ///construtor do medico
    public Medico(String nome, String cpf, String especialidade){
        super(nome, cpf);
        this.especialidade = especialidade;
        this.ativo = true;
    }

    public String getEspecialidade(){
        return especialidade;
    }

    public boolean isAtivo(){
        return ativo;
    }
    
    public void desativar(){
        this.ativo = false;
    }

    public void ativar(){
        this.ativo=true;
    }
}

