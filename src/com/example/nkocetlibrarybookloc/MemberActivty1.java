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

public class MemberActivty1 extends AsyncTask<String, Void, String>  {

	private Context context;
	 
    public MemberActivty1(Context context) {
        this.context = context;
    }
 
    protected void onPreExecute() {
 
    }
	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
	    	String Mem_id = arg0[0];
	        String memtype = arg0[1];
	        String FirstName = arg0[2];
	        String LastName = arg0[3];
	        String PhoneNo = arg0[4];
	        String dept = arg0[5];
	 
	        String link;
	        String data;
	        BufferedReader bufferedReader;
	        String result;
	 
	        try {
	            data = "?Mem_id=" + URLEncoder.encode(Mem_id, "UTF-8");
	            data += "&memtype=" + URLEncoder.encode(memtype, "UTF-8");
	            data += "&FirstName=" + URLEncoder.encode(FirstName, "UTF-8");
	            data += "&LastName=" + URLEncoder.encode(LastName, "UTF-8");
	            data += "&PhoneNo=" + URLEncoder.encode(PhoneNo, "UTF-8");
	            data += "&dept=" + URLEncoder.encode(dept, "UTF-8");
	 
	            link = "http://192.168.43.243/NKOCETLibrary/member.php" + data;
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
	                    Toast.makeText(context, "Member successfully stored.", Toast.LENGTH_SHORT).show();
	                      
	                } else if (query_result.equals("Mem_id")) {
	                       Toast.makeText(context, "Mem_id for Selected Member Already Exist !", Toast.LENGTH_SHORT).show();
	                }else if (query_result.equals("FAILURE")) {
	                    Toast.makeText(context, "Member Fail.", Toast.LENGTH_SHORT).show();
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