/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.browser;

import de.vw.mib.asl.internal.media.browser.PredictableModelProperty$ModelUpdater;
import java.util.Comparator;

public class PredictableModelProperty {
    private long mSequenceNumber;
    private Object mSubmittedProperty;
    private Object mPredictedProperty;
    private Object mForwardedProperty;
    private final PredictableModelProperty$ModelUpdater mUpdater;

    public PredictableModelProperty() {
        this.mUpdater = null;
    }

    public PredictableModelProperty(PredictableModelProperty$ModelUpdater predictableModelProperty$ModelUpdater) {
        this.mUpdater = predictableModelProperty$ModelUpdater;
    }

    public PredictableModelProperty(PredictableModelProperty$ModelUpdater predictableModelProperty$ModelUpdater, Comparator comparator) {
        this.mUpdater = predictableModelProperty$ModelUpdater;
    }

    public void updateSubmittedValue(Object object) {
        this.mSubmittedProperty = object;
        this.onPropertyChanged();
    }

    public void updatePredictedValue(Object object, long l) {
        if (l >= this.mSequenceNumber) {
            this.mSequenceNumber = l;
            this.mPredictedProperty = object;
            this.onPropertyChanged();
        }
    }

    public void clearPrediction(long l) {
        if (l >= this.mSequenceNumber) {
            this.mPredictedProperty = null;
            this.onPropertyChanged();
        }
    }

    public Object getVisibleProperty() {
        return this.mPredictedProperty != null ? this.mPredictedProperty : this.mSubmittedProperty;
    }

    public Object getForwardedProperty() {
        return this.mForwardedProperty;
    }

    private void onPropertyChanged() {
        Object object = this.getVisibleProperty();
        if (this.mForwardedProperty != object) {
            if (this.mUpdater != null) {
                this.mUpdater.forward(object);
            }
            this.mForwardedProperty = object;
        }
    }

    public String toString() {
        return new StringBuffer().append("PMP [seq#=").append(this.mSequenceNumber).append(", Submitted=").append(this.mSubmittedProperty).append(", Predicted=").append(this.mPredictedProperty).append(", mForwarded=").append(this.mForwardedProperty).append("]").toString();
    }
}

