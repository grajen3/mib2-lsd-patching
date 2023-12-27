/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal.containers;

import de.vw.mib.has.HASContainer;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public abstract class AbstractBaseContainer
implements HASContainer {
    protected int internal_containerId;
    protected int internal_elementId;
    protected boolean internal_valid;

    @Override
    public int getContainerId() {
        return this.internal_containerId;
    }

    @Override
    public int getElementId() {
        return this.internal_elementId;
    }

    @Override
    public void setElementId(int n) {
        this.internal_elementId = n;
    }

    @Override
    public boolean isValid() {
        return this.internal_valid;
    }

    public abstract void release() {
    }

    public final HASDataContainer createDataContainer(int n) {
        HASDataContainer hASDataContainer = new HASDataContainer();
        hASDataContainer.containerId = this.internal_containerId;
        HASDataElement hASDataElement = new HASDataElement();
        this.fillDataElement(hASDataElement);
        hASDataElement.elementId = n;
        hASDataContainer.dataElements = new HASDataElement[]{hASDataElement};
        return hASDataContainer;
    }

    abstract void fillDataElement(HASDataElement hASDataElement) {
    }
}

