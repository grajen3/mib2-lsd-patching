/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe.lines;

import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.FilterExchange;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.FilterLoad;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.IsLoadRequestInAcceptedTimeHook;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.PipeFilter;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.PipeConfig;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.SlotPipeline;
import de.vw.mib.asl.internal.speechengine.slots.start.SlotUpdaterParameters;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class PipeImmediateSlotUpdate
extends SlotPipeline {
    PipeImmediateSlotUpdate(AbstractClassifiedLogger abstractClassifiedLogger, PipeConfig pipeConfig, SlotUpdaterParameters slotUpdaterParameters, IsLoadRequestInAcceptedTimeHook isLoadRequestInAcceptedTimeHook) {
        super(abstractClassifiedLogger, pipeConfig, slotUpdaterParameters, isLoadRequestInAcceptedTimeHook);
    }

    @Override
    PipeFilter createPipeline() {
        FilterLoad filterLoad = new FilterLoad(this.logger, this.getPipeConfig(), null);
        FilterExchange filterExchange = new FilterExchange(this.logger, this.getPipeConfig(), filterLoad);
        return filterExchange;
    }
}

