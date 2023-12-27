/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCSound;

public class PDCSoundSerializer {
    public static void putOptionalPDCSound(ISerializer iSerializer, PDCSound pDCSound) {
        boolean bl = pDCSound == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = pDCSound.getVolume();
            iSerializer.putInt32(n);
            int n2 = pDCSound.getFrequency();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalPDCSoundVarArray(ISerializer iSerializer, PDCSound[] pDCSoundArray) {
        boolean bl = pDCSoundArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCSoundArray.length);
            for (int i2 = 0; i2 < pDCSoundArray.length; ++i2) {
                PDCSoundSerializer.putOptionalPDCSound(iSerializer, pDCSoundArray[i2]);
            }
        }
    }

    public static PDCSound getOptionalPDCSound(IDeserializer iDeserializer) {
        PDCSound pDCSound = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            pDCSound = new PDCSound();
            pDCSound.volume = n2 = iDeserializer.getInt32();
            pDCSound.frequency = n = iDeserializer.getInt32();
        }
        return pDCSound;
    }

    public static PDCSound[] getOptionalPDCSoundVarArray(IDeserializer iDeserializer) {
        PDCSound[] pDCSoundArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCSoundArray = new PDCSound[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCSoundArray[i2] = PDCSoundSerializer.getOptionalPDCSound(iDeserializer);
            }
        }
        return pDCSoundArray;
    }
}

