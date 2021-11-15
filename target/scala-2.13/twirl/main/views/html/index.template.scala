
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[QuerySearchResult],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(data : List[QuerySearchResult]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import helper._


Seq[Any](format.raw/*3.1*/("""
"""),_display_(/*4.2*/main("Welcome")/*4.17*/ {_display_(Seq[Any](format.raw/*4.19*/("""
  """),format.raw/*5.3*/("""<div class="container">
    <div class="search-wrapper">
      <div class="search-wrapper__box">
        <h2 class="title">Redditlytics</h2>
        <form class="search-form" action="#" method="GET">
          <input
            required
            autofocus
            name="q"
            type="text"
            class="input"
            placeholder="Enter Search Term"
            id="searchBox"
          />
          <button class="button is-normal ml-2" id="go">Search</button>
        </form>
      </div>
    </div>

    """),_display_(/*24.6*/for(record <- data) yield /*24.25*/ {_display_(Seq[Any](format.raw/*24.27*/("""
      """),format.raw/*25.7*/("""<section class="searchResultBox">
        <h3 class="subtitle is-5 has-text-weight-bold">
          Search terms:
          <a href="/stats/"""),_display_(/*28.28*/record/*28.34*/.getSearchTerm()),format.raw/*28.50*/("""">
            """),_display_(/*29.14*/record/*29.20*/.getSearchTerm()),format.raw/*29.36*/("""
          """),format.raw/*30.11*/("""</a>
        </h3>


        """),_display_(/*34.10*/if(!record.getData().isEmpty)/*34.39*/ {_display_(Seq[Any](format.raw/*34.41*/("""
          """),format.raw/*35.11*/("""<div class="table-container">
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
                """),_display_(/*46.18*/for(post <- record.getData()) yield /*46.47*/ {_display_(Seq[Any](format.raw/*46.49*/("""
                  """),format.raw/*47.19*/("""<tr>
                    <td>"""),_display_(/*48.26*/post/*48.30*/.title),format.raw/*48.36*/("""</td>
                    <td>
                      """),_display_(/*50.24*/if(post.selftext.isEmpty())/*50.51*/ {_display_(Seq[Any](format.raw/*50.53*/("""
                        """),format.raw/*51.25*/("""-
                      """)))}/*52.25*/else/*52.30*/{_display_(Seq[Any](format.raw/*52.31*/("""
                        """),_display_(/*53.26*/post/*53.30*/.selftext),format.raw/*53.39*/("""
                      """)))}),format.raw/*54.24*/("""
                    """),format.raw/*55.21*/("""</td>
                    <td><a href="/user/"""),_display_(/*56.41*/post/*56.45*/.author),format.raw/*56.52*/("""">"""),_display_(/*56.55*/post/*56.59*/.author),format.raw/*56.66*/("""</a></td>
                    <td><a href="/thread/"""),_display_(/*57.43*/post/*57.47*/.subreddit),format.raw/*57.57*/("""">"""),_display_(/*57.60*/post/*57.64*/.subreddit),format.raw/*57.74*/("""</a></td>
                  </tr>
                """)))}),format.raw/*59.18*/("""
              """),format.raw/*60.15*/("""</tbody>
            </table>
          </div>
        """)))}/*63.11*/else/*63.16*/{_display_(Seq[Any](format.raw/*63.17*/("""
          """),format.raw/*64.11*/("""<h4 class="subtitle is-6">No results found</h4>
        """)))}),format.raw/*65.10*/("""

        """),format.raw/*67.9*/("""<hr />
      </section>
    """)))}),format.raw/*69.6*/("""

    """),_display_(/*71.6*/if(!data.isEmpty())/*71.25*/ {_display_(Seq[Any](format.raw/*71.27*/("""
      """),format.raw/*72.7*/("""<div class="is-flex is-justify-content-center">
        <button class="button" onclick="window.scrollTo("""),format.raw/*73.57*/("""{"""),format.raw/*73.58*/(""" """),format.raw/*73.59*/("""top: 0, left: 0, behavior: 'smooth' """),format.raw/*73.95*/("""}"""),format.raw/*73.96*/(""")">Go to top</button>
      </div>
    """)))}),format.raw/*75.6*/("""
  """),format.raw/*76.3*/("""</div>
""")))}),format.raw/*77.2*/("""
"""))
      }
    }
  }

  def render(data:List[QuerySearchResult]): play.twirl.api.HtmlFormat.Appendable = apply(data)

  def f:((List[QuerySearchResult]) => play.twirl.api.HtmlFormat.Appendable) = (data) => apply(data)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: 3f7dc3cdd2934df573a9bbe1b856d3fe18ae08ac
                  MATRIX: 924->1|1029->35|1073->51|1100->53|1123->68|1162->70|1191->73|1750->606|1785->625|1825->627|1859->634|2027->775|2042->781|2079->797|2122->813|2137->819|2174->835|2213->846|2270->876|2308->905|2348->907|2387->918|2795->1299|2840->1328|2880->1330|2927->1349|2984->1379|2997->1383|3024->1389|3105->1443|3141->1470|3181->1472|3234->1497|3278->1523|3291->1528|3330->1529|3383->1555|3396->1559|3426->1568|3481->1592|3530->1613|3603->1659|3616->1663|3644->1670|3674->1673|3687->1677|3715->1684|3794->1736|3807->1740|3838->1750|3868->1753|3881->1757|3912->1767|3994->1818|4037->1833|4112->1890|4125->1895|4164->1896|4203->1907|4291->1964|4328->1974|4387->2003|4420->2010|4448->2029|4488->2031|4522->2038|4654->2142|4683->2143|4712->2144|4776->2180|4805->2181|4875->2221|4905->2224|4943->2232
                  LINES: 27->1|30->2|33->3|34->4|34->4|34->4|35->5|54->24|54->24|54->24|55->25|58->28|58->28|58->28|59->29|59->29|59->29|60->30|64->34|64->34|64->34|65->35|76->46|76->46|76->46|77->47|78->48|78->48|78->48|80->50|80->50|80->50|81->51|82->52|82->52|82->52|83->53|83->53|83->53|84->54|85->55|86->56|86->56|86->56|86->56|86->56|86->56|87->57|87->57|87->57|87->57|87->57|87->57|89->59|90->60|93->63|93->63|93->63|94->64|95->65|97->67|99->69|101->71|101->71|101->71|102->72|103->73|103->73|103->73|103->73|103->73|105->75|106->76|107->77
                  -- GENERATED --
              */
          