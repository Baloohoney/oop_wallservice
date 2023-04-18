import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

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
    fun updateExistsPostTrue(): Post {
        val post = Post()
        val result = WallService.update(post)
        assertEquals(true, result)
        return post
    }

    @Test
    fun updateExistsPostFalse(): Post? {
        val post = Post()
        val result = WallService.update(post)
        assertEquals(false, result)
        return null
    }
}