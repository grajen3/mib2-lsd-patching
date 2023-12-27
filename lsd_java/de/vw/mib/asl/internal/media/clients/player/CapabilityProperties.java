/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.player;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import org.dsi.ifc.media.Capabilities;

public class CapabilityProperties {
    public static final Capabilities RESET_CAPABILITIES = new Capabilities();
    private static Capabilities mCapabilities;

    public static void updateCapabilities(Capabilities capabilities) {
        boolean bl;
        boolean bl2 = bl = capabilities == null;
        if (capabilities == null) {
            capabilities = RESET_CAPABILITIES;
        }
        ASLPropertyManager aSLPropertyManager = ServiceManager.aslPropertyManager;
        aSLPropertyManager.valueChangedBoolean(47, capabilities.isPause() && capabilities.isPlay());
        aSLPropertyManager.valueChangedBoolean(54, capabilities.isSkipBwd());
        aSLPropertyManager.valueChangedBoolean(55, capabilities.isSkipFwd());
        aSLPropertyManager.valueChangedBoolean(811338752, capabilities.isFastFwd());
        aSLPropertyManager.valueChangedBoolean(794561536, capabilities.isFastBwd());
        aSLPropertyManager.valueChangedBoolean(53, capabilities.isSetTimePos());
        aSLPropertyManager.valueChangedBoolean(42, false);
        aSLPropertyManager.valueChangedBoolean(139, capabilities != RESET_CAPABILITIES);
        aSLPropertyManager.valueChangedBoolean(148, capabilities.isSkipFwd());
        aSLPropertyManager.valueChangedBoolean(149, capabilities.isPause());
        aSLPropertyManager.valueChangedBoolean(150, capabilities.isSkipBwd());
        if (mCapabilities != null && !CapabilityProperties.timeFullySupported(mCapabilities) && CapabilityProperties.timeFullySupported(capabilities)) {
            aSLPropertyManager.valueChangedBoolean(48, true);
        } else if (!CapabilityProperties.timeFullySupported(capabilities)) {
            aSLPropertyManager.valueChangedBoolean(48, false);
        }
        if (capabilities == RESET_CAPABILITIES) {
            aSLPropertyManager.valueChangedBoolean(2781, capabilities.isDetailInfos());
        }
        mCapabilities = bl ? null : capabilities;
    }

    private static boolean timeFullySupported(Capabilities capabilities) {
        return capabilities.isTotalPlaytime() && capabilities.isPlayTime();
    }

    public static boolean isDsiUpdated() {
        return mCapabilities != RESET_CAPABILITIES;
    }

    public static boolean isPlaybackStateExpected() {
        if (!CapabilityProperties.isDsiUpdated()) {
            ServiceManager.logger.warn(64, "CapabilityProperties.isPlaybackStateExpected() called while no valid data from DSI was available!");
        }
        return mCapabilities != null && mCapabilities.isPause() && mCapabilities.isResume() && mCapabilities.isPlay();
    }

    public static void updateVideoCapability(MediaPlayerState mediaPlayerState) {
        boolean bl = false;
        if (mediaPlayerState != null && mediaPlayerState.isActivated() && mediaPlayerState.getActiveMedia() != null) {
            bl = mediaPlayerState.getActiveMedia().supportsVideo();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(878447616, bl);
    }

    static {
        CapabilityProperties.RESET_CAPABILITIES.detailInfos = true;
        mCapabilities = RESET_CAPABILITIES;
    }
}

