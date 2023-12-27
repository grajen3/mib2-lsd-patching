/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock;

public class DsiKeyDescriptor {
    private final int dsiKey;
    private final int keyboardId;

    public DsiKeyDescriptor() {
        this.dsiKey = 0;
        this.keyboardId = 0;
    }

    public DsiKeyDescriptor(int n, int n2) {
        this.dsiKey = n;
        this.keyboardId = n2;
    }

    public int getDsiKey() {
        return this.dsiKey;
    }

    public int getKeyboardId() {
        return this.keyboardId;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + this.dsiKey;
        n2 = 31 * n2 + this.keyboardId;
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        DsiKeyDescriptor dsiKeyDescriptor = (DsiKeyDescriptor)object;
        if (this.dsiKey != dsiKeyDescriptor.dsiKey) {
            return false;
        }
        return this.keyboardId == dsiKeyDescriptor.keyboardId;
    }
}

