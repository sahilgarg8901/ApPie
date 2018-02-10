package com.example.sahil.pie_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var List : MutableList<PieEntry> = mutableListOf(PieEntry(100f,"Math"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pieChart.holeRadius = 25f
        pieChart.centerText = "Report Card"
        pieChart.setCenterTextSize(10f)
        val dataSet = PieDataSet(List,"Marks")
        val data = PieData(dataSet)
        pieChart.data = data
        pieChart.invalidate()
    }
}
