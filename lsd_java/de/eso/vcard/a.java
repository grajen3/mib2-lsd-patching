/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard;

import de.eso.vcard.b;
import de.eso.vcard.d;
import de.esolutions.fw.util.tracing.TraceClient;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class a {
    static void a(d d2, b b2) {
        String string = URLEncoder.encode("https://212.204.94.235/php_testsuite/vcards.php", "UTF-8");
        URL uRL = new URL(string);
        URLConnection uRLConnection = uRL.openConnection();
        uRLConnection.setDoOutput(false);
        InputStream inputStream = uRLConnection.getInputStream();
        d2.a(inputStream, 0, 0, b2);
    }

    public static void a(String[] stringArray) {
        TraceClient.init("organizer.VCardParser");
        b b2 = new b();
        d d2 = new d(0);
        d2.c();
        System.out.println(new StringBuffer().append("root: ").append(new File(".").getAbsolutePath()).toString());
        Thread.sleep(0);
        a.a(d2, b2);
        Thread.sleep(0);
        d2.b();
        TraceClient.exit();
    }
}

