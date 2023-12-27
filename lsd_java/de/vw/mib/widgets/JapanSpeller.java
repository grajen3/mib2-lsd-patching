/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.widgets.AsiaSpeller;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.InactiveAreaModel;
import de.vw.mib.widgets.models.JapanSpellerModel;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.TemplateListModel;
import de.vw.mib.widgets.models.TouchAreaModel;
import de.vw.mib.widgets.models.WidgetModel;

public class JapanSpeller
extends AsiaSpeller
implements JapanSpellerModel {
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$JapanSpellerUI;

    @Override
    public void init(boolean bl, int n, int n2, String[] stringArray, int[] nArray, Image image, boolean bl2, boolean bl3, boolean bl4, int n3, int n4, int n5, int n6, int n7, Color[] colorArray, Image[] imageArray, int n8, EasingParams[] easingParamsArray, boolean bl5, int n9, boolean bl6, int[] nArray2, int[] nArray3, Image[] imageArray2, int n10, int n11, TouchAreaModel touchAreaModel, boolean bl7, ContainerModel[] containerModelArray, WidgetModel[] widgetModelArray, int n12, ContainerModel[] containerModelArray2, Image[] imageArray3, InactiveAreaModel inactiveAreaModel, String string, int n13, KeyframeAnimation[] keyframeAnimationArray, int n14, String[] stringArray2, boolean bl8, LayoutAttribs layoutAttribs, int[] nArray4, boolean[] blArray, int[] nArray5, ListItemModel[] listItemModelArray, TemplateListModel[] templateListModelArray, int n15, int n16, int n17, String string2, boolean bl9, boolean bl10, int n18, Image image2, int n19, boolean bl11, int n20, boolean bl12, SpellerData spellerData, Insets insets, int n21, int n22, boolean bl13, int n23, Insets insets2, boolean bl14, boolean bl15, int n24, boolean bl16, int n25, int n26) {
        n13 = 2;
        super.init(bl, n, n2, stringArray, nArray, image, bl2, bl3, bl4, n3, n4, n5, n6, n7, colorArray, imageArray, n8, easingParamsArray, bl5, n9, bl6, nArray2, nArray3, imageArray2, n10, n11, touchAreaModel, bl7, containerModelArray, widgetModelArray, n12, containerModelArray2, imageArray3, inactiveAreaModel, string, n13, keyframeAnimationArray, n14, stringArray2, bl8, layoutAttribs, nArray4, blArray, nArray5, listItemModelArray, templateListModelArray, n15, n16, n17, string2, bl9, bl10, n18, image2, n19, bl11, n20, bl12, spellerData, insets, n21, n22, bl13, n23, insets2, bl14, bl15, n24, bl16, n25, n26);
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$JapanSpellerUI == null ? (class$de$vw$mib$widgets$ui$JapanSpellerUI = JapanSpeller.class$("de.vw.mib.widgets.ui.JapanSpellerUI")) : class$de$vw$mib$widgets$ui$JapanSpellerUI};
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

