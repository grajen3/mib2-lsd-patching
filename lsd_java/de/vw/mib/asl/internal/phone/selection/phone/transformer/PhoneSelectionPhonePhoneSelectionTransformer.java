/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.selection.phone.transformer;

import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.bluetooth.ConnectedDevice;
import de.vw.mib.asl.internal.phone.selection.phone.transformer.PhoneSelectionPhonePhoneSelectionCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.phone.selection.phone.transformer.AbstractPhoneSelectionPhonePhoneSelectionTransformer;

public class PhoneSelectionPhonePhoneSelectionTransformer
extends AbstractPhoneSelectionPhonePhoneSelectionTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        PhoneSelectionPhonePhoneSelectionCollector phoneSelectionPhonePhoneSelectionCollector = (PhoneSelectionPhonePhoneSelectionCollector)object;
        ConnectedDevice connectedDevice = phoneSelectionPhonePhoneSelectionCollector.connectedDevice;
        switch (n) {
            case 5: {
                if (phoneSelectionPhonePhoneSelectionCollector.deviceType == 1) {
                    return this.isPhoneConnected(connectedDevice.connectedServices);
                }
                return phoneSelectionPhonePhoneSelectionCollector.simMode == 1 || !ASLPhoneData.getInstance().isOtherSIMAvailable;
            }
            case 3: {
                if (phoneSelectionPhonePhoneSelectionCollector.deviceType == 1 || phoneSelectionPhonePhoneSelectionCollector.deviceType == 2) {
                    return this.isPhoneConnected(connectedDevice.connectedServices);
                }
                return true;
            }
            case 4: {
                if (phoneSelectionPhonePhoneSelectionCollector.deviceType == 1 || phoneSelectionPhonePhoneSelectionCollector.deviceType == 2) {
                    return this.isServiceConnected(PhoneUtil.getPhoneProfile(connectedDevice.device.lastConnectedServiceTypes), connectedDevice.connectedServices);
                }
                return true;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    private boolean isPhoneConnected(int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (!PhoneUtil.isPhoneDeviceProfile(nArray[i2])) continue;
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
        PhoneSelectionPhonePhoneSelectionCollector phoneSelectionPhonePhoneSelectionCollector = (PhoneSelectionPhonePhoneSelectionCollector)object;
        ConnectedDevice connectedDevice = phoneSelectionPhonePhoneSelectionCollector.connectedDevice;
        switch (n) {
            case 6: {
                return phoneSelectionPhonePhoneSelectionCollector.simMode;
            }
            case 2: {
                if (phoneSelectionPhonePhoneSelectionCollector.deviceType == 1 || phoneSelectionPhonePhoneSelectionCollector.deviceType == 2) {
                    return PhoneUtil.convertServiceTypeDSI2ASL(PhoneUtil.getLastConnectedTelephonyService(connectedDevice.device));
                }
                return 0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        PhoneSelectionPhonePhoneSelectionCollector phoneSelectionPhonePhoneSelectionCollector = (PhoneSelectionPhonePhoneSelectionCollector)object;
        ConnectedDevice connectedDevice = phoneSelectionPhonePhoneSelectionCollector.connectedDevice;
        switch (n) {
            case 0: {
                String string = phoneSelectionPhonePhoneSelectionCollector.deviceType == 1 || phoneSelectionPhonePhoneSelectionCollector.deviceType == 2 ? connectedDevice.device.deviceName : ASLPhoneData.getInstance().SIMName;
                return string;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

