/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufjf.dcc025.hospital.model;

/**
 *
 * @author mjjun
 */
//fiz aqui so pra ter o que vou usar no medico na parte de monitoramento
public class Consulta {
    private boolean compareceu;

    public Consulta(){
        this.compareceu = true; //vou considerar por padrão que o paciente foi
    }

    public boolean isCompareceu(){
        return compareceu;
    }

    public void registrarFalta(){
        this.compareceu = false;
    }
}
