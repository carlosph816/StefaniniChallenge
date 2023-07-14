package com.caperezh.stefaninichallenge.data.model

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable

@Serializable
data class GridModel(val category: String = "Category 1",val image: String = "app1", val name: String = "App 1", val price: Double = 0.0, val rating: Int = 3, val developer: String = "Developer 1")
