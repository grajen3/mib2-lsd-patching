/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.picturestore.persistence;

import org.dsi.ifc.global.ResourceLocator;

public final class ResourceLocatorKey {
    private final ResourceLocator resourceLocator;

    public ResourceLocatorKey(ResourceLocator resourceLocator) {
        this.resourceLocator = resourceLocator;
    }

    public ResourceLocator getResourceLocator() {
        return this.resourceLocator;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + this.resourceLocator.id;
        n2 = 31 * n2 + (this.resourceLocator.url == null ? 0 : this.resourceLocator.url.hashCode());
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        ResourceLocatorKey resourceLocatorKey = (ResourceLocatorKey)object;
        if (this.resourceLocator.id != resourceLocatorKey.resourceLocator.id) {
            return false;
        }
        return !(this.resourceLocator.url == null ? resourceLocatorKey.resourceLocator.url != null : !this.resourceLocator.url.equals(resourceLocatorKey.resourceLocator.url));
    }
}

