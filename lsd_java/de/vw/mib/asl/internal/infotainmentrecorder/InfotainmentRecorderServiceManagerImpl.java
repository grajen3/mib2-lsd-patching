/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.infotainmentrecorder;

import de.vw.mib.asl.internal.infotainmentrecorder.InfotainmentRecorderServiceManager;
import de.vw.mib.asl.internal.infotainmentrecorder.model.InfotainmenRecorderModel;

public class InfotainmentRecorderServiceManagerImpl
implements InfotainmentRecorderServiceManager {
    private final InfotainmenRecorderModel infotainmenRecorderModel = new InfotainmenRecorderModel();

    @Override
    public InfotainmenRecorderModel getModel() {
        return this.infotainmenRecorderModel;
    }
}

