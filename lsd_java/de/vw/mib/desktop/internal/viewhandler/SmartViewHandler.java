/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.viewhandler;

import de.vw.mib.animation.control.AnimatedPropertiesAccessor;
import de.vw.mib.animation.control.AnimationListener;
import de.vw.mib.desktop.ViewHandlerProvider;
import de.vw.mib.desktop.internal.common.ServiceManager;
import de.vw.mib.desktop.internal.viewhandler.CacheableViewHandler;
import de.vw.mib.desktop.internal.viewhandler.EmptySmartViewHandler;
import de.vw.mib.desktop.internal.viewhandler.SmartViewHandler$SmartViewHandlerIsInABadStateException;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.viewmanager.internal.PopupViewHandler;
import de.vw.mib.viewmanager.internal.ViewHandler;
import de.vw.mib.widgets.models.PopupViewModel;
import de.vw.mib.widgets.models.ScreenAreaModel;
import de.vw.mib.widgets.models.ViewModel;
import java.util.ArrayList;
import java.util.HashMap;

public class SmartViewHandler
extends CacheableViewHandler
implements AnimatedPropertiesAccessor {
    private static final int STATE_DESTROYED;
    private static final int STATE_CREATED;
    private static final int STATE_SETUP;
    private static final int STATE_INITIALIZED;
    private static final int STATE_ENTERED;
    private static final int STATE_ACTIVATED;
    private int currentState;
    private int targetState;
    private int restoreState;
    private boolean linked;
    public static final SmartViewHandler EMPTY_SMART_VIEWHANDLER;
    private static final ScreenAreaModel[] NO_SCREEN_AREAS;
    private final Logger logger = ServiceManager.loggerFactory.getLogger(1024);
    private final ViewHandlerProvider viewHandlerProvider;
    private boolean destroyable = false;
    protected static HashMap viewDiagnostics;
    private boolean opaque = false;
    private final String shortViewHandlerName;
    private String nameForTraces = null;
    private String prettyName = null;
    private boolean resetView = false;
    private boolean stateChangeInProgress = false;
    private boolean touchForwardingModeSet = false;
    private int touchForwardingMode;
    private boolean animationBlockingEnabled = false;

    public SmartViewHandler(ViewHandler viewHandler, String string, ViewHandlerProvider viewHandlerProvider) {
        super(viewHandler);
        this.shortViewHandlerName = string;
        this.viewHandlerProvider = viewHandlerProvider;
        this.reset();
    }

    private void reset() {
        this.currentState = 0;
        this.targetState = 0;
        this.linked = false;
    }

    public void setViewHandler(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        this.reset();
    }

    public String getName() {
        return this.viewHandler == null ? this.shortViewHandlerName : this.viewHandler.getName();
    }

    public String getNameForTraces() {
        if (this.nameForTraces == null) {
            if (this.viewHandler == null) {
                return this.shortViewHandlerName;
            }
            this.nameForTraces = new StringBuffer().append(this.shortViewHandlerName).append(" (").append(this.viewHandler.getName()).append(")").toString();
        }
        return this.nameForTraces;
    }

    public String getShortViewHandlerName() {
        return this.shortViewHandlerName;
    }

    public String getPrettyName() {
        String string;
        if (this.prettyName == null && this.viewHandler != null && (string = this.viewHandler.getName()) != null) {
            boolean bl = true;
            StringBuilder stringBuilder = new StringBuilder(string.length());
            for (int i2 = 0; i2 < string.length(); ++i2) {
                char c2 = string.charAt(i2);
                if (c2 == '_') {
                    bl = true;
                    continue;
                }
                if (bl) {
                    stringBuilder.append(Character.toUpperCase(c2));
                    bl = false;
                    continue;
                }
                stringBuilder.append(Character.toLowerCase(c2));
            }
            stringBuilder.append("ViewHandler");
            this.prettyName = stringBuilder.toString();
        }
        return this.prettyName != null ? this.prettyName : this.getName();
    }

    public void create() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': create()").log();
        }
        this.viewHandler.create();
        this.currentState = 1;
        this.targetState = 1;
    }

    public void setResetView(boolean bl) {
        this.resetView = bl;
    }

    public void setup() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.setup() ").log();
        }
        if (this.targetState < 2) {
            this.targetState = 2;
            this.enterState(this.targetState);
        }
    }

    private void onSetup() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.onSetup()").log();
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': vh.setup() ").append(System.identityHashCode(this)).log();
        }
        this.viewHandler.setup();
        this.viewHandler.getView().setAnimationBlockingEnabled(this.animationBlockingEnabled);
    }

    public void init() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.init() ").append(this.linked ? "linked" : "unlinked").log();
        }
        if (this.targetState < 3) {
            this.targetState = 3;
            if (this.linked) {
                this.enterState(this.targetState);
            }
        }
    }

    private void onInit() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.onInit()").log();
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': vh.init(").append(this.resetView).append(") ").append(System.identityHashCode(this)).log();
        }
        this.viewHandler.init(this.resetView);
        this.viewHandler.getView().setAnimationBlockingEnabled(this.animationBlockingEnabled);
        if (this.touchForwardingModeSet) {
            this.getView().set_touchForwardingMode(this.touchForwardingMode);
        }
        if (this.resetView) {
            this.resetView = false;
        }
    }

    private void onEnter() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': vh.onEnter()").log();
        }
        this.viewHandler.getView().onEnter();
    }

    public void activate(boolean bl) {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.activate() ").append(this.linked ? "linked" : "unlinked").log();
        }
        if (this.targetState < 5) {
            this.targetState = 5;
        }
        if (this.linked && bl) {
            this.enterState(this.targetState);
        }
    }

    private void onActivate() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.onActivate()").log();
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': vh.activate()").log();
        }
        this.viewHandler.activate();
    }

    public void deactivate() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.deactivate() ").append(this.linked ? "linked" : "unlinked").log();
        }
        if (this.targetState > 3) {
            this.targetState = 3;
            if (this.linked) {
                this.enterState(this.targetState);
            }
        }
    }

    private void onDeactivate() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.onDeactivate()").log();
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': vh.deactivate()").log();
        }
        this.viewHandler.deactivate();
    }

    public void reactivate() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.reactivate() ").append(this.linked ? "linked" : "unlinked").log();
        }
        if (this.linked && this.isActive()) {
            this.enterState(1);
            this.enterState(5);
        }
    }

    public boolean isActive() {
        return this.currentState >= 5;
    }

    public void deinit() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.deinit() ").append(this.linked ? "linked" : "unlinked").log();
        }
        if (this.targetState > 2) {
            this.targetState = 2;
            if (this.linked) {
                this.enterState(this.targetState);
            }
        }
    }

    private void onDeinit() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.onDeinit()").log();
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': vh.deinit()").log();
        }
        this.viewHandler.deinit();
    }

    private void onLeave() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': vh.onLeave()").log();
        }
        this.viewHandler.getView().onLeave();
    }

    public void teardown() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.teardown() ").log();
        }
        if (this.targetState > 1) {
            this.targetState = 1;
            if (!this.linked) {
                this.enterState(this.targetState);
            }
        }
    }

    private void onTeardown() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.onTeardown()").log();
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': vh.teardown() ").append(System.identityHashCode(this)).log();
        }
        this.viewHandler.teardown();
    }

    public boolean isInitialized() {
        return this.targetState >= 3;
    }

    public void setDestroyable(boolean bl) {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.setDestroyable(").append(bl).append(")").log();
        }
        this.destroyable = bl;
    }

    public void destroy(char c2) {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.destroy()").append(c2).append(this.linked ? " linked" : " unlinked").log();
        }
        if (this.targetState > 0 && this.destroyable) {
            this.targetState = 0;
            if (!this.linked) {
                this.enterState(this.targetState);
            }
        }
    }

    private void onDestroy() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.onDestroy() ").append(this.destroyable ? "destroyable" : "undestroyable").log();
        }
        if (this.destroyable) {
            String string = super.getClass().getName();
            this.viewHandler.destroy();
            if (this.viewHandler.getView() instanceof PopupViewModel) {
                this.opaque = ((PopupViewModel)this.viewHandler.getView()).is_opaque();
            }
            this.viewHandler = null;
            if (!ServiceManager.skinClassLoader.unloadDataForClass(string)) {
                ServiceManager.desktopManager.setPanic(new StringBuffer().append("Error! Couldn't unload viewhandler ").append(string).toString());
            }
        }
    }

    public void suspend() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.suspend()").log();
        }
        this.deactivate();
        ((PopupViewHandler)this.viewHandler).suspend();
    }

    public void resume() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.resume()").log();
        }
        this.activate(true);
        ((PopupViewHandler)this.viewHandler).resume();
    }

    public void release() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.release()").log();
        }
        this.restoreState = this.currentState;
        this.unlinkFromScreenTree('a');
    }

    public void reload() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.reload()").log();
        }
        ServiceManager.smartViewHandlerProvider.reloadViewHandler(this);
    }

    public void restore() {
        if (this.viewHandler == null) {
            this.logger.warn(128).append("View '").append(this.getNameForTraces()).append("': svh.restore(): viewHandler is null!!!").log();
        } else {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.restore()").log();
            }
            this.targetState = this.restoreState;
            this.enterState(this.targetState);
        }
    }

    public boolean consumeEvent(HMIEvent hMIEvent) {
        return this.viewHandler.consumeEvent(hMIEvent);
    }

    public boolean consumeEvent(TouchEvent touchEvent) {
        try {
            return this.viewHandler.consumeEvent(touchEvent);
        }
        catch (Exception exception) {
            this.logger.error(128).append("View '").append(this.shortViewHandlerName).append("': svh.consumeEvent()").attachThrowable(exception).log();
            return false;
        }
    }

    public void reInit(boolean bl) {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.reInit()").log();
        }
        this.viewHandler.reInit(bl);
    }

    public void invalidate() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.invalidate()").log();
        }
        this.viewHandler.getView().invalidate();
    }

    public boolean is_visible() {
        try {
            return this.viewHandler.getView().is_visible();
        }
        catch (Exception exception) {
            this.logger.error(128).append("View '").append(this.getNameForTraces()).append("': svh.is_visible()").attachThrowable(exception).log();
            return false;
        }
    }

    public boolean startLeaveAnimation(AnimatedPropertiesAccessor animatedPropertiesAccessor, int n, int n2, AnimationListener animationListener) {
        return this.viewHandler.getView().startLeaveAnimation(animatedPropertiesAccessor, n, n2, animationListener);
    }

    public boolean startEnterAnimation(AnimatedPropertiesAccessor animatedPropertiesAccessor, int n, int n2, AnimationListener animationListener) {
        return this.viewHandler.getView().startEnterAnimation(animatedPropertiesAccessor, n, n2, animationListener);
    }

    public void stopLeaveAnimation(int n) {
        this.viewHandler.getView().stopLeaveAnimation(n);
    }

    public void stopEnterAnimation(int n) {
        this.viewHandler.getView().stopEnterAnimation(n);
    }

    public String getStateInfo() {
        return new StringBuffer().append("c").append(this.getStateAsString(this.currentState)).append("t").append(this.getStateAsString(this.targetState)).toString();
    }

    public int getCurrentViewType() {
        return this.viewHandler.getView().getCurrentViewType();
    }

    public void onCover() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.onCover()").append(this.viewHandler.getView().get_name()).log();
        }
        this.viewHandler.getView().onCover();
    }

    public void onUncover() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': svh.onUncover()").log();
        }
        this.viewHandler.getView().onUncover();
    }

    public boolean is_opaque() {
        return this.viewHandler == null ? this.opaque : this.viewHandler.getView().is_opaque();
    }

    public ViewModel getView() {
        return this.viewHandler == null ? null : this.viewHandler.getView();
    }

    public ViewHandlerProvider getViewHandlerProvider() {
        return this.viewHandlerProvider;
    }

    public String toString() {
        return this.getNameForTraces();
    }

    @Override
    public boolean getAnimBooleanValue(int n, int n2) {
        return ((AnimatedPropertiesAccessor)((Object)this.viewHandler)).getAnimBooleanValue(n, n2);
    }

    @Override
    public void setAnimBooleanValue(int n, int n2, boolean bl) {
        ((AnimatedPropertiesAccessor)((Object)this.viewHandler)).setAnimBooleanValue(n, n2, bl);
    }

    @Override
    public int getAnimIntValue(int n, int n2) {
        return ((AnimatedPropertiesAccessor)((Object)this.viewHandler)).getAnimIntValue(n, n2);
    }

    @Override
    public void setAnimIntValue(int n, int n2, int n3) {
        ((AnimatedPropertiesAccessor)((Object)this.viewHandler)).setAnimIntValue(n, n2, n3);
    }

    @Override
    public float getAnimFloatValue(int n, int n2) {
        return ((AnimatedPropertiesAccessor)((Object)this.viewHandler)).getAnimFloatValue(n, n2);
    }

    @Override
    public void setAnimFloatValue(int n, int n2, float f2) {
        ((AnimatedPropertiesAccessor)((Object)this.viewHandler)).setAnimFloatValue(n, n2, f2);
    }

    public static ArrayList addDiagnostics(ArrayList arrayList) {
        return arrayList;
    }

    public void linkToScreenTree(char c2) {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': linkToScreenTree()").append(c2).log();
        }
        this.linked = true;
        if (this.targetState > 1) {
            this.enterState(this.targetState);
        }
    }

    public boolean isLinked() {
        return this.linked;
    }

    public void unlinkFromScreenTree(char c2) {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': unlinkFromScreenTree()").append(c2).log();
        }
        if (this.targetState < 3) {
            this.enterState(this.targetState);
        } else {
            this.enterState(1);
        }
        this.linked = false;
    }

    private String getStateAsString(int n) {
        switch (n) {
            case 0: {
                return "DESTROYED";
            }
            case 1: {
                return "CREATED";
            }
            case 2: {
                return "SET UP";
            }
            case 3: {
                return "INITIALIZED";
            }
            case 4: {
                return "ENTERED";
            }
            case 5: {
                return "ACTIVATED";
            }
        }
        return "<invalid value>";
    }

    private void enterState(int n) {
        if (this.stateChangeInProgress) {
            return;
        }
        this.stateChangeInProgress = true;
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("View '").append(this.getNameForTraces()).append("': enterState(").append(this.getStateAsString(n)).append(")").log();
        }
        if (n != this.currentState) {
            while (n > this.currentState) {
                switch (this.currentState) {
                    case 1: {
                        this.onSetup();
                        break;
                    }
                    case 2: {
                        this.onInit();
                        break;
                    }
                    case 3: {
                        this.onEnter();
                        break;
                    }
                    case 4: {
                        this.onActivate();
                        break;
                    }
                    default: {
                        throw new SmartViewHandler$SmartViewHandlerIsInABadStateException(this, this.getPrettyName(), this.currentState);
                    }
                }
                ++this.currentState;
            }
            while (n < this.currentState) {
                switch (this.currentState) {
                    case 1: {
                        this.onDestroy();
                        break;
                    }
                    case 2: {
                        this.onTeardown();
                        break;
                    }
                    case 3: {
                        this.onDeinit();
                        break;
                    }
                    case 4: {
                        this.onLeave();
                        break;
                    }
                    case 5: {
                        this.onDeactivate();
                        break;
                    }
                    default: {
                        throw new SmartViewHandler$SmartViewHandlerIsInABadStateException(this, this.getPrettyName(), this.currentState);
                    }
                }
                --this.currentState;
            }
        }
        this.stateChangeInProgress = false;
    }

    public ScreenAreaModel[] getScreenAreas() {
        if (this.getViewHandler() == null) {
            return NO_SCREEN_AREAS;
        }
        return this.getViewHandler().getScreenAreas();
    }

    public void setTouchForwardingMode(int n) {
        this.touchForwardingModeSet = true;
        this.touchForwardingMode = n;
        if (this.currentState >= 3) {
            this.getView().set_touchForwardingMode(n);
        }
    }

    public void setAnimationBlockingEnabled(boolean bl) {
        this.animationBlockingEnabled = bl;
    }

    static {
        EMPTY_SMART_VIEWHANDLER = new EmptySmartViewHandler();
        NO_SCREEN_AREAS = new ScreenAreaModel[0];
    }
}

