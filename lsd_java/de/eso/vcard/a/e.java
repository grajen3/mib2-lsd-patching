/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard.a;

import de.eso.a.a.a;
import de.eso.a.d.b;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserReply;
import de.esolutions.fw.comm.core.method.MethodException;

public class e
implements a {
    protected VCardParserReply a;
    protected int b;

    public e(int n, VCardParserReply vCardParserReply) {
        this.a = vCardParserReply;
        this.b = n;
    }

    @Override
    public void a() {
        if (this.a == null) {
            return;
        }
        try {
            this.a.parsingFinished(this.b);
        }
        catch (MethodException methodException) {
            de.eso.a.d.b.d("Cannot send reply parsingFinished() !");
        }
    }
}

