//package com.CME.backend.controller;
//
//import com.CME.backend.model.CombinedData;
//import com.CME.backend.service.CombinedDataService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/combined")
//public class CombinedDataController {
//
//    private final CombinedDataService combinedDataService;
//
//    @Autowired
//    public CombinedDataController(CombinedDataService combinedDataService) {
//        this.combinedDataService = combinedDataService;
//    }
//
//    @GetMapping("/{symbol}")
//    public ResponseEntity<CombinedData> getCombinedData(@PathVariable String symbol) {
//        CombinedData combinedData = combinedDataService.getCombinedData(symbol);
//        return ResponseEntity.ok(combinedData);
//    }
//}
