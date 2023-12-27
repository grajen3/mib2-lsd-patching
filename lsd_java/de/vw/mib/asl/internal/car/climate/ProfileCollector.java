/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate;

public class ProfileCollector {
    public int profileStyle;

    public ProfileCollector() {
        this.profileStyle = 1;
    }

    public ProfileCollector(int n) {
        this.profileStyle = n;
    }

    public ProfileCollector(ProfileCollector profileCollector) {
        this.profileStyle = profileCollector.profileStyle;
    }
}

