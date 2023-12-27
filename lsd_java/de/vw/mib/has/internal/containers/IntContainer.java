/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal.containers;

import de.vw.mib.has.internal.containers.AbstractBaseContainer;
import de.vw.mib.pool.PoorMansPool;
import org.dsi.ifc.has.HASDataElement;

final class IntContainer
extends AbstractBaseContainer {
    private static final int MAX_POOL_SIZE;
    private static PoorMansPool POOL;
    private int value;

    private IntContainer() {
    }

    static IntContainer borrow(int n, int n2) {
        IntContainer intContainer = (IntContainer)POOL.borrow();
        if (null == intContainer) {
            intContainer = new IntContainer();
        }
        intContainer.internal_containerId = n;
        intContainer.internal_elementId = -1;
        intContainer.internal_valid = false;
        intContainer.value = n2;
        return intContainer;
    }

    @Override
    public void release() {
        this.internal_valid = false;
        POOL.release(this);
    }

    @Override
    void fillDataElement(HASDataElement hASDataElement) {
        hASDataElement.numericData = this.value;
        hASDataElement.elementType = 0;
    }

    static {
        POOL = new PoorMansPool("HASIntContainer", 3);
    }
}

