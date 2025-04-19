package com.ey.banking.tms.transinit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transinit/v1")
public class TransInitController {

    @PostMapping("/initialize/{acountId}")
    public ResponseEntity<Object> initTransaction(@PathVariable){

    }
}
