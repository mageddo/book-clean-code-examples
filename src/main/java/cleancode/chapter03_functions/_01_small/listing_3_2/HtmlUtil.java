package cleancode.chapter03_functions._01_small.listing_3_2;

import cleancode.chapter03_functions._01_small.listing_3_1.HtmlUtil.PageData;
import cleancode.chapter03_functions._01_small.listing_3_1.HtmlUtil.WikiPage;

public class HtmlUtil {
  public static String renderPageWithSetupsAndTeardowns(
    PageData pageData, boolean isSuite
  ) throws Exception {
    boolean isTestPage = pageData.hasAttribute("Test");
    if (isTestPage) {
      WikiPage testPage = pageData.getWikiPage();
      StringBuffer newPageContent = new StringBuffer();
      includeSetupPages(testPage, newPageContent, isSuite);
      newPageContent.append(pageData.getContent());
      includeTeardownPages(testPage, newPageContent, isSuite);
      pageData.setContent(newPageContent.toString());
    }
    return pageData.getHtml();
  }

  static void includeTeardownPages(WikiPage testPage, StringBuffer newPageContent, boolean isSuite) {

  }

  static void includeSetupPages(WikiPage testPage, StringBuffer newPageContent, boolean isSuite) {

  }
}
