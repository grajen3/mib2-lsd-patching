/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.state.behavior;

import de.vw.mib.asl.internal.speechengine.features.client.state.behavior.BehaviorFeature;

public interface SpeakOnlyStateFeature
extends BehaviorFeature {
    default public boolean isSessionTypeValid() {
    }

    default public int getSessionType() {
    }
}

