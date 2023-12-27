/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.transformer;

import generated.de.vw.mib.asl.internal.messages.transformer.AbstractMessagesExtractedAddressesTransformer;
import org.dsi.ifc.organizer.AddressData;

public class MessagesExtractedAddressesTransformer
extends AbstractMessagesExtractedAddressesTransformer {
    @Override
    public String getString(int n, Object object) {
        AddressData addressData = (AddressData)object;
        switch (n) {
            case 0: {
                return addressData.getLocality() != null ? addressData.getLocality() : "";
            }
            case 1: {
                return addressData.getCountry() != null ? addressData.getCountry() : "";
            }
            case 2: {
                return addressData.getGeoPosition() != null ? addressData.getGeoPosition() : "";
            }
            case 3: {
                return addressData.getRegion() != null ? addressData.getRegion() : "";
            }
            case 4: {
                return addressData.getStreet() != null ? addressData.getStreet() : "";
            }
            case 5: {
                return addressData.getPostalCode() != null ? addressData.getPostalCode() : "";
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

