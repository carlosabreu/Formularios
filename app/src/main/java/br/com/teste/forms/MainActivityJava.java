package br.com.teste.forms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import br.com.teste.forms.utils.Formatter;

public class MainActivityJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_java);
        findViewById(R.id.button).setOnClickListener(v -> {
            setResult(12);
            finish();
        });

        ((EditText) findViewById(R.id.name)).setText(getIntent().getStringExtra("Nome"));
        ((EditText) findViewById(R.id.cpf)).addTextChangedListener(new Formatter(findViewById(R.id.cpf)));
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_space, new DefaultFragment()).commit();
    }
}