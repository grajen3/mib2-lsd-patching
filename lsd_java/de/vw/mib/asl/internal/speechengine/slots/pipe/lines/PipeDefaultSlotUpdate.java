/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe.lines;

import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.FilterDelayDynamic;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.FilterExchange;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.FilterLoadIfDirty;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.IsLoadRequestInAcceptedTimeHook;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.PipeFilter;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.PipeConfig;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.SlotPipeline;
import de.vw.mib.asl.internal.speechengine.slots.start.SlotUpdaterParameters;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class PipeDefaultSlotUpdate
extends SlotPipeline {
    PipeDefaultSlotUpdate(AbstractClassifiedLogger abstractClassifiedLogger, PipeConfig pipeConfig, SlotUpdaterParameters slotUpdaterParameters, IsLoadRequestInAcceptedTimeHook isLoadRequestInAcceptedTimeHook) {
        super(abstractClassifiedLogger, pipeConfig, slotUpdaterParameters, isLoadRequestInAcceptedTimeHook);
    }

    @Override
    PipeFilter createPipeline() {
        FilterLoadIfDirty filterLoadIfDirty = new FilterLoadIfDirty(this.logger, this.getPipeConfig(), null);
        FilterDelayDynamic filterDelayDynamic = new FilterDelayDynamic(this.logger, this.getPipeConfig(), filterLoadIfDirty, this.paras.getInvoker(), this.paras.getTimerManager(), this.paras.getFramework4u(), this.isLoadRequestInAcceptedTimeHook);
        FilterExchange filterExchange = new FilterExchange(this.logger, this.getPipeConfig(), filterDelayDynamic);
        return filterExchange;
    }
}

