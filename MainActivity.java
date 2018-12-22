package com.example.arslan.test;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IP ip=new IP(getBaseContext());
        InetAddress a= null;
        a = ip.getBroadcastAddress();
        String s= ""+a.toString();
        TextView t=(TextView) findViewById(R.id.test);
        t.setText(s);
        try {
            DatagramSocket socket=new DatagramSocket(25000);
            Scanner sc= new Scanner(socket,a,25000,this);
          //  Listener l=new Listener(socket,this,android.os.Build.MODEL,socket.getLocalAddress());
            sc.start();
         //   l.start();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        //list.setAdapter(listAdapter);


    }
    public void showMyToast(){
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                // write code to show toast
                Toast.makeText(getApplicationContext(),"Sent",Toast.LENGTH_SHORT).show();
            }

        });


    }
   /* public void addListItem(final String user){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                arrayList.add(user);
                listAdapter.notifyDataSetChanged();
            }
        });


    }
*/
}
