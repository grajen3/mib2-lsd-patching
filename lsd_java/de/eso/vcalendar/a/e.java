/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.a;

import de.eso.a.d.b;
import de.eso.vcalendar.a.a;
import de.eso.vcalendar.a.f;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.List;

public class e
extends a {
    private List c;
    private String d;

    public e(int n, f f2, String string, f f3, List list) {
        super(n, f2);
        this.c = list;
        this.d = string;
    }

    @Override
    public void a() {
        if (null == this.a) {
            return;
        }
        try {
            int n = this.c != null && this.c.size() > 0 ? this.c.size() : 0;
            long[] lArray = new long[n];
            for (int i2 = 0; i2 < n; ++i2) {
                lArray[i2] = (Long)this.c.get(i2);
            }
            this.a.a(0, lArray, 0, this.d, this.b);
        }
        catch (MethodException methodException) {
            de.eso.a.d.b.d("cannot send reply smallExportFinished()");
        }
    }
}

