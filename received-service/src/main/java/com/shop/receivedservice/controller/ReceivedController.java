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
@RequestMapping("/received")
@Tag(name = "Received")
public class ReceivedController {
    @Autowired
    private ReceivedServiceImpl receivedService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Received>>> getAllReceived(){
        List<Received> receiveds = receivedService.findAll();
        ApiResponse<List<Received>> apiResponse = ApiResponse.createResponse(receiveds, "Thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Received>> getReceivedById(Integer id) {
        Received received = receivedService.findById(id);
        ApiResponse<Received> apiResponse = ApiResponse.createResponse(received, "Thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<Received> createReceived(
//            @RequestParam Integer UserId,
//            @RequestBody List<ReceivedDetail> receivedDetails
//    ){
//        Received received = receivedService.save(UserId, receivedDetails);
//        return ResponseEntity.ok(received);
//    }

    @PostMapping
    public ResponseEntity<ApiResponse<Received>> create(
            @RequestBody ReceivedCreateRequest receivedCreateRequest
    ){
        Received received = receivedService.create(receivedCreateRequest);
        ApiResponse<Received> apiResponse = ApiResponse.createResponse(received, "Thành công", HttpStatus.CREATED.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<?>> deleteReceived(@RequestParam Integer id){
        receivedService.delete(id);
        ApiResponse<?> apiResponse = ApiResponse.createResponse(null, "Thành công", HttpStatus.OK.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
