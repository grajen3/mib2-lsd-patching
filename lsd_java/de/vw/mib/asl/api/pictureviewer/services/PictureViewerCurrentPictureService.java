/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.pictureviewer.services;

import de.vw.mib.asl.api.pictureviewer.services.PictureViewerCurrentPictureUpdate;

public interface PictureViewerCurrentPictureService {
    default public void register(PictureViewerCurrentPictureUpdate pictureViewerCurrentPictureUpdate) {
    }

    default public void unregister(PictureViewerCurrentPictureUpdate pictureViewerCurrentPictureUpdate) {
    }
}

