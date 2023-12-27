/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.License;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class LicenseSerializer {
    public static void putOptionalLicense(ISerializer iSerializer, License license) {
        boolean bl = license == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = license.getId();
            iSerializer.putOptionalString(string);
            int n = license.getState();
            iSerializer.putEnum(n);
            long l = license.getActivation();
            iSerializer.putUInt64(l);
            long l2 = license.getExpires();
            iSerializer.putUInt64(l2);
            String string2 = license.getDuration();
            iSerializer.putOptionalString(string2);
            String[] stringArray = license.getCountry();
            iSerializer.putOptionalStringVarArray(stringArray);
            String string3 = license.getServiceID();
            iSerializer.putOptionalString(string3);
            boolean bl2 = license.isWarn();
            iSerializer.putBool(bl2);
            String string4 = license.getName();
            iSerializer.putOptionalString(string4);
        }
    }

    public static void putOptionalLicenseVarArray(ISerializer iSerializer, License[] licenseArray) {
        boolean bl = licenseArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(licenseArray.length);
            for (int i2 = 0; i2 < licenseArray.length; ++i2) {
                LicenseSerializer.putOptionalLicense(iSerializer, licenseArray[i2]);
            }
        }
    }

    public static License getOptionalLicense(IDeserializer iDeserializer) {
        License license = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            boolean bl2;
            String string2;
            String string3;
            long l;
            long l2;
            int n;
            String string4;
            license = new License();
            license.id = string4 = iDeserializer.getOptionalString();
            license.state = n = iDeserializer.getEnum();
            license.activation = l2 = iDeserializer.getUInt64();
            license.expires = l = iDeserializer.getUInt64();
            license.duration = string3 = iDeserializer.getOptionalString();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            license.country = stringArray;
            license.serviceID = string2 = iDeserializer.getOptionalString();
            license.warn = bl2 = iDeserializer.getBool();
            license.name = string = iDeserializer.getOptionalString();
        }
        return license;
    }

    public static License[] getOptionalLicenseVarArray(IDeserializer iDeserializer) {
        License[] licenseArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            licenseArray = new License[n];
            for (int i2 = 0; i2 < n; ++i2) {
                licenseArray[i2] = LicenseSerializer.getOptionalLicense(iDeserializer);
            }
        }
        return licenseArray;
    }
}

