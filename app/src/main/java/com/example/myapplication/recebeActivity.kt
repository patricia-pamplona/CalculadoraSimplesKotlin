package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class recebeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recebe)
        //pegando valores recebidos como parâmetros
        val params = intent.extras
        val label = params?.getString("label")
        val valor = params?.getInt("valor")

        val textViewLabel = findViewById<TextView>(R.id.textViewLabel)
        val editTextVariavel = findViewById<TextView>(R.id.editTextVariavel)
        //setando valores recebidos para a Activity
        textViewLabel.text = label
        editTextVariavel.setText(valor.toString())

        val buttonOk = findViewById<Button>(R.id.buttonOk)
        val buttonCancelar = findViewById<Button>(R.id.buttonCancelar)

        buttonOk.setOnClickListener {
            val intent = Intent()
            val bundle = Bundle()

            val editTextVariavel = findViewById<EditText>(R.id.editTextVariavel)

            bundle.putInt("VALOR", editTextVariavel.text.toString().toInt())
            intent.putExtras(bundle)

            setResult(RESULT_OK, intent)
            onBackPressed()
        }

        buttonCancelar.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}