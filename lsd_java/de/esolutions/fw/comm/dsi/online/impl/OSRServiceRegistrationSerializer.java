/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRServiceRegistration;

public class OSRServiceRegistrationSerializer {
    public static void putOptionalOSRServiceRegistration(ISerializer iSerializer, OSRServiceRegistration oSRServiceRegistration) {
        boolean bl = oSRServiceRegistration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = oSRServiceRegistration.getAppID();
            iSerializer.putOptionalString(string);
            String string2 = oSRServiceRegistration.getServiceID();
            iSerializer.putOptionalString(string2);
            String string3 = oSRServiceRegistration.getSymbolicName();
            iSerializer.putOptionalString(string3);
            String string4 = oSRServiceRegistration.getLocalizedDescription();
            iSerializer.putOptionalString(string4);
            boolean bl2 = oSRServiceRegistration.isMandatoryFlag();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalOSRServiceRegistrationVarArray(ISerializer iSerializer, OSRServiceRegistration[] oSRServiceRegistrationArray) {
        boolean bl = oSRServiceRegistrationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(oSRServiceRegistrationArray.length);
            for (int i2 = 0; i2 < oSRServiceRegistrationArray.length; ++i2) {
                OSRServiceRegistrationSerializer.putOptionalOSRServiceRegistration(iSerializer, oSRServiceRegistrationArray[i2]);
            }
        }
    }

    public static OSRServiceRegistration getOptionalOSRServiceRegistration(IDeserializer iDeserializer) {
        OSRServiceRegistration oSRServiceRegistration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            String string;
            String string2;
            String string3;
            String string4;
            oSRServiceRegistration = new OSRServiceRegistration();
            oSRServiceRegistration.appID = string4 = iDeserializer.getOptionalString();
            oSRServiceRegistration.serviceID = string3 = iDeserializer.getOptionalString();
            oSRServiceRegistration.symbolicName = string2 = iDeserializer.getOptionalString();
            oSRServiceRegistration.localizedDescription = string = iDeserializer.getOptionalString();
            oSRServiceRegistration.mandatoryFlag = bl2 = iDeserializer.getBool();
        }
        return oSRServiceRegistration;
    }

    public static OSRServiceRegistration[] getOptionalOSRServiceRegistrationVarArray(IDeserializer iDeserializer) {
        OSRServiceRegistration[] oSRServiceRegistrationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            oSRServiceRegistrationArray = new OSRServiceRegistration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                oSRServiceRegistrationArray[i2] = OSRServiceRegistrationSerializer.getOptionalOSRServiceRegistration(iDeserializer);
            }
        }
        return oSRServiceRegistrationArray;
    }
}

