/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard;

import de.eso.vcard.a.a;
import de.eso.vcard.a.b;
import de.eso.vcard.a.e;
import de.eso.vcard.a.f;
import de.eso.vcard.a.g;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserReply;
import de.esolutions.fw.util.commons.queue.QueueShutdownException;
import de.esolutions.fw.util.commons.queue.QueueWorker;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import org.dsi.ifc.organizer.AdbEntry;

public class c
extends QueueWorker {
    public c(String string, int n) {
        super(string, n);
    }

    public void a(File file, int n, int n2, VCardParserReply vCardParserReply) {
        b b2 = new b(file, n, n2, vCardParserReply);
        try {
            this.addToQueue(b2);
        }
        catch (QueueShutdownException queueShutdownException) {
            // empty catch block
        }
    }

    public void a(InputStream inputStream, int n, int n2, VCardParserReply vCardParserReply) {
        b b2 = new b(inputStream, n, n2, vCardParserReply);
        try {
            this.addToQueue(b2);
        }
        catch (QueueShutdownException queueShutdownException) {
            // empty catch block
        }
    }

    public void a(AdbEntry adbEntry, String string, int n, VCardParserReply vCardParserReply) {
        g g2 = new g(adbEntry, string, n, false, null, vCardParserReply);
        try {
            this.addToQueue(g2);
        }
        catch (QueueShutdownException queueShutdownException) {
            // empty catch block
        }
    }

    public void a(AdbEntry adbEntry, String string, int n, List list, VCardParserReply vCardParserReply) {
        g g2 = new g(adbEntry, string, n, true, list, vCardParserReply);
        try {
            this.addToQueue(g2);
        }
        catch (QueueShutdownException queueShutdownException) {
            // empty catch block
        }
    }

    public void a(int n, VCardParserReply vCardParserReply) {
        e e2 = new e(n, vCardParserReply);
        try {
            this.addToQueue(e2);
        }
        catch (QueueShutdownException queueShutdownException) {
            // empty catch block
        }
    }

    @Override
    protected void handleQueuedObject(Object object) {
        de.eso.a.a.a a2 = (de.eso.a.a.a)object;
        a2.a();
    }

    public void a(int n, int n2, VCardParserReply vCardParserReply) {
        a a2 = new a(n, n2, vCardParserReply);
        try {
            this.addToQueue(a2);
        }
        catch (QueueShutdownException queueShutdownException) {
            // empty catch block
        }
    }

    public void a(int n, List list, String string, VCardParserReply vCardParserReply) {
        f f2 = new f(n, list, string, vCardParserReply);
        try {
            this.addToQueue(f2);
        }
        catch (QueueShutdownException queueShutdownException) {
            // empty catch block
        }
    }

    public void a(String string, int n, int n2, VCardParserReply vCardParserReply) {
        de.eso.vcard.a.c c2 = new de.eso.vcard.a.c(string, n, n2, vCardParserReply);
        try {
            this.addToQueue(c2);
        }
        catch (QueueShutdownException queueShutdownException) {
            // empty catch block
        }
    }
}

