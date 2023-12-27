/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.DABRadioText;

public class DABRadioTextSerializer {
    public static void putOptionalDABRadioText(ISerializer iSerializer, DABRadioText dABRadioText) {
        boolean bl = dABRadioText == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = dABRadioText.getEnsID();
            iSerializer.putInt32(n);
            int n2 = dABRadioText.getEnsECC();
            iSerializer.putInt32(n2);
            int n3 = dABRadioText.getSID();
            iSerializer.putInt32(n3);
            int n4 = dABRadioText.getSCIDI();
            iSerializer.putInt32(n4);
            String string = dABRadioText.getText();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalDABRadioTextVarArray(ISerializer iSerializer, DABRadioText[] dABRadioTextArray) {
        boolean bl = dABRadioTextArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dABRadioTextArray.length);
            for (int i2 = 0; i2 < dABRadioTextArray.length; ++i2) {
                DABRadioTextSerializer.putOptionalDABRadioText(iSerializer, dABRadioTextArray[i2]);
            }
        }
    }

    public static DABRadioText getOptionalDABRadioText(IDeserializer iDeserializer) {
        DABRadioText dABRadioText = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            int n2;
            int n3;
            int n4;
            dABRadioText = new DABRadioText();
            dABRadioText.ensID = n4 = iDeserializer.getInt32();
            dABRadioText.ensECC = n3 = iDeserializer.getInt32();
            dABRadioText.sID = n2 = iDeserializer.getInt32();
            dABRadioText.sCIDI = n = iDeserializer.getInt32();
            dABRadioText.text = string = iDeserializer.getOptionalString();
        }
        return dABRadioText;
    }

    public static DABRadioText[] getOptionalDABRadioTextVarArray(IDeserializer iDeserializer) {
        DABRadioText[] dABRadioTextArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dABRadioTextArray = new DABRadioText[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dABRadioTextArray[i2] = DABRadioTextSerializer.getOptionalDABRadioText(iDeserializer);
            }
        }
        return dABRadioTextArray;
    }
}

