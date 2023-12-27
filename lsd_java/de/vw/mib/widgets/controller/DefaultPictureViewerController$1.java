/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultPictureViewerController;

class DefaultPictureViewerController$1
implements Runnable {
    private final /* synthetic */ DefaultPictureViewerController this$0;

    DefaultPictureViewerController$1(DefaultPictureViewerController defaultPictureViewerController) {
        this.this$0 = defaultPictureViewerController;
    }

    @Override
    public void run() {
        this.this$0.fire_requestNextImage();
    }
}

