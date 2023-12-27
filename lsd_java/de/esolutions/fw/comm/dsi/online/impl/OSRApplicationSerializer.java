/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.online.impl.OSRApplicationPropertiesSerializer;
import de.esolutions.fw.comm.dsi.online.impl.OSRLicenseSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRApplicationProperties;
import org.dsi.ifc.online.OSRLicense;

public class OSRApplicationSerializer {
    public static void putOptionalOSRApplication(ISerializer iSerializer, OSRApplication oSRApplication) {
        boolean bl = oSRApplication == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = oSRApplication.getId();
            iSerializer.putOptionalString(string);
            int n = oSRApplication.getState();
            iSerializer.putInt32(n);
            boolean bl2 = oSRApplication.isDemandstate();
            iSerializer.putBool(bl2);
            OSRLicense[] oSRLicenseArray = oSRApplication.getLicenseList();
            OSRLicenseSerializer.putOptionalOSRLicenseVarArray(iSerializer, oSRLicenseArray);
            OSRApplicationProperties[] oSRApplicationPropertiesArray = oSRApplication.getPropertyList();
            OSRApplicationPropertiesSerializer.putOptionalOSRApplicationPropertiesVarArray(iSerializer, oSRApplicationPropertiesArray);
        }
    }

    public static void putOptionalOSRApplicationVarArray(ISerializer iSerializer, OSRApplication[] oSRApplicationArray) {
        boolean bl = oSRApplicationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(oSRApplicationArray.length);
            for (int i2 = 0; i2 < oSRApplicationArray.length; ++i2) {
                OSRApplicationSerializer.putOptionalOSRApplication(iSerializer, oSRApplicationArray[i2]);
            }
        }
    }

    public static OSRApplication getOptionalOSRApplication(IDeserializer iDeserializer) {
        OSRApplication oSRApplication = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            int n;
            String string;
            oSRApplication = new OSRApplication();
            oSRApplication.id = string = iDeserializer.getOptionalString();
            oSRApplication.state = n = iDeserializer.getInt32();
            oSRApplication.demandstate = bl2 = iDeserializer.getBool();
            OSRLicense[] oSRLicenseArray = OSRLicenseSerializer.getOptionalOSRLicenseVarArray(iDeserializer);
            oSRApplication.licenseList = oSRLicenseArray;
            OSRApplicationProperties[] oSRApplicationPropertiesArray = OSRApplicationPropertiesSerializer.getOptionalOSRApplicationPropertiesVarArray(iDeserializer);
            oSRApplication.propertyList = oSRApplicationPropertiesArray;
        }
        return oSRApplication;
    }

    public static OSRApplication[] getOptionalOSRApplicationVarArray(IDeserializer iDeserializer) {
        OSRApplication[] oSRApplicationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            oSRApplicationArray = new OSRApplication[n];
            for (int i2 = 0; i2 < n; ++i2) {
                oSRApplicationArray[i2] = OSRApplicationSerializer.getOptionalOSRApplication(iDeserializer);
            }
        }
        return oSRApplicationArray;
    }
}

