package com.example.download;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;

public class DownloadTask extends AsyncTask<String, Void, Bitmap> {

    private Context myContext;
    private ImageView imageView;
    private ProgressDialog progressDialog;

    public DownloadTask(Context myContext, ImageView imageView) {
        this.myContext = myContext;
        this.imageView = imageView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(myContext,"Por favor, aguarde! ... ","Baixando imagem");
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        progressDialog.dismiss();
        imageView.setImageBitmap(bitmap);
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        Bitmap bitmap = null;
        try {
            bitmap = DownloadRequest.downloadImage(strings[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}
