package com.abdurrahmanjun.kotlin.restful.services

import com.abdurrahmanjun.kotlin.restful.model.ListRequest
import com.abdurrahmanjun.kotlin.restful.model.request.productcar.CreateProductCarRequest
import com.abdurrahmanjun.kotlin.restful.model.request.productcar.ProductCarResponse
import com.abdurrahmanjun.kotlin.restful.model.request.productcar.UpdateProductCarRequest

interface ProductCarService {

    fun create(createProductRequest: CreateProductCarRequest): ProductCarResponse
    fun get(id: String): ProductCarResponse
    fun update(id: String, updateProductCarRequest: UpdateProductCarRequest): ProductCarResponse
    fun delete(id: String)
    fun list(listRequest: ListRequest): List<ProductCarResponse>

}