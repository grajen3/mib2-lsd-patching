/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal.containers;

import de.vw.mib.has.internal.containers.AbstractBaseContainer;
import de.vw.mib.pool.PoorMansPool;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.has.HASDataElement;

final class ResourceLocatorContainer
extends AbstractBaseContainer {
    private static final int MAX_POOL_SIZE;
    private static PoorMansPool POOL;
    private ResourceLocator value;

    private ResourceLocatorContainer() {
    }

    static ResourceLocatorContainer borrow(int n, ResourceLocator resourceLocator) {
        ResourceLocatorContainer resourceLocatorContainer = (ResourceLocatorContainer)POOL.borrow();
        if (null == resourceLocatorContainer) {
            resourceLocatorContainer = new ResourceLocatorContainer();
        }
        resourceLocatorContainer.internal_containerId = n;
        resourceLocatorContainer.internal_elementId = -1;
        resourceLocatorContainer.internal_valid = false;
        resourceLocatorContainer.value = resourceLocator;
        return resourceLocatorContainer;
    }

    @Override
    public void release() {
        this.internal_valid = false;
        this.value = null;
        POOL.release(this);
    }

    @Override
    void fillDataElement(HASDataElement hASDataElement) {
        hASDataElement.resourceLocator = this.value;
        hASDataElement.elementType = 6;
    }

    static {
        POOL = new PoorMansPool("HASResourceLocatorContainer", 3);
    }
}

