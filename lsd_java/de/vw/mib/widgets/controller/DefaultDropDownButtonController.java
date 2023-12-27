/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.WidgetList;
import de.vw.mib.widgets.controller.DefaultDropDownButtonController$DropDownCloseListener;
import de.vw.mib.widgets.controller.DefaultDropDownButtonController$InactiveAreaCloseListener;
import de.vw.mib.widgets.controller.DefaultPushButtonController;
import de.vw.mib.widgets.controller.DropDownButtonController;
import de.vw.mib.widgets.controller.ListItemController;
import de.vw.mib.widgets.interfaces.Focusable;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.DropDownButtonModel;
import de.vw.mib.widgets.models.DropDownModel;
import de.vw.mib.widgets.models.InactiveAreaModel;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetListModel;
import de.vw.mib.widgets.models.WidgetModel;

public final class DefaultDropDownButtonController
extends DefaultPushButtonController
implements DropDownButtonController {
    private DefaultDropDownButtonController$DropDownCloseListener ddCloseListener;
    private Rectangle dropDownArrowDestinationArea;
    private DefaultDropDownButtonController$InactiveAreaCloseListener iaCloseListener;

    @Override
    protected void reset() {
        super.reset();
        this.ddCloseListener = new DefaultDropDownButtonController$DropDownCloseListener(this);
        this.dropDownArrowDestinationArea = new Rectangle();
        this.iaCloseListener = new DefaultDropDownButtonController$InactiveAreaCloseListener(this);
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        super.deInit();
    }

    @Override
    public void deActivate() {
        this.fire_closeDropDown();
        super.deActivate();
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        boolean bl = super.consumeHMIEvent(hMIEvent, string);
        if ("openDropDown" == string) {
            this.fire_openDropDown();
            bl = true;
        } else if ("closeDropDown" == string) {
            this.fire_closeDropDown();
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        return super.consumeTouchEvent(touchEvent);
    }

    public DropDownButtonModel getDropDownButton() {
        if (this.getWidget() != null && this.getWidget() instanceof DropDownButtonModel) {
            return (DropDownButtonModel)this.getWidget();
        }
        return null;
    }

    @Override
    public void fire_closeDropDown() {
        DropDownButtonModel dropDownButtonModel = this.getDropDownButton();
        InactiveAreaModel inactiveAreaModel = dropDownButtonModel.get_inactiveAreaRef();
        DropDownModel dropDownModel = dropDownButtonModel != null ? dropDownButtonModel.get_dropDownRef() : null;
        WidgetListModel widgetListModel = dropDownModel != null ? dropDownModel.get_dropDownListRef() : null;
        ListItemModel[] listItemModelArray = widgetListModel != null ? widgetListModel.getListItems() : null;
        ListItemModel listItemModel = listItemModelArray != null && listItemModelArray.length > 0 ? listItemModelArray[0] : null;
        dropDownButtonModel.set_activated(false);
        if (widgetListModel != null) {
            widgetListModel.getController().removeOutEventListener(this.ddCloseListener);
            if (listItemModel != null && dropDownButtonModel.getParent() != null && dropDownButtonModel.getParent() instanceof ListItemModel) {
                ListItemModel listItemModel2 = (ListItemModel)dropDownButtonModel.getParent();
                listItemModel.getController().removeOutEventListener(((ListItemController)listItemModel2.getController()).getListItemEventHandler());
            }
        }
        if (dropDownModel != null && dropDownModel.is_visible()) {
            dropDownModel.set_visible(false);
            this.fire_dropDownClosed();
        }
        if (inactiveAreaModel != null) {
            inactiveAreaModel.unFocus();
            inactiveAreaModel.set_visible(false);
            inactiveAreaModel.getController().removeOutEventListener(this.iaCloseListener);
        }
    }

    @Override
    public void fire_openDropDown() {
        DropDownButtonModel dropDownButtonModel = this.getDropDownButton();
        InactiveAreaModel inactiveAreaModel = dropDownButtonModel.get_inactiveAreaRef();
        DropDownModel dropDownModel = dropDownButtonModel.get_dropDownRef();
        if (inactiveAreaModel != null && dropDownModel != null && dropDownButtonModel.is_openDropDown()) {
            dropDownModel.setFlyingWindowOpeningArea(dropDownButtonModel.get_x(), dropDownButtonModel.get_y(), dropDownButtonModel.get_width(), dropDownButtonModel.get_height());
            this.registerFocusToInactiveArea(dropDownButtonModel, inactiveAreaModel);
            if (!dropDownModel.is_visible()) {
                dropDownModel.set_visible(true);
                this.fire_dropDownOpened();
            }
            inactiveAreaModel.set_visible(true);
            inactiveAreaModel.getController().addOutEventListener(this.iaCloseListener);
            dropDownButtonModel.set_activated(true);
        }
    }

    @Override
    public void fire_release() {
        super.fire_release();
        DropDownButtonModel dropDownButtonModel = this.getDropDownButton();
        if (dropDownButtonModel != null && dropDownButtonModel.get_dropDownRef() != null) {
            if (dropDownButtonModel.get_dropDownRef().is_visible()) {
                this.fire_closeDropDown();
            } else {
                this.fire_openDropDown();
            }
        }
    }

    @Override
    public void fire_dropDownOpened() {
        this.fireHMIEvent("dropDownOpened");
        if (ServiceManager.proximityInstaller != null) {
            try {
                if (LOGGER.isTraceEnabled(1)) {
                    LogMessage logMessage = LOGGER.trace(32);
                    logMessage.append(new StringBuffer().append("DefaultDropDownButtonController '").append(this.getWidget()).append("': Proximity paused, DD opened.").toString()).log();
                }
                ServiceManager.proximityInstaller.pauseProximity(2, true);
            }
            catch (Exception exception) {
                LogMessage logMessage = LOGGER.warn(32);
                logMessage.append(new StringBuffer().append("DefaultDropDownButtonController '").append(this.getWidget()).append("': Proximity pause exception thrown, reset performed: ").toString());
                logMessage.append(exception).log();
                ServiceManager.proximityInstaller.resetProximityPause(2);
            }
        } else {
            LOGGER.warn(1, "Proximity service not available. Needed to pause proximity sensor while DD is opened.");
        }
    }

    @Override
    public void fire_dropDownClosed() {
        this.fireHMIEvent("dropDownClosed");
        if (ServiceManager.proximityInstaller != null) {
            try {
                if (LOGGER.isTraceEnabled(1)) {
                    LogMessage logMessage = LOGGER.trace(32);
                    logMessage.append(new StringBuffer().append("DefaultDropDownButtonController '").append(this.getWidget()).append("': Proximity resumed, DD closed.").toString()).log();
                }
                ServiceManager.proximityInstaller.resumeProximity(2);
            }
            catch (Exception exception) {
                LogMessage logMessage = LOGGER.warn(32);
                logMessage.append(new StringBuffer().append("DefaultDropDownButtonController '").append(this.getWidget()).append("': Proximity resumed exception thrown, reset performed: ").toString());
                logMessage.append(exception).log();
                ServiceManager.proximityInstaller.resetProximityPause(2);
            }
        } else {
            LOGGER.warn(1, "Proximity service not available. Needed to resume proximity sensor after DD is closed.");
        }
    }

    private void registerFocusToInactiveArea(DropDownButtonModel dropDownButtonModel, InactiveAreaModel inactiveAreaModel) {
        DropDownModel dropDownModel;
        WidgetModel widgetModel;
        ViewModel viewModel = dropDownButtonModel.getView();
        for (widgetModel = dropDownButtonModel.getParent(); widgetModel != viewModel && !(widgetModel instanceof WidgetList); widgetModel = widgetModel.getParent()) {
        }
        if (widgetModel != viewModel) {
            inactiveAreaModel.focus((Focusable)widgetModel, false);
        }
        if ((dropDownModel = dropDownButtonModel.get_dropDownRef()) != null) {
            WidgetListModel widgetListModel = dropDownModel.get_dropDownListRef();
            if (widgetListModel != null) {
                ListItemModel listItemModel;
                widgetListModel.getController().addOutEventListener(this.ddCloseListener);
                ListItemModel[] listItemModelArray = widgetListModel.getListItems();
                ListItemModel listItemModel2 = listItemModel = listItemModelArray != null && listItemModelArray.length > 0 ? listItemModelArray[0] : null;
                if (listItemModel != null) {
                    if (dropDownButtonModel.getParent() != null && dropDownButtonModel.getParent() instanceof ListItemModel) {
                        ListItemModel listItemModel3 = (ListItemModel)dropDownButtonModel.getParent();
                        listItemModel.getController().addOutEventListener(((ListItemController)listItemModel3.getController()).getListItemEventHandler());
                    }
                    if (dropDownButtonModel.get_dropDownExistenceFlags() != null && dropDownButtonModel.get_dropDownExistenceFlags().length > 0) {
                        listItemModel.set_existenceFlags(dropDownButtonModel.get_dropDownExistenceFlags());
                    }
                }
            }
            widgetModel.getAbsBounds(dropDownModel.getAutoLayoutArea());
            dropDownButtonModel.getAbsBounds(this.dropDownArrowDestinationArea);
            dropDownModel.setArrowDestinationArea(this.dropDownArrowDestinationArea);
        }
    }
}

