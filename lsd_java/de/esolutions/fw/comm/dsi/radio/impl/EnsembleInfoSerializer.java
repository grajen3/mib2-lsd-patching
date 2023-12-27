/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.EnsembleInfo;

public class EnsembleInfoSerializer {
    public static void putOptionalEnsembleInfo(ISerializer iSerializer, EnsembleInfo ensembleInfo) {
        boolean bl = ensembleInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = ensembleInfo.getEnsID();
            iSerializer.putInt32(n);
            int n2 = ensembleInfo.getEnsECC();
            iSerializer.putInt32(n2);
            String string = ensembleInfo.getShortName();
            iSerializer.putOptionalString(string);
            String string2 = ensembleInfo.getFullName();
            iSerializer.putOptionalString(string2);
            String string3 = ensembleInfo.getFrequencyLabel();
            iSerializer.putOptionalString(string3);
            int n3 = ensembleInfo.getFrequencyValue();
            iSerializer.putInt32(n3);
            boolean bl2 = ensembleInfo.isTp();
            iSerializer.putBool(bl2);
            boolean bl3 = ensembleInfo.isPotentiallyReceivable();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalEnsembleInfoVarArray(ISerializer iSerializer, EnsembleInfo[] ensembleInfoArray) {
        boolean bl = ensembleInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(ensembleInfoArray.length);
            for (int i2 = 0; i2 < ensembleInfoArray.length; ++i2) {
                EnsembleInfoSerializer.putOptionalEnsembleInfo(iSerializer, ensembleInfoArray[i2]);
            }
        }
    }

    public static EnsembleInfo getOptionalEnsembleInfo(IDeserializer iDeserializer) {
        EnsembleInfo ensembleInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            int n;
            String string;
            String string2;
            String string3;
            int n2;
            int n3;
            ensembleInfo = new EnsembleInfo();
            ensembleInfo.ensID = n3 = iDeserializer.getInt32();
            ensembleInfo.ensECC = n2 = iDeserializer.getInt32();
            ensembleInfo.shortName = string3 = iDeserializer.getOptionalString();
            ensembleInfo.fullName = string2 = iDeserializer.getOptionalString();
            ensembleInfo.frequencyLabel = string = iDeserializer.getOptionalString();
            ensembleInfo.frequencyValue = n = iDeserializer.getInt32();
            ensembleInfo.tp = bl3 = iDeserializer.getBool();
            ensembleInfo.potentiallyReceivable = bl2 = iDeserializer.getBool();
        }
        return ensembleInfo;
    }

    public static EnsembleInfo[] getOptionalEnsembleInfoVarArray(IDeserializer iDeserializer) {
        EnsembleInfo[] ensembleInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            ensembleInfoArray = new EnsembleInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                ensembleInfoArray[i2] = EnsembleInfoSerializer.getOptionalEnsembleInfo(iDeserializer);
            }
        }
        return ensembleInfoArray;
    }
}

