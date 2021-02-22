package com.taghavi.expandablerecyclerview

data class StateCapital(
    val countries: List<Country>
) {
    data class Country(
        val country: String,
        val states: List<State>
    ) {
        data class State(
            val capital: String,
            val name: String
        )
    }
}