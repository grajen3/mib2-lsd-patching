/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.b;

import java.io.ByteArrayOutputStream;

public class b {
    public static final String a;
    private String b;
    private String c;
    private ByteArrayOutputStream d;

    public void a(ByteArrayOutputStream byteArrayOutputStream) {
        this.d = byteArrayOutputStream;
    }

    public ByteArrayOutputStream a() {
        return this.d;
    }

    public void a(String string) {
        this.c = string;
    }

    public String b() {
        return this.c;
    }

    public void b(String string) {
        this.b = string;
    }

    public String c() {
        return this.b;
    }
}

