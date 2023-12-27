/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.sd;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.memory.sd.FileBrowserHelper$RequestQueueItem;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import edu.emory.mathcs.backport.java.util.LinkedList;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaInfo;

public class FileBrowserHelper {
    private final int contentFilter;
    private int sessionHandle = -1;
    private AbstractASLTarget target;
    private MediaInfo[] dsiMediaList;
    private DeviceInfo[] dsiDeviceList;
    private LinkedList myFetchQueue = new LinkedList();
    private int currentStartIndex = -1;
    private int aslList;
    private String[] currentFolder = new String[0];

    public FileBrowserHelper(AbstractASLTarget abstractASLTarget, int n, int n2) {
        this.target = abstractASLTarget;
        this.aslList = n;
        this.contentFilter = n2;
    }

    public void setDsiMediaList(MediaInfo[] mediaInfoArray) {
        this.dsiMediaList = mediaInfoArray;
    }

    public void setDsiDeviceList(DeviceInfo[] deviceInfoArray) {
        this.dsiDeviceList = deviceInfoArray;
    }

    public int getSessionHandle() {
        return this.sessionHandle;
    }

    public void startFileBrowserSession(Path path, int n) {
        this.currentFolder = path.folderNames;
        this.startFileBrowserSession(this.getMediaInfoByMountPoint(path.getMountPoint()), n);
    }

    public void startFileBrowserSession(int n, int n2) {
        this.startFileBrowserSession(this.getMediaInfoByDevice(n), n2);
    }

    private void startFileBrowserSession(MediaInfo mediaInfo, int n) {
        EventGeneric eventGeneric;
        if (this.sessionHandle != -1) {
            eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1272633856);
            eventGeneric.setInt(0, this.sessionHandle);
            this.target.send(eventGeneric);
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("NavigationMemorySd.FileBrowserHelper - requested to close file browser session: ").append(this.sessionHandle).log();
            }
            this.sessionHandle = -1;
        }
        eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1289411072);
        eventGeneric.setObject(0, mediaInfo);
        eventGeneric.setSenderEventId(n);
        this.target.send(eventGeneric);
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("NavigationMemorySdGpsPictures.FileBrowserHelper - requested activation of source ").append(mediaInfo.toString()).log();
        }
    }

    public void handleStartSessionResult(EventGeneric eventGeneric, int n) {
        boolean bl = eventGeneric.getBoolean(0);
        if (!bl) {
            if (this.target.isTraceEnabled()) {
                this.target.warn().append("NavigationMemorySd.FileBrowserHelper - FileBrowser did not create a new session handle: ").append(this.sessionHandle).log();
            }
        } else {
            this.sessionHandle = eventGeneric.getInt(1);
            if (this.target.isTraceEnabled()) {
                this.target.trace("NavigationMemorySd.FileBrowserHelper - FileBrowser created a new session handle");
            }
        }
        if (this.sessionHandle != -1) {
            EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric2.setReceiverEventId(-1557846528);
            eventGeneric2.setReceiverTargetId(-1058336256);
            eventGeneric2.setSenderEventId(n);
            eventGeneric2.setInt(0, this.sessionHandle);
            eventGeneric2.setObject(1, this.currentFolder);
            this.target.send(eventGeneric2);
        } else {
            this.target.warn("NavigationMemorySd.FileBrowserHelper -      No session handle: Cancel fetching entries.");
        }
    }

    public void handleSetDirectoryAbsolute(EventGeneric eventGeneric, int n) {
        EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric2.setReceiverEventId(-1457183232);
        eventGeneric2.setReceiverTargetId(-1058336256);
        eventGeneric2.setInt(0, this.sessionHandle);
        eventGeneric2.setBoolean(1, true);
        eventGeneric2.setBoolean(2, false);
        this.target.send(eventGeneric2);
        EventGeneric eventGeneric3 = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric3.setReceiverEventId(-1490737664);
        eventGeneric3.setReceiverTargetId(-1058336256);
        eventGeneric3.setSenderEventId(n);
        eventGeneric3.setInt(0, this.sessionHandle);
        eventGeneric3.setInt(1, this.contentFilter);
        this.target.send(eventGeneric3);
    }

    public void handleSetContentFilterResult(EventGeneric eventGeneric, int n) {
        boolean bl = eventGeneric.getBoolean(1);
        if (!bl) {
            this.target.warn("NavigationMemorySd.FileBrowserHelper - Setting content filter on the FileBrowser returned an error: Cancel fetching images for dislay");
        } else {
            EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric2.setReceiverEventId(-1524292096);
            eventGeneric2.setReceiverTargetId(-1058336256);
            eventGeneric2.setSenderEventId(n);
            eventGeneric2.setInt(0, this.sessionHandle);
            this.target.send(eventGeneric2);
        }
    }

    public void handleFileBrowserDirectoryChanged(EventGeneric eventGeneric, int n) {
        Path path = (Path)eventGeneric.getObject(0);
        int n2 = eventGeneric.getInt(1);
        if (path != null) {
            if (this.target.isTraceEnabled()) {
                this.target.trace().append("FileBrowserHelper/handleSetContentFilterResult path = ").append(path).append(" / currentSessionHandle = ").append(n2).log();
            }
            EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric2.setReceiverTargetId(-1058336256);
            eventGeneric2.setReceiverEventId(-1557846528);
            eventGeneric2.setInt(0, this.sessionHandle);
            String[] stringArray = path.getFolderNames();
            if (stringArray == null) {
                stringArray = new String[]{};
            }
            eventGeneric2.setObject(1, stringArray);
            this.target.send(eventGeneric2);
        }
    }

    public void handleListSizeUpdate(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(1);
        if (!bl) {
            this.target.warn("NavigationMemorySd.FileBrowserHelper - Fetching the list size of EXIF images from the FileBrowser returned an error: Cancel fetching images for dislay");
        } else {
            int n = eventGeneric.getInt(2);
            ListManager.getGenericASLList(this.aslList).setSize(0);
            ListManager.getGenericASLList(this.aslList).setSize(n);
            if (this.aslList == 926) {
                this.target.sendHMIEvent(104);
            } else if (this.aslList == 922) {
                this.target.sendHMIEvent(105);
            }
        }
    }

    public void handleReceivedEntries(EventGeneric eventGeneric, int n) {
        boolean bl = eventGeneric.getBoolean(1);
        if (!bl) {
            this.target.warn("NavigationMemorySd.FileBrowserHelper - FileBrowser returned an error when trying to send the listed EXIF image entries: Cancel fetching images for dislay");
        } else {
            int n2 = eventGeneric.getInt(2);
            BrowsedFileSet browsedFileSet = (BrowsedFileSet)eventGeneric.getObject(3);
            EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric2.setReceiverTargetId(-1058336256);
            eventGeneric2.setReceiverEventId(-1608178176);
            eventGeneric2.setObject(1, browsedFileSet);
            eventGeneric2.setSenderEventId(n);
            this.myFetchQueue.addLast(new FileBrowserHelper$RequestQueueItem(n2, eventGeneric2));
            this.handleNextFetchItems();
        }
    }

    public void handleReceivedResourceLocators(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (!bl) {
            this.target.warn("NavigationMemorySd.FileBrowserHelper - FileBrowser returned an error when trying to send the ResourceLocator array for the listed EXIF image entries: Cancel fetching images for dislay");
        } else {
            Object[] objectArray = (ResourceLocator[])eventGeneric.getObject(1);
            ListManager.getGenericASLList(this.aslList).updateListItems(this.currentStartIndex, objectArray);
        }
        this.currentStartIndex = -1;
        this.handleNextFetchItems();
    }

    public void handleDirectoryChangeRequest(EventGeneric eventGeneric, int n) {
        Path path = (Path)eventGeneric.getObject(0);
        this.sessionHandle = eventGeneric.getInt(1);
        EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric2.setReceiverTargetId(-1058336256);
        eventGeneric2.setReceiverEventId(-1557846528);
        eventGeneric2.setSenderEventId(n);
        eventGeneric2.setInt(0, this.sessionHandle);
        String[] stringArray = path != null && path.getFolderNames() != null ? path.getFolderNames() : new String[]{};
        eventGeneric2.setObject(1, stringArray);
        this.target.send(eventGeneric2);
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("NavigationMemorySd.FileBrowserHelper -      ResourceLocator: ").append(path).log();
        }
    }

    public void handleDirectoryChangeResult(EventGeneric eventGeneric, int n) {
        EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric2.setReceiverEventId(-1524292096);
        eventGeneric2.setReceiverTargetId(-1058336256);
        eventGeneric2.setSenderEventId(n);
        eventGeneric2.setInt(0, this.sessionHandle);
        this.target.send(eventGeneric2);
    }

    private void handleNextFetchItems() {
        block3: {
            if (this.currentStartIndex != -1 || this.myFetchQueue.isEmpty()) {
                return;
            }
            FileBrowserHelper$RequestQueueItem fileBrowserHelper$RequestQueueItem = (FileBrowserHelper$RequestQueueItem)this.myFetchQueue.removeFirst();
            try {
                this.currentStartIndex = fileBrowserHelper$RequestQueueItem.startIndex;
                this.target.send(fileBrowserHelper$RequestQueueItem.event);
            }
            catch (GenericEventException genericEventException) {
                if (!this.target.isTraceEnabled()) break block3;
                this.target.trace("NavigationMemorySd.FileBrowserHelper - Exception in handleNextFetchItem");
            }
        }
    }

    public void fetchItems(int n, int n2) {
        block2: {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setReceiverTargetId(-1058336256);
            eventGeneric.setReceiverEventId(-1507514880);
            eventGeneric.setInt(0, this.sessionHandle);
            eventGeneric.setInt(1, n);
            eventGeneric.setInt(2, n2);
            eventGeneric.setSenderEventId(126288128);
            try {
                this.target.send(eventGeneric);
            }
            catch (GenericEventException genericEventException) {
                if (!this.target.isTraceEnabled()) break block2;
                this.target.trace("NavigationMemorySd.FileBrowserHelper - Exception when requesting entries from FileBrowser");
            }
        }
    }

    private MediaInfo getMediaInfoByMountPoint(String string) {
        for (int i2 = 0; i2 < this.dsiMediaList.length; ++i2) {
            if (!this.dsiMediaList[i2].getMountPoint().equals(string)) continue;
            return this.dsiMediaList[i2];
        }
        if (this.target.isTraceEnabled()) {
            this.target.warn().append("NavigationMemorySdGpsPictures.FileBrowserHelper - No MediaInfo found for mount point").append(string).log();
        }
        return null;
    }

    private MediaInfo getMediaInfoByDevice(int n) {
        int n2;
        int n3 = 1;
        switch (n) {
            case 1: {
                n2 = 4;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            case 3: {
                n2 = 2;
                break;
            }
            case 4: {
                n2 = 8;
                break;
            }
            case 5: {
                n2 = 10;
                break;
            }
            case 6: {
                n2 = 1;
                n3 = 2;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        long l = this.getDsiDeviceIdByType(n2, n3);
        MediaInfo mediaInfo = this.getMediaInfoByDeviceId(l);
        return mediaInfo;
    }

    private long getDsiDeviceIdByType(int n, int n2) {
        if (this.dsiDeviceList != null) {
            int n3 = 0;
            for (int i2 = 0; i2 < this.dsiDeviceList.length; ++i2) {
                if (this.dsiDeviceList[i2].getDeviceType() != n || ++n3 != n2) continue;
                return this.dsiDeviceList[i2].getDeviceID();
            }
        }
        if (this.target.isTraceEnabled()) {
            this.target.warn().append("NavigationMemorySd.FileBrowserHelper - No DSI device found for the ").append(n2).append(". device of type: ").append(n).log();
        }
        return -1L;
    }

    private MediaInfo getMediaInfoByDeviceId(long l) {
        if (this.dsiMediaList != null) {
            for (int i2 = 0; i2 < this.dsiMediaList.length; ++i2) {
                if (this.dsiMediaList[i2].getDeviceID() != l) continue;
                return this.dsiMediaList[i2];
            }
        }
        if (this.target.isTraceEnabled()) {
            this.target.warn().append("NavigationMemorySd.FileBrowserHelper - No DSI media found for the DSI device id: ").append(l).log();
        }
        return null;
    }
}

