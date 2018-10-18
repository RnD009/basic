package id.revolt.basic;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

public class setup extends AppCompatActivity {
    private Switch sw1;
    private Switch sw2;
    private Switch sw3;
    private Button save;
    boolean switch1;

    private View.OnClickListener save1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (sw1.isChecked()){
                Intent sw1 = new Intent();
                sw1.setData(Uri.parse("?"));
                setup.this.setResult( 1, sw1);
                switch1 = true;
                finish();
            }else if (!sw1.isChecked()){
                Intent sw1 = new Intent();
                sw1.setData(Uri.parse("/"));
                setup.this.setResult( 2, sw1);
                switch1 = false;
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        this.sw1 = (Switch) findViewById(R.id.sw1);
        this.sw2 = (Switch) findViewById(R.id.sw2);
        this.sw3 = (Switch) findViewById(R.id.sw3);
        this.save = (Button) findViewById(R.id.btn_save);
        this.save.setOnClickListener(this.save1);
        sw1.setChecked(switch1);
    }

}
