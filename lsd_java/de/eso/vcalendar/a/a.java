/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.a;

import de.eso.a.d.b;
import de.eso.vcalendar.a.f;
import de.esolutions.fw.comm.core.method.MethodException;

public class a
implements de.eso.a.a.a {
    protected f a;
    protected int b;

    public a(int n, f f2) {
        this.a = f2;
        this.b = n;
    }

    @Override
    public void a() {
        if (null == this.a) {
            return;
        }
        try {
            this.a.a(this.b);
        }
        catch (MethodException methodException) {
            de.eso.a.d.b.d("Cannot send reply exportFinished()");
        }
    }
}

