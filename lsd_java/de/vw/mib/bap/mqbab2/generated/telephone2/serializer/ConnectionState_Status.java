/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.telephone2.serializer.ConnectionState_Status$BluetoothConnections;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ConnectionState_Status
implements StatusProperty {
    public int bluetoothState;
    private static final int BLUETOOTH_STATE_BITSIZE;
    public static final int BLUETOOTH_STATE_BLUETOOTH_NOT_INSTALLED;
    public static final int BLUETOOTH_STATE_BLUETOOTH_OFF;
    public static final int BLUETOOTH_STATE_BLUETOOTH_ON;
    public static final int BLUETOOTH_STATE_BLUETOOTH_SWITCHING_OFF;
    public static final int BLUETOOTH_STATE_BLUETOOTH_SWITCHING_ON;
    public static final int BLUETOOTH_STATE_BLUETOOTH_NOT_FUNCTIONAL;
    public int bluetoothVisibility;
    private static final int BLUETOOTH_VISIBILITY_BITSIZE;
    public static final int BLUETOOTH_VISIBILITY_NOT_VISIBLE;
    public static final int BLUETOOTH_VISIBILITY_VISIBLE;
    public static final int BLUETOOTH_VISIBILITY_AUTO;
    public final ConnectionState_Status$BluetoothConnections bluetoothConnections = new ConnectionState_Status$BluetoothConnections();
    public int wlanstate;
    private static final int WLAN_STATE_BITSIZE;
    public static final int WLAN_STATE_WLAN_NOT_INSTALLED;
    public static final int WLAN_STATE_OFF;
    public static final int WLAN_STATE_ON;
    public int wlanvisibility;
    private static final int WLAN_VISIBILITY_BITSIZE;
    public static final int WLAN_VISIBILITY_NOT_VISIBLE;
    public static final int WLAN_VISIBILITY_VISIBLE;
    public static final int WLAN_VISIBILITY_AUTO;
    public int wlanconnections;
    public static final int EXTENSION_1_MIN;
    public int extension_1;
    public static final int EXTENSION_2_MIN;
    public int extension_2;

    public ConnectionState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ConnectionState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.bluetoothState = 0;
        this.bluetoothVisibility = 0;
        this.wlanstate = 0;
        this.wlanvisibility = 0;
        this.wlanconnections = 0;
        this.extension_1 = 0;
        this.extension_2 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.bluetoothConnections.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ConnectionState_Status connectionState_Status = (ConnectionState_Status)bAPEntity;
        return this.bluetoothState == connectionState_Status.bluetoothState && this.bluetoothVisibility == connectionState_Status.bluetoothVisibility && this.bluetoothConnections.equalTo(connectionState_Status.bluetoothConnections) && this.wlanstate == connectionState_Status.wlanstate && this.wlanvisibility == connectionState_Status.wlanvisibility && this.wlanconnections == connectionState_Status.wlanconnections && this.extension_1 == connectionState_Status.extension_1 && this.extension_2 == connectionState_Status.extension_2;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ConnectionState_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.bluetoothState);
        bitStream.pushBits(4, this.bluetoothVisibility);
        this.bluetoothConnections.serialize(bitStream);
        bitStream.pushBits(4, this.wlanstate);
        bitStream.pushBits(4, this.wlanvisibility);
        bitStream.pushByte((byte)this.wlanconnections);
        bitStream.pushByte((byte)this.extension_1);
        bitStream.pushByte((byte)this.extension_2);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 24;
    }

    @Override
    public int getFunctionId() {
        return ConnectionState_Status.functionId();
    }
}

