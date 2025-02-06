package com.shop.receivedservice.controller;

import com.shop.receivedservice.entity.ReceivedDetail;
import com.shop.receivedservice.service.impl.ReceivedDetailServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ReceivedDetail")
@Tag(name = "Received Detail")
public class ReceivedDetailController {
    @Autowired
    private ReceivedDetailServiceImpl receivedDetailService;

    @GetMapping
    public List<ReceivedDetail> getAllReceivedDetail(){
        return receivedDetailService.findAll();
    }

    // Lỗi
    @PostMapping
    public ResponseEntity<ReceivedDetail> createReceivedDetail(
            @RequestBody ReceivedDetail receivedDetail
    ){
        return ResponseEntity.ok(receivedDetailService.save(receivedDetail));
    }
}
