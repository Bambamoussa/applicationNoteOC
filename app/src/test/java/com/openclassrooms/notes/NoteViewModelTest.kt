import app.cash.turbine.test
import com.openclassrooms.notes.data.model.Note
import com.openclassrooms.notes.repository.NotesRepository
import com.openclassrooms.notes.viewModel.NoteViewModel
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class NoteViewModelTest {

    private lateinit var viewModel: NoteViewModel
    private val notesRepository: NotesRepository = mockk()

    // Utilisation du TestCoroutineDispatcher pour contrôler le timing des coroutines
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        // Utilisation de TestDispatcher pour s'assurer que les coroutines s'exécutent immédiatement
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        // Réinitialisation du Dispatchers principal après les tests
        Dispatchers.resetMain()
    }

    @Test
    fun `test notes flow is updated correctly from repository`() = runTest {
        // Données factices pour le test
        val fakeNotes = listOf(
            Note(  title = "Test Note 1", description = "Content 1"),
            Note(  title = "Test Note 2", description = "Content 2")
        )

        // Mock du flow émis par le repository
        coEvery { notesRepository.notes } returns flowOf(fakeNotes)

        // Initialisation du ViewModel
        viewModel = NoteViewModel(notesRepository)

        // Utilisation de Turbine pour tester le Flow
        viewModel.notes.test {
            // Première émission attendue dans le flow
            val emittedNotes = awaitItem()

            // Vérification des résultats
            assertEquals(fakeNotes, emittedNotes)
            cancelAndConsumeRemainingEvents()
        }
    }
}
