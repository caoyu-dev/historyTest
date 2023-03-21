package com.example.history.service;

import com.example.history.domain.HistoryDto;
import com.example.history.entity.History;
import com.example.history.repository.HistoryRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository repository;
    @Override
    public ResponseEntity<String> list(HistoryDto request) {
        System.out.println("request --> " + request);
        System.out.println("request.getSequence() --> " + request.getSequence());

        List<History> list = repository.findBySequenceAndContentAndEventAndRegisterBetween(
                request.getSequence(),
                request.getContent(),
                request.getEvent(),
                request.getStart(),
                request.getEnd()
        );

        String json = new Gson().toJson(list);
        return ResponseEntity.ok(json);
    }

    @Override
    public String listOne(HistoryDto request) {
        List<History> list = repository.findBySequenceAndContentAndEventAndRegisterBetween(
                request.getSequence(),
                request.getContent(),
                request.getEvent(),
                request.getStart(),
                request.getEnd()
        );

        String json = new Gson().toJson(list);
        return json;
    }

    @Override
    public ResponseEntity<String> listTwo(String sequence, String content, String event, Date start, Date end) {
        List<History> list = repository.findBySequenceAndContentAndEventAndRegisterBetween(sequence, content, event, start, end);
        String json = new Gson().toJson(list);
        return ResponseEntity.ok(json);
    }
}
