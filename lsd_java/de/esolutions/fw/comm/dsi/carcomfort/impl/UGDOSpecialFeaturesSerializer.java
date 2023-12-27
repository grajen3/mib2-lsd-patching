/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOSpecialFeatures;

public class UGDOSpecialFeaturesSerializer {
    public static void putOptionalUGDOSpecialFeatures(ISerializer iSerializer, UGDOSpecialFeatures uGDOSpecialFeatures) {
        boolean bl = uGDOSpecialFeatures == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = uGDOSpecialFeatures.isDoorName();
            iSerializer.putBool(bl2);
            boolean bl3 = uGDOSpecialFeatures.isGpsSupervision();
            iSerializer.putBool(bl3);
            boolean bl4 = uGDOSpecialFeatures.isKeyFob();
            iSerializer.putBool(bl4);
            boolean bl5 = uGDOSpecialFeatures.isBiDirectionalCommunication();
            iSerializer.putBool(bl5);
            boolean bl6 = uGDOSpecialFeatures.isFixkitMode();
            iSerializer.putBool(bl6);
            boolean bl7 = uGDOSpecialFeatures.isDefaultMode();
            iSerializer.putBool(bl7);
        }
    }

    public static void putOptionalUGDOSpecialFeaturesVarArray(ISerializer iSerializer, UGDOSpecialFeatures[] uGDOSpecialFeaturesArray) {
        boolean bl = uGDOSpecialFeaturesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uGDOSpecialFeaturesArray.length);
            for (int i2 = 0; i2 < uGDOSpecialFeaturesArray.length; ++i2) {
                UGDOSpecialFeaturesSerializer.putOptionalUGDOSpecialFeatures(iSerializer, uGDOSpecialFeaturesArray[i2]);
            }
        }
    }

    public static UGDOSpecialFeatures getOptionalUGDOSpecialFeatures(IDeserializer iDeserializer) {
        UGDOSpecialFeatures uGDOSpecialFeatures = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            uGDOSpecialFeatures = new UGDOSpecialFeatures();
            uGDOSpecialFeatures.doorName = bl7 = iDeserializer.getBool();
            uGDOSpecialFeatures.gpsSupervision = bl6 = iDeserializer.getBool();
            uGDOSpecialFeatures.keyFob = bl5 = iDeserializer.getBool();
            uGDOSpecialFeatures.biDirectionalCommunication = bl4 = iDeserializer.getBool();
            uGDOSpecialFeatures.fixkitMode = bl3 = iDeserializer.getBool();
            uGDOSpecialFeatures.defaultMode = bl2 = iDeserializer.getBool();
        }
        return uGDOSpecialFeatures;
    }

    public static UGDOSpecialFeatures[] getOptionalUGDOSpecialFeaturesVarArray(IDeserializer iDeserializer) {
        UGDOSpecialFeatures[] uGDOSpecialFeaturesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uGDOSpecialFeaturesArray = new UGDOSpecialFeatures[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uGDOSpecialFeaturesArray[i2] = UGDOSpecialFeaturesSerializer.getOptionalUGDOSpecialFeatures(iDeserializer);
            }
        }
        return uGDOSpecialFeaturesArray;
    }
}

