/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.browsing;

import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.media.browser.AbstractMediaBrowser;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.util.Util;
import org.dsi.ifc.media.ListEntry;

public final class CmdOpenFolder
extends AbstractCommand {
    private static int TIMEOUT;
    private static final int STEP_1_OPEN_FOLDER;
    private static final int STEP_2_REQUEST_FOCUSED_ENTRY;
    private static final int STEP_3_SET_FOCUSED_ENTRY;
    private final AbstractMediaBrowser mBrowser;
    private final ListEntry[] mFolderPath;
    private final ListEntry mListEntry;
    private boolean mFolderChangeNeeded;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdOpenFolder;

    private CmdOpenFolder(AbstractMediaBrowser abstractMediaBrowser, ListEntry[] listEntryArray, ListEntry listEntry) {
        super(abstractMediaBrowser.getComponentId(), 1, 3, TIMEOUT);
        ListEntry listEntry2;
        this.mBrowser = abstractMediaBrowser;
        ListEntry[] listEntryArray2 = listEntryArray;
        ListEntry listEntry3 = listEntry;
        if (abstractMediaBrowser != null && abstractMediaBrowser.getInstanceId() == 4 && !Util.isNullOrEmpty(listEntryArray) && !MediaBrowserHelper.isSameListEntry(listEntryArray[0], listEntry2 = abstractMediaBrowser.getBrowseFolder()[0])) {
            this.warn("replaced root entry as passed folder path one was invalid.");
            listEntryArray2 = new ListEntry[listEntryArray.length];
            System.arraycopy((Object)listEntryArray, 0, (Object)listEntryArray2, 0, listEntryArray.length);
            ListEntry listEntry4 = new ListEntry();
            listEntry4.entryID = listEntry2.entryID;
            listEntry4.contentType = listEntry2.contentType;
            listEntry4.filename = listEntry2.filename;
            listEntry4.title = listEntry2.title;
            listEntry4.secLength = listEntry2.secLength;
            listEntry4.flags = listEntry2.flags;
            listEntryArray2[0] = listEntry4;
        }
        if (MediaBrowserHelper.isJoggerMode(listEntryArray)) {
            this.warn("Tried to enter jogger mode path -> ROOT!");
            listEntryArray2 = new ListEntry[]{abstractMediaBrowser.getBrowseFolder()[0]};
            listEntry3 = null;
        }
        this.mFolderPath = listEntryArray2;
        this.mListEntry = listEntry3;
    }

    public static CmdOpenFolder createRelativeCmd(AbstractMediaBrowser abstractMediaBrowser, ListEntry listEntry, ListEntry listEntry2) {
        if (!$assertionsDisabled && abstractMediaBrowser == null) {
            throw new AssertionError((Object)"browser must not be null");
        }
        if (!$assertionsDisabled && listEntry == null) {
            throw new AssertionError((Object)"listEntry must not be null");
        }
        Object[] objectArray = abstractMediaBrowser.getAbsolutePathByListEntry(listEntry);
        if (!$assertionsDisabled && Util.isNullOrEmpty(objectArray)) {
            throw new AssertionError((Object)"path must not be null or empty");
        }
        return new CmdOpenFolder(abstractMediaBrowser, (ListEntry[])objectArray, listEntry2);
    }

    public static CmdOpenFolder createAbsoluteCmd(AbstractMediaBrowser abstractMediaBrowser, ListEntry[] listEntryArray, ListEntry listEntry) {
        if (!$assertionsDisabled && abstractMediaBrowser == null) {
            throw new AssertionError((Object)"browser must not be null");
        }
        if (!$assertionsDisabled && Util.isNullOrEmpty(listEntryArray)) {
            throw new AssertionError((Object)"path must not be null or empty");
        }
        return new CmdOpenFolder(abstractMediaBrowser, listEntryArray, listEntry);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                if (this.mFolderChangeNeeded) {
                    this.mBrowser.rqOpenFolder(this.mFolderPath, this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 2: {
                if (this.mListEntry != null) {
                    MediaCollector mediaCollector = this.mBrowser.getBrowseMedia();
                    boolean bl = mediaCollector.isBT() || mediaCollector.isIPod();
                    this.mBrowser.rqListEntry(this.mListEntry.entryID, this.mListEntry.contentType, this.mListEntry.getTitle(), 0, bl && this.mListEntry.getContentType() == 1, this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 3: {
                ExtendedListEntry extendedListEntry;
                if (this.mListEntry != null && (extendedListEntry = this.mBrowser.getRequestedListEntry()) != null) {
                    this.trace(new StringBuffer().append("listIndex: ").append(extendedListEntry.listIndex).toString());
                    this.mBrowser.setFocusedElement(extendedListEntry);
                }
                this.nextStep();
                break;
            }
        }
    }

    @Override
    public void onEnter() {
        boolean bl = this.mFolderChangeNeeded = !MediaBrowserHelper.isSameFolder(this.mFolderPath, this.mBrowser.getBrowseFolder());
        if (this.mFolderChangeNeeded) {
            this.mBrowser.setListState(0);
        }
    }

    @Override
    public void onExit() {
        if (this.mBrowser.getListSize() <= 0) {
            this.mBrowser.setListState(1);
        } else {
            this.mBrowser.setListState(2);
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 1: {
                return "OPEN_FOLDER";
            }
            case 2: {
                return "REQUEST_FOCUSED_ENTRY";
            }
            case 3: {
                return "SET_FOCUSED_ENTRY";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        String string = MediaBrowserHelper.getInstanceIdStr(this.mBrowser);
        String string2 = MediaBrowserHelper.getPathString(this.mFolderPath);
        String string3 = MediaBrowserHelper.getListEntryStr(this.mListEntry);
        return new StringBuffer().append("instanceId=").append(string).append(", path=").append(string2).append(this.mListEntry != null ? new StringBuffer().append(", focusedEntry=").append(string3).toString() : "").toString();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdOpenFolder == null ? (class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdOpenFolder = CmdOpenFolder.class$("de.vw.mib.asl.internal.media.controller.commands.browsing.CmdOpenFolder")) : class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdOpenFolder).desiredAssertionStatus();
        TIMEOUT = 20000;
    }
}

