package com.example.history.controller;

import com.example.history.domain.HistoryDto;
import com.example.history.service.HistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryService historyService;

    @GetMapping
    public ResponseEntity<String> list(final @Valid @RequestBody HistoryDto request) {
        return historyService.list(request);
    }

    @GetMapping("/v2")
    public String listOne(final @Valid @RequestBody HistoryDto request) {
        return historyService.listOne(request);
    }
}
