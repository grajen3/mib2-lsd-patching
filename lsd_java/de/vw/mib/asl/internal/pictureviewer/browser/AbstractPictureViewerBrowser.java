/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer.browser;

import de.vw.mib.asl.api.filebrowser.ASLFilebrowserFactory;
import de.vw.mib.asl.api.filebrowser.FilebrowserSession;
import de.vw.mib.asl.api.filebrowser.FilebrowserSessionListener;
import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceInfo;
import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceList;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.pictureviewer.HsmTargetPictureViewer;
import de.vw.mib.asl.internal.pictureviewer.PictureSourceInfo;
import de.vw.mib.asl.internal.pictureviewer.PictureViewer;
import de.vw.mib.asl.internal.pictureviewer.PictureViewerHMINotifier;
import de.vw.mib.asl.internal.pictureviewer.PictureViewerHelper;
import de.vw.mib.asl.internal.pictureviewer.collector.BrowserCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractPictureViewerBrowser
implements ASLListElementFetcher,
FilebrowserSessionListener {
    public static final int INVALID_FILEBROWSER_SESSIONHANDLE;
    public static final int WINDOW_SIZE;
    private Path _path = null;
    private final HsmTargetPictureViewer _target;
    private final FilebrowserSession session;
    private final String _classname = super.getClass().getName();
    private PictureSourceInfo _activePictureBeforeBrowsing = null;

    public AbstractPictureViewerBrowser(HsmTargetPictureViewer hsmTargetPictureViewer) {
        this._target = hsmTargetPictureViewer;
        this.session = ASLFilebrowserFactory.getFilebrowserApi().getFilebrowserSession(this._target.getTargetId());
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".fetchItems(").append(n).append(", ").append(n2).append(")").log();
        }
        this.session.getViewWindow(n2, n);
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
    }

    protected AbstractASLHsmTarget getTarget() {
        return this._target;
    }

    protected PictureViewer getPictureViewer() {
        return this._target.getPictureViewer();
    }

    protected PictureViewerHMINotifier getHmiNotifier() {
        return this._target.getPictureViewer().getHmiNotifier();
    }

    public Path getPath() {
        return this._path;
    }

    public PictureSourceInfo getPictureSourceInfoBeforeBrowsing() {
        return this._activePictureBeforeBrowsing;
    }

    public void handleOpeningBrowser() {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".handleOpeningBrowser()").log();
        }
        this.openingBrowser();
    }

    public void handleClosingBrowser() {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".handleClosingBrowser()").log();
        }
        this._activePictureBeforeBrowsing = null;
        this.closingBrowser();
    }

    public void handleMoveFolderUp(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".handleMoveFolderUp() steps=").append(n).log();
        }
        switch (n) {
            case 0: {
                this.session.requestChangeToRootDirectory();
                break;
            }
            case 1: {
                this.session.requestChangeToParentDirectory(1);
                break;
            }
            case 2: {
                this.session.requestChangeToParentDirectory(2);
                break;
            }
            case 3: {
                this.session.requestChangeToParentDirectory(3);
                break;
            }
            default: {
                throw new GenericEventException("Unknown parameter id");
            }
        }
        this._target.getPictureViewer().getHmiNotifier().notifyFolderStateLoading();
    }

    public void handleOpenFolder(int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".handleOpenFolder() Opening folder with index ").append(n).log();
        }
        BrowserCollector browserCollector = (BrowserCollector)ListManager.getGenericASLList(1267).getRowItem(n);
        this._target.getPictureViewer().getHmiNotifier().notifyFolderStateLoading();
        this.session.requestOpenDirectoryRelative(browserCollector.getEntry());
    }

    @Override
    public void startResult(boolean bl, Path path) {
        if (bl) {
            this._path = path;
            if (this._target.isTraceEnabled()) {
                this._target.trace().append(this._classname).append(".startResult(): path=").append(this._path).log();
            }
            this.responseStartSessionResult(this._path);
        } else {
            this._target.warn().append(this._classname).append(".startResult(): failed").log();
            this.getHmiNotifier().notifyFolderStateEmpty();
        }
    }

    @Override
    public void updateSessionClosed() {
        this._target.trace("AbstractPictureViewerBrowser.updateSessionClosed()");
        this._path = null;
        this.resetFilebrowserSession();
    }

    public void handleSetContentFilterResult(boolean bl, Path path) {
        if (bl) {
            FileBrowserSourceInfo fileBrowserSourceInfo = this._target.getPictureViewer().getActiveSource();
            if (fileBrowserSourceInfo != null && fileBrowserSourceInfo.getActiveMedium() != null && path != null && path.getFolderNames() != null) {
                Path path2 = new Path(fileBrowserSourceInfo.getActiveMedium().mountPoint, path.getFolderNames());
                this.requestOpenDirectoryAbsoluteByPath(path2);
            } else {
                this.updateSetContentFilter();
                this.session.getFileCount();
            }
        }
    }

    public void handleActivateBrowsingSource(int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".handleActivateBrowsingSource(").append(n).append(")").log();
        }
        FileBrowserSourceInfo fileBrowserSourceInfo = this._target.getPictureViewer().getFileBrowserSourceInfoByIndex(n);
        this.browseSource(fileBrowserSourceInfo);
    }

    public void handleActivateSource(int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".handleActivateSource(").append(n).append(")").log();
        }
        FileBrowserSourceInfo fileBrowserSourceInfo = this._target.getPictureViewer().getFileBrowserSourceInfoByIndex(n);
        this.session.start(fileBrowserSourceInfo.getDevice());
    }

    public void handleDisplayPicture(int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".handleDisplayPicture() index=").append(n).log();
        }
        this.displayPicture(n);
    }

    @Override
    public void changeFolderResult(boolean bl, Path path) {
        if (bl) {
            if (this._target.isTraceEnabled()) {
                this._target.trace().append(this._classname).append(".handleUpdateCurrentDirectory() path=").append(path.toString()).log();
            }
            this._path = path;
            this.responseUpdateCurrentDirectory(path);
            this.session.getFileCount();
        } else {
            this._target.warn().append(this._classname).append(".handleUpdateCurrentDirectory() failed").log();
        }
    }

    @Override
    public void responseOpenDirectoryAbsoluteByPath(boolean bl, Path path) {
        if (bl) {
            if (this._target.isTraceEnabled()) {
                this._target.trace().append(this._classname).append(".handleOpenDirectoryAbsoluteByPath() path=").append(path.toString()).log();
            }
            this._path = path;
            this.responseUpdateCurrentDirectory(path);
            this.session.getFileCount();
        } else {
            this._target.warn().append(this._classname).append(".handleOpenDirectoryAbsoluteByPath() failed").log();
        }
    }

    public void handleUpdateSourceList(FileBrowserSourceList fileBrowserSourceList) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".handleUpdateSourceList() ").append(fileBrowserSourceList.count()).append(" entries: ").append(fileBrowserSourceList).log();
        }
        this.updateSourceList(fileBrowserSourceList);
        if (this.getPictureViewer().checkIfCurrentActiveSourceHasBeenRemoved()) {
            this.resetFilebrowserSession();
        }
        this.getPictureViewer().checkPictureSource();
    }

    @Override
    public void getFileCountResult(boolean bl, int n) {
        if (bl) {
            int n2 = n;
            if (this._target.isTraceEnabled()) {
                this._target.trace().append(this._classname).append(".getFileCountResult() ").append(n2).append(" entries").log();
            }
            this.updateNumberOfEntries(n2);
        } else {
            this._target.warn().append(this._classname).append(".getFileCountResult() failed").log();
            this.updateNumberOfEntries(0);
        }
    }

    @Override
    public void getViewWindowResult(boolean bl, int n, BrowsedFileSet browsedFileSet) {
        if (bl) {
            if (this._target.isTraceEnabled()) {
                this._target.trace().append(this._classname).append(".getViewWindowResult() ").append(browsedFileSet.files.length).append(" list entries starting at index ").append(n).log();
            }
            this.updateEntries(n, browsedFileSet);
        } else {
            this._target.warn().append(this._classname).append(".getViewWindowResult() failed").log();
        }
    }

    @Override
    public void getResourceLocatorsResult(boolean bl, ResourceLocator[] resourceLocatorArray) {
        if (bl) {
            if (this._target.isTraceEnabled()) {
                this._target.trace().append(this._classname).append(".getResourceLocatorsResult() ").append(resourceLocatorArray.length).append(" entries, first url=").append(resourceLocatorArray[0].getUrl()).log();
            }
            this.reponseFullyQualifiedName(resourceLocatorArray[0]);
        } else {
            this._target.warn().append(this._classname).append(".getResourceLocatorsResult() failed").log();
        }
    }

    private void requestStartSession(FileBrowserSourceInfo fileBrowserSourceInfo, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("partition must be known here!");
        }
        this.session.start(fileBrowserSourceInfo.getDevice().getMedium(n));
    }

    public void requestStopSession() {
        this.session.stop();
    }

    protected void requestSetContentFilter() {
        this.session.setContentFilter(1);
    }

    private boolean browseSource(FileBrowserSourceInfo fileBrowserSourceInfo) {
        if (fileBrowserSourceInfo == null) {
            this._target.warn().append(this._classname).append(".browseSource(): Invalid sourceInfo").log();
            return false;
        }
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".browseSource(sourceId=").append(fileBrowserSourceInfo.getSourceId()).append(") hmi source id=").append(PictureViewerHelper.getHMISourceIdFromFileBrowserSourceId(fileBrowserSourceInfo.getSourceId())).log();
        }
        this.storePicture();
        this.session.start(fileBrowserSourceInfo.getDevice());
        return true;
    }

    public void storePicture() {
        if (this._target.getPictureViewer().getSettings().getHMISourceId() != 0) {
            this._activePictureBeforeBrowsing = this._target.getPictureViewer().getSettings().getPictureSourceInfo();
        }
    }

    public void activateSource(FileBrowserSourceInfo fileBrowserSourceInfo, int n) {
        if (this._target.isTraceEnabled()) {
            String string = fileBrowserSourceInfo.getActiveMedium() != null ? fileBrowserSourceInfo.getActiveMedium().mountPoint : "(active medium null)";
            this._target.trace().append(this._classname).append(".activateSource(sourceId=").append(fileBrowserSourceInfo.getSourceId()).append(") hmi source id=").append(PictureViewerHelper.getHMISourceIdFromFileBrowserSourceId(fileBrowserSourceInfo.getSourceId())).append("  active.mountPoint=").append(string).log();
        }
        this.requestStartSession(fileBrowserSourceInfo, n);
    }

    public void requestFullyQualifiedName(BrowsedFile browsedFile) {
        if (browsedFile == null) {
            this._target.warn().append(this._classname).append(".requestFullyQualifiedName() Invalid entry.").log();
            return;
        }
        BrowsedFileSet browsedFileSet = new BrowsedFileSet(this._path, new BrowsedFile[]{browsedFile});
        this.session.getResourceLocators(browsedFileSet);
    }

    private void requestOpenDirectoryAbsoluteByPath(Path path) {
        this.session.requestOpenDirectoryAbsoluteByPath(path);
        this._target.getPictureViewer().getHmiNotifier().notifyFolderStateLoading();
    }

    protected abstract void updateSetContentFilter() {
    }

    protected abstract void openingBrowser() {
    }

    protected abstract void closingBrowser() {
    }

    protected abstract void displayPicture(int n) {
    }

    protected abstract void resetFilebrowserSession() {
    }

    protected abstract void responseStartSessionResult(Path path) {
    }

    protected abstract void responseUpdateCurrentDirectory(Path path) {
    }

    @Override
    public abstract void updateSourceList(FileBrowserSourceList fileBrowserSourceList) {
    }

    protected abstract void updateNumberOfEntries(int n) {
    }

    protected abstract void updateEntries(int n, BrowsedFileSet browsedFileSet) {
    }

    protected abstract void reponseFullyQualifiedName(ResourceLocator resourceLocator) {
    }

    @Override
    public void responseStopSession() {
        this.updateSessionClosed();
    }

    @Override
    public void responseSetContentFilter(boolean bl) {
        this.handleSetContentFilterResult(bl, null);
    }

    public boolean receive(EventGeneric eventGeneric) {
        return this.session.dispatch(eventGeneric, this);
    }
}

