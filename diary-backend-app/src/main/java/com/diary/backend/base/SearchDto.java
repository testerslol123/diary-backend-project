package com.diary.backend.base;

import lombok.Data;

@Data
public class SearchDto {

    private int page = 1;

    private int size;

    private String sort;
}
