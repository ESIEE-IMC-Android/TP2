package com.example.think.tp2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main2.*

class LogicielsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)
        dialBtn.setOnClickListener {

            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + dial_number_edit.text.toString()))
            startActivity(intent)
        }
        webBtn.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://" + web_edit.text.toString()))
            startActivity(intent)
        }
        loginBtn.setOnClickListener {

            val intent = Intent()
            intent.action = "login.ACTION"
            startActivityForResult(intent, 123)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 123 && resultCode == Activity.RESULT_OK && data!=null) {
            Toast.makeText(this,data.getStringExtra("response"),Toast.LENGTH_LONG).show()
            }
        }


}
