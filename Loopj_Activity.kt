package kurtis.rx.androidexamples

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_loopj_.*

/**
 * Created on Android Studio
 * Author: Umesh
 * DATE: 8/6/2018
 * TIME :9:56 AM.
 * DAY: Monday
 * Project: rxandroidexamples
 */
class Loopj_Activity : AppCompatActivity(), View.OnClickListener {
    var loopjClass: LoopjClass? = null
    var context:Context?=null
    override fun onClick(p0: View?) {
        val searchTerm = etSearchTerms.text.toString()
        etSearchTerms.setText("")
        // make Loopj HTTP call
        loopjClass!!.executeLoopjCall(context!! ,searchTerm)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loopj_)
        btnSearch.setOnClickListener(this)
        loopjClass = LoopjClass()
        context=this
    }
}
