/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.player;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.asl.internal.media.playback.PlayTime;

public class TimeBar {
    public static void update(MediaPlayerState mediaPlayerState) {
        PlayTime playTime = null;
        boolean bl = false;
        if (mediaPlayerState != null) {
            playTime = mediaPlayerState.getPlayTime();
            bl = mediaPlayerState.isActivated();
        }
        if (bl && playTime != null) {
            int n;
            int n2 = playTime.getTotalTime();
            int n3 = n2 >= (n = playTime.getPlayTime()) ? (n2 / 1000 - n / 1000) * 1000 : 0;
            ServiceManager.aslPropertyManager.valueChangedInteger(14, n3);
            ServiceManager.aslPropertyManager.valueChangedInteger(13, n);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(14, 0);
            ServiceManager.aslPropertyManager.valueChangedInteger(13, 0);
        }
    }
}

