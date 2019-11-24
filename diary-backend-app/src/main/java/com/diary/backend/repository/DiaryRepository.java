package com.diary.backend.repository;

import com.diary.backend.domain.Diary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRepository extends MongoRepository<Diary, String> {

    Page<Diary> findByIdContainingOrderByCreatedAtAsc(String id, Pageable pageable);

}
