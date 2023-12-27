/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard.c;

import de.eso.a.a.b;
import java.util.List;
import org.dsi.ifc.organizer.AdbEntry;

class c
implements b {
    int a;
    int b;
    int c;

    public c(int n, int n2) {
        this.a = n;
        this.b = n2;
        this.c = 0;
    }

    @Override
    public void a(List list) {
        this.c += list.size();
        de.eso.a.d.b.c(new StringBuffer().append("\n receivedObjects = ").append(this.c).append(" count of parseResult = ").append(list.size()).append("\n").toString());
        for (int i2 = 0; i2 < list.size(); ++i2) {
            AdbEntry adbEntry = (AdbEntry)list.get(i2);
            de.eso.a.d.b.c(adbEntry.toString());
        }
    }

    @Override
    public int b() {
        return this.a;
    }

    @Override
    public int a() {
        return this.b;
    }
}

