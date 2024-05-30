package cleancode.chapter09_unit_tests._01_cleantests.listing_9_2;

import cleancode.chapter03_functions.support.WikiPage;

public class SerializedPageResponderTest {

  public void testGetPageHierarchyAsXml() throws Exception {
    makePages("PageOne", "PageOne.ChildOne", "PageTwo");
    submitRequest("root", "type:pages");
    assertResponseIsXML();
    assertResponseContains(
      "<name>PageOne</name>", "<name>PageTwo</name>", "<name>ChildOne</name>"
    );
  }

  public void testSymbolicLinksAreNotInXmlPageHierarchy() throws Exception {
    WikiPage page = makePage("PageOne");
    makePages("PageOne.ChildOne", "PageTwo");
    addLinkTo(page, "PageTwo", "SymPage");
    submitRequest("root", "type:pages");
    assertResponseIsXML();
    assertResponseContains(
      "<name>PageOne</name>", "<name>PageTwo</name>", "<name>ChildOne</name>"
    );
    assertResponseDoesNotContain("SymPage");
  }


  public void testGetDataAsXml() throws Exception {
    makePageWithContent("TestPageOne", "test page");
    submitRequest("TestPageOne", "type:data");
    assertResponseIsXML();
    assertResponseContains("test page", "<Test");
  }

  private void assertResponseContains(String testPage, String s) {

  }

  private void makePageWithContent(String testPageOne, String testPage) {

  }

  private void assertResponseDoesNotContain(String symPage) {

  }

  private void assertResponseContains(String s, String s1, String s2) {

  }

  private void assertResponseIsXML() {

  }

  private void submitRequest(String root, String s) {

  }

  private void makePages(String s, String pageTwo) {

  }

  private void addLinkTo(WikiPage page, String pageTwo, String symPage) {

  }

  private WikiPage makePage(String pageOne) {
    return null;
  }


  private void makePages(String pageOne, String s, String pageTwo) {

  }
}
