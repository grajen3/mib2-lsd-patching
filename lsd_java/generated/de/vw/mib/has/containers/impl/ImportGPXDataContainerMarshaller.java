/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.ImportGPXDataContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class ImportGPXDataContainerMarshaller
extends AbstractContainerMarshaller {
    public ImportGPXDataContainerMarshaller() {
        super(59);
    }

    @Override
    public HASDataContainer marshal(HASContainer hASContainer) {
        HASDataContainer hASDataContainer;
        int n = this.getMarshallerContainerId();
        if (null == hASContainer) {
            hASDataContainer = null;
        } else {
            if (n != hASContainer.getContainerId()) {
                throw HASException.wrongContainerId(n, hASContainer.getContainerId());
            }
            hASDataContainer = new HASDataContainer();
            hASDataContainer.containerId = n;
            hASDataContainer.elementId = hASContainer.getElementId();
            ImportGPXDataContainer importGPXDataContainer = (ImportGPXDataContainer)hASContainer;
            ArrayList arrayList = ImportGPXDataContainerMarshaller.borrowArrayList();
            if (importGPXDataContainer.isResourceSet()) {
                ImportGPXDataContainerMarshaller.add((List)arrayList, ImportGPXDataContainerMarshaller.createResourceLocatorElement(134, importGPXDataContainer.getResource()));
            }
            if (importGPXDataContainer.isNameSet()) {
                ImportGPXDataContainerMarshaller.add((List)arrayList, ImportGPXDataContainerMarshaller.createStringElement(135, importGPXDataContainer.getName()));
            }
            if (importGPXDataContainer.isTypeSet()) {
                ImportGPXDataContainerMarshaller.add((List)arrayList, ImportGPXDataContainerMarshaller.createIntElement(138, importGPXDataContainer.getType()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            ImportGPXDataContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setResourceLocatorElement(HASContainer hASContainer, int n, ResourceLocator resourceLocator) {
        switch (n) {
            case 134: {
                ((ImportGPXDataContainer)hASContainer).setResource(resourceLocator);
                break;
            }
            default: {
                super.setResourceLocatorElement(hASContainer, n, resourceLocator);
            }
        }
    }

    @Override
    protected void setStringElement(HASContainer hASContainer, int n, String string) {
        switch (n) {
            case 135: {
                ((ImportGPXDataContainer)hASContainer).setName(string);
                break;
            }
            default: {
                super.setStringElement(hASContainer, n, string);
            }
        }
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 138: {
                ((ImportGPXDataContainer)hASContainer).setType(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }
}

