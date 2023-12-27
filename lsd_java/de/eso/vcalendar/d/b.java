/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.d;

import de.eso.a.c.a;
import de.eso.vcalendar.d.c;
import de.esolutions.fw.util.tracing.TraceClient;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class b {
    private static final String a;
    private static final String[] b;

    public static void a(String[] stringArray) {
        TraceClient.init("vcalender=1");
        URL uRL = new URL("http://212.204.94.235/php_testsuite/vcards.php");
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
        outputStreamWriter.write("icalendar");
        outputStreamWriter.close();
        InputStream inputStream = httpURLConnection.getInputStream();
        a a2 = new a(inputStream, (de.eso.a.c.b)new c());
        a2.a();
        TraceClient.exit();
    }

    static {
        b = new String[]{"bayram.ics", "test_attaced.ics", "test.ics"};
    }
}

