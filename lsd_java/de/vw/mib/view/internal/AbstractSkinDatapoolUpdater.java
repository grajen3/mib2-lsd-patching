/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.skin.SkinAnimationPool;
import de.vw.mib.skin.SkinDatapoolUpdater;

public abstract class AbstractSkinDatapoolUpdater
implements SkinDatapoolUpdater {
    private final SkinAnimationPool skinAnimationPool;

    public AbstractSkinDatapoolUpdater(SkinAnimationPool skinAnimationPool) {
        this.skinAnimationPool = skinAnimationPool;
    }

    @Override
    public final void updateDatapool() {
        this.performanceLogSkinDatapoolUpdate(1);
        this.updateNonImages();
        this.updateImages();
        this.performanceLogSkinDatapoolUpdate(4);
    }

    @Override
    public final void abort() {
    }

    protected abstract void updateNonImages() {
    }

    protected abstract void updateImages() {
    }

    protected EasingParams[] getEasingArray(int n) {
        return this.skinAnimationPool.getEasingParamsArray(n);
    }

    private void performanceLogSkinDatapoolUpdate(int n) {
        ServiceManagerCommon.perfService.performanceLogStartup(12, 6, n);
    }
}

