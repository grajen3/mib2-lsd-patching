/*
 * Decompiled with CFR 0.152.
 */
package de.eso.a.b;

import de.eso.a.b.g;

public class b {
    g a;
    private static final byte[] b = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
    private static final int c;
    private static final byte d;
    private int e = 0;
    private boolean f = false;
    private int g = 0;

    public b(g g2) {
        this.a = g2;
    }

    public void a() {
        this.f = false;
        this.e = 0;
        this.g = 0;
    }

    public void a(byte by) {
        byte by2;
        if (this.f) {
            return;
        }
        if (by == 61) {
            this.f = true;
        } else if (by >= 0 && by < b.length && (by2 = b[by]) >= 0) {
            ++this.e;
            this.e %= 4;
            this.g = (this.g << 6) + by2;
            if (this.e == 0) {
                this.b((byte)(this.g >> 16 & 0xFF));
                this.b((byte)(this.g >> 8 & 0xFF));
                this.b((byte)(this.g & 0xFF));
            }
        }
        if (this.f && this.e != 0) {
            this.g <<= 6;
            switch (this.e) {
                case 2: {
                    this.g <<= 6;
                    this.b((byte)(this.g >> 16 & 0xFF));
                    break;
                }
                case 3: {
                    this.b((byte)(this.g >> 16 & 0xFF));
                    this.b((byte)(this.g >> 8 & 0xFF));
                    break;
                }
            }
        }
    }

    public void b(byte by) {
        this.a.a(by);
    }
}

