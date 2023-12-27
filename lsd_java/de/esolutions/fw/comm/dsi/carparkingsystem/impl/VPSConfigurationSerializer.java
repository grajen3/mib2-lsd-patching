/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSSupportedBVModesSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSSupportedFVModesSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSSupportedRVModesSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSSupportedSVModesSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSSupportedSplitscreensSerializer;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.VPSSupportedViewsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.VPSConfiguration;
import org.dsi.ifc.carparkingsystem.VPSSupportedBVModes;
import org.dsi.ifc.carparkingsystem.VPSSupportedFVModes;
import org.dsi.ifc.carparkingsystem.VPSSupportedRVModes;
import org.dsi.ifc.carparkingsystem.VPSSupportedSVModes;
import org.dsi.ifc.carparkingsystem.VPSSupportedSplitscreens;
import org.dsi.ifc.carparkingsystem.VPSSupportedViews;

public class VPSConfigurationSerializer {
    public static void putOptionalVPSConfiguration(ISerializer iSerializer, VPSConfiguration vPSConfiguration) {
        boolean bl = vPSConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            VPSSupportedSplitscreens vPSSupportedSplitscreens = vPSConfiguration.getSupportedSplitScreens();
            VPSSupportedSplitscreensSerializer.putOptionalVPSSupportedSplitscreens(iSerializer, vPSSupportedSplitscreens);
            VPSSupportedViews vPSSupportedViews = vPSConfiguration.getSupportedViews();
            VPSSupportedViewsSerializer.putOptionalVPSSupportedViews(iSerializer, vPSSupportedViews);
            VPSSupportedRVModes vPSSupportedRVModes = vPSConfiguration.getSupportedRVModes();
            VPSSupportedRVModesSerializer.putOptionalVPSSupportedRVModes(iSerializer, vPSSupportedRVModes);
            VPSSupportedFVModes vPSSupportedFVModes = vPSConfiguration.getSupportedFVModes();
            VPSSupportedFVModesSerializer.putOptionalVPSSupportedFVModes(iSerializer, vPSSupportedFVModes);
            VPSSupportedSVModes vPSSupportedSVModes = vPSConfiguration.getSupportedSVModes();
            VPSSupportedSVModesSerializer.putOptionalVPSSupportedSVModes(iSerializer, vPSSupportedSVModes);
            VPSSupportedBVModes vPSSupportedBVModes = vPSConfiguration.getSupportedBVModes();
            VPSSupportedBVModesSerializer.putOptionalVPSSupportedBVModes(iSerializer, vPSSupportedBVModes);
            int n = vPSConfiguration.getBirdview3DViewPlains();
            iSerializer.putInt32(n);
            int n2 = vPSConfiguration.getBirdview3DViewPoints();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalVPSConfigurationVarArray(ISerializer iSerializer, VPSConfiguration[] vPSConfigurationArray) {
        boolean bl = vPSConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vPSConfigurationArray.length);
            for (int i2 = 0; i2 < vPSConfigurationArray.length; ++i2) {
                VPSConfigurationSerializer.putOptionalVPSConfiguration(iSerializer, vPSConfigurationArray[i2]);
            }
        }
    }

    public static VPSConfiguration getOptionalVPSConfiguration(IDeserializer iDeserializer) {
        VPSConfiguration vPSConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            VPSSupportedBVModes vPSSupportedBVModes;
            VPSSupportedSVModes vPSSupportedSVModes;
            VPSSupportedFVModes vPSSupportedFVModes;
            VPSSupportedRVModes vPSSupportedRVModes;
            VPSSupportedViews vPSSupportedViews;
            VPSSupportedSplitscreens vPSSupportedSplitscreens;
            vPSConfiguration = new VPSConfiguration();
            vPSConfiguration.supportedSplitScreens = vPSSupportedSplitscreens = VPSSupportedSplitscreensSerializer.getOptionalVPSSupportedSplitscreens(iDeserializer);
            vPSConfiguration.supportedViews = vPSSupportedViews = VPSSupportedViewsSerializer.getOptionalVPSSupportedViews(iDeserializer);
            vPSConfiguration.supportedRVModes = vPSSupportedRVModes = VPSSupportedRVModesSerializer.getOptionalVPSSupportedRVModes(iDeserializer);
            vPSConfiguration.supportedFVModes = vPSSupportedFVModes = VPSSupportedFVModesSerializer.getOptionalVPSSupportedFVModes(iDeserializer);
            vPSConfiguration.supportedSVModes = vPSSupportedSVModes = VPSSupportedSVModesSerializer.getOptionalVPSSupportedSVModes(iDeserializer);
            vPSConfiguration.supportedBVModes = vPSSupportedBVModes = VPSSupportedBVModesSerializer.getOptionalVPSSupportedBVModes(iDeserializer);
            vPSConfiguration.birdview3DViewPlains = n2 = iDeserializer.getInt32();
            vPSConfiguration.birdview3DViewPoints = n = iDeserializer.getInt32();
        }
        return vPSConfiguration;
    }

    public static VPSConfiguration[] getOptionalVPSConfigurationVarArray(IDeserializer iDeserializer) {
        VPSConfiguration[] vPSConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vPSConfigurationArray = new VPSConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vPSConfigurationArray[i2] = VPSConfigurationSerializer.getOptionalVPSConfiguration(iDeserializer);
            }
        }
        return vPSConfigurationArray;
    }
}

