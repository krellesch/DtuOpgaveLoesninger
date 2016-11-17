package com.example.kristian.dtu.dk.dtuopgaveloesninger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Kristian on 04-10-2016.
 */

public class FunShitActivity extends Activity {
    final Context context = this;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fun_shit_only);
        Button btnlogin = (Button) findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(myHandler);
    }

    View.OnClickListener myHandler = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnLogin:
                    // this need to be done properly, maybe an encryptet file. Or just implement and sql With
                    // table allready filled.
                    EditText pass = (EditText) findViewById(R.id.txtPass);
                    if(pass.getText().toString().equalsIgnoreCase("fisse")){
                        Intent monkey = new Intent(context, MonkeyExpandableList.class);
                        startActivity(monkey);
                    }
                    Intent youtube = new Intent(context, YoutubeActivity.class);
                    startActivity(youtube);
                    break;
            }
        }
    };


}
