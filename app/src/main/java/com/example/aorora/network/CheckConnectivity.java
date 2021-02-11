package com.example.aorora.network;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/*
This asyncronous task will check if we can reach the hosting ARORA-Server in order to ensure we can
still update the backend via a network connection.
 */
public class CheckConnectivity extends AsyncTask<Void,Void,Boolean> {
    public GetConnInfo connInfoCheck = null;

    @Override
    protected Boolean doInBackground(Void... voids) {
        try{
            //Timeout of the request, in milliseconds
            int timeoutMs = 1500;
            Socket testSock = new Socket();
            //Create the address that our socket will connect to. This is a public google DNS.
            SocketAddress sockAddress = new InetSocketAddress("104.248.178.78", 8000);
            //This will throw an ioException if we cannot connect to the address in the timeout period.
            testSock.connect(sockAddress, timeoutMs);
            //Otherwise, we connected, so close the socket and return true.
            testSock.close();
            return true;
        }
        catch(IOException e){
            Log.d("Connectivity Check", e.getMessage());
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean output){
        connInfoCheck.getConnInfo(output);
    }
}