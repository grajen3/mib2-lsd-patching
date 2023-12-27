/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.framework.internal.impl.lsc.Preconditions;
import de.vw.mib.asl.framework.internal.lsc.OsgiServices$1;
import de.vw.mib.asl.framework.internal.lsc.OsgiServices$ServiceConsumer;
import org.osgi.framework.BundleContext;

public class OsgiServices {
    public static void acquireService(BundleContext bundleContext, Class clazz, OsgiServices$ServiceConsumer osgiServices$ServiceConsumer) {
        Preconditions.checkArgumentNotNull(bundleContext, "Argument >context< must not be null!");
        Preconditions.checkArgumentNotNull(clazz, "Argument >serviceType< must not be null!");
        Preconditions.checkArgumentNotNull(osgiServices$ServiceConsumer, "Argument >consumer< must not be null!");
        new OsgiServices$1(bundleContext, clazz.getName(), null, osgiServices$ServiceConsumer).open();
    }

    private OsgiServices() {
    }
}

