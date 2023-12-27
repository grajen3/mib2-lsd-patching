/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe.lines;

import de.vw.mib.asl.internal.speechengine.slots.pipe.PipeSlotEntryUpdater;
import de.vw.mib.asl.internal.speechengine.slots.pipe.filter.IsLoadRequestInAcceptedTimeHook;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.PipeConfig;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.PipeDefaultSlotUpdate;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.PipeGrowSlotUpdate;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.PipeImmediateSlotUpdate;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.SlotPipeline;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.SlotPipelineFactory;
import de.vw.mib.asl.internal.speechengine.slots.start.SlotUpdaterParameters;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class SlotPipelineFactoryTarget
extends SlotPipelineFactory {
    private SlotPipeline DEFAULT_PIPELINE = null;
    private SlotPipeline GROW_PIPELINE = null;
    private SlotPipeline IMMEDIATE_PIPELINE = null;
    private final AbstractClassifiedLogger logger;
    private final SlotUpdaterParameters slotUpdaterParameters;
    private final IsLoadRequestInAcceptedTimeHook isLoadRequestInAcceptedTimeHook;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$slots$pipe$lines$PipeDefaultSlotUpdate;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$slots$pipe$lines$PipeGrowSlotUpdate;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$slots$pipe$lines$PipeImmediateSlotUpdate;

    public SlotPipelineFactoryTarget(SlotUpdaterParameters slotUpdaterParameters, IsLoadRequestInAcceptedTimeHook isLoadRequestInAcceptedTimeHook) {
        this.isLoadRequestInAcceptedTimeHook = isLoadRequestInAcceptedTimeHook;
        this.logger = slotUpdaterParameters.getLogger();
        this.slotUpdaterParameters = slotUpdaterParameters;
    }

    @Override
    public SlotPipeline getDefaultSlotUpdatePipeline() {
        String string = (class$de$vw$mib$asl$internal$speechengine$slots$pipe$lines$PipeDefaultSlotUpdate == null ? (class$de$vw$mib$asl$internal$speechengine$slots$pipe$lines$PipeDefaultSlotUpdate = SlotPipelineFactoryTarget.class$("de.vw.mib.asl.internal.speechengine.slots.pipe.lines.PipeDefaultSlotUpdate")) : class$de$vw$mib$asl$internal$speechengine$slots$pipe$lines$PipeDefaultSlotUpdate).getName();
        String string2 = PipeSlotEntryUpdater.convertToUnqualifiedName(string);
        PipeConfig pipeConfig = new PipeConfig(0, 0, string2);
        if (this.DEFAULT_PIPELINE == null) {
            this.DEFAULT_PIPELINE = new PipeDefaultSlotUpdate(this.logger, pipeConfig, this.slotUpdaterParameters, this.isLoadRequestInAcceptedTimeHook);
        }
        return this.DEFAULT_PIPELINE;
    }

    @Override
    public SlotPipeline getGrowSlotUpdatePipeline() {
        String string = (class$de$vw$mib$asl$internal$speechengine$slots$pipe$lines$PipeGrowSlotUpdate == null ? (class$de$vw$mib$asl$internal$speechengine$slots$pipe$lines$PipeGrowSlotUpdate = SlotPipelineFactoryTarget.class$("de.vw.mib.asl.internal.speechengine.slots.pipe.lines.PipeGrowSlotUpdate")) : class$de$vw$mib$asl$internal$speechengine$slots$pipe$lines$PipeGrowSlotUpdate).getName();
        String string2 = PipeSlotEntryUpdater.convertToUnqualifiedName(string);
        PipeConfig pipeConfig = new PipeConfig(0, 0, string2);
        if (this.GROW_PIPELINE == null) {
            this.GROW_PIPELINE = new PipeGrowSlotUpdate(this.logger, pipeConfig, this.slotUpdaterParameters, this.isLoadRequestInAcceptedTimeHook);
        }
        return this.GROW_PIPELINE;
    }

    @Override
    public SlotPipeline getImmediateSlotUpdatePipeline() {
        String string = (class$de$vw$mib$asl$internal$speechengine$slots$pipe$lines$PipeImmediateSlotUpdate == null ? (class$de$vw$mib$asl$internal$speechengine$slots$pipe$lines$PipeImmediateSlotUpdate = SlotPipelineFactoryTarget.class$("de.vw.mib.asl.internal.speechengine.slots.pipe.lines.PipeImmediateSlotUpdate")) : class$de$vw$mib$asl$internal$speechengine$slots$pipe$lines$PipeImmediateSlotUpdate).getName();
        String string2 = PipeSlotEntryUpdater.convertToUnqualifiedName(string);
        PipeConfig pipeConfig = new PipeConfig(0, 0, string2);
        if (this.IMMEDIATE_PIPELINE == null) {
            this.IMMEDIATE_PIPELINE = new PipeImmediateSlotUpdate(this.logger, pipeConfig, this.slotUpdaterParameters, this.isLoadRequestInAcceptedTimeHook);
        }
        return this.IMMEDIATE_PIPELINE;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

