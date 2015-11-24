package br.com.manfredi.android.graficoscomgooglecharts.entity;

import java.io.Serializable;

/**
 * Created by MANFREDi on 22/11/2015.
 */
public class Grafico implements Serializable {

    Double taxaMetabolica;
    Double cafe;
    Double lancheManha;
    Double almoco;
    Double lancheTarde;
    Double jantar;
    Double lancheNoite;

    public Double getTaxaMetabolica() {
        return taxaMetabolica;
    }

    public void setTaxaMetabolica(Double taxaMetabolica) {
        this.taxaMetabolica = taxaMetabolica;
    }

    public Double getCafe() {
        return cafe;
    }

    public void setCafe(Double cafe) {
        this.cafe = cafe;
    }

    public Double getLancheManha() {
        return lancheManha;
    }

    public void setLancheManha(Double lancheManha) {
        this.lancheManha = lancheManha;
    }

    public Double getAlmoco() {
        return almoco;
    }

    public void setAlmoco(Double almoco) {
        this.almoco = almoco;
    }

    public Double getLancheTarde() {
        return lancheTarde;
    }

    public void setLancheTarde(Double lancheTarde) {
        this.lancheTarde = lancheTarde;
    }

    public Double getJantar() {
        return jantar;
    }

    public void setJantar(Double jantar) {
        this.jantar = jantar;
    }

    public Double getLancheNoite() {
        return lancheNoite;
    }

    public void setLancheNoite(Double lancheNoite) {
        this.lancheNoite = lancheNoite;
    }
}
