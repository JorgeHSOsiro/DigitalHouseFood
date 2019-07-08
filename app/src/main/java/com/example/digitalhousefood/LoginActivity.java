package com.example.digitalhousefood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText emailEditText;
    private TextInputEditText senhaEditText;
    private Button loginButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailEditText = findViewById(R.id.email_edit_text);
        senhaEditText = findViewById(R.id.senha_edit_text);

        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaHome();
            }
        });
        registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaRegister();
            }
        });
    }

    private void irParaRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void irParaHome() {

        String emailDigitado = emailEditText.getEditableText().toString();
        String senhaDigitada = senhaEditText.getEditableText().toString();

        emailEditText.setError(null);
        senhaEditText.setError(null);
        if(emailDigitado.equals("joji@gmail.com")&& senhaDigitada.equals("12345")){
            Intent intent = new Intent(this, HomeActivity.class);

            Bundle bundle = new Bundle();
            bundle.putString("EMAIL",emailDigitado);
            intent.putExtras(bundle);
            startActivity(intent);
        }else{
            emailEditText.setError("Usuario e/ou senha incorretos");
            senhaEditText.setError("Usuario e/ou senha incorretos");
        }

    }
}
