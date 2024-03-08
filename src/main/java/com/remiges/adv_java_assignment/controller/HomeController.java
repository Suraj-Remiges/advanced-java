package com.remiges.adv_java_assignment.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/hello")
    public ResponseEntity<Object> helloWorld() {
        try {
            // Generate a unique request ID
            String reqid = generateReqId();

            // Get client timestamp
            LocalDateTime clientTs = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
            String clientTsStr = formatter.format(clientTs);

            // Prepare JSON response
            String jsonResponse = "{\"status\":\"success\",\"status_code\":\"\",\"status_msg\":\"\",\"data\":{\"message\":\"Hello World\"},\"_reqid\":\""
                    + reqid + "\",\"_server_ts\":\"" + clientTsStr + "\"}";

            return ResponseEntity.ok().body(jsonResponse);
        } catch (Exception e) {
            // Exception handling
            String reqid = generateReqId();
            String errorMsg = e.getMessage();
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
            String errorResponse = "{\"status\":\"error\",\"status_code\":\"500\",\"status_msg\":\"" + errorMsg
                    + "\",\"data\":{},\"_reqid\":\"" + reqid + "\",\"_server_ts\":\""
                    + LocalDateTime.now().format(formatter) + "\"}";

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    // Method to generate a unique request ID
    private String generateReqId() {
        return UUID.randomUUID().toString().substring(0, 9);
    }

    @PostMapping("/hello")
    public ResponseEntity<String> helloWorld(@RequestBody String name) {
        try {
            // Prepare greeting message
            String greeting = "Hello " + name;
            return ResponseEntity.ok().body(greeting);
        } catch (Exception e) {
            // Exception handling
            String errorMsg = e.getMessage();
            return ResponseEntity.badRequest().body(errorMsg);
        }
    }

}
