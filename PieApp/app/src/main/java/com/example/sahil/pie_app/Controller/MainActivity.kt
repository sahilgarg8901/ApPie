package com.example.sahil.pie_app.Controller

import android.graphics.Color
import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.util.Range
import android.view.View
import android.widget.Toast
import com.example.sahil.pie_app.R
import com.example.sahil.pie_app.Utilities.ColorKey
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.text.ParseException


class MainActivity : AppCompatActivity() {
    var GoodOrNot : Boolean = true
    var EntryColor : FloatArray = FloatArray(2)
    var List : MutableList<PieEntry> = mutableListOf()
    private var colors : ArrayList<Int> = arrayListOf(Color.GREEN,Color.RED)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pieChart.holeRadius = 25f
        pieChart.centerText = "Rating"
        pieChart.description.text = "Product Quality"
        pieChart.description.textAlign = Paint.Align.RIGHT
        pieChart.setCenterTextSize(15f)
        pieChart.setTransparentCircleAlpha(0)
        pieChart.isRotationEnabled = true
        pieChart.setHoleColor(Color.TRANSPARENT)
        pieChart.setCenterTextColor(Color.CYAN)
        pieChart.setDrawEntryLabels(true)
        pieChart.setEntryLabelTextSize(15f)

        pieChart.legend.form = Legend.LegendForm.SQUARE
        if (savedInstanceState != null) {
            EntryColor = savedInstanceState.getFloatArray(ColorKey)
        } else {
            EntryColor[0] = 50f
            EntryColor[1] = 50f
        }
        createPie()
    }
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putFloatArray(ColorKey,EntryColor)
    }
    fun goodBtnClicked(view : View){
        if (FloatValue.text.isEmpty()){
            Toast.makeText(this, "Enter Some Value", Toast.LENGTH_SHORT).show()
        } else if(getFloatFrom(FloatValue.text) !in Range(1f,99f)){
            Toast.makeText(this, "Enter between 1 to 99", Toast.LENGTH_SHORT).show()
            FloatValue.text = null
        } else {
            List.clear()
            EntryColor[0] =  getFloatFrom(FloatValue.text)
            EntryColor[1] = 100 - EntryColor[0]
            Log.d("check", EntryColor.toString())
            FloatValue.text = null
            createPie()
        }
    }
    private fun createPie(){

        List.add(PieEntry(EntryColor[0], "Good"))
        List.add(PieEntry(EntryColor[1], "Not Good"))
        val dataSet = PieDataSet(List, "Percentage")
        dataSet.sliceSpace = 2f
        dataSet.valueTextSize = 12f
        dataSet.colors = this.colors
        val data = PieData(dataSet)
        pieChart.data = data
        pieChart.invalidate()
    }
    private fun getFloatFrom(txt : Editable) : Float {
        try {
            return NumberFormat.getInstance().parse(txt.toString()).toFloat()
        } catch (e : ParseException) {
            return 0f
        }
    }
}

