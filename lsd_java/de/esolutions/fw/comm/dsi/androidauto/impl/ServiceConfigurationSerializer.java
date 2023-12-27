/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto.impl;

import de.esolutions.fw.comm.dsi.androidauto.impl.AppStateSerializer;
import de.esolutions.fw.comm.dsi.androidauto.impl.ResourceSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.androidauto.AppState;
import org.dsi.ifc.androidauto.Resource;
import org.dsi.ifc.androidauto.ServiceConfiguration;

public class ServiceConfigurationSerializer {
    public static void putOptionalServiceConfiguration(ISerializer iSerializer, ServiceConfiguration serviceConfiguration) {
        boolean bl = serviceConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            AppState[] appStateArray = serviceConfiguration.getInitialAppState();
            AppStateSerializer.putOptionalAppStateVarArray(iSerializer, appStateArray);
            Resource[] resourceArray = serviceConfiguration.getInitialResources();
            ResourceSerializer.putOptionalResourceVarArray(iSerializer, resourceArray);
            int n = serviceConfiguration.getDisplayResolutionX();
            iSerializer.putInt32(n);
            int n2 = serviceConfiguration.getDisplayResolutionY();
            iSerializer.putInt32(n2);
            int n3 = serviceConfiguration.getDisplayOffsetX();
            iSerializer.putInt32(n3);
            int n4 = serviceConfiguration.getDisplayOffsetY();
            iSerializer.putInt32(n4);
            String string = serviceConfiguration.getDisplayName();
            iSerializer.putOptionalString(string);
            boolean bl2 = serviceConfiguration.isUseRightHandDrive();
            iSerializer.putBool(bl2);
            boolean bl3 = serviceConfiguration.isTouchpadAvailable();
            iSerializer.putBool(bl3);
            int n5 = serviceConfiguration.getTouchpadResolutionX();
            iSerializer.putInt32(n5);
            int n6 = serviceConfiguration.getTouchpadResolutionY();
            iSerializer.putInt32(n6);
            boolean bl4 = serviceConfiguration.isTouchscreenAvailable();
            iSerializer.putBool(bl4);
            int n7 = serviceConfiguration.getTouchscreenResolutionX();
            iSerializer.putInt32(n7);
            int n8 = serviceConfiguration.getTouchscreenResolutionY();
            iSerializer.putInt32(n8);
            boolean bl5 = serviceConfiguration.isStartInNightMode();
            iSerializer.putBool(bl5);
            int n9 = serviceConfiguration.getPhysicalDisplayHeight();
            iSerializer.putInt32(n9);
            int n10 = serviceConfiguration.getPhysicalDisplayWidth();
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
            boolean bl2;
            int n3;
            int n4;
            boolean bl3;
            int n5;
            int n6;
            boolean bl4;
            boolean bl5;
            String string;
            int n7;
            int n8;
            int n9;
            int n10;
            serviceConfiguration = new ServiceConfiguration();
            AppState[] appStateArray = AppStateSerializer.getOptionalAppStateVarArray(iDeserializer);
            serviceConfiguration.initialAppState = appStateArray;
            Resource[] resourceArray = ResourceSerializer.getOptionalResourceVarArray(iDeserializer);
            serviceConfiguration.initialResources = resourceArray;
            serviceConfiguration.displayResolutionX = n10 = iDeserializer.getInt32();
            serviceConfiguration.displayResolutionY = n9 = iDeserializer.getInt32();
            serviceConfiguration.displayOffsetX = n8 = iDeserializer.getInt32();
            serviceConfiguration.displayOffsetY = n7 = iDeserializer.getInt32();
            serviceConfiguration.displayName = string = iDeserializer.getOptionalString();
            serviceConfiguration.useRightHandDrive = bl5 = iDeserializer.getBool();
            serviceConfiguration.touchpadAvailable = bl4 = iDeserializer.getBool();
            serviceConfiguration.touchpadResolutionX = n6 = iDeserializer.getInt32();
            serviceConfiguration.touchpadResolutionY = n5 = iDeserializer.getInt32();
            serviceConfiguration.touchscreenAvailable = bl3 = iDeserializer.getBool();
            serviceConfiguration.touchscreenResolutionX = n4 = iDeserializer.getInt32();
            serviceConfiguration.touchscreenResolutionY = n3 = iDeserializer.getInt32();
            serviceConfiguration.startInNightMode = bl2 = iDeserializer.getBool();
            serviceConfiguration.physicalDisplayHeight = n2 = iDeserializer.getInt32();
            serviceConfiguration.physicalDisplayWidth = n = iDeserializer.getInt32();
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

