package be.encelade.iapetus

import be.encelade.iapetus.ImagesFolderUtils.cutHorizontalStripes
import be.encelade.iapetus.ImagesFolderUtils.cutVerticalStripes
import org.junit.Test
import java.io.File

class ImagesFolderUtilsTest {

    @Test
    fun test1() {
        val outputFolder = "test_stripes_v6"
        val folder = File("src/test/resources")
        folder.cutVerticalStripes(6, outputFolder)

        // TODO: check post-conditions
    }

    @Test
    fun test2() {
        val outputFolder = "test_stripes_h6"
        val folder = File("src/test/resources")
        folder.cutHorizontalStripes(6, outputFolder)

        // TODO: check post-conditions
    }
}
