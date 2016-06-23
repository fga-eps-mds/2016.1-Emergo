package unlv.erc.emergo.controller;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import unlv.erc.emergo.R;

public class AboutApp extends Activity {

    private TextView informationAboutApp;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_app);
        String message= "\tEmerGo é um aplicativo que oferece a facilidade de " +
                "encontrar Unidades de Saúde mais próximas. Possui MODO EMERGÊNCIA, " +
                "que traça a rota para uma Unidade de Saúde mais próxima, " +
                "ligar para o SAMU, e envia uma mensagem pré definida com pedido de ajuda para " +
                "os contatos de emergência salvos!" +
                "\n\n\tTodas as funcionalidades em suas mãos, em apenas um aplicativo.";

        informationAboutApp = (TextView) findViewById(R.id.aboutApp);
        informationAboutApp.setText(message);

    }

}
