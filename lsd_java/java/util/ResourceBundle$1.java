/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.security.PrivilegedAction;

final class ResourceBundle$1
implements PrivilegedAction {
    private final /* synthetic */ ClassLoader val$loader;
    private final /* synthetic */ String val$fileName;

    ResourceBundle$1(ClassLoader classLoader, String string) {
        this.val$loader = classLoader;
        this.val$fileName = string;
    }

    @Override
    public Object run() {
        return this.val$loader == null ? ClassLoader.getSystemResourceAsStream(new StringBuffer(String.valueOf(this.val$fileName)).append(".properties").toString()) : this.val$loader.getResourceAsStream(new StringBuffer(String.valueOf(this.val$fileName)).append(".properties").toString());
    }
}

