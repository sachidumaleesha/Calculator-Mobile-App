package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.calculator.models.Calculator

class MainActivity : AppCompatActivity() {

    lateinit var editNumber1: EditText
    lateinit var editNumber2:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNumber1 = findViewById(R.id.editText1)
        editNumber2 = findViewById(R.id.editText2)


    }

    fun buttonClick(v: View){
        var ans = 0.0
        val calculator = Calculator(
            editNumber1.text.toString().toDouble(),
            editNumber2.text.toString().toDouble())
        when(v.id){
            R.id.btnPlus -> ans = calculator.add()
            R.id.btnMinus -> ans = calculator.subtract()
            R.id.btnMultiply -> ans = calculator.multiply()
            R.id.btnDivide -> ans = calculator.divide()
        }

        //println(ans)

        val intent = Intent(this, secondActivity::class.java)
        intent.putExtra("answer", ans)
        startActivity(intent)
        finish()
    }


}