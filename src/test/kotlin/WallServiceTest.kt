import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addNewPost() {
        val post = Post()
        val result = WallService.add(post)
        assertEquals(1, result.id)
    }

    @Test
    fun updateExistsPostTrue() {
        val post = Post(id = 1)
        val postAdded = WallService.add(post)
        val result = WallService.update(post)
        assertTrue(result)
    }

    @Test
    fun updateExistsPostFalse() {
        val post = Post(id = 100)
        val postAdded = WallService.add(post)
        val result = WallService.update(post)
        assertFalse(result)
    }
}