/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.PortalPersonalData;

public class PortalPersonalDataSerializer {
    public static void putOptionalPortalPersonalData(ISerializer iSerializer, PortalPersonalData portalPersonalData) {
        boolean bl = portalPersonalData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = portalPersonalData.getLastName();
            iSerializer.putOptionalString(string);
            String string2 = portalPersonalData.getLastNameSnd();
            iSerializer.putOptionalString(string2);
            String string3 = portalPersonalData.getFirstName();
            iSerializer.putOptionalString(string3);
            String string4 = portalPersonalData.getFirstNameSnd();
            iSerializer.putOptionalString(string4);
            String string5 = portalPersonalData.getOrganizationName();
            iSerializer.putOptionalString(string5);
            String string6 = portalPersonalData.getPosition();
            iSerializer.putOptionalString(string6);
        }
    }

    public static void putOptionalPortalPersonalDataVarArray(ISerializer iSerializer, PortalPersonalData[] portalPersonalDataArray) {
        boolean bl = portalPersonalDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(portalPersonalDataArray.length);
            for (int i2 = 0; i2 < portalPersonalDataArray.length; ++i2) {
                PortalPersonalDataSerializer.putOptionalPortalPersonalData(iSerializer, portalPersonalDataArray[i2]);
            }
        }
    }

    public static PortalPersonalData getOptionalPortalPersonalData(IDeserializer iDeserializer) {
        PortalPersonalData portalPersonalData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            portalPersonalData = new PortalPersonalData();
            portalPersonalData.lastName = string6 = iDeserializer.getOptionalString();
            portalPersonalData.lastNameSnd = string5 = iDeserializer.getOptionalString();
            portalPersonalData.firstName = string4 = iDeserializer.getOptionalString();
            portalPersonalData.firstNameSnd = string3 = iDeserializer.getOptionalString();
            portalPersonalData.organizationName = string2 = iDeserializer.getOptionalString();
            portalPersonalData.position = string = iDeserializer.getOptionalString();
        }
        return portalPersonalData;
    }

    public static PortalPersonalData[] getOptionalPortalPersonalDataVarArray(IDeserializer iDeserializer) {
        PortalPersonalData[] portalPersonalDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            portalPersonalDataArray = new PortalPersonalData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                portalPersonalDataArray[i2] = PortalPersonalDataSerializer.getOptionalPortalPersonalData(iDeserializer);
            }
        }
        return portalPersonalDataArray;
    }
}

