/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASContainerMarshaller;
import de.vw.mib.has.HASException;
import de.vw.mib.has.internal.HASManager;
import de.vw.mib.has.internal.containers.AbstractBaseContainer;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

class HASBaseContainerMarshallerImpl
implements HASContainerMarshaller {
    private final int marshallerContainerId;
    private final int elementId;

    HASBaseContainerMarshallerImpl(int n, int n2) {
        this.marshallerContainerId = n;
        this.elementId = n2;
    }

    @Override
    public HASDataContainer marshal(HASContainer hASContainer) {
        HASDataContainer hASDataContainer;
        if (null == hASContainer) {
            hASDataContainer = null;
        } else {
            if (this.marshallerContainerId != hASContainer.getContainerId()) {
                throw HASException.wrongContainerId(this.marshallerContainerId, hASContainer.getContainerId());
            }
            if (!(hASContainer instanceof AbstractBaseContainer)) {
                throw HASException.oneElementExpected(this.marshallerContainerId);
            }
            hASDataContainer = ((AbstractBaseContainer)hASContainer).createDataContainer(this.elementId);
        }
        return hASDataContainer;
    }

    @Override
    public HASContainer unmarshal(HASDataContainer hASDataContainer) {
        HASContainer hASContainer;
        if (null == hASDataContainer) {
            hASContainer = null;
        } else {
            if (this.marshallerContainerId != hASDataContainer.containerId) {
                throw HASException.wrongContainerId(this.marshallerContainerId, hASDataContainer.containerId);
            }
            HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
            if (null == hASDataElementArray || 1 != hASDataElementArray.length) {
                throw HASException.oneElementExpected(this.marshallerContainerId);
            }
            HASDataElement hASDataElement = hASDataElementArray[0];
            if (this.elementId != hASDataElement.getElementId()) {
                throw HASException.invalidDataElement(this.marshallerContainerId, hASDataElement.getElementId(), hASDataElement.getElementType());
            }
            hASContainer = this.createBaseContainer(this.marshallerContainerId, hASDataElement);
        }
        return hASContainer;
    }

    @Override
    public void addChild(HASContainer hASContainer, HASContainer hASContainer2) {
        throw HASException.noChildrenAllowed(this.marshallerContainerId);
    }

    @Override
    public void getChildren(HASContainer hASContainer, List list) {
    }

    private HASContainer createBaseContainer(int n, HASDataElement hASDataElement) {
        HASContainer hASContainer;
        HASBaseContainerFactory hASBaseContainerFactory = HASManager.getInstance().getBaseContainerFactory();
        int n2 = hASDataElement.getElementType();
        switch (n2) {
            case 0: {
                hASContainer = hASBaseContainerFactory.createIntContainer(n, (int)hASDataElement.getNumericData());
                break;
            }
            case 1: {
                hASContainer = hASBaseContainerFactory.createLongContainer(n, hASDataElement.getNumericData());
                break;
            }
            case 2: {
                hASContainer = hASBaseContainerFactory.createStringContainer(n, hASDataElement.getStringData());
                break;
            }
            case 3: {
                hASContainer = hASBaseContainerFactory.createDoubleContainer(n, hASDataElement.getDoubleData());
                break;
            }
            case 4: {
                hASContainer = hASBaseContainerFactory.createBooleanContainer(n, hASDataElement.getNumericData() == 1L);
                break;
            }
            case 5: {
                hASContainer = hASBaseContainerFactory.createBinaryContainer(n, hASDataElement.getBinaryData());
                break;
            }
            case 6: {
                hASContainer = hASBaseContainerFactory.createResourceLocatorContainer(n, hASDataElement.getResourceLocator());
                break;
            }
            default: {
                throw HASException.illegalElementType(n, hASDataElement.getElementId(), n2);
            }
        }
        return hASContainer;
    }
}

