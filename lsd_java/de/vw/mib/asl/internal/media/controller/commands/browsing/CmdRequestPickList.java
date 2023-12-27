/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.browsing;

import de.vw.mib.asl.internal.media.browser.AbstractMediaBrowser;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.browsing.CmdRequestPickListCallback;
import java.util.List;
import org.dsi.ifc.media.ListEntry;

public final class CmdRequestPickList
extends AbstractCommand {
    private static int TIMEOUT = 10000;
    private static final int STEP_0_VALIDATE;
    private static final int STEP_1_REQUEST_PICK_LIST;
    private static final int STEP_2_CONVERT_RESULT;
    private final AbstractMediaBrowser mBrowser;
    private final List mEntryIds;
    private final int mContentType;
    private ListEntry[] mEntryInfos;
    private final CmdRequestPickListCallback mCallback;

    public CmdRequestPickList(AbstractMediaBrowser abstractMediaBrowser, List list, int n, CmdRequestPickListCallback cmdRequestPickListCallback) {
        super(abstractMediaBrowser.getComponentId(), 0, 2, TIMEOUT);
        this.mBrowser = abstractMediaBrowser;
        this.mEntryIds = list;
        this.mContentType = n;
        this.mCallback = cmdRequestPickListCallback;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                if (!this.mBrowser.isBrowsingAvailable()) {
                    this.commandFailed("browser is not available");
                    return;
                }
                if (this.mEntryIds == null || this.mEntryIds.size() <= 0) {
                    this.commandFailed("passed entryIds null or empty");
                    return;
                }
                this.nextStep();
                break;
            }
            case 1: {
                long[] lArray = new long[this.mEntryIds.size()];
                for (int i2 = 0; i2 < this.mEntryIds.size(); ++i2) {
                    lArray[i2] = (Long)this.mEntryIds.get(i2);
                }
                this.mBrowser.rqPickList(lArray, this.NEXT_STEP);
                return;
            }
            case 2: {
                this.mEntryInfos = this.mBrowser.getRequestedPickList();
                this.nextStep();
                break;
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
                return "REQUEST_PICK_LIST";
            }
            case 2: {
                return "CONVERT_ARRAY";
            }
        }
        return null;
    }

    @Override
    public void onExit() {
        this.mCallback.response(this.mEntryInfos, this);
    }

    @Override
    protected String getParameterStr() {
        String string = MediaBrowserHelper.getInstanceIdStr(this.mBrowser);
        String string2 = MediaBrowserHelper.getListEntriesStr(this.mEntryIds);
        String string3 = MediaBrowserHelper.getContentTypeStr(this.mContentType);
        return new StringBuffer().append("instanceId=").append(string).append(" entryIds=").append(string2).append(", contentType=").append(string3).toString();
    }
}

