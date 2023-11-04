import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.dino.newskmp.app.common.NewsApp

/**
 * Created by dinopriyano on 04/11/23.
 */

fun main() {
  application {
    Window(
      title = "News KMP",
      onCloseRequest = ::exitApplication
    ) {
      NewsApp()
    }
  }
}