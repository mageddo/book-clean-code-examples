package cleancode.chapter03_functions._01_small.listing_3_3;

import cleancode.chapter03_functions._01_small.listing_3_1.HtmlUtil.PageData;

public class HtmlUtil {
  public static String renderPageWithSetupsAndTeardowns(PageData pageData, boolean isSuite) throws Exception {
    if (isTestPage(pageData))
      includeSetupAndTeardownPages(pageData, isSuite);
    return pageData.getHtml();
  }

  private static void includeSetupAndTeardownPages(PageData pageData, boolean isSuite) {
    throw new UnsupportedOperationException();
  }

  private static boolean isTestPage(PageData pageData) {
    throw new UnsupportedOperationException();
  }
}
