/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.b;

import java.util.ArrayList;
import java.util.List;

public class d {
    public static final String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private List k = null;
    private String l;
    private String m;
    private List n = null;
    private List o = null;
    private List p = null;
    private List q = null;

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.i;
    }

    public final String c() {
        return this.j;
    }

    public final List d() {
        if (this.k == null) {
            this.k = new ArrayList();
        }
        return this.k;
    }

    public final String e() {
        return this.l;
    }

    public final String f() {
        return this.m;
    }

    public final List g() {
        if (this.n == null) {
            this.n = new ArrayList();
        }
        return this.n;
    }

    public final List h() {
        if (this.o == null) {
            this.o = new ArrayList();
        }
        return this.o;
    }

    public final List i() {
        if (this.p == null) {
            this.p = new ArrayList();
        }
        return this.p;
    }

    public final List j() {
        if (this.q == null) {
            this.q = new ArrayList();
        }
        return this.q;
    }

    public final void a(String string) {
        this.b = string;
    }

    public final void b(String string) {
        this.i = string;
    }

    public final void c(String string) {
        this.j = string;
    }

    public final void d(String string) {
        this.l = string;
    }

    public final void e(String string) {
        this.m = string;
    }

    public final String k() {
        return this.c;
    }

    public final void f(String string) {
        this.c = string;
    }

    public final String l() {
        return this.d;
    }

    public final void g(String string) {
        this.d = string;
    }

    public final String m() {
        return this.f;
    }

    public final void h(String string) {
        this.f = string;
    }

    public final String n() {
        return this.g;
    }

    public final void i(String string) {
        this.g = string;
    }

    public final String o() {
        return this.h;
    }

    public final void j(String string) {
        this.h = string;
    }

    public final String p() {
        return this.e;
    }

    public final void k(String string) {
        this.e = string;
    }
}

