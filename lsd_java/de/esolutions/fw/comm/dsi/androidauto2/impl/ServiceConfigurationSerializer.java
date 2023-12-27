/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto2.impl;

import de.esolutions.fw.comm.dsi.androidauto2.impl.BluetoothServiceAnnouncementSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.androidauto2.BluetoothServiceAnnouncement;
import org.dsi.ifc.androidauto2.ServiceConfiguration;

public class ServiceConfigurationSerializer {
    public static void putOptionalServiceConfiguration(ISerializer iSerializer, ServiceConfiguration serviceConfiguration) {
        boolean bl = serviceConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = serviceConfiguration.getDisplayResolutionX();
            iSerializer.putInt32(n);
            int n2 = serviceConfiguration.getDisplayResolutionY();
            iSerializer.putInt32(n2);
            int n3 = serviceConfiguration.getDriverPosition();
            iSerializer.putInt32(n3);
            boolean bl2 = serviceConfiguration.isTouchpadAvailable();
            iSerializer.putBool(bl2);
            int n4 = serviceConfiguration.getTouchpadResolutionX();
            iSerializer.putInt32(n4);
            int n5 = serviceConfiguration.getTouchpadResolutionY();
            iSerializer.putInt32(n5);
            boolean bl3 = serviceConfiguration.isTouchscreenAvailable();
            iSerializer.putBool(bl3);
            int n6 = serviceConfiguration.getTouchscreenResolutionX();
            iSerializer.putInt32(n6);
            int n7 = serviceConfiguration.getTouchscreenResolutionY();
            iSerializer.putInt32(n7);
            int n8 = serviceConfiguration.getPhysicalDisplayHeight();
            iSerializer.putInt32(n8);
            int n9 = serviceConfiguration.getPhysicalDisplayWidth();
            iSerializer.putInt32(n9);
            boolean bl4 = serviceConfiguration.isRotaryControllerAvailable();
            iSerializer.putBool(bl4);
            boolean bl5 = serviceConfiguration.isExternalBluetoothPairing();
            iSerializer.putBool(bl5);
            BluetoothServiceAnnouncement bluetoothServiceAnnouncement = serviceConfiguration.getPairingAnnoncement();
            BluetoothServiceAnnouncementSerializer.putOptionalBluetoothServiceAnnouncement(iSerializer, bluetoothServiceAnnouncement);
            int n10 = serviceConfiguration.getWindowResolutionX();
            iSerializer.putInt32(n10);
            int n11 = serviceConfiguration.getWindowResolutionY();
            iSerializer.putInt32(n11);
            int n12 = serviceConfiguration.getWindowOffsetX();
            iSerializer.putInt32(n12);
            int n13 = serviceConfiguration.getWindowOffsetY();
            iSerializer.putInt32(n13);
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
            int n4;
            BluetoothServiceAnnouncement bluetoothServiceAnnouncement;
            boolean bl2;
            boolean bl3;
            int n5;
            int n6;
            int n7;
            int n8;
            boolean bl4;
            int n9;
            int n10;
            boolean bl5;
            int n11;
            int n12;
            int n13;
            serviceConfiguration = new ServiceConfiguration();
            serviceConfiguration.displayResolutionX = n13 = iDeserializer.getInt32();
            serviceConfiguration.displayResolutionY = n12 = iDeserializer.getInt32();
            serviceConfiguration.driverPosition = n11 = iDeserializer.getInt32();
            serviceConfiguration.touchpadAvailable = bl5 = iDeserializer.getBool();
            serviceConfiguration.touchpadResolutionX = n10 = iDeserializer.getInt32();
            serviceConfiguration.touchpadResolutionY = n9 = iDeserializer.getInt32();
            serviceConfiguration.touchscreenAvailable = bl4 = iDeserializer.getBool();
            serviceConfiguration.touchscreenResolutionX = n8 = iDeserializer.getInt32();
            serviceConfiguration.touchscreenResolutionY = n7 = iDeserializer.getInt32();
            serviceConfiguration.physicalDisplayHeight = n6 = iDeserializer.getInt32();
            serviceConfiguration.physicalDisplayWidth = n5 = iDeserializer.getInt32();
            serviceConfiguration.rotaryControllerAvailable = bl3 = iDeserializer.getBool();
            serviceConfiguration.externalBluetoothPairing = bl2 = iDeserializer.getBool();
            serviceConfiguration.pairingAnnoncement = bluetoothServiceAnnouncement = BluetoothServiceAnnouncementSerializer.getOptionalBluetoothServiceAnnouncement(iDeserializer);
            serviceConfiguration.windowResolutionX = n4 = iDeserializer.getInt32();
            serviceConfiguration.windowResolutionY = n3 = iDeserializer.getInt32();
            serviceConfiguration.windowOffsetX = n2 = iDeserializer.getInt32();
            serviceConfiguration.windowOffsetY = n = iDeserializer.getInt32();
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

