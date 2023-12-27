/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.recorder;

import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;

public interface RecorderStateListener {
    default public void onRecorderMediaChanged(MediaCollector mediaCollector) {
    }
}

