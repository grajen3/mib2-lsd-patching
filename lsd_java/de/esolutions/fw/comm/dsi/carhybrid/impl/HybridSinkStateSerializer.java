/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.HybridSinkState;

public class HybridSinkStateSerializer {
    public static void putOptionalHybridSinkState(ISerializer iSerializer, HybridSinkState hybridSinkState) {
        boolean bl = hybridSinkState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = hybridSinkState.isInstallation();
            iSerializer.putBool(bl2);
            boolean bl3 = hybridSinkState.isHeating();
            iSerializer.putBool(bl3);
            boolean bl4 = hybridSinkState.isCooling();
            iSerializer.putBool(bl4);
        }
    }

    public static void putOptionalHybridSinkStateVarArray(ISerializer iSerializer, HybridSinkState[] hybridSinkStateArray) {
        boolean bl = hybridSinkStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hybridSinkStateArray.length);
            for (int i2 = 0; i2 < hybridSinkStateArray.length; ++i2) {
                HybridSinkStateSerializer.putOptionalHybridSinkState(iSerializer, hybridSinkStateArray[i2]);
            }
        }
    }

    public static HybridSinkState getOptionalHybridSinkState(IDeserializer iDeserializer) {
        HybridSinkState hybridSinkState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            hybridSinkState = new HybridSinkState();
            hybridSinkState.installation = bl4 = iDeserializer.getBool();
            hybridSinkState.heating = bl3 = iDeserializer.getBool();
            hybridSinkState.cooling = bl2 = iDeserializer.getBool();
        }
        return hybridSinkState;
    }

    public static HybridSinkState[] getOptionalHybridSinkStateVarArray(IDeserializer iDeserializer) {
        HybridSinkState[] hybridSinkStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hybridSinkStateArray = new HybridSinkState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hybridSinkStateArray[i2] = HybridSinkStateSerializer.getOptionalHybridSinkState(iDeserializer);
            }
        }
        return hybridSinkStateArray;
    }
}

