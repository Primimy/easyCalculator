package com.pr.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var button0: Button? = null
    private var button1: Button? = null
    private var button2: Button? = null
    private var button3: Button? = null
    private var button4: Button? = null
    private var button5: Button? = null
    private var button6: Button? = null
    private var button7: Button? = null
    private var button8: Button? = null
    private var button9: Button? = null
    private var buttonAC: Button? = null
    private var buttonMinus: Button? = null
    private var buttonPercent: Button? = null
    private var buttonDivide: Button? = null
    private var buttonMultiply: Button? = null
    private var buttonSub: Button? = null
    private var buttonAdd: Button? = null
    private var buttonEqual: Button? = null
    private var buttonSqrt: Button? = null
    private var buttonDot: Button? = null
    private var textViewIn: TextView? = null
    private var textViewOut: TextView? = null

    private var stringInput = ""
    private var stringOutput = ""
    private var num1 = 0.0
    private var num2 = 0.0
    private var option = ""
    private var dotFlag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        button0 = findViewById<View>(R.id.button0) as Button
        button1 = findViewById<View>(R.id.button1) as Button
        button2 = findViewById<View>(R.id.button2) as Button
        button3 = findViewById<View>(R.id.button3) as Button
        button4 = findViewById<View>(R.id.button4) as Button
        button5 = findViewById<View>(R.id.button5) as Button
        button6 = findViewById<View>(R.id.button6) as Button
        button7 = findViewById<View>(R.id.button7) as Button
        button8 = findViewById<View>(R.id.button8) as Button
        button9 = findViewById<View>(R.id.button9) as Button
        buttonAC = findViewById<View>(R.id.buttonAC) as Button
        buttonMinus = findViewById<View>(R.id.buttonMinus) as Button
        buttonPercent = findViewById<View>(R.id.buttonPercent) as Button
        buttonDivide = findViewById<View>(R.id.buttonDivide) as Button
        buttonMultiply = findViewById<View>(R.id.buttonMultiply) as Button
        buttonSub = findViewById<View>(R.id.buttonSub) as Button
        buttonAdd = findViewById<View>(R.id.buttonAdd) as Button
        buttonEqual = findViewById<View>(R.id.buttonEqual) as Button
        buttonSqrt = findViewById<View>(R.id.buttonSqrt) as Button
        buttonDot = findViewById<View>(R.id.buttonDot) as Button
        textViewIn = findViewById<View>(R.id.textViewIn) as TextView
        textViewOut = findViewById<View>(R.id.textViewOut) as TextView

        button0!!.setOnClickListener(this)
        button1!!.setOnClickListener(this)
        button2!!.setOnClickListener(this)
        button3!!.setOnClickListener(this)
        button4!!.setOnClickListener(this)
        button5!!.setOnClickListener(this)
        button6!!.setOnClickListener(this)
        button7!!.setOnClickListener(this)
        button8!!.setOnClickListener(this)
        button9!!.setOnClickListener(this)
        buttonAC!!.setOnClickListener(this)
        buttonMinus!!.setOnClickListener(this)
        buttonPercent!!.setOnClickListener(this)
        buttonDivide!!.setOnClickListener(this)
        buttonMultiply!!.setOnClickListener(this)
        buttonSub!!.setOnClickListener(this)
        buttonAdd!!.setOnClickListener(this)
        buttonEqual!!.setOnClickListener(this)
        buttonSqrt!!.setOnClickListener(this)
        buttonDot!!.setOnClickListener(this)
        textViewIn!!.setOnClickListener(this)
        textViewOut!!.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.button0,
                R.id.button1,
                R.id.button2,
                R.id.button3,
                R.id.button4,
                R.id.button5,
                R.id.button6,
                R.id.button7,
                R.id.button8,
                R.id.button9 -> {
                    stringInput += (v as Button).text.toString()
                    textViewIn!!.text = stringInput
                }
                R.id.buttonDot -> {
                    if (!dotFlag) {
                        dotFlag = true
                        stringInput += "."
                        textViewIn!!.text = stringInput
                    }
                }
                R.id.buttonDivide -> {
                    if (textViewIn!!.text.toString() != "") {
                        num1 = textViewIn!!.text.toString().toDouble()
                        option = "divide"
                        stringInput += "/"
                        textViewIn!!.text = stringInput
                        stringInput = ""
                        dotFlag = false
                    }
                }
                R.id.buttonMultiply -> {
                    if (textViewIn!!.text.toString() != "") {
                        num1 = textViewIn!!.text.toString().toDouble()
                        option = "multiply"
                        stringInput += "×"
                        textViewIn!!.text = stringInput
                        stringInput = ""
                        dotFlag = false
                    }
                }
                R.id.buttonSub -> {
                    if (textViewIn!!.text.toString() != "") {
                        num1 = textViewIn!!.text.toString().toDouble()
                        option = "sub"
                        stringInput += "-"
                        textViewIn!!.text = stringInput
                        stringInput = ""
                        dotFlag = false
                    }
                }
                R.id.buttonAdd -> {
                    if (textViewIn!!.text.toString() != "") {
                        num1 = textViewIn!!.text.toString().toDouble()
                        option = "add"
                        stringInput += "+"
                        textViewIn!!.text = stringInput
                        stringInput = ""
                        dotFlag = false
                    }
                }
                R.id.buttonSqrt -> {
                    if (textViewIn!!.text.toString() == "") {
                        stringOutput = "请先输入数"
                        textViewOut!!.text = stringOutput
                    } else {
                        num1 = textViewIn!!.text.toString().toDouble()
                        if (num1 >= 0) {
                            stringOutput = sqrt(num1).toString()
                        } else {
                            Toast.makeText(this, "开方数需要不小于0", Toast.LENGTH_SHORT).show()
                        }
                        option = "sqrt"
                        stringInput = "√$stringInput"
                        textViewIn!!.text = stringInput
                    }
                    dotFlag = false
                }
                R.id.buttonPercent -> {
                    if (option == "") {
                        if (textViewIn!!.text.toString() != "")
                            num1 = textViewIn!!.text.toString().toDouble() * 0.01
                        stringInput = num1.toString()
                    } else {
                        if (textViewIn!!.text.toString() != "")
                            num2 = textViewIn!!.text.toString().toDouble() * 0.01
                        stringInput = num2.toString()
                    }
                    textViewIn!!.text = stringInput
                }
                R.id.buttonAC -> {
                    ac()
                    textViewIn!!.text = ""
                    textViewOut!!.text = ""
                }
                R.id.buttonMinus -> {
                    if (textViewIn!!.text.toString() != "") {
                        if (option == "") {
                            if (textViewIn!!.text.toString() != "")
                                num1 = textViewIn!!.text.toString().toDouble() * -1
                            stringInput = num1.toString()
                        } else {
                            if (textViewIn!!.text.toString() != "")
                                num2 = textViewIn!!.text.toString().toDouble() * -1
                            stringInput = num2.toString()
                        }
                        textViewIn!!.text = stringInput
                    } else {
                        textViewIn!!.text = "-"
                        stringInput = "-"
                    }
                }
                R.id.buttonEqual -> {
                    if (option == "sqrt") {
                        textViewOut!!.text = stringOutput
                    } else if (option == "") {
                        if (textViewIn!!.text.toString() == "") {
                            textViewOut!!.text = textViewIn!!.text.toString()
                        }
                    } else {
                        num2 = stringInput.toDouble()
                        when (option) {
                            "add" -> stringOutput = (num1 + num2).toString()
                            "sub" -> stringOutput = (num1 - num2).toString()
                            "multiply" -> stringOutput = (num1 * num2).toString()
                            "divide" -> {
                                if (num2 == 0.0) {
                                    Toast.makeText(this, "除数不能为0", Toast.LENGTH_SHORT).show()
                                    ac()
                                } else {
                                    stringOutput = (num1 / num2).toString()
                                }
                            }
                        }
                        textViewOut!!.text = stringOutput
                    }
                    ac()
                }
            }
        }
    }

    private fun ac() {
        stringInput = ""
        stringOutput = ""
        num1 = 0.0
        num2 = 0.0
        option = ""
        dotFlag = false
    }
}

