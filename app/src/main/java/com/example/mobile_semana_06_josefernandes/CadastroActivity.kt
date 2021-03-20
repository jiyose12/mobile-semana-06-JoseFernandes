package com.example.mobile_semana_06_josefernandes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile_semana_06_josefernandes.classes.Desejo
import java.text.NumberFormat

class CadastroActivity : AppCompatActivity() {

    private lateinit var btCancelar: Button
    private lateinit var btCadastrar: Button
    private lateinit var txtDescricao: EditText
    private lateinit var txtValor: EditText
    private lateinit var desejo: Desejo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        setSupportActionBar(findViewById(R.id.toolbar))

        this.btCadastrar = findViewById(R.id.btCadastrar)
        this.btCadastrar.setOnClickListener({ clickBotaoCadastrar(it) })

        this.btCancelar = findViewById(R.id.btCancelar)
        this.btCancelar.setOnClickListener({ clickBotaoCancelar(it) })

        this.txtDescricao = findViewById(R.id.txtDescricao)
        this.txtValor = findViewById(R.id.txtValor)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun clickBotaoCancelar(it: View?) {
        val intent = Intent(this, MainActivity::class.java)
        setResult(Activity.RESULT_CANCELED, intent)
        finish()
    }

    fun clickBotaoCadastrar(view: View){
        this.desejo = Desejo(txtDescricao.getText().toString(),
            NumberFormat.getInstance().parse(txtValor.getText().toString()).toFloat()
        )
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("MSG_DESEJO", this.desejo)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}