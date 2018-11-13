package com.denisgasparoto.kotlinws.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Note(@Id
                @GeneratedValue(strategy = GenerationType.AUTO)
                @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
                var id: Long = 0,
                val title: String = "",
                val shortDescription: String = "",
                val description: String = "",
                val author: String = "",
                val status: String = NoteStatusType.OPEN.status)