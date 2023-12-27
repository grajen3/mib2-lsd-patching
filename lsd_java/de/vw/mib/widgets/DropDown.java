/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.PushUp;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.DropDownModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetListModel;
import de.vw.mib.widgets.models.WidgetModel;
import java.io.IOException;

public class DropDown
extends PushUp
implements DropDownModel {
    private WidgetListModel dropDownListRef;
    private int layoutAlignment;
    private int yOffset;
    private Rectangle autoLayoutArea;
    private Rectangle flyingWindowOpeningArea;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$DropDownUI;

    @Override
    protected void reset() {
        super.reset();
        this.autoLayoutArea = null;
        this.dropDownListRef = null;
        this.flyingWindowOpeningArea = new Rectangle();
        this.layoutAlignment = 0;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, boolean bl4, int n2, int n3, int n4, Color[] colorArray, Image[] imageArray, int n5, WidgetListModel widgetListModel, EasingParams[] easingParamsArray, boolean bl5, int[] nArray, int[] nArray2, Image[] imageArray2, int n6, int n7, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, int n8, LayoutAttribs layoutAttribs, boolean bl7, String string, int n9, Image image2, int n10, boolean bl8, int n11, int n12, Insets insets, boolean bl9, int n13, int n14, int n15, int n16) {
        super.init(bl, n, image, bl2, bl3, n2, n3, n4, colorArray, imageArray, n5, easingParamsArray, bl5, nArray, nArray2, imageArray2, n6, n7, keyframeAnimationArray, bl6, layoutAttribs, string, n9, image2, n10, bl8, n11, n12, insets, bl9, n13, n14, n15);
        this.dropDownListRef = widgetListModel;
        this.layoutAlignment = n8;
        this.yOffset = n16;
        this.setInternalStateFlag(18, bl4);
        this.setInternalStateFlag(19, bl7);
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, boolean bl4, int n2, int n3, int n4, Color[] colorArray, Image[] imageArray, int n5, WidgetListModel widgetListModel, EasingParams[] easingParamsArray, boolean bl5, int n6, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, int n7, LayoutAttribs layoutAttribs, boolean bl7, String string, int n8, Image image2, int n9, boolean bl8, int n10, int n11, Insets insets, boolean bl9, int n12, int n13, int n14, int n15) {
        super.init(bl, n, image, bl2, bl3, n2, n3, n4, colorArray, imageArray, n5, easingParamsArray, bl5, n6, keyframeAnimationArray, bl6, layoutAttribs, string, n8, image2, n9, bl8, n10, n11, insets, bl9, n12, n13, n14);
        this.dropDownListRef = widgetListModel;
        this.layoutAlignment = n7;
        this.yOffset = n15;
        this.setInternalStateFlag(18, bl4);
        this.setInternalStateFlag(19, bl7);
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, boolean bl4, int n2, int n3, int n4, Image[] imageArray, int n5, WidgetListModel widgetListModel, EasingParams[] easingParamsArray, boolean bl5, int n6, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, int n7, LayoutAttribs layoutAttribs, boolean bl7, String string, int n8, Image image2, int n9, boolean bl8, int n10, int n11, Insets insets, boolean bl9, int n12, int n13, int n14, int n15) {
        this.init(bl, n, image, bl2, bl3, bl4, n2, n3, n4, null, imageArray, n5, widgetListModel, easingParamsArray, bl5, n6, keyframeAnimationArray, bl6, n7, layoutAttribs, bl7, string, n8, image2, n9, bl8, n10, n11, insets, bl9, n12, n13, n14, n15);
    }

    @Override
    public void init(ViewModel viewModel) {
        this.autoLayoutArea = new Rectangle();
        if (viewModel != null) {
            viewModel.getBounds(this.autoLayoutArea);
        }
        if (this.dropDownListRef != null) {
            this.dropDownListRef.set_listControlEnabled(false);
        }
        super.init(viewModel);
    }

    @Override
    public final boolean is_closeAutomatically() {
        return this.getInternalStateFlag(18);
    }

    @Override
    public final void set_closeAutomatically(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(18);
        if (bl2 != bl) {
            this.setInternalStateFlag(18, bl);
            this.closeAutomaticallyChanged(bl2);
            this.propertyChanged(38);
        }
    }

    @Override
    public final WidgetListModel get_dropDownListRef() {
        return this.dropDownListRef;
    }

    @Override
    public final void set_dropDownListRef(WidgetListModel widgetListModel) {
        WidgetListModel widgetListModel2 = this.dropDownListRef;
        if (widgetListModel2 != widgetListModel) {
            this.dropDownListRef = widgetListModel;
            this.dropDownListRefChanged(widgetListModel2);
            this.propertyChanged(39);
        }
    }

    @Override
    public final int get_layoutAlignment() {
        return this.layoutAlignment;
    }

    @Override
    public final void set_layoutAlignment(int n) {
        int n2 = this.layoutAlignment;
        if (n2 != n) {
            this.layoutAlignment = n;
            this.layoutAlignmentChanged(n2);
            this.propertyChanged(40);
        }
    }

    @Override
    public final boolean is_layoutAutomatically() {
        return this.getInternalStateFlag(19);
    }

    @Override
    public final void set_layoutAutomatically(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(19);
        if (bl2 != bl) {
            this.setInternalStateFlag(19, bl);
            this.layoutAutomaticallyChanged(bl2);
            this.propertyChanged(41);
        }
    }

    @Override
    public final int get_yOffset() {
        return this.yOffset;
    }

    @Override
    public final void set_yOffset(int n) {
        int n2 = this.yOffset;
        if (n2 != n) {
            this.yOffset = n;
            this.dropDownYOffsetChanged(n2);
            this.propertyChanged(42);
        }
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$DropDownUI == null ? (class$de$vw$mib$widgets$ui$DropDownUI = DropDown.class$("de.vw.mib.widgets.ui.DropDownUI")) : class$de$vw$mib$widgets$ui$DropDownUI};
    }

    @Override
    public Rectangle getAutoLayoutArea() {
        return this.autoLayoutArea;
    }

    @Override
    public void setAutoLayoutArea(Rectangle rectangle) {
        this.autoLayoutArea = rectangle;
    }

    @Override
    public Rectangle getFlyingWindowOpeningArea() {
        return this.flyingWindowOpeningArea;
    }

    @Override
    public void setFlyingWindowOpeningArea(int n, int n2, int n3, int n4) {
        this.flyingWindowOpeningArea.setBounds(n, n2, n3, n4);
    }

    protected void closeAutomaticallyChanged(boolean bl) {
    }

    protected void dropDownListRefChanged(WidgetListModel widgetListModel) {
    }

    protected void dropDownYOffsetChanged(int n) {
    }

    protected void layoutAlignmentChanged(int n) {
    }

    protected void layoutAutomaticallyChanged(boolean bl) {
    }

    @Override
    protected void visibleChanged(boolean bl) {
        if (this.dropDownListRef != null) {
            this.dropDownListRef.setInitialSelectionMode(1);
        }
        super.visibleChanged(bl);
    }

    @Override
    protected Rectangle calculateAnimationParams(int n) {
        switch (n) {
            case 8: {
                return new Rectangle(this.get_x(), this.getArrowDestinationArea().y + (this.getArrowDestinationArea().height >> 1), this.get_width(), 0);
            }
        }
        return super.calculateAnimationParams(n);
    }

    @Override
    protected void updateLayout() {
        int n = this.get_scalingPivot();
        switch (n ^ 0x100) {
            case 8: {
                if ((n & 0x100) == 0) break;
                Dimension dimension = this.calculateDimension();
                this.set_height(dimension.height);
                break;
            }
            default: {
                super.updateLayout();
            }
        }
        this.updateDropDownPosition();
    }

    private Point getPositionByAdjustHorizontal() {
        WidgetModel widgetModel = this.getParent();
        Point point = new Point(0, 0);
        if (widgetModel != null) {
            point = new Point(this.get_x() - widgetModel.get_x(), this.get_y() - widgetModel.get_y());
            if (this.get_flyingWindowMode() == 1 || this.get_flyingWindowMode() == 3) {
                if (this.getFlyingWindowOpeningArea().getX() - widgetModel.get_x() + this.getFlyingWindowOpeningArea().getWidth() / 2 > widgetModel.get_width() / 2) {
                    point.setX(this.getFlyingWindowOpeningArea().getX() - widgetModel.get_x() - this.get_width());
                    this.setCompositeBackgroundImagesByMode(5);
                } else {
                    point.setX(this.getFlyingWindowOpeningArea().getX() + this.getFlyingWindowOpeningArea().width - widgetModel.get_x());
                    this.setCompositeBackgroundImagesByMode(4);
                }
            }
        }
        return point;
    }

    private Point getPositionByAdjustVertical() {
        WidgetModel widgetModel = this.getParent();
        Point point = new Point(this.get_x(), this.get_y());
        if (widgetModel != null && (this.get_flyingWindowMode() == 2 || this.get_flyingWindowMode() == 3)) {
            point.setX(this.getFlyingWindowOpeningArea().getX() - widgetModel.get_x() - (this.get_width() >> 1));
            point.setY(this.get_y());
            if (this.getFlyingWindowOpeningArea().getY() > widgetModel.get_height() / 2) {
                point.setY(this.getFlyingWindowOpeningArea().getY() - widgetModel.get_y() - this.get_height());
                this.setCompositeBackgroundImagesByMode(3);
            } else {
                point.setY(this.getFlyingWindowOpeningArea().getY() + this.getFlyingWindowOpeningArea().height - widgetModel.get_y());
                this.setCompositeBackgroundImagesByMode(2);
            }
        }
        return point;
    }

    private void adjustArrowDestinationArea() {
        try {
            WidgetModel widgetModel = this.getParent();
            if (this.get_compositeBackgroundImages().length >= 5) {
                BufferImage bufferImage = ServiceManager.imageManager.getImageFromCurrentSkin(this.get_compositeBackgroundImages()[4]);
                Rectangle rectangle = this.getArrowDestinationArea();
                switch (this.get_compositeBackgroundMode()) {
                    case 4: 
                    case 5: {
                        if (rectangle.getY() + this.get_compositeBackgroundArrowOffsetY() < widgetModel.get_y()) {
                            rectangle.setY(widgetModel.get_y() - this.get_compositeBackgroundArrowOffsetY() + 1);
                            break;
                        }
                        if (widgetModel.get_y() + widgetModel.get_height() >= rectangle.getY() + this.get_compositeBackgroundArrowOffsetY() + bufferImage.getHeight()) break;
                        rectangle.setY(widgetModel.get_y() + this.get_y() + this.get_height() - bufferImage.getHeight() - 1);
                        break;
                    }
                    case 2: 
                    case 3: {
                        if (rectangle.getX() < widgetModel.get_x()) {
                            rectangle.setX(widgetModel.get_x() + bufferImage.getWidth() + this.get_compositeBackgroundArrowOffsetX());
                            break;
                        }
                        if (rectangle.getX() <= widgetModel.get_x() + widgetModel.get_width()) break;
                        rectangle.setX(widgetModel.get_x() + widgetModel.get_width() - bufferImage.getWidth() - this.get_compositeBackgroundArrowOffsetX());
                        break;
                    }
                }
                this.setArrowDestinationArea(rectangle);
            }
        }
        catch (IOException iOException) {
            LogMessage logMessage = LOGGER.error(1);
            logMessage.append("Widget '").append(this).append("': Unable to load composite background image: ").append(iOException).log();
        }
    }

    private void adjustFlyingWindowPosition() {
        WidgetModel widgetModel = this.getParent();
        if (widgetModel != null) {
            if (this.get_x() < 0) {
                this.set_x(0);
            }
            if (this.get_x() + this.get_width() > widgetModel.get_width()) {
                this.set_x(widgetModel.get_width() - this.get_width());
            }
            if (this.get_y() + this.get_height() > widgetModel.get_height()) {
                this.set_y(widgetModel.get_height() - this.get_height());
            }
            if (this.get_y() < 0) {
                this.set_y(0);
            }
        }
    }

    protected void adjustLayoutByFlyingWindow() {
        Point point = new Point(this.get_x(), this.get_y());
        WidgetModel widgetModel = this.getParent();
        if (widgetModel != null) {
            switch (this.get_flyingWindowMode()) {
                case 1: {
                    point = this.getPositionByAdjustHorizontal();
                    break;
                }
                case 2: {
                    point = this.getPositionByAdjustVertical();
                    break;
                }
                case 3: {
                    point = this.getPositionByAdjustVertical();
                    if (point.getY() + this.get_height() <= widgetModel.get_height() && point.getY() >= 0) break;
                    point = this.getPositionByAdjustHorizontal();
                    break;
                }
            }
            if (this.get_flyingWindowMode() != 0) {
                this.set_x(point.getX());
                this.set_y(point.getY());
                this.adjustFlyingWindowPosition();
            }
            this.adjustArrowDestinationArea();
        }
    }

    private void updateDropDownPosition() {
        if (this.is_layoutAutomatically()) {
            int n;
            WidgetModel widgetModel;
            int n2 = 0;
            if (this.dropDownListRef != null && this.dropDownListRef.get_itemCount() > 0) {
                int n3;
                widgetModel = this.getParent();
                if (widgetModel == null) {
                    return;
                }
                this.dropDownListRef.validateList();
                n = this.dropDownListRef.getFirstVisibleIndex();
                int n4 = this.dropDownListRef.getLastVisibleIndex();
                int n5 = n4 - n;
                switch (this.layoutAlignment) {
                    case 1: {
                        n3 = n;
                        break;
                    }
                    case 2: {
                        n3 = n4;
                        break;
                    }
                    default: {
                        n3 = n5 >> 1;
                    }
                }
                int n6 = this.getArrowDestinationArea().y - this.dropDownListRef.getItemY(n3);
                int n7 = this.dropDownListRef.getItemY(n4) + this.dropDownListRef.getItemHeight(n4);
                if (this.layoutAlignment == 0) {
                    if (n6 < this.autoLayoutArea.y && n3 > n) {
                        while ((n6 = this.getArrowDestinationArea().y - this.dropDownListRef.getItemY(--n3)) < this.autoLayoutArea.y && n3 > n) {
                        }
                        if (n6 + n7 > this.autoLayoutArea.y + this.autoLayoutArea.height && n6 > widgetModel.get_y() && n3 < n4) {
                            while ((n6 = this.getArrowDestinationArea().y - this.dropDownListRef.getItemY(++n3)) + n7 > widgetModel.get_y() + widgetModel.get_height() && n3 < n4) {
                            }
                        }
                    } else if (n6 + n7 > this.autoLayoutArea.y + this.autoLayoutArea.height && n3 < n4) {
                        while ((n6 = this.getArrowDestinationArea().y - this.dropDownListRef.getItemY(++n3)) + n7 > this.autoLayoutArea.y + this.autoLayoutArea.height && n3 < n4) {
                        }
                    }
                }
                n2 = n6 - this.dropDownListRef.get_y();
            } else {
                n2 = this.getArrowDestinationArea().y;
            }
            this.disableAnimations();
            widgetModel = this.getParent();
            n = widgetModel == null ? 0 : widgetModel.getAbsY();
            this.set_y(n2 + this.yOffset - n);
            this.adjustLayoutByFlyingWindow();
            this.enableAnimations();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

