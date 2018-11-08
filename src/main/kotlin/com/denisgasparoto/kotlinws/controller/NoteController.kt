package com.denisgasparoto.kotlinws.controller

import com.denisgasparoto.kotlinws.model.Note
import com.denisgasparoto.kotlinws.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/notes")
class NoteController {

    @Autowired
    lateinit var repository: NoteRepository

    @GetMapping
    fun list(): List<Note> {
        return repository.findAll().toList()
    }

    @PostMapping
    fun add(@RequestBody note: Note): Note {
        return repository.save(note)
    }

    @PutMapping("/{id}")
    fun alter(@PathVariable id: Long, @RequestBody note: Note): Note {
        assert(note.id == id)
        return repository.save(note)
    }

    @DeleteMapping("/{îd}")
    fun delete(@PathVariable id: Long) {
        repository.deleteById(id)
    }

    @GetMapping("/{îd}")
    fun getById(@PathVariable id: Long) {
        repository.findById(id)
    }
}