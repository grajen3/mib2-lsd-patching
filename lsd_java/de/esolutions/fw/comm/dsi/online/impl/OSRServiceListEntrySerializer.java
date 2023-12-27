/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.online.impl.OSRLicenseSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRServiceListEntry;

public class OSRServiceListEntrySerializer {
    public static void putOptionalOSRServiceListEntry(ISerializer iSerializer, OSRServiceListEntry oSRServiceListEntry) {
        boolean bl = oSRServiceListEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = oSRServiceListEntry.getServiceID();
            iSerializer.putOptionalString(string);
            int n = oSRServiceListEntry.getServiceType();
            iSerializer.putInt32(n);
            int n2 = oSRServiceListEntry.getPrivacyGroup();
            iSerializer.putInt32(n2);
            boolean bl2 = oSRServiceListEntry.isEnableDisableServiceState();
            iSerializer.putBool(bl2);
            int n3 = oSRServiceListEntry.getBackendReasons();
            iSerializer.putInt32(n3);
            int n4 = oSRServiceListEntry.getVehicleLocalServiceState();
            iSerializer.putInt32(n4);
            boolean bl3 = oSRServiceListEntry.isLicenseRequired();
            iSerializer.putBool(bl3);
            boolean bl4 = oSRServiceListEntry.isBlocksDisabling();
            iSerializer.putBool(bl4);
            boolean bl5 = oSRServiceListEntry.isPrimaryUserRequired();
            iSerializer.putBool(bl5);
            boolean bl6 = oSRServiceListEntry.isTermsAndConditionsRequired();
            iSerializer.putBool(bl6);
            int n5 = oSRServiceListEntry.getApn();
            iSerializer.putInt32(n5);
            int n6 = oSRServiceListEntry.getQos();
            iSerializer.putInt32(n6);
            int n7 = oSRServiceListEntry.getAuthLevel();
            iSerializer.putInt32(n7);
            OSRLicense oSRLicense = oSRServiceListEntry.getLicense();
            OSRLicenseSerializer.putOptionalOSRLicense(iSerializer, oSRLicense);
        }
    }

    public static void putOptionalOSRServiceListEntryVarArray(ISerializer iSerializer, OSRServiceListEntry[] oSRServiceListEntryArray) {
        boolean bl = oSRServiceListEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(oSRServiceListEntryArray.length);
            for (int i2 = 0; i2 < oSRServiceListEntryArray.length; ++i2) {
                OSRServiceListEntrySerializer.putOptionalOSRServiceListEntry(iSerializer, oSRServiceListEntryArray[i2]);
            }
        }
    }

    public static OSRServiceListEntry getOptionalOSRServiceListEntry(IDeserializer iDeserializer) {
        OSRServiceListEntry oSRServiceListEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            OSRLicense oSRLicense;
            int n;
            int n2;
            int n3;
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            int n4;
            int n5;
            boolean bl6;
            int n6;
            int n7;
            String string;
            oSRServiceListEntry = new OSRServiceListEntry();
            oSRServiceListEntry.serviceID = string = iDeserializer.getOptionalString();
            oSRServiceListEntry.serviceType = n7 = iDeserializer.getInt32();
            oSRServiceListEntry.privacyGroup = n6 = iDeserializer.getInt32();
            oSRServiceListEntry.enableDisableServiceState = bl6 = iDeserializer.getBool();
            oSRServiceListEntry.backendReasons = n5 = iDeserializer.getInt32();
            oSRServiceListEntry.vehicleLocalServiceState = n4 = iDeserializer.getInt32();
            oSRServiceListEntry.licenseRequired = bl5 = iDeserializer.getBool();
            oSRServiceListEntry.blocksDisabling = bl4 = iDeserializer.getBool();
            oSRServiceListEntry.primaryUserRequired = bl3 = iDeserializer.getBool();
            oSRServiceListEntry.termsAndConditionsRequired = bl2 = iDeserializer.getBool();
            oSRServiceListEntry.apn = n3 = iDeserializer.getInt32();
            oSRServiceListEntry.qos = n2 = iDeserializer.getInt32();
            oSRServiceListEntry.authLevel = n = iDeserializer.getInt32();
            oSRServiceListEntry.license = oSRLicense = OSRLicenseSerializer.getOptionalOSRLicense(iDeserializer);
        }
        return oSRServiceListEntry;
    }

    public static OSRServiceListEntry[] getOptionalOSRServiceListEntryVarArray(IDeserializer iDeserializer) {
        OSRServiceListEntry[] oSRServiceListEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            oSRServiceListEntryArray = new OSRServiceListEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                oSRServiceListEntryArray[i2] = OSRServiceListEntrySerializer.getOptionalOSRServiceListEntry(iDeserializer);
            }
        }
        return oSRServiceListEntryArray;
    }
}

