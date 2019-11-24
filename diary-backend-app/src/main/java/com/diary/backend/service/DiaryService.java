package com.diary.backend.service;

import com.diary.backend.domain.Diary;
import com.diary.backend.dto.DiaryDto;
import com.diary.backend.dto.DiarySearchDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface DiaryService {

    Optional<Diary> findById(String id);

    Diary update(DiaryDto diaryDto);

    Diary save(DiaryDto diaryDto);

    void delete(String id);

    Page<Diary> findSearch(DiarySearchDto diarySearchDto);

}
