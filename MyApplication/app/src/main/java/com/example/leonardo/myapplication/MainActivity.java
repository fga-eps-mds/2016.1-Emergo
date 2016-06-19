package com.example.leonardo.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contato> contatos = new ArrayList<Contato>();
    private Contato contato;
    private TextView nomeFixo, digitaNome , numeroFixo, digitaNumero;
    private Button botaoSalva , botaoMostra;
    private final String NOMEFIXO = "Digite o seu nome abaixo",
                        NUMEROFIXO = "Digite seu numero abaixo" ,
                        TITULOBOTAOSALVA = "Salvar dados" ,
                        TITULOBOTAOMOSTRA = "Mostrar pessoas salvas";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_de_dados);

        nomeFixo = (TextView) findViewById(R.id.nomeFixo);
        nomeFixo.setText(NOMEFIXO);

        digitaNome = (TextView) findViewById(R.id.digitaNome);

        numeroFixo = (TextView) findViewById(R.id.numeroFixo);
        numeroFixo.setText(NUMEROFIXO);

        digitaNumero = (TextView) findViewById(R.id.digitaNumero);

        botaoSalva = (Button) findViewById(R.id.botaoSalva);
        botaoSalva.setText(TITULOBOTAOSALVA);

        botaoMostra = (Button) findViewById(R.id.botaoMostra);
        botaoMostra.setText(TITULOBOTAOMOSTRA);


    }

    public void cliqueiPraSalvar(View view){
        contato = new Contato( (String) digitaNome.getText() ,
                       (String) digitaNumero.getText());
        Log.i("nome", "nome");
        Log.i("nome", contato.getNome());
        Log.i("numero" , contato.getNumero());


        Toast.makeText(this , "Dados salvos" , Toast.LENGTH_SHORT).show();

    }

    public void cliqueiPraMostrar(View view){

        Toast.makeText(this, "Dados mostrados", Toast.LENGTH_SHORT).show();
    }



    public TextView getNomeFixo() {
        return nomeFixo;
    }

    public void setNomeFixo(TextView nomeFixo) {
        this.nomeFixo = nomeFixo;
    }

    public TextView getDigitaNome() {
        return digitaNome;
    }

    public void setDigitaNome(TextView digitaNome) {
        this.digitaNome = digitaNome;
    }

    public TextView getNumeroFixo() {
        return numeroFixo;
    }

    public void setNumeroFixo(TextView numeroFixo) {
        this.numeroFixo = numeroFixo;
    }

    public TextView getDigitaNumero() {
        return digitaNumero;
    }

    public void setDigitaNumero(TextView digitaNumero) {
        this.digitaNumero = digitaNumero;
    }

    public Button getBotaoSalva() {
        return botaoSalva;
    }

    public void setBotaoSalva(Button botaoSalva) {
        this.botaoSalva = botaoSalva;
    }
}
