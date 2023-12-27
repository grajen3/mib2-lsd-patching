/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.ParentalSettings;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class ParentalSettingsSerializer {
    public static void putOptionalParentalSettings(ISerializer iSerializer, ParentalSettings parentalSettings) {
        boolean bl = parentalSettings == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = parentalSettings.isIsParentalManagementRequired();
            iSerializer.putBool(bl2);
            int n = parentalSettings.getParentalLevel();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalParentalSettingsVarArray(ISerializer iSerializer, ParentalSettings[] parentalSettingsArray) {
        boolean bl = parentalSettingsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(parentalSettingsArray.length);
            for (int i2 = 0; i2 < parentalSettingsArray.length; ++i2) {
                ParentalSettingsSerializer.putOptionalParentalSettings(iSerializer, parentalSettingsArray[i2]);
            }
        }
    }

    public static ParentalSettings getOptionalParentalSettings(IDeserializer iDeserializer) {
        ParentalSettings parentalSettings = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            boolean bl2;
            parentalSettings = new ParentalSettings();
            parentalSettings.isParentalManagementRequired = bl2 = iDeserializer.getBool();
            parentalSettings.parentalLevel = n = iDeserializer.getInt32();
        }
        return parentalSettings;
    }

    public static ParentalSettings[] getOptionalParentalSettingsVarArray(IDeserializer iDeserializer) {
        ParentalSettings[] parentalSettingsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            parentalSettingsArray = new ParentalSettings[n];
            for (int i2 = 0; i2 < n; ++i2) {
                parentalSettingsArray[i2] = ParentalSettingsSerializer.getOptionalParentalSettings(iDeserializer);
            }
        }
        return parentalSettingsArray;
    }
}

