/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.internal;

import de.vw.mib.animation.internal.AnimationManagerImpl;
import de.vw.mib.animation.internal.ServiceManager;

final class AnimationManagerImpl$AnimationTimerHandler
implements Runnable {
    private final /* synthetic */ AnimationManagerImpl this$0;

    public AnimationManagerImpl$AnimationTimerHandler(AnimationManagerImpl animationManagerImpl) {
        this.this$0 = animationManagerImpl;
    }

    @Override
    public void run() {
        if (this.this$0.animationQueued.compareAndSet(false, true)) {
            ServiceManager.eventDispatcher.createAndSubmitAnimationEvent(-272716322);
            this.this$0.logger.trace(1, "Submitted AnimationEvent");
        }
    }
}

