/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.impl.lsc;

import de.vw.mib.asl.framework.internal.impl.lsc.Preconditions;

public class InitialLscTrigger {
    private final Runnable initialLscCall;
    private boolean hasLscCtrl;
    private boolean hasVisibleLang;
    private boolean hasSysDefLang;
    private boolean isLscAllowedInStd;
    private boolean isStdTarget;

    public InitialLscTrigger(boolean bl, Runnable runnable) {
        Preconditions.checkArgumentNotNull(runnable);
        this.initialLscCall = runnable;
        this.isStdTarget = bl;
    }

    public void markLscIsAllowedInSTD() {
        Preconditions.checkState(this.isStdTarget, "The current target is not an STD!");
        InitialLscTrigger.checkNotCalledBefore(!this.isLscAllowedInStd);
        this.isLscAllowedInStd = true;
        this.tryInitialLsc();
    }

    public void markLscControllerIsInitialized() {
        InitialLscTrigger.checkNotCalledBefore(!this.hasLscCtrl);
        this.hasLscCtrl = true;
        this.tryInitialLsc();
    }

    public void markVisibleLanguageDataReceived() {
        InitialLscTrigger.checkNotCalledBefore(!this.hasVisibleLang);
        this.hasVisibleLang = true;
        this.tryInitialLsc();
    }

    public void markSystemDefaultLanguageDataReceived() {
        InitialLscTrigger.checkNotCalledBefore(!this.hasSysDefLang);
        this.hasSysDefLang = true;
        this.tryInitialLsc();
    }

    private void tryInitialLsc() {
        if (!(this.hasVisibleLang && this.hasLscCtrl && this.hasSysDefLang)) {
            return;
        }
        if (this.isStdTarget && !this.isLscAllowedInStd) {
            return;
        }
        this.initialLscCall.run();
    }

    private static void checkNotCalledBefore(boolean bl) {
        Preconditions.checkState(bl, "This method must only be called once!");
    }
}

