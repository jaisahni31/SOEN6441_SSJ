
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

object thread extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[QuerySearchResult,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(data : QuerySearchResult):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import helper._


Seq[Any](format.raw/*3.1*/("""
"""),_display_(/*4.2*/main("Subreddit")/*4.19*/ {_display_(Seq[Any](format.raw/*4.21*/("""
  """),format.raw/*5.3*/("""<div class="container">
    <a href="/">Go Back</a><br/><br/>

    <h2 class="title">Subreddit</h2>
    <h3 class="subtitle is-5">r/"""),_display_(/*9.34*/data/*9.38*/.getSearchTerm()),format.raw/*9.54*/("""</h3>

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

  def render(data:QuerySearchResult): play.twirl.api.HtmlFormat.Appendable = apply(data)

  def f:((QuerySearchResult) => play.twirl.api.HtmlFormat.Appendable) = (data) => apply(data)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/thread.scala.html
                  HASH: f71aa242d9eb4861f3629adbc801d73b794713e7
                  MATRIX: 919->1|1018->29|1062->45|1089->47|1114->64|1153->66|1182->69|1341->202|1353->206|1389->222|1427->234|1465->263|1505->265|1539->272|1903->609|1946->636|1986->638|2029->653|2082->679|2095->683|2122->689|2195->735|2231->762|2271->764|2320->785|2360->807|2373->812|2412->813|2461->835|2474->839|2504->848|2555->868|2600->885|2669->927|2682->931|2710->938|2740->941|2753->945|2781->952|2856->1000|2869->1004|2900->1014|2930->1017|2943->1021|2974->1031|3048->1074|3087->1085|3149->1130|3162->1135|3201->1136|3235->1143|3318->1196|3348->1199|3386->1207
                  LINES: 27->1|30->2|33->3|34->4|34->4|34->4|35->5|39->9|39->9|39->9|41->11|41->11|41->11|42->12|53->23|53->23|53->23|54->24|55->25|55->25|55->25|57->27|57->27|57->27|58->28|59->29|59->29|59->29|60->30|60->30|60->30|61->31|62->32|63->33|63->33|63->33|63->33|63->33|63->33|64->34|64->34|64->34|64->34|64->34|64->34|66->36|67->37|70->40|70->40|70->40|71->41|72->42|73->43|74->44
                  -- GENERATED --
              */
          