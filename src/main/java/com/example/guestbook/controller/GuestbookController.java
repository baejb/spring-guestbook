package com.example.guestbook.controller;

import com.example.guestbook.domain.Guestbook;
import com.example.guestbook.dto.GuestbookRequestDto;
import com.example.guestbook.dto.GuestbookResponseDto;
import com.example.guestbook.repository.GuestbookRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guestbooks")
public class GuestbookController {

    private final GuestbookRepository guestbookRepository;

    public GuestbookController(GuestbookRepository guestbookRepository){
        this.guestbookRepository = guestbookRepository;
    }

    @GetMapping
    public List<GuestbookResponseDto> getAll(){
        return guestbookRepository.findAll().stream()
                .map(g->new GuestbookResponseDto(g.getId(),g.getName(),g.getMessage())).toList();
    }

    @PostMapping
    public GuestbookResponseDto create(@Valid @RequestBody GuestbookRequestDto requestDto){
        Guestbook guestbook = new Guestbook();
        guestbook.setName(requestDto.getName());
        guestbook.setMessage(requestDto.getMessage());
        Guestbook saved = guestbookRepository.save(guestbook);

        return new GuestbookResponseDto(saved.getId(),saved.getName(),saved.getMessage());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        guestbookRepository.deleteById((id));
    }

    @PutMapping("/{id}")
    public Guestbook update(@PathVariable Long id, @RequestBody Guestbook updatedGuestbook){
        return guestbookRepository.findById(id).map(guestbook ->{
            guestbook.setName(updatedGuestbook.getName());
            guestbook.setMessage(updatedGuestbook.getMessage());
            return guestbookRepository.save(guestbook);
        }).orElseThrow(()-> new IllegalArgumentException("해당 ID의 글을 찾을 수 없습니다: " + id));
    }

}