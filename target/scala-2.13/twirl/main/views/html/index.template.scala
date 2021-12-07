
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[List[QuerySearchResult],play.mvc.Http.Request,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(data : List[QuerySearchResult], request: play.mvc.Http.Request):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import helper._


Seq[Any](format.raw/*3.1*/("""
"""),_display_(/*4.2*/main("Welcome", request)/*4.26*/ {_display_(Seq[Any](format.raw/*4.28*/("""
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
      """),format.raw/*25.7*/("""<section class="searchResultBox" data-search=""""),_display_(/*25.54*/record/*25.60*/.getSearchTerm()),format.raw/*25.76*/("""">
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

  def render(data:List[QuerySearchResult],request:play.mvc.Http.Request): play.twirl.api.HtmlFormat.Appendable = apply(data,request)

  def f:((List[QuerySearchResult],play.mvc.Http.Request) => play.twirl.api.HtmlFormat.Appendable) = (data,request) => apply(data,request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: f63ec005c46b1ed496dd4dd909aa49d839bff837
                  MATRIX: 946->1|1083->67|1127->83|1154->85|1186->109|1225->111|1254->114|1813->647|1848->666|1888->668|1922->675|1996->722|2011->728|2048->744|2185->854|2200->860|2237->876|2280->892|2295->898|2332->914|2371->925|2428->955|2466->984|2506->986|2545->997|2953->1378|2998->1407|3038->1409|3085->1428|3142->1458|3155->1462|3182->1468|3263->1522|3299->1549|3339->1551|3392->1576|3436->1602|3449->1607|3488->1608|3541->1634|3554->1638|3584->1647|3639->1671|3688->1692|3761->1738|3774->1742|3802->1749|3832->1752|3845->1756|3873->1763|3952->1815|3965->1819|3996->1829|4026->1832|4039->1836|4070->1846|4152->1897|4195->1912|4270->1969|4283->1974|4322->1975|4361->1986|4449->2043|4486->2053|4545->2082|4578->2089|4606->2108|4646->2110|4680->2117|4812->2221|4841->2222|4870->2223|4934->2259|4963->2260|5033->2300|5063->2303|5101->2311
                  LINES: 27->1|30->2|33->3|34->4|34->4|34->4|35->5|54->24|54->24|54->24|55->25|55->25|55->25|55->25|58->28|58->28|58->28|59->29|59->29|59->29|60->30|64->34|64->34|64->34|65->35|76->46|76->46|76->46|77->47|78->48|78->48|78->48|80->50|80->50|80->50|81->51|82->52|82->52|82->52|83->53|83->53|83->53|84->54|85->55|86->56|86->56|86->56|86->56|86->56|86->56|87->57|87->57|87->57|87->57|87->57|87->57|89->59|90->60|93->63|93->63|93->63|94->64|95->65|97->67|99->69|101->71|101->71|101->71|102->72|103->73|103->73|103->73|103->73|103->73|105->75|106->76|107->77
                  -- GENERATED --
              */
          