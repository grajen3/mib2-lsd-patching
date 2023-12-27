/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.database;

import de.vw.mib.asl.internal.radio.sdars.database.AslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;

final class AslPoolListenerSync
extends AslPoolListener {
    private final IAslPoolListener mListener;

    AslPoolListenerSync(int n, IAslPoolListener iAslPoolListener) {
        super(n);
        this.mListener = iAslPoolListener;
    }

    @Override
    void notifyUpdate(IAslPool iAslPool, IAslPoolRecord iAslPoolRecord) {
        this.mListener.notifyUpdate(iAslPool, this.mKey, iAslPoolRecord);
    }

    @Override
    public int hashCode() {
        int n = 31;
        int n2 = super.hashCode();
        n2 = 31 * n2 + (this.mListener == null ? 0 : this.mListener.hashCode());
        return n2;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        AslPoolListenerSync aslPoolListenerSync = (AslPoolListenerSync)object;
        return !(this.mListener == null ? aslPoolListenerSync.mListener != null : !this.mListener.equals(aslPoolListenerSync.mListener));
    }

    @Override
    public String toString() {
        return super.getClass().getName();
    }
}

