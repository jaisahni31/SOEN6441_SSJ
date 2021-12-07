
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

object profile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[QuerySearchResult,play.mvc.Http.Request,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(data : QuerySearchResult, request: play.mvc.Http.Request):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import helper._


Seq[Any](format.raw/*3.1*/("""
"""),_display_(/*4.2*/main("Profile", request)/*4.26*/ {_display_(Seq[Any](format.raw/*4.28*/("""
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

  def render(data:QuerySearchResult,request:play.mvc.Http.Request): play.twirl.api.HtmlFormat.Appendable = apply(data,request)

  def f:((QuerySearchResult,play.mvc.Http.Request) => play.twirl.api.HtmlFormat.Appendable) = (data,request) => apply(data,request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/profile.scala.html
                  HASH: 660ff70c8215ea2fcebcd17a99abc16bddc0932d
                  MATRIX: 942->1|1073->61|1117->77|1144->79|1176->103|1215->105|1244->108|1377->216|1414->245|1453->247|1487->254|1619->359|1632->363|1686->396|1754->437|1767->441|1812->465|1885->511|1898->515|1954->550|2027->596|2040->600|2093->632|2557->1069|2600->1096|2640->1098|2683->1113|2736->1139|2749->1143|2776->1149|2849->1195|2885->1222|2925->1224|2974->1245|3014->1267|3027->1272|3066->1273|3115->1295|3128->1299|3158->1308|3209->1328|3254->1345|3323->1387|3336->1391|3364->1398|3394->1401|3407->1405|3435->1412|3510->1460|3523->1464|3554->1474|3584->1477|3597->1481|3628->1491|3702->1534|3741->1545|3803->1590|3816->1595|3855->1596|3889->1603|3972->1656|4002->1659|4040->1667
                  LINES: 27->1|30->2|33->3|34->4|34->4|34->4|35->5|39->9|39->9|39->9|40->10|42->12|42->12|42->12|43->13|43->13|43->13|44->14|44->14|44->14|45->15|45->15|45->15|61->31|61->31|61->31|62->32|63->33|63->33|63->33|65->35|65->35|65->35|66->36|67->37|67->37|67->37|68->38|68->38|68->38|69->39|70->40|71->41|71->41|71->41|71->41|71->41|71->41|72->42|72->42|72->42|72->42|72->42|72->42|74->44|75->45|78->48|78->48|78->48|79->49|80->50|81->51|82->52
                  -- GENERATED --
              */
          