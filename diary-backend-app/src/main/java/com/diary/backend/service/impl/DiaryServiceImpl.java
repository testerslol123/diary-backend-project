package com.diary.backend.service.impl;

import com.diary.backend.domain.Diary;
import com.diary.backend.dto.DiaryDto;
import com.diary.backend.dto.DiarySearchDto;
import com.diary.backend.repository.DiaryRepository;
import com.diary.backend.service.DiaryService;
import com.diary.backend.utils.SearchUtils;
import com.diary.backend.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    @Override
    public Optional<Diary> findById(String id) {
        return diaryRepository.findById(id);
    }

    @Override
    public Diary update(DiaryDto diaryDto) {
        Diary diary = diaryRepository.findById(diaryDto.getId()).orElseThrow(() -> new RuntimeException("No Diary found with id : " + diaryDto.getId()));
        diary.setSubject(diaryDto.getSubject());
        diary.setBody(diaryDto.getBody());
        return diaryRepository.save(diary);
    }

    @Override
    public Diary save(DiaryDto diaryDto) {

        Diary diary = new Diary();

        diary.setSubject(diaryDto.getSubject());
        diary.setBody(diaryDto.getBody());
        diary.setCreatedAt(OffsetDateTime.now());
        return diaryRepository.save(diary);
    }

    @Override
    public void delete(String id) {
        Diary diary = diaryRepository.findById(id).orElseThrow(() -> new RuntimeException("No Diary found with id : " + id));
        diaryRepository.delete(diary);
    }

    @Override
    public Page<Diary> findSearch(DiarySearchDto diarySearchDto) {
        return diaryRepository.findByIdContainingOrderByCreatedAtAsc(
                StringUtils.nullToEmpty(diarySearchDto.getId()),
                SearchUtils.toPageable(diarySearchDto)
        );
    }
}
