/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.BapTurnToInfo;

public class BapTurnToInfoSerializer {
    public static void putOptionalBapTurnToInfo(ISerializer iSerializer, BapTurnToInfo bapTurnToInfo) {
        boolean bl = bapTurnToInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = bapTurnToInfo.getTurnToInfo();
            iSerializer.putOptionalString(string);
            String string2 = bapTurnToInfo.getSignPost();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalBapTurnToInfoVarArray(ISerializer iSerializer, BapTurnToInfo[] bapTurnToInfoArray) {
        boolean bl = bapTurnToInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bapTurnToInfoArray.length);
            for (int i2 = 0; i2 < bapTurnToInfoArray.length; ++i2) {
                BapTurnToInfoSerializer.putOptionalBapTurnToInfo(iSerializer, bapTurnToInfoArray[i2]);
            }
        }
    }

    public static BapTurnToInfo getOptionalBapTurnToInfo(IDeserializer iDeserializer) {
        BapTurnToInfo bapTurnToInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            bapTurnToInfo = new BapTurnToInfo();
            bapTurnToInfo.turnToInfo = string2 = iDeserializer.getOptionalString();
            bapTurnToInfo.signPost = string = iDeserializer.getOptionalString();
        }
        return bapTurnToInfo;
    }

    public static BapTurnToInfo[] getOptionalBapTurnToInfoVarArray(IDeserializer iDeserializer) {
        BapTurnToInfo[] bapTurnToInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bapTurnToInfoArray = new BapTurnToInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bapTurnToInfoArray[i2] = BapTurnToInfoSerializer.getOptionalBapTurnToInfo(iDeserializer);
            }
        }
        return bapTurnToInfoArray;
    }
}

