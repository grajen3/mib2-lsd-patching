/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRNotifyProperties;

public class OSRNotifyPropertiesSerializer {
    public static void putOptionalOSRNotifyProperties(ISerializer iSerializer, OSRNotifyProperties oSRNotifyProperties) {
        boolean bl = oSRNotifyProperties == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = oSRNotifyProperties.getIdonlineapp();
            iSerializer.putOptionalString(string);
            int n = oSRNotifyProperties.getPriority();
            iSerializer.putInt32(n);
            int n2 = oSRNotifyProperties.getReason();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalOSRNotifyPropertiesVarArray(ISerializer iSerializer, OSRNotifyProperties[] oSRNotifyPropertiesArray) {
        boolean bl = oSRNotifyPropertiesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(oSRNotifyPropertiesArray.length);
            for (int i2 = 0; i2 < oSRNotifyPropertiesArray.length; ++i2) {
                OSRNotifyPropertiesSerializer.putOptionalOSRNotifyProperties(iSerializer, oSRNotifyPropertiesArray[i2]);
            }
        }
    }

    public static OSRNotifyProperties getOptionalOSRNotifyProperties(IDeserializer iDeserializer) {
        OSRNotifyProperties oSRNotifyProperties = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            String string;
            oSRNotifyProperties = new OSRNotifyProperties();
            oSRNotifyProperties.idonlineapp = string = iDeserializer.getOptionalString();
            oSRNotifyProperties.priority = n2 = iDeserializer.getInt32();
            oSRNotifyProperties.reason = n = iDeserializer.getInt32();
        }
        return oSRNotifyProperties;
    }

    public static OSRNotifyProperties[] getOptionalOSRNotifyPropertiesVarArray(IDeserializer iDeserializer) {
        OSRNotifyProperties[] oSRNotifyPropertiesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            oSRNotifyPropertiesArray = new OSRNotifyProperties[n];
            for (int i2 = 0; i2 < n; ++i2) {
                oSRNotifyPropertiesArray[i2] = OSRNotifyPropertiesSerializer.getOptionalOSRNotifyProperties(iDeserializer);
            }
        }
        return oSRNotifyPropertiesArray;
    }
}

