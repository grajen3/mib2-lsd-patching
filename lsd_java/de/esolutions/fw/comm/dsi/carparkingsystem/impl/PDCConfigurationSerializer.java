/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCContinueDrivingAssistSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCManeuverAssistSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.PDCSupportedFunctionsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.PDCConfiguration;
import org.dsi.ifc.carparkingsystem.PDCContinueDrivingAssist;
import org.dsi.ifc.carparkingsystem.PDCManeuverAssist;
import org.dsi.ifc.carparkingsystem.PDCSupportedFunctions;

public class PDCConfigurationSerializer {
    public static void putOptionalPDCConfiguration(ISerializer iSerializer, PDCConfiguration pDCConfiguration) {
        boolean bl = pDCConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            byte by = pDCConfiguration.getNumberFrontSectors();
            iSerializer.putInt8(by);
            byte by2 = pDCConfiguration.getNumberRearSectors();
            iSerializer.putInt8(by2);
            byte by3 = pDCConfiguration.getNumberRightSectors();
            iSerializer.putInt8(by3);
            byte by4 = pDCConfiguration.getNumberLeftSectors();
            iSerializer.putInt8(by4);
            int n = pDCConfiguration.getWheelbase();
            iSerializer.putInt32(n);
            boolean bl2 = pDCConfiguration.isCrashWarning();
            iSerializer.putBool(bl2);
            boolean bl3 = pDCConfiguration.isSteeringInformation();
            iSerializer.putBool(bl3);
            PDCSupportedFunctions pDCSupportedFunctions = pDCConfiguration.getSupportedFunctions();
            PDCSupportedFunctionsSerializer.putOptionalPDCSupportedFunctions(iSerializer, pDCSupportedFunctions);
            PDCManeuverAssist pDCManeuverAssist = pDCConfiguration.getManeuverAssist();
            PDCManeuverAssistSerializer.putOptionalPDCManeuverAssist(iSerializer, pDCManeuverAssist);
            PDCContinueDrivingAssist pDCContinueDrivingAssist = pDCConfiguration.getContinueDrivingAssist();
            PDCContinueDrivingAssistSerializer.putOptionalPDCContinueDrivingAssist(iSerializer, pDCContinueDrivingAssist);
        }
    }

    public static void putOptionalPDCConfigurationVarArray(ISerializer iSerializer, PDCConfiguration[] pDCConfigurationArray) {
        boolean bl = pDCConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(pDCConfigurationArray.length);
            for (int i2 = 0; i2 < pDCConfigurationArray.length; ++i2) {
                PDCConfigurationSerializer.putOptionalPDCConfiguration(iSerializer, pDCConfigurationArray[i2]);
            }
        }
    }

    public static PDCConfiguration getOptionalPDCConfiguration(IDeserializer iDeserializer) {
        PDCConfiguration pDCConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            PDCContinueDrivingAssist pDCContinueDrivingAssist;
            PDCManeuverAssist pDCManeuverAssist;
            PDCSupportedFunctions pDCSupportedFunctions;
            boolean bl2;
            boolean bl3;
            int n;
            byte by;
            byte by2;
            byte by3;
            byte by4;
            pDCConfiguration = new PDCConfiguration();
            pDCConfiguration.numberFrontSectors = by4 = iDeserializer.getInt8();
            pDCConfiguration.numberRearSectors = by3 = iDeserializer.getInt8();
            pDCConfiguration.numberRightSectors = by2 = iDeserializer.getInt8();
            pDCConfiguration.numberLeftSectors = by = iDeserializer.getInt8();
            pDCConfiguration.wheelbase = n = iDeserializer.getInt32();
            pDCConfiguration.crashWarning = bl3 = iDeserializer.getBool();
            pDCConfiguration.steeringInformation = bl2 = iDeserializer.getBool();
            pDCConfiguration.supportedFunctions = pDCSupportedFunctions = PDCSupportedFunctionsSerializer.getOptionalPDCSupportedFunctions(iDeserializer);
            pDCConfiguration.maneuverAssist = pDCManeuverAssist = PDCManeuverAssistSerializer.getOptionalPDCManeuverAssist(iDeserializer);
            pDCConfiguration.continueDrivingAssist = pDCContinueDrivingAssist = PDCContinueDrivingAssistSerializer.getOptionalPDCContinueDrivingAssist(iDeserializer);
        }
        return pDCConfiguration;
    }

    public static PDCConfiguration[] getOptionalPDCConfigurationVarArray(IDeserializer iDeserializer) {
        PDCConfiguration[] pDCConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            pDCConfigurationArray = new PDCConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                pDCConfigurationArray[i2] = PDCConfigurationSerializer.getOptionalPDCConfiguration(iDeserializer);
            }
        }
        return pDCConfigurationArray;
    }
}

