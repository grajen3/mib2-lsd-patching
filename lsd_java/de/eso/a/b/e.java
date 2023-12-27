/*
 * Decompiled with CFR 0.152.
 */
package de.eso.a.b;

import de.eso.a.b.f;
import de.eso.a.d.b;
import java.io.File;

public class e
implements f {
    private int a = -1;
    private boolean b = true;
    private f c = null;
    private f d = null;

    public e(f f2) {
        this.d = f2;
        this.c = f2;
    }

    public void a() {
        ++this.a;
        this.h();
    }

    public void b() {
        --this.a;
        this.h();
    }

    public int c() {
        return this.a;
    }

    private void h() {
        if (this.a == 0) {
            this.c = this.d;
        } else {
            de.eso.a.d.b.a("warning: nestedVCardLevel != 0, ignoring information as nested VCards are not supported.");
            this.c = null;
        }
    }

    @Override
    public void a(String string) {
        if (this.c != null) {
            this.c.a(string);
        }
    }

    @Override
    public void b(String string) {
        if (this.c != null) {
            this.c.b(string);
        }
    }

    @Override
    public void c(String string) {
        if (this.c != null) {
            this.c.c(string);
        }
    }

    @Override
    public void a(String string, int n) {
        if (this.c != null) {
            this.c.a(string, n);
        }
    }

    @Override
    public void d() {
        if (this.c != null) {
            this.c.d();
        }
    }

    @Override
    public void e() {
        if (this.c != null) {
            this.c.e();
        }
    }

    @Override
    public void a(File file, int n) {
        if (this.c != null) {
            this.c.a(file, n);
        }
    }

    @Override
    public void a(byte[] byArray, int n) {
        if (this.c != null) {
            this.c.a(byArray, n);
        }
    }

    public boolean f() {
        return this.b;
    }

    public void a(boolean bl) {
        this.b = bl;
        this.c = bl ? this.d : null;
    }

    @Override
    public void d(String string) {
        if (this.c != null) {
            this.c.d(string);
        }
    }

    @Override
    public boolean g() {
        return this.d.g();
    }
}

