package com.abdurrahmanjun.kotlin.restful.entity

import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "car_products")
data class ProductCar (
        @Id
        val id: String,
        @Column(name = "img")
        var img: String,
        @Column(name = "merk")
        var merk: String,
        @Column(name = "model")
        var model: String,
        @Column(name = "varian")
        var varian: String,
        @Column(name = "transmission")
        var transmission: String,
        @Column(name = "year")
        var year: String,
        @Column(name = "location")
        var location: String,
        @Column(name = "seller")
        var seller: String,
        @Column(name = "seller_phone")
        var sellerPhone: String,
        @Column(name = "created_at")
        var createdAt: Date,
        @Column(name = "updated_at")
        var updatedAt: Date?,
)