package com.newdllano.convertidor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var selectedOption: Int=0
  //  private var temperatura: String=""
    private var resultado: Double = 0.0
    private var value: String =""
    private lateinit var total: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val resultado = findViewById<TextView>(R.id.txtv)
        val option = findViewById<Spinner>(R.id.spinner2)
        val temp = findViewById<EditText>(R.id.editTextNumberDecimal)
        total = findViewById(R.id.txtv)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener{
            value = temp.text.toString()
            conversion(selectedOption)

        }
        if(option !=null){

            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                resources.getStringArray(R.array.Convert_options)

            )
            option.adapter = adapter
            option.onItemSelectedListener = object:
                AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                    selectedOption = position
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
    }
    private fun conversion(option: Int) {
       when(option){
           0 -> {
               resultado = (value.toDouble() * 9/5) + 32
               total.text = resultado.toString()
           }
           1 ->{
               resultado = (value.toDouble() + 273.15)
               total.text = resultado.toString()
           }
           2 ->{
               resultado = (value.toDouble() - 32) * 5/9
               total.text = resultado.toString()
           }
           3 ->{
               resultado = (value.toDouble() * 9/5) + 32
               total.text = resultado.toString()
           }
           4 ->{
               resultado = (value.toDouble() * -273.15) + 32
               total.text = resultado.toString()
           }
           5 ->{
               resultado = (value.toDouble() * 9/5) -459.67
               total.text = resultado.toString()
           }
       }
    }
}