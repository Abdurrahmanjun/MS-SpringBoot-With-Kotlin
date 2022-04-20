package com.abdurrahmanjun.kotlin.restful.services.impl

import com.abdurrahmanjun.kotlin.restful.entity.Product
import com.abdurrahmanjun.kotlin.restful.model.CreateProductRequest
import com.abdurrahmanjun.kotlin.restful.model.ProductResponse
import com.abdurrahmanjun.kotlin.restful.repository.ProductRepository
import com.abdurrahmanjun.kotlin.restful.services.ProductService
import com.abdurrahmanjun.kotlin.restful.validation.ValidationUtil
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl(
        val productRepository: ProductRepository,
        val validationUtil: ValidationUtil
) : ProductService {

    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        validationUtil.validate(createProductRequest)

        val product = Product(
                id = createProductRequest.id!!,
                name = createProductRequest.name!!,
                price = createProductRequest.price!!,
                quantity = createProductRequest.quantity!!,
                createdAt = Date(),
                updatedAt = null
        )

        return ProductResponse(
                id = product.id,
                name = product.name,
                price = product.price,
                quantity = product.quantity,
                createdAt = product.createdAt,
                updatedAT = product.updatedAt)
    }

}