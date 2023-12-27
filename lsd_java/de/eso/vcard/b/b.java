/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard.b;

import de.eso.vcard.b.a;
import java.util.List;
import org.dsi.ifc.organizer.AdbEntry;

class b
implements de.eso.a.a.b {
    private final a a;

    b(a a2) {
        this.a = a2;
    }

    @Override
    public void a(List list) {
        if (list != null && list.size() > 0) {
            de.eso.vcard.b.a.a(this.a, (AdbEntry)list.get(0));
        }
    }

    @Override
    public int a() {
        return 1;
    }

    @Override
    public int b() {
        return 1;
    }
}

