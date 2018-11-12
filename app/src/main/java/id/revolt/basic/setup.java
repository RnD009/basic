package id.revolt.basic;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.ToggleButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class setup extends AppCompatActivity {
    private Switch sw1;
    private Switch sw2;
    private Switch sw3;
    private RadioButton rd1;
    private RadioButton rd2;
    private RadioButton rd3;
    private Button save;
    boolean switch1;

    private  View.OnClickListener sw11 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (sw1.isChecked()){
                sw2.setEnabled(true);
            }else {
                sw2.setEnabled(false);
            }
        }
    };

    private  View.OnClickListener sw21 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (sw2.isChecked()){
                sw3.setEnabled(true);
            }else {
                sw3.setEnabled(false);
            }
        }
    };

    private  View.OnClickListener sw31 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (sw3.isChecked()){
                rd1.setEnabled(true);
                rd2.setEnabled(true);
                rd3.setEnabled(true);
            }else {
                rd1.setEnabled(false);
                rd2.setEnabled(false);
                rd3.setEnabled(false);
            }
        }
    };

    private View.OnClickListener save1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (sw1.isChecked() && !sw2.isChecked() && !sw3.isChecked()){
                Intent sw1 = new Intent();
                sw1.setData(Uri.parse("?"));
                setup.this.setResult( 1, sw1);
                switch1 = true;
                finish();

            }
            else if (sw2.isChecked() && sw1.isChecked() && !sw3.isChecked()){
                Intent sw2 = new Intent();
                sw2.setData(Uri.parse("P"));
                setup.this.setResult( 1, sw2);
                finish();
            }
            else if (sw3.isChecked() && sw2.isChecked() && sw1.isChecked()){
                boolean valsw3 = true;
                rd1.setEnabled(true);
                rd2.setEnabled(true);
                rd3.setEnabled(true);
                if (valsw3 == true && rd1.isChecked()){
                    Intent sw3 = new Intent();
                    sw3.setData(Uri.parse("J"));
                    setup.this.setResult( 1, sw3);
                    finish();
                }
                if (valsw3 == true && rd2.isChecked()){
                    Intent sw3 = new Intent();
                    sw3.setData(Uri.parse("K"));
                    setup.this.setResult( 1, sw3);
                    finish();
                }
                if (valsw3 == true && rd3.isChecked()){
                    Intent sw3 = new Intent();
                    sw3.setData(Uri.parse("L"));
                    setup.this.setResult( 1, sw3);
                    finish();
                }
            }
            else if(!sw1.isChecked()){
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

        ButterKnife.bind(this);

        this.sw1 = (Switch) findViewById(R.id.sw1);
        //this.sw2 = (Switch) findViewById(R.id.sw2);
        sw2.setEnabled(false);
        //this.sw3 = (Switch) findViewById(R.id.sw3);
        sw3.setEnabled(false);
        //this.rd1 = (RadioButton) findViewById(R.id.radioButton1);
        //this.rd2 = (RadioButton) findViewById(R.id.radioButton2);
        //this.rd3 = (RadioButton) findViewById(R.id.radioButton3);
        rd1.setEnabled(false);
        rd2.setEnabled(false);
        rd3.setEnabled(false);

        this.save = (Button) findViewById(R.id.btn_save);

        this.save.setOnClickListener(this.save1);
        this.sw1.setOnClickListener(this.sw11);
        this.sw2.setOnClickListener(this.sw21);
        this.sw3.setOnClickListener(this.sw31);
    }

}
