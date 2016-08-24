package com.example.myapplication6;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.hardware.display.VirtualDisplay;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.BufferedReader;
import java.io.Console;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Locale;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity6 extends AppCompatActivity {

    TextView tvOut;
    Button btOk;
    Button btCancel;
    private  static String mytag = "mytag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        tvOut = (TextView) findViewById(R.id.tvOut);
        btOk = (Button) findViewById(R.id.btnOk);
        btCancel = (Button) findViewById(R.id.btnCancel);

        btOk.setOnClickListener((View v) -> {
            Log.d(mytag, getResources().getString(R.string.OkClickedText));
            Toast.makeText(this, getResources().getString(R.string.OkClickedText), Toast.LENGTH_SHORT).show();
            tvOut.setText("Нажата клавиша Ок__");
            try {
                getRates();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        });

        btCancel.setOnClickListener((View v) -> {
            Log.d(mytag, getResources().getString(R.string.CancelClickedText));
            Toast.makeText(this, getResources().getString(R.string.CancelClickedText), Toast.LENGTH_SHORT).show();
            tvOut.setText("Нажата клавиша Cancel");  }
        );


    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    void getRates() throws java.net.MalformedURLException, java.io.IOException, ParserConfigurationException, SAXException {
        int i;
        String srvSrc = "cbrates.rbc.ru";
        String adr = "tsv/";
        String tmp = "/2016/08/23";
        Log.d(mytag, "1111111");
        String filePathSrv = "http://www.cbr.ru/scripts/XML_dynamic.asp?date_req1=23/08/2016&date_req2=23/08/2016&VAL_NM_RQ=R01235";
        URL url = new URL(filePathSrv);


// or if you prefer DOM:
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(url.openStream());

        System.out.println(doc.toString());

//        URI uri = null;
//
//
//
//        File file = new File(uri.getPath());
//        System.out.println(uri.getPath());
//        System.out.println(uri.toString());
//        try (
//                FileReader fileReader =new FileReader(file);
//             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
//            String result = "";
//            String str = "";
//            while ((str = bufferedReader.readLine()) != null) {
//                result += str;
//            }
//            System.out.println(result);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }




    };

}
