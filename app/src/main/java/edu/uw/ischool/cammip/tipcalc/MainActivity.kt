package edu.uw.ischool.cammip.tipcalc

import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.text.TextWatcher

class MainActivity : AppCompatActivity() {
    lateinit var myButton: Button
    lateinit var editText: EditText

    val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val strFill : String = editText.text.toString()
            myButton.isEnabled = (strFill.length > 0)
        }

        override fun afterTextChanged(s: Editable?) {
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //need to undisable the button when editText is not empty
        myButton = findViewById(R.id.myButton)
        editText = findViewById(R.id.editText)


        editText.addTextChangedListener(textWatcher)

        myButton.setOnClickListener {
            calculateTip()
        }
    }

    fun calculateTip() {
        val textFromEdit = editText.text.toString()
        val intValue = textFromEdit.toDoubleOrNull()

        if (intValue != null) {
            val tip = intValue * 0.15
            val formattedValue = String.format("$%.2f", tip)

            val toast = Toast.makeText(this@MainActivity, formattedValue, Toast.LENGTH_LONG)
            toast.show()
        }
    }}