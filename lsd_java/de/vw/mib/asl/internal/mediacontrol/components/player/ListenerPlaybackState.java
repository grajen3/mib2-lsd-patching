/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.components.player;

import de.vw.mib.asl.internal.mediacontrol.components.player.PlayerState;

public interface ListenerPlaybackState {
    default public void updatePlaybackState(PlayerState playerState) {
    }
}

