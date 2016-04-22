package unlv.erc.emergo.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import unlv.erc.emergo.R;
import unlv.erc.emergo.model.HospitalUnit;
import unlv.erc.emergo.model.User;

public class InformationUsScreen extends Activity {

    private TextView textNome2 , textEndereco2 , textGestao2 , textUf2 , textMunicipio2 ,
            textbairro2 , textCep2;
    private HospitalUnit hospital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_us_screen);
        textNome2 = (TextView) findViewById(R.id.nomeText2);
        textEndereco2 = (TextView) findViewById(R.id.enderecoText2);
        textGestao2 = (TextView) findViewById(R.id.gestaoText2);
        textUf2 = (TextView) findViewById(R.id.ufText2);
        textMunicipio2 = (TextView) findViewById(R.id.municipioText2);
        textbairro2 = (TextView) findViewById(R.id.bairroText2);
        textCep2 = (TextView) findViewById(R.id.cepText2);

        textNome2.setText(hospital.getNo_logradouro());
        textEndereco2.setText(hospital.getNu_endereco());
        textGestao2.setText(hospital.getTipo_gestao());
        textUf2.setText(hospital.getUf());
        textMunicipio2.setText(hospital.getMunicipio());
        textbairro2.setText(hospital.getNo_bairro());
        textCep2.setText(hospital.getCo_cep());
    }


    public void goClicked(View v) {
        Toast.makeText(this , "Go clicked" , Toast.LENGTH_SHORT).show();
    }
}
