package com.example.history.domain;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryDto {
    @Nullable
    private Integer number;
    @NotNull
    private String sequence;
    @Nullable
    private String content;
    @Nullable
    private String event;
    @Nullable
    private Date start;
    @Nullable
    private Date end;
}
