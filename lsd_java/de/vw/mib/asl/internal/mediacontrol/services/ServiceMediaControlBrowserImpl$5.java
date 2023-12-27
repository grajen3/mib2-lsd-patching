/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.services;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlResultCode;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlCallbackListRequest;
import de.vw.mib.asl.internal.mediacontrol.commands.CmdRequestListCallback;
import de.vw.mib.asl.internal.mediacontrol.common.Helper;
import de.vw.mib.asl.internal.mediacontrol.common.commands.CommandState;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlBrowserImpl;
import org.dsi.ifc.upnp.ListEntry;

class ServiceMediaControlBrowserImpl$5
implements CmdRequestListCallback {
    private final /* synthetic */ MediaControlCallbackListRequest val$callback;
    private final /* synthetic */ int val$index;
    private final /* synthetic */ ServiceMediaControlBrowserImpl this$0;

    ServiceMediaControlBrowserImpl$5(ServiceMediaControlBrowserImpl serviceMediaControlBrowserImpl, MediaControlCallbackListRequest mediaControlCallbackListRequest, int n) {
        this.this$0 = serviceMediaControlBrowserImpl;
        this.val$callback = mediaControlCallbackListRequest;
        this.val$index = n;
    }

    @Override
    public void response(ListEntry[] listEntryArray, CommandState commandState) {
        if (commandState.isCompleted()) {
            this.val$callback.responseList(Helper.getMediaControlListEntries(listEntryArray), this.val$index, MediaControlResultCode.OK);
        } else {
            this.val$callback.responseList(Helper.getMediaControlListEntries(listEntryArray), this.val$index, MediaControlResultCode.NOK);
        }
    }
}

