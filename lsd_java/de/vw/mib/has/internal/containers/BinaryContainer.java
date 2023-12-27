/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal.containers;

import de.vw.mib.has.internal.containers.AbstractBaseContainer;
import de.vw.mib.pool.PoorMansPool;
import org.dsi.ifc.has.HASDataElement;

final class BinaryContainer
extends AbstractBaseContainer {
    private static final int MAX_POOL_SIZE;
    private static PoorMansPool POOL;
    private byte[] value;

    private BinaryContainer() {
    }

    static BinaryContainer borrow(int n, byte[] byArray) {
        BinaryContainer binaryContainer = (BinaryContainer)POOL.borrow();
        if (null == binaryContainer) {
            binaryContainer = new BinaryContainer();
        }
        binaryContainer.internal_containerId = n;
        binaryContainer.internal_elementId = -1;
        binaryContainer.internal_valid = false;
        binaryContainer.value = byArray;
        return binaryContainer;
    }

    @Override
    public void release() {
        this.internal_valid = false;
        this.value = null;
        POOL.release(this);
    }

    @Override
    void fillDataElement(HASDataElement hASDataElement) {
        hASDataElement.binaryData = this.value;
        hASDataElement.elementType = 5;
    }

    static {
        POOL = new PoorMansPool("HASBinaryContainer", 3);
    }
}

