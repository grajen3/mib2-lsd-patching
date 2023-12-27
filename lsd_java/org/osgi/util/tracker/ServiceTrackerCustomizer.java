/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.util.tracker;

import org.osgi.framework.ServiceReference;

public interface ServiceTrackerCustomizer {
    default public Object addingService(ServiceReference serviceReference) {
    }

    default public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    default public void removedService(ServiceReference serviceReference, Object object) {
    }
}

