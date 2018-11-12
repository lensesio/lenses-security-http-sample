package io.lenses.security.auth.http.custom;

import io.lenses.security.plugin.Header;
import io.lenses.security.plugin.HttpAuthenticationPlugin;
import io.lenses.security.plugin.HttpRequest;
import io.lenses.security.plugin.UserAndGroups;

public class HeaderTokenAuthPlugin implements HttpAuthenticationPlugin {

  private static final String API_HEADER_NAME = "API_KEY";

  private final UserStore store = new UserStore();

  @Override
  public UserAndGroups authenticate(HttpRequest httpRequest) {
    // find the header that contains our api key
    Header header = httpRequest.getHeaders().stream().filter(it -> it.getName().equals(API_HEADER_NAME)).findFirst().orElse(null);
    if (header == null)
      return null;
    // if the header is present then we use it to look up a user in the user store
    return store.getUser(header.getValue());
  }
}
