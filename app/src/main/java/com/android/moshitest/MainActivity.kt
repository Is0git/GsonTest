package com.android.moshitest

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layout:LinearLayout = findViewById(R.id.main)
        val textview:TextView = TextView(this)
        textview.text = "Sup"
        layout.addView(textview)
        val pojo = Pojo("Sup", 1)

        val mosh = Moshi.Builder().build()
        val jsonAdapter:JsonAdapter<Pojo> = mosh.adapter(Pojo::class.java)
        var value:String = jsonAdapter.toJson(pojo)
        var ss:Pojo? = jsonAdapter.fromJson(value)
        textview.text = pojo.toString()
    }
}
infix fun Pojo.doit(name:Int) {

}