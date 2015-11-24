package br.com.manfredi.android.graficoscomgooglecharts.entity;

/**
 * Created by MANFREDi on 22/11/2015.
 */
public enum NivelAtividadeFisica {

    SEDENTARIO("Pouco ou nenhum", 1.2D),

    LEVEMENTE_ATIVO("De 1 a 3 dias por semana", 1.375D),

    MODERADAMENTE_ATIVO("De 3 a 5 dias por semana", 1.65D),

    ALTAMENTE_ATIVO("De 6 a 7 dias por semana", 1.725D),

    EXTREMAMENTE_ATIVO("Diariamente uma ou mais vezes por dia", 1.9D);

    String descricao;
    Double fatorMultipliacao;

    private NivelAtividadeFisica(String descricao, Double fatorMultipliacao) {
        this.descricao = descricao;
        this.fatorMultipliacao = fatorMultipliacao;
    }

    public Double getFatorMultipliacao() {
        return fatorMultipliacao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
