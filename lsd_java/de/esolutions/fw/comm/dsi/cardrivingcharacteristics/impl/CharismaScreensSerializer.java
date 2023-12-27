/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.CharismaScreens;

public class CharismaScreensSerializer {
    public static void putOptionalCharismaScreens(ISerializer iSerializer, CharismaScreens charismaScreens) {
        boolean bl = charismaScreens == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = charismaScreens.isProfiledcc();
            iSerializer.putBool(bl2);
            boolean bl3 = charismaScreens.isProfile();
            iSerializer.putBool(bl3);
            boolean bl4 = charismaScreens.isDcc();
            iSerializer.putBool(bl4);
            boolean bl5 = charismaScreens.isAirSuspension();
            iSerializer.putBool(bl5);
            boolean bl6 = charismaScreens.isHybrid();
            iSerializer.putBool(bl6);
            boolean bl7 = charismaScreens.isOffroad();
            iSerializer.putBool(bl7);
        }
    }

    public static void putOptionalCharismaScreensVarArray(ISerializer iSerializer, CharismaScreens[] charismaScreensArray) {
        boolean bl = charismaScreensArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(charismaScreensArray.length);
            for (int i2 = 0; i2 < charismaScreensArray.length; ++i2) {
                CharismaScreensSerializer.putOptionalCharismaScreens(iSerializer, charismaScreensArray[i2]);
            }
        }
    }

    public static CharismaScreens getOptionalCharismaScreens(IDeserializer iDeserializer) {
        CharismaScreens charismaScreens = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            charismaScreens = new CharismaScreens();
            charismaScreens.profiledcc = bl7 = iDeserializer.getBool();
            charismaScreens.profile = bl6 = iDeserializer.getBool();
            charismaScreens.dcc = bl5 = iDeserializer.getBool();
            charismaScreens.airSuspension = bl4 = iDeserializer.getBool();
            charismaScreens.hybrid = bl3 = iDeserializer.getBool();
            charismaScreens.offroad = bl2 = iDeserializer.getBool();
        }
        return charismaScreens;
    }

    public static CharismaScreens[] getOptionalCharismaScreensVarArray(IDeserializer iDeserializer) {
        CharismaScreens[] charismaScreensArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            charismaScreensArray = new CharismaScreens[n];
            for (int i2 = 0; i2 < n; ++i2) {
                charismaScreensArray[i2] = CharismaScreensSerializer.getOptionalCharismaScreens(iDeserializer);
            }
        }
        return charismaScreensArray;
    }
}

