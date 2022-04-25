package com.android.deptlibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

class BackgroundWorker extends AsyncTask<String,Void,String> {

    Context context;
    AlertDialog alertDialog;
    BackgroundWorker (Context ctx){
        context=ctx;
    }


    @Override
    protected String doInBackground(String... voids) {
        String type=voids[0];
        String insert_url="http://192.168.0.107/Library/insert.php";
        String delete_url="http://192.168.0.107/Library/del.php";
        String update_url="http://192.168.0.107/Library/update.php";

        if(type.equals("insert")){

            try {

                String domno1=voids[1];
                String domname1=voids[2];
                String bookno1=voids[3];
                String bookt1=voids[4];
                String aut1=voids[5];
                String pub1=voids[6];
                String donated1=voids[7];
                String avail1=voids[8];
                String deleted1=voids[9];
                String usern1=voids[10];
                String usernn1=voids[11];

                URL url=new URL(insert_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String postdata= URLEncoder.encode("domain_no","UTF-8")+"="+URLEncoder.encode(domno1,"UTF-8")+"&"
                        +URLEncoder.encode("domain_name","UTF-8")+"="+URLEncoder.encode(domname1,"UTF-8")+"&"
                        +URLEncoder.encode("book_no","UTF-8")+"="+URLEncoder.encode(bookno1,"UTF-8")+"&"
                        +URLEncoder.encode("book_title","UTF-8")+"="+URLEncoder.encode(bookt1,"UTF-8")+"&"
                        +URLEncoder.encode("author","UTF-8")+"="+URLEncoder.encode(aut1,"UTF-8")+"&"
                        +URLEncoder.encode("publication","UTF-8")+"="+URLEncoder.encode(pub1,"UTF-8")+"&"
                        +URLEncoder.encode("donated_by","UTF-8")+"="+URLEncoder.encode(donated1,"UTF-8")+"&"
                        +URLEncoder.encode("availability","UTF-8")+"="+URLEncoder.encode(avail1,"UTF-8")+"&"
                        +URLEncoder.encode("deleted","UTF-8")+"="+URLEncoder.encode(deleted1,"UTF-8")+"&"
                        +URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(usern1,"UTF-8")+"&"
                        +URLEncoder.encode("user_name2","UTF-8")+"="+URLEncoder.encode(usernn1,"UTF-8");

                bufferedWriter.write(postdata);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                String result=" ";
                String line=" ";
                while ( (line=bufferedReader.readLine())!=null){
                    result += line;
                }


                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(type.equals("delete")){
            try {

                String bookno1=voids[1];

                URL url=new URL(delete_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String postdata= URLEncoder.encode("book_no","UTF-8")+"="+URLEncoder.encode(bookno1,"UTF-8");

                bufferedWriter.write(postdata);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                String result=" ";
                String line=" ";
                while ( (line=bufferedReader.readLine())!=null){
                    result += line;
                }


                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        else if(type.equals("update"))
        {
            try {

                String domno1=voids[1];
                String domname1=voids[2];
                String bookno1=voids[3];
                String bookt1=voids[4];
                String aut1=voids[5];
                String pub1=voids[6];
                String donated1=voids[7];
                String avail1=voids[8];
                String deleted1=voids[9];
                String usern1=voids[10];
                String usernn1=voids[11];

                URL url=new URL(update_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String postdata= URLEncoder.encode("domain_no","UTF-8")+"="+URLEncoder.encode(domno1,"UTF-8")+"&"
                        +URLEncoder.encode("domain_name","UTF-8")+"="+URLEncoder.encode(domname1,"UTF-8")+"&"
                        +URLEncoder.encode("book_no","UTF-8")+"="+URLEncoder.encode(bookno1,"UTF-8")+"&"
                        +URLEncoder.encode("book_title","UTF-8")+"="+URLEncoder.encode(bookt1,"UTF-8")+"&"
                        +URLEncoder.encode("author","UTF-8")+"="+URLEncoder.encode(aut1,"UTF-8")+"&"
                        +URLEncoder.encode("publication","UTF-8")+"="+URLEncoder.encode(pub1,"UTF-8")+"&"
                        +URLEncoder.encode("donated_by","UTF-8")+"="+URLEncoder.encode(donated1,"UTF-8")+"&"
                        +URLEncoder.encode("availability","UTF-8")+"="+URLEncoder.encode(avail1,"UTF-8")+"&"
                        +URLEncoder.encode("deleted","UTF-8")+"="+URLEncoder.encode(deleted1,"UTF-8")+"&"
                        +URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(usern1,"UTF-8")+"&"
                        +URLEncoder.encode("user_name2","UTF-8")+"="+URLEncoder.encode(usernn1,"UTF-8");

                bufferedWriter.write(postdata);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                String result=" ";
                String line=" ";
                while ( (line=bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    @Override
    protected void onPreExecute() {

        alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Book Information");
    }

    @Override
    protected void onPostExecute(String result) {


        alertDialog.setMessage(result);
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
