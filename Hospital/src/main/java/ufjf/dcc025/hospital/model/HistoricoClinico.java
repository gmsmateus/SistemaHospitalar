package ufjf.dcc025.hospital.model;

/**
 * Representa um registro do historico clinico de um paciente.
 */

public class HistoricoClinico {
    private String descricao;
    private String data;

    public HistoricoClinico(String descricao, String data){
        this.descricao = descricao;
        this.data = data;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getData(){
        return data;
    }

    @Override
     public String toString() {
        return "HistoricoClinico{" +
               "descricao='" + descricao + '\'' +
               ", data='" + data + '\'' +
               '}';
    }
}
