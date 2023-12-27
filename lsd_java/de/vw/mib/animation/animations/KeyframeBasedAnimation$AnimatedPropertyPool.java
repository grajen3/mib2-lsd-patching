/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.animations;

import de.vw.mib.animation.animations.KeyframeBasedAnimation$PooledAnimatedProperty;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractUnsynchronizedObjectPool;

final class KeyframeBasedAnimation$AnimatedPropertyPool
extends AbstractUnsynchronizedObjectPool {
    public KeyframeBasedAnimation$AnimatedPropertyPool(int n) {
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new KeyframeBasedAnimation$PooledAnimatedProperty();
    }
}

