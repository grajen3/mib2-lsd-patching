/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCTankLevel;

public class BCTankLevelSerializer {
    public static void putOptionalBCTankLevel(ISerializer iSerializer, BCTankLevel bCTankLevel) {
        boolean bl = bCTankLevel == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCTankLevel.getState();
            iSerializer.putInt32(n);
            int n2 = bCTankLevel.getTankLevelValue();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalBCTankLevelVarArray(ISerializer iSerializer, BCTankLevel[] bCTankLevelArray) {
        boolean bl = bCTankLevelArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCTankLevelArray.length);
            for (int i2 = 0; i2 < bCTankLevelArray.length; ++i2) {
                BCTankLevelSerializer.putOptionalBCTankLevel(iSerializer, bCTankLevelArray[i2]);
            }
        }
    }

    public static BCTankLevel getOptionalBCTankLevel(IDeserializer iDeserializer) {
        BCTankLevel bCTankLevel = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            bCTankLevel = new BCTankLevel();
            bCTankLevel.state = n2 = iDeserializer.getInt32();
            bCTankLevel.tankLevelValue = n = iDeserializer.getInt32();
        }
        return bCTankLevel;
    }

    public static BCTankLevel[] getOptionalBCTankLevelVarArray(IDeserializer iDeserializer) {
        BCTankLevel[] bCTankLevelArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCTankLevelArray = new BCTankLevel[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCTankLevelArray[i2] = BCTankLevelSerializer.getOptionalBCTankLevel(iDeserializer);
            }
        }
        return bCTankLevelArray;
    }
}

