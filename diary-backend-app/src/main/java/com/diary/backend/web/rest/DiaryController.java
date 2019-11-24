package com.diary.backend.web.rest;

import com.diary.backend.domain.Diary;
import com.diary.backend.dto.DiaryDto;
import com.diary.backend.dto.DiarySearchDto;
import com.diary.backend.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/diary/")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    @GetMapping("")
    public Page<DiaryDto> findSearch(DiarySearchDto diarySearchDto) {
        return diaryService.findSearch(diarySearchDto).map(this::toDto);
    }

    @GetMapping("{id}")
    public DiaryDto findById(@PathVariable(name = "id") String id) {
        return toDto(diaryService.findById(id).orElseThrow(() -> new RuntimeException("No Diary found with id : " + id)));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable(name = "id") String id) {
        diaryService.delete(id);
    }

    @PatchMapping("")
    public DiaryDto update(@RequestBody @Valid DiaryDto diaryDto) {
        return toDto(diaryService.update(diaryDto));
    }

    @PostMapping("")
    public DiaryDto save(@RequestBody @Valid DiaryDto diaryDto) {
        return toDto(diaryService.save(diaryDto));
    }

    private DiaryDto toDto(Diary diary) {
        DiaryDto diaryDto = new DiaryDto();
        diaryDto.setId(diary.getId());
        diaryDto.setSubject(diary.getSubject());
        diaryDto.setBody(diary.getBody());
        diaryDto.setCreatedAt(diary.getCreatedAt().toString());
        return diaryDto;
    }

}
