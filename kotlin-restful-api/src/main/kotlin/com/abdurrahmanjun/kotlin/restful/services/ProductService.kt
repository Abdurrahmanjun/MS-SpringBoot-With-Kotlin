package com.abdurrahmanjun.kotlin.restful.services

import com.abdurrahmanjun.kotlin.restful.model.CreateProductRequest
import com.abdurrahmanjun.kotlin.restful.model.ListProductRequest
import com.abdurrahmanjun.kotlin.restful.model.ProductResponse
import com.abdurrahmanjun.kotlin.restful.model.UpdateProductRequest

interface ProductService {

    fun create(createProductRequest: CreateProductRequest): ProductResponse
    fun get(id: String): ProductResponse
    fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse
    fun delete(id: String)
    fun list(listProductRequest: ListProductRequest): List<ProductResponse>

}