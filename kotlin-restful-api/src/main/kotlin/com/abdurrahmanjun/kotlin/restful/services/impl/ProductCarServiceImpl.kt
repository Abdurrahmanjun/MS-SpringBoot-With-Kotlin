package com.abdurrahmanjun.kotlin.restful.services.impl

import com.abdurrahmanjun.kotlin.restful.entity.ProductCar
import com.abdurrahmanjun.kotlin.restful.error.NotFoundException
import com.abdurrahmanjun.kotlin.restful.model.ListRequest
import com.abdurrahmanjun.kotlin.restful.model.request.productcar.CreateProductCarRequest
import com.abdurrahmanjun.kotlin.restful.model.request.productcar.ProductCarResponse
import com.abdurrahmanjun.kotlin.restful.model.request.productcar.UpdateProductCarRequest
import com.abdurrahmanjun.kotlin.restful.repository.ProductCarRepository
import com.abdurrahmanjun.kotlin.restful.services.ProductCarService
import com.abdurrahmanjun.kotlin.restful.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class ProductCarServiceImpl(
        val productCarRepository: ProductCarRepository,
        val validationUtil: ValidationUtil
) : ProductCarService {

    override fun create(createProductCarRequest: CreateProductCarRequest): ProductCarResponse {
        validationUtil.validate(createProductCarRequest)

        val product = ProductCar(
                id = createProductCarRequest.id!!,
                img = createProductCarRequest.img!!,
                merk = createProductCarRequest.merk!!,
                model = createProductCarRequest.model!!,
                varian = createProductCarRequest.varian!!,
                transmission = createProductCarRequest.transmission!!,
                year = createProductCarRequest.year!!,
                location = createProductCarRequest.location!!,
                seller = createProductCarRequest.seller!!,
                sellerPhone = createProductCarRequest.sellerPhone!!,
                createdAt = Date(),
                updatedAt = null
        )
        productCarRepository.save(product)

        return convertProductToProductCarResponse(product)
    }

    override fun get(id: String): ProductCarResponse {
        val product = productCarRepository.findByIdOrNull(id)
        if (product == null) {
            throw NotFoundException()
        } else {
            return convertProductToProductCarResponse(product)
        }
    }

    override fun update(id: String, updateProductCarRequest: UpdateProductCarRequest): ProductCarResponse {
        validationUtil.validate(updateProductCarRequest)
        val product = productCarRepository.findByIdOrNull(id) ?: throw NotFoundException()

        product.apply {
            img = updateProductCarRequest.img!!
            merk = updateProductCarRequest.merk!!
            model = updateProductCarRequest.model!!
            varian = updateProductCarRequest.varian!!
            transmission = updateProductCarRequest.transmission!!
            year = updateProductCarRequest.year!!
            location = updateProductCarRequest.location!!
            seller = updateProductCarRequest.seller!!
            sellerPhone = updateProductCarRequest.sellerPhone!!
            updatedAt = Date()
        }
        productCarRepository.save(product)

        return convertProductToProductCarResponse(product)
    }

    override fun delete(id: String) {
        val product = productCarRepository.findByIdOrNull(id) ?: throw NotFoundException()
        productCarRepository.delete(product)
    }

    override fun list(listRequest: ListRequest): List<ProductCarResponse> {
        val page = productCarRepository.findAll(PageRequest.of(listRequest.page, listRequest.size))
        val products = page.get().collect(Collectors.toList())

        return products.map { convertProductToProductCarResponse(it) }
    }

    private fun convertProductToProductCarResponse(productCar: ProductCar) : ProductCarResponse {
        return ProductCarResponse(
                id = productCar.id,
                img = productCar.img,
                merk = productCar.merk,
                model = productCar.model,
                varian = productCar.varian,
                transmission = productCar.transmission,
                year = productCar.year,
                location = productCar.location,
                seller = productCar.seller,
                sellerPhone = productCar.sellerPhone,
                createdAt = productCar.createdAt,
                updatedAt = productCar.updatedAt
        )
    }

}