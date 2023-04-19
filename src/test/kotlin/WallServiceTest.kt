import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addNewPost() {
        val post = Post(id = 1)
        val result = WallService.add(post)
        assertEquals(1, result.id)
    }

    @Test
    fun updateExistsPostTrue() {
        val post = Post(id = 0)
        println(post)
        val result = WallService.update(post)
        assertFalse(result)
    }

    @Test
    fun updateExistsPostFalse() {
        val post = Post(id = 100)
        println(post)
        val result = WallService.update(post)
        println(result)
        assertFalse(result)
    }
}