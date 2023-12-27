/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.security.BasicPermission;

public final class NetPermission
extends BasicPermission {
    public NetPermission(String string) {
        super(string);
    }

    public NetPermission(String string, String string2) {
        super(string, string2);
    }
}

