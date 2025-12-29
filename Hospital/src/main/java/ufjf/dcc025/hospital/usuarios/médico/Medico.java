/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufjf.dcc025.hospital.usuarios.médico;

import ufjf.dcc025.hospital.usuarios.Usuario;
import ufjf.dcc025.hospital.exception.DadosInvalidosException;

/**
 *representa um medico do sistema do hospital
 *aqui é a implementação minima para uso pelo hospital
 * @author mjjun
 */
public class Medico extends Usuario{
    public Medico(String nome, String cpf, String login, String senha) throws DadosInvalidosException {
        super(nome, cpf, login, senha);
    }

     @Override
    public String getTipo() {
        return "MEDICO";
    }
}
