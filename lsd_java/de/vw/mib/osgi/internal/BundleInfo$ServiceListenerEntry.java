/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.osgi.internal.ServiceFilter;
import java.util.EventListener;
import org.osgi.framework.ServiceListener;

final class BundleInfo$ServiceListenerEntry
implements EventListener {
    final ServiceFilter filter;
    final ServiceListener listener;

    BundleInfo$ServiceListenerEntry(ServiceListener serviceListener) {
        this.listener = serviceListener;
        this.filter = null;
    }

    BundleInfo$ServiceListenerEntry(ServiceListener serviceListener, String string) {
        this.listener = serviceListener;
        this.filter = string == null ? null : new ServiceFilter(string);
    }
}

