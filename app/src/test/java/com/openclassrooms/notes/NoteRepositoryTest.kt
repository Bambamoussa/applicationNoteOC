package com.openclassrooms.notes

import com.openclassrooms.notes.data.model.Note
import com.openclassrooms.notes.repository.NotesRepository
import com.openclassrooms.notes.service.NotesApiService
import io.mockk.coEvery
import io.mockk.mockk

import kotlinx.coroutines.flow.first

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class NotesRepositoryTest {

    private lateinit var notesRepository: NotesRepository
    private val mockNotesApiService: NotesApiService = mockk()

    @Before
    fun setup() {

        notesRepository = NotesRepository().apply {

            notesApiService = mockNotesApiService
        }
    }

    @Test
    fun `test notes flow emits expected data`() = runTest {

        val mockNotes = listOf(
            Note(title =  "Note 1", description = "Contenu de la note 1"),
            Note(title =  "Note 2", description = "Contenu de la note 2")
        )

        coEvery { mockNotesApiService.getAllNotes() } returns mockNotes


        val result = notesRepository.notes.first()


        assertEquals(mockNotes, result)
    }
}
