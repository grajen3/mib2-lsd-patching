/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller;

import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.api.media.services.browser.MediaEntriesCallback;
import de.vw.mib.asl.internal.media.controller.MediaController;
import de.vw.mib.asl.internal.media.controller.MediaEntryFactory;
import de.vw.mib.asl.internal.media.controller.commands.CommandState;
import de.vw.mib.asl.internal.media.controller.commands.browsing.CmdRequestPickListCallback;
import org.dsi.ifc.media.ListEntry;

class MediaController$8
implements CmdRequestPickListCallback {
    private final /* synthetic */ MediaEntriesCallback val$callback;
    private final /* synthetic */ MediaController this$0;

    MediaController$8(MediaController mediaController, MediaEntriesCallback mediaEntriesCallback) {
        this.this$0 = mediaController;
        this.val$callback = mediaEntriesCallback;
    }

    @Override
    public void response(ListEntry[] listEntryArray, CommandState commandState) {
        if (commandState.isCompleted()) {
            this.val$callback.responseMediaEntry(MediaEntryFactory.createMediaEntryList(listEntryArray), ResultCode.OK);
        } else {
            this.val$callback.responseMediaEntry(null, ResultCode.NOK);
        }
    }
}

