/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.online.OSRLicense;

public class OSRLicenseSerializer {
    public static void putOptionalOSRLicense(ISerializer iSerializer, OSRLicense oSRLicense) {
        boolean bl = oSRLicense == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = oSRLicense.getId();
            iSerializer.putOptionalString(string);
            int n = oSRLicense.getState();
            iSerializer.putInt32(n);
            DateTime dateTime = oSRLicense.getActivation();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime);
            DateTime dateTime2 = oSRLicense.getExpires();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime2);
            String string2 = oSRLicense.getDuration();
            iSerializer.putOptionalString(string2);
            String[] stringArray = oSRLicense.getCountry();
            iSerializer.putOptionalStringVarArray(stringArray);
            String string3 = oSRLicense.getServiceID();
            iSerializer.putOptionalString(string3);
            boolean bl2 = oSRLicense.isWarn();
            iSerializer.putBool(bl2);
            String string4 = oSRLicense.getName();
            iSerializer.putOptionalString(string4);
            String string5 = oSRLicense.getDescription();
            iSerializer.putOptionalString(string5);
            String[] stringArray2 = oSRLicense.getOnlineserviceassignments();
            iSerializer.putOptionalStringVarArray(stringArray2);
            int n2 = oSRLicense.getType();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalOSRLicenseVarArray(ISerializer iSerializer, OSRLicense[] oSRLicenseArray) {
        boolean bl = oSRLicenseArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(oSRLicenseArray.length);
            for (int i2 = 0; i2 < oSRLicenseArray.length; ++i2) {
                OSRLicenseSerializer.putOptionalOSRLicense(iSerializer, oSRLicenseArray[i2]);
            }
        }
    }

    public static OSRLicense getOptionalOSRLicense(IDeserializer iDeserializer) {
        OSRLicense oSRLicense = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            String string2;
            boolean bl2;
            String string3;
            String string4;
            DateTime dateTime;
            DateTime dateTime2;
            int n2;
            String string5;
            oSRLicense = new OSRLicense();
            oSRLicense.id = string5 = iDeserializer.getOptionalString();
            oSRLicense.state = n2 = iDeserializer.getInt32();
            oSRLicense.activation = dateTime2 = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            oSRLicense.expires = dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            oSRLicense.duration = string4 = iDeserializer.getOptionalString();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            oSRLicense.country = stringArray;
            oSRLicense.serviceID = string3 = iDeserializer.getOptionalString();
            oSRLicense.warn = bl2 = iDeserializer.getBool();
            oSRLicense.name = string2 = iDeserializer.getOptionalString();
            oSRLicense.description = string = iDeserializer.getOptionalString();
            String[] stringArray2 = iDeserializer.getOptionalStringVarArray();
            oSRLicense.onlineserviceassignments = stringArray2;
            oSRLicense.type = n = iDeserializer.getInt32();
        }
        return oSRLicense;
    }

    public static OSRLicense[] getOptionalOSRLicenseVarArray(IDeserializer iDeserializer) {
        OSRLicense[] oSRLicenseArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            oSRLicenseArray = new OSRLicense[n];
            for (int i2 = 0; i2 < n; ++i2) {
                oSRLicenseArray[i2] = OSRLicenseSerializer.getOptionalOSRLicense(iDeserializer);
            }
        }
        return oSRLicenseArray;
    }
}

