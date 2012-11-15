package de.dranke.learning.ooplecture.conferenctrackmgm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

class TalkParser {

  public Talk parseAsPair(String sessionString) {
    if (isBlank(sessionString)) { return null; }

    return new Talk(getSessionTitle(sessionString), getSessionLength(sessionString));
  }

  private Integer getSessionLength(String sessionString) {
    String[] words = getWords(sessionString);

    String duration = words[words.length - 1];
    if ("lightning".equals(duration.toLowerCase())) {
      return 5;
    }
    return Integer.parseInt(duration.substring(0, 2));
  }

  private String getSessionTitle(String sessionString) {
    String[] words = getWords(sessionString);
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < words.length - 1; i++) {
      stringBuilder.append(words[i] + " ");
    }
    return stringBuilder.toString().trim();
  }

  private String[] getWords(String sessionString) {
    return sessionString.split(" ");
  }

  public List<Talk> parseTalks(Collection<String> talks) {
    ArrayList result = new ArrayList();
    for (String talk : talks) {
      result.add(parseAsPair(talk));
    }
    return result;
  }
}
