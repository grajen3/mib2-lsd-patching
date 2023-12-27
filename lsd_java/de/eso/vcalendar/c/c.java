/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.c;

import de.eso.a.b.a;
import de.eso.a.b.e;
import de.eso.a.b.f;
import de.eso.a.d.b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class c
extends a {
    private BufferedOutputStream E = null;
    private File F = null;
    private static File G = new File("/tmp/vcalendar");
    static final String[] C = new String[]{"BEGIN", "END", "ATTACH", "ACTION", "ATTENDEE", "CATEGORIES", "CLASS", "CREATED", "DESCRIPTION", "DTEND", "DTSTAMP", "DTSTART", "DURATION", "ENCODING", "LAST-MODIFIED", "LOCATION", "METHOD", "ORGANIZER", "PRODID", "RRULE", "SEQUENCE", "SUMMARY", "TZID", "TRANSP", "TRIGGER", "TZNAME", "TZOFFSETFROM", "TZOFFSETTO", "UID", "URL", "VERSION"};
    public static final Collection D = Collections.unmodifiableCollection(Arrays.asList(C));

    public c(File file, f f2) {
        this.o = file;
        this.r = new e(f2);
        this.p = new BufferedInputStream(new FileInputStream(this.o));
    }

    public c(InputStream inputStream, f f2) {
        this.o = null;
        this.p = inputStream;
        this.r = new e(f2);
    }

    public static void a(File file) {
        G = file;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void a(int n) {
        if (this.E != null) {
            try {
                this.E.flush();
                this.E.close();
                if (this.F != null) {
                    de.eso.a.d.b.c(new StringBuffer().append("closed file ").append(this.F).toString());
                    this.r.a(this.F, n);
                } else {
                    de.eso.a.d.b.d("binary file was null!");
                }
            }
            catch (IOException iOException) {
                de.eso.a.d.b.d("error reading binary file!");
            }
            finally {
                this.E = null;
                this.F = null;
            }
        }
    }

    private void b(byte by) {
        if (this.E == null) {
            try {
                if (G.exists() || G.mkdirs()) {
                    String string = ".bin";
                    if ("PHOTO".equalsIgnoreCase(this.x)) {
                        string = ".jpg";
                    }
                    this.w = false;
                    this.v = 0L;
                    this.F = File.createTempFile(new StringBuffer().append("vcalender_").append(this.o.getName()).append("_").append(this.x).toString(), string, G);
                    this.E = new BufferedOutputStream(new FileOutputStream(this.F));
                    de.eso.a.d.b.c(new StringBuffer().append("Writing binary content to :").append(this.F.getAbsolutePath()).toString());
                } else {
                    de.eso.a.d.b.d(new StringBuffer().append("can not create ").append(G.getAbsolutePath()).toString());
                }
            }
            catch (Exception exception) {
                de.eso.a.d.b.d(new StringBuffer().append("Error opening temp file for binary rfc content: ").append(exception.getMessage()).toString());
            }
        }
        if (this.E != null) {
            if (this.w) {
                return;
            }
            if (this.v > de.eso.a.b.a.d()) {
                de.eso.a.d.b.d(new StringBuffer().append("Writing to binary file exceeded quota of ").append(de.eso.a.b.a.d()).append(" bytes").toString());
                this.w = true;
            }
            try {
                this.E.write(by);
            }
            catch (IOException iOException) {
                de.eso.a.d.b.d("Error writing binary content to temp file");
            }
        }
    }

    @Override
    public void a(byte by) {
        this.z = true;
        if (this.t != null && this.s == null) {
            this.b(by);
        } else {
            this.q.a(by);
        }
    }

    @Override
    public void b(String string) {
        if ("BEGIN".equalsIgnoreCase(string)) {
            this.A = true;
            this.y = 0;
        } else if ("END".equalsIgnoreCase(string)) {
            if (this.y == 0) {
                this.c();
                this.B = this.r.g();
                if (this.B) {
                    return;
                }
            }
            this.y = -1;
        }
    }

    protected boolean c(String string) {
        return false;
    }

    static {
        de.eso.vcalendar.c.c.a(C);
    }
}

