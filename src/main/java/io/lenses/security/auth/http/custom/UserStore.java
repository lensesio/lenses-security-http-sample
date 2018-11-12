package io.lenses.security.auth.http.custom;

import io.lenses.security.plugin.UserAndGroups;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Keeps track of API keys and the users they are registered to.
 * In a real system, this would be backed by a database or some
 * other store.
 */
public class UserStore {

    private final Map<String, UserAndGroups> users = new HashMap<>();

    {
        users.put("KEY-1", new UserAndGroups("Sam", Collections.singleton("AdminGroup")));
        users.put("KEY-2", new UserAndGroups("Stef", Collections.singleton("WriteGroup")));
        users.put("KEY-3", new UserAndGroups("Ant", Collections.singleton("ReadGroup")));
    }

    public UserAndGroups getUser(String key) {
        return users.get(key);
    }
}
