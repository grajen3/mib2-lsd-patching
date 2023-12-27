/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.net.URLConnection;
import java.security.PrivilegedAction;

final class URLConnection$1
implements PrivilegedAction {
    final /* synthetic */ URLConnection this$0;
    private final /* synthetic */ String val$typeString;

    URLConnection$1(URLConnection uRLConnection, String string) {
        this.this$0 = uRLConnection;
        this.val$typeString = string;
    }

    @Override
    public Object run() {
        try {
            String string = new StringBuffer("com.ibm.oti.www.content.").append(this.val$typeString).toString();
            return Class.forName(string).newInstance();
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (InstantiationException instantiationException) {}
        return null;
    }
}

