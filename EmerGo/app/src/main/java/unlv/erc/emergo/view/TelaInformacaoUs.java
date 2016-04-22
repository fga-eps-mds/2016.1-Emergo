package unlv.erc.emergo.view;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import unlv.erc.emergo.R;

public class TelaInformacaoUs extends Activity {

    private Button goButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_informacao_us);

    }

    public void cliqueGo(){

        Toast.makeText(this, "Tracar rota" , Toast.LENGTH_SHORT).show();
    }
}
