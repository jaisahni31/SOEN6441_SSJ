
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

object thread extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[QuerySearchResult,play.mvc.Http.Request,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(data : QuerySearchResult, request: play.mvc.Http.Request):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import helper._


Seq[Any](format.raw/*3.1*/("""
"""),_display_(/*4.2*/main("Subreddit", request)/*4.28*/ {_display_(Seq[Any](format.raw/*4.30*/("""
  """),format.raw/*5.3*/("""<div class="container">
    <a href="/">Go Back</a><br/><br/>

    <h2 class="title">Subreddit</h2>
    <h3 class="subtitle is-5" data-search=""""),_display_(/*9.45*/data/*9.49*/.getSearchTerm()),format.raw/*9.65*/("""">r/"""),_display_(/*9.70*/data/*9.74*/.getSearchTerm()),format.raw/*9.90*/("""</h3>

    """),_display_(/*11.6*/if(!data.getData().isEmpty())/*11.35*/ {_display_(Seq[Any](format.raw/*11.37*/("""
      """),format.raw/*12.7*/("""<div class="table-container">
        <table class="table is-hoverable is-fullwidth is-bordered break-td">
          <thead>
            <tr>
              <th>Title</th>
              <th>Description</th>
              <th>Author</th>
              <th>Subreddit</th>
            </tr>
          </thead>
          <tbody>
            """),_display_(/*23.14*/for(post <- data.getData()) yield /*23.41*/ {_display_(Seq[Any](format.raw/*23.43*/("""
              """),format.raw/*24.15*/("""<tr>
                <td>"""),_display_(/*25.22*/post/*25.26*/.title),format.raw/*25.32*/("""</td>
                <td>
                  """),_display_(/*27.20*/if(post.selftext.isEmpty())/*27.47*/ {_display_(Seq[Any](format.raw/*27.49*/("""
                    """),format.raw/*28.21*/("""-
                  """)))}/*29.21*/else/*29.26*/{_display_(Seq[Any](format.raw/*29.27*/("""
                    """),_display_(/*30.22*/post/*30.26*/.selftext),format.raw/*30.35*/("""
                  """)))}),format.raw/*31.20*/("""
                """),format.raw/*32.17*/("""</td>
                <td><a href="/user/"""),_display_(/*33.37*/post/*33.41*/.author),format.raw/*33.48*/("""">"""),_display_(/*33.51*/post/*33.55*/.author),format.raw/*33.62*/("""</a></td>
                <td><a href="/thread/"""),_display_(/*34.39*/post/*34.43*/.subreddit),format.raw/*34.53*/("""">"""),_display_(/*34.56*/post/*34.60*/.subreddit),format.raw/*34.70*/("""</a></td>
              </tr>
            """)))}),format.raw/*36.14*/("""
          """),format.raw/*37.11*/("""</tbody>
        </table>
      </div>
    """)))}/*40.7*/else/*40.12*/{_display_(Seq[Any](format.raw/*40.13*/("""
      """),format.raw/*41.7*/("""<h4 class="subtitle is-6">No results found</h4>
    """)))}),format.raw/*42.6*/("""
  """),format.raw/*43.3*/("""</div>
""")))}),format.raw/*44.2*/("""
"""))
      }
    }
  }

  def render(data:QuerySearchResult,request:play.mvc.Http.Request): play.twirl.api.HtmlFormat.Appendable = apply(data,request)

  def f:((QuerySearchResult,play.mvc.Http.Request) => play.twirl.api.HtmlFormat.Appendable) = (data,request) => apply(data,request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/thread.scala.html
                  HASH: 9ae6585399cb87e717bf47b8720c5c0be4f682d7
                  MATRIX: 941->1|1072->61|1116->77|1143->79|1177->105|1216->107|1245->110|1415->254|1427->258|1463->274|1494->279|1506->283|1542->299|1580->311|1618->340|1658->342|1692->349|2056->686|2099->713|2139->715|2182->730|2235->756|2248->760|2275->766|2348->812|2384->839|2424->841|2473->862|2513->884|2526->889|2565->890|2614->912|2627->916|2657->925|2708->945|2753->962|2822->1004|2835->1008|2863->1015|2893->1018|2906->1022|2934->1029|3009->1077|3022->1081|3053->1091|3083->1094|3096->1098|3127->1108|3201->1151|3240->1162|3302->1207|3315->1212|3354->1213|3388->1220|3471->1273|3501->1276|3539->1284
                  LINES: 27->1|30->2|33->3|34->4|34->4|34->4|35->5|39->9|39->9|39->9|39->9|39->9|39->9|41->11|41->11|41->11|42->12|53->23|53->23|53->23|54->24|55->25|55->25|55->25|57->27|57->27|57->27|58->28|59->29|59->29|59->29|60->30|60->30|60->30|61->31|62->32|63->33|63->33|63->33|63->33|63->33|63->33|64->34|64->34|64->34|64->34|64->34|64->34|66->36|67->37|70->40|70->40|70->40|71->41|72->42|73->43|74->44
                  -- GENERATED --
              */
          