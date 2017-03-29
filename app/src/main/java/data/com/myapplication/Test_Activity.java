package data.com.myapplication;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import data.com.myapplication.Home.Home;

public class Test_Activity extends AppCompatActivity  {

    private Keys keys;
    private static String fileName = "QualityEducation.PDF";
    private static final String MY_URL = "https://www.unicef.org/education/files/QualityEducation.PDF";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_);
        keys = new Keys(this);
//        Button size1=(Button)findViewById(R.id.size1);
//        Button size2=(Button)findViewById(R.id.size2);


        final Spinner spinner=(Spinner)findViewById(R.id.spinner);
        final TextView textView= (TextView)findViewById(R.id.textView);
        final TextView textView2= (TextView)findViewById(R.id.textView2);
        DsmListDetails dsmListDetails;



        List<DsmListDetails> dsmListDetailsList=new ArrayList<DsmListDetails>();

        for(int i=0 ;i<4;i++){

            DsmListDetails dsmListDetailses=new DsmListDetails
                    ("2AN","Aman");

            dsmListDetailsList.add(dsmListDetailses);

        }
        //DsmListDetails e= new DsmListDetails("4D","AJ");
        //dsmListDetailsList.add(4,e);


        ArrayAdapter<String> adapter;
        int n= dsmListDetailsList.size();

        final String dsm_id_ar[]=new String[n];
        final String dsm_name_ar[]=new String[n];

        int i=0;
        while(i < 4)
        {
            dsmListDetails = dsmListDetailsList.get(i);
            dsm_id_ar[i] = dsmListDetails.getDsm_id();
            dsm_name_ar[i] = dsmListDetails.getDsm_name();
            i++;

        }

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, dsm_id_ar);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //OnItemSelected
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int t, long l) {

                if(spinner.getItemAtPosition(t).toString().equals("2AN"))
                    textView.setVisibility(View.GONE);
                textView.setText(spinner.getItemAtPosition(t).toString()
                );
                String s="";
                s=s+t;
                textView2.setText(dsm_name_ar[t]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }


    public void button_size1(View view)

    {
        keys.setKey_id("1");
        String message = keys.getKey_id();
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        Intent i= new Intent(Test_Activity.this, Home.class);
        startActivity(i);
        finish();


    }

    public void button_size2(View view)
    {
        keys.setKey_id("2");
        String message = keys.getKey_id();
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        Intent i= new Intent(Test_Activity.this, Home.class);
        startActivity(i);
        finish();

    }

//    public void pdfDownloader(View view)
//    {
//        try {
//            //this is the file you want to download from the remote server
//            //String path ="http://localhost:8080/somefile.zip";
//            //this is the name of the local file you will create
//            //String targetFileName;
//            boolean eof = false;
//            URL u = new URL(MY_URL);
//            HttpURLConnection c = (HttpURLConnection) u.openConnection();
//            c.setRequestMethod("GET");
//            c.setDoOutput(true);
//            c.connect();
//
//            String PATH = Environment.getExternalStorageDirectory().toString();
//            Log.d("Abhan", "PATH: " + PATH);
//            File file = new File(PATH);
//            if(!file.exists()) {
//                file.mkdirs();
//            }
//            File outputFile = new File(file, fileName);
//            FileOutputStream fos = new FileOutputStream(outputFile);
//            InputStream is = c.getInputStream();
//            byte[] buffer = new byte[1024*1024];
//            int len1 = 0;
//            while ((len1 = is.read(buffer)) != -1) {
//                fos.write(buffer, 0, len1);
//            }
//            fos.flush();
//            fos.close();
//            is.close();
//
//
//        } catch (MalformedURLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ProtocolException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//
//
//    }


    public void download(View v)
    {
        new DownloadFile().execute("http://maven.apache.org/maven-1.x/maven.pdf", "maven.pdf");
    }

    public void view(View v)
    {
        File pdfFile = new File(Environment.getExternalStorageDirectory() + "/testthreepdf/" + "maven.pdf");  // -> filename = maven.pdf
        Uri path = Uri.fromFile(pdfFile);
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try{
            startActivity(pdfIntent);
        }catch(ActivityNotFoundException e){
            Toast.makeText(Test_Activity.this, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
        }
    }
    private class DownloadFile extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... strings) {
            String fileUrl = "http://maven.apache.org/maven-1.x/maven.pdf";
            String fileName = "maven.pdf";
            String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            File folder = new File(extStorageDirectory, "testthreepdf");
            folder.mkdir();
            Toast.makeText(Test_Activity.this,"Downloading",Toast.LENGTH_LONG).show();
            File pdfFile = new File(folder, fileName);

            try{
                pdfFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
            FileDownloader.downloadFile(fileUrl, pdfFile);
            return null;
        }
    }





}
