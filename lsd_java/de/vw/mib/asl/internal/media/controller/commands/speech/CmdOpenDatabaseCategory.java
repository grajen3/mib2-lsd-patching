/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.speech;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.browser.AbstractMediaBrowser;
import de.vw.mib.asl.internal.media.browser.BrowserPathData;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.browsing.CmdOpenFolder;
import de.vw.mib.asl.internal.media.controller.commands.browsing.CmdSetupBrowser;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.util.Util;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.ListEntryExt;

public final class CmdOpenDatabaseCategory
extends AbstractCommand {
    private static int TIMEOUT = 6000;
    private static final int STEP_0_VALIDATE;
    private static final int STEP_1_SETUP_BROWSER;
    private static final int STEP_2_OPEN_CATEGORY;
    private final AbstractMediaBrowser mBrowser;
    private final MediaCollector mSource;
    private final int mCategory;

    public CmdOpenDatabaseCategory(AbstractMediaBrowser abstractMediaBrowser, MediaCollector mediaCollector, int n) {
        super(abstractMediaBrowser.getComponentId(), 0, 2, TIMEOUT);
        this.mBrowser = abstractMediaBrowser;
        this.mSource = mediaCollector;
        this.mCategory = n;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                if (this.mSource == null) {
                    this.commandFailed("source must not be null");
                    return;
                }
                if (!this.mSource.supportsContentMode() && !this.mSource.isCDDA()) {
                    this.commandFailed("source must either be CDDA or support contentMode");
                    return;
                }
                this.nextStep();
                break;
            }
            case 1: {
                int n2 = this.mSource.supportsContentMode() ? 1 : 0;
                this.rqExecuteCmd(new CmdSetupBrowser(this.mBrowser, this.mSource, n2), this.NEXT_STEP);
                return;
            }
            case 2: {
                if (this.mSource.isCDDA()) {
                    if (this.isTraceEnabled()) {
                        this.trace("nothing to do for CDDA");
                    }
                    this.nextStep();
                    return;
                }
                ListEntry[] listEntryArray = null;
                switch (this.mCategory) {
                    case 1: {
                        listEntryArray = this.mBrowser.getPathData().getDBLPath(6);
                        break;
                    }
                    case 2: {
                        listEntryArray = this.mBrowser.getPathData().getDBLPath(16);
                        break;
                    }
                    case 3: {
                        listEntryArray = this.mBrowser.getPathData().getDBLPath(13);
                        break;
                    }
                    case 4: {
                        listEntryArray = this.mBrowser.getPathData().getDBLPath(14);
                        break;
                    }
                    case 5: {
                        listEntryArray = this.mBrowser.getPathData().getDBLPath(15);
                        break;
                    }
                    case 6: {
                        listEntryArray = this.mBrowser.getPathData().getDBLPath(8);
                        break;
                    }
                }
                if (Util.isNullOrEmpty(listEntryArray)) {
                    this.commandFailed("could not derive folder based on given category");
                    return;
                }
                this.rqExecuteCmd(CmdOpenFolder.createAbsoluteCmd(this.mBrowser, listEntryArray, null), this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "VALIDATE";
            }
            case 1: {
                return "SETUP_BROWSER";
            }
            case 2: {
                return "OPEN_CATEGORY";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        return new StringBuffer().append("mCategory:").append(MediaBrowserHelper.getCategoryStr(this.mCategory)).toString();
    }

    @Override
    public void onExit() {
        this.updateSpeakableElements(this.mBrowser.getState());
    }

    public void updateSpeakableElements(MediaBrowserState mediaBrowserState) {
        if (mediaBrowserState != null) {
            int n = 0;
            if (mediaBrowserState.isBrowsingAvailable()) {
                if (ServiceManager.configManagerDiag.getSDSMediaCountLimitedGlobally()) {
                    BrowserPathData browserPathData = mediaBrowserState.getPathData();
                    if (browserPathData != null) {
                        n = this.getTotalElementCount(browserPathData.getDBLPath(13));
                        n += this.getTotalElementCount(browserPathData.getDBLPath(14));
                        n += this.getTotalElementCount(browserPathData.getDBLPath(16));
                        n += this.getTotalElementCount(browserPathData.getDBLPath(15));
                        n += this.getTotalElementCount(browserPathData.getDBLPath(8));
                    }
                } else {
                    n = mediaBrowserState.getListSize();
                }
            }
            mediaBrowserState.setSpeakableElementsSize(n, true);
        }
    }

    private int getTotalElementCount(ListEntry[] listEntryArray) {
        ListEntryExt listEntryExt;
        int n = 0;
        if (!Util.isNullOrEmpty(listEntryArray) && (listEntryExt = listEntryArray[listEntryArray.length - 1].getExtInfo()) != null) {
            n = listEntryExt.getFileCount() + listEntryExt.getFolderCount() + listEntryExt.getPlaylistCount();
        }
        return n;
    }
}

