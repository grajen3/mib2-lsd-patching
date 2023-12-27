/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.services;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlAPI;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlServiceBrowser;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlServicePlayer;
import de.vw.mib.asl.internal.mediacontrol.common.commands.CommandQueue;
import de.vw.mib.asl.internal.mediacontrol.services.Components;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlBrowserImpl;
import de.vw.mib.asl.internal.mediacontrol.services.ServiceMediaControlPlayerImpl;

public class MediaControlAPIImpl
implements MediaControlAPI {
    private final ServiceMediaControlPlayerImpl mPlayer;
    private final ServiceMediaControlBrowserImpl mBrowser;

    public MediaControlAPIImpl(CommandQueue commandQueue, Components components) {
        this.mPlayer = new ServiceMediaControlPlayerImpl(commandQueue, components);
        this.mBrowser = new ServiceMediaControlBrowserImpl(commandQueue, components);
    }

    @Override
    public MediaControlServicePlayer getPlayerService() {
        return this.mPlayer;
    }

    @Override
    public MediaControlServiceBrowser getBrowserService() {
        return this.mBrowser;
    }
}

