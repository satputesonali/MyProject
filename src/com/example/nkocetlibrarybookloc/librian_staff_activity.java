package com.example.nkocetlibrarybookloc;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
 

public class librian_staff_activity extends Activity {
	private Button btn,btn2,btn3,btn4,btn5,btn6;
	
	 
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.librarianstaff);
        
        btn=(Button)findViewById(R.id.btnbcat);
        btn2=(Button)findViewById(R.id.btnaddmem);
        btn3=(Button)findViewById(R.id.btnbook);
        btn4=(Button)findViewById(R.id.btnsearch);
        btn5=(Button)findViewById(R.id.btnissue);
        btn6=(Button)findViewById(R.id.btnreturn);
        
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Intent i = new Intent(getApplicationContext(), LibrarianActivity.class);
	              startActivity(i);
			}
		});
        
        btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Intent i = new Intent(getApplicationContext(), MemberActivity.class);
	              startActivity(i);							
			}
		});
 
        btn3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Intent i = new Intent(getApplicationContext(),BookActivity.class);
	              startActivity(i);							
			}
		});
        
        btn4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Intent i = new Intent(getApplicationContext(),BookSearchActivity.class);
	              startActivity(i);							
			}
		});
        
        btn5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Intent i = new Intent(getApplicationContext(),BookIsuue.class);
	              startActivity(i);							
			}
		});
        
        btn6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 Intent i = new Intent(getApplicationContext(),BookReturn.class);
	              startActivity(i);							
			}
		});

	}
}