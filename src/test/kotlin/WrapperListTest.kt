import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.korlin.mexaneg.WrapperStringList

class WrapperListTest {

    private val list = WrapperStringList().apply {
        add("ssss")
        add("ttt")
        add("ww")
        add("d")
    }

    @Test
    fun mapWrapperListTest(): Unit = runBlocking {
        launch {
            val result = list.map { it.length }
            assertEquals(result[0], 4)
        }
    }

    @Test
    fun filterWrapperListTest() {
        val result = list.filter { it.length >= 2 }
        assertEquals(result.size, 3)
    }

    @Test
    fun sequenceWrapperListTest(): Unit = runBlocking {
        launch {
            val result = list.getStringsLongerOneSymbol()
            assertEquals(result.size, 3)
        }
    }

    @Test
    fun flowWrapperListTest(): Unit = runBlocking {
        launch {
            val result = list.getStringsLongerTwoSymbol()
            assertEquals(result.size, 2)
        }
    }

    @Test
    fun flowSleepWrapperListTest(): Unit = runBlocking {
        launch {
            val result = list.getStringsLongerThreeSymbol()
            assertEquals(result.size, 1)
        }
    }
}