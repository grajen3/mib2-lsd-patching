/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer.browser;

import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceInfo;
import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceList;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.pictureviewer.HsmTargetPictureViewer;
import de.vw.mib.asl.internal.pictureviewer.PictureViewer$PictureFile;
import de.vw.mib.asl.internal.pictureviewer.PictureViewerHelper;
import de.vw.mib.asl.internal.pictureviewer.browser.AbstractPictureViewerBrowser;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.Arrays;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.global.ResourceLocator;

public class HMIPictureViewerBrowser
extends AbstractPictureViewerBrowser {
    private final String _classname = super.getClass().getName();
    private int _followModeIndex = -1;

    public HMIPictureViewerBrowser(HsmTargetPictureViewer hsmTargetPictureViewer) {
        super(hsmTargetPictureViewer);
        ListManager.getGenericASLList(1267).enableWindowing(this, 10, 0);
        ListManager.getGenericASLList(1267).setColumn4ObjectId(99);
    }

    private Path getDisplayedDirectory() {
        Path path = null;
        FileBrowserSourceInfo fileBrowserSourceInfo = this.getPictureViewer().getActiveSource();
        if (fileBrowserSourceInfo != null && fileBrowserSourceInfo.getActiveMedium() != null && this.getPath() != null) {
            String string = "";
            if ((fileBrowserSourceInfo.getActiveMedium().getFlags() & 0x8000) == 0) {
                string = fileBrowserSourceInfo.getActiveMedium().name;
            }
            String[] stringArray = PictureViewerHelper.concat(new String[]{string}, this.getPath().getFolderNames());
            path = new Path(fileBrowserSourceInfo.getActiveMedium().mountPoint, stringArray);
        } else {
            path = new Path();
        }
        return path;
    }

    private void notifyDisplayedFolder() {
        this.getHmiNotifier().notifyDisplayedFolder(this.getDisplayedDirectory());
    }

    @Override
    protected void updateSetContentFilter() {
        this._followModeIndex = -1;
    }

    @Override
    protected void openingBrowser() {
    }

    @Override
    protected void closingBrowser() {
    }

    @Override
    protected void displayPicture(int n) {
        this.getPictureViewer().displayPicture(n);
    }

    @Override
    protected void resetFilebrowserSession() {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".resetFilebrowserSession()").log();
        }
        this.getPictureViewer().resetSource();
        this.notifyDisplayedFolder();
    }

    @Override
    protected void responseStartSessionResult(Path path) {
        try {
            this.getPictureViewer().setActiveFilebrowserSession(path);
        }
        catch (Exception exception) {
            this.getTarget().warn().append(this._classname).append(".handleSetContentFilterResult() path=").append(path == null ? "<null>" : path.toString()).append(' ').attachThrowable(exception).log();
        }
        this.notifyDisplayedFolder();
        this.requestSetContentFilter();
    }

    @Override
    protected void responseUpdateCurrentDirectory(Path path) {
        this._followModeIndex = -1;
        this.getHmiNotifier().notifyActiveBrowserInfoListItem(-1);
        this.notifyDisplayedFolder();
    }

    @Override
    public void updateSourceList(FileBrowserSourceList fileBrowserSourceList) {
        this.getPictureViewer().setSourceList(fileBrowserSourceList);
    }

    @Override
    protected void updateNumberOfEntries(int n) {
        this.getPictureViewer().setNumberOfEntries(n);
        if (0 == n) {
            this.getHmiNotifier().notifyFolderStateEmpty();
        } else {
            this.getHmiNotifier().notifyFolderStateNormal();
        }
    }

    @Override
    protected void updateEntries(int n, BrowsedFileSet browsedFileSet) {
        this.getPictureViewer().setDirectoryEntries(n, browsedFileSet);
        this.updateFollowModeIndex();
    }

    private void updateFollowModeIndex() {
        PictureViewer$PictureFile pictureViewer$PictureFile;
        if (this._followModeIndex == -1 && (pictureViewer$PictureFile = this.getPictureViewer().getPictureFile()).isValid() && (this.getPictureSourceInfoBeforeBrowsing() == null || this.getPictureViewer().getActiveSource().getSourceId() == this.getPictureSourceInfoBeforeBrowsing().getHMISourceId()) && this.getPath().getFolderNames() != null) {
            Object[] objectArray;
            Object[] objectArray2 = this.getPath().getFolderNames();
            if (Arrays.equals(objectArray2, objectArray = pictureViewer$PictureFile.getPath())) {
                this._followModeIndex = pictureViewer$PictureFile.getElementIndex();
                this.getHmiNotifier().notifyActiveBrowserInfoListItem(this._followModeIndex);
            } else if (objectArray2.length < objectArray.length) {
                Object object = null;
                if (Util.isNullOrEmpty(objectArray2)) {
                    object = objectArray[0];
                } else {
                    for (int i2 = 0; i2 < objectArray2.length; ++i2) {
                        object = null;
                        if (!((String)objectArray2[i2]).equals(objectArray[i2])) break;
                        object = objectArray[i2 + 1];
                    }
                }
                if (!Util.isNullOrEmpty((String)object)) {
                    this._followModeIndex = this.getPictureViewer().getIndexByName((String)object);
                    this.getHmiNotifier().notifyActiveBrowserInfoListItem(this._followModeIndex);
                }
            }
        }
    }

    @Override
    protected void reponseFullyQualifiedName(ResourceLocator resourceLocator) {
        this.getHmiNotifier().notifyCurrentImageResourceLocator(resourceLocator);
        this.getHmiNotifier().closeBrowser();
        ServiceManager.imageManager.getExifInfoFromResource(resourceLocator, 3, new int[]{0, 2, 4, 1, 3, 5}, this.getPictureViewer().getImageLoadingListener());
    }
}

