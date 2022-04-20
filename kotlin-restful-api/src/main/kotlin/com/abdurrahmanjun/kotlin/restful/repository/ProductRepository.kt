package com.abdurrahmanjun.kotlin.restful.repository

import com.abdurrahmanjun.kotlin.restful.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, String> {

}