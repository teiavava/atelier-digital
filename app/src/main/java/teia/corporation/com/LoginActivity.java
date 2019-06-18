package teia.corporation.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        final EditText loginField = findViewById(R.id.login_field);
        final EditText passField = findViewById(R.id.password_field);
        Button loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = loginField.getText().toString();
                String password = passField.getText().toString();
                if(login.equals("Teia") && password.equals("portocala")){
                    goToMainActivity();
                }else{
                    Toast.makeText(getApplicationContext(),"Wrong Login or Password!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void goToMainActivity(){
        startActivity(new Intent(this, MainActivity.class));
    }
}