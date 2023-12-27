/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.security.PrivilegedAction;

final class TimeZone$1
implements PrivilegedAction {
    private final /* synthetic */ String val$id;

    TimeZone$1(String string) {
        this.val$id = string;
    }

    @Override
    public Object run() {
        System.setProperty("user.timezone", this.val$id);
        return null;
    }
}

