package com.example.sockettemp;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RequestTask extends AsyncTask<Double,Void,Double> {
    private TextView output;
    private static final String IP = "10.0.2.2";
    private static final int PORT = 12345;

    public RequestTask(TextView output) {
        this.output = output;
    }

    @Override
    protected void onPostExecute(Double aDouble) {
        super.onPostExecute(aDouble);
        output.setText(String.valueOf(aDouble));
    }

    @Override
    protected Double doInBackground(Double... doubles) {
        Double tempF = 0.0;
        try{
            Socket socket = new Socket(IP, PORT);
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            output.writeDouble(doubles[0]);
            output.flush();
            tempF = input.readDouble();
            output.close();
            input.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return tempF;
    }
}
