/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.browsing;

import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.media.browser.MediaBrowser;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.browser.MediaBrowserListHandler;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.Command;
import de.vw.mib.util.Util;
import org.dsi.ifc.media.ListEntry;

public final class CmdRequestList
extends AbstractCommand {
    private static int TIMEOUT;
    private static final int STEP_1_REQUEST_LIST;
    private static final int STEP_2_HANDLE_RESPONSE;
    private final MediaBrowser mBrowser;
    private final MediaBrowserListHandler mListHandler;
    private final long mEntryId;
    private final int mContentType;
    private final int mIndex;
    private final int mCount;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdRequestList;

    private CmdRequestList(MediaBrowser mediaBrowser, long l, int n, int n2, int n3) {
        super(mediaBrowser.getComponentId(), 0, 1, TIMEOUT);
        this.mBrowser = mediaBrowser;
        this.mListHandler = mediaBrowser.getListHandler();
        this.mEntryId = l;
        this.mContentType = n;
        this.mIndex = n2;
        this.mCount = n3;
    }

    public static Command createListRequestById(MediaBrowser mediaBrowser, long l, int n, int n2) {
        if (!$assertionsDisabled && mediaBrowser == null) {
            throw new AssertionError((Object)"browser must not be null");
        }
        if (!$assertionsDisabled && l <= 0L) {
            throw new AssertionError((Object)"entryId must be > 0");
        }
        if (!$assertionsDisabled && n <= 0) {
            throw new AssertionError((Object)"contentType must be > 0");
        }
        if (!$assertionsDisabled && n2 < 0) {
            throw new AssertionError((Object)"count must be >= 0");
        }
        return new CmdRequestList(mediaBrowser, l, n, 0, n2);
    }

    public static Command createListRequestByIndex(MediaBrowser mediaBrowser, int n, int n2) {
        if (!$assertionsDisabled && mediaBrowser == null) {
            throw new AssertionError((Object)"browser must not be null");
        }
        if (!$assertionsDisabled && n < 0) {
            throw new AssertionError((Object)"index must be >= 0");
        }
        if (!$assertionsDisabled && n2 < 0) {
            throw new AssertionError((Object)"count must be >= 0");
        }
        return new CmdRequestList(mediaBrowser, 0L, 0, n, n2);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                this.mBrowser.rqList(this.mEntryId, this.mContentType, this.mIndex, this.mCount, this.NEXT_STEP);
                return;
            }
            case 1: {
                Object[] objectArray = this.mBrowser.getListResponse();
                if (Util.isNullOrEmpty(objectArray)) {
                    this.commandFailed("null or emtry list response");
                    return;
                }
                this.trace(new StringBuffer().append("entries: ").append(MediaBrowserHelper.getListEntriesStr((ListEntry[])objectArray)).toString());
                if (this.mListHandler != null) {
                    this.mListHandler.updateListData((ExtendedListEntry[])objectArray, ((ExtendedListEntry)objectArray[0]).listIndex);
                }
                this.nextStep();
                break;
            }
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "REQUEST_LIST";
            }
            case 1: {
                return "HANDLE_RESPONSE";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        String string = MediaBrowserHelper.getInstanceIdStr(this.mBrowser);
        if (this.mEntryId > 0L && this.mContentType > 0) {
            return new StringBuffer().append("instanceId=").append(string).append(" entryId=").append(this.mEntryId).append(", contentType=").append(MediaBrowserHelper.getContentTypeStr(this.mContentType)).append(" count=").append(this.mCount).toString();
        }
        return new StringBuffer().append("instanceId=").append(string).append(" index=").append(this.mIndex).append(" count=").append(this.mCount).toString();
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
        $assertionsDisabled = !(class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdRequestList == null ? (class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdRequestList = CmdRequestList.class$("de.vw.mib.asl.internal.media.controller.commands.browsing.CmdRequestList")) : class$de$vw$mib$asl$internal$media$controller$commands$browsing$CmdRequestList).desiredAssertionStatus();
        TIMEOUT = 10000;
    }
}

