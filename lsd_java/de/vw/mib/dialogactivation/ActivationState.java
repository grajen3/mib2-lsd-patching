/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dialogactivation;

public final class ActivationState {
    private int id;
    private String name;
    public static final ActivationState INACTIVE = new ActivationState(0, "INACTIVE");
    public static final ActivationState ACTIVE = new ActivationState(1, "ACTIVE");

    private ActivationState(int n, String string) {
        this.id = n;
        this.name = string;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + this.id;
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
        ActivationState activationState = (ActivationState)object;
        return this.id == activationState.id;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(super.getClass().getName()).append(".").append(this.name);
        return stringBuffer.toString();
    }
}

