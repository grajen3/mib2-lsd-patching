/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.sdars.RadioText;

public class RadioTextSerializer {
    public static void putOptionalRadioText(ISerializer iSerializer, RadioText radioText) {
        boolean bl = radioText == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = radioText.getSID();
            iSerializer.putInt16(s);
            String string = radioText.getShortArtistName();
            iSerializer.putOptionalString(string);
            String string2 = radioText.getLongArtistName();
            iSerializer.putOptionalString(string2);
            String string3 = radioText.getArtistID();
            iSerializer.putOptionalString(string3);
            String string4 = radioText.getShortProgramTitle();
            iSerializer.putOptionalString(string4);
            String string5 = radioText.getLongProgramTitle();
            iSerializer.putOptionalString(string5);
            String string6 = radioText.getProgramID();
            iSerializer.putOptionalString(string6);
            String string7 = radioText.getComposer();
            iSerializer.putOptionalString(string7);
            int n = radioText.getITunesID();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalRadioTextVarArray(ISerializer iSerializer, RadioText[] radioTextArray) {
        boolean bl = radioTextArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(radioTextArray.length);
            for (int i2 = 0; i2 < radioTextArray.length; ++i2) {
                RadioTextSerializer.putOptionalRadioText(iSerializer, radioTextArray[i2]);
            }
        }
    }

    public static RadioText getOptionalRadioText(IDeserializer iDeserializer) {
        RadioText radioText = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            short s;
            radioText = new RadioText();
            radioText.sID = s = iDeserializer.getInt16();
            radioText.shortArtistName = string7 = iDeserializer.getOptionalString();
            radioText.longArtistName = string6 = iDeserializer.getOptionalString();
            radioText.artistID = string5 = iDeserializer.getOptionalString();
            radioText.shortProgramTitle = string4 = iDeserializer.getOptionalString();
            radioText.longProgramTitle = string3 = iDeserializer.getOptionalString();
            radioText.programID = string2 = iDeserializer.getOptionalString();
            radioText.composer = string = iDeserializer.getOptionalString();
            radioText.iTunesID = n = iDeserializer.getInt32();
        }
        return radioText;
    }

    public static RadioText[] getOptionalRadioTextVarArray(IDeserializer iDeserializer) {
        RadioText[] radioTextArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            radioTextArray = new RadioText[n];
            for (int i2 = 0; i2 < n; ++i2) {
                radioTextArray[i2] = RadioTextSerializer.getOptionalRadioText(iDeserializer);
            }
        }
        return radioTextArray;
    }
}

