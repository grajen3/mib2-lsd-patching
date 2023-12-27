/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.HUDContent;

public class HUDContentSerializer {
    public static void putOptionalHUDContent(ISerializer iSerializer, HUDContent hUDContent) {
        boolean bl = hUDContent == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = hUDContent.isSpeed();
            iSerializer.putBool(bl2);
            boolean bl3 = hUDContent.isWarning();
            iSerializer.putBool(bl3);
            boolean bl4 = hUDContent.isGra();
            iSerializer.putBool(bl4);
            boolean bl5 = hUDContent.isNightvision();
            iSerializer.putBool(bl5);
            boolean bl6 = hUDContent.isRoadsign();
            iSerializer.putBool(bl6);
            boolean bl7 = hUDContent.isRgi();
            iSerializer.putBool(bl7);
            boolean bl8 = hUDContent.isNavInfo();
            iSerializer.putBool(bl8);
            boolean bl9 = hUDContent.isInfoList();
            iSerializer.putBool(bl9);
            boolean bl10 = hUDContent.isHca();
            iSerializer.putBool(bl10);
            boolean bl11 = hUDContent.isAcc();
            iSerializer.putBool(bl11);
            boolean bl12 = hUDContent.isTelephone();
            iSerializer.putBool(bl12);
            boolean bl13 = hUDContent.isEfficiencyAssist();
            iSerializer.putBool(bl13);
            boolean bl14 = hUDContent.isSpeedLimiter();
            iSerializer.putBool(bl14);
        }
    }

    public static void putOptionalHUDContentVarArray(ISerializer iSerializer, HUDContent[] hUDContentArray) {
        boolean bl = hUDContentArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hUDContentArray.length);
            for (int i2 = 0; i2 < hUDContentArray.length; ++i2) {
                HUDContentSerializer.putOptionalHUDContent(iSerializer, hUDContentArray[i2]);
            }
        }
    }

    public static HUDContent getOptionalHUDContent(IDeserializer iDeserializer) {
        HUDContent hUDContent = null;
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
            hUDContent = new HUDContent();
            hUDContent.speed = bl14 = iDeserializer.getBool();
            hUDContent.warning = bl13 = iDeserializer.getBool();
            hUDContent.gra = bl12 = iDeserializer.getBool();
            hUDContent.nightvision = bl11 = iDeserializer.getBool();
            hUDContent.roadsign = bl10 = iDeserializer.getBool();
            hUDContent.rgi = bl9 = iDeserializer.getBool();
            hUDContent.navInfo = bl8 = iDeserializer.getBool();
            hUDContent.infoList = bl7 = iDeserializer.getBool();
            hUDContent.hca = bl6 = iDeserializer.getBool();
            hUDContent.acc = bl5 = iDeserializer.getBool();
            hUDContent.telephone = bl4 = iDeserializer.getBool();
            hUDContent.efficiencyAssist = bl3 = iDeserializer.getBool();
            hUDContent.speedLimiter = bl2 = iDeserializer.getBool();
        }
        return hUDContent;
    }

    public static HUDContent[] getOptionalHUDContentVarArray(IDeserializer iDeserializer) {
        HUDContent[] hUDContentArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hUDContentArray = new HUDContent[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hUDContentArray[i2] = HUDContentSerializer.getOptionalHUDContent(iDeserializer);
            }
        }
        return hUDContentArray;
    }
}

