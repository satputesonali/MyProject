package com.example.nkocetlibrarybookloc;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
 

public class LibrarianActivity extends Activity {
	Spinner staticSpinner,staticSpinner1;
	private String memtype,bookcat;
	private EditText ed1,ed2;
	private Button btn,btn2;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.librarian_activity);
        
        staticSpinner = (Spinner) findViewById(R.id.lib_spinner);
        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.member_array,
                        android.R.layout.simple_spinner_item);
 
        // Specify the layout to use when the list of choices appears
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 
        // Apply the adapter to the spinner
        staticSpinner.setAdapter(staticAdapter);
        
 
        staticSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                memtype=(String) parent.getItemAtPosition(position);
            }

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
        });
        
        
        staticSpinner1 = (Spinner) findViewById(R.id.bookcat_spinner);
        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter1 = ArrayAdapter
                .createFromResource(this, R.array.bookcat_array,
                        android.R.layout.simple_spinner_item);
 
        // Specify the layout to use when the list of choices appears
        staticAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 
        // Apply the adapter to the spinner
        staticSpinner1.setAdapter(staticAdapter1);
        
 
        staticSpinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
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
        
        
        ed1=(EditText)findViewById(R.id.lib_ndays);
        ed2=(EditText)findViewById(R.id.lib_nitems);
        
    
        btn=(Button)findViewById(R.id.btnLibrarian);
        btn2=(Button)findViewById(R.id.btnLibrarianClear);
        
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String days,items;
				days=ed1.getText().toString();
				items=ed2.getText().toString();
				
				
				Toast.makeText(LibrarianActivity.this, "Book Category...",Toast.LENGTH_SHORT).show();				
				new LibrarianActivty1(LibrarianActivity.this).execute(bookcat,memtype,days,items);
				
			}
		});
        
        btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ed1.setText("");
				ed2.setText("");				
			}
		});
    }
	
	
}