/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.skin.V2vAnimationIndexProvider;
import de.vw.mib.view.internal.View2ViewAnimationsResDataAccess;

public class View2ViewAnimations
implements V2vAnimationIndexProvider {
    private static final int HEADER_VIEW_GROUP_COUNT;
    private final Logger logger;
    private int viewGroupCount;
    private int[] animationLeaveIndex;
    private int[] animationEnterIndex;
    private int[] animationLeaveDelay;
    private int[] animationEnterDelay;
    private int[] animationAudioRampDelay;
    private byte[] animationLeaveOverEnter;

    public View2ViewAnimations(LoggerFactory loggerFactory) {
        this.logger = loggerFactory.getLogger(1024);
    }

    private int get(int[] nArray, int n, int n2, int n3) {
        if (nArray == null) {
            this.logger.error(8, "View 2 View animation not loaded for current skin.");
            return n;
        }
        if (n2 < 0 || n2 >= this.viewGroupCount) {
            LogMessage logMessage = this.logger.error(8);
            logMessage.append("Leave index ").append(n2);
            logMessage.append(" out of range 0..").append(this.viewGroupCount);
            logMessage.log();
            return n;
        }
        if (n3 < 0 || n3 >= this.viewGroupCount) {
            LogMessage logMessage = this.logger.error(8);
            logMessage.append("Enter index ").append(n3);
            logMessage.append(" out of range 0..").append(this.viewGroupCount);
            logMessage.log();
            return n;
        }
        return nArray[n2 * this.viewGroupCount + n3];
    }

    private boolean get(byte[] byArray, boolean bl, int n, int n2) {
        if (byArray == null) {
            this.logger.error(8, "View 2 View animation not loaded for current skin.");
            return bl;
        }
        if (n < 0 || n >= this.viewGroupCount) {
            LogMessage logMessage = this.logger.error(8);
            logMessage.append("Leave index ").append(n);
            logMessage.append(" out of range 0..").append(this.viewGroupCount);
            logMessage.log();
            return bl;
        }
        if (n2 < 0 || n2 >= this.viewGroupCount) {
            LogMessage logMessage = this.logger.error(8);
            logMessage.append("Enter index ").append(n2);
            logMessage.append(" out of range 0..").append(this.viewGroupCount);
            logMessage.log();
            return bl;
        }
        return byArray[n * this.viewGroupCount + n2] != 0;
    }

    public int getViewGroupCount() {
        return this.viewGroupCount;
    }

    @Override
    public int getLeaveAnimationIdx(int n, int n2) {
        return this.get(this.animationLeaveIndex, -1, n, n2);
    }

    @Override
    public int getEnterAnimationIdx(int n, int n2) {
        return this.get(this.animationEnterIndex, -1, n, n2);
    }

    @Override
    public int getLeaveAnimationDelay(int n, int n2) {
        return this.get(this.animationLeaveDelay, 0, n, n2);
    }

    @Override
    public int getEnterAnimationDelay(int n, int n2) {
        return this.get(this.animationEnterDelay, 0, n, n2);
    }

    @Override
    public int getAudioRampDelay(int n, int n2) {
        return this.get(this.animationAudioRampDelay, 0, n, n2);
    }

    @Override
    public boolean isDrawLeaveOverEnterAnimation(int n, int n2) {
        return this.get(this.animationLeaveOverEnter, false, n, n2);
    }

    void updateData(View2ViewAnimationsResDataAccess view2ViewAnimationsResDataAccess) {
        this.viewGroupCount = view2ViewAnimationsResDataAccess.getHeader()[3];
        this.animationLeaveIndex = view2ViewAnimationsResDataAccess.getAnimationLeaveIndex();
        this.animationEnterIndex = view2ViewAnimationsResDataAccess.getAnimationEnterIndex();
        this.animationLeaveDelay = view2ViewAnimationsResDataAccess.getAnimationLeaveDelay();
        this.animationEnterDelay = view2ViewAnimationsResDataAccess.getAnimationEnterDelay();
        this.animationAudioRampDelay = view2ViewAnimationsResDataAccess.getAnimationAudioRampDelay();
        this.animationLeaveOverEnter = view2ViewAnimationsResDataAccess.getAnimationLeaveOverEnter();
    }
}

