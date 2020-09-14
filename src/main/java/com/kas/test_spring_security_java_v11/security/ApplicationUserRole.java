package com.kas.test_spring_security_java_v11.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.kas.test_spring_security_java_v11.security.ApplicationUserPermission.*;

public enum  ApplicationUserRole {
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)),
    STUDENT(Sets.newHashSet());

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
