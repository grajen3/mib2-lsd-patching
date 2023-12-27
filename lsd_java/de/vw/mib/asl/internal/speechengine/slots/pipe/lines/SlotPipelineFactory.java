/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe.lines;

import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.SlotPipeline;

public abstract class SlotPipelineFactory {
    public abstract SlotPipeline getDefaultSlotUpdatePipeline() {
    }

    public abstract SlotPipeline getGrowSlotUpdatePipeline() {
    }

    public abstract SlotPipeline getImmediateSlotUpdatePipeline() {
    }
}

