/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCSoundReproduction;

public class PDCSoundReproductionSerializer {
    public static void putOptionalPDCSoundReproduction(ISerializer iSerializer, PDCSoundReproduction pDCSoundReproduction) {
        boolean bl = pDCSoundReproduction == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = pDCSoundReproduction.isFront();
            iSerializer.putBool(bl2);
            boolean bl3 = pDCSoundReproduction.isRear();
            iSerializer.putBool(bl3);
            boolean bl4 = pDCSoundReproduction.isRight();
            iSerializer.putBool(bl4);
            boolean bl5 = pDCSoundReproduction.isLeft();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalPDCSoundReproductionVarArray(ISerializer iSerializer, PDCSoundReproduction[] pDCSoundReproductionArray) {
        boolean bl = pDCSoundReproductionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCSoundReproductionArray.length);
            for (int i2 = 0; i2 < pDCSoundReproductionArray.length; ++i2) {
                PDCSoundReproductionSerializer.putOptionalPDCSoundReproduction(iSerializer, pDCSoundReproductionArray[i2]);
            }
        }
    }

    public static PDCSoundReproduction getOptionalPDCSoundReproduction(IDeserializer iDeserializer) {
        PDCSoundReproduction pDCSoundReproduction = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            pDCSoundReproduction = new PDCSoundReproduction();
            pDCSoundReproduction.front = bl5 = iDeserializer.getBool();
            pDCSoundReproduction.rear = bl4 = iDeserializer.getBool();
            pDCSoundReproduction.right = bl3 = iDeserializer.getBool();
            pDCSoundReproduction.left = bl2 = iDeserializer.getBool();
        }
        return pDCSoundReproduction;
    }

    public static PDCSoundReproduction[] getOptionalPDCSoundReproductionVarArray(IDeserializer iDeserializer) {
        PDCSoundReproduction[] pDCSoundReproductionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCSoundReproductionArray = new PDCSoundReproduction[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCSoundReproductionArray[i2] = PDCSoundReproductionSerializer.getOptionalPDCSoundReproduction(iDeserializer);
            }
        }
        return pDCSoundReproductionArray;
    }
}

