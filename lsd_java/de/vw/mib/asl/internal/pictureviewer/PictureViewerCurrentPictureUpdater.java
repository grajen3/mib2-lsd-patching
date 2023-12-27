/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer;

import de.vw.mib.asl.api.pictureviewer.services.PictureViewerCurrentPictureService;
import de.vw.mib.asl.api.pictureviewer.services.PictureViewerCurrentPictureUpdate;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import java.util.HashMap;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;

public class PictureViewerCurrentPictureUpdater
implements PictureViewerCurrentPictureService {
    private final HashMap listeners = new HashMap();
    private ResourceLocator currentPicture;

    public void onCurrentPictureChanged(ResourceLocator resourceLocator) {
        this.currentPicture = resourceLocator;
        Iterator iterator = this.listeners.values().iterator();
        while (iterator.hasNext()) {
            PictureViewerCurrentPictureUpdate pictureViewerCurrentPictureUpdate = (PictureViewerCurrentPictureUpdate)iterator.next();
            pictureViewerCurrentPictureUpdate.onCurrentPictureChanged(resourceLocator);
        }
    }

    @Override
    public void register(PictureViewerCurrentPictureUpdate pictureViewerCurrentPictureUpdate) {
        PictureViewerCurrentPictureUpdate pictureViewerCurrentPictureUpdate2 = (PictureViewerCurrentPictureUpdate)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAsyncServiceFactory().create(pictureViewerCurrentPictureUpdate);
        this.listeners.put(pictureViewerCurrentPictureUpdate, pictureViewerCurrentPictureUpdate2);
        pictureViewerCurrentPictureUpdate2.onCurrentPictureChanged(this.currentPicture);
    }

    @Override
    public void unregister(PictureViewerCurrentPictureUpdate pictureViewerCurrentPictureUpdate) {
        this.listeners.remove(pictureViewerCurrentPictureUpdate);
    }
}

