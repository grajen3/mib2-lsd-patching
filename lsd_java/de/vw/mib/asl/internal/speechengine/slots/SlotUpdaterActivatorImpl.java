/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots;

import de.vw.mib.asl.internal.speechengine.slots.SlotUpdaterActivatorImpl$1;
import de.vw.mib.asl.internal.speechengine.slots.pipe.PipeSlotEntryUpdater;
import de.vw.mib.asl.internal.speechengine.slots.pipe.SlotLoaderBuffer;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.IsLoadRequestInAcceptedTimeHook;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.SlotPipelineFactoryTarget;
import de.vw.mib.asl.internal.speechengine.slots.start.SlotUpdaterActivator;
import de.vw.mib.asl.internal.speechengine.slots.start.SlotUpdaterCallback;
import de.vw.mib.asl.internal.speechengine.slots.start.SlotUpdaterParameters;

public class SlotUpdaterActivatorImpl
implements SlotUpdaterActivator {
    @Override
    public void activate(SlotUpdaterCallback slotUpdaterCallback, SlotUpdaterParameters slotUpdaterParameters) {
        this.activateInternal(slotUpdaterCallback, slotUpdaterParameters, new SlotUpdaterActivatorImpl$1(this));
    }

    void activateInternal(SlotUpdaterCallback slotUpdaterCallback, SlotUpdaterParameters slotUpdaterParameters, IsLoadRequestInAcceptedTimeHook isLoadRequestInAcceptedTimeHook) {
        SlotPipelineFactoryTarget slotPipelineFactoryTarget = new SlotPipelineFactoryTarget(slotUpdaterParameters, isLoadRequestInAcceptedTimeHook);
        SlotLoaderBuffer slotLoaderBuffer = new SlotLoaderBuffer(slotUpdaterParameters.getCommandLoader());
        PipeSlotEntryUpdater pipeSlotEntryUpdater = new PipeSlotEntryUpdater(slotPipelineFactoryTarget, slotLoaderBuffer, slotUpdaterParameters);
        slotUpdaterCallback.onSlotUpdaterReady(pipeSlotEntryUpdater);
    }
}

