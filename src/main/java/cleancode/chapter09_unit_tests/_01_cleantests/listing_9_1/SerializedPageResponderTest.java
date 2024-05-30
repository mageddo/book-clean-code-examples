package cleancode.chapter09_unit_tests._01_cleantests.listing_9_1;

import cleancode.chapter03_functions._01_small.listing_3_1.HtmlUtil.PageData;
import cleancode.chapter03_functions.support.PageCrawler;
import cleancode.chapter03_functions.support.PathParser;
import cleancode.chapter03_functions.support.WikiPage;
import cleancode.chapter09_unit_tests._01_cleantests.support.FitNesseContext;
import cleancode.chapter09_unit_tests._01_cleantests.support.Request;
import cleancode.chapter09_unit_tests._01_cleantests.support.Responder;
import cleancode.chapter09_unit_tests._01_cleantests.support.SerializedPageResponder;
import cleancode.chapter09_unit_tests._01_cleantests.support.SimpleResponse;
import cleancode.chapter09_unit_tests._01_cleantests.support.SymbolicPage;
import cleancode.chapter09_unit_tests._01_cleantests.support.WikiPageProperties;
import cleancode.chapter09_unit_tests._01_cleantests.support.WikiPageProperty;

import static cleancode.chapter09_unit_tests._01_cleantests.support.Assertions.assertEquals;
import static cleancode.chapter09_unit_tests._01_cleantests.support.Assertions.assertNotSubString;
import static cleancode.chapter09_unit_tests._01_cleantests.support.Assertions.assertSubString;

public class SerializedPageResponderTest {

  PageCrawler crawler;
  Object root;
  Request request;

  public void testGetPageHieratchyAsXml() throws Exception {
    crawler.addPage(root, PathParser.parse("PageOne"));
    crawler.addPage(root, PathParser.parse("PageOne.ChildOne"));
    crawler.addPage(root, PathParser.parse("PageTwo"));
    request.setResource("root");
    request.addInput("type", "pages");
    Responder responder = new SerializedPageResponder();
    SimpleResponse response =
      (SimpleResponse) responder.makeResponse(
        new FitNesseContext(root), request);
    String xml = response.getContent();


    assertEquals("text/xml", response.getContentType());
    assertSubString("<name>PageOne</name>", xml);
    assertSubString("<name>PageTwo</name>", xml);
    assertSubString("<name>ChildOne</name>", xml);
  }

  public void testGetPageHieratchyAsXmlDoesntContainSymbolicLinks()
    throws Exception {
    WikiPage pageOne = crawler.addPage(root, PathParser.parse("PageOne"));
    crawler.addPage(root, PathParser.parse("PageOne.ChildOne"));
    crawler.addPage(root, PathParser.parse("PageTwo"));
    PageData data = pageOne.getData();
    WikiPageProperties properties = data.getProperties();
    WikiPageProperty symLinks = properties.set(SymbolicPage.PROPERTY_NAME);
    symLinks.set("SymPage", "PageTwo");
    pageOne.commit(data);
    request.setResource("root");
    request.addInput("type", "pages");
    Responder responder = new SerializedPageResponder();
    SimpleResponse response =
      (SimpleResponse) responder.makeResponse(
        new FitNesseContext(root), request);
    String xml = response.getContent();


    assertEquals("text/xml", response.getContentType());
    assertSubString("<name>PageOne</name>", xml);
    assertSubString("<name>PageTwo</name>", xml);
    assertSubString("<name>ChildOne</name>", xml);
    assertNotSubString("SymPage", xml);
  }

  public void testGetDataAsHtml() throws Exception {
    crawler.addPage(root, PathParser.parse("TestPageOne"), "test page");
    request.setResource("TestPageOne");
    request.addInput("type", "data");
    Responder responder = new SerializedPageResponder();
    SimpleResponse response =
      (SimpleResponse) responder.makeResponse(
        new FitNesseContext(root), request);
    String xml = response.getContent();
    assertEquals("text/xml", response.getContentType());
    assertSubString("test page", xml);
    assertSubString("<Test", xml);
  }
}
