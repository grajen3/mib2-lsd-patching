/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer;

import de.vw.mib.asl.api.devicehandling.ASLDeviceHandlingFactory;
import de.vw.mib.asl.api.devicehandling.clients.DeviceAslList;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceInfo;
import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceList;
import de.vw.mib.asl.internal.pictureviewer.BufferedAslList;
import de.vw.mib.asl.internal.pictureviewer.HsmTargetPictureViewer;
import de.vw.mib.asl.internal.pictureviewer.IndexedList;
import de.vw.mib.asl.internal.pictureviewer.PictureSourceInfo;
import de.vw.mib.asl.internal.pictureviewer.PictureViewer$1;
import de.vw.mib.asl.internal.pictureviewer.PictureViewer$PictureFile;
import de.vw.mib.asl.internal.pictureviewer.PictureViewerHMINotifier;
import de.vw.mib.asl.internal.pictureviewer.PictureViewerHelper;
import de.vw.mib.asl.internal.pictureviewer.PictureViewerSettings;
import de.vw.mib.asl.internal.pictureviewer.collector.BrowserCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.graphics.image.ImageLoadingListener;
import de.vw.mib.util.Util;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.global.ResourceLocator;

public final class PictureViewer {
    private final HsmTargetPictureViewer _target;
    private final PictureViewerHMINotifier _hmiNotifier;
    private final PictureViewerSettings _settings;
    private FileBrowserSourceList _sourceList = null;
    private FileBrowserSourceInfo _activeSource = null;
    private boolean _displayOperationPending = false;
    private static final BrowserCollector[] BROWSER_LIST_WINDOW = new BrowserCollector[10];
    private boolean _slideShowOn = false;
    private final PictureViewer$PictureFile _activePictureFile;
    private final String _classname = super.getClass().getName();
    private final ImageLoadingListener _imageLoadingListener = new PictureViewer$1(this);
    private final IndexedList indexedList;
    private final BufferedAslList browserInfoList = new BufferedAslList(1267);
    public static final ResourceLocator INVALID_RESOURCELOCATOR = new ResourceLocator();

    public ImageLoadingListener getImageLoadingListener() {
        return this._imageLoadingListener;
    }

    protected void updateGPSInformation(boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".updateGPSInformation(").append(bl).append(")").log();
        }
        this.getHmiNotifier().notifyPictureContainsGpsInfo(bl);
    }

    PictureViewer(HsmTargetPictureViewer hsmTargetPictureViewer) {
        this._target = hsmTargetPictureViewer;
        this._hmiNotifier = new PictureViewerHMINotifier(this);
        this._settings = new PictureViewerSettings();
        this._activePictureFile = new PictureViewer$PictureFile(this);
        this.indexedList = new IndexedList(1266, DeviceFilter.REMOVABLE);
        ASLDeviceHandlingFactory.getDeviceHandlingApi().register(this.indexedList);
        ASLDeviceHandlingFactory.getDeviceHandlingApi().register(new DeviceAslList(3516, DeviceFilter.REMOVABLE));
    }

    public int getListSize() {
        return this.browserInfoList.getSize();
    }

    protected void displaySettings() {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".displaySettings(): ZoomLevel=").append(this.getSettings().getZoomLevel()).append(", SlideshowTimer=").append(this.getSettings().getSlideshowTimer()).append(", SlideshowRepeatState=").append(this.getSettings().getSlideshowRepeatState()).log();
        }
        this.getHmiNotifier().notifyDefaultZoomLevel(this.getSettings().getZoomLevel());
        this.getHmiNotifier().notifySlideshowTimer(this.getSettings().getSlideshowTimer());
        this.getHmiNotifier().notifySlideshowRepeatState(this.getSettings().getSlideshowRepeatState());
    }

    public PictureViewer$PictureFile getPictureFile() {
        return this._activePictureFile;
    }

    public FileBrowserSourceInfo getActiveSource() {
        return this._activeSource;
    }

    private void setActiveSource(FileBrowserSourceInfo fileBrowserSourceInfo) {
        if (this._activeSource != null) {
            this._activeSource.getDevice().tags().remove(-1863904256);
        }
        this._activeSource = fileBrowserSourceInfo;
        this._activeSource.getDevice().tags().put(-1863904256, Boolean.TRUE);
        int n = this.getActiveHMISourceId();
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".setActiveSource(): PictureViewer source activated [hmi source id=").append(n).append("]").log();
        }
        this.getHmiNotifier().notifyCurrentPictureSource(n);
        this.getHmiNotifier().notifyFolderStateLoading();
    }

    public void setActiveFilebrowserSession(Path path) {
        FileBrowserSourceInfo fileBrowserSourceInfo = this._sourceList.getSourceByMountPoint(path.mountPoint);
        for (int i2 = fileBrowserSourceInfo.getMediaInfos().length - 1; i2 >= 0; --i2) {
            if (!fileBrowserSourceInfo.getMediaInfos()[i2].mountPoint.equals(path.mountPoint)) continue;
            fileBrowserSourceInfo.setActiveMedium(i2);
            break;
        }
        this.setActiveSource(fileBrowserSourceInfo);
    }

    public void resetSource() {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".resetSource()").log();
        }
        this.getHmiNotifier().notifyCurrentPictureSource(0);
        this.browserInfoList.setSize(0);
        this.getHmiNotifier().notifyCurrentImageResourceLocator(INVALID_RESOURCELOCATOR);
        this._activePictureFile.reset();
    }

    public void setNumberOfEntries(int n) {
        this.browserInfoList.setSize(0);
        if (n > 0) {
            this.browserInfoList.setSize(n);
        }
    }

    public void setDirectoryEntries(int n, BrowsedFileSet browsedFileSet) {
        Object[] objectArray = browsedFileSet.files.length == BROWSER_LIST_WINDOW.length ? BROWSER_LIST_WINDOW : new BrowserCollector[browsedFileSet.files.length];
        for (int i2 = 0; i2 < browsedFileSet.files.length; ++i2) {
            BrowserCollector browserCollector = new BrowserCollector();
            browserCollector.setEntry(browsedFileSet.files[i2]);
            objectArray[i2] = browserCollector;
        }
        this.browserInfoList.updateListItems(n, objectArray);
        if (this._displayOperationPending) {
            this.displayActivePicture();
        }
    }

    public int getIndexByName(String string) {
        if (!Util.isNullOrEmpty(string)) {
            for (int i2 = 0; i2 < this.browserInfoList.getItemCount(); ++i2) {
                BrowserCollector browserCollector;
                Object object = this.browserInfoList.getRowItemCacheOnly(i2);
                if (!this.browserInfoList.isValidItem(object) || (browserCollector = (BrowserCollector)object) == null || !browserCollector.getEntry().getFilename().equals(string)) continue;
                return i2;
            }
        }
        return -1;
    }

    private int getNextEntryIndex(int n, int n2) {
        if (Math.abs(n2) != 1) {
            throw new IllegalArgumentException("direction must be +/-1");
        }
        int n3 = -1;
        int n4 = this.browserInfoList.getSize();
        if (n4 > 0 && ((n3 = n + n2) < 0 || n3 >= n4)) {
            n3 = PictureViewer.mod(n3, n4);
            this.getHmiNotifier().notifyEndOfFileList();
            if (this._slideShowOn && !this.getSettings().getSlideshowRepeatState()) {
                n3 = -1;
            }
        }
        if (n3 != -1) {
            Object object = this.browserInfoList.getRowItem(n3);
            if (!this.browserInfoList.isValidItem(object)) {
                this._displayOperationPending = true;
            } else {
                this._displayOperationPending = false;
                BrowserCollector browserCollector = (BrowserCollector)object;
                if (!PictureViewerHelper.isPictureFile(browserCollector)) {
                    n3 = this.getNextEntryIndex(n3, n2);
                }
            }
        }
        return n3;
    }

    private boolean setActiveEntryIndex(int n) {
        boolean bl = false;
        if (-1 < n && n < this.browserInfoList.getSize()) {
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append(this._classname).append(".setActiveEntryIndex(").append(n).append(")").log();
            }
            this._activePictureFile.setElementIndex(n);
            bl = true;
        } else if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".setActiveEntryIndex(").append(n).append("): Out of range").log();
        }
        return bl;
    }

    public void handleDisplayPreviousPicture() {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".handleDisplayPreviousPicture()").log();
        }
        if (this.setActiveEntryIndex(this.getNextEntryIndex(this._activePictureFile.getElementIndex(), -1))) {
            this.displayActivePicture();
        }
    }

    public void handleDisplayNextPicture() {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".handleDisplayNextPicture()").log();
        }
        if (this.setActiveEntryIndex(this.getNextEntryIndex(this._activePictureFile.getElementIndex(), 1))) {
            this.displayActivePicture();
        }
    }

    public boolean displayPicture(int n) {
        if (n != -1) {
            if (n >= this.browserInfoList.getSize()) {
                this.getTarget().warn().append(this._classname).append(".displayPicture(").append(n).append(") picture index > list size").log();
                return false;
            }
            Object object = this.browserInfoList.getRowItem(n);
            this.prefetch(n);
            if (!this.browserInfoList.isValidItem(object)) {
                this._displayOperationPending = true;
                return true;
            }
            this._displayOperationPending = false;
            BrowserCollector browserCollector = (BrowserCollector)object;
            if (PictureViewerHelper.isPictureFile(browserCollector)) {
                if (this.setActiveEntryIndex(n)) {
                    this.displayActivePicture();
                    return true;
                }
                this.getTarget().warn().append(this._classname).append(".displayPicture(").append(n).append(") activate picture file failed").log();
                return false;
            }
            this.getTarget().warn().append(this._classname).append(".displayPicture(").append(n).append(") no picture file").log();
            return false;
        }
        this.getTarget().warn().append(this._classname).append(".displayPicture(").append(n).append(") Invalid picture index").log();
        return false;
    }

    private static int mod(int n, int n2) {
        return (n % n2 + n2) % n2;
    }

    private void prefetch(int n) {
        this.browserInfoList.getRowItem(PictureViewer.mod(n + 5, this.browserInfoList.getSize()));
        this.browserInfoList.getRowItem(PictureViewer.mod(n - 5, this.browserInfoList.getSize()));
    }

    protected void displayActivePicture() {
        if (-1 < this._activePictureFile.getElementIndex() && this._activePictureFile.getElementIndex() < this.browserInfoList.getSize()) {
            Object object = this.browserInfoList.getRowItem(this._activePictureFile.getElementIndex());
            this.prefetch(this._activePictureFile.getElementIndex());
            if (!this.browserInfoList.isValidItem(object)) {
                this._displayOperationPending = true;
            } else {
                this._displayOperationPending = false;
                BrowserCollector browserCollector = (BrowserCollector)object;
                if (PictureViewerHelper.isPictureFile(browserCollector)) {
                    if (this.getTarget().isTraceEnabled()) {
                        this.getTarget().trace().append(this._classname).append(".displayActivePicture(): Requesting fully qualified name of entry at index ").append(this._activePictureFile.getElementIndex()).log();
                    }
                    if (this._target.getBrowser().getPath() != null) {
                        this._activePictureFile.setPath(this._target.getBrowser().getPath().getFolderNames());
                    } else {
                        this.getTarget().warn().append(this._classname).append(".displayPicture(").append(this._activePictureFile.getElementIndex()).append(") Picture path contains no folders").log();
                    }
                    this.getHmiNotifier().notifyPictureContainsGpsInfo(false);
                    this.getTarget().getBrowser().requestFullyQualifiedName(browserCollector.getEntry());
                    this._settings.setPicture(new PictureSourceInfo(this.getActiveHMISourceId(), this._activeSource.getActiveMedium().getUniqueMediaID(), this._target.getBrowser().getPath().getFolderNames(), this._activePictureFile.getElementIndex()));
                }
            }
        }
    }

    public FileBrowserSourceInfo checkFileBrowserSourceInfo(int n, String string) {
        FileBrowserSourceInfo fileBrowserSourceInfo = this._sourceList.getSourceById(PictureViewerHelper.getFileBrowserSourceIdFromHMISourceId(n));
        if (fileBrowserSourceInfo != null) {
            if (fileBrowserSourceInfo.getPartitionByUniqueMediaID(string) != -1) {
                return fileBrowserSourceInfo;
            }
        } else if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".checkFileBrowserSourceInfo() Source [hmi id=").append(n).append(", uniqueMediaID=").append(string).append("] not available").log();
        }
        return null;
    }

    public FileBrowserSourceInfo checkLastActiveSource() {
        return this.checkLastActiveSource(this.getSettings().getHMISourceId(), this.getSettings().getUniqueMediaID());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private FileBrowserSourceInfo checkLastActiveSource(int n, String string) {
        if (this.getActiveSource() == null && n > 0) {
            FileBrowserSourceInfo fileBrowserSourceInfo;
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append(this._classname).append(".checkLastActiveSource() Try to activate last active source [hmi source id=").append(n).append(", uniqueMediaID=").append(string).append("]").log();
            }
            if ((fileBrowserSourceInfo = this.checkFileBrowserSourceInfo(n, string)) != null) return fileBrowserSourceInfo;
            if (!this.getTarget().isTraceEnabled()) return null;
            this.getTarget().trace().append(this._classname).append(".checkLastActiveSource() Last active source [hmi id=").append(n).append(", uniqueMediaID=").append(string).append("] not available").log();
            return null;
        } else {
            if (!this.getTarget().isTraceEnabled()) return null;
            this.getTarget().trace().append(this._classname).append(".checkLastActiveSource() No last active source. src=").append(this.getActiveSource()).append(", lastSourceId=").append(n).append(", lastUniqueMediaId=").append(string).log();
        }
        return null;
    }

    public void setSourceList(FileBrowserSourceList fileBrowserSourceList) {
        this._sourceList = fileBrowserSourceList;
    }

    public boolean checkIfCurrentActiveSourceHasBeenRemoved() {
        FileBrowserSourceInfo fileBrowserSourceInfo = this.getActiveSource();
        if (fileBrowserSourceInfo != null && !this._sourceList.isSourceAvailable(fileBrowserSourceInfo.getSourceId())) {
            if (this.getTarget().isTraceEnabled()) {
                this.getTarget().trace().append(this._classname).append(".checkIfCurrentActiveSourceHasBeenRemoved() hmi source id ").append(PictureViewerHelper.getHMISourceIdFromFileBrowserSourceId(fileBrowserSourceInfo.getSourceId())).append(" removed").log();
            }
            return true;
        }
        return false;
    }

    public void checkPictureSource() {
        FileBrowserSourceInfo fileBrowserSourceInfo;
        if (this.getSettings().getHMISourceId() != 0 && ((fileBrowserSourceInfo = this._sourceList.getSourceById(PictureViewerHelper.getFileBrowserSourceIdFromHMISourceId(this.getSettings().getHMISourceId()))) == null || fileBrowserSourceInfo.getPartitionByUniqueMediaID(this.getSettings().getUniqueMediaID()) == -1)) {
            this._settings.setPicture(PictureSourceInfo.NONE);
            this._hmiNotifier.notifyPictureDisplayed(false);
        }
    }

    public FileBrowserSourceInfo getFileBrowserSourceInfoByIndex(int n) {
        return this.indexedList.getByIndex(n);
    }

    private int getActiveHMISourceId() {
        return this._activeSource != null ? PictureViewerHelper.getHMISourceIdFromFileBrowserSourceId(this._activeSource.getSourceId()) : 0;
    }

    public HsmTargetPictureViewer getTarget() {
        return this._target;
    }

    public PictureViewerHMINotifier getHmiNotifier() {
        return this._hmiNotifier;
    }

    public PictureViewerSettings getSettings() {
        return this._settings;
    }

    public boolean checkLastActivePicture(int n) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this._classname).append(".checkLastActivePicture(").append(n).append(")").log();
        }
        return this.displayPicture(n);
    }

    public void handleSetZoomLevel(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        switch (n) {
            case 0: 
            case 1: 
            case 2: {
                if (this._target.isTraceEnabled()) {
                    this.getTarget().trace().append(this._classname).append(".setZoomLevel(").append(n).append(")").log();
                }
                this.getSettings().setZoomLevel(n);
                this.getHmiNotifier().notifyDefaultZoomLevel(n);
                break;
            }
            default: {
                this.getTarget().warn().append(this._classname).append(".setZoomLevel(").append(n).append(") Unknown value").log();
            }
        }
    }

    public void handleSetSlideShowMode(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        switch (n) {
            case 0: 
            case 1: {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append(this._classname).append(".setSlideShowMode(").append(n).append(")").log();
                }
                this._slideShowOn = n == 0;
                break;
            }
            default: {
                this.getTarget().warn().append(this._classname).append(".setSlideShowMode(").append(n).append(") Unknown value").log();
            }
        }
    }

    public void handleToggleSlideshowRepeatState() {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".toggleSlideshowRepeatState()").log();
        }
        this.getSettings().toggleSlideshowRepeatState();
        this.getHmiNotifier().notifySlideshowRepeatState(this.getSettings().getSlideshowRepeatState());
    }

    public void handleSetSlideShowTimer(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append(this._classname).append(".setSlideShowTimer(").append(n).append(")").log();
                }
                if (!this.getSettings().setSlideshowTimer(n)) break;
                this.getHmiNotifier().notifySlideshowTimer(n);
                break;
            }
            default: {
                this.getTarget().warn().append(this._classname).append(".setSlideShowTimer(").append(n).append(") Unknown value").log();
            }
        }
    }

    public void handleSpeedDisclaimerShown(EventGeneric eventGeneric) {
    }
}

