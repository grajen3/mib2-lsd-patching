/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRNotifyPropertiesSL;

public class OSRNotifyPropertiesSLSerializer {
    public static void putOptionalOSRNotifyPropertiesSL(ISerializer iSerializer, OSRNotifyPropertiesSL oSRNotifyPropertiesSL) {
        boolean bl = oSRNotifyPropertiesSL == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = oSRNotifyPropertiesSL.getServiceID();
            iSerializer.putOptionalString(string);
            String string2 = oSRNotifyPropertiesSL.getSymbolicName();
            iSerializer.putOptionalString(string2);
            int n = oSRNotifyPropertiesSL.getReasonConnectivity();
            iSerializer.putInt32(n);
            int n2 = oSRNotifyPropertiesSL.getReasonConfig();
            iSerializer.putInt32(n2);
            int n3 = oSRNotifyPropertiesSL.getReasonLicense();
            iSerializer.putInt32(n3);
            int n4 = oSRNotifyPropertiesSL.getReasonBackend();
            iSerializer.putInt32(n4);
            int n5 = oSRNotifyPropertiesSL.getPrivacyConflict();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalOSRNotifyPropertiesSLVarArray(ISerializer iSerializer, OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray) {
        boolean bl = oSRNotifyPropertiesSLArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(oSRNotifyPropertiesSLArray.length);
            for (int i2 = 0; i2 < oSRNotifyPropertiesSLArray.length; ++i2) {
                OSRNotifyPropertiesSLSerializer.putOptionalOSRNotifyPropertiesSL(iSerializer, oSRNotifyPropertiesSLArray[i2]);
            }
        }
    }

    public static OSRNotifyPropertiesSL getOptionalOSRNotifyPropertiesSL(IDeserializer iDeserializer) {
        OSRNotifyPropertiesSL oSRNotifyPropertiesSL = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            String string;
            String string2;
            oSRNotifyPropertiesSL = new OSRNotifyPropertiesSL();
            oSRNotifyPropertiesSL.serviceID = string2 = iDeserializer.getOptionalString();
            oSRNotifyPropertiesSL.symbolicName = string = iDeserializer.getOptionalString();
            oSRNotifyPropertiesSL.reasonConnectivity = n5 = iDeserializer.getInt32();
            oSRNotifyPropertiesSL.reasonConfig = n4 = iDeserializer.getInt32();
            oSRNotifyPropertiesSL.reasonLicense = n3 = iDeserializer.getInt32();
            oSRNotifyPropertiesSL.reasonBackend = n2 = iDeserializer.getInt32();
            oSRNotifyPropertiesSL.privacyConflict = n = iDeserializer.getInt32();
        }
        return oSRNotifyPropertiesSL;
    }

    public static OSRNotifyPropertiesSL[] getOptionalOSRNotifyPropertiesSLVarArray(IDeserializer iDeserializer) {
        OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            oSRNotifyPropertiesSLArray = new OSRNotifyPropertiesSL[n];
            for (int i2 = 0; i2 < n; ++i2) {
                oSRNotifyPropertiesSLArray[i2] = OSRNotifyPropertiesSLSerializer.getOptionalOSRNotifyPropertiesSL(iDeserializer);
            }
        }
        return oSRNotifyPropertiesSLArray;
    }
}

