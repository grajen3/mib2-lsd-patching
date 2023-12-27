/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.commands;

import de.vw.mib.asl.internal.mediacontrol.commands.CmdRequestListCallback;
import de.vw.mib.asl.internal.mediacontrol.common.Helper;
import de.vw.mib.asl.internal.mediacontrol.common.commands.AbstractCommand;
import de.vw.mib.asl.internal.mediacontrol.common.commands.Command;
import de.vw.mib.asl.internal.mediacontrol.components.browser.Browser;
import de.vw.mib.util.Util;

public final class CmdRequestList
extends AbstractCommand {
    private static int TIMEOUT;
    private static final int STEP_1_REQUEST_LIST;
    private final Browser mBrowser;
    private final CmdRequestListCallback mCallback;
    private final String mEntryId;
    private final int mContentType;
    private final int mIndex;
    private final int mCount;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mediacontrol$commands$CmdRequestList;

    private CmdRequestList(Browser browser, String string, int n, int n2, int n3, CmdRequestListCallback cmdRequestListCallback) {
        super(browser.getComponentId(), 0, 0, TIMEOUT);
        this.mBrowser = browser;
        this.mCallback = cmdRequestListCallback;
        this.mEntryId = string;
        this.mContentType = n;
        this.mIndex = n2;
        this.mCount = n3;
    }

    public static Command createListRequestById(Browser browser, String string, int n, int n2, CmdRequestListCallback cmdRequestListCallback) {
        if (!$assertionsDisabled && browser == null) {
            throw new AssertionError((Object)"browser must not be null");
        }
        if (!$assertionsDisabled && string == null) {
            throw new AssertionError((Object)"entryId must not be nulll");
        }
        if (!$assertionsDisabled && n <= 0) {
            throw new AssertionError((Object)"contentType must be > 0");
        }
        if (!$assertionsDisabled && n2 < 0) {
            throw new AssertionError((Object)"count must be >= 0");
        }
        return new CmdRequestList(browser, string, n, 0, n2, cmdRequestListCallback);
    }

    public static Command createListRequestByIndex(Browser browser, int n, int n2, CmdRequestListCallback cmdRequestListCallback) {
        if (!$assertionsDisabled && browser == null) {
            throw new AssertionError((Object)"browser must not be null");
        }
        if (!$assertionsDisabled && n < 0) {
            throw new AssertionError((Object)"index must be >= 0");
        }
        if (!$assertionsDisabled && n2 < 0) {
            throw new AssertionError((Object)"count must be >= 0");
        }
        return new CmdRequestList(browser, null, 0, n, n2, cmdRequestListCallback);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                this.mBrowser.rqList(this.mEntryId, this.mContentType, this.mIndex, this.mCount, this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    public void onExit() {
        this.mCallback.response(this.mBrowser.getListResponse(), this);
        if (!Util.isNullOrEmpty(this.mBrowser.getListResponse())) {
            this.mBrowser.getState().setListState(2);
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "REQUEST_LIST";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        if (this.mEntryId != null && this.mContentType > 0) {
            return new StringBuffer().append(" entryId=").append(this.mEntryId).append(", contentType=").append(Helper.getContentTypeStr(this.mContentType)).append(" count=").append(this.mCount).toString();
        }
        return new StringBuffer().append(" index=").append(this.mIndex).append(" count=").append(this.mCount).toString();
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
        $assertionsDisabled = !(class$de$vw$mib$asl$internal$mediacontrol$commands$CmdRequestList == null ? (class$de$vw$mib$asl$internal$mediacontrol$commands$CmdRequestList = CmdRequestList.class$("de.vw.mib.asl.internal.mediacontrol.commands.CmdRequestList")) : class$de$vw$mib$asl$internal$mediacontrol$commands$CmdRequestList).desiredAssertionStatus();
        TIMEOUT = 10000;
    }
}

