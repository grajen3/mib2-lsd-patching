/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.pictureviewer;

import de.vw.mib.appadapter.pictureviewer.PictureViewerAdapter;
import generated.de.vw.mib.appadapter.pictureviewer.GesturesModelApiService;

class PictureViewerAdapter$1
implements GesturesModelApiService {
    private final /* synthetic */ PictureViewerAdapter this$0;

    PictureViewerAdapter$1(PictureViewerAdapter pictureViewerAdapter) {
        this.this$0 = pictureViewerAdapter;
    }

    @Override
    public void _mda_showSpaceGestureRegisteredAnimation(int n, boolean bl) {
        this.this$0.showSpaceGestureRegisteredAnimation(n, bl);
    }

    @Override
    public void _mda_showSpaceGestureAvailableAnimation(boolean bl) {
        this.this$0.showSpaceGestureAvailableAnimation(bl);
    }
}

