/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard.c;

import de.eso.a.c.a;
import de.eso.vcard.b.g;
import de.eso.vcard.c.d;
import de.esolutions.fw.util.tracing.TraceClient;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class b {
    private File n() {
        File file = new File("test/eso_test_vcards/bigVCards2.vcf");
        de.eso.a.d.b.c(new StringBuffer().append("file = ").append(file.getAbsolutePath()).toString());
        return file;
    }

    InputStream a(boolean bl, String string) {
        URL uRL = new URL("http://212.204.94.235/php_testsuite/vcards.php");
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        httpURLConnection.setDoOutput(bl);
        if (bl) {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
            outputStreamWriter.write(string);
            outputStreamWriter.close();
        }
        httpURLConnection.setRequestMethod("POST");
        return httpURLConnection.getInputStream();
    }

    private void o() {
        File file = new File("/ramdisk/vcard");
        File[] fileArray = file.listFiles();
        boolean bl = false;
        if (fileArray != null && fileArray.length > 0) {
            for (int i2 = 0; i2 < fileArray.length; ++i2) {
                bl = fileArray[i2].delete();
                de.eso.a.d.b.c(new StringBuffer().append("delete result of the file :").append(fileArray[i2].getAbsolutePath()).append(" = ").append(bl).toString());
            }
        }
    }

    public void a() {
        a a2 = new a(this.n(), (de.eso.a.c.b)new d(10, 30));
        a2.a();
    }

    public void b() {
        a a2 = new a(this.n(), (de.eso.a.c.b)new d(4, 50));
        a2.a();
    }

    public void c() {
        a a2 = new a(this.n(), (de.eso.a.c.b)new d(10, 299));
        a2.a();
    }

    public void d() {
        a a2 = new a(this.n(), (de.eso.a.c.b)new d(1, 5));
        a2.a();
    }

    public void e() {
        a a2 = new a(this.n(), (de.eso.a.c.b)new d(1, 1));
        a2.a();
    }

    public void f() {
        File file = new File("test/eso_test_vcards/bigVCards.vcf");
        a a2 = new a(file, (de.eso.a.c.b)new d(2, 150));
        a2.a();
    }

    public void g() {
        a a2 = new a(this.n(), (de.eso.a.c.b)new d());
        a2.a();
    }

    public void h() {
        a a2 = new a(this.a(false, null), (de.eso.a.c.b)new d(1, 1));
        a2.a();
    }

    public void i() {
        a a2 = new a(this.a(false, null), (de.eso.a.c.b)new d(10, 50));
        a2.a();
    }

    public void j() {
        a a2 = new a(this.a(false, null), (de.eso.a.c.b)new d(10, 30));
        a2.a();
    }

    public void k() {
        a a2 = new a(this.a(false, null), (de.eso.a.c.b)new d(10, 299));
        a2.a();
    }

    public void l() {
        a a2 = new a(this.a(false, null), (de.eso.a.c.b)new d(1, 5));
        a2.a();
    }

    public void m() {
        this.o();
        long l = 0L;
        long l2 = 0L;
        long l3 = 0L;
        l = System.currentTimeMillis();
        this.g();
        l3 = System.currentTimeMillis();
        de.eso.a.d.b.c(new StringBuffer().append("StartTime = ").append(l).toString());
        de.eso.a.d.b.c(new StringBuffer().append("Parse from file in ms = ").append(l2 - l).toString());
        de.eso.a.d.b.c(new StringBuffer().append("Parse from Stream in ms = ").append(l3 - l2).toString());
        de.eso.a.d.b.c(new StringBuffer().append("time in millis in ms = ").append(l3 - l).toString());
        File file = new File("/ramdisk/vcard");
        File[] fileArray = file.listFiles();
        if (fileArray != null && fileArray.length > 0) {
            de.eso.a.d.b.c(new StringBuffer().append("importet images:  ").append(fileArray.length).toString());
        } else {
            de.eso.a.d.b.c("importet images:  0");
        }
    }

    public static void a(String[] stringArray) {
        g.a((String[])de.eso.vcard.d.b.toArray(new String[0]));
        File file = new File("test/");
        file = new File("test/eso_test_vcards/photo.vcf");
        a a2 = new a(file, (de.eso.a.c.b)new d());
        a2.a();
        Thread.sleep(0);
        TraceClient.exit();
    }
}

