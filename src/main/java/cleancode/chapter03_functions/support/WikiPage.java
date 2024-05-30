package cleancode.chapter03_functions.support;

import cleancode.chapter03_functions._01_small.listing_3_1.HtmlUtil;

public class WikiPage {

  public PageCrawlerImpl getPageCrawler() {
    throw new UnsupportedOperationException();
  }

  public HtmlUtil.PageData getData() {
    return null;
  }

  public void commit(HtmlUtil.PageData data) {

  }
}
