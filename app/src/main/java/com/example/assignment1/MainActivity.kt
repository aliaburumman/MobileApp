package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.btn)
        val ed1 : EditText = findViewById(R.id.weight)
        val ed2 : EditText = findViewById(R.id.height)
        val ed3 : EditText = findViewById(R.id.age)
        val res: TextView = findViewById(R.id.txtV)


        var flag : String = "Men"
        val spinnerV: Spinner =findViewById(R.id.spinner)
        var options = arrayOf("Men","Women")
        spinnerV.adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
button.setOnClickListener{ view ->
    var x: Int = ed1.text.toString().toInt();
    var y: Int = ed2.text.toString().toInt();
    var z: Int = ed3.text.toString().toInt();

    if(flag=="Men")
        res.text= BmrMen(x,y,z).toString()
        else
            res.text= BmrWomen(x,y,z).toString()



}
        spinnerV.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2) //p2 is the index of selected item
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}
public fun BmrMen(weight: Int,height: Int,age: Int): Double
{
    return 1.2*(10 * weight + 6.25 * height - 5 * age + 5)
}

public fun BmrWomen(weight: Int,height: Int,age: Int): Double {
    return 1.2*(10 * weight + 6.25 * height - 5 * age - 161)
}