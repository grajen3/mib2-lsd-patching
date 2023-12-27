/*
 * Decompiled with CFR 0.152.
 */
package de.eso.a.b;

import de.eso.a.b.g;

public class k {
    g a;
    private static final byte e;
    public static final int b;
    public static final int c;
    public static final int d;
    private int f = 0;
    private int g;
    private int h;

    public k(g g2) {
        this.a = g2;
    }

    public void a() {
        this.h = 0;
        this.g = 0;
        this.f = 0;
    }

    public void a(byte by) {
        if (by == 61) {
            this.f = 1;
        } else if (this.f == 1) {
            this.g = k.b(by);
            this.f = 2;
        } else if (this.f == 2) {
            this.h = k.b(by);
            this.c((byte)((this.g << 4) + this.h));
            this.f = 0;
        } else {
            this.c(by);
        }
    }

    static int b(byte by) {
        return Character.digit((char)by, 16);
    }

    public void c(byte by) {
        this.a.a(by);
    }
}

