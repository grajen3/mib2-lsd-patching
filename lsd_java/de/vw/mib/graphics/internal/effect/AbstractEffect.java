/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.effect.EffectManager;
import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractEffect
extends AbstractResource
implements Effect {
    private final EffectManager effectManager;

    public AbstractEffect(Graphics3D graphics3D, Logger logger, EffectManager effectManager) {
        super(graphics3D, logger);
        this.effectManager = effectManager;
        this.updateAllocationStatistics(this.effectManager.getPerformanceMetrics(), true);
    }

    @Override
    public void dispose() {
        this.updateAllocationStatistics(this.effectManager.getPerformanceMetrics(), false);
        super.dispose();
    }

    protected final EffectManager getEffectManager() {
        return this.effectManager;
    }

    protected abstract void updateAllocationStatistics(EffectPerformanceMetrics effectPerformanceMetrics, boolean bl) {
    }

    @Override
    public abstract boolean isFixedFunction() {
    }

    @Override
    public void bind() {
        Graphics3D graphics3D = this.getGraphics3D();
        if (graphics3D.arePerformanceMetricsEnabled()) {
            EffectPerformanceMetrics effectPerformanceMetrics = this.getEffectManager().getPerformanceMetrics();
            ++effectPerformanceMetrics.effectBinds;
        }
    }
}

