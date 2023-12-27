/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal.containers;

import de.vw.mib.has.internal.containers.AbstractBaseContainer;
import de.vw.mib.pool.PoorMansPool;
import org.dsi.ifc.has.HASDataElement;

final class DoubleContainer
extends AbstractBaseContainer {
    private static final int MAX_POOL_SIZE;
    private static PoorMansPool POOL;
    private double value;

    private DoubleContainer() {
    }

    static DoubleContainer borrow(int n, double d2) {
        DoubleContainer doubleContainer = (DoubleContainer)POOL.borrow();
        if (null == doubleContainer) {
            doubleContainer = new DoubleContainer();
        }
        doubleContainer.internal_containerId = n;
        doubleContainer.internal_elementId = -1;
        doubleContainer.internal_valid = false;
        doubleContainer.value = d2;
        return doubleContainer;
    }

    @Override
    public void release() {
        this.internal_valid = false;
        POOL.release(this);
    }

    @Override
    void fillDataElement(HASDataElement hASDataElement) {
        hASDataElement.doubleData = this.value;
        hASDataElement.elementType = 3;
    }

    static {
        POOL = new PoorMansPool("HASDoubleContainer", 3);
    }
}

