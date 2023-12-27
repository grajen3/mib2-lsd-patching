/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCDisplayedAdditionalInfos;

public class DCDisplayedAdditionalInfosSerializer {
    public static void putOptionalDCDisplayedAdditionalInfos(ISerializer iSerializer, DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos) {
        boolean bl = dCDisplayedAdditionalInfos == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = dCDisplayedAdditionalInfos.isAdditionalInfo1();
            iSerializer.putBool(bl2);
            boolean bl3 = dCDisplayedAdditionalInfos.isAdditionalInfo2();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalDCDisplayedAdditionalInfosVarArray(ISerializer iSerializer, DCDisplayedAdditionalInfos[] dCDisplayedAdditionalInfosArray) {
        boolean bl = dCDisplayedAdditionalInfosArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dCDisplayedAdditionalInfosArray.length);
            for (int i2 = 0; i2 < dCDisplayedAdditionalInfosArray.length; ++i2) {
                DCDisplayedAdditionalInfosSerializer.putOptionalDCDisplayedAdditionalInfos(iSerializer, dCDisplayedAdditionalInfosArray[i2]);
            }
        }
    }

    public static DCDisplayedAdditionalInfos getOptionalDCDisplayedAdditionalInfos(IDeserializer iDeserializer) {
        DCDisplayedAdditionalInfos dCDisplayedAdditionalInfos = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            dCDisplayedAdditionalInfos = new DCDisplayedAdditionalInfos();
            dCDisplayedAdditionalInfos.additionalInfo1 = bl3 = iDeserializer.getBool();
            dCDisplayedAdditionalInfos.additionalInfo2 = bl2 = iDeserializer.getBool();
        }
        return dCDisplayedAdditionalInfos;
    }

    public static DCDisplayedAdditionalInfos[] getOptionalDCDisplayedAdditionalInfosVarArray(IDeserializer iDeserializer) {
        DCDisplayedAdditionalInfos[] dCDisplayedAdditionalInfosArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dCDisplayedAdditionalInfosArray = new DCDisplayedAdditionalInfos[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dCDisplayedAdditionalInfosArray[i2] = DCDisplayedAdditionalInfosSerializer.getOptionalDCDisplayedAdditionalInfos(iDeserializer);
            }
        }
        return dCDisplayedAdditionalInfosArray;
    }
}

