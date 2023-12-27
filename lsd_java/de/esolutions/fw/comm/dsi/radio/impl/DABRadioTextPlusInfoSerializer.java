/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.DABRadioTextPlusInfo;

public class DABRadioTextPlusInfoSerializer {
    public static void putOptionalDABRadioTextPlusInfo(ISerializer iSerializer, DABRadioTextPlusInfo dABRadioTextPlusInfo) {
        boolean bl = dABRadioTextPlusInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = dABRadioTextPlusInfo.getEnsID();
            iSerializer.putInt32(n);
            int n2 = dABRadioTextPlusInfo.getEnsECC();
            iSerializer.putInt32(n2);
            int n3 = dABRadioTextPlusInfo.getSID();
            iSerializer.putInt32(n3);
            int n4 = dABRadioTextPlusInfo.getSCIDI();
            iSerializer.putInt32(n4);
            int[] nArray = dABRadioTextPlusInfo.getTags();
            iSerializer.putOptionalInt32VarArray(nArray);
            String[] stringArray = dABRadioTextPlusInfo.getContent();
            iSerializer.putOptionalStringVarArray(stringArray);
        }
    }

    public static void putOptionalDABRadioTextPlusInfoVarArray(ISerializer iSerializer, DABRadioTextPlusInfo[] dABRadioTextPlusInfoArray) {
        boolean bl = dABRadioTextPlusInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dABRadioTextPlusInfoArray.length);
            for (int i2 = 0; i2 < dABRadioTextPlusInfoArray.length; ++i2) {
                DABRadioTextPlusInfoSerializer.putOptionalDABRadioTextPlusInfo(iSerializer, dABRadioTextPlusInfoArray[i2]);
            }
        }
    }

    public static DABRadioTextPlusInfo getOptionalDABRadioTextPlusInfo(IDeserializer iDeserializer) {
        DABRadioTextPlusInfo dABRadioTextPlusInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            dABRadioTextPlusInfo = new DABRadioTextPlusInfo();
            dABRadioTextPlusInfo.ensID = n4 = iDeserializer.getInt32();
            dABRadioTextPlusInfo.ensECC = n3 = iDeserializer.getInt32();
            dABRadioTextPlusInfo.sID = n2 = iDeserializer.getInt32();
            dABRadioTextPlusInfo.sCIDI = n = iDeserializer.getInt32();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            dABRadioTextPlusInfo.tags = nArray;
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            dABRadioTextPlusInfo.content = stringArray;
        }
        return dABRadioTextPlusInfo;
    }

    public static DABRadioTextPlusInfo[] getOptionalDABRadioTextPlusInfoVarArray(IDeserializer iDeserializer) {
        DABRadioTextPlusInfo[] dABRadioTextPlusInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dABRadioTextPlusInfoArray = new DABRadioTextPlusInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dABRadioTextPlusInfoArray[i2] = DABRadioTextPlusInfoSerializer.getOptionalDABRadioTextPlusInfo(iDeserializer);
            }
        }
        return dABRadioTextPlusInfoArray;
    }
}

