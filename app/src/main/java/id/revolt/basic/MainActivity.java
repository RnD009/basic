package id.revolt.basic;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    public Vibrator h;

    @BindView(R.id.front_up)
    ImageButton a1;
    @BindView(R.id.front_down)
    ImageButton a2;
    @BindView(R.id.rear_up)
    ImageButton a3;
    @BindView(R.id.rear_down)
    ImageButton a4;
    @BindView(R.id.all_up)
    ImageButton a5;
    @BindView(R.id.all_down)
    ImageButton a6;

    @BindView(R.id.tg_bt)
    ToggleButton btn_bt;
    @BindView(R.id.btn_alldown)
    ImageButton alldown;
    @BindView(R.id.btn_mem1)
    ImageButton mem1;
    @BindView(R.id.btn_mem2)
    ImageButton mem2;
    @BindView(R.id.btn_mem3)
    ImageButton mem3;

    String d;
    @BindView(R.id.e)
    TextView e;
    @BindView(R.id.tv1)
    TextView L1;
    @BindView(R.id.tv2)
    TextView R1;

    @BindView(R.id.tv5)
    TextView tvSW;

    boolean fail;

    BluetoothAdapter mBluetoothAdapter;
    BluetoothDevice mmDevice;
    InputStream mmInputStream;
    OutputStream mmOutputStream;
    BluetoothSocket mmSocket;
    private Set<BluetoothDevice> pairedDevices;
    byte[] readBuffer;
    int readBufferPosition;

    volatile boolean stopWorker;
    boolean sukses;


    private View.OnTouchListener ta1 = new View.OnTouchListener() {
        @SuppressLint({"WrongConstant", "PrivateResource"})
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case R.styleable.View_android_theme:
                    MainActivity.this.a2.setEnabled(false);
                    MainActivity.this.a3.setEnabled(false);
                    MainActivity.this.a4.setEnabled(false);
                    MainActivity.this.a5.setEnabled(false);
                    MainActivity.this.a6.setEnabled(false);
                    long[] pattern = new long[]{0, 1000, 0, 1000, 0, 1000, 0, 1000, 0};
                    MainActivity.this.h = (Vibrator) MainActivity.this.getApplicationContext().getSystemService("vibrator");
                    MainActivity.this.h.vibrate(pattern, -1);
                    try {
                        MainActivity.this.fa1();
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                case R.styleable.View_android_focusable:
                    MainActivity.this.h.cancel();
                    MainActivity.this.a2.setEnabled(true);
                    MainActivity.this.a3.setEnabled(true);
                    MainActivity.this.a4.setEnabled(true);
                    MainActivity.this.a5.setEnabled(true);
                    MainActivity.this.a6.setEnabled(true);
                    try {
                        MainActivity.this.fa15();
                        break;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        break;
                    }
            }

            return true;
        }
    };

    private View.OnTouchListener ta2 = new View.OnTouchListener() {
        @SuppressLint("WrongConstant")
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case R.styleable.View_android_theme:
                    MainActivity.this.a1.setEnabled(false);
                    MainActivity.this.a3.setEnabled(false);
                    MainActivity.this.a4.setEnabled(false);
                    MainActivity.this.a5.setEnabled(false);
                    MainActivity.this.a6.setEnabled(false);
                    long[] pattern = new long[]{0, 1000, 0, 1000, 0, 1000, 0, 1000, 0};
                    MainActivity.this.h = (Vibrator) MainActivity.this.getApplicationContext().getSystemService("vibrator");
                    MainActivity.this.h.vibrate(pattern, -1);
                    try {
                        MainActivity.this.fa2();
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                case R.styleable.View_android_focusable:
                    MainActivity.this.h.cancel();
                    MainActivity.this.a1.setEnabled(true);
                    MainActivity.this.a3.setEnabled(true);
                    MainActivity.this.a4.setEnabled(true);
                    MainActivity.this.a5.setEnabled(true);
                    MainActivity.this.a6.setEnabled(true);
                    try {
                        MainActivity.this.fa15();
                        break;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        break;
                    }
            }

            return true;
        }
    };

    private View.OnTouchListener ta3 = new View.OnTouchListener() {
        @SuppressLint("WrongConstant")
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case R.styleable.View_android_theme:
                    MainActivity.this.a1.setEnabled(false);
                    MainActivity.this.a2.setEnabled(false);
                    MainActivity.this.a4.setEnabled(false);
                    MainActivity.this.a5.setEnabled(false);
                    MainActivity.this.a6.setEnabled(false);
                    long[] pattern = new long[]{0, 1000, 0, 1000, 0, 1000, 0, 1000, 0};
                    MainActivity.this.h = (Vibrator) MainActivity.this.getApplicationContext().getSystemService("vibrator");
                    MainActivity.this.h.vibrate(pattern, -1);
                    try {
                        MainActivity.this.fa3();
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                case R.styleable.View_android_focusable:
                    MainActivity.this.h.cancel();
                    MainActivity.this.a1.setEnabled(true);
                    MainActivity.this.a2.setEnabled(true);
                    MainActivity.this.a4.setEnabled(true);
                    MainActivity.this.a5.setEnabled(true);
                    MainActivity.this.a6.setEnabled(true);
                    try {
                        MainActivity.this.fa15();
                        break;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        break;
                    }
            }

            return true;
        }
    };

    private View.OnTouchListener ta4 = new View.OnTouchListener() {
        @SuppressLint("WrongConstant")
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case R.styleable.View_android_theme:
                    MainActivity.this.a1.setEnabled(false);
                    MainActivity.this.a2.setEnabled(false);
                    MainActivity.this.a3.setEnabled(false);
                    MainActivity.this.a5.setEnabled(false);
                    MainActivity.this.a6.setEnabled(false);
                    long[] pattern = new long[]{0, 1000, 0, 1000, 0, 1000, 0, 1000, 0};
                    MainActivity.this.h = (Vibrator) MainActivity.this.getApplicationContext().getSystemService("vibrator");
                    MainActivity.this.h.vibrate(pattern, -1);
                    try {
                        MainActivity.this.fa4();
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                case R.styleable.View_android_focusable:
                    MainActivity.this.h.cancel();
                    MainActivity.this.a1.setEnabled(true);
                    MainActivity.this.a2.setEnabled(true);
                    MainActivity.this.a3.setEnabled(true);
                    MainActivity.this.a5.setEnabled(true);
                    MainActivity.this.a6.setEnabled(true);
                    try {
                        MainActivity.this.fa15();
                        break;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        break;
                    }
            }

            return true;
        }
    };

    private View.OnTouchListener ta5 = new View.OnTouchListener() {
        @SuppressLint("WrongConstant")
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case R.styleable.View_android_theme:
                    MainActivity.this.a1.setEnabled(false);
                    MainActivity.this.a2.setEnabled(false);
                    MainActivity.this.a3.setEnabled(false);
                    MainActivity.this.a4.setEnabled(false);
                    MainActivity.this.a6.setEnabled(false);
                    long[] pattern = new long[]{0, 1000, 0, 1000, 0, 1000, 0, 1000, 0};
                    MainActivity.this.h = (Vibrator) MainActivity.this.getApplicationContext().getSystemService("vibrator");
                    MainActivity.this.h.vibrate(pattern, -1);
                    try {
                        MainActivity.this.fa5();
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                case R.styleable.View_android_focusable:
                    MainActivity.this.h.cancel();
                    MainActivity.this.a1.setEnabled(true);
                    MainActivity.this.a2.setEnabled(true);
                    MainActivity.this.a3.setEnabled(true);
                    MainActivity.this.a4.setEnabled(true);
                    MainActivity.this.a6.setEnabled(true);
                    try {
                        MainActivity.this.fa15();
                        break;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        break;
                    }
            }

            return true;
        }
    };

    private View.OnTouchListener ta6 = new View.OnTouchListener() {
        @SuppressLint("WrongConstant")
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case R.styleable.View_android_theme:
                    MainActivity.this.a1.setEnabled(false);
                    MainActivity.this.a2.setEnabled(false);
                    MainActivity.this.a3.setEnabled(false);
                    MainActivity.this.a4.setEnabled(false);
                    MainActivity.this.a5.setEnabled(false);
                    long[] pattern = new long[]{0, 1000, 0, 1000, 0, 1000, 0, 1000, 0};
                    MainActivity.this.h = (Vibrator) MainActivity.this.getApplicationContext().getSystemService("vibrator");
                    MainActivity.this.h.vibrate(pattern, -1);
                    try {
                        MainActivity.this.fa6();
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                case R.styleable.View_android_focusable:
                    MainActivity.this.h.cancel();
                    MainActivity.this.a1.setEnabled(true);
                    MainActivity.this.a2.setEnabled(true);
                    MainActivity.this.a3.setEnabled(true);
                    MainActivity.this.a4.setEnabled(true);
                    MainActivity.this.a5.setEnabled(true);
                    try {
                        MainActivity.this.fa15();
                        break;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        break;
                    }
            }

            return true;
        }
    };


    Thread workerThread;

    public void onDestroy() {
        super.onDestroy();
        if (this.sukses) {
            Toast.makeText(this, "destroy discon", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            Z();
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    MainActivity.this.closeBT();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 1000);

    }

    private View.OnClickListener alldown1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (btn_bt.isChecked()) {
                Toast.makeText(MainActivity.this, "All down", Toast.LENGTH_SHORT).show();
                try {
                    ad();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }

        }
    };

    private View.OnClickListener Opmem1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (btn_bt.isChecked()) {
                //Toast.makeText(MainActivity.this, "Open memory 1", Toast.LENGTH_SHORT).show();
                try {
                    Opmem1();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    };

    private View.OnClickListener Opmem2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (btn_bt.isChecked()) {
                //Toast.makeText(MainActivity.this, "Open memory 2", Toast.LENGTH_SHORT).show();
                try {
                    Opmem2();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    };

    private View.OnClickListener Opmem3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (btn_bt.isChecked()) {
                //Toast.makeText(MainActivity.this, "Open memory 3", Toast.LENGTH_SHORT).show();
                try {
                    Opmem3();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    };

    private View.OnLongClickListener Svcmem1 = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            if (btn_bt.isChecked()) {
                Toast.makeText(MainActivity.this, "Save memory 1", Toast.LENGTH_SHORT).show();
                try {
                    Svmem1();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            return false;
        }
    };

    private View.OnLongClickListener Svcmem2 = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            if (btn_bt.isChecked()) {
                Toast.makeText(MainActivity.this, "Save memory 2", Toast.LENGTH_SHORT).show();
                try {
                    Svmem2();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            return false;
        }
    };

    private View.OnLongClickListener Svcmem3 = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            if (btn_bt.isChecked()) {
                Toast.makeText(MainActivity.this, "Save memory 3", Toast.LENGTH_SHORT).show();
                try {
                    Svmem3();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            return false;
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        this.sukses = true;
        this.a1 = (ImageButton) findViewById(R.id.front_up);
        this.a2 = (ImageButton) findViewById(R.id.front_down);
        this.a3 = (ImageButton) findViewById(R.id.rear_up);
        this.a4 = (ImageButton) findViewById(R.id.rear_down);
        this.a5 = (ImageButton) findViewById(R.id.all_up);
        this.a6 = (ImageButton) findViewById(R.id.all_down);
        this.e = (TextView) findViewById(R.id.e);

        this.L1 = (TextView) findViewById(R.id.tv1);
        this.R1 = (TextView) findViewById(R.id.tv2);

        this.tvSW = (TextView) findViewById(R.id.tv5);


        this.btn_bt = (ToggleButton) findViewById(R.id.tg_bt);
        this.alldown = (ImageButton) findViewById(R.id.btn_alldown);
        this.mem1 = (ImageButton) findViewById(R.id.btn_mem1);
        this.mem2 = (ImageButton) findViewById(R.id.btn_mem2);
        this.mem3 = (ImageButton) findViewById(R.id.btn_mem3);

        this.alldown.setOnClickListener(this.alldown1);
        this.mem1.setOnLongClickListener(this.Svcmem1);
        this.mem2.setOnLongClickListener(this.Svcmem2);
        this.mem3.setOnLongClickListener(this.Svcmem3);

        this.mem1.setOnClickListener(this.Opmem1);
        this.mem2.setOnClickListener(this.Opmem2);
        this.mem3.setOnClickListener(this.Opmem3);

        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (this.mBluetoothAdapter == null) {
            Toast.makeText(this, "No bluetooth adapter available", Toast.LENGTH_SHORT).show();
        }
        if (!this.mBluetoothAdapter.isEnabled()) {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 0);
        }


        this.btn_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (MainActivity.this.btn_bt.isChecked()) {
                        MainActivity.this.a1.setEnabled(true);
                        MainActivity.this.a2.setEnabled(true);
                        MainActivity.this.a3.setEnabled(true);
                        MainActivity.this.a4.setEnabled(true);
                        MainActivity.this.a5.setEnabled(true);
                        MainActivity.this.a6.setEnabled(true);

                        MainActivity.this.alldown.setEnabled(true);

                        MainActivity.this.e.setEnabled(true);
                        try {
                            MainActivity.this.startActivityForResult(new Intent(MainActivity.this, list.class), 3);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    MainActivity.this.a1.setEnabled(false);
                    MainActivity.this.a2.setEnabled(false);
                    MainActivity.this.a3.setEnabled(false);
                    MainActivity.this.a4.setEnabled(false);
                    MainActivity.this.a5.setEnabled(false);
                    MainActivity.this.a6.setEnabled(false);

                    MainActivity.this.alldown.setEnabled(false);


                    MainActivity.this.Z();
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            try {
                                MainActivity.this.closeBT();
                                MainActivity.this.e.setText(BuildConfig.FLAVOR);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }, 1000);
                    MainActivity.this.e.setEnabled(false);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_cpass) {
            if (MainActivity.this.sukses) {
                Toast.makeText(MainActivity.this, "Bluetooth Must Connect", Toast.LENGTH_SHORT).show();
                return true;
            }
            try {
                MainActivity.this.sandi();
                MainActivity.this.startActivityForResult(new Intent(MainActivity.this, changepassword.class), 2);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return true;
            }
        } else if (id == R.id.nav_cas) {
            if (MainActivity.this.sukses) {
                Toast.makeText(MainActivity.this, "Bluetooth Must Connect", Toast.LENGTH_SHORT).show();
                return true;
            } else {
                MainActivity.this.startActivityForResult(new Intent(MainActivity.this, cas.class), 4);
            }

        } else if (id == R.id.nav_operation) {
            Intent intent = new Intent(MainActivity.this, intruksi.class);
            startActivity(intent);
        } else if (id == R.id.nav_setup) {
            if (MainActivity.this.sukses) {
                Toast.makeText(MainActivity.this, "Bluetooth Must Connect", Toast.LENGTH_SHORT).show();
                return true;
            } else {
                MainActivity.this.startActivityForResult(new Intent(MainActivity.this, setup.class), 5);
            }

        } else if (id == R.id.nav_about) {
            Intent intent = new Intent(MainActivity.this, about.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) { //login
            if (resultCode == -1) {
                try {
                    this.d = data.getData().toString();
                    Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
                    uji2();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (requestCode == 0) {
                try {
                    closeBT();
                    this.btn_bt.setChecked(false);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }

        } else if (requestCode == 2) { //cpass
            if (resultCode == -1) {
                try {
                    this.a1.setEnabled(false);
                    this.a2.setEnabled(false);
                    this.a3.setEnabled(false);
                    this.a4.setEnabled(false);
                    this.a5.setEnabled(false);
                    this.a6.setEnabled(false);

                    this.e.setEnabled(false);
                    this.d = data.getData().toString();
                    uji2();
                    Toast.makeText(this, "wait 4 second", Toast.LENGTH_LONG).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                MainActivity.this.save();
                                MainActivity.this.a1.setEnabled(true);
                                MainActivity.this.a2.setEnabled(true);
                                MainActivity.this.a3.setEnabled(true);
                                MainActivity.this.a4.setEnabled(true);
                                MainActivity.this.a5.setEnabled(true);
                                MainActivity.this.a6.setEnabled(true);

                                MainActivity.this.e.setEnabled(true);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }, 4000);
                } catch (IOException e22) {
                    e22.printStackTrace();
                }
            }
            if (resultCode == 0) {
                try {
                    gagal();
                } catch (IOException e222) {
                    e222.printStackTrace();
                }
            }
        } else if (requestCode == 4) { //cas
            if (resultCode == 1) {
                try {
                    this.d = data.getData().toString();
                    Toast.makeText(MainActivity.this, "Wait a moment", Toast.LENGTH_SHORT).show();
                    kalibrasi();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (requestCode == 5) { //kompressor
            if (resultCode == 1) {
                try {
                    this.d = data.getData().toString();
                    Toast.makeText(MainActivity.this, "Compressor ON", Toast.LENGTH_SHORT).show();
                    sw();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (resultCode == 2) {
                try {
                    this.d = data.getData().toString();
                    Toast.makeText(MainActivity.this, "Compressor OFF", Toast.LENGTH_SHORT).show();
                    sw();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (requestCode != 3) {
        } else {
            if (resultCode == -1) {
                try {
                    this.d = data.getData().toString();
                    findBT2();
                    openBT();
                } catch (IOException e2222) {
                    e2222.printStackTrace();
                }
            } else if (resultCode == 0) {
                this.btn_bt.setChecked(false);
            }
        }
    }


    void findBT2() {
        Set<BluetoothDevice> pairedDevices = this.mBluetoothAdapter.getBondedDevices();
        if (pairedDevices.size() > 0) {
            for (BluetoothDevice device : pairedDevices) {
                if (device.getName().equals("REVOLT")) {
                    this.mmDevice = device;
                    Log.v("ArduinoBT", "findBT found device named" + this.mmDevice.getName());
                    Log.v("ArduinoBT", "device address is" + this.mmDevice.getAddress());
                    break;
                }
            }
        }
        Toast.makeText(this, "Find Bluetooth", Toast.LENGTH_SHORT).show();
    }


    void openBT() throws IOException {
        this.mmSocket = this.mmDevice.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805f9b34fb"));
        this.mBluetoothAdapter.cancelDiscovery();
        try {
            this.mmSocket.connect();
        } catch (IOException e) {
            Toast.makeText(this, "Bluetooth Connected failed", Toast.LENGTH_SHORT).show();
            this.fail = true;
            this.btn_bt.setChecked(false);
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        if (!this.fail) {
            this.sukses = false;
            this.mmOutputStream = this.mmSocket.getOutputStream();
            this.mmInputStream = this.mmSocket.getInputStream();
            beginListenForData();
            Toast.makeText(this, "Bluetooth Connected", Toast.LENGTH_SHORT).show();
            startActivityForResult(new Intent(this, login.class), 1);
        }
    }

    void beginListenForData() {
        this.a1.setOnTouchListener(this.ta1);
        this.a2.setOnTouchListener(this.ta2);
        this.a3.setOnTouchListener(this.ta3);
        this.a4.setOnTouchListener(this.ta4);
        this.a5.setOnTouchListener(this.ta5);
        this.a6.setOnTouchListener(this.ta6);

        final Handler handler = new Handler();
        this.stopWorker = false;
        this.readBufferPosition = 0;
        this.readBuffer = new byte[1024];
        this.workerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted() && !MainActivity.this.stopWorker) {
                    try {
                        int byteAvailable = MainActivity.this.mmInputStream.available();
                        if (byteAvailable > 0) {
                            byte[] packetBytes = new byte[byteAvailable];
                            MainActivity.this.mmInputStream.read(packetBytes);
                            for (int i = 0; i < byteAvailable; i++) {
                                byte b = packetBytes[i];

                                if (b == (byte) 10) {
                                    byte[] encodedBytes = new byte[MainActivity.this.readBufferPosition];
                                    System.arraycopy(MainActivity.this.readBuffer, 0, encodedBytes, 0, encodedBytes.length);
                                    final String data = new String(encodedBytes, "US-ASCII");
                                    MainActivity.this.readBufferPosition = 0;
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            System.out.println(data);

                                            String[] separate = data.split(":");
                                            separate[0] = separate[0].trim();
                                            separate[1] = separate[1].trim();
                                            separate[2] = separate[2].trim();

                                            System.out.println(separate[0]);
                                            System.out.println(separate[1]);
                                            System.out.println(separate[2]);

                                            MainActivity.this.L1.setText(separate[0]);
                                            MainActivity.this.R1.setText(separate[1]);

                                            MainActivity.this.tvSW.setText(separate[2] + " psi");

                                        }
                                    });
                                } else {
                                    byte[] bArr = MainActivity.this.readBuffer;
                                    MainActivity mainActivity = MainActivity.this;
                                    int i2 = mainActivity.readBufferPosition;
                                    mainActivity.readBufferPosition = i2 + 1;
                                    bArr[i2] = b;
                                }
                            }
                        }
                    } catch (IOException e) {
                        MainActivity.this.stopWorker = true;
                    }
                }
            }
        });
        this.workerThread.start();
    }

    void fa1() throws IOException {
        this.mmOutputStream.write("!".getBytes());
    }

    void fa2() throws IOException {
        this.mmOutputStream.write("@".getBytes());
    }

    void fa3() throws IOException {
        this.mmOutputStream.write("|".getBytes());
    }

    void fa4() throws IOException {
        this.mmOutputStream.write("$".getBytes());
    }

    void fa5() throws IOException {
        this.mmOutputStream.write("%".getBytes());
    }

    void fa6() throws IOException {
        this.mmOutputStream.write("^".getBytes());
    }

    void fa15() throws IOException {
        this.mmOutputStream.write("s".getBytes());
    }

    void Z() throws IOException {
        this.mmOutputStream.write("9".getBytes());
    }

    void uji2() throws IOException {
        this.mmOutputStream.write(this.d.getBytes());
    }

    void kalibrasi() throws IOException {
        this.mmOutputStream.write(this.d.getBytes());
    }

    void sw() throws IOException {
        this.mmOutputStream.write(this.d.getBytes());
    }

    void sandi() throws IOException {
        this.mmOutputStream.write("Z".getBytes());
    }

    void save() throws IOException {
        this.mmOutputStream.write("x".getBytes());
    }

    void gagal() throws IOException {
        this.mmOutputStream.write("y".getBytes());
    }

    void ad() throws IOException {
        this.mmOutputStream.write(";".getBytes());
    }

    void Svmem1() throws IOException {
        this.mmOutputStream.write("[".getBytes());
    }

    void Svmem2() throws IOException {
        this.mmOutputStream.write("]".getBytes());
    }

    void Svmem3() throws IOException {
        this.mmOutputStream.write(">".getBytes());
    }

    void Opmem1() throws IOException {
        this.mmOutputStream.write("{".getBytes());
    }

    void Opmem2() throws IOException {
        this.mmOutputStream.write("}".getBytes());
    }

    void Opmem3() throws IOException {
        this.mmOutputStream.write("~".getBytes());
    }


    void closeBT() throws IOException {
        this.e.setText(BuildConfig.FLAVOR);
        this.stopWorker = true;
        this.sukses = true;
        this.mmOutputStream.close();
        this.mmInputStream.close();
        this.mmSocket.close();
        Toast.makeText(this, "Bluetooth Disconnect", Toast.LENGTH_SHORT).show();
        this.e.setText(BuildConfig.FLAVOR);
    }

}
