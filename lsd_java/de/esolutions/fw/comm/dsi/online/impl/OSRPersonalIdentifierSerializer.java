/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRPersonalIdentifier;

public class OSRPersonalIdentifierSerializer {
    public static void putOptionalOSRPersonalIdentifier(ISerializer iSerializer, OSRPersonalIdentifier oSRPersonalIdentifier) {
        boolean bl = oSRPersonalIdentifier == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = oSRPersonalIdentifier.getPType();
            iSerializer.putInt32(n);
            String string = oSRPersonalIdentifier.getPIdentifier();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalOSRPersonalIdentifierVarArray(ISerializer iSerializer, OSRPersonalIdentifier[] oSRPersonalIdentifierArray) {
        boolean bl = oSRPersonalIdentifierArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(oSRPersonalIdentifierArray.length);
            for (int i2 = 0; i2 < oSRPersonalIdentifierArray.length; ++i2) {
                OSRPersonalIdentifierSerializer.putOptionalOSRPersonalIdentifier(iSerializer, oSRPersonalIdentifierArray[i2]);
            }
        }
    }

    public static OSRPersonalIdentifier getOptionalOSRPersonalIdentifier(IDeserializer iDeserializer) {
        OSRPersonalIdentifier oSRPersonalIdentifier = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            oSRPersonalIdentifier = new OSRPersonalIdentifier();
            oSRPersonalIdentifier.pType = n = iDeserializer.getInt32();
            oSRPersonalIdentifier.pIdentifier = string = iDeserializer.getOptionalString();
        }
        return oSRPersonalIdentifier;
    }

    public static OSRPersonalIdentifier[] getOptionalOSRPersonalIdentifierVarArray(IDeserializer iDeserializer) {
        OSRPersonalIdentifier[] oSRPersonalIdentifierArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            oSRPersonalIdentifierArray = new OSRPersonalIdentifier[n];
            for (int i2 = 0; i2 < n; ++i2) {
                oSRPersonalIdentifierArray[i2] = OSRPersonalIdentifierSerializer.getOptionalOSRPersonalIdentifier(iDeserializer);
            }
        }
        return oSRPersonalIdentifierArray;
    }
}

