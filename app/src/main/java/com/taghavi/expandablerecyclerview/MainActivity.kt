package com.taghavi.expandablerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.taghavi.expandablerecyclerview.ExpandableCountryModel.Companion.PARENT
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var countryStateExpandableAdapter: CountryStateExpandableAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val expandableCountryStateList: ArrayList<ExpandableCountryModel> = ArrayList()
        expandableCountryStateList.add(
            ExpandableCountryModel(
                PARENT,
                StateCapital.Country(
                    "Iran",
                    arrayListOf(
                        StateCapital.Country.State("Tehran", "Tehran"),
                        StateCapital.Country.State("Sari", "Mazandaran")
                    )
                )
            )
        )

        countryStateExpandableAdapter = CountryStateExpandableAdapter(
            this,
            expandableCountryStateList
        )

        countryStateExpandableAdapter?.let {
            val layoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = it
            recyclerView.addItemDecoration(
                DividerItemDecoration(
                    this,
                    DividerItemDecoration.VERTICAL
                )
            )
            it.notifyDataSetChanged()
        }
    }
}