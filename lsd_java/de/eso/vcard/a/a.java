/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard.a;

import de.eso.a.d.b;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserReply;
import de.esolutions.fw.comm.core.method.MethodException;

public class a
implements de.eso.a.a.a {
    protected VCardParserReply a;
    protected int b;
    protected int c;

    public a(int n, int n2, VCardParserReply vCardParserReply) {
        this.a = vCardParserReply;
        this.b = n;
        this.c = n2;
    }

    @Override
    public void a() {
        if (this.a == null) {
            return;
        }
        try {
            this.a.exportFinished(this.b, this.c);
        }
        catch (MethodException methodException) {
            de.eso.a.d.b.d("Cannot send reply exportFinished() !");
        }
    }
}

