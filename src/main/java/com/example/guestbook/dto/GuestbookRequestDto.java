package com.example.guestbook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GuestbookRequestDto {
    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "내용을 입력해주세요.")
    private String message;
}