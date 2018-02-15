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

public class BookUpdateActivity extends Activity {
	 
	Spinner staticSpinner;
	String bookcat;
	private EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7;
	private Button btn,btn2,btn3;
	@Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      
        setContentView(R.layout.bookupdate_activity);

        staticSpinner = (Spinner) findViewById(R.id.cat_spinner);
        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.bookcat_array,
                        android.R.layout.simple_spinner_item);
 
        // Specify the layout to use when the list of choices appears
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 
        // Apply the adapter to the spinner
        staticSpinner.setAdapter(staticAdapter);
        
        String Accn_no,Title,Author,Edition,Material_name,Rack_no,Self_no,Position,Material_Status;
 
        staticSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                bookcat=(String) parent.getItemAtPosition(position);
            }

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
        });
        
        ed1=(EditText)findViewById(R.id.accno_upd);
        ed2=(EditText)findViewById(R.id.title);
        ed3=(EditText)findViewById(R.id.author);
        ed4=(EditText)findViewById(R.id.edition);
        ed5=(EditText)findViewById(R.id.rackno);
        ed6=(EditText)findViewById(R.id.selfno);
        ed7=(EditText)findViewById(R.id.position);
        
    	
			
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
			
    
        btn=(Button)findViewById(R.id.btnbookupdate);
        btn2=(Button)findViewById(R.id.btnbookclear);
        
        
        btn.setOnClickListener(new OnClickListener() {
  			
  			@Override
  			public void onClick(View arg0) {
  				// TODO Auto-generated method stub
  				String accno,title,author,edition,rackno,selfno,position;
  				accno=ed1.getText().toString();
  				title=ed2.getText().toString();
  				author=ed3.getText().toString();
  				edition=ed4.getText().toString();
  				rackno=ed5.getText().toString();
  				selfno=ed6.getText().toString();
  				position=ed7.getText().toString();
  				
  				Toast.makeText(BookUpdateActivity.this, "Book Update Activity ..",Toast.LENGTH_SHORT).show();				
  				new BookSearchActivty1(BookUpdateActivity.this).execute(accno,title,author,edition,bookcat,rackno,selfno,position);
  				
  			}
  		});
          
        
          btn2.setOnClickListener(new OnClickListener() {
  			
  			@Override
  			public void onClick(View arg0) {
  				// TODO Auto-generated method stub
  				ed1.setText("");
  				ed2.setText("");		
  				ed3.setText("");
  				ed4.setText("");
  				ed5.setText("");
  				ed6.setText("");
  				ed7.setText("");
  			}
  		});
       
        
  }
}