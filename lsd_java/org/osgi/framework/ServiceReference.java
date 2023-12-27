/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.framework;

import org.osgi.framework.Bundle;

public interface ServiceReference {
    default public Object getProperty(String string) {
    }

    default public String[] getPropertyKeys() {
    }

    default public Bundle getBundle() {
    }

    default public Bundle[] getUsingBundles() {
    }
}

