package com.abdurrahmanjun.kotlin.restful.model.request.productcar

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CreateProductCarRequest (
        @field:NotBlank
        val id : String?,
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