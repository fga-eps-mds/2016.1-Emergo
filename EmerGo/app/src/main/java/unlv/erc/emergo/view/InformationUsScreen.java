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

    private TextView textNome2 , textGestao2 , textUf2 , textMunicipio2 ,
            textbairro2 , textCep2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_us_screen);
        textNome2 = (TextView) findViewById(R.id.nomeText2);

        textGestao2 = (TextView) findViewById(R.id.gestaoText2);
        textUf2 = (TextView) findViewById(R.id.ufText2);
        textMunicipio2 = (TextView) findViewById(R.id.municipioText2);
        textbairro2 = (TextView) findViewById(R.id.bairroText2);
        textCep2 = (TextView) findViewById(R.id.cepText2);

        textNome2.setText("");
        textGestao2.setText("");
        textUf2.setText("");
        textMunicipio2.setText("");
        textbairro2.setText("");
        textCep2.setText("");
    }


    public void goClicked(View v) {
        Toast.makeText(this , "Go clicked" , Toast.LENGTH_SHORT).show();
    }
}
