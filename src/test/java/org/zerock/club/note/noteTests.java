package org.zerock.club.note;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.club.dto.NoteDTO;
import org.zerock.club.entity.Note;
import org.zerock.club.repository.NoteRepository;
import org.zerock.club.service.NoteService;

@SpringBootTest
public class noteTests {
    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteRepository noteRepository;

    @Test
    public void test() {
        NoteDTO noteDTO = NoteDTO.builder()
                .title("test")
                .content("testContent")
                .writerEmail("wlfkrdl2@gmail.com").build();
        Note note = noteService.dtoToEntity(noteDTO);

        noteRepository.save(note);
    }

    @Test
    public void modifyTest() {
        long num = 1;
        NoteDTO noteDTO = NoteDTO.builder()
                .num(num)
                .title("test modify")
                .content("modified Content")
                .writerEmail("wlfkrdl2@gmail.com").build();
        noteService.modify(noteDTO);
    }
}
