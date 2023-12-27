/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.VisualizationConfig;

public class VisualizationConfigSerializer {
    public static void putOptionalVisualizationConfig(ISerializer iSerializer, VisualizationConfig visualizationConfig) {
        boolean bl = visualizationConfig == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = visualizationConfig.isSitzlaengsverstellung();
            iSerializer.putBool(bl2);
            boolean bl3 = visualizationConfig.isSitzhoehenverstellung();
            iSerializer.putBool(bl3);
            boolean bl4 = visualizationConfig.isSitzneigungsverstellung();
            iSerializer.putBool(bl4);
            boolean bl5 = visualizationConfig.isLehnenneigungsverstellung();
            iSerializer.putBool(bl5);
            boolean bl6 = visualizationConfig.isKopfstuetzenhoehenverstellung();
            iSerializer.putBool(bl6);
            boolean bl7 = visualizationConfig.isLordosenweitenverstellung();
            iSerializer.putBool(bl7);
            boolean bl8 = visualizationConfig.isLordosenhoehenverstellung();
            iSerializer.putBool(bl8);
            boolean bl9 = visualizationConfig.isSitztiefenverstellung();
            iSerializer.putBool(bl9);
            boolean bl10 = visualizationConfig.isLehnenkopfverstellung();
            iSerializer.putBool(bl10);
            boolean bl11 = visualizationConfig.isGurthoehenverstellung();
            iSerializer.putBool(bl11);
            boolean bl12 = visualizationConfig.isLehnenwangenverstellung();
            iSerializer.putBool(bl12);
            boolean bl13 = visualizationConfig.isSitzflaechenwangenverstellung();
            iSerializer.putBool(bl13);
            boolean bl14 = visualizationConfig.isKopfstuetzenlaengsverstellung();
            iSerializer.putBool(bl14);
            boolean bl15 = visualizationConfig.isFussstuetzenhoehe();
            iSerializer.putBool(bl15);
            boolean bl16 = visualizationConfig.isRseAufnahmehoehe();
            iSerializer.putBool(bl16);
            boolean bl17 = visualizationConfig.isRseAufnahmetiefe();
            iSerializer.putBool(bl17);
            boolean bl18 = visualizationConfig.isFussmattenhoehe();
            iSerializer.putBool(bl18);
            boolean bl19 = visualizationConfig.isRseDisplay();
            iSerializer.putBool(bl19);
        }
    }

    public static void putOptionalVisualizationConfigVarArray(ISerializer iSerializer, VisualizationConfig[] visualizationConfigArray) {
        boolean bl = visualizationConfigArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(visualizationConfigArray.length);
            for (int i2 = 0; i2 < visualizationConfigArray.length; ++i2) {
                VisualizationConfigSerializer.putOptionalVisualizationConfig(iSerializer, visualizationConfigArray[i2]);
            }
        }
    }

    public static VisualizationConfig getOptionalVisualizationConfig(IDeserializer iDeserializer) {
        VisualizationConfig visualizationConfig = null;
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
            visualizationConfig = new VisualizationConfig();
            visualizationConfig.sitzlaengsverstellung = bl19 = iDeserializer.getBool();
            visualizationConfig.sitzhoehenverstellung = bl18 = iDeserializer.getBool();
            visualizationConfig.sitzneigungsverstellung = bl17 = iDeserializer.getBool();
            visualizationConfig.lehnenneigungsverstellung = bl16 = iDeserializer.getBool();
            visualizationConfig.kopfstuetzenhoehenverstellung = bl15 = iDeserializer.getBool();
            visualizationConfig.lordosenweitenverstellung = bl14 = iDeserializer.getBool();
            visualizationConfig.lordosenhoehenverstellung = bl13 = iDeserializer.getBool();
            visualizationConfig.sitztiefenverstellung = bl12 = iDeserializer.getBool();
            visualizationConfig.lehnenkopfverstellung = bl11 = iDeserializer.getBool();
            visualizationConfig.gurthoehenverstellung = bl10 = iDeserializer.getBool();
            visualizationConfig.lehnenwangenverstellung = bl9 = iDeserializer.getBool();
            visualizationConfig.sitzflaechenwangenverstellung = bl8 = iDeserializer.getBool();
            visualizationConfig.kopfstuetzenlaengsverstellung = bl7 = iDeserializer.getBool();
            visualizationConfig.fussstuetzenhoehe = bl6 = iDeserializer.getBool();
            visualizationConfig.rseAufnahmehoehe = bl5 = iDeserializer.getBool();
            visualizationConfig.rseAufnahmetiefe = bl4 = iDeserializer.getBool();
            visualizationConfig.fussmattenhoehe = bl3 = iDeserializer.getBool();
            visualizationConfig.rseDisplay = bl2 = iDeserializer.getBool();
        }
        return visualizationConfig;
    }

    public static VisualizationConfig[] getOptionalVisualizationConfigVarArray(IDeserializer iDeserializer) {
        VisualizationConfig[] visualizationConfigArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            visualizationConfigArray = new VisualizationConfig[n];
            for (int i2 = 0; i2 < n; ++i2) {
                visualizationConfigArray[i2] = VisualizationConfigSerializer.getOptionalVisualizationConfig(iDeserializer);
            }
        }
        return visualizationConfigArray;
    }
}

