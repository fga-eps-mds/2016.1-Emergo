package unlv.erc.emergo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import unlv.erc.emergo.view.TelaInformacaoUs;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cliqueGo(View activity_main){
        Toast.makeText(this , "GO" , Toast.LENGTH_SHORT).show();
        //implementar método liga e traca rota
    }
    public void cliqueEstouBem(View activity_main){
        Toast.makeText(this , "ESTOU BEM" , Toast.LENGTH_SHORT).show();
        //implementar método mostrar mapa

    }
}
