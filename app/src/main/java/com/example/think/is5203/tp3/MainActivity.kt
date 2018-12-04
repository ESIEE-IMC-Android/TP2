package com.example.think.is5203.tp3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.think.is5203.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), Observer {
    lateinit var calculette: Calculette
    override fun update(o: Observable?, arg: Any?) {
        updateView()
    }

    private fun updateView() {
        stack.text = calculette.toString()
        progress_bar.progress = calculette.size()
        if (calculette.isEmpty) {
            empilerBtn.isEnabled = true
            plusBtn.isEnabled = false
            subBtn.isEnabled = false
            mulBtn.isEnabled = false
            divBtn.isEnabled = false
            empBtn.isEnabled = false
        } else {
            plusBtn.isEnabled = true
            subBtn.isEnabled = true
            mulBtn.isEnabled = true
            divBtn.isEnabled = true
            empBtn.isEnabled = true
        }
        if (calculette.isFull) {
            empilerBtn.isEnabled = false
            plusBtn.isEnabled = false
            subBtn.isEnabled = false
            mulBtn.isEnabled = false
            divBtn.isEnabled = false
            empBtn.isEnabled = true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.calculette = Calculette()
        this.calculette.addObserver(this@MainActivity)
        progress_bar.max = calculette.capacity()
        updateView()

    }

    fun empiler(view: View) {
        try {
            calculette.enter(input.text.toString().toInt())
        } catch (e: CalculetteException) {
            e.printStackTrace()
        } catch (num: NumberFormatException) {
            Toast.makeText(this@MainActivity, num.message, Toast.LENGTH_LONG).show()
        }


    }

    fun plus(view: View) {
        try {
            calculette.add()
        } catch (e: CalculetteException) {
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
        }
    }

    fun subtract(view: View) {
        try {
            calculette.sub()
        } catch (e: CalculetteException) {
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
        }
    }

    fun multiply(view: View) {
        try {
            calculette.mul()
        } catch (e: CalculetteException) {
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
        }
    }

    fun divide(view: View) {
        try{
            calculette.div()}
        catch (e : CalculetteException){
            Toast.makeText(this@MainActivity,e.message,Toast.LENGTH_LONG).show()
        }
    }

    fun emptyAr(view: View) {
        try{
            calculette.clear()}
        catch (e : CalculetteException){
            Toast.makeText(this@MainActivity,e.message,Toast.LENGTH_LONG).show()
        }
    }

}
