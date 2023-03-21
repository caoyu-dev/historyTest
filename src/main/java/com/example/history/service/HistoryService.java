package com.example.history.service;

import com.example.history.domain.HistoryDto;
import jakarta.annotation.Nullable;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

public interface HistoryService {
    ResponseEntity<String> list(HistoryDto request);
    String listOne(HistoryDto request);
    ResponseEntity<String> listTwo(String sequence, String content, String event, Date start, Date end);
}
