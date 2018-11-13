package com.denisgasparoto.kotlinws.controller

import com.denisgasparoto.kotlinws.model.Note
import com.denisgasparoto.kotlinws.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/notes")
class NoteController {

    @Autowired
    lateinit var repository: NoteRepository

    @GetMapping
    fun getAll(): List<Note> = repository.findAll()

    @PostMapping("/post")
    fun create(@RequestBody @Valid note: Note): Note = repository.save(note)

    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long,
               @Valid @RequestBody newNote: Note): ResponseEntity<Note> {

        return repository.findById(id).map { existingNote ->
            val updatedNote: Note = existingNote.copy(title = newNote.title,
                    shortDescription = newNote.shortDescription,
                    description = newNote.description,
                    author = newNote.author,
                    status = newNote.status)
            ResponseEntity.ok().body(repository.save(updatedNote))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void>? {
        return repository.findById(id).map { note ->
            repository.delete(note)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/{îd}")
    fun getById(@PathVariable id: Long): ResponseEntity<Note>? {
        return repository.findById(id).map { note ->
            ResponseEntity.ok(note)
        }.orElse(ResponseEntity.notFound().build())
    }
}