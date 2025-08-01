package com.example.guestbook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GuestbookRequestDto {

    @NotBlank(message = "이름은 필수입니다.")
    @Size(min = 2, max = 20, message = "이름은 2자 이상 20자 이하로 입력해주세요.")
    private String name;

    @NotBlank(message = "내용은 필수입니다.")
    @Size(min = 2, max = 100, message = "내용은 2자 이상 100자 이하로 입력해주세요.")
    private String message;
}
