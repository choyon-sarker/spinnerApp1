package com.devdroid.spinner_lab_2

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val languages = resources.getStringArray(R.array.Languages_String)
        val textView: TextView=findViewById(R.id.tv_id)
        val button_id:Button=findViewById(R.id.button_id)

        val spinner:Spinner=findViewById(R.id.spinner_id)



        if(spinner!= null){
            val adapter1=ArrayAdapter(this,android.R.layout.simple_spinner_item,languages)
            spinner.adapter=adapter1

            spinner.onItemSelectedListener= object :
            AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    //Toast.makeText(this@MainActivity,getString(R.string.selected_item) + " " + languages[position],Toast.LENGTH_LONG).show()
                    //textView.text=getString(R.string.selected_item) +" "+ languages[position]
                    button_id.setOnClickListener {
                        //textView.text= languages[position]
                       textView.text= (getMenu(languages[position])).toString()
                    }
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
    }
}
    fun getMenu(meal: String): List<String> {
        val Menu: MutableList<String> = ArrayList()
        if (meal == "Kotlin") {
            Menu.add("1. JVM Compatibility")
            Menu.add("\n2. Concise Syntax")
            Menu.add("\n3. Null Safety")
            Menu.add("\n4. Modern Features")
            Menu.add("\n5. Multiplatform Development")

        } else if (meal == "Java") {
            Menu.add("1. Platform Independence")
            Menu.add("\n2. Object-Oriented")
            Menu.add("\n3. Rich API and Ecosystem")
            Menu.add("\n4. Performance")
            Menu.add("\n5. Strong Typing")
        }else if(meal =="Swift"){
            Menu.add("1. Modern Syntax")
            Menu.add("\n2. Safety and Performance")
            Menu.add("\n3. Interoperability with Objective-C")
            Menu.add("\n4. Playgrounds")
            Menu.add("\n5. Cross-Platform")
        }
        else if(meal=="C++"){
            Menu.add("1. Standard Template Library (STL)")
            Menu.add("\n2. Manual Memory Management")
            Menu.add("\n3. Object-Oriented and Generic Programming")
            Menu.add("\n4. Performance")
            Menu.add("\n5. Low-Level Programming")
        }
        else if(meal =="Perl"){
            Menu.add("1. Text Processing")
            Menu.add("\n2. Flexibility")
            Menu.add("\n3. CPAN Repository")
            Menu.add("\n4. Regular Expressions")
            Menu.add("\n5. Context Sensitivity")
        }
        return Menu
    }