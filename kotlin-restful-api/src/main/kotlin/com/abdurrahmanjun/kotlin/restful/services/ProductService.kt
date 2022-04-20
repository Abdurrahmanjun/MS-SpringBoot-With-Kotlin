package com.abdurrahmanjun.kotlin.restful.services

import com.abdurrahmanjun.kotlin.restful.model.CreateProductRequest
import com.abdurrahmanjun.kotlin.restful.model.ProductResponse

interface ProductService {

    fun create(createProductRequest: CreateProductRequest): ProductResponse

}