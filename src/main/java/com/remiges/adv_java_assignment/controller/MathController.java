package com.remiges.adv_java_assignment.controller;

import java.time.Instant;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.remiges.adv_java_assignment.utility.Request;
import com.remiges.adv_java_assignment.utility.Response;

@RestController
public class MathController {

    @PostMapping("/mysum")
    public ResponseEntity<Response> performOperation(@RequestBody Request request) {
        try {
            String operation = (String) request.getData().get("operation");
            double num1 = ((Number) request.getData().get("num1")).doubleValue();
            double num2 = ((Number) request.getData().get("num2")).doubleValue();

            double result = switch (operation) {
                case "add" -> num1 + num2;
                case "subtract" -> num1 - num2;
                case "multiply" -> num1 * num2;
                case "divide" -> {
                    if (num2 == 0) {
                        throw new IllegalArgumentException("Division by zero is not allowed.");
                    }
                    yield num1 / num2;
                }
                default -> throw new IllegalArgumentException("Invalid operation: " + operation);
            };

            Response response = new Response("success", "200", "", Map.of("result", result), request.getReqId(), null);
            response.setServerTs(Instant.now());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return handleException(e, request.getReqId());
        }
    }

    private ResponseEntity<Response> handleException(Exception e, String reqId) {
        Response eResponse = new Response(reqId, reqId, reqId, null, reqId, null);
        eResponse.setStatus("errro");
        eResponse.setStatusCode("Internal_Error");
        eResponse.setStatusMsg(e.getMessage());
        eResponse.setReqId(reqId);
        eResponse.setServerTs(Instant.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(eResponse);
    }

    // static class Result {
    // private final double result;

    // public Result(double result) {
    // this.result = result;
    // }

    // public double getResult() {
    // return result;
    // }
    // }
}
