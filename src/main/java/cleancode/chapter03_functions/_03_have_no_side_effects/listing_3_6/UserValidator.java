package cleancode.chapter03_functions._03_have_no_side_effects.listing_3_6;

import cleancode.chapter03_functions.support.Cryptographer;
import cleancode.chapter03_functions.support.Session;
import cleancode.chapter03_functions.support.User;
import cleancode.chapter03_functions.support.UserGateway;

public class UserValidator {

  private Cryptographer cryptographer;

  public boolean checkPassword(String userName, String password) {
    User user = UserGateway.findByName(userName);
    if (user != User.NULL) {
      String codedPhrase = user.getPhraseEncodedByPassword();
      String phrase = cryptographer.decrypt(codedPhrase, password);
      if ("Valid Password".equals(phrase)) {
        Session.initialize();
        return true;
      }
    }
    return false;
  }

}
