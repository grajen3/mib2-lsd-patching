/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.starter.client;

import de.eso.a.d.b;
import de.eso.vcalendar.starter.client.a;
import de.esolutions.fw.util.tracing.TraceClient;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator
implements BundleActivator {
    private static final int d;
    private static final int e;
    static int a;
    a b;
    a c;

    @Override
    public void start(BundleContext bundleContext) {
        TraceClient.init("organizer.VCardParser");
        de.eso.a.d.b.c("JVCALENDAR start bundle.");
        try {
            this.b = new a(0, bundleContext);
            this.b.e();
            this.b.a();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        try {
            this.c = new a(1, bundleContext);
            this.c.e();
            this.c.a();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        try {
            this.c.e();
            this.c.a();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void stop(BundleContext bundleContext) {
        a a2 = this.b;
        if (a2 == null) {
            return;
        }
        a2.b();
        a2 = this.c;
        if (a2 == null) {
            return;
        }
        a2.b();
        TraceClient.exit();
    }

    static {
        a = 10;
    }
}

