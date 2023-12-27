/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OSRApplicationProperties;

public class OSRApplicationPropertiesSerializer {
    public static void putOptionalOSRApplicationProperties(ISerializer iSerializer, OSRApplicationProperties oSRApplicationProperties) {
        boolean bl = oSRApplicationProperties == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = oSRApplicationProperties.getGroup();
            iSerializer.putInt32(n);
            String string = oSRApplicationProperties.getKey();
            iSerializer.putOptionalString(string);
            String string2 = oSRApplicationProperties.getValue();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalOSRApplicationPropertiesVarArray(ISerializer iSerializer, OSRApplicationProperties[] oSRApplicationPropertiesArray) {
        boolean bl = oSRApplicationPropertiesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(oSRApplicationPropertiesArray.length);
            for (int i2 = 0; i2 < oSRApplicationPropertiesArray.length; ++i2) {
                OSRApplicationPropertiesSerializer.putOptionalOSRApplicationProperties(iSerializer, oSRApplicationPropertiesArray[i2]);
            }
        }
    }

    public static OSRApplicationProperties getOptionalOSRApplicationProperties(IDeserializer iDeserializer) {
        OSRApplicationProperties oSRApplicationProperties = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            int n;
            oSRApplicationProperties = new OSRApplicationProperties();
            oSRApplicationProperties.group = n = iDeserializer.getInt32();
            oSRApplicationProperties.key = string2 = iDeserializer.getOptionalString();
            oSRApplicationProperties.value = string = iDeserializer.getOptionalString();
        }
        return oSRApplicationProperties;
    }

    public static OSRApplicationProperties[] getOptionalOSRApplicationPropertiesVarArray(IDeserializer iDeserializer) {
        OSRApplicationProperties[] oSRApplicationPropertiesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            oSRApplicationPropertiesArray = new OSRApplicationProperties[n];
            for (int i2 = 0; i2 < n; ++i2) {
                oSRApplicationPropertiesArray[i2] = OSRApplicationPropertiesSerializer.getOptionalOSRApplicationProperties(iDeserializer);
            }
        }
        return oSRApplicationPropertiesArray;
    }
}

