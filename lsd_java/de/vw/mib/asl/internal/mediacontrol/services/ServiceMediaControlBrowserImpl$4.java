/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.services;

import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListenerInvalidBrowserPath;
import de.vw.mib.asl.internal.mediacontrol.components.browser.ListenerInvalidBrowsePath;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlBrowserImpl;

class ServiceMediaControlBrowserImpl$4
implements ListenerInvalidBrowsePath {
    private final /* synthetic */ MediaControlListenerInvalidBrowserPath val$listener;
    private final /* synthetic */ ServiceMediaControlBrowserImpl this$0;

    ServiceMediaControlBrowserImpl$4(ServiceMediaControlBrowserImpl serviceMediaControlBrowserImpl, MediaControlListenerInvalidBrowserPath mediaControlListenerInvalidBrowserPath) {
        this.this$0 = serviceMediaControlBrowserImpl;
        this.val$listener = mediaControlListenerInvalidBrowserPath;
    }

    @Override
    public void indicateInvalidBrowsePath() {
        this.val$listener.indicateInvalidBrowsePath();
    }
}

