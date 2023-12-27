/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.pictureviewertilel;

import de.vw.mib.appadapter.pictureviewertilel.PictureViewerTileLAdapter;
import generated.de.vw.mib.appadapter.pictureviewertilel.MainModelApiService;

class PictureViewerTileLAdapter$3
implements MainModelApiService {
    private final /* synthetic */ PictureViewerTileLAdapter this$0;

    PictureViewerTileLAdapter$3(PictureViewerTileLAdapter pictureViewerTileLAdapter) {
        this.this$0 = pictureViewerTileLAdapter;
    }

    @Override
    public void _mda_prevImage() {
        if (this.this$0.pictureViewerControlService != null) {
            this.this$0.pictureViewerControlService.previousImage();
        }
    }

    @Override
    public void _mda_nextImage() {
        if (this.this$0.pictureViewerControlService != null) {
            this.this$0.pictureViewerControlService.nextImage();
        }
    }
}

