package com.astrapay.dto.request;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
public class ReqCreateNotesDto {
    @NotBlank(message = "Title cannot be blank")
    @Size(min = 3, message = "Title must be at least 3 characters long")
    private String title;
    @NotBlank
    @Size(min = 3, message = "Content must be at least 3 characters long")
    private String content;
}
