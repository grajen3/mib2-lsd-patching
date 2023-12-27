/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser;

import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceInfo;
import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceList;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.filebrowser.FileBrowserListCollector;
import de.vw.mib.asl.internal.filebrowser.HsmTargetFileBrowser;
import de.vw.mib.asl.internal.filebrowser.ModelSessions;
import de.vw.mib.asl.internal.filebrowser.sessions.Session;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Loggable;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.MediaInfo;

public final class StateIdle
extends AbstractHsmState {
    private final HsmTargetFileBrowser _target;
    private final String _classname = super.getClass().getName();
    private static FileBrowserListCollector[] LIST_WINDOW = new FileBrowserListCollector[10];

    StateIdle(HsmTargetFileBrowser hsmTargetFileBrowser, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._target = hsmTargetFileBrowser;
    }

    public void dsiFileBrowserChangeFolderResult(int n, int n2, Path path) {
        Session session = this._target.sessions.getDsiSession(n);
        if (n2 == 0 && this._target.getModelSessions().getCurrentModelFilebrowserSession() == session) {
            if (this._target.isTraceEnabled()) {
                this._target.trace().append(this._classname).append(".dsiFileBrowserChangeFolderResult(").append(n).append(", ").append(n2).append(", ").append(path == null ? "null" : path.toString()).append("): handleModelUpdateCurrentFolder() getCurrentModelFilebrowserSession()").log();
            }
            this.handleModelUpdateCurrentFolder(session, path);
        } else if (null != session) {
            EventGeneric eventGeneric = session.popEvent();
            session.setPath(path);
            try {
                this.reportDirectoryChangeResult(eventGeneric, session.getAslHandle(), n2 == 0, path);
            }
            catch (GenericEventException genericEventException) {
                this._target.error().append(this._classname).append(".dsiFileBrowserChangeFolderResult(").append(n).append(", ").append(n2).append(", ").append(path == null ? "null" : path.toString()).append("): reportDirectoryChangeResult() failed [").append(genericEventException.getMessage()).append("]").log();
            }
        } else {
            this._target.warn().append(this._classname).append(".dsiFileBrowserChangeFolderResult(").append(n).append(", ").append(n2).append(", ").append(path == null ? "null" : path.toString()).append(") unknown session with sessionHandle ").append(n).log();
        }
    }

    public void dsiFileBrowserGetFileCountResult(int n, int n2, int n3) {
        Session session = this._target.sessions.getDsiSession(n);
        if (session != null) {
            session.removeRequest(1015);
        }
        if (n2 == 0 && this._target.getModelSessions().getCurrentModelFilebrowserSession() == session) {
            this.handleModelUpdateFileCount(n, n3);
        } else if (null != session) {
            EventGeneric eventGeneric = session.popEvent();
            try {
                this.reportNumberOfEntries(eventGeneric, session.getAslHandle(), n2 == 0, n3);
            }
            catch (GenericEventException genericEventException) {
                this._target.error().append(this._classname).append(".dsiFileBrowserGetFileCountResult(").append(n).append(", ").append(n2).append(", ").append(n3).append("): reportNumberOfEntries() failed [").append(genericEventException.getMessage()).append("]").log();
            }
        } else {
            this._target.warn().append(this._classname).append(".dsiFileBrowserGetFileCountResult(").append(n).append(", ").append(n2).append(", ").append(n3).append("): Unknown session.").log();
        }
    }

    public void dsiFileBrowserGetViewWindowResult(int n, int n2, int n3, BrowsedFileSet browsedFileSet, int n4) {
        Session session = this._target.sessions.getAnyDsiSession(n);
        if (null != session) {
            EventGeneric eventGeneric = session.popListEvent();
            this._target.sessions.removeIfHalfClosed(session);
            try {
                this.reportEntries(eventGeneric, session.getAslHandle(), n2 == 0, n3, browsedFileSet);
            }
            catch (GenericEventException genericEventException) {
                this._target.error().append(this._classname).append(".dsiFileBrowserGetViewWindowResult(): reportEntries() failed [").append(genericEventException.getMessage()).append("]").log();
            }
        } else {
            this._target.warn().append(this._classname).append(".dsiFileBrowserGetViewWindowResult(): Unknown session handle ").append(n).log();
        }
    }

    public void dsiFileBrowserSetFileExtensionFilterResult(int n, int n2) {
        Session session = this._target.sessions.getDsiSession(n);
        if (null != session) {
            if (!session.isPartitioned()) {
                EventGeneric eventGeneric = session.popEvent();
                try {
                    this.reportSetFilterResult(eventGeneric, session.getAslHandle(), n2 == 0);
                }
                catch (GenericEventException genericEventException) {
                    this._target.error().append(this._classname).append(".dsiFileBrowserSetFileExtensionFilterResult(): reportSetFilterResult() failed [").append(genericEventException.getMessage()).append("]").log();
                }
            } else {
                this._target.warn("not expecting a dsiFileBrowserSetFileExtensionFilterResult because isPartitioned. ");
            }
        } else {
            this._target.warn().append(this._classname).append(".dsiFileBrowserSetFileExtensionFilterResult(): Unknown session handle ").append(n).log();
        }
    }

    public void dsiFileBrowserSetFileTypeFilterResult(int n, int n2) {
        Session session = this._target.sessions.getDsiSession(n);
        if (null != session) {
            EventGeneric eventGeneric = session.popEvent();
            try {
                this.reportSetFileAndFolderFilterResult(eventGeneric, session.getAslHandle(), n2 == 0);
            }
            catch (GenericEventException genericEventException) {
                this._target.error().append(this._classname).append(".dsiFileBrowserSetFileTypeFilterResult() reportSetFileAndFolderFilterResult() failed [").append(genericEventException.getMessage()).append("]").log();
            }
        } else {
            this._target.warn().append(this._classname).append(".dsiFileBrowserSetFileTypeFilterResult(): Unknown session handle ").append(n).log();
        }
    }

    public void dsiFileBrowserGetResourceLocatorsResult(int n, int n2, ResourceLocator[] resourceLocatorArray) {
        if (this._target.getPendingModelResourceLocatorSlotIndex() == n) {
            this._target.handleResourceLocatorResponse(resourceLocatorArray);
        } else {
            EventGeneric eventGeneric = this._target.getRLRequestEvent(n);
            if (null != eventGeneric) {
                this._target.clearRLEventSlot(n);
                try {
                    this.reportGetResourceLocatorsResult(eventGeneric, n2 == 0, resourceLocatorArray);
                }
                catch (GenericEventException genericEventException) {
                    this._target.error().append(this._classname).append(".dsiFileBrowserGetResourceLocatorsResult() reportGetResourceLocatorsResult() failed [").append(genericEventException.getMessage()).append("]").log();
                }
            } else {
                this._target.error().append(this._classname).append(".dsiFileBrowserGetResourceLocatorsResult(): invalid caller Id. No requestEvent found for slot/callerId ").append(n).log();
            }
        }
    }

    public void dsiFileBrowserGetResourceLocatorWindowResult(int n, int n2, int n3, ResourceLocator[] resourceLocatorArray, int n4) {
        if (n2 != 0) {
            this._target.error("getResourceLocatorWindowResult failure");
            return;
        }
        this._target.handleResourceLocatorResponse(resourceLocatorArray);
    }

    public void dsiFileBrowserAsyncException(int n, String string, int n2) {
        Object object;
        this._target.error().append("dsiFileBrowserAsyncException(errorCode=").append(n).append(", errorMsg=").append(string).append(", requestType=").append(n2).append(')').log();
        List list = this._target.sessions.getByRequestType(n2);
        this._target.warn().append(list.size()).append(" sessions with matching requestType found:").log();
        Object object2 = list.iterator();
        while (object2.hasNext()) {
            object = (Session)object2.next();
            this._target.warn().append((Loggable)object).log();
        }
        if (list.size() != 1) {
            this._target.error().append("cannot identify session with requestType uniquely!").log();
            return;
        }
        object2 = (Session)list.get(0);
        object = ((Session)object2).popEvent();
        if (object != null) {
            this._target.sendBackIfBlocked((EventGeneric)object);
        }
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 2: {
                if (!this._target.isTraceEnabled()) break;
                this._target.trace().append(this._classname).append(".handle(HSM_ENTRY)").log();
                break;
            }
            case 4: {
                if (!this._target.isTraceEnabled()) break;
                this._target.trace().append(this._classname).append(".handle(HSM_EXIT)").log();
                break;
            }
            case 2500019: {
                eventGeneric.setBlocked(true);
                this._target.startSessionState.pendingEvent = eventGeneric;
                this._target.startAslSessionState.setMediaInfo((MediaInfo)eventGeneric.getObject(0));
                if (eventGeneric.getParamType(1) == 2 && eventGeneric.getBoolean(1)) {
                    this.trans(this._target.startSessionState);
                    break;
                }
                this.trans(this._target.startAslSessionState);
                break;
            }
            case 1073742150: {
                this.reportCurrentGPSFolderPath(eventGeneric.getInt(0));
                break;
            }
            case 2500020: {
                int n2 = eventGeneric.getInt(0);
                Session session = this._target.sessions.removeSession(n2);
                if (session != null) {
                    int n3 = session.getDsiHandle();
                    this._target.getDsiFileBrowser().stop(n3);
                } else {
                    this._target.warn().append("StateIdle.handle(ASLFilebrowserServiceIds.STOP_SESSION) for handle ").append(n2).append(", but no session found.").log();
                }
                this.trans(this);
                break;
            }
            case 2500011: {
                int n4 = eventGeneric.getInt(0);
                Session session = this._target.sessions.getAslSession(n4);
                if (null != session) {
                    if (session.isFree()) {
                        eventGeneric.setBlocked(true);
                        session.setPendingEvent(eventGeneric, 1006);
                        Path path = new Path(session.getPath().mountPoint, HsmTargetFileBrowser.ROOT_PATH);
                        if (this._target.isTraceEnabled()) {
                            this._target.trace().append("ASLFilebrowserServiceIds.CHANGE_TO_ROOT_DIRECTORY changeFolder(").append(n4).append(',').append(path.toString()).append(')').log();
                        }
                        this._target.getDsiFileBrowser().changeFolder(session.getDsiHandle(), path);
                        break;
                    }
                    this._target.info().append(this._classname).append(".handle(ASL_FILEBROWSER_CHANGE_TO_ROOT_DIRECTORY): Request denied due to pending event.").log();
                    this.reportDirectoryChangeResult(eventGeneric, n4, false, session.getPath());
                    break;
                }
                this._target.error().append(this._classname).append(".handle(ASL_FILEBROWSER_CHANGE_TO_ROOT_DIRECTORY): Unknown session handle ").append(n4).log();
                this.reportDirectoryChangeResult(eventGeneric, n4, false, null);
                break;
            }
            case 2500001: {
                this.handleChangeToParentDirectory(eventGeneric);
                break;
            }
            case 2500002: {
                int n5 = eventGeneric.getInt(0);
                BrowsedFile browsedFile = (BrowsedFile)eventGeneric.getObject(1);
                Session session = this._target.sessions.getAslSession(n5);
                if (null != session) {
                    if (browsedFile.fileType != 3) {
                        this._target.error().append(this._classname).append(".handle(ASL_FILEBROWSER_OPEN_DIRECTORY_RELATIVE): file was passed -> ").append(browsedFile.filename).log();
                        this.reportDirectoryChangeResult(eventGeneric, n5, false, session.getPath());
                        break;
                    }
                    if (session.isFree()) {
                        eventGeneric.setBlocked(true);
                        session.setPendingEvent(eventGeneric, 1006);
                        String[] stringArray = new String[session.getPath().folderNames.length + 1];
                        System.arraycopy((Object)session.getPath().folderNames, 0, (Object)stringArray, 0, session.getPath().folderNames.length);
                        stringArray[stringArray.length - 1] = browsedFile.filename;
                        if (this._target.isTraceEnabled()) {
                            this._target.trace().append("ASLFilebrowserServiceIds.OPEN_DIRECTORY_RELATIVE changeFolder(").append(n5).append(',').append(new Path(session.getPath().mountPoint, stringArray).toString()).append(')').log();
                        }
                        this._target.getDsiFileBrowser().changeFolder(session.getDsiHandle(), new Path(session.getPath().mountPoint, stringArray));
                        break;
                    }
                    this._target.info().append(this._classname).append(".handle(ASL_FILEBROWSER_OPEN_DIRECTORY_RELATIVE): Request denied due to pending event.").log();
                    this.reportDirectoryChangeResult(eventGeneric, n5, false, session.getPath());
                    break;
                }
                this._target.error().append(this._classname).append(".handle(ASL_FILEBROWSER_OPEN_DIRECTORY_RELATIVE): Unknown session handle ").append(n5).log();
                this.reportDirectoryChangeResult(eventGeneric, n5, false, null);
                break;
            }
            case 2500003: {
                int n6 = eventGeneric.getInt(0);
                String[] stringArray = (String[])eventGeneric.getObject(1);
                Session session = this._target.sessions.getAslSession(n6);
                if (null != session) {
                    if (session.isFree()) {
                        eventGeneric.setBlocked(true);
                        session.setPendingEvent(eventGeneric, 1006);
                        if (this._target.isTraceEnabled()) {
                            this._target.trace().append("ASLFilebrowserServiceIds.OPEN_DIRECTORY_ABSOLUTE changeFolder(").append(n6).append(',').append(new Path(session.getPath().mountPoint, stringArray).toString()).append(')').log();
                        }
                        this._target.getDsiFileBrowser().changeFolder(session.getDsiHandle(), new Path(session.getPath().mountPoint, stringArray));
                        break;
                    }
                    this._target.info().append(this._classname).append(".handle(ASL_FILEBROWSER_OPEN_DIRECTORY_ABSOLUTE): Request denied due to pending event.").log();
                    this.reportDirectoryChangeResult(eventGeneric, n6, false, session.getPath());
                    break;
                }
                this._target.error().append(this._classname).append(".handle(ASL_FILEBROWSER_OPEN_DIRECTORY_ABSOLUTE): Unknown session handle ").append(n6).log();
                this.reportDirectoryChangeResult(eventGeneric, n6, false, null);
                break;
            }
            case 2500004: {
                int n7 = eventGeneric.getInt(0);
                Path path = (Path)eventGeneric.getObject(1);
                Session session = this._target.sessions.getAslSession(n7);
                if (null != session) {
                    if (session.isFree()) {
                        eventGeneric.setBlocked(true);
                        session.setPendingEvent(eventGeneric, 1006);
                        if (this._target.isTraceEnabled()) {
                            this._target.trace().append("ASLFilebrowserServiceIds.OPEN_DIRECTORY_ABSOLUTE_BY_PATH changeFolder(").append(n7).append(',').append(path.toString()).append(')').log();
                        }
                        this._target.getDsiFileBrowser().changeFolder(session.getDsiHandle(), path);
                        break;
                    }
                    this._target.info().append(this._classname).append(".handle(ASL_FILEBROWSER_OPEN_DIRECTORY_ABSOLUTE_BY_PATH): Request denied due to pending event.").log();
                    this.reportDirectoryChangeResult(eventGeneric, n7, false, session.getPath());
                    break;
                }
                this._target.error().append(this._classname).append(".handle(ASL_FILEBROWSER_OPEN_DIRECTORY_ABSOLUTE_BY_PATH): Unknown session handle ").append(n7).log();
                this.reportDirectoryChangeResult(eventGeneric, n7, false, null);
                break;
            }
            case 2500005: {
                int n8 = eventGeneric.getInt(0);
                Session session = this._target.sessions.getAslSession(n8);
                if (null != session) {
                    if (session.isFree()) {
                        eventGeneric.setBlocked(true);
                        session.setPendingEvent(eventGeneric, 1015);
                        this._target.getDsiFileBrowser().getFileCount(session.getDsiHandle());
                        break;
                    }
                    this._target.info().append(this._classname).append(".handle(ASL_FILEBROWSER_GET_NUMBER_OF_ENTRIES): Request denied due to pending event.").log();
                    this.reportDirectoryChangeResult(eventGeneric, n8, false, session.getPath());
                    break;
                }
                this._target.warn().append(this._classname).append(".handle(ASL_FILEBROWSER_GET_NUMBER_OF_ENTRIES): Unknown session handle ").append(n8).log();
                this.reportNumberOfEntries(eventGeneric, n8, false, 0);
                break;
            }
            case 2500006: {
                int n9 = eventGeneric.getInt(0);
                int n10 = eventGeneric.getInt(1);
                int n11 = eventGeneric.getInt(2);
                Session session = this._target.sessions.getAslSession(n9);
                if (null != session) {
                    eventGeneric.setBlocked(true);
                    session.setListEvent(eventGeneric);
                    this._target.getDsiFileBrowser().getViewWindow(session.getDsiHandle(), n11, n10);
                    break;
                }
                this._target.warn().append(this._classname).append(".handle(ASL_FILEBROWSER_GET_ENTRIES): Unknown session handle ").append(n9).log();
                this.reportEntries(eventGeneric, n9, false, n10, null);
                break;
            }
            case 2500007: {
                int n12 = eventGeneric.getInt(0);
                int n13 = eventGeneric.getInt(1);
                if (0 <= n13 && n13 < ModelSessions.CONTENT_FILTERS.length) {
                    Session session = this._target.sessions.getAslSession(n12);
                    if (null != session) {
                        if (session.isFree()) {
                            eventGeneric.setBlocked(true);
                            session.setPendingEvent(eventGeneric, 1007);
                            this._target.getDsiFileBrowser().setFileExtensionFilter(session.getDsiHandle(), ModelSessions.CONTENT_FILTERS[n13]);
                            session.setExtensions(ModelSessions.CONTENT_FILTERS[n13]);
                            break;
                        }
                        this._target.info().append(this._classname).append(".handle(ASL_FILEBROWSER_SET_CONTENT_FILTER): Request denied due to pending event.").log();
                        this.reportSetFilterResult(eventGeneric, n12, false);
                        break;
                    }
                    this._target.warn().append(this._classname).append(".handle(ASL_FILEBROWSER_SET_CONTENT_FILTER): Unknown session handle ").append(n12).log();
                    this.reportSetFilterResult(eventGeneric, n12, false);
                    break;
                }
                this._target.error().append(this._classname).append(".handle(ASL_FILEBROWSER_SET_CONTENT_FILTER): Invalid filter id ").append(n13).log();
                this.reportSetFilterResult(eventGeneric, n12, false);
                break;
            }
            case 2500008: {
                int n14 = eventGeneric.getInt(0);
                String[] stringArray = (String[])eventGeneric.getObject(1);
                Session session = this._target.sessions.getAslSession(n14);
                if (null != session) {
                    if (session.isFree()) {
                        eventGeneric.setBlocked(true);
                        session.setPendingEvent(eventGeneric, 1007);
                        this._target.getDsiFileBrowser().setFileExtensionFilter(session.getDsiHandle(), stringArray);
                        session.setExtensions(stringArray);
                        break;
                    }
                    this._target.info().append(this._classname).append(".handle(ASL_FILEBROWSER_SET_EXTENSION_FILTER): Request denied due to pending event.").log();
                    this.reportSetFilterResult(eventGeneric, n14, false);
                    break;
                }
                this._target.warn().append(this._classname).append(".handle(ASL_FILEBROWSER_SET_EXTENSION_FILTER): Unknown session handle ").append(n14).log();
                this.reportSetFilterResult(eventGeneric, n14, false);
                break;
            }
            case 2500009: {
                int n15 = eventGeneric.getInt(0);
                Session session = this._target.sessions.getAslSession(n15);
                if (null != session) {
                    if (session.isFree()) {
                        boolean bl = eventGeneric.getBoolean(1);
                        boolean bl2 = eventGeneric.getBoolean(1);
                        if (!bl && !bl2) {
                            this._target.info().append(this._classname).append(".handle(ASL_FILEBROWSER_SET_FILE_FOLDER_FILTER): Request for ignored.  Either files or folders must be visible.").log();
                            this.reportSetFileAndFolderFilterResult(eventGeneric, n15, false);
                            break;
                        }
                        eventGeneric.setBlocked(true);
                        session.setPendingEvent(eventGeneric, 1008);
                        this._target.getDsiFileBrowser().setFileTypeFilter(session.getDsiHandle(), (bl ? 1 : 0) | (bl2 ? 2 : 0));
                        break;
                    }
                    this._target.info().append(this._classname).append(".handle(ASL_FILEBROWSER_SET_FILE_FOLDER_FILTER): Request denied due to pending event.").log();
                    this.reportSetFileAndFolderFilterResult(eventGeneric, n15, false);
                    break;
                }
                this._target.warn().append(this._classname).append(".handle(ASL_FILEBROWSER_SET_FILE_FOLDER_FILTER): Unknown session handle ").append(n15).log();
                this.reportSetFileAndFolderFilterResult(eventGeneric, n15, false);
                break;
            }
            case 2500000: {
                int n16 = this._target.getFreeRLRequestSlot();
                if (n16 != -1) {
                    eventGeneric.setBlocked(true);
                    this._target.setRLRequestEvent(n16, eventGeneric);
                    BrowsedFileSet browsedFileSet = (BrowsedFileSet)eventGeneric.getObject(1);
                    this._target.getDsiFileBrowser().getResourceLocators(n16, browsedFileSet);
                    break;
                }
                this._target.error().append(this._classname).append(".handle(ASL_FILEBROWSER_GET_RESOURCE_LOCATORS): No free slots available").log();
                this.reportGetResourceLocatorsResult(eventGeneric, false, null);
                break;
            }
            case 2500022: {
                String string;
                String string2 = eventGeneric.getString(0);
                String string3 = string = eventGeneric.getParamType(1) == 5 ? eventGeneric.getString(1) : null;
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append(this._classname).append("ASLFilebrowserServiceIds.GET_DOWNLOAD_RESOURCELOCATORS (").append(string2).append(", ").append(string).append(")").log();
                }
                this._target.stateGetDownloadResourceLocators.setParameters(eventGeneric, string2, string);
                this.trans(this._target.stateGetDownloadResourceLocators);
                break;
            }
            case 2500016: {
                this._target.sourceList = (FileBrowserSourceList)eventGeneric.getObject(0);
                if (!this._target.isTraceEnabled()) break;
                this._target.trace().append(this._classname).append("ASLFilebrowserServiceIds.UPDATE_SOURCE_LIST: ").append(this._target.sourceList).log();
                break;
            }
            case 2500018: {
                String string = eventGeneric.getString(2);
                this.handleUpdateSourceRemoved(string);
                break;
            }
            case 0x40000144: {
                int n17 = eventGeneric.getInt(0);
                this._target.trace("Received ASLFileBrowserServiceConstants.SET_FILTER ", n17);
                this.handleModelSetFilter(n17);
                break;
            }
            case 1073744298: {
                this.handleModelResetLogoPath();
                break;
            }
            case 1073742147: {
                int n18 = eventGeneric.getInt(0);
                int n19 = ListManager.getGenericASLList(414).getListTransformer().getInt(0, ListManager.getGenericASLList(414).getRowItem(n18));
                this.handleModelSelectSource(n19);
                break;
            }
            case 1073742146: {
                int n20 = eventGeneric.getInt(0);
                this._target.trace("Received ASLFileBrowserServiceConstants.SELECT_SOURCE, source=", n20);
                this.selectSource(this._target.filebrowserSourcesV2.getByIndex(n20).getMedium(0).getCurrentInfo());
                break;
            }
            case 1073742143: {
                int n21 = eventGeneric.getInt(0);
                this.handleModelMoveFolderUp(n21);
                break;
            }
            case 0x40000140: {
                int n22 = eventGeneric.getInt(0);
                this.handleTriggerListItem(n22);
                break;
            }
            case 0x40000141: {
                break;
            }
            case 1073742149: {
                ServiceManager.aslPropertyManager.valueChangedInteger(423, 1);
                ResourceLocator resourceLocator = (ResourceLocator)eventGeneric.getObject(0);
                boolean bl = this.checkPathAvailability(resourceLocator);
                ServiceManager.aslPropertyManager.valueChangedInteger(423, bl ? 2 : 3);
                break;
            }
            case 101128: {
                eventGeneric.setBlocked(true);
                this._target.startSessionWithParamtersState.setPendingEvent(eventGeneric);
                this.trans(this._target.startSessionWithParamtersState);
                break;
            }
            case 1073744367: {
                Path path;
                ResourceLocator resourceLocator = (ResourceLocator)eventGeneric.getObject(0);
                this._target.startModelContextSessionState.sessionStartPath = path = this.createPathFromResourceLocator(resourceLocator);
                this._target.startModelContextSessionState.submitSetPathResult = true;
                this.trans(this._target.startModelContextSessionState);
                break;
            }
            default: {
                hsmState = this.getParent();
            }
        }
        return hsmState;
    }

    private void handleChangeToParentDirectory(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        Session session = this._target.sessions.getAslSession(n);
        if (null != session) {
            if (session.isFree()) {
                String[] stringArray = session.getPath().folderNames;
                if (stringArray.length >= n2) {
                    eventGeneric.setBlocked(true);
                    session.setPendingEvent(eventGeneric, 1006);
                    String[] stringArray2 = new String[stringArray.length - n2];
                    System.arraycopy((Object)stringArray, 0, (Object)stringArray2, 0, stringArray2.length);
                    Path path = new Path(session.getPath().mountPoint, stringArray2);
                    if (this._target.isTraceEnabled()) {
                        this._target.trace().append("ASLFilebrowserServiceIds.CHANGE_TO_PARENT_DIRECTORY changeFolder(").append(n).append(',').append(path.toString()).append(')').log();
                    }
                    this._target.getDsiFileBrowser().changeFolder(session.getDsiHandle(), path);
                } else {
                    this._target.info().append(this._classname).append(".handle(ASL_FILEBROWSER_CHANGE_TO_PARENT_DIRECTORY): Request denied due to invalid number of folderlevels to move up.").log();
                    this.reportDirectoryChangeResult(eventGeneric, n, false, session.getPath());
                }
            } else {
                this._target.info().append(this._classname).append(".handle(ASL_FILEBROWSER_CHANGE_TO_PARENT_DIRECTORY): Request denied due to pending event.").log();
                this.reportDirectoryChangeResult(eventGeneric, n, false, session.getPath());
            }
        } else {
            this._target.error().append(this._classname).append(".handle(ASL_FILEBROWSER_CHANGE_TO_PARENT_DIRECTORY): Unknown session handle ").append(n).log();
            this.reportDirectoryChangeResult(eventGeneric, n, false, null);
        }
    }

    private void reportCurrentGPSFolderPath(int n) {
        switch (n) {
            case 0: {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append(this._classname).append(".reportCurrentGPSFolderPath(): Path for GPS Pics requested.").log();
                }
                this.sendDirectoryChange(6, 2118849536);
                break;
            }
            case 1: {
                if (this._target.isTraceEnabled()) {
                    this._target.trace().append(this._classname).append(".reportCurrentGPSFolderPath(): Path for vCards requested.").log();
                }
                this.sendDirectoryChange(7, -2142563328);
                break;
            }
            default: {
                this._target.warn().append(this._classname).append(".reportCurrentGPSFolderPath(): Unknown parameter.").log();
            }
        }
    }

    private void sendDirectoryChange(int n, int n2) {
        Session session = this._target.getModelSessions().getSessionByContextFilter(n);
        if (session == null) {
            this._target.error().append("StateIdle.sendDirectoryChange(): targetId ").append(n2).append(" wanted ModelSession identified by filter ").append(n).append(", but the ModelSession is invalid.").log();
            return;
        }
        Path path = session.getPath();
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1058336256, n2, 176619776);
        eventGeneric.setObject(0, path);
        eventGeneric.setInt(1, session.getAslHandle());
        this._target.sendSafe(eventGeneric);
    }

    private boolean checkPathAvailability(ResourceLocator resourceLocator) {
        return false;
    }

    void handleModelUpdateFileCount(int n, int n2) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".handleModelUpdateFileCount(handle=").append(n).append(", count=").append(n2).append(")").log();
        }
        ListManager.getGenericASLList(424).setSize(0);
        ListManager.getGenericASLList(424).setSize(n2);
    }

    private void handleModelUpdateCurrentFolder(Session session, Path path) {
        session.setPath(path);
        this._target.notifyModel(session);
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".handleModelUpdateCurrentFolder(): Changed current folder to ").append(path).log();
        }
        session.addRequest(1015);
        this._target.getDsiFileBrowser().getFileCount(session.getDsiHandle());
        this._target.topState.updateNumberOfVCards(session);
    }

    void handleModelMoveFolderUp(int n) {
        if (this._target.getModelSessions().isValid()) {
            Session session = this._target.getModelSessions().getCurrentModelFilebrowserSession();
            if (!session.isFree()) {
                this._target.trace("Operations pending, suppressing ASLFileBrowserServiceConstants.MOVE_FOLDER_UP");
                return;
            }
            int n2 = session.getDsiHandle();
            switch (n) {
                case 0: {
                    this._target.getDsiFileBrowser().changeFolder(n2, new Path(session.getPath().mountPoint, HsmTargetFileBrowser.ROOT_PATH));
                    break;
                }
                case 1: {
                    String[] stringArray = new String[session.getPath().folderNames.length - 1];
                    System.arraycopy((Object)session.getPath().folderNames, 0, (Object)stringArray, 0, stringArray.length);
                    this._target.getDsiFileBrowser().changeFolder(n2, new Path(session.getPath().mountPoint, stringArray));
                    break;
                }
                case 2: {
                    String[] stringArray = new String[session.getPath().folderNames.length - 2];
                    System.arraycopy((Object)session.getPath().folderNames, 0, (Object)stringArray, 0, stringArray.length);
                    this._target.getDsiFileBrowser().changeFolder(n2, new Path(session.getPath().mountPoint, stringArray));
                    break;
                }
                default: {
                    this._target.error().append(this._classname).append(".handleModelMoveFolderUp(").append(n).append("): Unknown parameter").log();
                }
            }
        }
    }

    private void handleTriggerListItem(int n) {
        Object object = ListManager.getGenericASLList(424).getRowItem(n);
        if (object != null && object instanceof FileBrowserListCollector) {
            FileBrowserListCollector fileBrowserListCollector = (FileBrowserListCollector)object;
            if (null != fileBrowserListCollector.listEntry) {
                if (fileBrowserListCollector.listEntry.fileType == 3) {
                    if (this._target.getModelSessions().getCurrentModelContext() == 4) {
                        this._target.sendHMIEvent(50);
                    } else if (this._target.getModelSessions().isValid()) {
                        Session session = this._target.getModelSessions().getCurrentModelFilebrowserSession();
                        if (!session.isFree()) {
                            this._target.trace("Operations pending, suppressing ASLFileBrowserServiceConstants.TRIGGER_LISTITEM");
                            return;
                        }
                        String[] stringArray = new String[session.getPath().folderNames.length + 1];
                        System.arraycopy((Object)session.getPath().folderNames, 0, (Object)stringArray, 0, session.getPath().folderNames.length);
                        stringArray[stringArray.length - 1] = fileBrowserListCollector.listEntry.filename;
                        if (this._target.isTraceEnabled()) {
                            this._target.trace().append("ASLFileBrowserServiceConstants.TRIGGER_LISTITEM changeFolder(").append(session).append(',').append(new Path(session.getPath().mountPoint, stringArray).toString()).append(')').log();
                        }
                        this._target.getDsiFileBrowser().changeFolder(session.getDsiHandle(), new Path(session.getPath().mountPoint, stringArray));
                    }
                } else {
                    ServiceManager.aslPropertyManager.valueChangedResourceLocator(413, fileBrowserListCollector.resourceLocator);
                    this._target.sendHMIEvent(50);
                }
            }
        }
    }

    private void handleUpdateSourceRemoved(String string) {
        if (!Util.isNullOrEmpty(string)) {
            Session session = this._target.sessions.getSessionByMountPoint(string);
            while (null != session) {
                this._target.sessions.removeSession(session.getAslHandle());
                int n = this._target.getModelSessions().invalidateModelFilebrowserSession(session);
                if (n != -1) {
                    this._target.info().append("Removed ModelSession ").append(n).append(" because it matched mountPoint ").append(string).log();
                }
                this._target.getDsiFileBrowser().stop(session.getDsiHandle());
                this.reportSessionClosed(session);
                session = this._target.sessions.getSessionByMountPoint(string);
            }
        }
    }

    private void handleModelSelectSource(int n) {
        this._target.closeCurrentModelSession();
        this._target.trace("StateIdle.handleModelSelectSource(), ASLFileBrowserSetter.SELECT_SOURCE__INDEX__C", n);
        if (this._target.sourceList != null) {
            int n2;
            switch (n) {
                case 2: {
                    n2 = 1;
                    break;
                }
                case 6: {
                    n2 = 2;
                    break;
                }
                case 3: {
                    n2 = 3;
                    break;
                }
                case 9: {
                    n2 = 4;
                    break;
                }
                case 1: {
                    n2 = 0;
                    break;
                }
                default: {
                    n2 = -1;
                }
            }
            this._target.trace("StateIdle.handleModelSelectSource(), FileBrowserSourceInfo.SOURCEID=", n2);
            if (-1 != n2) {
                FileBrowserSourceInfo fileBrowserSourceInfo = this._target.sourceList.getSourceById(n2);
                this._target.trace(new StringBuffer().append("StateIdle.handleModelSelectSource(), sourceInfo=").append(fileBrowserSourceInfo).toString());
                if (null != fileBrowserSourceInfo) {
                    MediaInfo mediaInfo = fileBrowserSourceInfo.getMediaInfos()[0];
                    this.selectSource(mediaInfo);
                }
            }
        }
    }

    private void selectSource(MediaInfo mediaInfo) {
        this._target.trace(new StringBuffer().append("StateIdle.selectSource(), mediaInfo=").append(mediaInfo).toString());
        if (null != mediaInfo) {
            this._target.startModelContextSessionState.mediaInfo = mediaInfo;
            this._target.startModelContextSessionState.sessionStartPath = new Path(mediaInfo.mountPoint, HsmTargetFileBrowser.ROOT_PATH);
            this._target.startModelContextSessionState.submitSetPathResult = false;
            this.trans(this._target.startModelContextSessionState);
        }
    }

    private void handleModelSetFilter(int n) {
        this._target.getModelSessions().setCurrentModelContext(n);
        if (5 == n) {
            this.fillDeviceList();
        } else if (this._target.getModelSessions().isValid()) {
            Session session = this._target.getModelSessions().getCurrentModelFilebrowserSession();
            this._target.notifyModel(session);
            if (session.getDsiHandle() != -1) {
                this._target.getDsiFileBrowser().getFileCount(session.getDsiHandle());
                this._target.topState.updateNumberOfVCards(session);
            } else {
                ServiceManager.aslPropertyManager.valueChangedInteger(3822, 0);
            }
        }
    }

    private void handleModelResetLogoPath() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3479, false);
    }

    private void fillDeviceList() {
    }

    private void reportGetResourceLocatorsResult(EventGeneric eventGeneric, boolean bl, ResourceLocator[] resourceLocatorArray) {
        eventGeneric.setBoolean(0, bl);
        eventGeneric.setObject(1, resourceLocatorArray);
        this._target.sendBackIfBlocked(eventGeneric);
    }

    private void reportSetFileAndFolderFilterResult(EventGeneric eventGeneric, int n, boolean bl) {
        if (null != eventGeneric) {
            eventGeneric.setInt(0, n);
            eventGeneric.setBoolean(1, bl);
            this._target.sendBackIfBlocked(eventGeneric);
        }
    }

    void reportSetFilterResult(EventGeneric eventGeneric, int n, boolean bl) {
        if (null != eventGeneric) {
            eventGeneric.setInt(0, n);
            eventGeneric.setBoolean(1, bl);
            this._target.sendBackIfBlocked(eventGeneric);
        }
    }

    void reportEntries(EventGeneric eventGeneric, int n, boolean bl, int n2, BrowsedFileSet browsedFileSet) {
        if (null != eventGeneric) {
            eventGeneric.setInt(0, n);
            eventGeneric.setBoolean(1, bl);
            eventGeneric.setInt(2, n2);
            eventGeneric.setObject(3, browsedFileSet);
            this._target.sendBackIfBlocked(eventGeneric);
        } else if (bl) {
            this._target.handleListResponse(n, n2, browsedFileSet);
        }
    }

    void reportNumberOfEntries(EventGeneric eventGeneric, int n, boolean bl, int n2) {
        if (null != eventGeneric) {
            eventGeneric.setInt(0, n);
            eventGeneric.setBoolean(1, bl);
            eventGeneric.setInt(2, n2);
            this._target.sendBackIfBlocked(eventGeneric);
        } else if (this._target.getModelSessions().getCurrentModelFilebrowserSession().getAslHandle() == n) {
            ListManager.getGenericASLList(424).setSize(0);
            if (bl) {
                ListManager.getGenericASLList(424).setSize(n2);
            }
        }
    }

    void reportDirectoryChangeResult(EventGeneric eventGeneric, int n, boolean bl, Path path) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".reportDirectoryChangeResult(): currentPath = ").append(path).log();
        }
        if (eventGeneric == null) {
            this._target.warn().append("StateIdle.reportDirectoryChangeResult(): responseEvent is null. (cannot be!) handle=").append(n).append(", success=").append(bl).append(", Path=").append(path).log();
            return;
        }
        eventGeneric.setInt(0, n);
        eventGeneric.setBoolean(1, bl);
        eventGeneric.setObject(2, path);
        this._target.sendBackIfBlocked(eventGeneric);
    }

    private void reportSessionClosed(Session session) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, session.getAslHandle());
        this._target.triggerObserver(-1255856640, eventGeneric);
    }

    private Path createPathFromResourceLocator(ResourceLocator resourceLocator) {
        String string = "";
        File file = new File(resourceLocator.getUrl());
        StringTokenizer stringTokenizer = new StringTokenizer(file.isFile() ? file.getParent() : file.getPath(), File.separator);
        ArrayList arrayList = new ArrayList();
        boolean bl = true;
        while (stringTokenizer.hasMoreTokens()) {
            String string2 = stringTokenizer.nextToken();
            if (bl) {
                string = new StringBuffer().append(string).append(File.separator).append(string2).toString();
                if (string2.indexOf("sda") <= -1 && string2.indexOf("sdb") <= -1 && string2.indexOf("usb") <= -1) continue;
                bl = false;
                continue;
            }
            arrayList.add(string2);
        }
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".createPathFromResourceLocator: ResourceLocator = ").append(resourceLocator.getUrl()).append("\n created Mountpoint: ").append(string).append("\n created Path: ").append(((Object)arrayList).toString()).log();
        }
        return new Path(string, (String[])arrayList.toArray(new String[arrayList.size()]));
    }

    static {
        for (int i2 = 0; i2 < LIST_WINDOW.length; ++i2) {
            StateIdle.LIST_WINDOW[i2] = new FileBrowserListCollector();
        }
    }
}

