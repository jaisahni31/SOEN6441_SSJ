
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""

"""),_display_(/*4.2*/main("Welcome")/*4.17*/ {_display_(Seq[Any](format.raw/*4.19*/("""

"""),format.raw/*6.1*/("""<div style="position: absolute;top: 0;left: 0;height: 100%;width: 100%;display: flex;justify-content: center">

  <div style="flex-direction: column;
            display: flex;">
    <div style="    border: 2px solid black;
                height: fit-content;
                margin-top: 3em;
                width: 100em;
                text-align: center;">


      <h3 style="color: black; text-align: center;">Reddit Analysis</h3>

      <div style="margin-bottom: 1em">
        <input type="text" style="border-color: black;
                        outline: none;
                        font-size: 1em;padding: 8px; width: 30em ;display: inline-block" placeholder="Enter Search Term" id="searchBox"/>
        <a style="display: inline-block;
                        margin-left: 10px;
                        border: 2px solid black;
                        padding: 6px;
                        border-radius: 0%;
                        color: blue;
                        cursor: pointer;
                        font-weight: 700;" href='/' id="go">Search</a>
      </div>
    </div>




  </div>
</div>




""")))}))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: b0d7169575531da36000b1549756c092954e6221
                  MATRIX: 900->1|996->4|1024->7|1047->22|1086->24|1114->26
                  LINES: 27->1|32->2|34->4|34->4|34->4|36->6
                  -- GENERATED --
              */
          