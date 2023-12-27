/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.jar;

import com.ibm.oti.net.www.protocol.jar.JarURLConnection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.PrivilegedAction;

final class JarURLConnection$3
implements PrivilegedAction {
    final /* synthetic */ JarURLConnection this$0;
    private final /* synthetic */ InputStream val$is;
    private final /* synthetic */ String val$externalForm;

    JarURLConnection$3(JarURLConnection jarURLConnection, InputStream inputStream, String string) {
        this.this$0 = jarURLConnection;
        this.val$is = inputStream;
        this.val$externalForm = string;
    }

    @Override
    public Object run() {
        try {
            File file = File.createTempFile("j9jar_", ".tmp", null);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] byArray = new byte[4096];
            int n = 0;
            while ((n = this.val$is.read(byArray)) > -1) {
                fileOutputStream.write(byArray, 0, n);
            }
            fileOutputStream.close();
            String string = file.getPath();
            if (this.this$0.getUseCaches()) {
                return this.this$0.openJarFile(string, this.val$externalForm, true);
            }
            return this.this$0.openJarFile(string, string, true);
        }
        catch (IOException iOException) {
            return null;
        }
    }
}

