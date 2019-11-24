package com.diary.backend.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class DiaryDto {

    private String id;

    private String subject;

    private String body;

    private String createdAt;

}
