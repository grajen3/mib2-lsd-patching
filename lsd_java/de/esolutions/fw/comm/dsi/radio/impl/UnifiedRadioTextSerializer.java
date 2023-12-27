/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.UnifiedRadioText;

public class UnifiedRadioTextSerializer {
    public static void putOptionalUnifiedRadioText(ISerializer iSerializer, UnifiedRadioText unifiedRadioText) {
        boolean bl = unifiedRadioText == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = unifiedRadioText.getPiSId();
            iSerializer.putInt32(n);
            int n2 = unifiedRadioText.getEnsId();
            iSerializer.putInt32(n2);
            int n3 = unifiedRadioText.getEcc();
            iSerializer.putInt32(n3);
            int n4 = unifiedRadioText.getSCIDI();
            iSerializer.putInt32(n4);
            String string = unifiedRadioText.getRadioText();
            iSerializer.putOptionalString(string);
            int n5 = unifiedRadioText.getSource();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalUnifiedRadioTextVarArray(ISerializer iSerializer, UnifiedRadioText[] unifiedRadioTextArray) {
        boolean bl = unifiedRadioTextArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(unifiedRadioTextArray.length);
            for (int i2 = 0; i2 < unifiedRadioTextArray.length; ++i2) {
                UnifiedRadioTextSerializer.putOptionalUnifiedRadioText(iSerializer, unifiedRadioTextArray[i2]);
            }
        }
    }

    public static UnifiedRadioText getOptionalUnifiedRadioText(IDeserializer iDeserializer) {
        UnifiedRadioText unifiedRadioText = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            int n2;
            int n3;
            int n4;
            int n5;
            unifiedRadioText = new UnifiedRadioText();
            unifiedRadioText.piSId = n5 = iDeserializer.getInt32();
            unifiedRadioText.ensId = n4 = iDeserializer.getInt32();
            unifiedRadioText.ecc = n3 = iDeserializer.getInt32();
            unifiedRadioText.sCIDI = n2 = iDeserializer.getInt32();
            unifiedRadioText.radioText = string = iDeserializer.getOptionalString();
            unifiedRadioText.source = n = iDeserializer.getInt32();
        }
        return unifiedRadioText;
    }

    public static UnifiedRadioText[] getOptionalUnifiedRadioTextVarArray(IDeserializer iDeserializer) {
        UnifiedRadioText[] unifiedRadioTextArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            unifiedRadioTextArray = new UnifiedRadioText[n];
            for (int i2 = 0; i2 < n; ++i2) {
                unifiedRadioTextArray[i2] = UnifiedRadioTextSerializer.getOptionalUnifiedRadioText(iDeserializer);
            }
        }
        return unifiedRadioTextArray;
    }
}

