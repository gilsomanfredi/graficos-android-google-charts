package br.com.manfredi.android.graficoscomgooglecharts;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import br.com.manfredi.android.graficoscomgooglecharts.entity.Grafico;
import br.com.manfredi.android.graficoscomgooglecharts.entity.NivelAtividadeFisica;
import br.com.manfredi.android.graficoscomgooglecharts.entity.Sexo;

public class TaxaMetabolicaActivity extends AppCompatActivity {

    RadioButton rbFeminino;
    RadioButton rbMasculino;

    EditText etIdade;
    EditText etPeso;
    EditText etAltura;

    Spinner spinnerAtividadeFisica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxa_metabolica);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rbFeminino = (RadioButton) findViewById(R.id.rbFeminino);
        rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        etIdade = (EditText) findViewById(R.id.etIdade);
        etPeso = (EditText) findViewById(R.id.etPeso);
        etAltura = (EditText) findViewById(R.id.etAltura);
        spinnerAtividadeFisica = (Spinner) findViewById(R.id.spinner_atividade_fisica);

        spinnerAtividadeFisica.setAdapter(new ArrayAdapter<NivelAtividadeFisica>(
                this,
                android.R.layout.simple_list_item_1,
                NivelAtividadeFisica.values()));
    }

    public void btnProximoOnClick(View view) {

        try {

            Integer idade = getIdade();
            Double peso = getPeso();
            Integer altura = getAltura();
            Sexo sexo;
            NivelAtividadeFisica nivel = (NivelAtividadeFisica) spinnerAtividadeFisica.getSelectedItem();

            if (rbFeminino.isChecked()) {
                sexo = Sexo.FEMININO;
            } else {
                sexo = Sexo.MASCULINO;
            }

            Double taxaMetabolica = calculaTaxaMetabolica(idade, peso, altura, sexo, nivel);

            Grafico grafico = new Grafico();
            grafico.setTaxaMetabolica(taxaMetabolica);

            Intent intent = new Intent(this, CaloriasActivity.class);
            intent.putExtra("grafico", grafico);
            startActivity(intent);

        } catch (Exception e) {

            Snackbar.make(view, e.getMessage(), Snackbar.LENGTH_LONG).show();
        }

    }

    private Double calculaTaxaMetabolica(Integer idade, Double peso, Integer altura, Sexo sexo, NivelAtividadeFisica nivel) {

        Double tmb;

        if (sexo.equals(Sexo.FEMININO)) {

            tmb = (655 + (9.6D * peso) + (1.8D * altura) - (4.7D * idade)) * nivel.getFatorMultipliacao();

        } else {

            tmb = (66 + (13.7D * peso) + (5D * altura) - (6.8D * idade)) * nivel.getFatorMultipliacao();

        }

        return tmb;
    }

    private Integer getIdade() throws Exception {

        if (etIdade.getText().toString().trim().isEmpty()) {

            throw new Exception(getString(R.string.informe_idade));

        } else {

            try {

                int idade = Integer.parseInt(etIdade.getText().toString().trim());

                return idade;
            } catch (Exception e) {

                throw new Exception(getString(R.string.idade_invalida));
            }
        }

    }

    private Double getPeso() throws Exception {

        if (etPeso.getText().toString().trim().isEmpty()) {

            throw new Exception(getString(R.string.Informe_peso));

        } else {

            try {

                Double peso = Double.parseDouble(etPeso.getText().toString().trim());

                return peso;
            } catch (Exception e) {

                throw new Exception(getString(R.string.peso_invalido));
            }
        }

    }

    private Integer getAltura() throws Exception {

        if (etAltura.getText().toString().trim().isEmpty()) {

            throw new Exception(getString(R.string.informe_altura));

        } else {

            try {

                int altura = Integer.parseInt(etAltura.getText().toString().trim());

                return altura;
            } catch (Exception e) {

                throw new Exception(getString(R.string.altura_invalida));
            }
        }

    }

}
