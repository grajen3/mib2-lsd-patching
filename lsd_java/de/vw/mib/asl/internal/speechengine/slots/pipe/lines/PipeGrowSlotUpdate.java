/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe.lines;

import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.FilterAdd;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.FilterDelayDynamic;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.FilterDelayStatic;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.FilterExchange;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.FilterFork;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.FilterLoadIfDirty;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.IsLoadRequestInAcceptedTimeHook;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.PipeFilter;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.PipeConfig;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.SlotPipeline;
import de.vw.mib.asl.internal.speechengine.slots.start.SlotUpdaterParameters;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class PipeGrowSlotUpdate
extends SlotPipeline {
    PipeGrowSlotUpdate(AbstractClassifiedLogger abstractClassifiedLogger, PipeConfig pipeConfig, SlotUpdaterParameters slotUpdaterParameters, IsLoadRequestInAcceptedTimeHook isLoadRequestInAcceptedTimeHook) {
        super(abstractClassifiedLogger, pipeConfig, slotUpdaterParameters, isLoadRequestInAcceptedTimeHook);
    }

    @Override
    PipeFilter createPipeline() {
        FilterLoadIfDirty filterLoadIfDirty = new FilterLoadIfDirty(this.logger, this.getPipeConfig(), null);
        FilterDelayDynamic filterDelayDynamic = new FilterDelayDynamic(this.logger, this.getPipeConfig(), filterLoadIfDirty, this.paras.getInvoker(), this.paras.getTimerManager(), this.paras.getFramework4u(), this.isLoadRequestInAcceptedTimeHook);
        FilterExchange filterExchange = new FilterExchange(this.logger, this.getPipeConfig(), filterDelayDynamic);
        FilterDelayStatic filterDelayStatic = new FilterDelayStatic(this.logger, this.getPipeConfig(), filterExchange, this.paras.getInvoker(), this.paras.getTimerManager());
        FilterAdd filterAdd = new FilterAdd(this.logger, this.getPipeConfig(), filterDelayDynamic);
        FilterFork filterFork = new FilterFork(this.logger, this.getPipeConfig(), filterAdd, filterDelayStatic);
        return filterFork;
    }
}

