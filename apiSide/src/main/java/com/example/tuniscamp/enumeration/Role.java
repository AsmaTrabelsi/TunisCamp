package com.example.tuniscamp.enumeration;

import static com.example.tuniscamp.constants.Authority.SUPER_ADMIN_AUTHORITIES;
import static com.example.tuniscamp.constants.Authority.USER_AUTHORITIES;

public enum Role {
    ROLE_USER(USER_AUTHORITIES),
    ROLE_SUPER_ADMIN(SUPER_ADMIN_AUTHORITIES);

    private String[] authorities;

    Role(String... authorities) {
        this.authorities = authorities;
    }

    public String[] getAuthorities() {
        return authorities;
    }
}
