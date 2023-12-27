/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.services;

import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListenerFolderPath;
import de.vw.mib.asl.internal.mediacontrol.common.Helper;
import de.vw.mib.asl.internal.mediacontrol.components.browser.BrowserState;
import de.vw.mib.asl.internal.mediacontrol.components.browser.ListenerFolderPath;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlBrowserImpl;

class ServiceMediaControlBrowserImpl$3
implements ListenerFolderPath {
    private final /* synthetic */ MediaControlListenerFolderPath val$listener;
    private final /* synthetic */ ServiceMediaControlBrowserImpl this$0;

    ServiceMediaControlBrowserImpl$3(ServiceMediaControlBrowserImpl serviceMediaControlBrowserImpl, MediaControlListenerFolderPath mediaControlListenerFolderPath) {
        this.this$0 = serviceMediaControlBrowserImpl;
        this.val$listener = mediaControlListenerFolderPath;
    }

    @Override
    public void updateFolderPath(BrowserState browserState) {
        this.val$listener.updateFolderPath(Helper.getMediaControlListEntries(browserState.getFolderPath()));
    }
}

