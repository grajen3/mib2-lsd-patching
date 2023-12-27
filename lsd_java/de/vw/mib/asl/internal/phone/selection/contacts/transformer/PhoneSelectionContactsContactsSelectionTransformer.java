/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.selection.contacts.transformer;

import de.vw.mib.asl.internal.phone.bluetooth.ConnectedDevice;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.phone.selection.contacts.transformer.AbstractPhoneSelectionContactsContactsSelectionTransformer;

public class PhoneSelectionContactsContactsSelectionTransformer
extends AbstractPhoneSelectionContactsContactsSelectionTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        ConnectedDevice connectedDevice = (ConnectedDevice)object;
        switch (n) {
            case 4: {
                return this.isPBAPConnected(connectedDevice.connectedServices);
            }
            case 2: {
                return this.isPBAPConnected(connectedDevice.connectedServices);
            }
            case 3: {
                return this.isServiceConnected(PhoneUtil.getADRDLProfile(connectedDevice.device.lastConnectedServiceTypes), connectedDevice.connectedServices);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    private boolean isPBAPConnected(int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (!Util.isBitSet(32, nArray[i2])) continue;
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
                return 13;
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

