/*
 * Decompiled with CFR 0.152.
 */
package de.eso.a.b;

import de.eso.a.d.b;
import java.io.ByteArrayOutputStream;

public class c {
    private ByteArrayOutputStream a;
    private boolean b = false;
    private int c;

    public c(int n) {
        this.c = n;
        this.a = new ByteArrayOutputStream();
    }

    public void a(byte by) {
        if (this.c() >= this.c - 1) {
            if (!this.b) {
                this.b = true;
                de.eso.a.d.b.d("Buffer overflow in VCardReader. You seem to have a very unusual VCard.");
            }
            return;
        }
        this.a.write(by);
    }

    public void a(byte[] byArray) {
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            this.a(byArray[i2]);
        }
    }

    public void a() {
        this.b = false;
        this.a = new ByteArrayOutputStream();
    }

    public byte[] b() {
        return this.a.toByteArray();
    }

    public int c() {
        return this.a.size();
    }

    public boolean d() {
        return this.b;
    }
}

