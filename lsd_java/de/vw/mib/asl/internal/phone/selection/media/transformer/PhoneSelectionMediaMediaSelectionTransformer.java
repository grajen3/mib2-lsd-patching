/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.selection.media.transformer;

import de.vw.mib.asl.internal.phone.bluetooth.ConnectedDevice;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.phone.selection.media.transformer.AbstractPhoneSelectionMediaMediaSelectionTransformer;

public class PhoneSelectionMediaMediaSelectionTransformer
extends AbstractPhoneSelectionMediaMediaSelectionTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        ConnectedDevice connectedDevice = (ConnectedDevice)object;
        switch (n) {
            case 5: {
                return this.isMediaConnected(connectedDevice.connectedServices);
            }
            case 3: {
                return this.isMediaConnected(connectedDevice.connectedServices);
            }
            case 4: {
                return this.isServiceConnected(PhoneUtil.getMediaProfile(connectedDevice.device.lastConnectedServiceTypes), connectedDevice.connectedServices);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    private boolean isMediaConnected(int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (!PhoneUtil.isMediaDeviceProfile(nArray[i2])) continue;
            return true;
        }
        return false;
    }

    private boolean isServiceConnected(int n, int[] nArray) {
        if (n != 0) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (!Util.isBitSet(n, nArray[i2])) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 1: {
                return 0;
            }
            case 2: {
                return 5;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        ConnectedDevice connectedDevice = (ConnectedDevice)object;
        switch (n) {
            case 0: {
                return connectedDevice.device.deviceName;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

