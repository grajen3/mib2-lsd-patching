/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.security.PrivilegedAction;
import java.util.Locale;

final class Locale$2
implements PrivilegedAction {
    Locale$2() {
    }

    @Override
    public Object run() {
        return Locale.find("com/ibm/oti/locale/Locale_");
    }
}

