package com.example.digitalhousefood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
    private TextInputEditText nomeEditText;
    private TextInputEditText emailEditText;
    private TextInputEditText senhaEditText;
    private TextInputEditText confirmarSenhaEditText;
    private Button confirmarButton;
    private ImageButton voltarButton;
    private String emailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nomeEditText = findViewById(R.id.nome_cadastro_edit_text);
        emailEditText = findViewById(R.id.email_cadastro_edit_text);
        senhaEditText = findViewById(R.id.senha_cadastro_edit_text);
        confirmarSenhaEditText = findViewById(R.id.confirmar_senha_edit_text);
        confirmarButton = findViewById(R.id.confirmar_cadastro_button);
        voltarButton = findViewById(R.id.voltar_register_image_button);

        confirmarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irParaLogin();
            }
        });

        voltarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarParaOutraTela();
            }
        });
    }

    private void voltarParaOutraTela() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {
            getFragmentManager().popBackStack();
        }
    }

    private void irParaLogin() {

        String nomeEditado = nomeEditText.getEditableText().toString();
        String emailEditado = emailEditText.getEditableText().toString();
        String senhaEditada = senhaEditText.getEditableText().toString();
        String confirmarSenhaEditada = confirmarSenhaEditText.getEditableText().toString();

        nomeEditText.setError(null);
        emailEditText.setError(null);
        senhaEditText.setError(null);
        confirmarSenhaEditText.setError(null);

        if (!nomeEditado.equals("") && !emailEditado.equals("")&& !senhaEditada.equals("") && !confirmarSenhaEditada.equals("") ){

            if(!senhaEditText.getEditableText().toString().equals(confirmarSenhaEditText.getEditableText().toString())) {
                senhaEditText.setError("As senhas não conferem!");
                confirmarSenhaEditText.setError("As senhas não conferem!");
            }else if (!emailEditText.getEditableText().toString().matches(emailRegex)) {
                emailEditText.setError("O email deve conter @ e .");
            }else {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }
        }else{
            nomeEditText.setError("Por favor preencha o campo");
            emailEditText.setError("Por favor preencha o campo");
            senhaEditText.setError("Por favor preencha o campo");
            confirmarSenhaEditText.setError("Por favor preencha o campo");
        }

    }
}
