/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration;

import de.vw.mib.configuration.SkinInformationReceiver;

public interface SkinInformationService {
    public static final int SKINMODE_DAY;
    public static final int SKINMODE_NIGHT;

    default public int getCurrentSkinMode() {
    }

    default public boolean isAmbientColorEnabled() {
    }

    default public int getAmbientColor() {
    }

    default public int getAmbientColor(int n) {
    }

    default public int getAmbientColor(int n, int n2, int n3) {
    }

    default public int getAmbientInteriorColor() {
    }

    default public void addSkinInformationReceiver(SkinInformationReceiver skinInformationReceiver) {
    }

    default public void removeSkinInformationReceiver(SkinInformationReceiver skinInformationReceiver) {
    }
}

