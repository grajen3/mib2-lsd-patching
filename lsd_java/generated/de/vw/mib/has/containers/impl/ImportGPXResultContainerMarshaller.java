/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.ImportGPXResultContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class ImportGPXResultContainerMarshaller
extends AbstractContainerMarshaller {
    public ImportGPXResultContainerMarshaller() {
        super(60);
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
            ImportGPXResultContainer importGPXResultContainer = (ImportGPXResultContainer)hASContainer;
            ArrayList arrayList = ImportGPXResultContainerMarshaller.borrowArrayList();
            if (importGPXResultContainer.isNameSet()) {
                ImportGPXResultContainerMarshaller.add((List)arrayList, ImportGPXResultContainerMarshaller.createStringElement(136, importGPXResultContainer.getName()));
            }
            if (importGPXResultContainer.isResultSet()) {
                ImportGPXResultContainerMarshaller.add((List)arrayList, ImportGPXResultContainerMarshaller.createIntElement(137, importGPXResultContainer.getResult()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            ImportGPXResultContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setStringElement(HASContainer hASContainer, int n, String string) {
        switch (n) {
            case 136: {
                ((ImportGPXResultContainer)hASContainer).setName(string);
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
            case 137: {
                ((ImportGPXResultContainer)hASContainer).setResult(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }
}

