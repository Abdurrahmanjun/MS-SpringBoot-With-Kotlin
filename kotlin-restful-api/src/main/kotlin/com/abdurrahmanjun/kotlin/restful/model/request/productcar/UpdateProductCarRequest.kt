package com.abdurrahmanjun.kotlin.restful.model.request.productcar

import javax.validation.constraints.NotBlank

data class UpdateProductCarRequest (
        @field:NotBlank
        val img : String?,
        @field:NotBlank
        val merk : String?,
        @field:NotBlank
        val model : String?,
        @field:NotBlank
        val varian : String?,
        @field:NotBlank
        val transmission : String?,
        @field:NotBlank
        val year : String?,
        @field:NotBlank
        val location : String?,
        @field:NotBlank
        val seller : String?,
        @field:NotBlank
        val sellerPhone : String?,
)