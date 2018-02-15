package com.example.nkocetlibrarybookloc;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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
 

public class MemberActivity extends Activity {
	 
	Spinner staticSpinner,staticSpinner1,staticSpinner2;
	String memtype,dept;
	private EditText ed1,ed2,ed3,ed4;
	private Button btn,btn2;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
          setContentView(R.layout.member_activity);
 
          staticSpinner = (Spinner) findViewById(R.id.membertype_spinner);
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
          
          
          staticSpinner1 = (Spinner) findViewById(R.id.department_spinner);
          // Create an ArrayAdapter using the string array and a default spinner
          ArrayAdapter<CharSequence> staticAdapter1 = ArrayAdapter
                  .createFromResource(this, R.array.dept_array,
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
                  dept=(String) parent.getItemAtPosition(position);
              }

  			@Override
  			public void onNothingSelected(AdapterView<?> arg0) {
  				// TODO Auto-generated method stub
  				
  			}
          });
          
          ed1=(EditText)findViewById(R.id.Mem_id);
          ed2=(EditText)findViewById(R.id.FirstName);
          ed3=(EditText)findViewById(R.id.LastName);
          ed4=(EditText)findViewById(R.id.PhoneNo);
          
      
          btn=(Button)findViewById(R.id.btnmem_register);
          btn2=(Button)findViewById(R.id.btnmem_clear);
          
          btn.setOnClickListener(new OnClickListener() {
  			
  			@Override
  			public void onClick(View arg0) {
  				// TODO Auto-generated method stub
  				String Mem_id,FirstName,LastName,PhoneNo;
  				Mem_id=ed1.getText().toString();
  				FirstName=ed2.getText().toString();
  				LastName=ed3.getText().toString();
  				PhoneNo=ed4.getText().toString();
  				
  				
  				Toast.makeText(MemberActivity.this, "Member Activity ..",Toast.LENGTH_SHORT).show();				
  				new MemberActivty1(MemberActivity.this).execute(Mem_id,memtype,FirstName,LastName,PhoneNo,dept);
  				
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
  			}
  		});
    
        
    }
}