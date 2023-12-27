/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard;

import de.eso.a.d.b;
import de.eso.vcard.d;
import de.esolutions.fw.util.tracing.TraceClient;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator
implements BundleActivator {
    private static final int d;
    private static final int e;
    public static final int a;
    d b;
    d c;

    @Override
    public void start(BundleContext bundleContext) {
        TraceClient.init("organizer.VCardParser");
        de.eso.a.d.b.c("JVCARDIMPORT start bundle.");
        this.b = new d(0);
        try {
            this.b.a();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.c = new d(1);
        try {
            this.c.a();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void stop(BundleContext bundleContext) {
        d d2 = this.b;
        if (d2 == null) {
            return;
        }
        d2.b();
        d2 = this.c;
        if (d2 == null) {
            return;
        }
        d2.b();
        TraceClient.exit();
    }
}

