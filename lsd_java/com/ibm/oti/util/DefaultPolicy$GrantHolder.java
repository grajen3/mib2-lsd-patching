/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import java.security.CodeSource;
import java.security.Permission;
import java.security.Permissions;

class DefaultPolicy$GrantHolder {
    private CodeSource codeSource;
    private String signedBy;
    private Permissions permissions;

    DefaultPolicy$GrantHolder() {
    }

    void setCodeSource(CodeSource codeSource) {
        this.codeSource = codeSource;
    }

    CodeSource getCodeSource() {
        return this.codeSource;
    }

    Permissions getPermissions() {
        return this.permissions;
    }

    void setSigner(String string) {
        this.signedBy = string;
    }

    String getSigner() {
        return this.signedBy;
    }

    void addPermission(Permission permission) {
        if (this.permissions == null) {
            this.permissions = new Permissions();
        }
        this.permissions.add(permission);
    }
}

