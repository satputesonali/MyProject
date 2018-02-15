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

public class BookDisplayActivity extends Activity {
	 
	Spinner staticSpinner;
	String bookcat;
	private EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7;
	private Button btn,btn2,btn3;
	@Override
 public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     
       setContentView(R.layout.book_display);

       
       ed1=(EditText)findViewById(R.id.accno_upd1);
       ed2=(EditText)findViewById(R.id.title1);
       ed3=(EditText)findViewById(R.id.author1);
       ed4=(EditText)findViewById(R.id.edition1);
       ed5=(EditText)findViewById(R.id.rackno1);
       ed6=(EditText)findViewById(R.id.selfno1);
       ed7=(EditText)findViewById(R.id.position1);
       
       String Accn_no,Title,Author,Edition,Material_name,Rack_no,Self_no,Position,Material_Status;
			
			Intent mIntent=getIntent();
			Bundle b2=mIntent.getExtras();
			Accn_no=b2.getString("Accn_no");
			Title=b2.getString("Title");
			Author=b2.getString("Author");
			Edition=b2.getString("Edition");
			Material_name=b2.getString("Material_name");
			Rack_no=b2.getString("Rack_no");
			Self_no=b2.getString("Self_no");
			Position=b2.getString("Position");
			Material_Status=b2.getString("Material_Status");
				
			ed1.setText(Accn_no);
			ed2.setText(Title);		
			ed3.setText(Author);
			ed4.setText(Edition);
			ed5.setText(Rack_no);
			ed6.setText(Self_no);
			ed7.setText(Position); 
			
   
       btn=(Button)findViewById(R.id.btnbookupdate1);
       
       
       
       btn.setOnClickListener(new OnClickListener() {
 			
 			@Override
 			public void onClick(View arg0) {
 				// TODO Auto-generated method stub
 				finish(); 				
 			}
 		});              
        
 }
}