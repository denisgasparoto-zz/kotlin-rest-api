package com.denisgasparoto.kotlinws.repository

import com.denisgasparoto.kotlinws.model.Note
import org.springframework.data.jpa.repository.JpaRepository

interface NoteRepository : JpaRepository<Note, Long>