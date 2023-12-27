/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.services;

import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListenerListState;
import de.vw.mib.asl.internal.mediacontrol.common.Helper;
import de.vw.mib.asl.internal.mediacontrol.components.browser.BrowserState;
import de.vw.mib.asl.internal.mediacontrol.components.browser.ListenerListState;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlBrowserImpl;

class ServiceMediaControlBrowserImpl$1
implements ListenerListState {
    private final /* synthetic */ MediaControlListenerListState val$listener;
    private final /* synthetic */ ServiceMediaControlBrowserImpl this$0;

    ServiceMediaControlBrowserImpl$1(ServiceMediaControlBrowserImpl serviceMediaControlBrowserImpl, MediaControlListenerListState mediaControlListenerListState) {
        this.this$0 = serviceMediaControlBrowserImpl;
        this.val$listener = mediaControlListenerListState;
    }

    @Override
    public void updateListState(BrowserState browserState) {
        this.val$listener.updateListState(Helper.getMediaControlListState(browserState.getListState()));
    }
}

