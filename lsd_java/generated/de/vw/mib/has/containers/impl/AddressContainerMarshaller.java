/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class AddressContainerMarshaller
extends AbstractContainerMarshaller {
    public AddressContainerMarshaller() {
        super(1);
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
            AddressContainer addressContainer = (AddressContainer)hASContainer;
            ArrayList arrayList = AddressContainerMarshaller.borrowArrayList();
            if (addressContainer.isLatitudeSet()) {
                AddressContainerMarshaller.add((List)arrayList, AddressContainerMarshaller.createDoubleElement(1, addressContainer.getLatitude()));
            }
            if (addressContainer.isLongitudeSet()) {
                AddressContainerMarshaller.add((List)arrayList, AddressContainerMarshaller.createDoubleElement(2, addressContainer.getLongitude()));
            }
            if (addressContainer.isFormattedStringSet()) {
                AddressContainerMarshaller.add((List)arrayList, AddressContainerMarshaller.createStringElement(3, addressContainer.getFormattedString()));
            }
            if (addressContainer.isStreetSet()) {
                AddressContainerMarshaller.add((List)arrayList, AddressContainerMarshaller.createStringElement(4, addressContainer.getStreet()));
            }
            if (addressContainer.isCitySet()) {
                AddressContainerMarshaller.add((List)arrayList, AddressContainerMarshaller.createStringElement(5, addressContainer.getCity()));
            }
            if (addressContainer.isCountrySet()) {
                AddressContainerMarshaller.add((List)arrayList, AddressContainerMarshaller.createStringElement(6, addressContainer.getCountry()));
            }
            if (addressContainer.isHousenumberSet()) {
                AddressContainerMarshaller.add((List)arrayList, AddressContainerMarshaller.createStringElement(7, addressContainer.getHousenumber()));
            }
            if (addressContainer.isZipSet()) {
                AddressContainerMarshaller.add((List)arrayList, AddressContainerMarshaller.createStringElement(8, addressContainer.getZip()));
            }
            if (addressContainer.isStateSet()) {
                AddressContainerMarshaller.add((List)arrayList, AddressContainerMarshaller.createStringElement(10, addressContainer.getState()));
            }
            if (addressContainer.isAltitudeSet()) {
                AddressContainerMarshaller.add((List)arrayList, AddressContainerMarshaller.createDoubleElement(21, addressContainer.getAltitude()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            AddressContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setDoubleElement(HASContainer hASContainer, int n, double d2) {
        switch (n) {
            case 1: {
                ((AddressContainer)hASContainer).setLatitude(d2);
                break;
            }
            case 2: {
                ((AddressContainer)hASContainer).setLongitude(d2);
                break;
            }
            case 21: {
                ((AddressContainer)hASContainer).setAltitude(d2);
                break;
            }
            default: {
                super.setDoubleElement(hASContainer, n, d2);
            }
        }
    }

    @Override
    protected void setStringElement(HASContainer hASContainer, int n, String string) {
        switch (n) {
            case 3: {
                ((AddressContainer)hASContainer).setFormattedString(string);
                break;
            }
            case 4: {
                ((AddressContainer)hASContainer).setStreet(string);
                break;
            }
            case 5: {
                ((AddressContainer)hASContainer).setCity(string);
                break;
            }
            case 6: {
                ((AddressContainer)hASContainer).setCountry(string);
                break;
            }
            case 7: {
                ((AddressContainer)hASContainer).setHousenumber(string);
                break;
            }
            case 8: {
                ((AddressContainer)hASContainer).setZip(string);
                break;
            }
            case 10: {
                ((AddressContainer)hASContainer).setState(string);
                break;
            }
            default: {
                super.setStringElement(hASContainer, n, string);
            }
        }
    }
}

