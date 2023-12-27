/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.browser.Medium;

public class MediumSerializer {
    public static void putOptionalMedium(ISerializer iSerializer, Medium medium) {
        boolean bl = medium == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = medium.getId();
            iSerializer.putInt32(n);
            int n2 = medium.getMediumType();
            iSerializer.putInt32(n2);
            String string = medium.getName();
            iSerializer.putOptionalString(string);
            boolean bl2 = medium.isUpdateMedium();
            iSerializer.putBool(bl2);
            int n3 = medium.getMediumState();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalMediumVarArray(ISerializer iSerializer, Medium[] mediumArray) {
        boolean bl = mediumArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mediumArray.length);
            for (int i2 = 0; i2 < mediumArray.length; ++i2) {
                MediumSerializer.putOptionalMedium(iSerializer, mediumArray[i2]);
            }
        }
    }

    public static Medium getOptionalMedium(IDeserializer iDeserializer) {
        Medium medium = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            boolean bl2;
            String string;
            int n2;
            int n3;
            medium = new Medium();
            medium.id = n3 = iDeserializer.getInt32();
            medium.mediumType = n2 = iDeserializer.getInt32();
            medium.name = string = iDeserializer.getOptionalString();
            medium.updateMedium = bl2 = iDeserializer.getBool();
            medium.mediumState = n = iDeserializer.getInt32();
        }
        return medium;
    }

    public static Medium[] getOptionalMediumVarArray(IDeserializer iDeserializer) {
        Medium[] mediumArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mediumArray = new Medium[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mediumArray[i2] = MediumSerializer.getOptionalMedium(iDeserializer);
            }
        }
        return mediumArray;
    }
}

