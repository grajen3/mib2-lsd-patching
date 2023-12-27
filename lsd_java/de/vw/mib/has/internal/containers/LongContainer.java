/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal.containers;

import de.vw.mib.has.internal.containers.AbstractBaseContainer;
import de.vw.mib.pool.PoorMansPool;
import org.dsi.ifc.has.HASDataElement;

final class LongContainer
extends AbstractBaseContainer {
    private static final int MAX_POOL_SIZE;
    private static PoorMansPool POOL;
    private long value;

    private LongContainer() {
    }

    static LongContainer borrow(int n, long l) {
        LongContainer longContainer = (LongContainer)POOL.borrow();
        if (null == longContainer) {
            longContainer = new LongContainer();
        }
        longContainer.internal_containerId = n;
        longContainer.internal_elementId = -1;
        longContainer.internal_valid = false;
        longContainer.value = l;
        return longContainer;
    }

    @Override
    public void release() {
        this.internal_valid = false;
        POOL.release(this);
    }

    @Override
    void fillDataElement(HASDataElement hASDataElement) {
        hASDataElement.numericData = this.value;
        hASDataElement.elementType = 1;
    }

    static {
        POOL = new PoorMansPool("HASLongContainer", 3);
    }
}

