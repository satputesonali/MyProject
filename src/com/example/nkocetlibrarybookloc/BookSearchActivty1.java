package com.example.nkocetlibrarybookloc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class BookSearchActivty1 extends AsyncTask<String, Void, String>  {

	private Context context;
	 
    public BookSearchActivty1(Context context) {
        this.context = context;
    }
 
    protected void onPreExecute() {
 
    }

	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
	    	String accno = arg0[0];
	        String title = arg0[1];
	        String author = arg0[2];
	        String edition = arg0[3];
	        String bookcat = arg0[4];
	        String rackno = arg0[5];
	        String selfno = arg0[6];
	        String position = arg0[7];
	 
	        String link;
	        String data;
	        BufferedReader bufferedReader;
	        String result;
	 
	        try {
	            data = "?accno=" + URLEncoder.encode(accno, "UTF-8");
	            data += "&title=" + URLEncoder.encode(title, "UTF-8");
	            data += "&author=" + URLEncoder.encode(author, "UTF-8");
	            data += "&edition=" + URLEncoder.encode(edition, "UTF-8");
	            data += "&bookcat=" + URLEncoder.encode(bookcat, "UTF-8");
	            data += "&rackno=" + URLEncoder.encode(rackno, "UTF-8");
	            data += "&selfno=" + URLEncoder.encode(selfno, "UTF-8");
	            data += "&position=" + URLEncoder.encode(position, "UTF-8");

	 
	            link = "http://192.168.43.243/NKOCETLibrary/Book_Search.php" + data;
	            URL url = new URL(link);
	            HttpURLConnection con = (HttpURLConnection) url.openConnection();
	 
	            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            result = bufferedReader.readLine();
	            return result;
	        } catch (Exception e) {
	            return new String("Exception: " + e.getMessage());
	        }
	}
	
	 @Override
	    protected void onPostExecute(String result) {
	        String jsonStr = result;
	        if (jsonStr != null) {
	            try {
	                JSONObject jsonObj = new JSONObject(jsonStr);
	                String query_result = jsonObj.getString("query_result");
	                
	                
	                if (query_result.equals("SUCCESS")) {
	                    Toast.makeText(context, "Book successfully Updated.", Toast.LENGTH_SHORT).show();
	                      
	                } else if (query_result.equals("Accn_no")) {
	                       Toast.makeText(context, "ACC No not found !", Toast.LENGTH_SHORT).show();
	                }else if (query_result.equals("FAILURE")) {
	                    Toast.makeText(context, "Book Fail.", Toast.LENGTH_SHORT).show();
	                } else {
	                    Toast.makeText(context, "Couldn't connect to remote database.", Toast.LENGTH_SHORT).show();
	                }
	            } catch (JSONException e) {
	                e.printStackTrace();
	                Toast.makeText(context, "Error parsing JSON data.", Toast.LENGTH_SHORT).show();
	            }
	        } else {
	            Toast.makeText(context, "Couldn't get any JSON data.", Toast.LENGTH_SHORT).show();
	        }
	    }

}
