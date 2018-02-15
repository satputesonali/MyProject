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

public class RegisterActivty  extends AsyncTask<String, Void, String>  {

	private Context context;
	 
    public RegisterActivty(Context context) {
        this.context = context;
    }
 
    protected void onPreExecute() {
 
    }
	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
			String name = arg0[0];
	        String email = arg0[1];
	        String password = arg0[2];
	        String memtype = arg0[3];
	 
	        String link;
	        String data;
	        BufferedReader bufferedReader;
	        String result;
	 
	        try {
	            data = "?name=" + URLEncoder.encode(name, "UTF-8");
	            data += "&email=" + URLEncoder.encode(email, "UTF-8");
	            data += "&password=" + URLEncoder.encode(password, "UTF-8");
	            data += "&memtype=" + URLEncoder.encode(memtype, "UTF-8");
	 
	            link = "http://192.168.43.243/NKOCETLibrary/register.php" + data;
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
	                    Toast.makeText(context, "Registered successfully.", Toast.LENGTH_SHORT).show();
	                } else if (query_result.equals("FAILURE")) {
	                    Toast.makeText(context, "Registration Fail.", Toast.LENGTH_SHORT).show();
	                } else if (query_result.equals("EMAIL")) {
                       Toast.makeText(context, "Email Already Registered !", Toast.LENGTH_SHORT).show();
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