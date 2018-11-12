package io.lenses.security.auth.http.custom;

import io.lenses.security.plugin.HttpAuthenticationPlugin;
import io.lenses.security.plugin.HttpRequest;
import io.lenses.security.plugin.UserAndGroups;

public class SampleTokenBasedAuthPlugin implements HttpAuthenticationPlugin {
  @Override
  public UserAndGroups authenticate(HttpRequest httpRequest) {
    return null;
  }
}
