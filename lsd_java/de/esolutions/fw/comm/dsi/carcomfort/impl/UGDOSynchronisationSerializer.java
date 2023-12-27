/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOSynchronisation;

public class UGDOSynchronisationSerializer {
    public static void putOptionalUGDOSynchronisation(ISerializer iSerializer, UGDOSynchronisation uGDOSynchronisation) {
        boolean bl = uGDOSynchronisation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = uGDOSynchronisation.getState();
            iSerializer.putInt32(n);
            int n2 = uGDOSynchronisation.getSoftkey();
            iSerializer.putInt32(n2);
            int n3 = uGDOSynchronisation.getDoorMovement();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalUGDOSynchronisationVarArray(ISerializer iSerializer, UGDOSynchronisation[] uGDOSynchronisationArray) {
        boolean bl = uGDOSynchronisationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uGDOSynchronisationArray.length);
            for (int i2 = 0; i2 < uGDOSynchronisationArray.length; ++i2) {
                UGDOSynchronisationSerializer.putOptionalUGDOSynchronisation(iSerializer, uGDOSynchronisationArray[i2]);
            }
        }
    }

    public static UGDOSynchronisation getOptionalUGDOSynchronisation(IDeserializer iDeserializer) {
        UGDOSynchronisation uGDOSynchronisation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            uGDOSynchronisation = new UGDOSynchronisation();
            uGDOSynchronisation.state = n3 = iDeserializer.getInt32();
            uGDOSynchronisation.softkey = n2 = iDeserializer.getInt32();
            uGDOSynchronisation.doorMovement = n = iDeserializer.getInt32();
        }
        return uGDOSynchronisation;
    }

    public static UGDOSynchronisation[] getOptionalUGDOSynchronisationVarArray(IDeserializer iDeserializer) {
        UGDOSynchronisation[] uGDOSynchronisationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uGDOSynchronisationArray = new UGDOSynchronisation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uGDOSynchronisationArray[i2] = UGDOSynchronisationSerializer.getOptionalUGDOSynchronisation(iDeserializer);
            }
        }
        return uGDOSynchronisationArray;
    }
}

