package com.example.history.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "HISTORY")
@Data
public class History {
    @Id
    @Column(name = "NUM")
    public Integer number;
    @Column(name = "SEQ")
    public String sequence;
    @Column(name = "CONTENT")
    public String content;
    @Column(name = "EVENT")
    public String event;
    @Column(name = "REG")
    public Date register;
}
