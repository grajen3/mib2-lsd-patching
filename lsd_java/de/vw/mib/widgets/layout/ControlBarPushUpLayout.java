/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.layout;

import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.models.ControlBarModel;
import de.vw.mib.widgets.models.PushUpModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;

public final class ControlBarPushUpLayout {
    public static void adjustPushUpPosition(ControlBarModel controlBarModel, PushUpModel pushUpModel) {
        WidgetModel widgetModel;
        PushUpModel[] pushUpModelArray = controlBarModel.get_pushUpRefs();
        int n = -1;
        if (pushUpModelArray != null && pushUpModelArray.length > 0) {
            for (int i2 = pushUpModelArray.length - 1; i2 >= 0; --i2) {
                if (pushUpModelArray[i2] != pushUpModel) continue;
                n = i2;
                break;
            }
        }
        if ((widgetModel = controlBarModel.getChild(n)) != null) {
            ControlBarPushUpLayout.adjustPushUpPosition(controlBarModel.getView(), pushUpModel, widgetModel);
        }
    }

    public static void adjustPushUpPosition(ViewModel viewModel, PushUpModel pushUpModel, WidgetModel widgetModel) {
        int n = pushUpModel.getParent().get_width();
        int n2 = pushUpModel.getParent().getAbsX();
        int n3 = n2 + n;
        int n4 = widgetModel.get_width();
        int n5 = widgetModel.getAbsX();
        int n6 = pushUpModel.get_width();
        if (n6 >= n) {
            pushUpModel.set_x(0);
        } else if (n5 + n4 / 2 < n2 + n6 / 2) {
            pushUpModel.set_x(0);
        } else if (n5 + n4 / 2 > n3 - n6 / 2) {
            pushUpModel.set_x(n - n6);
        } else {
            int n7 = n5 + n4 / 2 - n6 / 2 - n2;
            pushUpModel.set_x(n7);
        }
        ControlBarPushUpLayout.layoutArrowDestinationArea(pushUpModel, widgetModel);
    }

    private static void layoutArrowDestinationArea(PushUpModel pushUpModel, WidgetModel widgetModel) {
        Rectangle rectangle = pushUpModel.getArrowDestinationArea();
        rectangle.x = widgetModel.getAbsX();
        rectangle.y = widgetModel.getAbsY();
        rectangle.width = widgetModel.get_width();
        rectangle.height = widgetModel.get_height();
        pushUpModel.set_compositeBackgroundMode(7);
        pushUpModel.setArrowDestinationArea(rectangle);
    }
}

