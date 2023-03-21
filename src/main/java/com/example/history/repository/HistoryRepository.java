package com.example.history.repository;

import com.example.history.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, String> {
    @Query("SELECT h FROM History h WHERE h.sequence = :sequence AND (:content is null OR h.content = :content) AND (:event is null OR h.event = :event) AND (:start is null OR h.register >= :start) AND (:end is null OR h.register <= :end)")
    List<History> findBySequenceAndContentAndEventAndRegisterBetween(String sequence, String content, String event, Date start, Date end);
}
