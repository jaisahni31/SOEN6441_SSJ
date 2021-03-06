
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

object stats extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[QuerySearchResult,play.mvc.Http.Request,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(record : QuerySearchResult, request: play.mvc.Http.Request ):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import helper._


Seq[Any](format.raw/*3.1*/("""
"""),_display_(/*4.2*/main("Welcome", request)/*4.26*/ {_display_(Seq[Any](format.raw/*4.28*/("""
  """),format.raw/*5.3*/("""<div class="container">

    <a href="/">Go Back</a><br/><br/>

    <h2 class="title">Word Stats</h2>
    <h3 class="subtitle is-5">
      """),_display_(/*11.8*/record/*11.14*/.getSearchTerm()),format.raw/*11.30*/("""
    """),format.raw/*12.5*/("""</h3>

    """),_display_(/*14.6*/if(!record.getAnalytics.isEmpty())/*14.40*/ {_display_(Seq[Any](format.raw/*14.42*/("""
      """),format.raw/*15.7*/("""<div class="table-container">
        <table class="table is-hoverable is-bordered break-td">
          <thead>
            <tr>
              <th>Frequency</th>
              <th>Words used</th>
            </tr>
          </thead>
          <tbody>
            """),_display_(/*24.14*/for(item <- record.getAnalytics()) yield /*24.48*/ {_display_(Seq[Any](format.raw/*24.50*/("""
              """),format.raw/*25.15*/("""<tr>
                <td>"""),_display_(/*26.22*/item/*26.26*/.getValue()),format.raw/*26.37*/("""</td>
                <td>"""),_display_(/*27.22*/item/*27.26*/.getKey()),format.raw/*27.35*/("""</td>
              </tr>
            """)))}),format.raw/*29.14*/("""
          """),format.raw/*30.11*/("""</tbody>
        </table>
      </div>

      <div class="is-flex is-justify-content-center">
        <button class="button" onclick="window.scrollTo("""),format.raw/*35.57*/("""{"""),format.raw/*35.58*/(""" """),format.raw/*35.59*/("""top: 0, left: 0, behavior: 'smooth' """),format.raw/*35.95*/("""}"""),format.raw/*35.96*/(""")">Go to top</button>
      </div>
    """)))}/*37.7*/else/*37.12*/{_display_(Seq[Any](format.raw/*37.13*/("""
      """),format.raw/*38.7*/("""<h4 class="subtitle is-6">No results found</h4>
    """)))}),format.raw/*39.6*/("""
  """),format.raw/*40.3*/("""</div>
""")))}),format.raw/*41.2*/("""
"""))
      }
    }
  }

  def render(record:QuerySearchResult,request:play.mvc.Http.Request): play.twirl.api.HtmlFormat.Appendable = apply(record,request)

  def f:((QuerySearchResult,play.mvc.Http.Request) => play.twirl.api.HtmlFormat.Appendable) = (record,request) => apply(record,request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/stats.scala.html
                  HASH: 721279772e25da7022dce3b396653dbe06618282
                  MATRIX: 940->1|1074->64|1118->80|1145->82|1177->106|1216->108|1245->111|1411->251|1426->257|1463->273|1495->278|1533->290|1576->324|1616->326|1650->333|1941->597|1991->631|2031->633|2074->648|2127->674|2140->678|2172->689|2226->716|2239->720|2269->729|2339->768|2378->779|2556->929|2585->930|2614->931|2678->967|2707->968|2765->1009|2778->1014|2817->1015|2851->1022|2934->1075|2964->1078|3002->1086
                  LINES: 27->1|30->2|33->3|34->4|34->4|34->4|35->5|41->11|41->11|41->11|42->12|44->14|44->14|44->14|45->15|54->24|54->24|54->24|55->25|56->26|56->26|56->26|57->27|57->27|57->27|59->29|60->30|65->35|65->35|65->35|65->35|65->35|67->37|67->37|67->37|68->38|69->39|70->40|71->41
                  -- GENERATED --
              */
          