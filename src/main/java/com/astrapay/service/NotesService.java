package com.astrapay.service;

import com.astrapay.dto.request.ReqCreateNotesDto;
import com.astrapay.dto.request.ReqUpdateNotesDto;
import com.astrapay.dto.response.ResNotesDto;

import java.util.List;

public interface NotesService {
    public ResNotesDto createNote(ReqCreateNotesDto body);
    public List<ResNotesDto> getAllNote();
    public String deleteNote(Long id);
    public ResNotesDto updateNote(Long id, ReqUpdateNotesDto body);
}
