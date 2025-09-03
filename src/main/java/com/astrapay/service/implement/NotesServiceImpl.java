package com.astrapay.service.implement;

import com.astrapay.dto.request.ReqCreateNotesDto;
import com.astrapay.dto.request.ReqUpdateNotesDto;
import com.astrapay.dto.response.ResNotesDto;
import com.astrapay.entity.NotesModel;
import com.astrapay.exception.NotFoundException;
import com.astrapay.service.NotesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class NotesServiceImpl implements NotesService {
    private final Map<Long, NotesModel> notesMap = new HashMap<>();
    private Long counter = 0L;

    @Override
    public ResNotesDto createNote(ReqCreateNotesDto body){
        counter++;
        NotesModel note = new NotesModel(counter, body.getTitle(), body.getContent());
        notesMap.put(note.getId(), note);
        return new ResNotesDto(note.getId(), note.getTitle(), note.getContent());
    }

    @Override
    public List<ResNotesDto> getAllNote(){
        return notesMap.values().stream()
                .map(note -> new ResNotesDto(note.getId(), note.getTitle(), note.getContent()))
                .collect(Collectors.toList());
    }

    @Override
    public String deleteNote(Long id) {
        log.info("idnya {}: "+ id);
        if (notesMap.containsKey(id)) {
            notesMap.remove(id);
            return "Note with ID " + id + " deleted successfully.";
        } else {
           throw new NotFoundException("Note with ID " + id + " not found.");
        }
    }

    @Override
    public ResNotesDto updateNote(Long id, ReqUpdateNotesDto body){
        if(notesMap.containsKey(id)){
            NotesModel existingNote = notesMap.get(id);
            existingNote.setTitle(body.getTitle());
            existingNote.setContent(body.getContent());
            return new ResNotesDto(existingNote.getId(), existingNote.getTitle(), existingNote.getContent());
        } else {
            throw new NotFoundException("Note with ID " + id + " not found.");
        }
    }
}
