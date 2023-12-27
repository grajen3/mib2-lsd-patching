/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard.a;

import de.eso.a.d.b;
import de.eso.vcard.a.a;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserReply;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.List;

public class f
extends a {
    private List d;
    private String e;

    public f(int n, List list, String string, VCardParserReply vCardParserReply) {
        super(n, 0, vCardParserReply);
        this.d = list;
        this.e = string;
    }

    @Override
    public void a() {
        if (this.a == null) {
            return;
        }
        try {
            long[] lArray = new long[this.d.size()];
            for (int i2 = 0; i2 < this.d.size(); ++i2) {
                lArray[i2] = (Long)this.d.get(i2);
            }
            this.a.smallExportFinished(0, lArray, 0, this.e, this.b);
        }
        catch (MethodException methodException) {
            de.eso.a.d.b.d("Cannot send reply smallExportFinished() !");
        }
        this.d.clear();
    }
}

