/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.infotainmentrecorder.api.impl;

import de.vw.mib.asl.api.infotainmentrecorder.ASLInfotainmentrecorderAPI;
import de.vw.mib.asl.api.infotainmentrecorder.InfotainmentRecorderService;
import de.vw.mib.asl.internal.infotainmentrecorder.InfotainmentRecorderServiceImpl;
import de.vw.mib.asl.internal.infotainmentrecorder.InfotainmentRecorderServiceManager;

public class ASLInfotainmentrecorderAPIImpl
implements ASLInfotainmentrecorderAPI {
    private InfotainmentRecorderService infotainmentRecorderService = new InfotainmentRecorderServiceImpl();

    @Override
    public String getCurrentViewName() {
        return InfotainmentRecorderServiceManager.INSTANCE.getModel().getCurrentViewName();
    }

    @Override
    public InfotainmentRecorderService getInfotainmentRecorderService() {
        return this.infotainmentRecorderService;
    }
}

