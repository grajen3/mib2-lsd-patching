/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.messaging.MatchedAddress;

public class MatchedAddressSerializer {
    public static void putOptionalMatchedAddress(ISerializer iSerializer, MatchedAddress matchedAddress) {
        boolean bl = matchedAddress == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = matchedAddress.getAddress();
            iSerializer.putOptionalString(string);
            String string2 = matchedAddress.getName();
            iSerializer.putOptionalString(string2);
            long l = matchedAddress.getAdbEntryID();
            iSerializer.putInt64(l);
            ResourceLocator resourceLocator = matchedAddress.getAdbPictureID();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
        }
    }

    public static void putOptionalMatchedAddressVarArray(ISerializer iSerializer, MatchedAddress[] matchedAddressArray) {
        boolean bl = matchedAddressArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(matchedAddressArray.length);
            for (int i2 = 0; i2 < matchedAddressArray.length; ++i2) {
                MatchedAddressSerializer.putOptionalMatchedAddress(iSerializer, matchedAddressArray[i2]);
            }
        }
    }

    public static MatchedAddress getOptionalMatchedAddress(IDeserializer iDeserializer) {
        MatchedAddress matchedAddress = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ResourceLocator resourceLocator;
            long l;
            String string;
            String string2;
            matchedAddress = new MatchedAddress();
            matchedAddress.address = string2 = iDeserializer.getOptionalString();
            matchedAddress.name = string = iDeserializer.getOptionalString();
            matchedAddress.adbEntryID = l = iDeserializer.getInt64();
            matchedAddress.adbPictureID = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
        }
        return matchedAddress;
    }

    public static MatchedAddress[] getOptionalMatchedAddressVarArray(IDeserializer iDeserializer) {
        MatchedAddress[] matchedAddressArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            matchedAddressArray = new MatchedAddress[n];
            for (int i2 = 0; i2 < n; ++i2) {
                matchedAddressArray[i2] = MatchedAddressSerializer.getOptionalMatchedAddress(iDeserializer);
            }
        }
        return matchedAddressArray;
    }
}

