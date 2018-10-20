package id.revolt.basic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;

public class login extends AppCompatActivity {

    @BindView(R.id.btn_cancel) Button cancel;
    @BindView(R.id.btn_ok) Button oke;
    @BindView(R.id.txt_password) TextView pswd;

    private View.OnClickListener cancel1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            login.this.setResult(0, new Intent());
            login.this.finish();
        }
    };

    private View.OnClickListener oke1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setData(Uri.parse(login.this.pswd.getText().toString()));
            Toast.makeText(login.this, login.this.pswd.getText().toString(), Toast.LENGTH_SHORT).show();
            login.this.setResult(-1, intent);
            login.this.finish();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.oke = (Button) findViewById(R.id.btn_ok);
        this.cancel = (Button) findViewById(R.id.btn_cancel);
        this.pswd = (TextView) findViewById(R.id.txt_password);
        this.cancel.setOnClickListener(this.cancel1);
        this.oke.setOnClickListener(this.oke1);

    }
}
