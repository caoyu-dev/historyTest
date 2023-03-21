package com.example.history.service;

import com.example.history.domain.HistoryDto;
import org.springframework.http.ResponseEntity;

public interface HistoryService {
    ResponseEntity<String> list(HistoryDto request);
    String listOne(HistoryDto request);
}
