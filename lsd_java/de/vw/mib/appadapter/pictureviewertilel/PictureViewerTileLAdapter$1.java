/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.pictureviewertilel;

import de.vw.mib.appadapter.pictureviewertilel.PictureViewerTileLAdapter;
import de.vw.mib.asl.api.pictureviewer.services.PictureViewerControlService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;

class PictureViewerTileLAdapter$1
implements ASLComponentAPICallback {
    private final /* synthetic */ PictureViewerTileLAdapter this$0;

    PictureViewerTileLAdapter$1(PictureViewerTileLAdapter pictureViewerTileLAdapter) {
        this.this$0 = pictureViewerTileLAdapter;
    }

    @Override
    public void registered(Class clazz, Object object) {
        this.this$0.pictureViewerControlService = (PictureViewerControlService)object;
    }
}

