/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tmc.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tmc.TmcPhoneme;

public class TmcPhonemeSerializer {
    public static void putOptionalTmcPhoneme(ISerializer iSerializer, TmcPhoneme tmcPhoneme) {
        boolean bl = tmcPhoneme == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = tmcPhoneme.getRoadName();
            iSerializer.putOptionalString(string);
            String string2 = tmcPhoneme.getDirectionOfRoad1();
            iSerializer.putOptionalString(string2);
            String string3 = tmcPhoneme.getDirectionOfRoad2();
            iSerializer.putOptionalString(string3);
            String string4 = tmcPhoneme.getStartLocation();
            iSerializer.putOptionalString(string4);
            String string5 = tmcPhoneme.getEndLocation();
            iSerializer.putOptionalString(string5);
            String string6 = tmcPhoneme.getPhonemeAlphabet();
            iSerializer.putOptionalString(string6);
        }
    }

    public static void putOptionalTmcPhonemeVarArray(ISerializer iSerializer, TmcPhoneme[] tmcPhonemeArray) {
        boolean bl = tmcPhonemeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tmcPhonemeArray.length);
            for (int i2 = 0; i2 < tmcPhonemeArray.length; ++i2) {
                TmcPhonemeSerializer.putOptionalTmcPhoneme(iSerializer, tmcPhonemeArray[i2]);
            }
        }
    }

    public static TmcPhoneme getOptionalTmcPhoneme(IDeserializer iDeserializer) {
        TmcPhoneme tmcPhoneme = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            tmcPhoneme = new TmcPhoneme();
            tmcPhoneme.roadName = string6 = iDeserializer.getOptionalString();
            tmcPhoneme.directionOfRoad1 = string5 = iDeserializer.getOptionalString();
            tmcPhoneme.directionOfRoad2 = string4 = iDeserializer.getOptionalString();
            tmcPhoneme.startLocation = string3 = iDeserializer.getOptionalString();
            tmcPhoneme.endLocation = string2 = iDeserializer.getOptionalString();
            tmcPhoneme.phonemeAlphabet = string = iDeserializer.getOptionalString();
        }
        return tmcPhoneme;
    }

    public static TmcPhoneme[] getOptionalTmcPhonemeVarArray(IDeserializer iDeserializer) {
        TmcPhoneme[] tmcPhonemeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tmcPhonemeArray = new TmcPhoneme[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tmcPhonemeArray[i2] = TmcPhonemeSerializer.getOptionalTmcPhoneme(iDeserializer);
            }
        }
        return tmcPhonemeArray;
    }
}

