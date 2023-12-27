/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.security.BasicPermission;

public final class SerializablePermission
extends BasicPermission {
    private static final long serialVersionUID;
    private String actions;

    public SerializablePermission(String string) {
        super(string);
    }

    public SerializablePermission(String string, String string2) {
        super(string, string2);
    }
}

