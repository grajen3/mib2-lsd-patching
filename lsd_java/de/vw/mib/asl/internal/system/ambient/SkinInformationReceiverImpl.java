/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.ambient;

import de.vw.mib.asl.internal.system.has.SystemHasBridge;
import de.vw.mib.configuration.SkinInformationReceiver;

public class SkinInformationReceiverImpl
implements SkinInformationReceiver {
    private final SystemHasBridge systemHasBridge;

    public SkinInformationReceiverImpl(SystemHasBridge systemHasBridge) {
        this.systemHasBridge = systemHasBridge;
    }

    @Override
    public void receiveCurrentSkinMode(int n) {
    }

    @Override
    public void receiveAmbientColorEnabled(boolean bl) {
    }

    @Override
    public void receiveAmbientColor(int n) {
    }

    @Override
    public void receiveAmbientHmiAndSrgbColor(String string, String string2) {
        this.systemHasBridge.setPropertyColorHMI(string);
        this.systemHasBridge.setPropertyColorSRGB(string2);
    }
}

