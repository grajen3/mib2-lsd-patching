/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.online.impl.OSRDeviceSerializer;
import de.esolutions.fw.comm.dsi.online.impl.OSRPersonalIdentifierSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRPersonalIdentifier;
import org.dsi.ifc.online.OSRUser;

public class OSRUserSerializer {
    public static void putOptionalOSRUser(ISerializer iSerializer, OSRUser oSRUser) {
        boolean bl = oSRUser == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = oSRUser.getAuthIdentifier();
            iSerializer.putOptionalString(string);
            String string2 = oSRUser.getPortalUser();
            iSerializer.putOptionalString(string2);
            String string3 = oSRUser.getHash1();
            iSerializer.putOptionalString(string3);
            String string4 = oSRUser.getHash2();
            iSerializer.putOptionalString(string4);
            String string5 = oSRUser.getName();
            iSerializer.putOptionalString(string5);
            OSRPersonalIdentifier oSRPersonalIdentifier = oSRUser.getPersonalIdentifier();
            OSRPersonalIdentifierSerializer.putOptionalOSRPersonalIdentifier(iSerializer, oSRPersonalIdentifier);
            OSRDevice[] oSRDeviceArray = oSRUser.getDevicesForAutologin();
            OSRDeviceSerializer.putOptionalOSRDeviceVarArray(iSerializer, oSRDeviceArray);
            int n = oSRUser.getPrivacyFlag();
            iSerializer.putInt32(n);
            int n2 = oSRUser.getUsertype();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalOSRUserVarArray(ISerializer iSerializer, OSRUser[] oSRUserArray) {
        boolean bl = oSRUserArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(oSRUserArray.length);
            for (int i2 = 0; i2 < oSRUserArray.length; ++i2) {
                OSRUserSerializer.putOptionalOSRUser(iSerializer, oSRUserArray[i2]);
            }
        }
    }

    public static OSRUser getOptionalOSRUser(IDeserializer iDeserializer) {
        OSRUser oSRUser = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            OSRPersonalIdentifier oSRPersonalIdentifier;
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            oSRUser = new OSRUser();
            oSRUser.authIdentifier = string5 = iDeserializer.getOptionalString();
            oSRUser.portalUser = string4 = iDeserializer.getOptionalString();
            oSRUser.hash1 = string3 = iDeserializer.getOptionalString();
            oSRUser.hash2 = string2 = iDeserializer.getOptionalString();
            oSRUser.name = string = iDeserializer.getOptionalString();
            oSRUser.personalIdentifier = oSRPersonalIdentifier = OSRPersonalIdentifierSerializer.getOptionalOSRPersonalIdentifier(iDeserializer);
            OSRDevice[] oSRDeviceArray = OSRDeviceSerializer.getOptionalOSRDeviceVarArray(iDeserializer);
            oSRUser.devicesForAutologin = oSRDeviceArray;
            oSRUser.privacyFlag = n2 = iDeserializer.getInt32();
            oSRUser.usertype = n = iDeserializer.getInt32();
        }
        return oSRUser;
    }

    public static OSRUser[] getOptionalOSRUserVarArray(IDeserializer iDeserializer) {
        OSRUser[] oSRUserArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            oSRUserArray = new OSRUser[n];
            for (int i2 = 0; i2 < n; ++i2) {
                oSRUserArray[i2] = OSRUserSerializer.getOptionalOSRUser(iDeserializer);
            }
        }
        return oSRUserArray;
    }
}

