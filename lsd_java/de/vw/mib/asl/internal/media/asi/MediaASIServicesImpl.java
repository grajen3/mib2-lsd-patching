/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.asi;

import de.esolutions.fw.comm.asi.hmisync.media.MediaBrowserSelectionData;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.vw.mib.asi.media.ASIMediaAdapter;
import de.vw.mib.asi.media.ASIMediaListener;
import de.vw.mib.asi.media.ASIMediaResponse;

public class MediaASIServicesImpl
extends ASIMediaAdapter {
    @Override
    public ASIMediaListener getASIMediaListener() {
        return super.getASIMediaListener();
    }

    @Override
    public void activate(MediaSourceSlot mediaSourceSlot, MediaBrowserSelectionData mediaBrowserSelectionData, ASIMediaResponse aSIMediaResponse) {
        super.activate(mediaSourceSlot, mediaBrowserSelectionData, aSIMediaResponse);
    }

    @Override
    public void executeDvdVideoCommand(int n, ASIMediaResponse aSIMediaResponse) {
        super.executeDvdVideoCommand(n, aSIMediaResponse);
    }

    @Override
    public void mix(boolean bl, ASIMediaResponse aSIMediaResponse) {
        super.mix(bl, aSIMediaResponse);
    }

    @Override
    public void pause(ASIMediaResponse aSIMediaResponse) {
        super.pause(aSIMediaResponse);
    }

    @Override
    public void playMoreFrom(long l, int n, ASIMediaResponse aSIMediaResponse) {
        super.playMoreFrom(l, n, aSIMediaResponse);
    }
}

