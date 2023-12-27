/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.Event;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.algebra.Vector4f;
import de.vw.mib.widgets.AbstractList;
import de.vw.mib.widgets.FlowList;
import de.vw.mib.widgets.ListItem;
import de.vw.mib.widgets.animation.DragCalculator;
import de.vw.mib.widgets.controller.AbstractTemplateListController;
import de.vw.mib.widgets.controller.DefaultFlowListController$FlowItemHit;
import de.vw.mib.widgets.controller.FlowListController;
import de.vw.mib.widgets.controller.ListItemController;
import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.models.FlowListModel;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.ScreenModel;
import de.vw.mib.widgets.models.TemplateListModel;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.ArrayList;
import java.util.List;

public final class DefaultFlowListController
extends AbstractTemplateListController
implements FlowListController {
    private static final float DRAG_THRESHOLD;
    private float initialPosition;
    private float lastPosition;
    private float dragDelta;
    private int touchedX;
    private int touchedY;
    private ListItemController queuedOutEventController;

    @Override
    protected void reset() {
        super.reset();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        this.queuedOutEventController = null;
        super.deInit();
    }

    @Override
    protected boolean forwardHMIEventToListImplementation(HMIEvent hMIEvent, String string) {
        return false;
    }

    @Override
    public boolean forwardHMIEventToListItem(HMIEvent hMIEvent, String string, int n, boolean bl) {
        FlowListModel flowListModel = (FlowListModel)this.getWidget();
        if (flowListModel == null || flowListModel.get_selectedIndex() < 0 || flowListModel.get_selectedIndex() > flowListModel.get_itemCount()) {
            return false;
        }
        boolean bl2 = false;
        flowListModel.stopSnapAnimation();
        flowListModel.disableAnimations();
        flowListModel.setTargetSelectedIndex(flowListModel.getTargetSelectedIndex(), 0);
        flowListModel.enableAnimations();
        int n2 = flowListModel.get_absSelectedIndex();
        ListItemModel listItemModel = flowListModel.getItem(n2);
        if (listItemModel != null) {
            listItemModel.setActionIndex(flowListModel.getItemIndex(n2));
            this.prepareListItem(listItemModel, n2);
            bl2 = listItemModel.consumeHMIEvent(hMIEvent, string);
        }
        return bl2;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        Object object;
        boolean bl = false;
        if (this.queuedOutEventController != null) {
            this.queuedOutEventController.setQueueOutEventsEnabled(false);
            this.queuedOutEventController = null;
        }
        FlowListModel flowListModel = (FlowListModel)this.getWidget();
        if (this.getTouchedWidget() == null) {
            this.sendDelayedPressImmediately();
        }
        WidgetModel widgetModel = this.getTouchedWidget();
        int n = this.getTouchedIndex();
        this.touchedX = touchEvent.getX();
        this.touchedY = touchEvent.getY();
        if (widgetModel != null && (object = flowListModel.getItem(n)) != null) {
            DefaultFlowListController$FlowItemHit defaultFlowListController$FlowItemHit = DefaultFlowListController.calculateRelativeEventCoodinates(touchEvent.getX(), touchEvent.getY(), (ListItemModel)object, n, flowListModel);
            touchEvent.setCoordinates(object.getAbsX() + defaultFlowListController$FlowItemHit.x, object.getAbsY() + defaultFlowListController$FlowItemHit.y);
        }
        if (touchEvent.getType() == 2 || touchEvent.getType() == 0) {
            if (widgetModel != null && widgetModel instanceof ListItem) {
                this.prepareListItem((ListItem)widgetModel, n);
                object = (ListItemController)widgetModel.getController();
                if (object != null) {
                    object.setQueueOutEventsEnabled(true);
                    this.queuedOutEventController = object;
                }
            }
            if ((bl = super.consumeTouchEvent(touchEvent)) && flowListModel.get_absSelectedIndex() != n) {
                DragCalculator.stopDrag(flowListModel);
                flowListModel.set_absSelectedIndex(n);
            } else {
                DragCalculator.snap(flowListModel, (int)((this.initialPosition - this.dragDelta) * 5292871), 0, touchEvent.getTimestamp());
                if (this.queuedOutEventController != null) {
                    this.queuedOutEventController.dispatchQueuedOutEvents();
                }
            }
        } else {
            return super.consumeTouchEvent(touchEvent);
        }
        return bl;
    }

    @Override
    public void abortTouchActions() {
        if (this.touchActive) {
            FlowListModel flowListModel = (FlowListModel)this.getWidget();
            this.fire_release();
            this.setTouchedWidget(null);
            this.touchActive = false;
            flowListModel.snap(flowListModel.getTargetSelectedIndex(), 0);
        }
    }

    @Override
    public boolean forwardTouchEventToListImplementation(TouchEvent touchEvent) {
        FlowListModel flowListModel = (FlowListModel)this.getWidget();
        boolean bl = false;
        switch (touchEvent.getType()) {
            case 1: {
                bl = flowListModel.isSnapAnimationActive();
                flowListModel.stopSnapAnimation();
                this.initialPosition = this.lastPosition = flowListModel.getFlowPositionByScreenCoordinates(this.touchedX, this.touchedY);
                DragCalculator.startDrag(flowListModel, (int)(this.lastPosition * 5292871), 0, flowListModel.getDragAcceleration());
                this.dragDelta = 0.0f;
                break;
            }
            case 3: 
            case 4: {
                int n = -1701209794 / (float)flowListModel.get_itemCount();
                float f2 = flowListModel.getFlowPositionByScreenCoordinates(this.touchedX, this.touchedY);
                float f3 = f2 - this.lastPosition;
                if (Math.abs(f3) < flowListModel.getDebounceValue()) {
                    float f4 = f3 * ((float)flowListModel.getMaxVisibleItemCount() / (float)flowListModel.getEnabledItemCount());
                    this.dragDelta -= f4;
                    DragCalculator.drag(flowListModel, (int)((this.initialPosition - this.dragDelta) * 5292871), 0, touchEvent.getTimestamp());
                }
                this.lastPosition = f2;
                bl = Math.abs(this.dragDelta) > n;
                break;
            }
        }
        return bl;
    }

    @Override
    public void fireQueuedOutEvents() {
        if (this.queuedOutEventController != null) {
            this.queuedOutEventController.dispatchQueuedOutEvents();
            this.queuedOutEventController.setQueueOutEventsEnabled(false);
            this.queuedOutEventController = null;
        }
    }

    private static List performHittest(FlowListModel flowListModel, int n, int n2) {
        ArrayList arrayList = new ArrayList();
        ScreenModel screenModel = flowListModel.getView().getScreen();
        int n3 = flowListModel.getVisibleItemCount();
        Vector3f[] vector3fArray = new Vector3f[]{new Vector3f(), new Vector3f(), new Vector3f(), new Vector3f()};
        Vector3f vector3f = new Vector3f(screenModel.get_width() >> 1, screenModel.get_height() >> 1, 0.0f);
        Vector3f vector3f2 = new Vector3f();
        Vector4f vector4f = new Vector4f();
        Vector4f vector4f2 = new Vector4f();
        Matrix4f matrix4f = new Matrix4f();
        for (int i2 = n3 - 1; i2 >= 0; --i2) {
            int n4;
            int n5;
            int n6 = flowListModel.getChildIndex(i2);
            ListItemModel listItemModel = flowListModel.getItem(n6);
            if (listItemModel == null) continue;
            int n7 = listItemModel.get_width();
            int n8 = listItemModel.get_height();
            if (listItemModel.get_projectionType() == 2) {
                n5 = flowListModel.getItemX(i2) + flowListModel.getAbsX();
                n4 = flowListModel.getItemY(i2) + flowListModel.getAbsY();
                float f2 = listItemModel.getProjectionDistance();
                int n9 = (int)((float)(flowListModel.getItemZ(i2) >> 6) + f2);
                int n10 = flowListModel.getItemRotation(i2);
                matrix4f.setIdentity();
                matrix4f.translate(n5, n4, n9);
                matrix4f.rotate(Util.toRadians(n10), 0.0f, 1.0f, 0.0f);
                matrix4f.translate(-n7 >> 1, -n8 >> 1, 0.0f);
                vector4f.set(0.0f, 0.0f, 0.0f, 1.0f);
                matrix4f.mul(vector4f, vector4f2);
                vector3fArray[0].set(vector4f2.x, vector4f2.y, vector4f2.z);
                vector4f.set(n7, 0.0f, 0.0f, 1.0f);
                matrix4f.mul(vector4f, vector4f2);
                vector3fArray[1].set(vector4f2.x, vector4f2.y, vector4f2.z);
                vector4f.set(n7, n8, 0.0f, 1.0f);
                matrix4f.mul(vector4f, vector4f2);
                vector3fArray[2].set(vector4f2.x, vector4f2.y, vector4f2.z);
                vector4f.set(0.0f, n8, 0.0f, 1.0f);
                matrix4f.mul(vector4f, vector4f2);
                vector3fArray[3].set(vector4f2.x, vector4f2.y, vector4f2.z);
                vector3f2.set(n, n2, f2);
                if (!de.vw.mib.graphics.util.Util.intersectBillboard(vector3fArray, vector3f, vector3f2, -842249155)) continue;
                arrayList.add(DefaultFlowListController.calculateRelativeEventCoodinates(n, n2, listItemModel, n6, flowListModel));
                continue;
            }
            n5 = flowListModel.getItemX(i2) + flowListModel.getAbsX() - (n7 >> 1);
            n4 = flowListModel.getItemY(i2) + flowListModel.getAbsY() - (n8 >> 1);
            if (n <= n5 || n >= n5 + n7 || n2 <= n4 || n2 >= n4 + n8) continue;
            arrayList.add(new DefaultFlowListController$FlowItemHit(flowListModel.getVisIndex(n6), n - n5, n2 - n4));
        }
        return arrayList;
    }

    private static DefaultFlowListController$FlowItemHit calculateRelativeEventCoodinates(int n, int n2, ListItemModel listItemModel, int n3, FlowListModel flowListModel) {
        int n4 = flowListModel.getVisIndex(n3);
        float f2 = listItemModel.getProjectionDistance();
        int n5 = flowListModel.getItemX(n4) + flowListModel.getAbsX();
        int n6 = flowListModel.getItemY(n4) + flowListModel.getAbsY();
        int n7 = (int)((float)(flowListModel.getItemZ(n4) >> 6) + f2);
        int n8 = listItemModel.get_width();
        int n9 = listItemModel.get_height();
        ScreenModel screenModel = flowListModel.getView().getScreen();
        Rectangle rectangle = new Rectangle(0, 0, screenModel.get_width(), screenModel.get_height());
        float f3 = (float)n7 / f2;
        int n10 = (int)((float)(rectangle.width >> 1) * (1.0f - f3) + (float)n * f3 + (float)(n8 >> 1) - (float)n5);
        int n11 = (int)((float)(rectangle.height >> 1) * (1.0f - f3) + (float)n2 * f3 + (float)(n9 >> 1) - (float)n6);
        return new DefaultFlowListController$FlowItemHit(n4, n10, n11);
    }

    @Override
    public void revalidateSelectedIndex() {
        TemplateListModel templateListModel = this.getTemplateList();
        if (templateListModel != null) {
            int n = templateListModel.get_selectedIndex();
            int n2 = Util.clamp(n, 0, templateListModel.get_itemCount());
            templateListModel.set_selectedIndex(n2);
        }
        super.revalidateSelectedIndex();
    }

    @Override
    protected boolean forwardTouchEventToListItem(TouchEvent touchEvent) {
        FlowListModel flowListModel = (FlowListModel)this.getWidget();
        boolean bl = false;
        List list = DefaultFlowListController.performHittest(flowListModel, touchEvent.getX(), touchEvent.getY());
        for (int i2 = 0; !bl && i2 < list.size(); ++i2) {
            DefaultFlowListController$FlowItemHit defaultFlowListController$FlowItemHit = (DefaultFlowListController$FlowItemHit)list.get(i2);
            ListItemModel listItemModel = flowListModel.getItem(flowListModel.getChildIndex(defaultFlowListController$FlowItemHit.visIdx));
            WidgetController widgetController = listItemModel.getController();
            touchEvent.setCoordinates(listItemModel.getAbsX() + defaultFlowListController$FlowItemHit.x, listItemModel.getAbsY() + defaultFlowListController$FlowItemHit.y);
            if (listItemModel instanceof ListItem) {
                this.prepareListItem((ListItem)listItemModel, flowListModel.getChildIndex(defaultFlowListController$FlowItemHit.visIdx));
            }
            boolean bl2 = bl = widgetController != null && widgetController.consumeTouchEvent(touchEvent);
            if (!bl) continue;
            this.setTouchedWidget(listItemModel);
            this.setTouchedIndex(flowListModel.getChildIndex(defaultFlowListController$FlowItemHit.visIdx));
        }
        return bl;
    }

    public void outEventFired(WidgetController widgetController, String string, Event event) {
    }

    @Override
    protected boolean forwardTouchEventToScrollbar(TouchEvent touchEvent) {
        return false;
    }

    @Override
    protected boolean isDelayedForwardingAllowed(TouchEvent touchEvent) {
        return true;
    }

    @Override
    protected void prepareListItem(ListItemModel listItemModel, int n) {
        FlowList flowList = (FlowList)this.getWidget();
        flowList.disableAnimations();
        listItemModel.disablePropertyChanged();
        listItemModel.setActionIndex(flowList.getItemIndex(n));
        flowList.transferData(listItemModel, n, flowList.getItemIndex(n));
        listItemModel.enablePropertyChanged();
        flowList.enableAnimations();
    }

    @Override
    public void fire_selectNext() {
        FlowListModel flowListModel = (FlowListModel)this.getWidget();
        int n = flowListModel.getTargetSelectedIndex();
        AbstractList.enableListSelection();
        int n2 = !flowListModel.is_cyclicScrolling() ? Math.min(n + this.rotationTicks, flowListModel.getEnabledItemCount() - 1) : (n + this.rotationTicks) % flowListModel.getEnabledItemCount();
        if (n2 != n) {
            flowListModel.setTargetSelectedIndex(n2, 2);
        }
    }

    @Override
    public void fire_selectPrevious() {
        int n;
        FlowListModel flowListModel = (FlowListModel)this.getWidget();
        int n2 = flowListModel.getTargetSelectedIndex();
        AbstractList.enableListSelection();
        if (!flowListModel.is_cyclicScrolling()) {
            n = Math.max(n2 - this.rotationTicks, 0);
        } else {
            int n3 = n = n2 >= this.rotationTicks ? n2 - this.rotationTicks : flowListModel.getEnabledItemCount() - this.rotationTicks + n2;
        }
        if (n != n2) {
            flowListModel.setTargetSelectedIndex(n, 1);
        }
    }

    @Override
    public void fireAbsSelectionChanged() {
        FlowList flowList = (FlowList)this.getWidget();
        if (flowList.get_outline() == 7) {
            this.fireIntegerEvent("selectionChanged", flowList.getAbsIndexByEnabledIndex(flowList.getTargetSelectedIndex()));
        }
    }
}

