/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.SoundAvailableStyles;

public class SoundAvailableStylesSerializer {
    public static void putOptionalSoundAvailableStyles(ISerializer iSerializer, SoundAvailableStyles soundAvailableStyles) {
        boolean bl = soundAvailableStyles == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = soundAvailableStyles.isStyle1();
            iSerializer.putBool(bl2);
            boolean bl3 = soundAvailableStyles.isStyle2();
            iSerializer.putBool(bl3);
            boolean bl4 = soundAvailableStyles.isStyle3();
            iSerializer.putBool(bl4);
            boolean bl5 = soundAvailableStyles.isStyle4();
            iSerializer.putBool(bl5);
            boolean bl6 = soundAvailableStyles.isStyle5();
            iSerializer.putBool(bl6);
            boolean bl7 = soundAvailableStyles.isStyle6();
            iSerializer.putBool(bl7);
            boolean bl8 = soundAvailableStyles.isStyle7();
            iSerializer.putBool(bl8);
            boolean bl9 = soundAvailableStyles.isStyle8();
            iSerializer.putBool(bl9);
        }
    }

    public static void putOptionalSoundAvailableStylesVarArray(ISerializer iSerializer, SoundAvailableStyles[] soundAvailableStylesArray) {
        boolean bl = soundAvailableStylesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(soundAvailableStylesArray.length);
            for (int i2 = 0; i2 < soundAvailableStylesArray.length; ++i2) {
                SoundAvailableStylesSerializer.putOptionalSoundAvailableStyles(iSerializer, soundAvailableStylesArray[i2]);
            }
        }
    }

    public static SoundAvailableStyles getOptionalSoundAvailableStyles(IDeserializer iDeserializer) {
        SoundAvailableStyles soundAvailableStyles = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            soundAvailableStyles = new SoundAvailableStyles();
            soundAvailableStyles.style1 = bl9 = iDeserializer.getBool();
            soundAvailableStyles.style2 = bl8 = iDeserializer.getBool();
            soundAvailableStyles.style3 = bl7 = iDeserializer.getBool();
            soundAvailableStyles.style4 = bl6 = iDeserializer.getBool();
            soundAvailableStyles.style5 = bl5 = iDeserializer.getBool();
            soundAvailableStyles.style6 = bl4 = iDeserializer.getBool();
            soundAvailableStyles.style7 = bl3 = iDeserializer.getBool();
            soundAvailableStyles.style8 = bl2 = iDeserializer.getBool();
        }
        return soundAvailableStyles;
    }

    public static SoundAvailableStyles[] getOptionalSoundAvailableStylesVarArray(IDeserializer iDeserializer) {
        SoundAvailableStyles[] soundAvailableStylesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            soundAvailableStylesArray = new SoundAvailableStyles[n];
            for (int i2 = 0; i2 < n; ++i2) {
                soundAvailableStylesArray[i2] = SoundAvailableStylesSerializer.getOptionalSoundAvailableStyles(iDeserializer);
            }
        }
        return soundAvailableStylesArray;
    }
}

