/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ConnectionState_Status$BluetoothConnections
implements BAPEntity {
    private static final int RESERVED_BIT_4__7_BITSIZE;
    public boolean simAccessProfileActive;
    public boolean phonebookAccessProfileActive;
    public boolean handsFreeProfileActive;
    public boolean audioplayerActive;

    public ConnectionState_Status$BluetoothConnections() {
        this.internalReset();
        this.customInitialization();
    }

    public ConnectionState_Status$BluetoothConnections(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.simAccessProfileActive = false;
        this.phonebookAccessProfileActive = false;
        this.handsFreeProfileActive = false;
        this.audioplayerActive = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ConnectionState_Status$BluetoothConnections connectionState_Status$BluetoothConnections = (ConnectionState_Status$BluetoothConnections)bAPEntity;
        return this.simAccessProfileActive == connectionState_Status$BluetoothConnections.simAccessProfileActive && this.phonebookAccessProfileActive == connectionState_Status$BluetoothConnections.phonebookAccessProfileActive && this.handsFreeProfileActive == connectionState_Status$BluetoothConnections.handsFreeProfileActive && this.audioplayerActive == connectionState_Status$BluetoothConnections.audioplayerActive;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "BluetoothConnections:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(4);
        bitStream.pushBoolean(this.simAccessProfileActive);
        bitStream.pushBoolean(this.phonebookAccessProfileActive);
        bitStream.pushBoolean(this.handsFreeProfileActive);
        bitStream.pushBoolean(this.audioplayerActive);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

