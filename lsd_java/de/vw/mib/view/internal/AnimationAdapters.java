/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.animation.control.AnimatedPropertiesAccessor;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.view.internal.CloneData;
import de.vw.mib.view.internal.WidgetAnimator;
import de.vw.mib.widgets.interfaces.WidgetCloneable;
import de.vw.mib.widgets.models.WidgetModel;

public class AnimationAdapters
implements AnimatedPropertiesAccessor {
    private static final int[][] EMTPY_DATA = new int[0][];
    public static final AnimationAdapters NONE = new AnimationAdapters();
    public static final int NO_CLONEDATA;
    private static final int COLUMN_ACCESS_ID;
    private static final int COLUMN_WIDGET_INDEX;
    private static final int COLUMN_WIDGET_SUBINDEX;
    private static final int COLUMN_WIDGET_TYPE;
    private static final int COLUMN_WHAT;
    private static final int COLUMN__COUNT;
    static final boolean DEFAULT_BOOLEAN;
    static final int DEFAULT_INT;
    static final float DEFAULT_FLOAT;
    private final int[][] data;
    private final WidgetModel[] widgets;
    private final WidgetAnimator widgetAnimator;

    public AnimationAdapters(int[][] nArray, CloneData cloneData, WidgetAnimator widgetAnimator) {
        Preconditions.checkNotNull(nArray, "Data can not be null. Use AnimationAdapters.NONE instead.");
        Preconditions.checkNotNull(cloneData, "CloneData root can not be null. Use AnimationAdapters.NONE instead.");
        Preconditions.checkNotNull(cloneData.widgets, "Widgets of CloneData root can not be null. Use AnimationAdapters.NONE instead.");
        Preconditions.checkNotNull(widgetAnimator, "WidgetAnimator can not be null. Use AnimationAdapters.NONE instead.");
        this.data = nArray != null ? nArray : EMTPY_DATA;
        this.widgets = cloneData.widgets;
        this.widgetAnimator = widgetAnimator;
        for (int i2 = 0; i2 < this.data.length; ++i2) {
            Preconditions.checkArgument(this.data[i2].length == 5, "Data row expect to have 5 entries.");
        }
    }

    private AnimationAdapters() {
        this.data = EMTPY_DATA;
        this.widgets = null;
        this.widgetAnimator = null;
    }

    @Override
    public boolean getAnimBooleanValue(int n, int n2) {
        return false;
    }

    @Override
    public void setAnimBooleanValue(int n, int n2, boolean bl) {
    }

    @Override
    public int getAnimIntValue(int n, int n2) {
        int[] nArray = this.getDataRow(n);
        if (nArray == null) {
            return 0;
        }
        WidgetModel widgetModel = this.getWidget(nArray);
        return this.widgetAnimator.getAnimatableIntValue(widgetModel, nArray[3], nArray[4]);
    }

    @Override
    public void setAnimIntValue(int n, int n2, int n3) {
        int[] nArray = this.getDataRow(n);
        if (nArray != null) {
            WidgetModel widgetModel = this.widgets[nArray[1]];
            if (this.isInCloneData(nArray)) {
                CloneData cloneData;
                int n4 = nArray[2];
                int n5 = nArray[3];
                int n6 = nArray[4];
                CloneData cloneData2 = cloneData = (CloneData)((WidgetCloneable)((Object)widgetModel)).getCloneData();
                while (cloneData2 != null) {
                    this.widgetAnimator.setAnimatableIntValue(cloneData2.widgets[n4], n5, n6, n3);
                    cloneData2 = cloneData2.next;
                }
            } else {
                this.widgetAnimator.setAnimatableIntValue(widgetModel, nArray[3], nArray[4], n3);
            }
        }
    }

    @Override
    public float getAnimFloatValue(int n, int n2) {
        int[] nArray = this.getDataRow(n);
        if (nArray == null) {
            return 0.0f;
        }
        WidgetModel widgetModel = this.getWidget(nArray);
        return this.widgetAnimator.getAnimatableFloatValue(widgetModel, nArray[3], nArray[4]);
    }

    @Override
    public void setAnimFloatValue(int n, int n2, float f2) {
        int[] nArray = this.getDataRow(n);
        if (nArray != null) {
            WidgetModel widgetModel = this.widgets[nArray[1]];
            if (this.isInCloneData(nArray)) {
                CloneData cloneData;
                int n3 = nArray[2];
                int n4 = nArray[3];
                int n5 = nArray[4];
                CloneData cloneData2 = cloneData = (CloneData)((WidgetCloneable)((Object)widgetModel)).getCloneData();
                while (cloneData2 != null) {
                    this.widgetAnimator.setAnimatableFloatValue(cloneData2.widgets[n3], n4, n5, f2);
                    cloneData2 = cloneData2.next;
                }
            } else {
                this.widgetAnimator.setAnimatableFloatValue(widgetModel, nArray[3], nArray[4], f2);
            }
        }
    }

    private int[] getDataRow(int n) {
        for (int i2 = 0; i2 < this.data.length; ++i2) {
            int[] nArray = this.data[i2];
            if (nArray[0] != n) continue;
            return nArray;
        }
        return null;
    }

    private WidgetModel getWidget(int[] nArray) {
        WidgetModel widgetModel = this.widgets[nArray[1]];
        if (this.isInCloneData(nArray)) {
            CloneData cloneData = (CloneData)((WidgetCloneable)((Object)widgetModel)).getCloneData();
            return cloneData.widgets[nArray[2]];
        }
        return widgetModel;
    }

    private boolean isInCloneData(int[] nArray) {
        return nArray[2] != -1;
    }
}

