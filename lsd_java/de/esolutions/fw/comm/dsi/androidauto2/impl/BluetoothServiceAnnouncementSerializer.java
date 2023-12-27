/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto2.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.androidauto2.BluetoothServiceAnnouncement;

public class BluetoothServiceAnnouncementSerializer {
    public static void putOptionalBluetoothServiceAnnouncement(ISerializer iSerializer, BluetoothServiceAnnouncement bluetoothServiceAnnouncement) {
        boolean bl = bluetoothServiceAnnouncement == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = bluetoothServiceAnnouncement.getMacAddressHU();
            iSerializer.putOptionalString(string);
            int n = bluetoothServiceAnnouncement.getSupportedPairingMethods();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalBluetoothServiceAnnouncementVarArray(ISerializer iSerializer, BluetoothServiceAnnouncement[] bluetoothServiceAnnouncementArray) {
        boolean bl = bluetoothServiceAnnouncementArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bluetoothServiceAnnouncementArray.length);
            for (int i2 = 0; i2 < bluetoothServiceAnnouncementArray.length; ++i2) {
                BluetoothServiceAnnouncementSerializer.putOptionalBluetoothServiceAnnouncement(iSerializer, bluetoothServiceAnnouncementArray[i2]);
            }
        }
    }

    public static BluetoothServiceAnnouncement getOptionalBluetoothServiceAnnouncement(IDeserializer iDeserializer) {
        BluetoothServiceAnnouncement bluetoothServiceAnnouncement = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            bluetoothServiceAnnouncement = new BluetoothServiceAnnouncement();
            bluetoothServiceAnnouncement.macAddressHU = string = iDeserializer.getOptionalString();
            bluetoothServiceAnnouncement.supportedPairingMethods = n = iDeserializer.getInt32();
        }
        return bluetoothServiceAnnouncement;
    }

    public static BluetoothServiceAnnouncement[] getOptionalBluetoothServiceAnnouncementVarArray(IDeserializer iDeserializer) {
        BluetoothServiceAnnouncement[] bluetoothServiceAnnouncementArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bluetoothServiceAnnouncementArray = new BluetoothServiceAnnouncement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bluetoothServiceAnnouncementArray[i2] = BluetoothServiceAnnouncementSerializer.getOptionalBluetoothServiceAnnouncement(iDeserializer);
            }
        }
        return bluetoothServiceAnnouncementArray;
    }
}

