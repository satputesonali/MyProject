package com.example.nkocetlibrarybookloc;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BookReturn extends Activity {
	 
	 WebView mywebview;
	@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
      setContentView(R.layout.book_return);

      mywebview = (WebView) findViewById(R.id.webView3);  
      WebSettings webSettings = mywebview.getSettings();
      webSettings.setJavaScriptEnabled(true);                                         

      mywebview.setWebViewClient(new WebViewClient());  
  
      mywebview.loadUrl("http://192.168.43.243/NKOCETLibrary/Book_Return.php");
  				
   	    
}
}