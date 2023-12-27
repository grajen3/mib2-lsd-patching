/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.browsing;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.browser.AbstractMediaBrowser;
import de.vw.mib.asl.internal.media.browser.BrowserPathData;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.browser.coverflow.MediaCoverBrowser;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.Command;
import de.vw.mib.asl.internal.media.controller.commands.browsing.CmdOpenFolder;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.util.Util;
import org.dsi.ifc.media.ListEntry;

public class CmdSetupBrowser
extends AbstractCommand {
    private static final int EXECUTION_STEP_00_PREPARE_SEQUENCE;
    private static final int EXECUTION_STEP_01_SET_BROWSE_MEDIA;
    private static final int EXECUTION_STEP_02_VALIDATE;
    private static final int EXECUTION_STEP_03_WAIT_FOR_FLAGS;
    private static final int EXECUTION_STEP_04_SET_BROWSE_MODE;
    private static final int EXECUTION_STEP_05_SET_CONTENT_FILTER;
    private static final int EXECUTION_STEP_06_RESET_SELECTION;
    private static final int EXECUTION_STEP_07_FORCE_ROOT_FOLDER;
    private static final int EXECUTION_STEP_08_FILL_ROOT_FOLDER_INFOS;
    private static final int EXECUTION_STEP_09_OPEN_INITIAL_FOLDER;
    private static int TIMEOUT;
    private final AbstractMediaBrowser mBrowser;
    private final MediaPlayer mPlayer;
    private final MediaCollector mBrowseMedia;
    private final int mBrowseMode;
    private final ListEntry[] mFolder;
    private final ListEntry mEntry;
    private boolean mStep7Reached = false;

    public CmdSetupBrowser(AbstractMediaBrowser abstractMediaBrowser, MediaPlayer mediaPlayer) {
        super(abstractMediaBrowser.getComponentId(), 0, 9, TIMEOUT);
        this.mBrowser = abstractMediaBrowser;
        this.mPlayer = mediaPlayer;
        this.mBrowseMedia = this.mPlayer.getActiveMedia();
        this.mBrowseMode = abstractMediaBrowser.getMatchingBrowseMode(mediaPlayer);
        this.mFolder = abstractMediaBrowser.getMatchingBrowseFolder(mediaPlayer);
        this.mEntry = abstractMediaBrowser.getMatchingBrowseEntry(mediaPlayer);
    }

    public CmdSetupBrowser(AbstractMediaBrowser abstractMediaBrowser, MediaCollector mediaCollector, int n, ListEntry[] listEntryArray) {
        super(abstractMediaBrowser.getComponentId(), 0, 9, TIMEOUT);
        this.mBrowser = abstractMediaBrowser;
        this.mPlayer = null;
        this.mBrowseMedia = mediaCollector;
        this.mBrowseMode = n;
        this.mFolder = listEntryArray;
        this.mEntry = null;
    }

    public CmdSetupBrowser(AbstractMediaBrowser abstractMediaBrowser, MediaCollector mediaCollector, int n) {
        this(abstractMediaBrowser, mediaCollector, n, null);
    }

    public static Command createDeactivationCmd(MediaCoverBrowser mediaCoverBrowser) {
        return new CmdSetupBrowser(mediaCoverBrowser, MediaCollector.EMPTY, -1, null);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                if (!this.mBrowser.isSetupRequired(this.mBrowseMedia, this.mBrowseMode)) {
                    if (this.mBrowser.isDeactivated()) {
                        this.commandCompleted("browser deactivated, nothing to synchronize");
                        return;
                    }
                    this.skipTo(9);
                    return;
                }
                this.nextStep();
                break;
            }
            case 1: {
                if (this.mBrowser.isSetBrowseMediaNeeded(this.mBrowseMedia, this.mBrowseMode)) {
                    this.mBrowser.invalidate("incoming browse media change");
                    this.mBrowser.rqSetBrowseMedia(this.mBrowseMedia, this.mBrowseMode, this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                return;
            }
            case 2: {
                if (this.mBrowser.isDeactivated()) {
                    this.commandCompleted(new StringBuffer().append("browser deactivated for: ").append(this.mBrowseMedia.toStringShort()).append(" [browsing supported: ").append(this.mBrowseMedia.supportsBrowsing()).append(", raw/dbl supported:").append(this.mBrowseMedia.supportsRawMode()).append("/").append(this.mBrowseMedia.supportsContentMode()).append("]").toString());
                    return;
                }
                this.nextStep();
                break;
            }
            case 3: {
                MediaCollector mediaCollector;
                if (this.mBrowseMode == 1 && !(mediaCollector = this.mBrowser.getBrowseMedia()).isFlagSet(512)) {
                    this.suspendTimer("browser synchronization");
                    this.trace(new StringBuffer().append("waiting for flags: ").append(MediaBrowserHelper.getMediaFlagsStr(512)).toString());
                    this.mBrowser.rqWaitForFlag(mediaCollector, 512, true, this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 4: {
                this.resumeTimer();
                if (this.mBrowser.getBrowseMode() != this.mBrowseMode) {
                    this.mBrowser.rqSetBrowseMode(this.mBrowseMode, this.NEXT_STEP);
                    return;
                }
                if (this.mBrowser.getContentFilter() == this.mBrowser.getDefaultContentFilterMask() && MediaBrowserHelper.getBrowseMode(this.mBrowser.getBrowseFolder()) == this.mBrowseMode) {
                    this.skipTo(6);
                    return;
                }
                this.nextStep();
                break;
            }
            case 5: {
                this.mBrowser.rqSetContentFilter(this.mBrowser.getDefaultContentFilterMask(), this.NEXT_STEP);
                return;
            }
            case 6: {
                if (this.mBrowser.getInstanceId() == 7) {
                    this.mBrowser.rqAddSelection(this.mBrowser.createResetSelection(), this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 7: {
                this.mStep7Reached = true;
                Object[] objectArray = this.mBrowser.getBrowseFolder();
                if (Util.isNullOrEmpty(objectArray)) {
                    this.commandFailed("valid folderPath expected");
                    return;
                }
                if (objectArray.length != 1) {
                    this.rqExecuteCmd(CmdOpenFolder.createAbsoluteCmd(this.mBrowser, new ListEntry[]{objectArray[0]}, null), this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 8: {
                this.mBrowser.rqFillPathData(this.NEXT_STEP);
                return;
            }
            case 9: {
                Object[] objectArray = this.mFolder;
                if (this.isSynchronizingToPlayer()) {
                    this.mPlayer.updatePlaceHolderPaths(this.mBrowser.getPathData());
                    BrowserPathData browserPathData = this.mBrowser.getPathData();
                    if (browserPathData.containsDummies((ListEntry[])objectArray)) {
                        if (this.isTraceEnabled()) {
                            this.trace(new StringBuffer().append("replacing dummy entries: ").append(MediaBrowserHelper.getPathString((ListEntry[])objectArray)).toString());
                        }
                        browserPathData.replaceDummies((ListEntry[])objectArray);
                    }
                }
                if (!Util.isNullOrEmpty(objectArray)) {
                    this.rqExecuteCmd(CmdOpenFolder.createAbsoluteCmd(this.mBrowser, (ListEntry[])objectArray, this.mEntry), this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
        }
    }

    @Override
    public void onEnter() {
        if (this.mBrowser.isSetupRequired(this.mBrowseMedia, this.mBrowseMode)) {
            this.mBrowser.setInitState(0);
        }
    }

    @Override
    public void onExit() {
        if (this.isCompleted() || this.mStep7Reached) {
            if (this.mBrowser.isDeactivated()) {
                this.mBrowser.setInitState(1);
            } else {
                if (this.mBrowser.getListSize() <= 0) {
                    this.mBrowser.setListState(1);
                } else {
                    this.mBrowser.setListState(2);
                }
                this.mBrowser.setInitState(2);
            }
            if (!this.isSynchronizingToPlayer() && this.mBrowser.getInstanceId() == 0) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(341576704);
            }
            if (this.isSynchronizingToPlayer() && this.mBrowser.getInstanceId() == 1) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(375131136);
            }
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "PREPARE_SEQUENCE";
            }
            case 1: {
                return "SET_BROWSE_MEDIA";
            }
            case 2: {
                return "VALIDATE";
            }
            case 3: {
                return "WAIT_FOR_FLAGS";
            }
            case 4: {
                return "SET_BROWSE_MODE";
            }
            case 5: {
                return "SET_CONTENT_FILTER";
            }
            case 6: {
                return "RESET_SELECTION";
            }
            case 7: {
                return "FORCE_ROOT_FOLDER";
            }
            case 8: {
                return "FILL_ROOT_FOLDER_INFOS";
            }
            case 9: {
                return "OPEN_INITIAL_FOLDER";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        String string = MediaBrowserHelper.getInstanceIdStr(this.mBrowser);
        String string2 = this.mBrowseMedia != null ? this.mBrowseMedia.toStringShort() : "-";
        String string3 = MediaBrowserHelper.getBrowseModeStr(this.mBrowseMode);
        String string4 = this.mBrowser != null ? MediaBrowserHelper.getContentFilterStr(this.mBrowser.getDefaultContentFilterMask()) : "-";
        return new StringBuffer().append("instanceId: ").append(string).append(" browseMedia: ").append(string2).append(" browseMode: ").append(string3).append(", contentFilter: ").append(string4).toString();
    }

    public int getInstanceId() {
        return this.mBrowser.getInstanceId();
    }

    public boolean isSynchronizingToPlayer() {
        return this.mPlayer != null;
    }

    static {
        TIMEOUT = 10000;
    }
}

