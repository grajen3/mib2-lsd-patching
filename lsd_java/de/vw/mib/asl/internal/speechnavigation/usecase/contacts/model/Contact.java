/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.contacts.model;

import de.vw.mib.asl.api.navigation.memory.INavigationContact;
import de.vw.mib.asl.api.navigation.memory.INavigationContactAddress;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.model.ContactAddress;
import de.vw.mib.collections.ObjectArrayList;
import org.dsi.ifc.global.ResourceLocator;

public class Contact {
    public int groupSize;
    public long contactId;
    public String contactName;
    public ResourceLocator contactPicture;
    public final ContactAddress[] contactAddresses;

    public Contact() {
        this.contactId = -1L;
        this.contactName = "";
        this.groupSize = -1;
        this.contactPicture = new ResourceLocator();
        this.contactAddresses = new ContactAddress[0];
    }

    public Contact(ResultItem resultItem) {
        this.contactId = -1L;
        this.contactName = resultItem.getText();
        this.groupSize = resultItem.getSize();
        this.contactAddresses = new ContactAddress[0];
    }

    public Contact(INavigationContact iNavigationContact) {
        this.contactId = iNavigationContact.getId();
        this.contactName = iNavigationContact.getName();
        this.contactPicture = iNavigationContact.getIcon();
        INavigationContactAddress[] iNavigationContactAddressArray = iNavigationContact.getAddresses();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        if (iNavigationContactAddressArray != null) {
            for (int i2 = 0; i2 < iNavigationContactAddressArray.length; ++i2) {
                if (!this.isValid(iNavigationContactAddressArray[i2])) continue;
                objectArrayList.add(new ContactAddress(i2, this.contactId, iNavigationContactAddressArray[i2]));
            }
        }
        this.contactAddresses = (ContactAddress[])objectArrayList.toArray(new ContactAddress[objectArrayList.size()]);
    }

    public ContactAddress getFirstAddress() {
        if (this.contactAddresses.length > 0) {
            return this.contactAddresses[0];
        }
        return new ContactAddress();
    }

    public boolean hasSingleAddress() {
        return this.contactAddresses.length == 1;
    }

    public boolean hasMultipleAddresses() {
        return this.contactAddresses.length > 1;
    }

    public boolean hasAddresses() {
        return this.contactAddresses.length != 0;
    }

    public int getAddressesStatus() {
        if (this.hasSingleAddress()) {
            return 1;
        }
        if (this.hasMultipleAddresses()) {
            return 2;
        }
        return 0;
    }

    private boolean isValid(INavigationContactAddress iNavigationContactAddress) {
        boolean bl = iNavigationContactAddress != null && (Contact.isValid(iNavigationContactAddress.getCountry()) || Contact.isValid(iNavigationContactAddress.getGeoPosition()) || Contact.isValid(iNavigationContactAddress.getLocality()) || Contact.isValid(iNavigationContactAddress.getPostalCode()) || Contact.isValid(iNavigationContactAddress.getStreet()) || Contact.isValid(iNavigationContactAddress.getRegion()));
        return bl;
    }

    private static boolean isValid(String string) {
        return string != null && string.length() > 0;
    }
}

