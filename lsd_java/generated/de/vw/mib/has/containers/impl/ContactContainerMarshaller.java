/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.ContactContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class ContactContainerMarshaller
extends AbstractContainerMarshaller {
    public ContactContainerMarshaller() {
        super(8);
    }

    @Override
    public void addChild(HASContainer hASContainer, HASContainer hASContainer2) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        ContactContainer contactContainer = (ContactContainer)hASContainer;
        int n2 = hASContainer2.getContainerId();
        switch (n2) {
            case 1: {
                this.addAddress(contactContainer, (AddressContainer)hASContainer2);
                break;
            }
            default: {
                throw HASException.invalidChild(n, n2);
            }
        }
    }

    private void addAddress(ContactContainer contactContainer, AddressContainer addressContainer) {
        if (contactContainer.isAddressSet()) {
            throw HASException.invalidMultipleChildren(this.getMarshallerContainerId(), addressContainer.getContainerId());
        }
        contactContainer.setAddress(addressContainer);
    }

    @Override
    public void getChildren(HASContainer hASContainer, List list) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        ContactContainer contactContainer = (ContactContainer)hASContainer;
        if (contactContainer.isAddressSet()) {
            ContactContainerMarshaller.add(list, contactContainer.getAddress());
        }
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
            ContactContainer contactContainer = (ContactContainer)hASContainer;
            ArrayList arrayList = ContactContainerMarshaller.borrowArrayList();
            if (contactContainer.isTelephoneNumberSet()) {
                ContactContainerMarshaller.add((List)arrayList, ContactContainerMarshaller.createStringElement(17, contactContainer.getTelephoneNumber()));
            }
            if (contactContainer.isNameSet()) {
                ContactContainerMarshaller.add((List)arrayList, ContactContainerMarshaller.createStringElement(18, contactContainer.getName()));
            }
            if (contactContainer.isSurnameSet()) {
                ContactContainerMarshaller.add((List)arrayList, ContactContainerMarshaller.createStringElement(19, contactContainer.getSurname()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            ContactContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setStringElement(HASContainer hASContainer, int n, String string) {
        switch (n) {
            case 17: {
                ((ContactContainer)hASContainer).setTelephoneNumber(string);
                break;
            }
            case 18: {
                ((ContactContainer)hASContainer).setName(string);
                break;
            }
            case 19: {
                ((ContactContainer)hASContainer).setSurname(string);
                break;
            }
            default: {
                super.setStringElement(hASContainer, n, string);
            }
        }
    }
}

