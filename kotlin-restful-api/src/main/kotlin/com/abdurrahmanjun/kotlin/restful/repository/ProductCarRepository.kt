package com.abdurrahmanjun.kotlin.restful.repository

import com.abdurrahmanjun.kotlin.restful.entity.Product
import com.abdurrahmanjun.kotlin.restful.entity.ProductCar
import org.springframework.data.jpa.repository.JpaRepository

interface ProductCarRepository : JpaRepository<ProductCar, String> {

}