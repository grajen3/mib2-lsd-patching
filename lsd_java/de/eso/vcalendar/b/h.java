/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.b;

import java.util.ArrayList;
import java.util.List;

public class h {
    public static final String a;
    private String d;
    List b;
    List c;

    public final List a() {
        if (null == this.c) {
            this.c = new ArrayList();
        }
        return this.c;
    }

    public final List b() {
        if (null == this.b) {
            this.b = new ArrayList();
        }
        return this.b;
    }

    public final String c() {
        return this.d;
    }

    public final void a(String string) {
        this.d = string;
    }
}

