/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.datapool;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public class ASLVicsEtcDatapoolBooleanWrapper {
    private boolean value;
    private int key;
    private boolean trueValue;
    private boolean falseValue;

    public ASLVicsEtcDatapoolBooleanWrapper(boolean bl, int n, boolean bl2, boolean bl3) {
        this.value = bl;
        this.key = n;
        this.trueValue = bl2;
        this.falseValue = bl3;
        this.writeToASLDatapool();
    }

    public void toggle() {
        this.value = !this.value;
    }

    public void writeToASLDatapool() {
        if (this.value) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(this.key, this.trueValue);
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(this.key, this.falseValue);
        }
    }

    public boolean isChecked() {
        return this.value;
    }
}

