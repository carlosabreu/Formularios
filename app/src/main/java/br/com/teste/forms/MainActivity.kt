package br.com.teste.forms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.teste.forms.utils.Formatter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val intent = Intent(this, MainActivityJava::class.java)
            intent.putExtra("Nome", name.text.toString())
            startActivityForResult(intent, 1234)
        }

        cpf.addTextChangedListener(Formatter(cpf))
        supportFragmentManager.beginTransaction().replace(R.id.fragment_space, FragmentoBonitinho()).commit()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1234) {
            if (resultCode == 12) {
                Toast.makeText(this, "Chegou o resultado", Toast.LENGTH_SHORT).show()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}