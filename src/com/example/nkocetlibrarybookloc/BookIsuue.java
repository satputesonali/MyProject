package com.example.nkocetlibrarybookloc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BookIsuue extends Activity {
	 
	 WebView mywebview;
	@Override
 public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     
       setContentView(R.layout.book_issue);

       mywebview = (WebView) findViewById(R.id.webView3);  
       WebSettings webSettings = mywebview.getSettings();
       webSettings.setJavaScriptEnabled(true);                                         

       mywebview.setWebViewClient(new WebViewClient());  
   
       mywebview.loadUrl("http://192.168.43.243/NKOCETLibrary/Book_Issue.php");
   				
    	    
 }
}