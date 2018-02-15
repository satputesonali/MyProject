package com.example.nkocetlibrarybookloc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

public class BookSearchActivty3 extends AsyncTask<String, Void, String>  {

	private Context context;
	 
    public BookSearchActivty3(Context context) {
        this.context = context;
    }
 
    protected void onPreExecute() {
 
    }

	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
	    	String accno = arg0[0];	    	
	      
	 
	        String link;
	        String data;
	        BufferedReader bufferedReader;
	        String result;
	 
	        try {
	            data = "?accno=" + URLEncoder.encode(accno, "UTF-8");
	 
	            link = "http://192.168.43.243/NKOCETLibrary/Book_Search3.php" + data;
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
	        String Accn_no,Title,Author,Edition,Material_name,Rack_no,Self_no,Position,Material_Status;
	        Accn_no=Title=Author=Edition=Material_name=Rack_no=Self_no=Position=Material_Status="";
	        if (jsonStr != null) {
	            try {
	                JSONObject jsonObj = new JSONObject(jsonStr);
	                String query_result = jsonObj.getString("query_result");
	                
	                
	                if (query_result.equals("SUCCESS")) {
	                    Toast.makeText(context, "Book successfully search.", Toast.LENGTH_SHORT).show();
	                    Accn_no= jsonObj.getString("Accn_no");
	                    Title= jsonObj.getString("Title");
	                    Author= jsonObj.getString("Author");
	                    Edition= jsonObj.getString("Edition");
	                    Material_name= jsonObj.getString("Material_name");
	                    Rack_no= jsonObj.getString("Rack_no");
	                    Self_no= jsonObj.getString("Self_no");
	                    Position= jsonObj.getString("Position");
	                    Material_Status= jsonObj.getString("Material_Status");
	                    
	                    Bundle b1=new Bundle();
	                    b1.putString("Accn_no",Accn_no);
	   				 	b1.putString("Title",Title);  
	   				 	b1.putString("Author",Author);
	   				 	b1.putString("Edition",Edition);
	   				 	b1.putString("Material_name",Material_name);
	   				 	b1.putString("Rack_no",Rack_no);
	   				 	b1.putString("Self_no",Self_no);
	   				 	b1.putString("Position",Position);
	   				 	b1.putString("Material_Status",Material_Status);
	   				 	
	                    Intent i = new Intent(context, BookDisplayActivity.class);
	                    i.putExtras(b1);
	                    context.startActivity(i);	
	                    
	                } else if (query_result.equals("Accn_no")) {
	                       Toast.makeText(context, "ACC No not found !", Toast.LENGTH_SHORT).show();
	                }else if (query_result.equals("FAILURE")) {
	                    Toast.makeText(context, "Book Search Fail.", Toast.LENGTH_SHORT).show();
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
