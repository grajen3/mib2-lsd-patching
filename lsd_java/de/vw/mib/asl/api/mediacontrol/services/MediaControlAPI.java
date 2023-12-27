/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.mediacontrol.services;

import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlServiceBrowser;
import de.vw.mib.asl.api.mediacontrol.services.player.MediaControlServicePlayer;

public interface MediaControlAPI {
    default public MediaControlServicePlayer getPlayerService() {
    }

    default public MediaControlServiceBrowser getBrowserService() {
    }
}

