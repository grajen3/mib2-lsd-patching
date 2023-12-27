/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.jar;

import com.ibm.oti.net.www.protocol.jar.JarURLConnection;
import java.io.IOException;
import java.security.PrivilegedAction;

final class JarURLConnection$2
implements PrivilegedAction {
    final /* synthetic */ JarURLConnection this$0;
    private final /* synthetic */ String val$externalForm;

    JarURLConnection$2(JarURLConnection jarURLConnection, String string) {
        this.this$0 = jarURLConnection;
        this.val$externalForm = string;
    }

    @Override
    public Object run() {
        try {
            return this.this$0.openJarFile(null, this.val$externalForm, false);
        }
        catch (IOException iOException) {
            return null;
        }
    }
}

