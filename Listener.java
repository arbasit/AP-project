package com.example.arslan.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;

public class Listener extends Thread {
    private DatagramSocket socket;
    private MainActivity activity;
    private String deviceName;
    private InetAddress deviceIp;
    private HashMap<String,Boolean> hash;
    private Thread t;
    private byte[] response;
    private byte[] receive;
    public Listener(DatagramSocket socket,MainActivity activity,String deviceName,InetAddress address)
    {
        this.socket=socket;
        this.activity=activity;
        this.deviceIp=address;
        this.deviceName=deviceName;
    }
    @Override
    public void start()
    {
        receive=new byte[1024];
        hash= new HashMap<>();
        if(t==null)
        {
            t=new Thread(this);
            t.start();
        }
    }
    @Override
    public void run()
    {
        while(true)
        {
            try {
                DatagramPacket packet = new DatagramPacket(receive, receive.length);
                socket.receive(packet);
                InetAddress ip=packet.getAddress();
                //show(ip);

            } catch (IOException e) {

            }
        }
    }
  /*  public void show(InetAddress ip)
    {
        String ipAdress=ip.toString();
        if(ip.equals(deviceIp))
        {
            return;
        }
        if(!hash.containsKey(ipAdress))
        {
            hash.put(ipAdress,true);
            activity.addListItem(ipAdress);
        }
    }
    */
}
