package com.dps.kotlin

data class SoftwareEngineer
(
        val name: String,
        val title: String,
        val image: String
) {
    constructor() : this("","","")
}
