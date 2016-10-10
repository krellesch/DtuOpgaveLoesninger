package com.example.kristian.dtu.dk.dtuopgaveloesninger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Kristian on 03-10-2016.
 */

public class WebViewActivity extends Activity {

    private WebView webView;
    final Context context = this;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignment_two);

        Button btnGo = (Button) findViewById(R.id.btnGo);
        btnGo.setOnClickListener(myHandler);
        /*here could have checked for string and edit'ed if
        missing http://, but this is more fun.
         */

        EditText name = (EditText) findViewById(R.id.txtToGo);
        Toast.makeText(this, "Du ville gerne ha' gået til: " + name.getText(), Toast.LENGTH_LONG).show();
        webView = (WebView) findViewById(R.id.webV_go);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://javabog.dk");
        name.setText("");
    }

    View.OnClickListener myHandler = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnGo:
                    Intent intente = new Intent(context, WebViewActivity.class);
                    startActivity(intente);
                    break;
            }
        }
    };

}
