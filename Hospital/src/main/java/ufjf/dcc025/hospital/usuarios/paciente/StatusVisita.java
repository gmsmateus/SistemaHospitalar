package ufjf.dcc025.hospital.usuarios.paciente;

public enum StatusVisita {
    
    APTO("O pasciente esta liberado para fazer/ receber visitas"),
    INAPTO("O pasciente não eta podendo fazer/receber visitas ");
    
    private final String descricao;
    
    StatusVisita(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
