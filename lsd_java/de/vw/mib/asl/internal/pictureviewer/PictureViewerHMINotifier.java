/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.pictureviewer.PictureViewer;
import de.vw.mib.asl.internal.pictureviewer.PictureViewerCurrentPictureUpdater;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.global.ResourceLocator;

public final class PictureViewerHMINotifier {
    private final PictureViewer _pictureViewer;
    private final String _classname = super.getClass().getName();
    private final PictureViewerCurrentPictureUpdater _pictureViewerCurrentPictureUpdater;
    static /* synthetic */ Class class$de$vw$mib$asl$api$pictureviewer$services$PictureViewerCurrentPictureService;

    PictureViewerHMINotifier(PictureViewer pictureViewer) {
        this._pictureViewer = pictureViewer;
        this._pictureViewerCurrentPictureUpdater = new PictureViewerCurrentPictureUpdater();
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$pictureviewer$services$PictureViewerCurrentPictureService == null ? (class$de$vw$mib$asl$api$pictureviewer$services$PictureViewerCurrentPictureService = PictureViewerHMINotifier.class$("de.vw.mib.asl.api.pictureviewer.services.PictureViewerCurrentPictureService")) : class$de$vw$mib$asl$api$pictureviewer$services$PictureViewerCurrentPictureService, this._pictureViewerCurrentPictureUpdater);
    }

    public void notifyActiveBrowserInfoListItem(int n) {
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            ServiceManager.logger2.trace(128).append(this._classname).append(".notifyActiveBrowserInfoListItem(").append(n).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(3101, n);
    }

    protected void notifyDefaultZoomLevel(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1255, n);
    }

    protected void notifySlideshowTimer(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1265, n);
    }

    protected void notifySlideshowRepeatState(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1264, bl);
    }

    public void notifyCurrentImageResourceLocator(ResourceLocator resourceLocator) {
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            ServiceManager.logger2.trace(128).append(this._classname).append(".notifyCurrentImageResourceLocator(").append(String.valueOf(resourceLocator)).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(1896486656, resourceLocator != PictureViewer.INVALID_RESOURCELOCATOR);
        ServiceManager.aslPropertyManager.valueChangedResourceLocator(1257, resourceLocator);
        this._pictureViewerCurrentPictureUpdater.onCurrentPictureChanged(resourceLocator);
    }

    public void notifyDisplayedFolder(Path path) {
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            ServiceManager.logger2.trace(128).append(this._classname).append(".notifyDisplayedFolder(").append(String.valueOf(path)).append(")").log();
        }
        if (path != null && path.getFolderNames() != null && path.getFolderNames().length > 0) {
            ServiceManager.aslPropertyManager.valueChangedString(1261, path.getFolderNames()[path.getFolderNames().length - 1]);
            ServiceManager.aslPropertyManager.valueChangedInteger(1260, path.getFolderNames().length - 1);
        } else {
            ServiceManager.aslPropertyManager.valueChangedString(1261, "");
            ServiceManager.aslPropertyManager.valueChangedInteger(1260, 0);
        }
    }

    public void notifyCurrentPictureSource(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1258, n);
        this.notifyCurrentBrowsingSource(n);
        this.notifyIndexOfParentElement(n);
        boolean bl = n > 0 ? !this._pictureViewer.getTarget().isLastSource() : false;
        this.notifyOpenBrowserAfterSourceChange(bl);
    }

    public void notifyCurrentBrowsingSource(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(3514, n);
    }

    public void notifyIndexOfParentElement(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(3515, n);
    }

    protected void notifyEndOfFileList() {
        if (ServiceManager.logger2.isTraceEnabled(128)) {
            ServiceManager.logger2.trace(128).append(this._classname).append(".notifyEndOfFileList()").log();
        }
        this._pictureViewer.getTarget().sendHMIEvent(200);
    }

    public void notifyPictureContainsGpsInfo(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1259, bl);
    }

    public void closeBrowser() {
        this._pictureViewer.getTarget().sendHMIEvent(199);
    }

    public void notifyFolderStateEmpty() {
        ServiceManager.aslPropertyManager.valueChangedInteger(1256, 2);
    }

    public void notifyFolderStateLoading() {
        ServiceManager.aslPropertyManager.valueChangedInteger(1256, 1);
    }

    public void notifyFolderStateNormal() {
        ServiceManager.aslPropertyManager.valueChangedInteger(1256, 0);
    }

    public void notifyOpenBrowserAfterSourceChange(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3176, bl);
    }

    public void notifySlideShowMode(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1263, n);
    }

    public void notifyLoadingState(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1262, n);
    }

    public void notifyPictureDisplayed(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1896486656, bl);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

