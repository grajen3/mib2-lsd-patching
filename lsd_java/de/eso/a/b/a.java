/*
 * Decompiled with CFR 0.152.
 */
package de.eso.a.b;

import de.eso.a.b.b;
import de.eso.a.b.c;
import de.eso.a.b.e;
import de.eso.a.b.g;
import de.eso.a.b.k;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class a
implements g {
    public static final int a;
    public static final String b;
    public static final int c;
    public static final int d;
    public static final char e;
    public static final int f;
    public static final int g;
    public static final int h;
    public static final int i;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    protected File o;
    protected InputStream p;
    protected c q = new c(4096);
    private b C = new b(this);
    private k D = new k(this);
    protected e r;
    protected String s = null;
    protected String t = null;
    static long u;
    protected long v = 0L;
    protected boolean w = false;
    protected String x = null;
    private int E = 0;
    protected int y = -1;
    private int F = 0;
    protected boolean z = false;
    protected boolean A = false;
    private boolean G = false;
    private boolean H = false;
    private boolean I = false;
    protected boolean B = false;
    private static Set J;
    private boolean K = true;
    private int L = 0;
    private int M = 0;
    private char N = '\u0000';

    public void a() {
        boolean bl = false;
        if (this.o == null && this.p == null) {
            return;
        }
        if (this.o != null) {
            bl = true;
            de.eso.a.d.b.c(new StringBuffer().append("BEGIN PARSING ").append(this.o.getAbsolutePath()).toString());
        } else {
            de.eso.a.d.b.c("BEGIN PARSING inputStream");
        }
        byte[] byArray = new byte[255];
        int n = 0;
        int n2 = 0;
        try {
            int n3 = this.p.available();
            de.eso.a.d.b.c(new StringBuffer().append("availableBytes = ").append(n3).append("").toString());
            while ((n = this.p.read(byArray)) != -1) {
                this.a(byArray, n);
                if ((n2 += n) > 2048 && !this.A) {
                    this.d(new StringBuffer().append("2048 bytes have been read and no BEGIN of rfc-tag was found. Skipping the rest of the file. Bytes skipped:").append(n3 - n2).toString());
                    this.B = true;
                    break;
                }
                if (!this.B) continue;
                if (n3 <= n2) break;
                this.d(new StringBuffer().append("First rfc-tag of file read or cancelled. Rest of file is being ommitted. Bytes skipped: ").append(n3 - n2).toString());
                break;
            }
            if (!this.B) {
                this.c();
                this.B = true;
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            throw fileNotFoundException;
        }
        catch (IOException iOException) {
            throw iOException;
        }
        finally {
            if (this.p != null) {
                this.p.close();
            }
        }
        if (bl) {
            de.eso.a.d.b.c(new StringBuffer().append("END PARSING ").append(this.o.getAbsolutePath()).toString());
        } else {
            de.eso.a.d.b.c("END PARSING inputStream");
        }
    }

    public final void b() {
        this.B = true;
    }

    private void a(byte[] byArray, int n) {
        for (int i2 = 0; i2 < n; ++i2) {
            byte by = byArray[i2];
            if (this.M == 0) {
                if (by != 66 && by != 98) continue;
                this.M = 1;
            }
            this.b(by);
            if (this.B) break;
        }
    }

    private void b(byte by) {
        this.c(by);
        if (!this.I) {
            this.d(by);
        } else {
            this.I = false;
        }
    }

    private void c(byte by) {
        if (this.L == 0) {
            if (by == 13) {
                if ("QUOTED-PRINTABLE".equalsIgnoreCase(this.t)) {
                    if (this.N == '=') {
                        this.L = 3;
                        this.D.a();
                        this.N = '\u0000';
                    }
                } else {
                    this.L = 1;
                }
                this.I = true;
            } else if (by == 10) {
                this.L = 2;
            }
        } else if (this.L == 1) {
            if (by == 10) {
                this.L = 2;
                ++this.E;
            } else {
                this.L = 0;
            }
            this.I = true;
        } else if (this.L == 2) {
            if (by == 9 || by == 32) {
                this.L = 0;
                this.I = true;
            } else if (by == 10) {
                this.L = 2;
                ++this.E;
            } else {
                this.l();
            }
        } else if (this.L == 3) {
            this.L = 0;
            this.I = true;
        }
    }

    private void d(byte by) {
        if (this.L != 0) {
            return;
        }
        if (!this.n() && this.M != 1) {
            return;
        }
        if (this.M == 4) {
            return;
        }
        if (this.M == 3 && by != 59 && by != 44) {
            if ("BASE64".equalsIgnoreCase(this.t) || "B".equalsIgnoreCase(this.t)) {
                this.C.a(by);
                return;
            }
            if ("QUOTED-PRINTABLE".equalsIgnoreCase(this.t)) {
                this.D.a(by);
                this.N = (char)by;
                return;
            }
        }
        if (by == 59) {
            if (this.N == '\\') {
                this.q.a(by);
                this.e();
            } else if (this.M == 1) {
                this.g();
                if (this.M != 4) {
                    this.M = 2;
                }
            } else if (this.M == 2) {
                this.i();
            } else if (this.M == 3) {
                this.z = true;
                this.k();
            } else {
                this.d("unhandled state for SEMICOLON input!");
            }
        } else if (by == 44) {
            if (this.N == '\\') {
                this.q.a(by);
            } else if (this.M == 2) {
                this.i();
            } else if (this.M == 3) {
                this.j();
            } else {
                this.d("unhandled state for COMMA input!");
            }
        } else if (by == 58) {
            if (this.N == '\\') {
                this.q.a(by);
            } else if (this.M == 1) {
                this.g();
                if (this.M != 4) {
                    this.M = 3;
                }
            } else if (this.M == 2) {
                this.i();
                this.M = 3;
            } else if (this.M == 3) {
                this.q.a(by);
            } else {
                this.d("unhandled state for COLON input!");
            }
        } else if (by == 46) {
            if (this.M == 1) {
                this.f();
            } else {
                this.q.a(by);
            }
        } else if (by == 92) {
            if (de.eso.a.b.a.a(this.s)) {
                this.q.a(by);
                return;
            }
            if (this.N == '\\') {
                this.q.a(by);
                this.N = '\u0000';
                return;
            }
            this.N = (char)92;
        } else if (by == 110 && this.N == '\\') {
            this.q.a((byte)10);
        } else if (by == 61) {
            if (this.M == 2) {
                this.h();
            } else {
                this.q.a(by);
            }
        } else {
            this.q.a(by);
            if (this.M == 3) {
                this.z = true;
            }
        }
        this.N = (char)by;
    }

    private void e() {
        int n = this.q.c();
        if (n > 76 && n % 76 == 0) {
            de.eso.a.d.b.a("very long line. Usually line breaks should be applied after 76 chars in a vcard");
        }
    }

    private void f() {
        String string = this.m();
        this.r.d(string);
        this.q.a();
    }

    private void g() {
        this.x = this.m();
        this.q.a();
        if (this.x == null) {
            return;
        }
        this.x = this.x.toUpperCase();
        this.a(J.contains(this.x));
        if (!this.n()) {
            this.d(new StringBuffer().append("rfc-Reader does not support property ").append(this.x).toString());
        }
        this.b(this.x);
        if (this.y != 0) {
            this.M = 4;
        } else {
            this.r.a(this.x);
        }
    }

    public final void c() {
        this.r.d();
    }

    private void h() {
        String string = this.m();
        this.q.a();
        if ("CHARSET".equalsIgnoreCase(string)) {
            this.G = true;
        } else if ("ENCODING".equalsIgnoreCase(string)) {
            this.H = true;
        } else {
            this.H = false;
            this.G = false;
        }
        this.r.b(string);
    }

    private void i() {
        String string = this.m();
        this.q.a();
        if ("BASE64".equalsIgnoreCase(string)) {
            this.t = string;
        }
        if (this.G) {
            this.s = string;
            if ("GB2312".equalsIgnoreCase(string)) {
                this.s = "GB18030";
            }
            this.G = false;
        } else if (this.H) {
            this.t = string;
            this.H = false;
        }
        this.r.c(string);
    }

    private void j() {
        this.q.a(this.c(" "));
    }

    private void k() {
        if (!this.z) {
            this.d("line without value!");
            return;
        }
        if ("PHOTO".equalsIgnoreCase(this.x)) {
            this.a(this.F);
        } else if ("X-MIB_HIGH_NAV_LOCATION".equalsIgnoreCase(this.x)) {
            if (this.q.d()) {
                de.eso.a.d.b.d("Reading caused a buffer overflow. NAV_LOCATION is being ignored.");
            } else {
                byte[] byArray = this.q.b();
                this.r.a(byArray, this.F);
            }
        } else {
            this.r.a(this.m(), this.F);
        }
        this.q.a();
        ++this.F;
    }

    private void l() {
        if (this.z) {
            this.k();
        }
        this.L = 0;
        this.M = 1;
        this.s = null;
        this.t = null;
        this.x = null;
        this.q.a();
        this.C.a();
        this.D.a();
        this.z = false;
        this.F = 0;
        this.r.e();
        this.a(true);
    }

    private String m() {
        String string;
        if (this.q.c() < 1) {
            return null;
        }
        byte[] byArray = this.q.b();
        if (this.s != null) {
            try {
                string = new String(byArray, this.s);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                this.e(new StringBuffer().append("Charset not supported: ").append(this.s).toString());
                string = new String(byArray);
            }
        } else {
            try {
                string = new String(byArray, "UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                this.e(new StringBuffer().append("Charset not supported: ").append(this.s).toString());
                string = new String(byArray);
            }
        }
        return string;
    }

    private byte[] c(String string) {
        try {
            if (this.s == null) {
                return string.getBytes("UTF-8");
            }
            return string.getBytes(this.s);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            this.e(new StringBuffer().append("Charset not supported: ").append(this.s).toString());
            return string.getBytes();
        }
    }

    private void a(boolean bl) {
        this.K = bl;
        this.r.a(bl);
    }

    private boolean n() {
        return this.K;
    }

    private void d(String string) {
        String string2 = this.o == null ? this.p.toString() : this.o.getAbsolutePath();
        String string3 = new StringBuffer().append(string2).append(" line ").append(this.E).append(" ").append(string).toString();
        de.eso.a.d.b.a(new StringBuffer().append(super.getClass().getName()).append(" | ").append(string3).toString());
    }

    private void e(String string) {
        String string2 = this.o == null ? this.p.toString() : this.o.getAbsolutePath();
        String string3 = new StringBuffer().append(string2).append(" line ").append(this.E).append(" ").append(string).toString();
        de.eso.a.d.b.d(new StringBuffer().append(super.getClass().getName()).append(" | ").append(string3).toString());
    }

    public static void a(String[] stringArray) {
        J = new HashSet();
        J.addAll(Arrays.asList(stringArray));
    }

    public static void a(long l) {
        u = l;
    }

    public static long d() {
        return u;
    }

    public static final boolean a(String string) {
        if (string == null) {
            return false;
        }
        String[] stringArray = new String[]{"x-sjis", "shift_jis", "sjis", "ms_kanji", "shift-jis", "csShiftJIS"};
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (!stringArray[i2].equalsIgnoreCase(string)) continue;
            return true;
        }
        return false;
    }

    static {
        u = 0;
    }
}

