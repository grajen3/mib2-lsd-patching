/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration;

public interface SkinInformationReceiver {
    default public void receiveCurrentSkinMode(int n) {
    }

    default public void receiveAmbientColorEnabled(boolean bl) {
    }

    default public void receiveAmbientColor(int n) {
    }

    default public void receiveAmbientHmiAndSrgbColor(String string, String string2) {
    }
}

