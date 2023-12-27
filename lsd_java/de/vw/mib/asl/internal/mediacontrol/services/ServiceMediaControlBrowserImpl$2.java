/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.services;

import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListenerListSize;
import de.vw.mib.asl.internal.mediacontrol.components.browser.BrowserState;
import de.vw.mib.asl.internal.mediacontrol.components.browser.ListenerListSize;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlBrowserImpl;

class ServiceMediaControlBrowserImpl$2
implements ListenerListSize {
    private final /* synthetic */ MediaControlListenerListSize val$listener;
    private final /* synthetic */ ServiceMediaControlBrowserImpl this$0;

    ServiceMediaControlBrowserImpl$2(ServiceMediaControlBrowserImpl serviceMediaControlBrowserImpl, MediaControlListenerListSize mediaControlListenerListSize) {
        this.this$0 = serviceMediaControlBrowserImpl;
        this.val$listener = mediaControlListenerListSize;
    }

    @Override
    public void updateListSize(BrowserState browserState) {
        this.val$listener.updateListSize(browserState.getListSize());
    }
}

