package com.shop.receivedservice.controller;

import com.shop.receivedservice.dto.request.ReceivedCreateRequest;
import com.shop.receivedservice.dto.response.ApiResponse;
import com.shop.receivedservice.entity.Received;
import com.shop.receivedservice.entity.ReceivedDetail;
import com.shop.receivedservice.service.impl.ReceivedServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Received")
@Tag(name = "Received")
public class ReceivedController {
    @Autowired
    private ReceivedServiceImpl receivedService;

    @GetMapping
    public List<Received> getAllReceived(){
        return receivedService.findAll();
    }

    @PostMapping
    public ResponseEntity<Received> createReceived(
            @RequestParam Integer UserId,
            @RequestBody List<ReceivedDetail> receivedDetails
    ){
        Received received = receivedService.save(UserId, receivedDetails);
        return ResponseEntity.ok(received);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Received>> create(
            @RequestBody ReceivedCreateRequest receivedCreateRequest
    ){
        Received received = receivedService.create(receivedCreateRequest);
        ApiResponse<Received> apiResponse = ApiResponse.createResponse(received, "Thành công", HttpStatus.CREATED.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteReceived(@RequestParam Integer id){
        receivedService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
