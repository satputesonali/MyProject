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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
public class LoginActivity extends Activity {
	private Button btn;
	Spinner staticSpinner;
	private EditText ed1,ed2;
	private String memtype;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setting default screen to login.xml
        setContentView(R.layout.login);
 

         staticSpinner = (Spinner) findViewById(R.id.lg_spinner);
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
        
        ed1=(EditText)findViewById(R.id.lg_email);
        ed2=(EditText)findViewById(R.id.lg_password);
        
    
        btn=(Button)findViewById(R.id.btnLogin);
        
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String email,password;
				email=ed1.getText().toString();
				password=ed2.getText().toString();
				
				
				Toast.makeText(LoginActivity.this, "Login Validation...",Toast.LENGTH_SHORT).show();				
				new LoginActivty1(LoginActivity.this).execute(email,password,memtype);
				
			}
		});
        
        TextView registerScreen = (TextView) findViewById(R.id.link_to_register);
 
        // Listening to register new account link
        registerScreen.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}