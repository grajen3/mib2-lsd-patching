/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.view2view;

import de.vw.mib.animation.animations.Animation;
import de.vw.mib.animation.control.AnimationListener;
import de.vw.mib.desktop.internal.DesktopManagerConfiguration;
import de.vw.mib.desktop.internal.common.ServiceManager;
import de.vw.mib.desktop.internal.view2view.TransitionListener;
import de.vw.mib.desktop.internal.view2view.TransitionManager;
import de.vw.mib.desktop.internal.view2view.TransitionManagerConcurrentImpl$1;
import de.vw.mib.desktop.internal.view2view.TransitionManagerConcurrentImpl$2;
import de.vw.mib.desktop.internal.viewhandler.SmartViewHandler;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.skin.V2vAnimationIndexProvider;

public class TransitionManagerConcurrentImpl
implements TransitionManager {
    private static final boolean DISABLE_ANIMATIONS;
    private static final int ANIMATION_ABORTED;
    private static final int ENTERANIMATION_ENDED;
    private static final int LEAVEANIMATION_ENDED;
    protected final Logger logger = ServiceManager.loggerFactory.getLogger(1024);
    protected final String screenAreaPath;
    private int leaveAnimation;
    private int enterAnimation;
    private boolean leaveOverEnter;
    protected boolean leaveViewIsVisible;
    protected boolean enterViewIsVisible;
    private SmartViewHandler leaveViewHandler;
    private SmartViewHandler enterViewHandler;
    protected TransitionListener transitionListener;
    protected int waitFor;
    protected int currentTransitionNumber = 0;
    protected int activateEarlyAtPercent = 70;
    protected boolean activatedEarly = false;
    protected boolean animationIsRunning;

    public TransitionManagerConcurrentImpl(String string) {
        this.screenAreaPath = string;
        String string2 = DesktopManagerConfiguration.ACTIVATE_EARLY_AT_XX_PERCENT;
        if (string2 != null) {
            try {
                int n = Integer.parseInt(string2);
                if (n < 0 || n > 100) {
                    this.logger.error(8, new StringBuffer().append("Early activation percentage (").append(string2).append(") not in range 0..100!").toString());
                } else {
                    this.activateEarlyAtPercent = n == 100 ? -1 : n;
                }
            }
            catch (NumberFormatException numberFormatException) {
                this.logger.error(8, new StringBuffer().append("Illegal percentage value for early activation (").append(string2).append(")!").toString(), numberFormatException);
            }
        }
    }

    private void traceText(String string) {
        this.logger.trace(8).append("transition ").append(this.screenAreaPath).append(".").append(this.currentTransitionNumber).append(" (").append(this.leaveViewHandler == null ? "<none>" : this.leaveViewHandler.getNameForTraces()).append(" -->").append(this.enterViewHandler == null ? "<none>" : this.enterViewHandler.getNameForTraces()).append("): ").append(string).log();
    }

    @Override
    public int startTransition(SmartViewHandler smartViewHandler, SmartViewHandler smartViewHandler2, TransitionListener transitionListener) {
        int n = 0;
        try {
            AnimationListener animationListener;
            int n2;
            this.activatedEarly = false;
            this.animationIsRunning = true;
            this.leaveViewHandler = smartViewHandler;
            this.enterViewHandler = smartViewHandler2;
            this.transitionListener = transitionListener;
            this.waitFor = 0;
            if (this.logger.isTraceEnabled(8)) {
                this.traceText("begins");
            }
            int n3 = 1;
            if (this.leaveViewHandler != null && (n2 = this.leaveViewHandler.getCurrentViewType()) >= 0) {
                n3 = n2;
            }
            n2 = 1;
            if (this.enterViewHandler != null) {
                this.enterViewHandler.setup();
                int n4 = this.enterViewHandler.getCurrentViewType();
                if (n4 >= 0) {
                    n2 = n4;
                }
            }
            V2vAnimationIndexProvider v2vAnimationIndexProvider = ServiceManager.v2vAnimationIndexProvider;
            this.leaveAnimation = this.leaveViewHandler == null ? -1 : v2vAnimationIndexProvider.getLeaveAnimationIdx(n3, n2);
            this.enterAnimation = v2vAnimationIndexProvider.getEnterAnimationIdx(n3, n2);
            int n5 = v2vAnimationIndexProvider.getLeaveAnimationDelay(n3, n2);
            int n6 = v2vAnimationIndexProvider.getEnterAnimationDelay(n3, n2);
            this.leaveOverEnter = v2vAnimationIndexProvider.isDrawLeaveOverEnterAnimation(n3, n2);
            if (this.logger.isTraceEnabled(8)) {
                this.traceText(new StringBuffer().append("Leave Animation: delay ").append(n5).append(", index ").append(this.leaveAnimation).append("; Enter Animation: delay ").append(n6).append(", index ").append(this.enterAnimation).append("; ").append(this.leaveOverEnter ? "LEAVE_OVER_ENTER" : "ENTER_OVER_LEAVE").toString());
            }
            this.enterViewIsVisible = this.enterAnimation < 0;
            this.leaveViewIsVisible = true;
            if (this.leaveAnimation >= 0) {
                this.waitFor = 1;
            }
            if (this.enterAnimation >= 0) {
                int n7 = this.waitFor = this.waitFor == 1 ? 3 : 2;
            }
            if (this.leaveAnimation >= 0 && !this.leaveViewHandler.startLeaveAnimation(this.leaveViewHandler, this.leaveAnimation, n5, animationListener = new TransitionManagerConcurrentImpl$1(this))) {
                this.waitFor &= 0xFFFFFFFE;
            }
            if (this.enterAnimation >= 0 && !this.enterViewHandler.startEnterAnimation(this.enterViewHandler, this.enterAnimation, n6, animationListener = new TransitionManagerConcurrentImpl$2(this))) {
                this.waitFor &= 0xFFFFFFFD;
            }
            n = this.animationIsRunning ? this.waitFor : 128;
        }
        catch (NullPointerException nullPointerException) {
            String string = smartViewHandler == null ? "#VSN -" : new StringBuffer().append("#VSN '").append(smartViewHandler.getShortViewHandlerName()).append("' (").append(smartViewHandler.getStateInfo()).append(")").toString();
            String string2 = smartViewHandler2 == null ? "#VSN -" : new StringBuffer().append("#VSN '").append(smartViewHandler2.getShortViewHandlerName()).append("' (").append(smartViewHandler2.getStateInfo()).append(")").toString();
            this.logger.error(8).append(string).append(" --v2v--> ").append(string2).attachThrowable(nullPointerException).log();
        }
        if (n <= 0) {
            this.animationIsRunning = false;
        }
        return n;
    }

    @Override
    public boolean isLeaveOverEnter() {
        return this.leaveOverEnter;
    }

    @Override
    public boolean isEnterViewVisible() {
        return this.enterViewHandler != null && this.enterViewIsVisible;
    }

    @Override
    public boolean isLeaveViewVisible() {
        return this.leaveViewHandler != null && (this.leaveViewIsVisible || !this.enterViewIsVisible);
    }

    protected void stopAnimations(int n) {
        if (this.logger.isTraceEnabled(8)) {
            switch (n) {
                case 0: {
                    this.traceText("ends. (animation ABORTED)");
                    break;
                }
                case 1: {
                    this.traceText("ends. (ENTER animation ended)");
                    break;
                }
                case 2: {
                    this.traceText("ends. (LEAVE animation ended)");
                    break;
                }
                default: {
                    this.traceText("ends. (unknown cause)");
                }
            }
        }
        ++this.currentTransitionNumber;
        if (this.leaveAnimation >= 0 && this.leaveViewHandler != null) {
            this.leaveViewHandler.stopLeaveAnimation(this.leaveAnimation);
        }
        if (this.enterAnimation >= 0 && this.enterViewHandler != null) {
            this.enterViewHandler.stopEnterAnimation(this.enterAnimation);
        }
        this.enterViewIsVisible = false;
        this.leaveViewIsVisible = false;
        this.animationIsRunning = false;
        this.transitionListener.finishViewChange();
    }

    @Override
    public void abort() {
        if (this.animationIsRunning) {
            this.stopAnimations(0);
        }
    }

    protected void onLeaveAnimationStarted(int n) {
        if (this.currentTransitionNumber == n) {
            if (this.logger.isTraceEnabled(8)) {
                this.traceText("'leave animation started!'");
            }
            this.transitionListener.setPaintingEnabled(true);
        } else if (this.logger.isTraceEnabled(8)) {
            this.traceText(new StringBuffer().append("'leave animation started!' for transition ").append(n).append(" SKIPPED!").toString());
        }
    }

    protected void onLeaveAnimationRunning(int n) {
        if (this.currentTransitionNumber == n) {
            if (this.logger.isTraceEnabled(8)) {
                this.traceText("'leave animation running!'");
            }
        } else if (this.logger.isTraceEnabled(8)) {
            this.traceText(new StringBuffer().append("'leave animation running!' for transition ").append(n).append(" SKIPPED!").toString());
        }
    }

    protected void onLeaveAnimationProgress(int n, Animation animation, int n2) {
        if (this.currentTransitionNumber == n) {
            if (this.logger.isTraceEnabled(8)) {
                this.traceText(new StringBuffer().append("'leave animation progress!' (").append(n2).append("/").append(animation.getDuration()).append(")").toString());
            }
        } else if (this.logger.isTraceEnabled(8)) {
            this.traceText(new StringBuffer().append("'leave animation progress!' for transition ").append(n).append(" SKIPPED!").toString());
        }
    }

    protected void onLeaveAnimationStopped(int n) {
        if (this.currentTransitionNumber == n) {
            if (this.logger.isTraceEnabled(8)) {
                this.traceText("'leave animation stopped!'");
            }
            this.waitFor &= 0xFFFFFFFE;
            this.leaveViewIsVisible = false;
            this.transitionListener.updateViewstack();
            if (this.waitFor == 0) {
                this.stopAnimations(2);
            }
        } else if (this.logger.isTraceEnabled(8)) {
            this.traceText(new StringBuffer().append("'leave animation stopped!' for transition ").append(n).append(" SKIPPED!").toString());
        }
    }

    protected void onEnterAnimationStarted(int n) {
        if (this.currentTransitionNumber == n) {
            if (this.logger.isTraceEnabled(8)) {
                this.traceText("'enter animation started!'");
            }
            this.transitionListener.setPaintingEnabled(true);
            this.enterViewIsVisible = true;
            this.transitionListener.updateViewstack();
        } else if (this.logger.isTraceEnabled(8)) {
            this.traceText(new StringBuffer().append("'enter animation started!' for transition ").append(n).append(" SKIPPED!").toString());
        }
    }

    protected void onEnterAnimationRunning(int n) {
        if (this.currentTransitionNumber == n) {
            if (this.logger.isTraceEnabled(8)) {
                this.traceText("'enter animation running!'");
            }
        } else if (this.logger.isTraceEnabled(8)) {
            this.traceText(new StringBuffer().append("'enter animation running!' for transition ").append(n).append(" SKIPPED!").toString());
        }
    }

    protected void onEnterAnimationProgress(int n, Animation animation, int n2) {
        if (this.activateEarlyAtPercent >= 0 && n2 >= animation.getDuration() * this.activateEarlyAtPercent / 100 && !this.activatedEarly) {
            this.transitionListener.activateEarly();
            this.activatedEarly = true;
        }
        if (this.currentTransitionNumber == n) {
            if (this.logger.isTraceEnabled(8)) {
                this.traceText(new StringBuffer().append("'enter animation progress!' (").append(n2).append("/").append(animation.getDuration()).append(")").toString());
            }
        } else if (this.logger.isTraceEnabled(8)) {
            this.traceText(new StringBuffer().append("'enter animation progress!' for transition ").append(n).append(" SKIPPED!").toString());
        }
    }

    protected void onEnterAnimationStopped(int n) {
        if (this.currentTransitionNumber == n) {
            if (this.logger.isTraceEnabled(8)) {
                this.traceText("'enter animation stopped!'");
            }
            this.waitFor &= 0xFFFFFFFD;
            if (this.waitFor == 0) {
                this.stopAnimations(1);
            }
        } else if (this.logger.isTraceEnabled(8)) {
            this.traceText(new StringBuffer().append("'enter animation stopped!' for transition ").append(n).append(" SKIPPED!").toString());
        }
    }

    @Override
    public boolean isAnimationRunning() {
        return this.animationIsRunning;
    }

    @Override
    public boolean abortLeaveAnimation(String string) {
        if (this.isLeaveAnimationRunning(string)) {
            this.leaveViewHandler.stopLeaveAnimation(this.leaveAnimation);
            if ("Sgm".equals(string) && this.leaveViewHandler.getView() != null) {
                this.leaveViewHandler.getView().set_z(0);
            }
            this.leaveViewHandler = null;
            this.leaveViewIsVisible = false;
            this.transitionListener.updateViewstack();
            return true;
        }
        return false;
    }

    @Override
    public boolean isLeaveAnimationRunning(String string) {
        return this.animationIsRunning && this.leaveViewHandler != null && this.leaveAnimation >= 0 && (string == null || string.equals(this.leaveViewHandler.getShortViewHandlerName()));
    }
}

