package com.sparta.week03.domain.controller;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import com.sparta.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        memoService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }
}




//@RequiredArgsConstructor
//@RestController
//public class MemoController {
//
//    private final MemoRepository memoRepository;
//    private final MemoService memoService;
//
//    @GetMapping("/api/memos")
//    public List<Memo> getMemos() {
//        LocalDateTime start = LocalDateTime.now().minusDays(1);
//        LocalDateTime end = LocalDateTime.now();
            //24시간 이내의 메모만 가져올레요
//        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start, end);
//    }
//
//    @PostMapping("/api/memos")
//    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
//        Memo memo = new Memo(requestDto);
//        return memoRepository.save(memo);
//    }
//
//    @PutMapping("/api/memos/{id}")
//    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
//        memoService.update(id, requestDto);
//        return id;
//    }
//
//    @DeleteMapping("/api/memos/{id}")
//    public Long deleteMemo(@PathVariable Long id) {
//        memoRepository.deleteById(id);
//        return id;
//    }
//}