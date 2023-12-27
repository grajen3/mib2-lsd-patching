/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.controller.AbstractListController;
import de.vw.mib.widgets.controller.ControlBarController;
import de.vw.mib.widgets.controller.DefaultControlBarController$ButtonListener;
import de.vw.mib.widgets.controller.DefaultControlBarController$InactiveAreaListener;
import de.vw.mib.widgets.event.DefaultTouchDelegator;
import de.vw.mib.widgets.event.TouchDelegatable;
import de.vw.mib.widgets.event.TouchDelegator;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.layout.ControlBarPushUpLayout;
import de.vw.mib.widgets.models.ButtonModel;
import de.vw.mib.widgets.models.ControlBarModel;
import de.vw.mib.widgets.models.InactiveAreaModel;
import de.vw.mib.widgets.models.PushUpModel;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.List;

public final class DefaultControlBarController
extends AbstractListController
implements ControlBarController,
TouchDelegatable {
    private static int NO_GROUP = -1;
    private DefaultControlBarController$ButtonListener buttonListener;
    private DefaultControlBarController$InactiveAreaListener inactiveAreaListener;
    private TouchDelegator touchDelegator;

    @Override
    protected void reset() {
        super.reset();
    }

    @Override
    public void init() {
        super.init();
        this.buttonListener = new DefaultControlBarController$ButtonListener(this);
        this.inactiveAreaListener = new DefaultControlBarController$InactiveAreaListener(this);
        this.touchDelegator = new DefaultTouchDelegator(this, this.buttonListener);
    }

    @Override
    public void deInit() {
        this.buttonListener = null;
        this.inactiveAreaListener = null;
        this.touchDelegator = null;
        super.deInit();
    }

    @Override
    public void deActivate() {
        this.hideInactiveArea();
        this.hideAllPushups();
        super.deActivate();
    }

    @Override
    public int getTouchForwardingMode() {
        return 0;
    }

    public ControlBarModel getControlBar() {
        if (this.getWidget() != null && this.getWidget() instanceof ControlBarModel) {
            return (ControlBarModel)this.getWidget();
        }
        return null;
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        if ("selectNext" == string || "selectPrevious" == string) {
            return false;
        }
        return super.consumeHMIEvent(hMIEvent, string);
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        return this.touchDelegator.forwardTouchEvent(touchEvent);
    }

    public void setPushUpVisibility(boolean bl) {
        PushUpModel pushUpModel;
        PushUpModel[] pushUpModelArray;
        ControlBarModel controlBarModel = this.getControlBar();
        int n = controlBarModel.get_selectedIndex();
        if (-1 != n && (pushUpModelArray = controlBarModel.get_pushUpRefs()) != null && n < pushUpModelArray.length && null != (pushUpModel = pushUpModelArray[n])) {
            WidgetModel widgetModel = (WidgetModel)controlBarModel.getActiveChildren().get(n);
            if (controlBarModel.is_layoutAutomatically()) {
                ControlBarPushUpLayout.adjustPushUpPosition(this.getWidget().getView(), pushUpModel, widgetModel);
                pushUpModel.disablePropertyChanged();
                pushUpModel.set_visible(bl);
                pushUpModel.enablePropertyChanged();
            } else {
                Rectangle rectangle = pushUpModel.getArrowDestinationArea();
                rectangle.setBounds(widgetModel.getAbsX(), widgetModel.getAbsY(), widgetModel.get_width(), widgetModel.get_height());
                pushUpModel.set_visible(bl);
            }
        }
    }

    protected void hideAllPushups() {
        ControlBarModel controlBarModel = this.getControlBar();
        PushUpModel[] pushUpModelArray = controlBarModel.get_pushUpRefs();
        boolean bl = false;
        controlBarModel.set_activated(false);
        if (pushUpModelArray != null) {
            for (int i2 = 0; i2 < pushUpModelArray.length; ++i2) {
                if (null == pushUpModelArray[i2] || !pushUpModelArray[i2].is_visible()) continue;
                bl = true;
                pushUpModelArray[i2].set_visible(false);
            }
        }
        if (bl) {
            this.fire_pushUpClosed();
        }
    }

    private int getGroup(int[] nArray, int n) {
        if (nArray != null && nArray.length > n) {
            return nArray[n];
        }
        return NO_GROUP;
    }

    protected void hidePushups(int n) {
        ControlBarModel controlBarModel = this.getControlBar();
        PushUpModel[] pushUpModelArray = controlBarModel.get_pushUpRefs();
        int[] nArray = controlBarModel.get_pushUpRefsGroups();
        int n2 = this.getGroup(nArray, n);
        boolean bl = false;
        controlBarModel.set_activated(false);
        if (pushUpModelArray != null) {
            for (int i2 = 0; i2 < pushUpModelArray.length; ++i2) {
                int n3;
                if (null == pushUpModelArray[i2] || (n3 = this.getGroup(nArray, i2)) != NO_GROUP && n2 != n3 || !pushUpModelArray[i2].is_visible()) continue;
                bl = true;
                pushUpModelArray[i2].set_visible(false);
            }
        }
        if (bl) {
            this.fire_pushUpClosed();
        }
    }

    protected void showInactiveArea() {
        ControlBarModel controlBarModel = this.getControlBar();
        InactiveAreaModel inactiveAreaModel = controlBarModel.get_inactiveAreaRef();
        if (inactiveAreaModel != null && !inactiveAreaModel.is_visible()) {
            inactiveAreaModel.set_visible(true);
            inactiveAreaModel.getController().addOutEventListener(this.inactiveAreaListener);
        }
    }

    protected void hideInactiveArea() {
        ControlBarModel controlBarModel = (ControlBarModel)this.getWidget();
        InactiveAreaModel inactiveAreaModel = controlBarModel.get_inactiveAreaRef();
        if (inactiveAreaModel != null && inactiveAreaModel.is_visible()) {
            inactiveAreaModel.set_visible(false);
            inactiveAreaModel.getController().removeOutEventListener(this.inactiveAreaListener);
        }
    }

    private int getChildIndex(ControlBarModel controlBarModel, WidgetModel widgetModel) {
        List list = controlBarModel.getActiveChildren();
        return list.indexOf(widgetModel);
    }

    private void pauseProximity() {
        if (ServiceManager.proximityInstaller != null) {
            try {
                if (LOGGER.isTraceEnabled(1)) {
                    LogMessage logMessage = LOGGER.trace(1);
                    logMessage.append(new StringBuffer().append("DefaultControlBarController '").append(this.getWidget()).append("': Proximity paused, PU opened.").toString()).log();
                }
                ServiceManager.proximityInstaller.pauseProximity(2, true);
            }
            catch (Exception exception) {
                LogMessage logMessage = LOGGER.warn(1);
                logMessage.append(new StringBuffer().append("DefaultControlBarController '").append(this.getWidget()).append("': Proximity pause exception thrown, reset performed: ").toString());
                logMessage.append(exception).log();
                ServiceManager.proximityInstaller.resetProximityPause(2);
            }
        } else {
            LOGGER.warn(1, "Proximity service not available. Needed to pause proximity sensor while PU is opened.");
        }
    }

    private void resumeProximity() {
        if (ServiceManager.proximityInstaller != null) {
            try {
                if (LOGGER.isTraceEnabled(1)) {
                    LogMessage logMessage = LOGGER.trace(1);
                    logMessage.append(new StringBuffer().append("DefaultControlBarController '").append(this.getWidget()).append("': Proximity resumed, PU closed.").toString()).log();
                }
                ServiceManager.proximityInstaller.resumeProximity(2);
            }
            catch (Exception exception) {
                LogMessage logMessage = LOGGER.warn(1);
                logMessage.append(new StringBuffer().append("DefaultControlBarController '").append(this.getWidget()).append("': Proximity resumed exception thrown, reset performed: ").toString());
                logMessage.append(exception).log();
                ServiceManager.proximityInstaller.resetProximityPause(2);
            }
        } else {
            LOGGER.warn(1, "Proximity service not available. Needed to resume proximity sensor after PU is closed.");
        }
    }

    @Override
    public void findActiveWidgets(List list, TouchEvent touchEvent) {
        this.getWidget().findTouchEventConsumingWidgets(list, touchEvent);
    }

    @Override
    public void onTouchEventForward(TouchEvent touchEvent, WidgetModel widgetModel) {
    }

    @Override
    public boolean onTouchEventForwarded(TouchEvent touchEvent, WidgetModel widgetModel, boolean bl) {
        return bl;
    }

    @Override
    public void fire_pushUpOpened() {
        ControlBarModel controlBarModel = this.getControlBar();
        int n = this.getChildIndex(controlBarModel, controlBarModel.getCurrentActiveWidget());
        if (n != -1) {
            PushUpModel[] pushUpModelArray = controlBarModel.get_pushUpRefs();
            if (pushUpModelArray != null && n >= 0 && n < pushUpModelArray.length && null != pushUpModelArray[n]) {
                controlBarModel.getCurrentActiveWidget().set_activated(true);
            }
            this.pauseProximity();
        }
        this.fireHMIEvent("pushUpOpened");
        this.fire_pushUpOpenedDetailed();
        this.fire_pushUpOpenedByButton();
    }

    @Override
    public void fire_pushUpOpenedDetailed() {
        ControlBarModel controlBarModel = this.getControlBar();
        int n = this.getChildIndex(controlBarModel, controlBarModel.getCurrentActiveWidget());
        this.fireIntegerEvent("pushUpOpenedDetailed", n);
    }

    @Override
    public void fire_pushUpOpenedByButton() {
        ControlBarModel controlBarModel = this.getControlBar();
        ButtonModel buttonModel = (ButtonModel)controlBarModel.getCurrentActiveWidget();
        if (buttonModel != null) {
            this.fireStringEvent("pushUpOpenedByButton", buttonModel.get_eventSender());
        }
    }

    @Override
    public void fire_pushUpClosed() {
        ControlBarModel controlBarModel = this.getControlBar();
        int n = this.getChildIndex(controlBarModel, controlBarModel.getCurrentActiveWidget());
        if (n != -1) {
            PushUpModel[] pushUpModelArray = controlBarModel.get_pushUpRefs();
            if (pushUpModelArray != null && n >= 0 && n < pushUpModelArray.length && null != pushUpModelArray[n]) {
                controlBarModel.getCurrentActiveWidget().set_activated(false);
            }
            this.resumeProximity();
        }
        this.fireHMIEvent("pushUpClosed");
    }

    private boolean isAllRefPushupsClosed() {
        ControlBarModel controlBarModel = this.getControlBar();
        PushUpModel[] pushUpModelArray = controlBarModel.get_pushUpRefs();
        for (int i2 = 0; i2 < pushUpModelArray.length; ++i2) {
            if (pushUpModelArray[i2] == null || !pushUpModelArray[i2].is_visible()) continue;
            return false;
        }
        return true;
    }

    protected void managePushupActivation(WidgetModel widgetModel) {
        ControlBarModel controlBarModel = this.getControlBar();
        boolean bl = false;
        boolean bl2 = controlBarModel.is_activated();
        int n = this.getChildIndex(controlBarModel, widgetModel);
        if ((bl2 || !this.isAllRefPushupsClosed()) && n != controlBarModel.get_selectedIndex()) {
            controlBarModel.disableAnimations();
            this.hidePushups(n);
            bl2 = false;
            controlBarModel.enableAnimations();
        }
        if (n != -1) {
            PushUpModel[] pushUpModelArray = controlBarModel.get_pushUpRefs();
            bl2 = pushUpModelArray != null && n >= 0 && n < pushUpModelArray.length && null != pushUpModelArray[n] ? !bl2 : false;
            bl = false;
        } else {
            bl = true;
            bl2 = false;
        }
        if (bl2) {
            controlBarModel.setCurrentActiveWidget(widgetModel);
            this.showInactiveArea();
            this.fire_pushUpOpened();
        } else {
            this.hideInactiveArea();
            this.fire_pushUpClosed();
        }
        controlBarModel.set_selectedIndex(n);
        if (bl) {
            this.hideAllPushups();
        }
        this.setPushUpVisibility(bl2);
        controlBarModel.set_activated(bl2);
    }

    static /* synthetic */ TouchDelegator access$000(DefaultControlBarController defaultControlBarController) {
        return defaultControlBarController.touchDelegator;
    }
}

