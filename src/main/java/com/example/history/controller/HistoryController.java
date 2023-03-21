package com.example.history.controller;

import com.example.history.domain.HistoryDto;
import com.example.history.service.HistoryService;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.Date;

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

    // curl -X GET 'http://localhost:8080/history/v3?sequence=A14201'
    // curl -X GET 'http://localhost:8080/history/v3?sequence=A14201&content=DEVELOP'
    // curl -X GET 'http://localhost:8080/history/v3?sequence=A14201&content=DEVELOP&event=DELETED'
    // curl -X GET 'http://localhost:8080/history/v3?sequence=A14201&content=DEVELOP&event=DELETED&start=2023-03-22'
    // curl -X GET 'http://localhost:8080/history/v3?sequence=A14201&content=DEVELOP&event=DELETED&start=2023-03-22'
    @GetMapping("/v3")
    public ResponseEntity<String> listTwo(@RequestParam String sequence,
                                          @RequestParam @Nullable String content,
                                          @RequestParam @Nullable String event,
                                          @RequestParam @Nullable @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
                                          @RequestParam @Nullable @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
        return historyService.listTwo(sequence, content, event, start, end);
    }
}
