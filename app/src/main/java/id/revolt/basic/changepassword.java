package id.revolt.basic;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class changepassword extends AppCompatActivity {
    boolean CheckEditText;
    @BindView(R.id.btn_cancel) Button cancel;
    @BindView(R.id.btn_ok) Button oke;
    @BindView(R.id.txt_cpassword) TextView cpswd;

    private View.OnClickListener cancel1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changepassword.this.setResult(0, new Intent());
            changepassword.this.finish();
        }
    };

    private View.OnClickListener oke1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changepassword.this.CheckeditTextEmptyOrNot();
            if (changepassword.this.CheckEditText){
                Intent intent = new Intent();
                intent.setData(Uri.parse(changepassword.this.cpswd.getText().toString()));
                Toast.makeText(changepassword.this, changepassword.this.cpswd.getText().toString(), Toast.LENGTH_SHORT).show();
                changepassword.this.setResult(-1, intent);
                changepassword.this.finish();
                return;

            }
            Toast.makeText(changepassword.this, "Please Fill password fields.", Toast.LENGTH_SHORT).show();
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);

        ButterKnife.bind(this);

        this.oke = (Button) findViewById(R.id.btn_ok);
        this.cancel = (Button) findViewById(R.id.btn_cancel);
        this.cpswd = (TextView) findViewById(R.id.txt_cpassword);
        this.cancel.setOnClickListener(this.cancel1);
        this.oke.setOnClickListener(this.oke1);

    }

    public void CheckeditTextEmptyOrNot(){
        String NameDholder = this.cpswd.getText().toString().trim();
        if (TextUtils.isEmpty(NameDholder) || NameDholder.length()< 5){
            this.CheckEditText = false;
        }else {
            this.CheckEditText = true;

        }

    }

}
