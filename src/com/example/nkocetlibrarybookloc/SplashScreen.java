package com.example.nkocetlibrarybookloc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class SplashScreen extends Activity {
	
	 Button b1;
	 private ProgressBar spinner;
	 
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        // Show the splash screen
	        setContentView(R.layout.splash_screen);
	        
	        b1=(Button)findViewById(R.id.button);
	        spinner=(ProgressBar)findViewById(R.id.progressBar);
	        spinner.setVisibility(View.GONE);

	        b1.setOnClickListener(new View.OnClickListener() {
	           @Override
	           public void onClick(View v) {
	              spinner.setVisibility(View.VISIBLE);
	              try {
		                Thread.sleep(2000);
		                Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
		    	        startActivity(intent);
		            } catch (Exception e) {
		                e.printStackTrace();	             
		            }
	           }
	        });
	     
	    }
	  }
