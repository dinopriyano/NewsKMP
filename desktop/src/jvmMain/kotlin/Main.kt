import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.dino.newskmp.app.common.NewsApp
import com.dino.newskmp.app.common.domain.di.initKoin

/**
 * Created by dinopriyano on 04/11/23.
 */

fun main() {
  application {
    Window(
      title = "News KMP",
      onCloseRequest = ::exitApplication
    ) {
      initKoin("")
      NewsApp()
    }
  }
}