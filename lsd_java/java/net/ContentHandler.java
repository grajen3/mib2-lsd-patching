/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.net.URLConnection;

public abstract class ContentHandler {
    public abstract Object getContent(URLConnection uRLConnection) {
    }

    public Object getContent(URLConnection uRLConnection, Class[] classArray) {
        Object object = this.getContent(uRLConnection);
        Class clazz = object.getClass();
        int n = 0;
        while (n < classArray.length) {
            if (clazz == classArray[n]) {
                return object;
            }
            ++n;
        }
        return null;
    }
}

