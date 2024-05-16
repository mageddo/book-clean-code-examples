package cleancode.chapter03_functions._01_small.listing_3_1;

import cleancode.chapter03_functions.support.PageCrawlerImpl;
import cleancode.chapter03_functions.support.PathParser;
import cleancode.chapter03_functions.support.WikiPage;
import cleancode.chapter03_functions.support.WikiPagePath;

public class HtmlUtil {
  public static String testableHtml(
    PageData pageData,
    boolean includeSuiteSetup
  ) throws Exception {
    WikiPage wikiPage = pageData.getWikiPage();
    StringBuffer buffer = new StringBuffer();
    if (pageData.hasAttribute("Test")) {
      if (includeSuiteSetup) {
        WikiPage suiteSetup =
          PageCrawlerImpl.getInheritedPage(
            SuiteResponder.SUITE_SETUP_NAME, wikiPage
          );
        if (suiteSetup != null) {
          WikiPagePath pagePath =
            suiteSetup.getPageCrawler().getFullPath(suiteSetup);
          String pagePathName = PathParser.render(pagePath);
          buffer.append("!include -setup .")
            .append(pagePathName)
            .append("\n");
        }
      }
      WikiPage setup =
        PageCrawlerImpl.getInheritedPage("SetUp", wikiPage);
      if (setup != null) {
        WikiPagePath setupPath =
          wikiPage.getPageCrawler().getFullPath(setup);
        String setupPathName = PathParser.render(setupPath);
        buffer.append("!include -setup .")
          .append(setupPathName)
          .append("\n");
      }
    }
    buffer.append(pageData.getContent());
    if (pageData.hasAttribute("Test")) {
      WikiPage teardown =
        PageCrawlerImpl.getInheritedPage("TearDown", wikiPage);
      if (teardown != null) {
        WikiPagePath tearDownPath =
          wikiPage.getPageCrawler().getFullPath(teardown);
        String tearDownPathName = PathParser.render(tearDownPath);
        buffer.append("\n")
          .append("!include -teardown .")
          .append(tearDownPathName)
          .append("\n");
      }
      if (includeSuiteSetup) {
        WikiPage suiteTeardown =
          PageCrawlerImpl.getInheritedPage(
            SuiteResponder.SUITE_TEARDOWN_NAME,
            wikiPage
          );
        if (suiteTeardown != null) {
          WikiPagePath pagePath =
            suiteTeardown.getPageCrawler().getFullPath (suiteTeardown);
          String pagePathName = PathParser.render(pagePath);
          buffer.append("!include -teardown .")
            .append(pagePathName)
            .append("\n");
        }
      }
    }
    pageData.setContent(buffer.toString());
    return pageData.getHtml();
  }

  public  static class PageData {

    public WikiPage getWikiPage() {
      throw new UnsupportedOperationException();
    }

    public boolean hasAttribute(String test) {
      throw new UnsupportedOperationException();
    }

    public char[] getContent() {
      throw new UnsupportedOperationException();
    }

    public void setContent(String string) {
      throw new UnsupportedOperationException();
    }

    public String getHtml() {
      throw new UnsupportedOperationException();
    }
  }

  public  static class SuiteResponder {
    public static final String  SUITE_SETUP_NAME = null;
    public static final String SUITE_TEARDOWN_NAME = null;
  }

}
