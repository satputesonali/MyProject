package com.example.nkocetlibrarybookloc;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class BookSearchActivity  extends Activity {
	 
	private Button btn;
	private EditText ed1;
	@Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       
         setContentView(R.layout.booksearch_activity);

         ed1=(EditText)findViewById(R.id.accno_ser);
         
         
     
         btn=(Button)findViewById(R.id.btn_bksearch1);
               
         btn.setOnClickListener(new OnClickListener() {
      			
      			@Override
      			public void onClick(View arg0) {
      				// TODO Auto-generated method stub
      				String accno;
      				accno=ed1.getText().toString();
      				
      				Toast.makeText(BookSearchActivity.this, "Book Search Activity ..",Toast.LENGTH_SHORT).show();				
      				new BookSearchActivty2(BookSearchActivity.this).execute(accno);
     				
      			}
      		});
              
   }
}