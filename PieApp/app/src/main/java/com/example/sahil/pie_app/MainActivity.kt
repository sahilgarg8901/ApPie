package com.example.sahil.pie_app

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.renderer.scatter.CircleShapeRenderer
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var List : MutableList<PieEntry> = mutableListOf()
    var Data : ArrayList<XYData> = arrayListOf(XYData(40f,"Math"),
            XYData(20f,"Science"), XYData(30f,"English"),
            XYData(15f,"Hindi"),XYData(25f,"Computer"))
    var colors : ArrayList<Int> = arrayListOf(Color.BLUE,Color.GREEN,Color.CYAN,Color.GRAY,Color.RED)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pieChart.holeRadius = 25f
        pieChart.centerText = "Report Card"
        pieChart.description.text = "Marks in Subjects by Students"
        pieChart.setCenterTextSize(10f)
        pieChart.setTransparentCircleAlpha(0)
        pieChart.isRotationEnabled = true
        pieChart.setHoleColor(Color.TRANSPARENT)
        pieChart.setCenterTextColor(Color.RED)
        pieChart.setDrawEntryLabels(true)
        pieChart.setEntryLabelTextSize(15f)
        for (a in Data){
            List.add(PieEntry(a.yData,a.xData))
        }

        val dataSet = PieDataSet(List,"Marks")
        dataSet.sliceSpace = 2f
        dataSet.valueTextSize = 12f
        dataSet.colors = colors
        val data = PieData(dataSet)
        pieChart.data = data

        pieChart.legend.form = Legend.LegendForm.CIRCLE
        pieChart.legend.position = Legend.LegendPosition.BELOW_CHART_LEFT

        pieChart.invalidate()

    }
}

data class XYData (val yData : Float, val xData : String)