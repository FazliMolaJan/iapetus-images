package be.encelade.iapetus

import be.encelade.iapetus.FaceUtils.KNEE_LEVEL
import be.encelade.iapetus.FaceUtils.WAIST_LEVEL
import be.encelade.iapetus.FaceUtils.reFrameAroundFace
import org.junit.Test
import java.awt.Rectangle
import java.io.File

class FaceUtilsTest {

    val FACE_CLOSE_UP_2 = ImageContainingFace(640, 1080, Face(Rectangle(0, 190, 640, 700)))
    val SQUARE_CLOSE_UP = ImageContainingFace(1000, 1000, Face(Rectangle(100, 100, 800, 800)))
    val ULTRA_CLOSE_UP = ImageContainingFace(640, 1080, Face(Rectangle(0, 0, 640, 1080)))
    val SUPER_CLOSE_UP = ImageContainingFace(640, 1080, Face(Rectangle(100, 100, 440, 880)))

    val CENTER_FACE_CLOSE_UP = reFrameOnCenter(1920, FACE_CLOSE_UP_2)
    val CENTER_WAIST_LEVEL = reFrameOnCenter(1920, WAIST_LEVEL)
    val CENTER_KNEE_LEVEL = reFrameOnCenter(1920, KNEE_LEVEL)

    val LEFT_FACE_CLOSE_UP = reFrameOnLeft(1920, FACE_CLOSE_UP_2)
    val LEFT_WAIST_LEVEL = reFrameOnLeft(1920, WAIST_LEVEL)
    val LEFT_KNEE_LEVEL = reFrameOnLeft(1920, KNEE_LEVEL)

    @Test
    fun test1() {
        val outputFolder = "test_output_faces"
        val csv = File("src/test/resources/beatles.csv").absolutePath
        reFrameAroundFace(csv, WAIST_LEVEL, outputFolder, debug = true)
    }

    private fun reFrameOnCenter(width: Int, input: ImageContainingFace): ImageContainingFace {
        val margin = (width - input.face.rectangle.width) / 2
        val rectangle = input.face.rectangle
        val newRectangle = Rectangle(margin, rectangle.y, rectangle.width, rectangle.height)
        return ImageContainingFace(width, input.height, Face(newRectangle))
    }

    private fun reFrameOnLeft(width: Int, input: ImageContainingFace): ImageContainingFace {
        val margin = input.face.rectangle.y
        val rectangle = input.face.rectangle
        val newRectangle = Rectangle(rectangle.x + margin, rectangle.y, rectangle.width, rectangle.height)
        return ImageContainingFace(width, input.height, Face(newRectangle))
    }

    private fun reFrameOnRight(width: Int, input: ImageContainingFace): ImageContainingFace {
        val margin = (input.width - input.face.rectangle.y)
        val rectangle = input.face.rectangle
        val newRectangle = Rectangle(rectangle.x + margin, rectangle.y, rectangle.width, rectangle.height)
        return ImageContainingFace(width, input.height, Face(newRectangle))
    }
}
