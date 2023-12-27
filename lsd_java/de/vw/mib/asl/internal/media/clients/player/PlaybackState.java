/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.player;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.clients.player.CapabilityProperties;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.util.Util;
import org.dsi.ifc.media.Capabilities;

public class PlaybackState {
    private static final ASLPropertyManager DATA_POOL = ServiceManager.aslPropertyManager;

    public static void update(MediaPlayerState mediaPlayerState) {
        boolean bl;
        int n = mediaPlayerState.getPlaybackState();
        if (CapabilityProperties.isDsiUpdated() && !CapabilityProperties.isPlaybackStateExpected()) {
            n = 1;
        }
        if (n != 0) {
            DATA_POOL.valueChangedInteger(29, n);
        }
        Capabilities capabilities = mediaPlayerState.getCapabilities();
        int n2 = mediaPlayerState.getCmdBlockingMask();
        DATA_POOL.valueChangedBoolean(53, capabilities == null || capabilities.isSetTimePos() && !Util.isAnyBitSet(33, n2));
        boolean bl2 = bl = n == 1 || n == 6 || n == 7;
        if (bl) {
            DATA_POOL.valueChangedBoolean(149, (capabilities == null || capabilities.isPause()) && !Util.isBitSet(2048, n2));
        } else {
            DATA_POOL.valueChangedBoolean(149, (capabilities == null || capabilities.isResume()) && !Util.isBitSet(256, n2));
        }
        DATA_POOL.valueChangedBoolean(811338752, (capabilities == null || capabilities.isFastFwd()) && !Util.isBitSet(256, n2));
        DATA_POOL.valueChangedBoolean(794561536, (capabilities == null || capabilities.isFastBwd()) && !Util.isBitSet(512, n2));
        DATA_POOL.valueChangedBoolean(148, (capabilities == null || capabilities.isSkipFwd()) && !Util.isBitSet(128, n2));
        DATA_POOL.valueChangedBoolean(150, (capabilities == null || capabilities.isSkipFwd()) && !Util.isBitSet(64, n2));
    }
}

