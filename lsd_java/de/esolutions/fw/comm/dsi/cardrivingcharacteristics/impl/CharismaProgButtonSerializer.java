/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;

public class CharismaProgButtonSerializer {
    public static void putOptionalCharismaProgButton(ISerializer iSerializer, CharismaProgButton charismaProgButton) {
        boolean bl = charismaProgButton == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = charismaProgButton.isButton1();
            iSerializer.putBool(bl2);
            boolean bl3 = charismaProgButton.isButton2();
            iSerializer.putBool(bl3);
            boolean bl4 = charismaProgButton.isButton3();
            iSerializer.putBool(bl4);
            boolean bl5 = charismaProgButton.isButton4();
            iSerializer.putBool(bl5);
            boolean bl6 = charismaProgButton.isButton5();
            iSerializer.putBool(bl6);
        }
    }

    public static void putOptionalCharismaProgButtonVarArray(ISerializer iSerializer, CharismaProgButton[] charismaProgButtonArray) {
        boolean bl = charismaProgButtonArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(charismaProgButtonArray.length);
            for (int i2 = 0; i2 < charismaProgButtonArray.length; ++i2) {
                CharismaProgButtonSerializer.putOptionalCharismaProgButton(iSerializer, charismaProgButtonArray[i2]);
            }
        }
    }

    public static CharismaProgButton getOptionalCharismaProgButton(IDeserializer iDeserializer) {
        CharismaProgButton charismaProgButton = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            charismaProgButton = new CharismaProgButton();
            charismaProgButton.button1 = bl6 = iDeserializer.getBool();
            charismaProgButton.button2 = bl5 = iDeserializer.getBool();
            charismaProgButton.button3 = bl4 = iDeserializer.getBool();
            charismaProgButton.button4 = bl3 = iDeserializer.getBool();
            charismaProgButton.button5 = bl2 = iDeserializer.getBool();
        }
        return charismaProgButton;
    }

    public static CharismaProgButton[] getOptionalCharismaProgButtonVarArray(IDeserializer iDeserializer) {
        CharismaProgButton[] charismaProgButtonArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            charismaProgButtonArray = new CharismaProgButton[n];
            for (int i2 = 0; i2 < n; ++i2) {
                charismaProgButtonArray[i2] = CharismaProgButtonSerializer.getOptionalCharismaProgButton(iDeserializer);
            }
        }
        return charismaProgButtonArray;
    }
}

