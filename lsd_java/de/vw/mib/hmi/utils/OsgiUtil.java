/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.hmi.utils;

import de.vw.mib.hmi.utils.Preconditions;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class OsgiUtil {
    public static Object getService(BundleContext bundleContext, String string) {
        ServiceReference serviceReference = bundleContext.getServiceReference(string);
        Preconditions.checkState(serviceReference != null, "Service '%s' not available.", string);
        Object object = bundleContext.getService(serviceReference);
        Preconditions.checkState(object != null, "Service '%s' not available.", string);
        return object;
    }
}

