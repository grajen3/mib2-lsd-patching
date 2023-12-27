/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.AMFMRadioText;

public class AMFMRadioTextSerializer {
    public static void putOptionalAMFMRadioText(ISerializer iSerializer, AMFMRadioText aMFMRadioText) {
        boolean bl = aMFMRadioText == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = aMFMRadioText.getPi();
            iSerializer.putInt32(n);
            String string = aMFMRadioText.getText();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalAMFMRadioTextVarArray(ISerializer iSerializer, AMFMRadioText[] aMFMRadioTextArray) {
        boolean bl = aMFMRadioTextArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(aMFMRadioTextArray.length);
            for (int i2 = 0; i2 < aMFMRadioTextArray.length; ++i2) {
                AMFMRadioTextSerializer.putOptionalAMFMRadioText(iSerializer, aMFMRadioTextArray[i2]);
            }
        }
    }

    public static AMFMRadioText getOptionalAMFMRadioText(IDeserializer iDeserializer) {
        AMFMRadioText aMFMRadioText = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            aMFMRadioText = new AMFMRadioText();
            aMFMRadioText.pi = n = iDeserializer.getInt32();
            aMFMRadioText.text = string = iDeserializer.getOptionalString();
        }
        return aMFMRadioText;
    }

    public static AMFMRadioText[] getOptionalAMFMRadioTextVarArray(IDeserializer iDeserializer) {
        AMFMRadioText[] aMFMRadioTextArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            aMFMRadioTextArray = new AMFMRadioText[n];
            for (int i2 = 0; i2 < n; ++i2) {
                aMFMRadioTextArray[i2] = AMFMRadioTextSerializer.getOptionalAMFMRadioText(iDeserializer);
            }
        }
        return aMFMRadioTextArray;
    }
}

