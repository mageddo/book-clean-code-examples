package cleancode.chapter05_formatting._01_vertical_formatting.listing_5_2;

import cleancode.chapter05_formatting._01_vertical_formatting.support.ParentWidget;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class BoldWidget extends ParentWidget {
  public static final String REGEXP = "'''.+?'''";
  private static final Pattern pattern = Pattern.compile("'''(.+?)'''",
    Pattern.MULTILINE + Pattern.DOTALL);
  public BoldWidget(ParentWidget parent, String text) throws Exception {
    super(parent);
    Matcher match = pattern.matcher(text);
    match.find();
    addChildWidgets(match.group(1));
  }
  public String render() throws Exception {
    StringBuffer html = new StringBuffer("<b>");
    html.append(childHtml()).append("</b>");
    return html.toString();
  }
  private char[] childHtml() {
    return null;
  }
  private void addChildWidgets(String group) {
  }
}
