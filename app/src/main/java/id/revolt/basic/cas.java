package id.revolt.basic;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;



public class cas extends AppCompatActivity {

    private Button oke;
    private CheckBox ncb1;
    private CheckBox ncb2;
    private CheckBox ncb3;


    private View.OnClickListener oke1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (ncb1.isChecked() && ncb2.isChecked() && ncb3.isChecked()){
                Intent as = new Intent();
                as.setData(Uri.parse("<"));
                cas.this.setResult( 1, as);
                finish();
            }
            else{
                Toast.makeText(cas.this, "Please check all options", Toast.LENGTH_SHORT).show();
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cas);

        this.oke = (Button) findViewById(R.id.btn_start);
        this.ncb1 = (CheckBox) findViewById(R.id.cb1);
        this.ncb2 = (CheckBox) findViewById(R.id.cb2);
        this.ncb3 = (CheckBox) findViewById(R.id.cb3);

        this.oke.setOnClickListener(this.oke1);

    }

}
