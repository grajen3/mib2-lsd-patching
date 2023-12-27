/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser.api.impl;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.Medium;
import de.vw.mib.asl.api.filebrowser.FilebrowserSession;
import de.vw.mib.asl.api.filebrowser.FilebrowserSessionListener;
import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceList;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.MediaInfo;

final class FilebrowserSessionImpl
implements FilebrowserSession {
    private final int targetId;
    private int handle = -1;

    FilebrowserSessionImpl(int n) {
        this.targetId = n;
    }

    @Override
    public void start(Device device) {
        this.start(device.getMainMedium().getCurrentInfo(), false);
    }

    @Override
    public void start(Medium medium) {
        this.start(medium.getCurrentInfo(), true);
    }

    private void start(MediaInfo mediaInfo, boolean bl) {
        if (this.handle != -1) {
            ServiceManager.logger2.warn(256).append(".requestStartSession() Closing active session.").log();
            this.stop(false);
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1289411072);
        eventGeneric.setSenderTargetId(this.targetId);
        eventGeneric.setSenderEventId(-1171970560);
        eventGeneric.setObject(0, mediaInfo);
        eventGeneric.setBoolean(1, bl);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void stop() {
        this.stop(true);
    }

    private void stop(boolean bl) {
        if (this.handle == -1) {
            ServiceManager.logger2.warn(256).append(".requestStopSession() Invalid session handle.").log();
        } else {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1272633856);
            eventGeneric.setSenderTargetId(this.targetId);
            if (bl) {
                eventGeneric.setSenderEventId(-1155193344);
            }
            eventGeneric.setInt(0, this.handle);
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
            this.handle = -1;
        }
    }

    @Override
    public void setFileExtensionFilter(String[] stringArray) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getViewWindow(int n, int n2) {
        if (this.handle == -1) {
            throw new RuntimeException(new StringBuffer().append("handle is invalid (targetId=").append(this.targetId).append(")").toString());
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1507514880);
        eventGeneric.setSenderTargetId(this.targetId);
        eventGeneric.setSenderEventId(-1205524992);
        eventGeneric.setInt(0, this.handle);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void requestOpenDirectoryRelative(BrowsedFile browsedFile) {
        if (this.handle == -1) {
            ServiceManager.logger2.warn(256).append(".requestOpenDirectoryRelative() Invalid session handle.").log();
        } else {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1574623744);
            eventGeneric.setSenderTargetId(this.targetId);
            eventGeneric.setSenderEventId(-1138416128);
            eventGeneric.setInt(0, this.handle);
            eventGeneric.setObject(1, browsedFile);
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        }
    }

    @Override
    public void requestChangeToRootDirectory() {
        if (this.handle == -1) {
            ServiceManager.logger2.warn(256).append(".requestChangeToRootDirectory() Invalid session handle.").log();
            throw new RuntimeException(new StringBuffer().append("handle is invalid (targetId=").append(this.targetId).append(")").toString());
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1423628800);
        eventGeneric.setSenderTargetId(this.targetId);
        eventGeneric.setSenderEventId(-1138416128);
        eventGeneric.setInt(0, this.handle);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void requestChangeToParentDirectory(int n) {
        if (this.handle == -1) {
            ServiceManager.logger2.warn(256).append(".requestChangeToParentDirectory() Invalid session handle.").log();
            throw new RuntimeException(new StringBuffer().append("handle is invalid (targetId=").append(this.targetId).append(")").toString());
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1591400960);
        eventGeneric.setSenderTargetId(this.targetId);
        eventGeneric.setSenderEventId(-1138416128);
        eventGeneric.setInt(0, this.handle);
        eventGeneric.setInt(1, n);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void getFileCount() {
        if (this.handle == -1) {
            ServiceManager.logger2.warn(256).append(".requestFileCount() Invalid session handle.").log();
            throw new RuntimeException(new StringBuffer().append("handle is invalid (targetId=").append(this.targetId).append(")").toString());
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1524292096);
        eventGeneric.setSenderTargetId(this.targetId);
        eventGeneric.setSenderEventId(-1104861696);
        eventGeneric.setInt(0, this.handle);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void getResourceLocators(BrowsedFileSet browsedFileSet) {
        if (this.handle == -1) {
            ServiceManager.logger2.warn(256).append(".requestFileCount() Invalid session handle.").log();
            throw new RuntimeException(new StringBuffer().append("handle is invalid (targetId=").append(this.targetId).append(")").toString());
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1608178176);
        eventGeneric.setSenderTargetId(this.targetId);
        eventGeneric.setSenderEventId(-1188747776);
        eventGeneric.setObject(1, browsedFileSet);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void requestOpenDirectoryAbsoluteByPath(Path path) {
        if (this.handle == -1) {
            ServiceManager.logger2.warn(256).append(".requestOpenDirectoryAbsoluteByPath() Invalid session handle.").log();
            throw new RuntimeException(new StringBuffer().append("handle is invalid (targetId=").append(this.targetId).append(")").toString());
        }
        if (path == null) {
            ServiceManager.logger2.warn(256).append(".requestOpenDirectoryAbsoluteByPath(): Invalid path").log();
            throw new NullPointerException("Path must not be null");
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1541069312);
        eventGeneric.setSenderTargetId(this.targetId);
        eventGeneric.setSenderEventId(-1121638912);
        eventGeneric.setInt(0, this.handle);
        eventGeneric.setObject(1, path);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void setContentFilter(int n) {
        if (this.handle == -1) {
            ServiceManager.logger2.warn(256).append(".requestSetContentFilter() Invalid session handle.").log();
            return;
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1490737664);
        eventGeneric.setSenderTargetId(this.targetId);
        eventGeneric.setSenderEventId(-1088084480);
        eventGeneric.setInt(0, this.handle);
        eventGeneric.setInt(1, n);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public boolean dispatch(EventGeneric eventGeneric, FilebrowserSessionListener filebrowserSessionListener) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2500021: {
                if (eventGeneric.getInt(0) != this.handle) break;
                filebrowserSessionListener.updateSessionClosed();
                this.handle = -1;
                break;
            }
            case 2500016: {
                filebrowserSessionListener.updateSourceList((FileBrowserSourceList)eventGeneric.getObject(0));
                break;
            }
            case 2500030: {
                filebrowserSessionListener.getFileCountResult(eventGeneric.getBoolean(1), eventGeneric.getInt(2));
                break;
            }
            case 2500028: {
                if (eventGeneric.getInt(0) != this.handle) break;
                filebrowserSessionListener.changeFolderResult(eventGeneric.getBoolean(1), (Path)eventGeneric.getObject(2));
                break;
            }
            case 2500029: {
                if (eventGeneric.getInt(0) != this.handle) break;
                filebrowserSessionListener.responseOpenDirectoryAbsoluteByPath(eventGeneric.getBoolean(1), (Path)eventGeneric.getObject(2));
                break;
            }
            case 2500026: {
                this.handle = eventGeneric.getInt(1);
                filebrowserSessionListener.startResult(eventGeneric.getBoolean(0), (Path)eventGeneric.getObject(2));
                break;
            }
            case 2500027: {
                if (eventGeneric.getInt(0) != this.handle) break;
                filebrowserSessionListener.responseStopSession();
                this.handle = -1;
                break;
            }
            case 2500024: {
                if (eventGeneric.getInt(0) != this.handle) break;
                filebrowserSessionListener.getViewWindowResult(eventGeneric.getBoolean(1), eventGeneric.getInt(2), (BrowsedFileSet)eventGeneric.getObject(3));
                break;
            }
            case 2500025: {
                filebrowserSessionListener.getResourceLocatorsResult(eventGeneric.getBoolean(0), (ResourceLocator[])eventGeneric.getObject(1));
                break;
            }
            case 2500031: {
                if (eventGeneric.getInt(0) != this.handle) break;
                filebrowserSessionListener.responseSetContentFilter(eventGeneric.getBoolean(1));
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }
}

