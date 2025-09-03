package com.astrapay.controller;

import com.astrapay.dto.BaseResponse;
import com.astrapay.dto.request.ReqCreateNotesDto;
import com.astrapay.dto.response.ResNotesDto;
import com.astrapay.service.NotesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class NotesController {

    NotesService notesService;

    public NotesController(NotesService notesService){
        this.notesService = notesService;
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<ResNotesDto>>> getAllNotes(){
        List<ResNotesDto> result = notesService.getAllNote();
        return ResponseEntity.ok(BaseResponse.success(result, "Success Get All Notes"));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<ResNotesDto>> createNotes(
            @Valid @RequestBody ReqCreateNotesDto body
            ){
        ResNotesDto result = notesService.createNote(body);
        return ResponseEntity.ok(
                BaseResponse.success(result, "Success Create Notes")
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<String>> deleteNotes(
            @PathVariable Long id
    ){
        String result = notesService.deleteNote(id);
        return ResponseEntity.ok(
                BaseResponse.success(result, "Success Delete Notes")
        );
    }



}

