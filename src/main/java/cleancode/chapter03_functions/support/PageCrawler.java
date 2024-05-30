package cleancode.chapter03_functions.support;

public interface PageCrawler {

  WikiPagePath getFullPath(WikiPage page);

  WikiPage addPage(Object parent, Object page);

  void addPage(Object root, Object testPageOne, String testPage);
}
