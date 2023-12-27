/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.features;

import de.vw.mib.asl.api.speechengine.features.Feature;
import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;

public interface GenericTargetFeature
extends Feature {
    default public void setInt(int n, int n2) {
    }

    default public void setBoolean(int n, boolean bl) {
    }

    default public void setOrderedPrompts(int n, OrderedPrompts orderedPrompts) {
    }

    default public void setEvent(int n, Event event) {
    }
}

