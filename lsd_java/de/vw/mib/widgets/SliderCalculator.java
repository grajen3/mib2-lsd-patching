/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.graphics.math.Util;
import de.vw.mib.widgets.models.AbstractSliderModel;
import de.vw.mib.widgets.models.ScrollbarModel;
import de.vw.mib.widgets.models.StaticImageModel;

public final class SliderCalculator {
    public static int calculateSliderValueByPosition(AbstractSliderModel abstractSliderModel, int n) {
        switch (abstractSliderModel.get_orientation()) {
            case 1: {
                n = abstractSliderModel.get_width() - n;
                break;
            }
            case 3: {
                n = abstractSliderModel.get_height() - n;
                break;
            }
        }
        int n2 = Math.round((float)(n - abstractSliderModel.get_paddingMin()) / abstractSliderModel.getScaleRatio()) + abstractSliderModel.get_valueMin();
        return n2;
    }

    public static int calculateSliderPositionByValue(AbstractSliderModel abstractSliderModel, int n) {
        int n2 = 0;
        int n3 = Math.round((float)(Util.clamp(n, abstractSliderModel.get_valueMin(), abstractSliderModel.get_valueMax()) - abstractSliderModel.get_valueMin()) * abstractSliderModel.getScaleRatio());
        switch (abstractSliderModel.get_orientation()) {
            case 1: {
                n2 = abstractSliderModel.get_width() - n3 - abstractSliderModel.get_paddingMin();
                break;
            }
            case 3: {
                n2 = abstractSliderModel.get_height() - n3 - abstractSliderModel.get_paddingMin();
                break;
            }
            default: {
                n2 = n3 + abstractSliderModel.get_paddingMin();
            }
        }
        return n2;
    }

    public static int calculateScrollValueByTouchPoint(ScrollbarModel scrollbarModel, int n) {
        int n2 = Util.clamp(Math.round((float)(n - scrollbarModel.getValuePoint()) / scrollbarModel.getScaleRatio() + (float)scrollbarModel.get_valueMin()), scrollbarModel.get_valueMin(), scrollbarModel.get_valueMax());
        return n2;
    }

    public static int calculateScrollbarPositionByValue(ScrollbarModel scrollbarModel, int n) {
        int n2 = 0;
        int n3 = n - scrollbarModel.get_valueMin();
        boolean bl = scrollbarModel.is_jump();
        int n4 = scrollbarModel.getPositionOnScrollbarButton();
        float f2 = scrollbarModel.getScaleRatio();
        n2 = bl && n4 == -2 ? Math.round((float)n3 * f2 + (float)scrollbarModel.getValuePoint()) : (bl && n4 == -1 ? Math.round((float)n3 * f2 + (float)scrollbarModel.getValuePoint()) : (!bl && n4 < 0 ? Math.round((float)n3 * f2) + scrollbarModel.getValuePoint() : Math.round((float)n3 * f2) - n4 + scrollbarModel.getValuePoint()));
        return n2;
    }

    public static int getRelativePositionByOrientation(AbstractSliderModel abstractSliderModel, int n, int n2, boolean bl) {
        int n3 = abstractSliderModel.get_orientation();
        if (n3 == 0 || n3 == 1) {
            if (bl) {
                return Util.clamp(n - abstractSliderModel.getAbsX(), 0, abstractSliderModel.get_width() - 1);
            }
            return n - abstractSliderModel.getAbsX();
        }
        if (bl) {
            return Util.clamp(n2 - abstractSliderModel.getAbsY(), 0, abstractSliderModel.get_height() - 1);
        }
        return n2 - abstractSliderModel.getAbsY();
    }

    public static int getPositionOnScrollbarButton(AbstractSliderModel abstractSliderModel, int n, int n2, StaticImageModel staticImageModel) {
        int n3 = n - abstractSliderModel.getAbsX();
        int n4 = n2 - abstractSliderModel.getAbsY();
        int n5 = -3;
        if (abstractSliderModel.get_orientation() == 0 || abstractSliderModel.get_orientation() == 1) {
            int n6 = staticImageModel.get_x();
            int n7 = n6 + staticImageModel.get_width();
            n5 = n3 < n6 ? -1 : (n3 > n7 ? -2 : n3 - n6);
        } else {
            int n8 = staticImageModel.get_y();
            int n9 = n8 + staticImageModel.get_height();
            n5 = n4 < n8 ? -1 : (n4 > n9 ? -2 : n4 - n8);
        }
        return n5;
    }
}

