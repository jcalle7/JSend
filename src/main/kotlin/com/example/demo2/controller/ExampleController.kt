package com.example.demo2.controller

import com.example.demo2.response.JSendResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ExampleController {

    @GetMapping("/success")
    fun getSuccessResponse(): ResponseEntity<JSendResponse<String>> {
        val response = JSendResponse(
            status = "success",
            data = "This is a successful response"
        )
        return ResponseEntity.ok(response)
    }

    @GetMapping("/fail")
    fun getFailResponse(): ResponseEntity<JSendResponse<Map<String, String>>> {
        val failData = mapOf("field" to "Invalid value")
        val response = JSendResponse(
            status = "fail",
            data = failData
        )
        return ResponseEntity.badRequest().body(response)
    }

    @GetMapping("/error")
    fun getErrorResponse(): ResponseEntity<JSendResponse<Nothing>> {
        val response = JSendResponse<Nothing>(
            status = "error",
            message = "An unexpected error occurred"
        )
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response)
    }
}