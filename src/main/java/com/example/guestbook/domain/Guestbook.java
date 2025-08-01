package com.example.guestbook.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Guestbook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "이름은 비어 있을 수 없습니다.")
    private String name;

    @NotBlank(message = "메세지는 비어 있을 수 없습니다.")
    @Size(min = 2, message = "메세지는 최소 2자 이상이어야 합니다.")

    private String message;

    public Guestbook(String name, String message) {
        this.name = name;
        this.message = message;
    }
}
