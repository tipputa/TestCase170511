/**
  * Created by tipputa on 2017/05/11.
  */
import scala.swing.{ SimpleSwingApplication, MainFrame, Dimension }

object MainFrameSample extends SimpleSwingApplication {
  def top = new MainFrame {
    // Windowのタイトル
    title = "Window Title"
    // Windowのサイズ
    minimumSize = new Dimension( 300, 200 )
  }
}
