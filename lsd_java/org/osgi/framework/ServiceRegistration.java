/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.framework;

import java.util.Dictionary;
import org.osgi.framework.ServiceReference;

public interface ServiceRegistration {
    default public ServiceReference getReference() {
    }

    default public void setProperties(Dictionary dictionary) {
    }

    default public void unregister() {
    }
}

