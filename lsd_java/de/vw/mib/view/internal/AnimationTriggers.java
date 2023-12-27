/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.animation.control.AnimatedPropertiesAccessor;
import de.vw.mib.datapool.ModelDatapool;
import de.vw.mib.datapool.ModelDatapoolObserver;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.view.internal.CloneData;
import de.vw.mib.widgets.animation.Animatable;
import de.vw.mib.widgets.interfaces.WidgetCloneable;
import de.vw.mib.widgets.models.WidgetModel;
import edu.emory.mathcs.backport.java.util.Arrays;

public class AnimationTriggers
implements ModelDatapoolObserver {
    private static final boolean DISABLE_CLONEWIDGET_ANIMATION = Boolean.getBoolean("disable.animated.clonewidgets");
    private static final int[][] EMTPY_DATA = new int[0][];
    public static final AnimationTriggers NONE = new AnimationTriggers();
    public static final int TYPE_DP_BOOLEAN;
    public static final int MODE_START_KEYFRAMEANIMATION;
    public static final int MODE_STOP_KEYFRAMEANIMATION;
    public static final int GUARD_FALSE;
    public static final int GUARD_TRUE;
    public static final int NO_CLONEDATA;
    private static final int NO_PROPERTY;
    private static final int COLUMN_TYPE;
    private static final int COLUMN_TRIGGER_ID;
    private static final int COLUMN_GUARD;
    private static final int COLUMN_WIDGET_INDEX;
    private static final int COLUMN_WIDGET_SUBINDEX;
    private static final int COLUMN_MODE;
    private static final int COLUMN_KEYFRAME_ANIMATION_INDEX;
    private static final int COLUMN__COUNT;
    private final int[][] data;
    private final WidgetModel[] widgets;
    private final AnimatedPropertiesAccessor accessor;
    private final ModelDatapool datapool;

    public AnimationTriggers(int[][] nArray, CloneData cloneData, AnimatedPropertiesAccessor animatedPropertiesAccessor, ModelDatapool modelDatapool) {
        Preconditions.checkNotNull(nArray, "Data can not be null. Use AnimationTrigger.NONE instead.");
        Preconditions.checkNotNull(cloneData, "CloneData root can not be null. Use AnimationTrigger.NONE instead.");
        Preconditions.checkNotNull(cloneData.widgets, "Widgets of CloneData root can not be null. Use AnimationTrigger.NONE instead.");
        Preconditions.checkNotNull(animatedPropertiesAccessor, "Accessor can not be null. Use AnimationTrigger.NONE instead.");
        Preconditions.checkNotNull(modelDatapool, "Datapool can not be null. Use AnimationTrigger.NONE instead.");
        this.data = nArray;
        this.widgets = cloneData.widgets;
        this.accessor = animatedPropertiesAccessor;
        this.datapool = modelDatapool;
        for (int i2 = 0; i2 < this.data.length; ++i2) {
            Preconditions.checkArgument(this.data[i2] != null, "Data row expect to be set.");
            Preconditions.checkArgument(this.data[i2].length == 7, "Data row expect to have 7 entries.");
        }
    }

    private AnimationTriggers() {
        this.data = EMTPY_DATA;
        this.widgets = null;
        this.accessor = null;
        this.datapool = null;
    }

    public void registerDpPropertyTriggers() {
        int n = -1;
        for (int i2 = 0; i2 < this.data.length; ++i2) {
            int[] nArray = this.data[i2];
            if (n == nArray[1]) continue;
            n = nArray[1];
            this.datapool.registerObserver(n, this);
        }
    }

    public void deregisterDpPropertyTriggers() {
        int n = -1;
        for (int i2 = 0; i2 < this.data.length; ++i2) {
            int[] nArray = this.data[i2];
            if (n == nArray[1]) continue;
            n = nArray[1];
            this.datapool.unregisterObserver(n, this);
        }
    }

    @Override
    public void datapoolValueChanged(int n) {
        for (int i2 = 0; i2 < this.data.length; ++i2) {
            int[] nArray = this.data[i2];
            if (n != nArray[1]) continue;
            this.processTriggerRow(nArray);
        }
    }

    private void processTriggerRow(int[] nArray) {
        switch (nArray[0]) {
            case 0: {
                if (!this.matchDatapoolBooleanTriggerRow(nArray)) break;
                this.handleTriggerRow(nArray);
                break;
            }
            default: {
                throw this.invalidDataException(nArray, "Unknown type for DP trigger.");
            }
        }
    }

    private boolean matchDatapoolBooleanTriggerRow(int[] nArray) {
        if (nArray[3] == -1) {
            return false;
        }
        boolean bl = nArray[2] == 1;
        boolean bl2 = this.datapool.getBoolean(nArray[1]);
        return bl2 == bl;
    }

    private void handleTriggerRow(int[] nArray) {
        WidgetModel widgetModel = this.widgets[nArray[3]];
        if (!this.isWidgetInCloneData(nArray)) {
            this.triggerAnimation(widgetModel, nArray);
        } else if (!DISABLE_CLONEWIDGET_ANIMATION) {
            CloneData cloneData = (CloneData)((WidgetCloneable)((Object)widgetModel)).getCloneData();
            WidgetModel widgetModel2 = cloneData.widgets[nArray[4]];
            this.triggerAnimation(widgetModel2, nArray);
        }
    }

    private boolean isWidgetInCloneData(int[] nArray) {
        return nArray[4] != -1;
    }

    private void triggerAnimation(WidgetModel widgetModel, int[] nArray) {
        if (!(widgetModel instanceof Animatable)) {
            throw this.invalidDataException(nArray, new StringBuffer().append("Invalid widget class. Expected Animatable but found: ").append(super.getClass().getName()).toString());
        }
        Animatable animatable = (Animatable)((Object)widgetModel);
        int n = nArray[5];
        int n2 = nArray[6];
        switch (n) {
            case 0: {
                this.startKeyframeAnimation(animatable, n2);
                break;
            }
            case 1: {
                this.stopKeyframeAnimation(animatable, n2);
                break;
            }
            default: {
                throw this.invalidDataException(nArray, "Unsupported 'what'.");
            }
        }
    }

    private void stopKeyframeAnimation(Animatable animatable, int n) {
        animatable.stopKeyframeAnimation(n);
    }

    private void startKeyframeAnimation(Animatable animatable, int n) {
        animatable.startKeyframeAnimation(this.accessor, n);
    }

    private AssertionError invalidDataException(int[] nArray, String string) {
        int n = Arrays.asList((Object[])this.data).indexOf(nArray);
        return new AssertionError((Object)new StringBuffer().append("Invalid animation data [at row #").append(n).append("]: ").append(string).toString());
    }
}

