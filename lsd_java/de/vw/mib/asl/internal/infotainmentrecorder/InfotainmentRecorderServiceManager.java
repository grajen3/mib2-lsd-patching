/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.infotainmentrecorder;

import de.vw.mib.asl.internal.infotainmentrecorder.InfotainmentRecorderServiceManagerImpl;
import de.vw.mib.asl.internal.infotainmentrecorder.model.InfotainmenRecorderModel;

public interface InfotainmentRecorderServiceManager {
    public static final InfotainmentRecorderServiceManager INSTANCE = new InfotainmentRecorderServiceManagerImpl();

    default public InfotainmenRecorderModel getModel() {
    }
}

