/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterSupportedSkins;

public class UnitmasterSupportedSkinsSerializer {
    public static void putOptionalUnitmasterSupportedSkins(ISerializer iSerializer, UnitmasterSupportedSkins unitmasterSupportedSkins) {
        boolean bl = unitmasterSupportedSkins == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = unitmasterSupportedSkins.isSkin1();
            iSerializer.putBool(bl2);
            boolean bl3 = unitmasterSupportedSkins.isSkin2();
            iSerializer.putBool(bl3);
            boolean bl4 = unitmasterSupportedSkins.isSkin3();
            iSerializer.putBool(bl4);
        }
    }

    public static void putOptionalUnitmasterSupportedSkinsVarArray(ISerializer iSerializer, UnitmasterSupportedSkins[] unitmasterSupportedSkinsArray) {
        boolean bl = unitmasterSupportedSkinsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(unitmasterSupportedSkinsArray.length);
            for (int i2 = 0; i2 < unitmasterSupportedSkinsArray.length; ++i2) {
                UnitmasterSupportedSkinsSerializer.putOptionalUnitmasterSupportedSkins(iSerializer, unitmasterSupportedSkinsArray[i2]);
            }
        }
    }

    public static UnitmasterSupportedSkins getOptionalUnitmasterSupportedSkins(IDeserializer iDeserializer) {
        UnitmasterSupportedSkins unitmasterSupportedSkins = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            unitmasterSupportedSkins = new UnitmasterSupportedSkins();
            unitmasterSupportedSkins.skin1 = bl4 = iDeserializer.getBool();
            unitmasterSupportedSkins.skin2 = bl3 = iDeserializer.getBool();
            unitmasterSupportedSkins.skin3 = bl2 = iDeserializer.getBool();
        }
        return unitmasterSupportedSkins;
    }

    public static UnitmasterSupportedSkins[] getOptionalUnitmasterSupportedSkinsVarArray(IDeserializer iDeserializer) {
        UnitmasterSupportedSkins[] unitmasterSupportedSkinsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            unitmasterSupportedSkinsArray = new UnitmasterSupportedSkins[n];
            for (int i2 = 0; i2 < n; ++i2) {
                unitmasterSupportedSkinsArray[i2] = UnitmasterSupportedSkinsSerializer.getOptionalUnitmasterSupportedSkins(iDeserializer);
            }
        }
        return unitmasterSupportedSkinsArray;
    }
}

