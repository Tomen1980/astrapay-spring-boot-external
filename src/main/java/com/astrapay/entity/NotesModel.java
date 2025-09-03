package com.astrapay.entity;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NotesModel {
    private long id;
    private String title;
    private String content;
}
