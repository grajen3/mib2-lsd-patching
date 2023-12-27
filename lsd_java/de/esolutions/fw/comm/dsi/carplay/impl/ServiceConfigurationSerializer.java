/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carplay.impl;

import de.esolutions.fw.comm.dsi.carplay.impl.AppStateRequestSerializer;
import de.esolutions.fw.comm.dsi.carplay.impl.ResourceRequestSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.ResourceRequest;
import org.dsi.ifc.carplay.ServiceConfiguration;

public class ServiceConfigurationSerializer {
    public static void putOptionalServiceConfiguration(ISerializer iSerializer, ServiceConfiguration serviceConfiguration) {
        boolean bl = serviceConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            AppStateRequest[] appStateRequestArray = serviceConfiguration.getInitialAppState();
            AppStateRequestSerializer.putOptionalAppStateRequestVarArray(iSerializer, appStateRequestArray);
            ResourceRequest[] resourceRequestArray = serviceConfiguration.getInitialResources();
            ResourceRequestSerializer.putOptionalResourceRequestVarArray(iSerializer, resourceRequestArray);
            int n = serviceConfiguration.getScreenResolution();
            iSerializer.putInt32(n);
            int n2 = serviceConfiguration.getXResolution();
            iSerializer.putInt32(n2);
            int n3 = serviceConfiguration.getYResolution();
            iSerializer.putInt32(n3);
            int n4 = serviceConfiguration.getXOffset();
            iSerializer.putInt32(n4);
            int n5 = serviceConfiguration.getYOffset();
            iSerializer.putInt32(n5);
            String string = serviceConfiguration.getDisplayName();
            iSerializer.putOptionalString(string);
            boolean bl2 = serviceConfiguration.isUseRightHandDrive();
            iSerializer.putBool(bl2);
            int n6 = serviceConfiguration.getTouchpadXResolution();
            iSerializer.putInt32(n6);
            int n7 = serviceConfiguration.getTouchpadYResolution();
            iSerializer.putInt32(n7);
            String[] stringArray = serviceConfiguration.getBluetoothIdentities();
            iSerializer.putOptionalStringVarArray(stringArray);
            boolean bl3 = serviceConfiguration.isStartInNightMode();
            iSerializer.putBool(bl3);
            int n8 = serviceConfiguration.getPhysicalDisplayHeight();
            iSerializer.putInt32(n8);
            int n9 = serviceConfiguration.getPhysicalDisplayWidth();
            iSerializer.putInt32(n9);
            int n10 = serviceConfiguration.getInputFeatures();
            iSerializer.putInt32(n10);
        }
    }

    public static void putOptionalServiceConfigurationVarArray(ISerializer iSerializer, ServiceConfiguration[] serviceConfigurationArray) {
        boolean bl = serviceConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(serviceConfigurationArray.length);
            for (int i2 = 0; i2 < serviceConfigurationArray.length; ++i2) {
                ServiceConfigurationSerializer.putOptionalServiceConfiguration(iSerializer, serviceConfigurationArray[i2]);
            }
        }
    }

    public static ServiceConfiguration getOptionalServiceConfiguration(IDeserializer iDeserializer) {
        ServiceConfiguration serviceConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            boolean bl2;
            int n4;
            int n5;
            boolean bl3;
            String string;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            serviceConfiguration = new ServiceConfiguration();
            AppStateRequest[] appStateRequestArray = AppStateRequestSerializer.getOptionalAppStateRequestVarArray(iDeserializer);
            serviceConfiguration.initialAppState = appStateRequestArray;
            ResourceRequest[] resourceRequestArray = ResourceRequestSerializer.getOptionalResourceRequestVarArray(iDeserializer);
            serviceConfiguration.initialResources = resourceRequestArray;
            serviceConfiguration.screenResolution = n10 = iDeserializer.getInt32();
            serviceConfiguration.xResolution = n9 = iDeserializer.getInt32();
            serviceConfiguration.yResolution = n8 = iDeserializer.getInt32();
            serviceConfiguration.xOffset = n7 = iDeserializer.getInt32();
            serviceConfiguration.yOffset = n6 = iDeserializer.getInt32();
            serviceConfiguration.displayName = string = iDeserializer.getOptionalString();
            serviceConfiguration.useRightHandDrive = bl3 = iDeserializer.getBool();
            serviceConfiguration.touchpadXResolution = n5 = iDeserializer.getInt32();
            serviceConfiguration.touchpadYResolution = n4 = iDeserializer.getInt32();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            serviceConfiguration.bluetoothIdentities = stringArray;
            serviceConfiguration.startInNightMode = bl2 = iDeserializer.getBool();
            serviceConfiguration.physicalDisplayHeight = n3 = iDeserializer.getInt32();
            serviceConfiguration.physicalDisplayWidth = n2 = iDeserializer.getInt32();
            serviceConfiguration.inputFeatures = n = iDeserializer.getInt32();
        }
        return serviceConfiguration;
    }

    public static ServiceConfiguration[] getOptionalServiceConfigurationVarArray(IDeserializer iDeserializer) {
        ServiceConfiguration[] serviceConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            serviceConfigurationArray = new ServiceConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                serviceConfigurationArray[i2] = ServiceConfigurationSerializer.getOptionalServiceConfiguration(iDeserializer);
            }
        }
        return serviceConfigurationArray;
    }
}

