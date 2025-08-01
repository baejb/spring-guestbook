package com.example.guestbook.dto;

import lombok.Getter;


@Getter

public class GuestbookResponseDto {
    private Long id;
    private String name;
    private String message;

    public GuestbookResponseDto(Long id, String name, String message){
        this.id = id;
        this.name = name;
        this.message = message;
    }


}