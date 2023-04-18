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
}