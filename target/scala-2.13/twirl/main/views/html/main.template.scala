
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._
import scala.jdk.CollectionConverters._

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,play.mvc.Http.Request,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/(title: String, request: play.mvc.Http.Request)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*8.1*/("""
"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <title>"""),_display_(/*12.17*/title),format.raw/*12.22*/("""</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" media="screen" href='"""),_display_(/*14.54*/routes/*14.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*14.101*/("""' />
        <link rel="stylesheet" media="screen" href='"""),_display_(/*15.54*/routes/*15.60*/.Assets.versioned("stylesheets/prism.css")),format.raw/*15.102*/("""' />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css" />

        <link rel="shortcut icon" type="image/png" href='"""),_display_(/*18.59*/routes/*18.65*/.Assets.versioned("images/favicon.png")),format.raw/*18.104*/("""'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>
    <body data-ws-url=""""),_display_(/*21.25*/routes/*21.31*/.HomeController.socket.webSocketURL(request)),format.raw/*21.75*/("""">
        <main class="section is-flex-direction-column is-align-items-center">"""),_display_(/*22.79*/content),format.raw/*22.86*/("""</main>

        <script src='"""),_display_(/*24.23*/routes/*24.29*/.Assets.versioned("javascripts/main.js")),format.raw/*24.69*/("""' type="text/javascript"></script>
        <script src='"""),_display_(/*25.23*/routes/*25.29*/.Assets.versioned("javascripts/prism.js")),format.raw/*25.70*/("""' type="text/javascript"></script>
    </body>

</html>
"""))
      }
    }
  }

  def render(title:String,request:play.mvc.Http.Request,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title,request)(content)

  def f:((String,play.mvc.Http.Request) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title,request) => (content) => apply(title,request)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/main.scala.html
                  HASH: 9d774603c18749fff4ee50d4bf0476683a10123e
                  MATRIX: 1187->260|1343->323|1370->324|1467->394|1493->399|1663->542|1678->548|1741->589|1826->647|1841->653|1905->695|2096->860|2111->866|2172->905|2335->1041|2350->1047|2415->1091|2523->1172|2551->1179|2609->1210|2624->1216|2685->1256|2769->1313|2784->1319|2846->1360
                  LINES: 32->7|37->8|38->9|41->12|41->12|43->14|43->14|43->14|44->15|44->15|44->15|47->18|47->18|47->18|50->21|50->21|50->21|51->22|51->22|53->24|53->24|53->24|54->25|54->25|54->25
                  -- GENERATED --
              */
          