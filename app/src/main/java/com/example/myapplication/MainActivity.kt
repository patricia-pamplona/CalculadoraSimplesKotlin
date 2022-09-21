package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    var variavelX: Int = 0;
    var variavelY: Int = 0;
    var resultado: Int = 0;

    val setVariavelXLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
                if(result.resultCode == RESULT_OK){
                        variavelX = result.data!!.getIntExtra("VALOR", 0)
                        val textViewVariavelX = findViewById<TextView>(R.id.textViewX)
                        textViewVariavelX.text = "${variavelX}"
                }else{
                    Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
                }
    }

    val setVariavelYLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == RESULT_OK){
            variavelY = result.data!!.getIntExtra("VALOR", 0)
            val textViewVariavelY = findViewById<TextView>(R.id.textViewY)
            textViewVariavelY.text = "${variavelY}"
        }else{
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewX = findViewById<TextView>(R.id.textViewX);
        val textViewY = findViewById<TextView>(R.id.textViewY);
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado);

        val buttonSetVariavelX = findViewById<Button>(R.id.buttonSetVariavelX);
        val buttonSetVariavelY = findViewById<Button>(R.id.buttonSetVariavelY);
        val buttonCalcular = findViewById<Button>(R.id.buttonCalcular);

        textViewX.text = "${variavelX}"
        textViewY.text = "${variavelY}"
        textViewResultado.text = "${resultado}"

        buttonSetVariavelX.setOnClickListener{
            val intent = Intent(this, recebeActivity::class.java)

            val bundle: Bundle = Bundle()
            bundle.putString("label", "Variável X:")
            bundle.putInt("valor", variavelX)
            intent.putExtras(bundle)

            setVariavelXLauncher.launch(intent)
        }

        buttonSetVariavelY.setOnClickListener {
            val intent = Intent(this, recebeActivity::class.java)

            val bundle: Bundle = Bundle()
            bundle.putString("label", "Variável Y:")
            bundle.putInt("valor", variavelY)
            intent.putExtras(bundle)

            setVariavelYLauncher.launch(intent)

        }
        buttonCalcular.setOnClickListener {
            resultado = variavelX + variavelY
            textViewResultado.text = "${resultado}"
            Toast.makeText(this, getString(R.string.calcular), Toast.LENGTH_SHORT).show()
        }

    }
}