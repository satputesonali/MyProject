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

public class search_activity extends Activity {
	 
	private Button btn;
	private EditText ed1,ed2;
	 WebView mywebview;
	@Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      
        setContentView(R.layout.search_activity);

        ed1=(EditText)findViewById(R.id.accno_ser1);
        ed2=(EditText)findViewById(R.id.title_ser1);
        
        mywebview = (WebView) findViewById(R.id.webView3);  
        WebSettings webSettings = mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);                                         

        mywebview.setWebViewClient(new WebViewClient());  
    
        btn=(Button)findViewById(R.id.btn_bksearch2);
              
        btn.setOnClickListener(new OnClickListener() {
     			
     			@Override
     			public void onClick(View arg0) {
     				// TODO Auto-generated method stub
     				String accno,title;
     				accno=ed1.getText().toString();
     				title=ed2.getText().toString();
     				
     				Toast.makeText(search_activity.this, "Book Search Activity ..",Toast.LENGTH_SHORT).show();				
     				//new BookSearchActivty3(search_activity.this).execute(accno);
     				   				
     				mywebview.loadUrl("http://192.168.43.243/NKOCETLibrary/Book_Search3.php?accno=" + accno+"&title="+title);
    				
     			}
     		});
             
  }
}