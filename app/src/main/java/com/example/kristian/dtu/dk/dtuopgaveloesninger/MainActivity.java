package com.example.kristian.dtu.dk.dtuopgaveloesninger;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

ArrayList<String> namesList = new ArrayList<String>();

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(myHandler);

        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(myHandler);

        Button btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(myHandler);
    }

    View.OnClickListener myHandler = new View.OnClickListener() {
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btn1:
                    setContentView(R.layout.assignment_one);
                    Button add = (Button) findViewById(R.id.btnAdd);
                    Button check = (Button) findViewById(R.id.btnOel);
                    add.setOnClickListener(myHandler);
                    check.setOnClickListener(myHandler);
                    break;
                case R.id.btn2:
                    setContentView(R.layout.assignment_two);
                    Button btnGo = (Button) findViewById(R.id.btnGo);
                    btnGo.setOnClickListener(myHandler);
                    break;
                case R.id.btn3:
                    Intent funShitOnly = new Intent(context, FunShitActivity.class);
                    startActivity(funShitOnly);
                    break;
                case R.id.btnAdd:
                    EditText name = (EditText) findViewById(R.id.txtName);
                    namesList.add(name.getText().toString());
                    TextView amountOfNames = (TextView) findViewById(R.id.txtV_namesList);
                    amountOfNames.setText("antal navne: "+namesList.size());
                    name.setText("");
                    break;
                case R.id.btnOel:
                    Random rand = new Random();
                    TextView winnerName = (TextView) findViewById(R.id.txtV_vinder);
                    // nextInt is normally exclusive of the top value,
                    // so add 1 to make it inclusive
                    if(namesList.size() < 1){winnerName.setText("Vinder: Ingen navne ingen vinder"); break;}
                    int randomNum = rand.nextInt((namesList.size() - 0));
                    winnerName.setText("Vinder: "+namesList.get(randomNum));
                    break;
                case R.id.btnGo:
                    Intent webBrowser = new Intent(context, WebViewActivity.class);
                    startActivity(webBrowser);
                    break;
            }
        }
    };
}
