/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.pictureviewertiles;

import de.vw.mib.appadapter.pictureviewertiles.PictureViewerTileSAdapter;
import generated.de.vw.mib.appadapter.pictureviewertiles.MainModelApiService;

class PictureViewerTileSAdapter$3
implements MainModelApiService {
    private final /* synthetic */ PictureViewerTileSAdapter this$0;

    PictureViewerTileSAdapter$3(PictureViewerTileSAdapter pictureViewerTileSAdapter) {
        this.this$0 = pictureViewerTileSAdapter;
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

