/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer;

import de.vw.mib.asl.api.pictureviewer.services.PictureViewerControlService;
import de.vw.mib.asl.internal.pictureviewer.HsmTargetPictureViewer;

class HsmTargetPictureViewer$1
implements PictureViewerControlService {
    private final /* synthetic */ HsmTargetPictureViewer this$0;

    HsmTargetPictureViewer$1(HsmTargetPictureViewer hsmTargetPictureViewer) {
        this.this$0 = hsmTargetPictureViewer;
    }

    @Override
    public void previousImage() {
        this.this$0.triggerObserver(0x42040040, null);
    }

    @Override
    public void nextImage() {
        this.this$0.triggerObserver(0x40040040, null);
    }
}

