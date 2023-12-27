/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.RgTurnToInfo;

public class RgTurnToInfoSerializer {
    public static void putOptionalRgTurnToInfo(ISerializer iSerializer, RgTurnToInfo rgTurnToInfo) {
        boolean bl = rgTurnToInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = rgTurnToInfo.getTurnToStreet();
            iSerializer.putOptionalString(string);
            String string2 = rgTurnToInfo.getStreetIconText();
            iSerializer.putOptionalString(string2);
            int n = rgTurnToInfo.getStreetIconId();
            iSerializer.putInt32(n);
            boolean bl2 = rgTurnToInfo.isInProgressData();
            iSerializer.putBool(bl2);
            String string3 = rgTurnToInfo.getSignPost();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalRgTurnToInfoVarArray(ISerializer iSerializer, RgTurnToInfo[] rgTurnToInfoArray) {
        boolean bl = rgTurnToInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rgTurnToInfoArray.length);
            for (int i2 = 0; i2 < rgTurnToInfoArray.length; ++i2) {
                RgTurnToInfoSerializer.putOptionalRgTurnToInfo(iSerializer, rgTurnToInfoArray[i2]);
            }
        }
    }

    public static RgTurnToInfo getOptionalRgTurnToInfo(IDeserializer iDeserializer) {
        RgTurnToInfo rgTurnToInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            boolean bl2;
            int n;
            String string2;
            String string3;
            rgTurnToInfo = new RgTurnToInfo();
            rgTurnToInfo.turnToStreet = string3 = iDeserializer.getOptionalString();
            rgTurnToInfo.streetIconText = string2 = iDeserializer.getOptionalString();
            rgTurnToInfo.streetIconId = n = iDeserializer.getInt32();
            rgTurnToInfo.inProgressData = bl2 = iDeserializer.getBool();
            rgTurnToInfo.signPost = string = iDeserializer.getOptionalString();
        }
        return rgTurnToInfo;
    }

    public static RgTurnToInfo[] getOptionalRgTurnToInfoVarArray(IDeserializer iDeserializer) {
        RgTurnToInfo[] rgTurnToInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rgTurnToInfoArray = new RgTurnToInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rgTurnToInfoArray[i2] = RgTurnToInfoSerializer.getOptionalRgTurnToInfo(iDeserializer);
            }
        }
        return rgTurnToInfoArray;
    }
}

