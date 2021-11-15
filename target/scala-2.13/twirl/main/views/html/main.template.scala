
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
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
    <body>
        <main class="section is-flex-direction-column is-align-items-center">"""),_display_(/*22.79*/content),format.raw/*22.86*/("""</main>

        <script src='"""),_display_(/*24.23*/routes/*24.29*/.Assets.versioned("javascripts/main.js")),format.raw/*24.69*/("""' type="text/javascript"></script>
        <script src='"""),_display_(/*25.23*/routes/*25.29*/.Assets.versioned("javascripts/prism.js")),format.raw/*25.70*/("""' type="text/javascript"></script>
    </body>

</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/main.scala.html
                  HASH: 9d79a956dc8257c4f15b02f951cf5afc6f5c2542
                  MATRIX: 1165->260|1289->291|1316->292|1413->362|1439->367|1609->510|1624->516|1687->557|1772->615|1787->621|1851->663|2042->828|2057->834|2118->873|2346->1074|2374->1081|2432->1112|2447->1118|2508->1158|2592->1215|2607->1221|2669->1262
                  LINES: 32->7|37->8|38->9|41->12|41->12|43->14|43->14|43->14|44->15|44->15|44->15|47->18|47->18|47->18|51->22|51->22|53->24|53->24|53->24|54->25|54->25|54->25
                  -- GENERATED --
              */
          