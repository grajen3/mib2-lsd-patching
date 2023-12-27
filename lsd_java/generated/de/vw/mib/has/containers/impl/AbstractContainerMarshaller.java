/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASContainerMarshaller;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASException;
import de.vw.mib.has.HASFactory;
import de.vw.mib.pool.PoorMansPool;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

abstract class AbstractContainerMarshaller
implements HASContainerMarshaller {
    private static final HASEngineAPI API = HAS.getInstance().getEngine();
    private static final HASFactory FACTORY = HAS.getInstance().getFactory();
    private final int containerId;
    private static final int ARRAYLIST_POOL_MAX_ELEMENTS;
    private static final int ARRAYLIST_POOL_INITIAL_ARRAYLEN;
    private static final int ARRAYLIST_POOL_MAX_ARRAYLEN;
    private static final PoorMansPool ARRAYLIST_POOL;

    protected AbstractContainerMarshaller(int n) {
        this.containerId = n;
    }

    protected int getMarshallerContainerId() {
        return this.containerId;
    }

    @Override
    public void addChild(HASContainer hASContainer, HASContainer hASContainer2) {
        throw HASException.noChildrenAllowed(this.containerId);
    }

    @Override
    public void getChildren(HASContainer hASContainer, List list) {
    }

    protected static ArrayList borrowArrayList() {
        ArrayList arrayList = (ArrayList)ARRAYLIST_POOL.borrow();
        if (null == arrayList) {
            arrayList = new ArrayList(20);
        }
        return arrayList;
    }

    protected static void release(ArrayList arrayList) {
        if (null != arrayList && arrayList.size() <= 20) {
            arrayList.clear();
            ARRAYLIST_POOL.release(arrayList);
        }
    }

    protected static void add(List list, Object object) {
        list.add(object);
    }

    protected static void add(List list, Object[] objectArray) {
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            list.add(objectArray[i2]);
        }
    }

    protected static HASDataElement createBinaryElement(int n, byte[] byArray) {
        return API.getDataElementFactory().createBinaryElement(n, byArray);
    }

    protected static HASDataElement createBooleanElement(int n, boolean bl) {
        return API.getDataElementFactory().createBooleanElement(n, bl);
    }

    protected static HASDataElement createDoubleElement(int n, double d2) {
        return API.getDataElementFactory().createDoubleElement(n, d2);
    }

    protected static HASDataElement createIntElement(int n, int n2) {
        return API.getDataElementFactory().createIntElement(n, n2);
    }

    protected static HASDataElement createLongElement(int n, long l) {
        return API.getDataElementFactory().createLongElement(n, l);
    }

    protected static HASDataElement createResourceLocatorElement(int n, ResourceLocator resourceLocator) {
        return API.getDataElementFactory().createResourceLocatorElement(n, resourceLocator);
    }

    protected static HASDataElement createStringElement(int n, String string) {
        return API.getDataElementFactory().createStringElement(n, string);
    }

    @Override
    public final HASContainer unmarshal(HASDataContainer hASDataContainer) {
        HASContainer hASContainer;
        if (null == hASDataContainer) {
            hASContainer = null;
        } else {
            if (this.containerId != hASDataContainer.getContainerId()) {
                throw HASException.wrongContainerId(this.containerId, hASDataContainer.getContainerId());
            }
            hASContainer = FACTORY.createContainer(this.containerId);
            hASContainer.setElementId(hASDataContainer.elementId);
            HASDataElement[] hASDataElementArray = hASDataContainer.getDataElements();
            this.unmarshalElements(hASContainer, hASDataElementArray);
        }
        return hASContainer;
    }

    private void unmarshalElements(HASContainer hASContainer, HASDataElement[] hASDataElementArray) {
        if (null != hASDataElementArray) {
            block9: for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
                HASDataElement hASDataElement = hASDataElementArray[i2];
                int n = hASDataElement.getElementType();
                int n2 = hASDataElement.getElementId();
                switch (n) {
                    case 5: {
                        this.setBinaryElement(hASContainer, n2, hASDataElement.getBinaryData());
                        continue block9;
                    }
                    case 4: {
                        this.setBooleanElement(hASContainer, n2, hASDataElement.getNumericData() == 1L);
                        continue block9;
                    }
                    case 3: {
                        this.setDoubleElement(hASContainer, n2, hASDataElement.getDoubleData());
                        continue block9;
                    }
                    case 0: {
                        this.setIntElement(hASContainer, n2, (int)hASDataElement.getNumericData());
                        continue block9;
                    }
                    case 1: {
                        this.setLongElement(hASContainer, n2, hASDataElement.getNumericData());
                        continue block9;
                    }
                    case 6: {
                        this.setResourceLocatorElement(hASContainer, n2, hASDataElement.getResourceLocator());
                        continue block9;
                    }
                    case 2: {
                        this.setStringElement(hASContainer, n2, hASDataElement.getStringData());
                        continue block9;
                    }
                    default: {
                        throw HASException.invalidDataElement(this.containerId, n2, n);
                    }
                }
            }
        }
    }

    protected void setBinaryElement(HASContainer hASContainer, int n, byte[] byArray) {
        throw HASException.invalidDataElement(this.containerId, n, 5);
    }

    protected void setBooleanElement(HASContainer hASContainer, int n, boolean bl) {
        throw HASException.invalidDataElement(this.containerId, n, 4);
    }

    protected void setDoubleElement(HASContainer hASContainer, int n, double d2) {
        throw HASException.invalidDataElement(this.containerId, n, 3);
    }

    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        throw HASException.invalidDataElement(this.containerId, n, 0);
    }

    protected void setLongElement(HASContainer hASContainer, int n, long l) {
        try {
            this.setIntElement(hASContainer, n, (int)l);
        }
        catch (HASException hASException) {
            throw HASException.invalidDataElement(this.containerId, n, 1);
        }
    }

    protected void setResourceLocatorElement(HASContainer hASContainer, int n, ResourceLocator resourceLocator) {
        throw HASException.invalidDataElement(this.containerId, n, 6);
    }

    protected void setStringElement(HASContainer hASContainer, int n, String string) {
        throw HASException.invalidDataElement(this.containerId, n, 2);
    }

    static {
        ARRAYLIST_POOL = new PoorMansPool("HASContainerMarshaller.ArrayList", 10);
    }
}

