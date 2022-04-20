package com.abdurrahmanjun.kotlin.restful.validation

import org.springframework.stereotype.Component
import javax.validation.ConstraintViolationException
import javax.validation.Validator

@Component
class ValidationUtil(val validator: Validator) {

    fun validate(any: Any): Unit {
        val result = validator.validate(any)
        if (result.size !=0) {
            throw ConstraintViolationException(result)
        }
    }
}