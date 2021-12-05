package kotlinx.strings


import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class StringTest {
    @Test
    fun testLastCharacterStructure() {
        val name = "Breimer"

        // assertEquals(name[2:last], 'e')
    }

    @Test
    fun testSubStringUInt() {
        val name = "Breimer"

        // assertEquals("Br", name[2::first])
    }

    @Test
    fun testReplacement() {
        val singular = "criterion"
        val plural = "criteria"

        assertEquals(plural, singular.replace(singular.length - 2, singular.length, "a"))
    }

    @Test
    fun getWithinScope() {
        assertEquals("er", "Breimer"[2::lastChars])
        assertEquals("Br", "Breimer"[2::firstChars])
        assertNotEquals("er", "Breimer"[2::firstChars])
    }

    @Test
    fun testInfixReplace() {
        assertEquals("Breima", "Breimer" replace -2 with "a")
        assertEquals("aeimer", "Breimer" replace 2 with "a")
    }

    @Test
    fun testYEndingPlurals() {

    }

    @Test
    fun getPair() {
        assertEquals("Br", "Breimer"[0 to 2])
    }

    @Test
    fun testGetLast() {
        assertEquals('e', "Breimer"[2::last])
    }

    @Test
    fun testFEndingPlurals() {

    }

    @Test
    fun testUsEndingPlurals() {

    }

    @Test
    fun testIsEndingPlurals() {


    }

    @Test
    fun testOnEndingPlurals() {


    }

    @Test
    fun testGeneralEndingPlurals() {

    }

    @Test
    fun testS_SS_SH_CH_X_Z_EndingPlurals() {


    }


}