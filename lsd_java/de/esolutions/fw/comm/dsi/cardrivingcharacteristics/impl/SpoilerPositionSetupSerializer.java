/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerPositionSetup;

public class SpoilerPositionSetupSerializer {
    public static void putOptionalSpoilerPositionSetup(ISerializer iSerializer, SpoilerPositionSetup spoilerPositionSetup) {
        boolean bl = spoilerPositionSetup == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = spoilerPositionSetup.getPosition0();
            iSerializer.putInt32(n);
            int n2 = spoilerPositionSetup.getPosition1();
            iSerializer.putInt32(n2);
            int n3 = spoilerPositionSetup.getPosition2();
            iSerializer.putInt32(n3);
            int n4 = spoilerPositionSetup.getPosition3();
            iSerializer.putInt32(n4);
            int n5 = spoilerPositionSetup.getPosition4();
            iSerializer.putInt32(n5);
            int n6 = spoilerPositionSetup.getPosition5();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalSpoilerPositionSetupVarArray(ISerializer iSerializer, SpoilerPositionSetup[] spoilerPositionSetupArray) {
        boolean bl = spoilerPositionSetupArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(spoilerPositionSetupArray.length);
            for (int i2 = 0; i2 < spoilerPositionSetupArray.length; ++i2) {
                SpoilerPositionSetupSerializer.putOptionalSpoilerPositionSetup(iSerializer, spoilerPositionSetupArray[i2]);
            }
        }
    }

    public static SpoilerPositionSetup getOptionalSpoilerPositionSetup(IDeserializer iDeserializer) {
        SpoilerPositionSetup spoilerPositionSetup = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            spoilerPositionSetup = new SpoilerPositionSetup();
            spoilerPositionSetup.position0 = n6 = iDeserializer.getInt32();
            spoilerPositionSetup.position1 = n5 = iDeserializer.getInt32();
            spoilerPositionSetup.position2 = n4 = iDeserializer.getInt32();
            spoilerPositionSetup.position3 = n3 = iDeserializer.getInt32();
            spoilerPositionSetup.position4 = n2 = iDeserializer.getInt32();
            spoilerPositionSetup.position5 = n = iDeserializer.getInt32();
        }
        return spoilerPositionSetup;
    }

    public static SpoilerPositionSetup[] getOptionalSpoilerPositionSetupVarArray(IDeserializer iDeserializer) {
        SpoilerPositionSetup[] spoilerPositionSetupArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            spoilerPositionSetupArray = new SpoilerPositionSetup[n];
            for (int i2 = 0; i2 < n; ++i2) {
                spoilerPositionSetupArray[i2] = SpoilerPositionSetupSerializer.getOptionalSpoilerPositionSetup(iDeserializer);
            }
        }
        return spoilerPositionSetupArray;
    }
}

