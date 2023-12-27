/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.UnifiedStation;

public class UnifiedStationSerializer {
    public static void putOptionalUnifiedStation(ISerializer iSerializer, UnifiedStation unifiedStation) {
        boolean bl = unifiedStation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = unifiedStation.getShortName();
            iSerializer.putOptionalString(string);
            String string2 = unifiedStation.getLongName();
            iSerializer.putOptionalString(string2);
            long l = unifiedStation.getFrequency();
            iSerializer.putInt64(l);
            int n = unifiedStation.getPiSId();
            iSerializer.putInt32(n);
            int n2 = unifiedStation.getEnsId();
            iSerializer.putInt32(n2);
            int n3 = unifiedStation.getEcc();
            iSerializer.putInt32(n3);
            int n4 = unifiedStation.getSCIDI();
            iSerializer.putInt32(n4);
            int n5 = unifiedStation.getScrollingPS();
            iSerializer.putInt32(n5);
            boolean bl2 = unifiedStation.isRds();
            iSerializer.putBool(bl2);
            int n6 = unifiedStation.getAudioQuality();
            iSerializer.putInt32(n6);
            int n7 = unifiedStation.getTpAvailability();
            iSerializer.putInt32(n7);
            byte[] byArray = unifiedStation.getPtyCodes();
            iSerializer.putOptionalInt8VarArray(byArray);
            boolean bl3 = unifiedStation.isRadioText();
            iSerializer.putBool(bl3);
            boolean bl4 = unifiedStation.isRadioTextPlus();
            iSerializer.putBool(bl4);
            boolean bl5 = unifiedStation.isEnhancedRadioText();
            iSerializer.putBool(bl5);
            boolean bl6 = unifiedStation.isSlideshow();
            iSerializer.putBool(bl6);
            ResourceLocator resourceLocator = unifiedStation.getStationLogo();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            boolean bl7 = unifiedStation.isCoChannel();
            iSerializer.putBool(bl7);
        }
    }

    public static void putOptionalUnifiedStationVarArray(ISerializer iSerializer, UnifiedStation[] unifiedStationArray) {
        boolean bl = unifiedStationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(unifiedStationArray.length);
            for (int i2 = 0; i2 < unifiedStationArray.length; ++i2) {
                UnifiedStationSerializer.putOptionalUnifiedStation(iSerializer, unifiedStationArray[i2]);
            }
        }
    }

    public static UnifiedStation getOptionalUnifiedStation(IDeserializer iDeserializer) {
        UnifiedStation unifiedStation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            ResourceLocator resourceLocator;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            int n;
            int n2;
            boolean bl7;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            long l;
            String string;
            String string2;
            unifiedStation = new UnifiedStation();
            unifiedStation.shortName = string2 = iDeserializer.getOptionalString();
            unifiedStation.longName = string = iDeserializer.getOptionalString();
            unifiedStation.frequency = l = iDeserializer.getInt64();
            unifiedStation.piSId = n7 = iDeserializer.getInt32();
            unifiedStation.ensId = n6 = iDeserializer.getInt32();
            unifiedStation.ecc = n5 = iDeserializer.getInt32();
            unifiedStation.sCIDI = n4 = iDeserializer.getInt32();
            unifiedStation.scrollingPS = n3 = iDeserializer.getInt32();
            unifiedStation.rds = bl7 = iDeserializer.getBool();
            unifiedStation.audioQuality = n2 = iDeserializer.getInt32();
            unifiedStation.tpAvailability = n = iDeserializer.getInt32();
            byte[] byArray = iDeserializer.getOptionalInt8VarArray();
            unifiedStation.ptyCodes = byArray;
            unifiedStation.radioText = bl6 = iDeserializer.getBool();
            unifiedStation.radioTextPlus = bl5 = iDeserializer.getBool();
            unifiedStation.enhancedRadioText = bl4 = iDeserializer.getBool();
            unifiedStation.slideshow = bl3 = iDeserializer.getBool();
            unifiedStation.stationLogo = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
            unifiedStation.coChannel = bl2 = iDeserializer.getBool();
        }
        return unifiedStation;
    }

    public static UnifiedStation[] getOptionalUnifiedStationVarArray(IDeserializer iDeserializer) {
        UnifiedStation[] unifiedStationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            unifiedStationArray = new UnifiedStation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                unifiedStationArray[i2] = UnifiedStationSerializer.getOptionalUnifiedStation(iDeserializer);
            }
        }
        return unifiedStationArray;
    }
}

