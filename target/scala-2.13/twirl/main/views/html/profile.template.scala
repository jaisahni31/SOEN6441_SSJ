
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

object profile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[QuerySearchResult,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(data : QuerySearchResult):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import helper._


Seq[Any](format.raw/*3.1*/("""
"""),_display_(/*4.2*/main("Profile")/*4.17*/ {_display_(Seq[Any](format.raw/*4.19*/("""
  """),format.raw/*5.3*/("""<div class="container">
    <a href="/">Go Back</a><br/><br/>

    <h2 class="title">User Profile</h2>
    """),_display_(/*9.6*/if(!data.getData().isEmpty())/*9.35*/ {_display_(Seq[Any](format.raw/*9.37*/("""
      """),format.raw/*10.7*/("""<table class="table is-hoverable is-narrow is-bordered">
        <tbody>
          <tr><th>Name</th><td>"""),_display_(/*12.33*/data/*12.37*/.getData().get(0).author_fullname),format.raw/*12.70*/("""</td></tr>
          <tr><th>Id</th><td>"""),_display_(/*13.31*/data/*13.35*/.getData().get(0).author),format.raw/*13.59*/("""</td></tr>
          <tr><th>Blocked</th><td>"""),_display_(/*14.36*/data/*14.40*/.getData().get(0).author_is_blocked),format.raw/*14.75*/("""</td></tr>
          <tr><th>Premium</th><td>"""),_display_(/*15.36*/data/*15.40*/.getData().get(0).author_premium),format.raw/*15.72*/("""</td></tr>
        </tbody>
      </table>

      <h4 class="subtitle is-5">Recent Posts</h4>
      <div class="table-container">
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
            """),_display_(/*31.14*/for(post <- data.getData()) yield /*31.41*/ {_display_(Seq[Any](format.raw/*31.43*/("""
              """),format.raw/*32.15*/("""<tr>
                <td>"""),_display_(/*33.22*/post/*33.26*/.title),format.raw/*33.32*/("""</td>
                <td>
                  """),_display_(/*35.20*/if(post.selftext.isEmpty())/*35.47*/ {_display_(Seq[Any](format.raw/*35.49*/("""
                    """),format.raw/*36.21*/("""-
                  """)))}/*37.21*/else/*37.26*/{_display_(Seq[Any](format.raw/*37.27*/("""
                    """),_display_(/*38.22*/post/*38.26*/.selftext),format.raw/*38.35*/("""
                  """)))}),format.raw/*39.20*/("""
                """),format.raw/*40.17*/("""</td>
                <td><a href="/user/"""),_display_(/*41.37*/post/*41.41*/.author),format.raw/*41.48*/("""">"""),_display_(/*41.51*/post/*41.55*/.author),format.raw/*41.62*/("""</a></td>
                <td><a href="/thread/"""),_display_(/*42.39*/post/*42.43*/.subreddit),format.raw/*42.53*/("""">"""),_display_(/*42.56*/post/*42.60*/.subreddit),format.raw/*42.70*/("""</a></td>
              </tr>
            """)))}),format.raw/*44.14*/("""
          """),format.raw/*45.11*/("""</tbody>
        </table>
      </div>
    """)))}/*48.7*/else/*48.12*/{_display_(Seq[Any](format.raw/*48.13*/("""
      """),format.raw/*49.7*/("""<h4 class="subtitle is-6">No results found</h4>
    """)))}),format.raw/*50.6*/("""
  """),format.raw/*51.3*/("""</div>
""")))}),format.raw/*52.2*/("""
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
                  SOURCE: app/views/profile.scala.html
                  HASH: f1d08a4376327f8a7455adf59c8adf7f0cef54a8
                  MATRIX: 920->1|1019->29|1063->45|1090->47|1113->62|1152->64|1181->67|1314->175|1351->204|1390->206|1424->213|1556->318|1569->322|1623->355|1691->396|1704->400|1749->424|1822->470|1835->474|1891->509|1964->555|1977->559|2030->591|2494->1028|2537->1055|2577->1057|2620->1072|2673->1098|2686->1102|2713->1108|2786->1154|2822->1181|2862->1183|2911->1204|2951->1226|2964->1231|3003->1232|3052->1254|3065->1258|3095->1267|3146->1287|3191->1304|3260->1346|3273->1350|3301->1357|3331->1360|3344->1364|3372->1371|3447->1419|3460->1423|3491->1433|3521->1436|3534->1440|3565->1450|3639->1493|3678->1504|3740->1549|3753->1554|3792->1555|3826->1562|3909->1615|3939->1618|3977->1626
                  LINES: 27->1|30->2|33->3|34->4|34->4|34->4|35->5|39->9|39->9|39->9|40->10|42->12|42->12|42->12|43->13|43->13|43->13|44->14|44->14|44->14|45->15|45->15|45->15|61->31|61->31|61->31|62->32|63->33|63->33|63->33|65->35|65->35|65->35|66->36|67->37|67->37|67->37|68->38|68->38|68->38|69->39|70->40|71->41|71->41|71->41|71->41|71->41|71->41|72->42|72->42|72->42|72->42|72->42|72->42|74->44|75->45|78->48|78->48|78->48|79->49|80->50|81->51|82->52
                  -- GENERATED --
              */
          