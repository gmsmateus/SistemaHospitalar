package ufjf.dcc025.hospital.usuarios.médico;

import ufjf.dcc025.hospital.usuarios.Usuario;
import ufjf.dcc025.hospital.exception.DadosInvalidosException;
/**
 *representa um medico do sistema do hospital
 *aqui é a implementação minima para uso pelo hospital
 * @author mjjun
 */
public class Medico extends Usuario{
    private Agenda agenda;
    public Medico(String nome, String cpf, String login, String senha) throws DadosInvalidosException {
        super(nome, cpf, login, senha);
    }
    public void definirAgenda(Agenda agenda){
        this.agenda = agenda;
    }

    public Agenda getAgenda(){
        return agenda;
    }

     @Override
    public String getTipo() {
        return "MEDICO";
    }
}
