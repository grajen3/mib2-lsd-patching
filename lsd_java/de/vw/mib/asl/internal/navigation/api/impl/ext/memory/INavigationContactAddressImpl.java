/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.memory;

import de.vw.mib.asl.api.navigation.memory.INavigationContactAddress;
import org.dsi.ifc.organizer.AddressData;

public class INavigationContactAddressImpl
implements INavigationContactAddress {
    public AddressData realAddressData;

    public String toString() {
        return this.realAddressData != null ? this.realAddressData.toString() : "null";
    }

    public INavigationContactAddressImpl(AddressData addressData) {
        this.realAddressData = addressData;
    }

    @Override
    public int getAddressType() {
        return this.realAddressData == null ? 0 : this.realAddressData.getAddressType();
    }

    @Override
    public String getStreet() {
        return this.realAddressData == null ? null : this.realAddressData.getStreet();
    }

    @Override
    public String getLocality() {
        return this.realAddressData == null ? null : this.realAddressData.getLocality();
    }

    @Override
    public String getCountry() {
        return this.realAddressData == null ? null : this.realAddressData.getCountry();
    }

    @Override
    public String getRegion() {
        return this.realAddressData == null ? null : this.realAddressData.getRegion();
    }

    @Override
    public String getPostalCode() {
        return this.realAddressData == null ? null : this.realAddressData.getPostalCode();
    }

    @Override
    public String getGeoPosition() {
        return this.realAddressData == null ? null : this.realAddressData.getGeoPosition();
    }
}

