/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.memory;

import de.vw.mib.asl.api.navigation.memory.INavigationContact;
import de.vw.mib.asl.api.navigation.memory.INavigationContactAddress;
import de.vw.mib.asl.internal.navigation.api.impl.ext.memory.INavigationContactAddressImpl;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;

public class INavigationContactImpl
implements INavigationContact {
    public AdbEntry realEntry;

    public String toString() {
        return this.realEntry != null ? this.realEntry.toString() : "null";
    }

    public INavigationContactImpl(AdbEntry adbEntry) {
        this.realEntry = adbEntry;
    }

    @Override
    public long getId() {
        return this.realEntry.entryId;
    }

    @Override
    public String getName() {
        return this.realEntry.getCombinedName();
    }

    @Override
    public ResourceLocator getIcon() {
        return this.realEntry.getPersonalData() != null ? this.realEntry.getPersonalData().getContactPicture() : null;
    }

    @Override
    public INavigationContactAddress[] getAddresses() {
        INavigationContactAddress[] iNavigationContactAddressArray = new INavigationContactAddress[this.realEntry.addressData != null ? this.realEntry.addressData.length : 0];
        for (int i2 = 0; i2 < iNavigationContactAddressArray.length; ++i2) {
            iNavigationContactAddressArray[i2] = this.realEntry.addressData[i2] != null ? new INavigationContactAddressImpl(this.realEntry.addressData[i2]) : null;
        }
        return iNavigationContactAddressArray;
    }
}

