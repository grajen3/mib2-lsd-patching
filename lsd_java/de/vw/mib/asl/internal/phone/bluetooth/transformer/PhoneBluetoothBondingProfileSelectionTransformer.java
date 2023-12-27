/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bluetooth.transformer;

import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.bluetooth.transformer.PhoneBluetoothBondingProfileSelectionCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import generated.de.vw.mib.asl.internal.phone.bluetooth.transformer.AbstractPhoneBluetoothBondingProfileSelectionTransformer;

public class PhoneBluetoothBondingProfileSelectionTransformer
extends AbstractPhoneBluetoothBondingProfileSelectionTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        PhoneBluetoothBondingProfileSelectionCollector phoneBluetoothBondingProfileSelectionCollector = (PhoneBluetoothBondingProfileSelectionCollector)object;
        switch (n) {
            case 1: {
                return phoneBluetoothBondingProfileSelectionCollector.connected;
            }
            case 2: {
                switch (phoneBluetoothBondingProfileSelectionCollector.profileDSI) {
                    case 65536: {
                        return ASLPhoneData.getInstance().a2DPEnabled;
                    }
                    case 4: {
                        return PhoneUtil.isSimapTemporarilyAvailable();
                    }
                }
                return true;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        PhoneBluetoothBondingProfileSelectionCollector phoneBluetoothBondingProfileSelectionCollector = (PhoneBluetoothBondingProfileSelectionCollector)object;
        switch (n) {
            case 0: {
                return phoneBluetoothBondingProfileSelectionCollector.profileASL;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean[] getFlagVector(int n, Object object) {
        throw new IllegalArgumentException();
    }
}

