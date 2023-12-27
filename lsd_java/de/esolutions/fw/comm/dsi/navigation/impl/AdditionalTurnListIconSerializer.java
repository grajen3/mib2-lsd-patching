/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.AdditionalTurnListIcon;

public class AdditionalTurnListIconSerializer {
    public static void putOptionalAdditionalTurnListIcon(ISerializer iSerializer, AdditionalTurnListIcon additionalTurnListIcon) {
        boolean bl = additionalTurnListIcon == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = additionalTurnListIcon.getType();
            iSerializer.putInt32(n);
            int n2 = additionalTurnListIcon.getIconId();
            iSerializer.putInt32(n2);
            int n3 = additionalTurnListIcon.getVariant();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalAdditionalTurnListIconVarArray(ISerializer iSerializer, AdditionalTurnListIcon[] additionalTurnListIconArray) {
        boolean bl = additionalTurnListIconArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(additionalTurnListIconArray.length);
            for (int i2 = 0; i2 < additionalTurnListIconArray.length; ++i2) {
                AdditionalTurnListIconSerializer.putOptionalAdditionalTurnListIcon(iSerializer, additionalTurnListIconArray[i2]);
            }
        }
    }

    public static AdditionalTurnListIcon getOptionalAdditionalTurnListIcon(IDeserializer iDeserializer) {
        AdditionalTurnListIcon additionalTurnListIcon = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            additionalTurnListIcon = new AdditionalTurnListIcon();
            additionalTurnListIcon.type = n3 = iDeserializer.getInt32();
            additionalTurnListIcon.iconId = n2 = iDeserializer.getInt32();
            additionalTurnListIcon.variant = n = iDeserializer.getInt32();
        }
        return additionalTurnListIcon;
    }

    public static AdditionalTurnListIcon[] getOptionalAdditionalTurnListIconVarArray(IDeserializer iDeserializer) {
        AdditionalTurnListIcon[] additionalTurnListIconArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            additionalTurnListIconArray = new AdditionalTurnListIcon[n];
            for (int i2 = 0; i2 < n; ++i2) {
                additionalTurnListIconArray[i2] = AdditionalTurnListIconSerializer.getOptionalAdditionalTurnListIcon(iDeserializer);
            }
        }
        return additionalTurnListIconArray;
    }
}

