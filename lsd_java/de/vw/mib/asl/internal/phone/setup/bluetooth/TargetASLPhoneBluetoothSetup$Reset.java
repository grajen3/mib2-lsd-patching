/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.setup.bluetooth;

import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.setup.bluetooth.TargetASLPhoneBluetoothSetup;
import de.vw.mib.asl.internal.phone.setup.bluetooth.TargetASLPhoneBluetoothSetup$1;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.bluetooth.DiscoveredDevice;

class TargetASLPhoneBluetoothSetup$Reset
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ TargetASLPhoneBluetoothSetup this$0;

    private TargetASLPhoneBluetoothSetup$Reset(TargetASLPhoneBluetoothSetup targetASLPhoneBluetoothSetup) {
        this.this$0 = targetASLPhoneBluetoothSetup;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        if (!ASLPhoneFactory.getPhoneApi().isCallsActive()) {
            this.this$0.dsiBluetooth.requestRestoreFactorySettings();
            ASLPhoneData.getInstance().isBTFactoryResetRequested = true;
            PhoneUtil.resetDiscoveredDevices();
            ListManager.getGenericASLList(1142).updateList(new DiscoveredDevice[0]);
            TargetASLPhoneBluetoothSetup.access$102(this.this$0, factoryResetCallback);
        } else if (factoryResetCallback != null) {
            factoryResetCallback.notifyResetDone();
        }
    }

    /* synthetic */ TargetASLPhoneBluetoothSetup$Reset(TargetASLPhoneBluetoothSetup targetASLPhoneBluetoothSetup, TargetASLPhoneBluetoothSetup$1 targetASLPhoneBluetoothSetup$1) {
        this(targetASLPhoneBluetoothSetup);
    }
}

