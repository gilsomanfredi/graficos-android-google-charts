package br.com.manfredi.android.graficoscomgooglecharts.entity;

/**
 * Created by MANFREDi on 22/11/2015.
 */
public enum Refeicoes {

    CAFE_DA_MANHA(25D),

    LANCHE_DA_MANHA(5D),

    ALMOCO(35D),

    LANCHE_DA_TARDE(5D),

    JANTAR(25D),

    LANCHE_DA_NOITE(5D);

    Double percentualCalorias;

    private Refeicoes(Double percentualCalorias) {
        this.percentualCalorias = percentualCalorias;
    }

    public static Refeicoes getValue(Integer ordinal) {

        if (ordinal == null || ordinal < 0 || ordinal >= Refeicoes.values().length) {
            return null;
        }
        return Refeicoes.values()[ordinal];

    }

    public Double getPercentualCalorias() {
        return percentualCalorias;
    }

}
