package wishihab.wedefend;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePasswordActivity extends AppCompatActivity {

    EditText edittext1, edittext2;
    Button button_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);

        edittext1 = (EditText)findViewById(R.id.edit_pass);
        edittext2 = (EditText)findViewById(R.id.edit_pass2);
        button_confirm = (Button)findViewById(R.id.button_pass);

        button_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass1 = edittext1.getText().toString();
                String pass2 = edittext2.getText().toString();

                if(pass1.equals("") || pass2.equals("")){
                    Toast.makeText(CreatePasswordActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                }else{
                    if(pass1.equals(pass2)){
                        //save to share preferences
                        SharedPreferences settings = getSharedPreferences("PREFS", 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("password", pass1);
                        editor.apply();

                        //go to main
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(CreatePasswordActivity.this, "Password doesn't match!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}
