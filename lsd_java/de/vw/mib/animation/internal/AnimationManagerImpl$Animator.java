/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.internal;

import de.vw.mib.animation.animations.Animation;
import de.vw.mib.animation.internal.AnimationManagerImpl;
import de.vw.mib.log4mib.LogMessage;
import java.util.Iterator;

final class AnimationManagerImpl$Animator
implements Runnable {
    private final /* synthetic */ AnimationManagerImpl this$0;

    public AnimationManagerImpl$Animator(AnimationManagerImpl animationManagerImpl) {
        this.this$0 = animationManagerImpl;
    }

    @Override
    public void run() {
        if (this.this$0.animations.size() > 0) {
            long l = this.this$0.getSystemTimeMillis();
            if (this.this$0.logger.isTraceEnabled(1)) {
                LogMessage logMessage = this.this$0.logger.trace(1);
                logMessage.append("AnimationManager.run() currentTime ").append(l);
                logMessage.log();
            }
            int n = 0;
            Iterator iterator = this.this$0.animations.iterator();
            while (iterator.hasNext()) {
                Animation animation = (Animation)iterator.next();
                if (l < animation.getNextRunTime()) continue;
                if (animation.isActive()) {
                    try {
                        animation.run(l);
                    }
                    catch (Exception exception) {
                        LogMessage logMessage = this.this$0.logger.error(1);
                        logMessage.append("Exception during animation.run():").attachThrowable(exception).log();
                        animation.stop();
                    }
                }
                if (animation.isActive()) {
                    n = (int)Math.min((long)n, animation.getNextRunTime());
                    continue;
                }
                iterator.remove();
            }
            if (n < 0) {
                int n2 = n - l;
                if (this.this$0.animationTimer.getDelay() != n2) {
                    this.this$0.animationTimer.setDelayFromNow(n2);
                }
            }
        }
        this.this$0.checkIfStatusChanged();
    }
}

