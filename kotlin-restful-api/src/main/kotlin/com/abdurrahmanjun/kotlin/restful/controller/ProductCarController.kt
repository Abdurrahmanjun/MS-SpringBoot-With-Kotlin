package com.abdurrahmanjun.kotlin.restful.controller

import com.abdurrahmanjun.kotlin.restful.model.*
import com.abdurrahmanjun.kotlin.restful.services.ProductService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductCarController(val productService: ProductService) {

    @PostMapping(
            value = ["/api/car-products"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun createProductCar(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse> {
        val productResponse = productService.create(body)
        return WebResponse(
                code = 200,
                status = "OK",
                data = productResponse
        )
    }

    @GetMapping(
            value = ["/api/car-products/{idProduct}"],
            produces = ["application/json"],
    )
    fun getProductCar(@PathVariable("idProduct") id:String): WebResponse<ProductResponse> {
        val productResponse = productService.get(id)
        return WebResponse(
                code = 200,
                status = "OK",
                data = productResponse
        )
    }

    @PutMapping(
            value = ["/api/car-products/{idProduct}"],
            produces = ["application/json"],
            consumes = ["application/json"],
    )
    fun updateProductCar(@PathVariable("idProduct") id:String,
                      @RequestBody updateProductRequest: UpdateProductRequest ): WebResponse<ProductResponse> {
        val productResponse = productService.update(id, updateProductRequest)
        return WebResponse(
                code = 200,
                status = "OK",
                data = productResponse
        )
    }

    @DeleteMapping(
            value = ["/api/car-products/{idProduct}"],
            produces = ["application/json"],
    )
    fun deleteProductCar(@PathVariable("idProduct") id:String): WebResponse<String> {
        productService.delete(id)
        return WebResponse(
                code = 200,
                status = "OK",
                data = id
        )
    }

    @GetMapping(
            value = ["/api/car-products"],
            produces = ["application/json"],
    )
    fun listProductCar(@RequestParam(value = "size", defaultValue = "10") size: Int,
                    @RequestParam(value = "page", defaultValue = "0") page: Int): WebResponse<List<ProductResponse>> {
        val request = ListRequest(size,page)
        val productResponse = productService.list(request)
        return WebResponse(
                code = 200,
                status = "OK",
                data = productResponse
        )
    }

}