package com.astrapay.dto.response;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResNotesDto {
    private long id;
    private String title;
    private String content;
}
