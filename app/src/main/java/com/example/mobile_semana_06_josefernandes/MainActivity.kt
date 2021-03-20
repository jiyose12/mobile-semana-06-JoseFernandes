package com.example.mobile_semana_06_josefernandes

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.example.mobile_semana_06_josefernandes.classes.Desejo
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var btAdd: FloatingActionButton
    private lateinit var lvDesejos: ListView
    private lateinit var lista: ArrayList<Desejo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lista = ArrayList()

        this.btAdd = findViewById(R.id.floatingActionButton)
        this.lvDesejos = findViewById(R.id.lvDesejos)

        val layout = android.R.layout.simple_list_item_1
        this.lvDesejos.adapter = ArrayAdapter<Desejo>(this, layout ,this.lista)

        this.btAdd.setOnClickListener({ clickBAddDesejo(it) })
    }

    private fun addDesejo(desejo: Desejo){
        (this.lvDesejos.adapter as ArrayAdapter<Desejo>).add(desejo)
    }

    fun clickBAddDesejo(view: View){
        val intent = Intent(this, CadastroActivity::class.java)
        startActivityForResult(intent, 1)
    }
    // é automaticamente executado quando realizada chamada forResult
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == 1){
                val desejo: Desejo = data?.getSerializableExtra("MSG_DESEJO") as Desejo
                    addDesejo(desejo)
                Log.i("APP_DESEJO", desejo.toString())
            }
        }else if (resultCode == Activity.RESULT_CANCELED){
            Log.i("APP_DESEJO", "Voltou: " + "Voltou pelo dispositivo ou botao cancelar")
        }
    }
}