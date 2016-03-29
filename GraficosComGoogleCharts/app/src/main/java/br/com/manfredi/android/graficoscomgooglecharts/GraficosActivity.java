package br.com.manfredi.android.graficoscomgooglecharts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import br.com.manfredi.android.graficoscomgooglecharts.entity.Grafico;
import br.com.manfredi.android.graficoscomgooglecharts.entity.Refeicoes;

public class GraficosActivity extends AppCompatActivity {

    WebView webView;

    Grafico grafico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficos);

        webView = (WebView) findViewById(R.id.web_view);
        webView.addJavascriptInterface(new WebAppInterface(), "android");
        webView.getSettings().setJavaScriptEnabled(true);

        grafico = (Grafico) getIntent().getSerializableExtra("grafico");

        btnBarrasOnClick(null);
    }

    public void btnVoltarOnClick(View view) {

        finish();
    }

    public void btnPizzaOnClick(View view) {

        webView.loadUrl("file:///android_asset/calorias_dia_pizza.html");
    }

    public void btnBarrasOnClick(View view) {

        webView.loadUrl("file:///android_asset/calorias_dia_barras.html");
    }

    public class WebAppInterface {

        @JavascriptInterface
        public String getTituloBrras() {
            return getString(R.string.grafico_barras);
        }

        @JavascriptInterface
        public String getTituloPizza() {
            return getString(R.string.grafico_pizza);
        }

        @JavascriptInterface
        public String getTituloRefeicao() {
            return getString(R.string.refeicao);
        }

        @JavascriptInterface
        public String getTituloCalorias() {
            return getString(R.string.calorias);
        }

        @JavascriptInterface
        public String getTituloConsumidas() {
            return getString(R.string.consumidas);
        }

        @JavascriptInterface
        public String getTituloNecessarias() {
            return getString(R.string.necessarias);
        }

        @JavascriptInterface
        public String getTituloCafe() {
            return getString(R.string.cafe_manha);
        }

        @JavascriptInterface
        public String getTituloLancheManha() {
            return getString(R.string.lanche_manha);
        }

        @JavascriptInterface
        public String getTituloAlmoco() {
            return getString(R.string.almoco);
        }

        @JavascriptInterface
        public String getTituloLancheTarde() {
            return getString(R.string.lanche_tarde);
        }

        @JavascriptInterface
        public String getTituloJantar() {
            return getString(R.string.jantar);
        }

        @JavascriptInterface
        public String getTituloLancheNoite() {
            return getString(R.string.lanche_noite);
        }

        @JavascriptInterface
        public double getConsumidoCafe() {
            return grafico.getCafe();
        }

        @JavascriptInterface
        public double getConsumidoLancheManha() {
            return grafico.getLancheManha();
        }

        @JavascriptInterface
        public double getConsumidoAlmoco() {
            return grafico.getAlmoco();
        }

        @JavascriptInterface
        public double getConsumidoLancheTarde() {
            return grafico.getLancheTarde();
        }

        @JavascriptInterface
        public double getConsumidoJantar() {
            return grafico.getJantar();
        }

        @JavascriptInterface
        public double getConsumidoLancheNoite() {
            return grafico.getLancheNoite();
        }

        @JavascriptInterface
        public double getNecessarioCafe() {
            return getCaloriasNecessarias(Refeicoes.CAFE_DA_MANHA);
        }

        @JavascriptInterface
        public double getNecessarioLancheManha() {
            return getCaloriasNecessarias(Refeicoes.LANCHE_DA_MANHA);
        }

        @JavascriptInterface
        public double getNecessarioAlmoco() {
            return getCaloriasNecessarias(Refeicoes.ALMOCO);
        }

        @JavascriptInterface
        public double getNecessarioLancheTarde() {
            return getCaloriasNecessarias(Refeicoes.LANCHE_DA_TARDE);
        }

        @JavascriptInterface
        public double getNecessarioJantar() {
            return getCaloriasNecessarias(Refeicoes.JANTAR);
        }

        @JavascriptInterface
        public double getNecessarioLancheNoite() {
            return getCaloriasNecessarias(Refeicoes.LANCHE_DA_NOITE);
        }

        private double getCaloriasNecessarias(Refeicoes refeicao) {
            return grafico.getTaxaMetabolica() * refeicao.getPercentualCalorias() / 100D;
        }

    }

}
