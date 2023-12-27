/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.HUDConfiguration;

public class HUDConfigurationSerializer {
    public static void putOptionalHUDConfiguration(ISerializer iSerializer, HUDConfiguration hUDConfiguration) {
        boolean bl = hUDConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = hUDConfiguration.isSpeed();
            iSerializer.putBool(bl2);
            boolean bl3 = hUDConfiguration.isWarning();
            iSerializer.putBool(bl3);
            boolean bl4 = hUDConfiguration.isGra();
            iSerializer.putBool(bl4);
            boolean bl5 = hUDConfiguration.isNightvision();
            iSerializer.putBool(bl5);
            boolean bl6 = hUDConfiguration.isRoadsign();
            iSerializer.putBool(bl6);
            boolean bl7 = hUDConfiguration.isRgi();
            iSerializer.putBool(bl7);
            boolean bl8 = hUDConfiguration.isNavInfo();
            iSerializer.putBool(bl8);
            boolean bl9 = hUDConfiguration.isInfoList();
            iSerializer.putBool(bl9);
            boolean bl10 = hUDConfiguration.isHca();
            iSerializer.putBool(bl10);
            boolean bl11 = hUDConfiguration.isAcc();
            iSerializer.putBool(bl11);
            boolean bl12 = hUDConfiguration.isTelephone();
            iSerializer.putBool(bl12);
            boolean bl13 = hUDConfiguration.isEfficiencyAssist();
            iSerializer.putBool(bl13);
            boolean bl14 = hUDConfiguration.isSpeedLimiter();
            iSerializer.putBool(bl14);
            boolean bl15 = hUDConfiguration.isColourDesignAuto();
            iSerializer.putBool(bl15);
            boolean bl16 = hUDConfiguration.isColourDesignDay();
            iSerializer.putBool(bl16);
            boolean bl17 = hUDConfiguration.isColourDesignNight();
            iSerializer.putBool(bl17);
            boolean bl18 = hUDConfiguration.isColourDefault();
            iSerializer.putBool(bl18);
            boolean bl19 = hUDConfiguration.isColourAlternative();
            iSerializer.putBool(bl19);
        }
    }

    public static void putOptionalHUDConfigurationVarArray(ISerializer iSerializer, HUDConfiguration[] hUDConfigurationArray) {
        boolean bl = hUDConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hUDConfigurationArray.length);
            for (int i2 = 0; i2 < hUDConfigurationArray.length; ++i2) {
                HUDConfigurationSerializer.putOptionalHUDConfiguration(iSerializer, hUDConfigurationArray[i2]);
            }
        }
    }

    public static HUDConfiguration getOptionalHUDConfiguration(IDeserializer iDeserializer) {
        HUDConfiguration hUDConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            boolean bl10;
            boolean bl11;
            boolean bl12;
            boolean bl13;
            boolean bl14;
            boolean bl15;
            boolean bl16;
            boolean bl17;
            boolean bl18;
            boolean bl19;
            hUDConfiguration = new HUDConfiguration();
            hUDConfiguration.speed = bl19 = iDeserializer.getBool();
            hUDConfiguration.warning = bl18 = iDeserializer.getBool();
            hUDConfiguration.gra = bl17 = iDeserializer.getBool();
            hUDConfiguration.nightvision = bl16 = iDeserializer.getBool();
            hUDConfiguration.roadsign = bl15 = iDeserializer.getBool();
            hUDConfiguration.rgi = bl14 = iDeserializer.getBool();
            hUDConfiguration.navInfo = bl13 = iDeserializer.getBool();
            hUDConfiguration.infoList = bl12 = iDeserializer.getBool();
            hUDConfiguration.hca = bl11 = iDeserializer.getBool();
            hUDConfiguration.acc = bl10 = iDeserializer.getBool();
            hUDConfiguration.telephone = bl9 = iDeserializer.getBool();
            hUDConfiguration.efficiencyAssist = bl8 = iDeserializer.getBool();
            hUDConfiguration.speedLimiter = bl7 = iDeserializer.getBool();
            hUDConfiguration.colourDesignAuto = bl6 = iDeserializer.getBool();
            hUDConfiguration.colourDesignDay = bl5 = iDeserializer.getBool();
            hUDConfiguration.colourDesignNight = bl4 = iDeserializer.getBool();
            hUDConfiguration.colourDefault = bl3 = iDeserializer.getBool();
            hUDConfiguration.colourAlternative = bl2 = iDeserializer.getBool();
        }
        return hUDConfiguration;
    }

    public static HUDConfiguration[] getOptionalHUDConfigurationVarArray(IDeserializer iDeserializer) {
        HUDConfiguration[] hUDConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hUDConfigurationArray = new HUDConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hUDConfigurationArray[i2] = HUDConfigurationSerializer.getOptionalHUDConfiguration(iDeserializer);
            }
        }
        return hUDConfigurationArray;
    }
}

