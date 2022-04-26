package com.abdurrahmanjun.kotlin.restful.model.request.productcar

import java.util.*

data class ProductCarResponse(
        val id: String,
        var img: String,
        var merk: String,
        var model: String,
        var varian: String,
        var transmission: String,
        var year: String,
        var location: String,
        var seller: String,
        var sellerPhone: String,
        var createdAt: Date,
        var updatedAt: Date?,
)
