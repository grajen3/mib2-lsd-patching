/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.starter.client;

import de.eso.a.d.b;
import de.eso.vcalendar.a.a.a;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderProxy;
import de.esolutions.fw.util.commons.queue.QueueShutdownException;
import de.esolutions.fw.util.commons.queue.QueueWorker;
import java.io.File;

public class d
extends QueueWorker {
    public d(String string, int n) {
        super(string, n);
    }

    @Override
    protected void handleQueuedObject(Object object) {
        try {
            de.eso.a.a.a a2 = (de.eso.a.a.a)object;
            a2.a();
        }
        catch (ClassCastException classCastException) {
            b.d(classCastException.getMessage());
            classCastException.printStackTrace();
        }
    }

    public void a(File file, int n, VCalendarDbProviderProxy vCalendarDbProviderProxy) {
        a a2 = new a(file, n, vCalendarDbProviderProxy);
        try {
            this.addToQueue(a2);
        }
        catch (QueueShutdownException queueShutdownException) {
            // empty catch block
        }
    }
}

