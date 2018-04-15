package wishihab.wedefend;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPasswordActivity extends AppCompatActivity {

    EditText editenter;
    Button button_enter;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);

        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        password = settings.getString("password", "");

        editenter = (EditText)findViewById(R.id.edit_enterpass);
        button_enter = (Button)findViewById(R.id.button_enterpass);

        button_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editenter.getText().toString();

                if(text.equals(password)){
                    //enter main
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(EnterPasswordActivity.this, "Password incorrect!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
