/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal.containers;

import de.vw.mib.has.internal.containers.AbstractBaseContainer;
import de.vw.mib.pool.PoorMansPool;
import org.dsi.ifc.has.HASDataElement;

final class BooleanContainer
extends AbstractBaseContainer {
    private static final int MAX_POOL_SIZE;
    private static PoorMansPool POOL;
    private boolean value;

    private BooleanContainer() {
    }

    static BooleanContainer borrow(int n, boolean bl) {
        BooleanContainer booleanContainer = (BooleanContainer)POOL.borrow();
        if (null == booleanContainer) {
            booleanContainer = new BooleanContainer();
        }
        booleanContainer.internal_containerId = n;
        booleanContainer.internal_elementId = -1;
        booleanContainer.internal_valid = false;
        booleanContainer.value = bl;
        return booleanContainer;
    }

    @Override
    public void release() {
        this.internal_valid = false;
        POOL.release(this);
    }

    @Override
    void fillDataElement(HASDataElement hASDataElement) {
        hASDataElement.numericData = this.value ? 1L : 0L;
        hASDataElement.elementType = 4;
    }

    static {
        POOL = new PoorMansPool("HASBooleanContainer", 3);
    }
}

