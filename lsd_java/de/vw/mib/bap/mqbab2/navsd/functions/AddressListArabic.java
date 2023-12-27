/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.Address_List_Data;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.Address_List_StatusArray;
import de.vw.mib.bap.mqbab2.navsd.functions.AddressList;

public class AddressListArabic
extends AddressList {
    @Override
    protected void fillTheAddressListData(Address_List_StatusArray address_List_StatusArray) {
        super.fillTheAddressListData(address_List_StatusArray);
        BAPArrayData bAPArrayData = address_List_StatusArray.getArrayData();
        int n = bAPArrayData.size();
        for (int i2 = 0; i2 < n; ++i2) {
            Address_List_Data address_List_Data = (Address_List_Data)bAPArrayData.get(i2);
            if (address_List_Data.lastName.isArabic()) {
                address_List_Data.lastName.reset();
            }
            if (address_List_Data.firstName.isArabic()) {
                address_List_Data.firstName.reset();
            }
            if (address_List_Data.street.isArabic()) {
                address_List_Data.street.reset();
            }
            if (address_List_Data.city.isArabic()) {
                address_List_Data.city.reset();
            }
            if (address_List_Data.region.isArabic()) {
                address_List_Data.region.reset();
            }
            if (address_List_Data.postalCode.isArabic()) {
                address_List_Data.postalCode.reset();
            }
            if (address_List_Data.country.isArabic()) {
                address_List_Data.country.reset();
            }
            if (address_List_Data.coordinates.isArabic()) {
                address_List_Data.coordinates.reset();
            }
            if (!address_List_Data.poi_Description.isArabic()) continue;
            address_List_Data.poi_Description.reset();
        }
    }
}

