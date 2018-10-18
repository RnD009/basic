package id.revolt.basic;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

import id.revolt.basic.R;

public class list extends AppCompatActivity {
    private static final int REQUEST_ENABLE_BT = 1;
    ArrayAdapter adapter;
    private BluetoothAdapter bluetoothAdapter;
    ArrayAdapter<String> btArrayAdapter;
    byte[] c;
    int counter;
    String d;
    private ArrayList<String> items = new ArrayList();
    BluetoothAdapter mBluetoothAdapter;
    BluetoothDevice mmDevice;
    InputStream mmInputStream;
    OutputStream mmOutputStream;
    BluetoothSocket mmSocket;
    private Set<BluetoothDevice> pairedDevices;
    byte[] readBuffer;
    int readBufferPosition;
    volatile boolean stopWorker;
    Thread workerThread;

    @SuppressLint("ResourceType")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        final ListView listDevicesFound = (ListView) findViewById(R.id.lv);
        this.btArrayAdapter = new ArrayAdapter(this, 17367043);
        listDevicesFound.setAdapter(this.btArrayAdapter);
        getPairedDevices();
        startDiscovery();
        listDevicesFound.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String terpilih = listDevicesFound.getItemAtPosition(position).toString();
                String address = terpilih.substring(terpilih.length() - 17);
                String name = terpilih.substring(0, terpilih.length() - 17);
                Intent intent = new Intent();
                intent.setData(Uri.parse(address));
                list.this.setResult(-1, intent);
                list.this.finish();
            }
        });
    }

    private void startDiscovery() {
        this.bluetoothAdapter.cancelDiscovery();
        this.bluetoothAdapter.startDiscovery();
    }

    public void onBackPressed() {
        setResult(0, new Intent());
        finish();
    }

    private void getPairedDevices() {
        this.pairedDevices = this.bluetoothAdapter.getBondedDevices();
        if (this.pairedDevices.size() > 0) {
            for (BluetoothDevice device : this.pairedDevices) {
                this.btArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                this.btArrayAdapter.notifyDataSetChanged();
            }
        }
    }

}
