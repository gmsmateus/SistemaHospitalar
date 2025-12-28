package ufjf.dcc025.hospital.servicos_hospital;

import ufjf.dcc025.hospital.usuarios.médico.Medico;
import ufjf.dcc025.hospital.usuarios.paciente.Paciente;

public class Atestado {
    
    private String mensagem;
    private String data;
    private String duracao;
    private Paciente pacienteAlvo;
    private Medico medicoResponsavel;
    
    private boolean emitido;
    
    
    public Atestado(Medico medico, Paciente paciente , String mensagem ,String data ,String duracao){
            
        medicoResponsavel = medico;
        pacienteAlvo = paciente;
        this.mensagem = mensagem;
        this.data = data;
        this.duracao = duracao;
    }
    
    public void alterarMensagem(String novaMensagem){
        if(!emitido)
            mensagem = novaMensagem;
    }
    
    public  void emitir(){
        emitido = true;
    }
}
