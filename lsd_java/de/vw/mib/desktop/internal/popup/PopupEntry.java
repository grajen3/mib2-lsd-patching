/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.popup;

import de.vw.mib.animation.animations.Animation;
import de.vw.mib.animation.control.AnimationListener;
import de.vw.mib.desktop.internal.common.ServiceManager;
import de.vw.mib.desktop.internal.popup.DynamicStateData;
import de.vw.mib.desktop.internal.popup.PopupEntry$1;
import de.vw.mib.desktop.internal.popup.PopupEntry$2;
import de.vw.mib.desktop.internal.popup.PopupStackManagerImpl;
import de.vw.mib.desktop.internal.viewhandler.SmartViewHandler;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.widgets.models.PopupViewModel;

class PopupEntry {
    private static final boolean SUSPEND;
    private static final boolean RESUME;
    private static final int ENTRYSTATE_HIDDEN;
    private static final int ENTRYSTATE_SHOW;
    private static final int ENTRYSTATE_VISIBLE;
    private static final int ENTRYSTATE_HIDE;
    private static final int ENTRYSTATE_CLOSE;
    private static final int ENTRYSTATE_CLOSED;
    private static final int ENTER_ANIMATION;
    private static final int LEAVE_ANIMATION;
    protected Logger logger;
    private DynamicStateData dynamicStateData;
    private int popupInfoId;
    private String popupViewName;
    private SmartViewHandler popupViewHandler;
    private boolean visible = false;
    private boolean hasBeenVisible = false;
    private int entryState = 0;
    private boolean leaveAnimationRunning = false;
    private boolean enterAnimationRunning = false;
    private boolean active = false;
    protected int sequenceNr = 0;
    private final PopupStackManagerImpl popupStackManager;
    private AnimationListener enterAnimationListener;
    private AnimationListener leaveAnimationListener;
    private boolean leaveAnimationStopped;
    private boolean opaque = false;

    public PopupEntry(PopupStackManagerImpl popupStackManagerImpl, DynamicStateData dynamicStateData, int n, String string) {
        this.popupStackManager = popupStackManagerImpl;
        this.dynamicStateData = dynamicStateData;
        this.popupInfoId = n;
        this.popupViewName = string;
        this.logger = ServiceManager.loggerFactory.getLogger(1024);
    }

    private void traceText(String string) {
        this.logger.trace(256, new StringBuffer().append(this.getPresentationString()).append(": ").append(string).toString());
    }

    private void traceEntryState() {
        this.logger.trace(256, new StringBuffer().append(this.getPresentationString()).append(":").append(this.entryState()).toString());
    }

    private String entryState() {
        switch (this.entryState) {
            case 0: {
                return "<hidden >";
            }
            case 1: {
                return "< show  >";
            }
            case 2: {
                return "<visible>";
            }
            case 3: {
                return "< hide  >";
            }
            case 4: {
                return "< close >";
            }
            case 5: {
                return "<closed >";
            }
        }
        return "<???????>";
    }

    public int getDynamicStateId() {
        return this.dynamicStateData == null ? -1 : this.dynamicStateData.getDynamicStateId();
    }

    public void setDynamicStateData(DynamicStateData dynamicStateData) {
        this.dynamicStateData = dynamicStateData;
    }

    public DynamicStateData getDynamicStateData() {
        return this.dynamicStateData;
    }

    public void setPopupInfoId(int n) {
        this.popupInfoId = n;
    }

    public int getPopupInfoId() {
        return this.popupInfoId;
    }

    public String getGuidePresentationString() {
        return this.popupViewHandler != null ? this.popupViewHandler.getName() : this.popupViewName;
    }

    public String getPresentationString() {
        return this.popupViewHandler != null ? this.popupViewHandler.getPrettyName() : this.popupViewName;
    }

    public String getPopupViewName() {
        return this.popupViewName;
    }

    public void setPopupViewName(String string) {
        this.popupViewName = string;
    }

    public boolean hasViewHandler() {
        return this.popupViewHandler != SmartViewHandler.EMPTY_SMART_VIEWHANDLER;
    }

    public String getViewHandlerName() {
        return this.popupViewHandler != null ? this.popupViewHandler.getName() : null;
    }

    public boolean consumeEvent(HMIEvent hMIEvent) {
        return this.popupViewHandler != null && this.popupViewHandler.is_visible() && this.popupViewHandler.consumeEvent(hMIEvent);
    }

    public boolean consumeEvent(TouchEvent touchEvent) {
        return this.popupViewHandler.consumeEvent(touchEvent);
    }

    public PopupViewModel getView() {
        return (PopupViewModel)this.popupViewHandler.getView();
    }

    public SmartViewHandler getViewHandler() {
        return this.popupViewHandler;
    }

    public void suspend(boolean bl) {
        if (this.logger.isTraceEnabled(256)) {
            this.traceText(new StringBuffer().append("'suspend(includeStatemachineManager: ").append(bl).append(")").toString());
        }
        this.getDynamicStateData().setSuspended(true);
        this.popupViewHandler.suspend();
        if (bl) {
            ServiceManager.statemachineManager.suspendPopup(this.getDynamicStateId());
        }
    }

    public void resume(boolean bl) {
        if (this.logger.isTraceEnabled(256)) {
            this.traceText(new StringBuffer().append("'resume(includeStatemachineManager: ").append(bl).append(")").toString());
        }
        this.getDynamicStateData().setSuspended(false);
        this.popupViewHandler.resume();
        if (bl) {
            ServiceManager.statemachineManager.resumePopup(this.getDynamicStateId());
        }
    }

    public void setPopupViewHandler(SmartViewHandler smartViewHandler) {
        if (smartViewHandler == SmartViewHandler.EMPTY_SMART_VIEWHANDLER && this.popupViewHandler != null && this.popupViewHandler != SmartViewHandler.EMPTY_SMART_VIEWHANDLER) {
            this.opaque = this.popupViewHandler.is_opaque();
        }
        this.popupViewHandler = smartViewHandler;
    }

    public boolean isShowing() {
        return this.entryState != 0;
    }

    public boolean isAvailableAndVisible() {
        return this.popupViewHandler != null && this.visible;
    }

    public boolean isAvailableAndVisibleAndActive() {
        return this.popupViewHandler != null && this.visible && this.active;
    }

    public void setVisible(boolean bl) {
        if (this.logger.isTraceEnabled(256)) {
            this.traceText(new StringBuffer().append("'setVisible(").append(bl).append(")").toString());
        }
        this.visible = bl;
        if (bl && !this.hasBeenVisible && !this.dynamicStateData.isSuppressedBySpeech()) {
            this.dynamicStateData.startTimers();
            this.hasBeenVisible = true;
        }
    }

    public void setHasBeenVisible(boolean bl) {
        this.hasBeenVisible = bl;
    }

    public boolean hasBeenVisible() {
        return this.hasBeenVisible;
    }

    public boolean isViewVisible() {
        return this.popupViewHandler.is_visible();
    }

    public boolean isViewOpaque() {
        return this.popupViewHandler == SmartViewHandler.EMPTY_SMART_VIEWHANDLER ? this.opaque : this.popupViewHandler.is_opaque();
    }

    public void invalidate() {
        this.popupViewHandler.invalidate();
    }

    public void initViewHandler() {
        this.popupViewHandler.setup();
        this.popupViewHandler.init();
    }

    public void activateViewHandler() {
        this.popupViewHandler.activate(true);
    }

    public void deactivateViewHandler() {
        this.popupViewHandler.deactivate();
    }

    public void deinitViewHandler() {
        this.popupViewHandler.deinit();
        this.popupViewHandler.teardown();
    }

    public void release() {
        this.stopPendingAnimations();
        this.popupViewHandler.release();
    }

    public void setActive(boolean bl) {
        this.active = bl;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean isLeaveAnimationRunning() {
        return this.leaveAnimationRunning;
    }

    public void show(boolean bl) {
        if (this.logger.isTraceEnabled(256)) {
            this.traceText(new StringBuffer().append("show(v2v: ").append(bl).append(")").toString());
        }
        if (!(bl && this.entryState == 4 || this.entryState != 0 && this.entryState != 3 && this.entryState != 4)) {
            if (this.leaveAnimationRunning) {
                this.popupViewHandler.stopLeaveAnimation(0);
                this.leaveAnimationRunning = false;
            }
            this.enterAnimationListener = new PopupEntry$1(this);
            this.enterAnimationRunning = true;
            this.entryState = 1;
            this.activateViewHandler();
            if (!this.popupViewHandler.startEnterAnimation(this.popupViewHandler, 0, 0, this.enterAnimationListener)) {
                this.onEnterAnimationStopped(this.sequenceNr);
            }
        }
        if (this.logger.isTraceEnabled(256)) {
            this.traceEntryState();
        }
    }

    public void hide() {
        if (this.logger.isTraceEnabled(256)) {
            this.traceText("hide()");
        }
        if (this.entryState == 1 || this.entryState == 2) {
            this.hide(3);
        }
        if (this.logger.isTraceEnabled(256)) {
            this.traceEntryState();
        }
    }

    public void close() {
        this.dynamicStateData.stopTimers();
        if (this.logger.isTraceEnabled(256)) {
            this.traceText("close()");
        }
        switch (this.entryState) {
            case 1: 
            case 2: {
                this.hide(4);
                break;
            }
            case 3: {
                this.entryState = 4;
                break;
            }
            case 0: {
                this.removeViewHandler();
                break;
            }
        }
        if (this.logger.isTraceEnabled(256)) {
            this.traceEntryState();
        }
    }

    private void hide(int n) {
        if (this.enterAnimationRunning) {
            this.popupViewHandler.stopEnterAnimation(0);
            this.enterAnimationRunning = false;
        }
        this.deactivateViewHandler();
        this.leaveAnimationListener = new PopupEntry$2(this);
        this.leaveAnimationRunning = true;
        this.entryState = n;
        this.leaveAnimationStopped = false;
        if (!this.popupViewHandler.startLeaveAnimation(this.popupViewHandler, 0, 0, this.leaveAnimationListener) && !this.leaveAnimationStopped) {
            this.onLeaveAnimationStopped(this.sequenceNr);
        }
    }

    protected void onEnterAnimationStarted(int n) {
        if (this.sequenceNr == n) {
            if (this.logger.isTraceEnabled(256)) {
                this.traceText("enter animation started");
            }
        } else if (this.logger.isTraceEnabled(256)) {
            this.traceText(new StringBuffer().append("enter animation started skipped (").append(n).append(" != ").append(this.sequenceNr).append(")").toString());
        }
    }

    protected void onEnterAnimationRunning(int n) {
        if (this.sequenceNr == n) {
            if (this.logger.isTraceEnabled(256)) {
                this.traceText("enter animation running");
            }
        } else if (this.logger.isTraceEnabled(256)) {
            this.traceText(new StringBuffer().append("enter animation running skipped (").append(n).append(" != ").append(this.sequenceNr).append(")").toString());
        }
    }

    protected void onEnterAnimationProgress(int n, Animation animation, int n2) {
        if (this.sequenceNr == n) {
            if (this.logger.isTraceEnabled(256)) {
                this.traceText(new StringBuffer().append("'enter animation progress!' (").append(n2).append("/").append(animation.getDuration()).append(")").toString());
            }
        } else if (this.logger.isTraceEnabled(256)) {
            this.traceText(new StringBuffer().append("'enter animation progress!' for transition ").append(n).append(" SKIPPED!").toString());
        }
    }

    protected void onEnterAnimationStopped(int n) {
        if (this.sequenceNr == n) {
            if (this.popupViewHandler != null && this.popupViewHandler.getView().isEnterAnimationRunning()) {
                this.popupViewHandler.stopEnterAnimation(0);
            }
            if (this.logger.isTraceEnabled(256)) {
                this.traceText("enter animation stopped");
            }
            this.enterAnimationRunning = false;
            if (this.entryState == 1) {
                this.entryState = 2;
            }
            if (this.logger.isTraceEnabled(256)) {
                this.traceEntryState();
            }
        } else if (this.logger.isTraceEnabled(256)) {
            this.traceText(new StringBuffer().append("enter animation stopped skipped (").append(n).append(" != ").append(this.sequenceNr).append(")").toString());
        }
    }

    protected void onLeaveAnimationStarted(int n) {
        if (this.sequenceNr == n) {
            if (this.logger.isTraceEnabled(256)) {
                this.traceText("leave animation started");
            }
        } else if (this.logger.isTraceEnabled(256)) {
            this.traceText(new StringBuffer().append("leave animation started skipped (").append(n).append(" != ").append(this.sequenceNr).append(")").toString());
        }
    }

    protected void onLeaveAnimationRunning(int n) {
        if (this.sequenceNr == n) {
            if (this.logger.isTraceEnabled(256)) {
                this.traceText("leave animation running");
            }
        } else if (this.logger.isTraceEnabled(256)) {
            this.traceText(new StringBuffer().append("leave animation running skipped (").append(n).append(" != ").append(this.sequenceNr).append(")").toString());
        }
    }

    protected void onLeaveAnimationProgress(int n, Animation animation, int n2) {
        if (this.sequenceNr == n) {
            if (this.logger.isTraceEnabled(256)) {
                this.traceText(new StringBuffer().append("'leave animation progress!' (").append(n2).append("/").append(animation.getDuration()).append(")").toString());
            }
        } else if (this.logger.isTraceEnabled(256)) {
            this.traceText(new StringBuffer().append("'leave animation progress!' for transition ").append(n).append(" SKIPPED!").toString());
        }
    }

    protected void onLeaveAnimationStopped(int n) {
        this.leaveAnimationStopped = true;
        if (this.sequenceNr == n) {
            this.leaveAnimationStopped();
        } else if (this.logger.isTraceEnabled(256)) {
            this.traceText(new StringBuffer().append("leave animation stopped skipped (").append(n).append(" != ").append(this.sequenceNr).append(")").toString());
        }
    }

    private void leaveAnimationStopped() {
        this.leaveAnimationStopped = true;
        if (this.logger.isTraceEnabled(256)) {
            this.traceText("leave animation stopped");
        }
        if (this.popupViewHandler != null && this.popupViewHandler.getView() != null && this.popupViewHandler.getView().isLeaveAnimationRunning()) {
            new Exception(new StringBuffer().append("Leave animation still running!!! (").append(this.popupViewHandler.getNameForTraces()).append(")").toString());
        }
        this.leaveAnimationRunning = false;
        if (this.entryState == 3 || this.entryState == 4) {
            if (this.entryState == 4) {
                this.removeViewHandler();
                this.entryState = 5;
            } else {
                this.entryState = 0;
            }
            ServiceManager.infotainmentRecorderInfoDirty = true;
        }
        if (this.logger.isTraceEnabled(256)) {
            this.traceEntryState();
        }
    }

    public void reinit() {
        this.dynamicStateData.stopTimers();
        this.visible = false;
        this.hasBeenVisible = false;
    }

    private void removeViewHandler() {
        this.popupViewHandler.deinit();
        this.popupViewHandler.teardown();
        if (this.popupStackManager != null) {
            this.popupStackManager.removeFromStack(this);
        } else {
            this.popupViewHandler = SmartViewHandler.EMPTY_SMART_VIEWHANDLER;
        }
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        return this.popupViewName.equals(((PopupEntry)object).getPopupViewName());
    }

    public int hashCode() {
        return this.popupViewName.hashCode();
    }

    public void stopPendingAnimations() {
        ++this.sequenceNr;
        if (this.logger.isTraceEnabled(256)) {
            this.traceText(new StringBuffer().append("stopPendingAnimations() => sequenceNr: ").append(this.sequenceNr).toString());
        }
        if (this.enterAnimationRunning) {
            this.popupViewHandler.stopEnterAnimation(0);
            this.enterAnimationRunning = false;
        }
        if (this.leaveAnimationRunning) {
            this.popupViewHandler.stopLeaveAnimation(0);
            this.leaveAnimationRunning = false;
            this.leaveAnimationStopped();
            this.entryState = 0;
        }
    }
}

