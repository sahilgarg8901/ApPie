package com.example.sahil.pie_app.Controller

import android.graphics.Color
import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.sahil.pie_app.R
import com.example.sahil.pie_app.Utilities.ColorKey
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {
    var GoodOrNot : Boolean = true
    var EntryColor : FloatArray = FloatArray(2)
    var List : MutableList<PieEntry> = mutableListOf()
    /*var Data : ArrayList<XYData> = arrayListOf(XYData(40f, "Math"),
            XYData(20f, "Science"))*/
    private var colors : ArrayList<Int> = arrayListOf(Color.GREEN,Color.RED)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pieChart.holeRadius = 25f
        pieChart.centerText = "Rating"
        pieChart.description.text = "Product Quality"
        pieChart.description.textAlign = Paint.Align.RIGHT
        pieChart.setCenterTextSize(10f)
        pieChart.setTransparentCircleAlpha(0)
        pieChart.isRotationEnabled = true
        pieChart.setHoleColor(Color.TRANSPARENT)
        pieChart.setCenterTextColor(Color.YELLOW)
        pieChart.setDrawEntryLabels(true)
        pieChart.setEntryLabelTextSize(15f)

        pieChart.legend.form = Legend.LegendForm.SQUARE
        pieChart.legend.position = Legend.LegendPosition.BELOW_CHART_LEFT

        /*for (a in Data){
            List.add(PieEntry(a.yData,a.xData))
        }*/
        if (savedInstanceState != null) {
            EntryColor = savedInstanceState.getFloatArray(ColorKey)
        } else {
            EntryColor[0] = 50f
            EntryColor[1] = 50f
        }
       /* List.add(PieEntry(EntryColor[0], "Good"))
        List.add(PieEntry(EntryColor[1], "Not Good"))
        val dataSet = PieDataSet(List, "Percentage")
        dataSet.sliceSpace = 2f
        dataSet.valueTextSize = 12f
        dataSet.colors = colors
        val data = PieData(dataSet)
        pieChart.data = data
        pieChart.invalidate()*/
        createPie()
    }
    fun goodBtnClicked(view : View){
        if (FloatValue.toString().isEmpty()){
            Toast.makeText(this, "Enter Some Value", Toast.LENGTH_SHORT).show()
        } else {

        }
    }
    private fun createPie(){

        List.add(PieEntry(EntryColor[0], "Good"))
        List.add(PieEntry(EntryColor[1], "Not Good"))
        val dataSet = PieDataSet(List, "Percentage")
        dataSet.sliceSpace = 2f
        dataSet.valueTextSize = 12f
        dataSet.colors = colors
        val data = PieData(dataSet)
        pieChart.data = data
        pieChart.invalidate()
    }
}

