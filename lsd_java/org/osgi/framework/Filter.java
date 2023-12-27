/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.framework;

import java.util.Dictionary;
import org.osgi.framework.ServiceReference;

public interface Filter {
    default public boolean match(ServiceReference serviceReference) {
    }

    default public boolean match(Dictionary dictionary) {
    }

    default public String toString() {
    }

    default public boolean equals(Object object) {
    }

    default public int hashCode() {
    }
}

