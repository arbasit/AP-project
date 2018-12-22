package com.example.arslan.test;

import android.content.Context;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Scanner extends Thread{
    private DatagramSocket socket;
    private InetAddress ip;
    private int port;
    private byte[] msg;
    private Thread t;
    private DatagramPacket packet;
    private MainActivity activity;
    public Scanner(DatagramSocket socket,InetAddress ip,int port,MainActivity activity)
    {
        this.socket=socket;
        this.ip=ip;
        this.port=port;
        this.activity=activity;
    }

    @Override
    public void start()
    {
        msg="ECHO\r\n\r\n".getBytes();
        packet=new DatagramPacket(msg,msg.length,ip,port);
        if(t==null)
        {
            t = new Thread (this);
            t.start ();
        }
    }

    @Override
    public void run()
    {
      while(true)
      {
          try {
              socket.send(packet);
              activity.showMyToast();
              currentThread().sleep(5000);
          } catch (IOException e) {
              e.printStackTrace();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
    }

}
