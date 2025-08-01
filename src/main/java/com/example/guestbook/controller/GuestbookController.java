package com.example.guestbook.controller;

import com.example.guestbook.domain.Guestbook;
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
    public List<Guestbook> getAll(){
        return guestbookRepository.findAll();
    }

    @PostMapping
    public Guestbook create(@Valid @RequestBody Guestbook guestbook){
        return guestbookRepository.save(guestbook);
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