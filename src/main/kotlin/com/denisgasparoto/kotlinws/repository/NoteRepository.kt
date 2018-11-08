package com.denisgasparoto.kotlinws.repository

import com.denisgasparoto.kotlinws.model.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository : CrudRepository<Note, Long>