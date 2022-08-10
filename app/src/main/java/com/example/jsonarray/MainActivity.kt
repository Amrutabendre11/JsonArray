package com.example.jsonarray

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.json.JSONObject

@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    var strJson = ("{ \"Employee\" :[{\"ID\":\"01\",\"Name\":\"Sam\",\"Salary\":\"50000\"},"
            + "{\"ID\":\"02\",\"Name\":\"Shankar\",\"Salary\":\"60000\"}] }")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "KotlinApp"
        textView = findViewById(R.id.textView)
        val data = StringBuilder()
        val jsonObject = JSONObject(strJson)
        val jsonArray = jsonObject.optJSONArray("Employee")
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            val id = jsonObject.optString("ID").toInt()
            val name = jsonObject.optString("Name")
            val salary = jsonObject.optString("Salary").toFloat()
            data.append("Employee ").append(i).append(" : \n ID= ") .append(id).append(" \n " + "Name= ") .append(name).append(" \n Salary= ") .append(salary).append(" \n\n ")
        }
        textView.text = data.toString()
    }
}