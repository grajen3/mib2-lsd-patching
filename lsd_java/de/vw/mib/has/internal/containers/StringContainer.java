/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal.containers;

import de.vw.mib.has.internal.containers.AbstractBaseContainer;
import de.vw.mib.pool.PoorMansPool;
import org.dsi.ifc.has.HASDataElement;

final class StringContainer
extends AbstractBaseContainer {
    private static final int MAX_POOL_SIZE;
    private static PoorMansPool POOL;
    private String value;

    private StringContainer() {
    }

    static StringContainer borrow(int n, String string) {
        StringContainer stringContainer = (StringContainer)POOL.borrow();
        if (null == stringContainer) {
            stringContainer = new StringContainer();
        }
        stringContainer.internal_containerId = n;
        stringContainer.internal_elementId = -1;
        stringContainer.internal_valid = false;
        stringContainer.value = string;
        return stringContainer;
    }

    @Override
    public void release() {
        this.internal_valid = false;
        this.value = null;
        POOL.release(this);
    }

    @Override
    void fillDataElement(HASDataElement hASDataElement) {
        hASDataElement.stringData = this.value;
        hASDataElement.elementType = 2;
    }

    static {
        POOL = new PoorMansPool("HASStringContainer", 3);
    }
}

