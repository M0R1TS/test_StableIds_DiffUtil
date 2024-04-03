package ru.devsokovix.test_stableids_diffutil

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DiffUtil
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        fun mixing() {
            val adapter = (recyclerView.adapter as MyAdapter)
            val newList = Array(30) {
                i - > i + 1
            }
            val r = Random(System.currentTimeMillis())
            for (i in newList.indices) {
                val newI = r.nextInt(adapter.data.size)
                val temp = newList[i]
                newList[i] = newList[newI]
                newList[newI] = temp
            }
            val oldList = adapter.data
            val numbersDiff = NumbersDiff(oldList, newList)
            val diffResult = DiffUtil.calculateDiff(numbersDiff)
            adapter.data = newList
            diffResult.dispatchUpdatesTo(adapter)
        }

        val refresh = findViewById <Button> (R.id.refresh)
        refresh.setOnClickListener {
            mixing()
        }
    }
}