package com.example.nkocetlibrarybookloc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
 

public class RegisterActivity extends Activity {
	 
	private Button btn;
	Spinner staticSpinner;
	private EditText ed1,ed2,ed3;
	private String memtype;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
      
        
        // Set View to register.xml
        setContentView(R.layout.register);
        
        staticSpinner = (Spinner) findViewById(R.id.spinner1);
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
 
        
        
        ed1=(EditText)findViewById(R.id.reg_fullname);
        ed2=(EditText)findViewById(R.id.reg_email);
        ed3=(EditText)findViewById(R.id.reg_password);
    
        btn=(Button)findViewById(R.id.btnRegister);
        
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String name,email,password;
				name=ed1.getText().toString();
				email=ed2.getText().toString();
				password=ed3.getText().toString();
				
				Toast.makeText(RegisterActivity.this, "Account Saving...",Toast.LENGTH_SHORT).show();				
				new RegisterActivty(RegisterActivity.this).execute(name,email,password,memtype);
				
			}
		});
        TextView loginScreen = (TextView) findViewById(R.id.link_to_login);
 
        // Listening to Login Screen link
        loginScreen.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
                                // Closing registration screen
                // Switching to Login Screen/closing register screen
                finish();
            }
        });
    }
}