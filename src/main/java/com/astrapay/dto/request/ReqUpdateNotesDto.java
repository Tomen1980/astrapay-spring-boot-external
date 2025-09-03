package com.astrapay.dto.request;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class ReqUpdateNotesDto {
    @Size(min = 3, message = "Title must be at least 3 characters long")
    private String title;
    @Size(min = 3, message = "Content must be at least 3 characters long")
    private String content;
}
