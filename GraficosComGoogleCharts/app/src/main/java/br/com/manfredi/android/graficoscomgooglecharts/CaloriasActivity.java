package br.com.manfredi.android.graficoscomgooglecharts;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import br.com.manfredi.android.graficoscomgooglecharts.entity.Grafico;

public class CaloriasActivity extends AppCompatActivity {

    EditText etCafe;
    EditText etLancheManha;
    EditText etAlmoco;
    EditText etLancheTarde;
    EditText etJantar;
    EditText etLancheNoite;

    Grafico grafico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorias);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etCafe = (EditText) findViewById(R.id.etCafe);
        etLancheManha = (EditText) findViewById(R.id.etLancheManha);
        etAlmoco = (EditText) findViewById(R.id.etAlmoco);
        etLancheTarde = (EditText) findViewById(R.id.etLancheTarde);
        etJantar = (EditText) findViewById(R.id.etJantar);
        etLancheNoite = (EditText) findViewById(R.id.etLancheNoite);

        grafico = (Grafico) getIntent().getSerializableExtra("grafico");
    }

    public void btnGraficoOnClick(View view) {

        try {

            Double cafe = getCalorias(etCafe, getString(R.string.cafe_manha));
            Double lancheManha = getCalorias(etLancheManha, getString(R.string.lanche_manha));
            Double almoco = getCalorias(etAlmoco, getString(R.string.almoco));
            Double lancheTarde = getCalorias(etLancheTarde, getString(R.string.lanche_tarde));
            Double jantar = getCalorias(etJantar, getString(R.string.jantar));
            Double lancheNoite = getCalorias(etLancheNoite, getString(R.string.lanche_noite));

            grafico.setCafe(cafe);
            grafico.setLancheManha(lancheManha);
            grafico.setAlmoco(almoco);
            grafico.setLancheTarde(lancheTarde);
            grafico.setJantar(jantar);
            grafico.setLancheNoite(lancheNoite);

            Intent intent = new Intent(this, GraficosActivity.class);
            intent.putExtra("grafico", grafico);
            startActivity(intent);

        } catch (Exception e) {

            Snackbar.make(view, e.getMessage(), Snackbar.LENGTH_LONG).show();
        }

    }

    private Double getCalorias(EditText etCafe, String refeicao) throws Exception{

        Double calorias = 0D;

        if (!etCafe.getText().toString().trim().isEmpty()) {

            try {

                calorias = Double.parseDouble(etCafe.getText().toString().trim());
            } catch (Exception e) {

                throw new Exception(getString(R.string.caloria_invalida_refeicao) + refeicao);
            }
        }

        return calorias;
    }

}
