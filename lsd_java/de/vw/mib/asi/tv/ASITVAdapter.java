/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.tv;

import de.vw.mib.asi.tv.ASITV;
import de.vw.mib.asi.tv.ASITVListener;
import de.vw.mib.asi.tv.ASITVResponse;

public class ASITVAdapter
implements ASITV {
    protected ASITVListener listener;

    @Override
    public ASITVListener getASITVListener() {
        return this.listener;
    }

    @Override
    public void setASITVListener(ASITVListener aSITVListener) {
        this.listener = aSITVListener;
    }

    @Override
    public void setActiveStation(long l, ASITVResponse aSITVResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void logonToTV(ASITVResponse aSITVResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void logoffFromTV(ASITVResponse aSITVResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void sendPressedPanelKey(byte by, ASITVResponse aSITVResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void searchChannel(byte by, ASITVResponse aSITVResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void setTerminalMode(byte by, ASITVResponse aSITVResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }
}

