/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.devicehandling;

import de.vw.mib.asl.framework.api.diagnosis.config.Adaptation;
import de.vw.mib.asl.framework.api.diagnosis.config.Coding;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.collections.ints.IntIntOptHashMap;

public class DeviceCoding {
    private final IntIntOptHashMap slots = new IntIntOptHashMap();
    private boolean receivedCoding = false;
    private boolean receivedAdaptation = false;

    public boolean isAvailable(int n, int n2) {
        return this.getSlotsAvailable(n) > n2;
    }

    public int getSlotsAvailable(int n) {
        if (this.slots.containsKey(n)) {
            return this.slots.get(n);
        }
        return -129;
    }

    public void receiveCoding(Coding coding) {
        this.receivedCoding = true;
        boolean bl = coding.getBoolean(71) && coding.getBoolean(72) && coding.getBoolean(74);
        this.slots.put(10, bl ? -129 : 0);
        int n = ServiceManager.configManagerDiag.getNumberOfSDSlots();
        this.slots.put(1, n);
        boolean bl2 = coding.getBoolean(42);
        this.slots.put(8, bl2 ? -129 : 0);
        boolean bl3 = coding.getBoolean(106);
        this.slots.put(9, bl3 ? -129 : 0);
        int n2 = coding.getValue(84);
        this.slots.put(2, n2 != 0 ? -129 : 0);
        ServiceManager.logger2.info(1).append("Coding: AUX: ").append(bl2).append(", BT: ").append(bl).append(", WLAN: ").append(bl3).append(", USB: ").append(n2).append(", #SD slots: ").append(n).log();
    }

    public void receiveAdaptation(Adaptation adaptation) {
        boolean bl;
        boolean bl2;
        this.receivedAdaptation = true;
        boolean bl3 = bl2 = adaptation.getValue(116) == 1;
        if (!bl2) {
            this.slots.put(10, 0);
        }
        boolean bl4 = bl = adaptation.getValue(129) == 1;
        if (!bl) {
            this.slots.put(9, 0);
        }
        boolean bl5 = adaptation.getValue(161) == 1;
        boolean bl6 = adaptation.getValue(162) == 1;
        boolean bl7 = adaptation.getValue(163) == 1;
        boolean bl8 = adaptation.getValue(164) == 1;
        ServiceManager.logger2.info(1).append("Adaptation: wlanModulActivationActivated: ").append(bl).append(", bluetoothDeactivationStateOn: ").append(bl2).append(", activationForExternalUsb1: ").append(bl5).append(", activationForExternalUsb2: ").append(bl6).append(", activationForExternalUsb3: ").append(bl7).append(", activationForExternalUsb4: ").append(bl8).log();
    }

    public boolean isInitialized() {
        return this.receivedCoding && this.receivedAdaptation;
    }
}

