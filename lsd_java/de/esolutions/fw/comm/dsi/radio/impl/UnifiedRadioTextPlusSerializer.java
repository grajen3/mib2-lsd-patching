/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.UnifiedRadioTextPlus;

public class UnifiedRadioTextPlusSerializer {
    public static void putOptionalUnifiedRadioTextPlus(ISerializer iSerializer, UnifiedRadioTextPlus unifiedRadioTextPlus) {
        boolean bl = unifiedRadioTextPlus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = unifiedRadioTextPlus.getPiSId();
            iSerializer.putInt32(n);
            int n2 = unifiedRadioTextPlus.getEnsId();
            iSerializer.putInt32(n2);
            int n3 = unifiedRadioTextPlus.getEcc();
            iSerializer.putInt32(n3);
            int n4 = unifiedRadioTextPlus.getSCIDI();
            iSerializer.putInt32(n4);
            int[] nArray = unifiedRadioTextPlus.getTags();
            iSerializer.putOptionalInt32VarArray(nArray);
            String[] stringArray = unifiedRadioTextPlus.getContent();
            iSerializer.putOptionalStringVarArray(stringArray);
            int n5 = unifiedRadioTextPlus.getSource();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalUnifiedRadioTextPlusVarArray(ISerializer iSerializer, UnifiedRadioTextPlus[] unifiedRadioTextPlusArray) {
        boolean bl = unifiedRadioTextPlusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(unifiedRadioTextPlusArray.length);
            for (int i2 = 0; i2 < unifiedRadioTextPlusArray.length; ++i2) {
                UnifiedRadioTextPlusSerializer.putOptionalUnifiedRadioTextPlus(iSerializer, unifiedRadioTextPlusArray[i2]);
            }
        }
    }

    public static UnifiedRadioTextPlus getOptionalUnifiedRadioTextPlus(IDeserializer iDeserializer) {
        UnifiedRadioTextPlus unifiedRadioTextPlus = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            unifiedRadioTextPlus = new UnifiedRadioTextPlus();
            unifiedRadioTextPlus.piSId = n5 = iDeserializer.getInt32();
            unifiedRadioTextPlus.ensId = n4 = iDeserializer.getInt32();
            unifiedRadioTextPlus.ecc = n3 = iDeserializer.getInt32();
            unifiedRadioTextPlus.sCIDI = n2 = iDeserializer.getInt32();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            unifiedRadioTextPlus.tags = nArray;
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            unifiedRadioTextPlus.content = stringArray;
            unifiedRadioTextPlus.source = n = iDeserializer.getInt32();
        }
        return unifiedRadioTextPlus;
    }

    public static UnifiedRadioTextPlus[] getOptionalUnifiedRadioTextPlusVarArray(IDeserializer iDeserializer) {
        UnifiedRadioTextPlus[] unifiedRadioTextPlusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            unifiedRadioTextPlusArray = new UnifiedRadioTextPlus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                unifiedRadioTextPlusArray[i2] = UnifiedRadioTextPlusSerializer.getOptionalUnifiedRadioTextPlus(iDeserializer);
            }
        }
        return unifiedRadioTextPlusArray;
    }
}

