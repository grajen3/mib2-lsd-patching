/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.model;

public class Profile {
    private final String name;
    private boolean isActive;

    public Profile(String string) {
        this.name = string;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean bl) {
        this.isActive = bl;
    }

    public String getName() {
        return this.name;
    }
}

