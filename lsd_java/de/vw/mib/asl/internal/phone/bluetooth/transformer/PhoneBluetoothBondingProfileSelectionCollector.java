/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bluetooth.transformer;

public class PhoneBluetoothBondingProfileSelectionCollector
implements Comparable {
    public int profileDSI;
    public int profileASL;
    public boolean connected;

    @Override
    public int compareTo(Object object) {
        PhoneBluetoothBondingProfileSelectionCollector phoneBluetoothBondingProfileSelectionCollector = (PhoneBluetoothBondingProfileSelectionCollector)object;
        if (this.profileASL == phoneBluetoothBondingProfileSelectionCollector.profileASL) {
            return 0;
        }
        if (this.profileASL < phoneBluetoothBondingProfileSelectionCollector.profileASL) {
            return -1;
        }
        return 1;
    }
}

