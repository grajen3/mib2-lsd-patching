/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.tv;

import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.tv.ASITVListener;
import de.vw.mib.asi.tv.ASITVResponse;

public interface ASITV
extends ASIService {
    default public ASITVListener getASITVListener() {
    }

    default public void setASITVListener(ASITVListener aSITVListener) {
    }

    default public void setActiveStation(long l, ASITVResponse aSITVResponse) {
    }

    default public void logonToTV(ASITVResponse aSITVResponse) {
    }

    default public void logoffFromTV(ASITVResponse aSITVResponse) {
    }

    default public void sendPressedPanelKey(byte by, ASITVResponse aSITVResponse) {
    }

    default public void searchChannel(byte by, ASITVResponse aSITVResponse) {
    }

    default public void setTerminalMode(byte by, ASITVResponse aSITVResponse) {
    }
}

