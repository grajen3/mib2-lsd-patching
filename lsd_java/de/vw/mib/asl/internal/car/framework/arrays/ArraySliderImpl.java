/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.framework.arrays;

import de.vw.mib.asl.api.car.arrays.ArraySlider;
import de.vw.mib.asl.api.car.arrays.ArraySliderDelegate;
import de.vw.mib.bap.array.asg.ASGArrayList;

class ArraySliderImpl
implements ArraySlider {
    private Object nextRequest;
    private Object requestInProgress;
    private final ArraySliderDelegate delegate;
    private ASGArrayList arrayList;
    private final int id;

    public ArraySliderImpl(ArraySliderDelegate arraySliderDelegate, int n) {
        this.delegate = arraySliderDelegate;
        this.id = n;
    }

    @Override
    public void requestNewValue(Object object) {
        this.getDelegate().fakeValue(this, object);
        if (!this.isRequestInProgress()) {
            this.sendNewValue(object);
        } else {
            this.queueRequest(object);
        }
    }

    @Override
    public void receivedNewValue(Object object) {
        if (this.isRequestQueueEmpty()) {
            if (this.isSliderValueEqualToRequestInProgress(object)) {
                this.clearRequestInProgress();
            } else if (!this.isArrayModifyRequestPending()) {
                this.clearRequestInProgress();
                this.getDelegate().updateValue(this, object);
            }
        } else if (!this.isArrayModifyRequestPending()) {
            this.sendNewValue(this.dequeueRequest());
        }
    }

    @Override
    public ArraySliderDelegate getDelegate() {
        return this.delegate;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setCorrespondingArrayList(ASGArrayList aSGArrayList) {
        this.arrayList = aSGArrayList;
    }

    private boolean isArrayModifyRequestPending() {
        return this.arrayList != null && this.isRequestInProgress() && this.arrayList.isModifyRequestPending();
    }

    private boolean isRequestQueueEmpty() {
        return this.nextRequest == null;
    }

    private void queueRequest(Object object) {
        this.nextRequest = object;
    }

    private Object dequeueRequest() {
        Object object = this.nextRequest;
        this.nextRequest = null;
        return object;
    }

    private boolean isRequestInProgress() {
        return this.getRequestInProgress() != null;
    }

    private void clearRequestInProgress() {
        this.requestInProgress = null;
    }

    private Object getRequestInProgress() {
        return this.requestInProgress;
    }

    private void sendNewValue(Object object) {
        this.requestInProgress = object;
        this.getDelegate().sendNewValue(this, object);
    }

    private boolean isSliderValueEqualToRequestInProgress(Object object) {
        return this.isRequestInProgress() && ArraySliderImpl.sliderValuesEqual(this.getRequestInProgress(), object);
    }

    private static boolean sliderValuesEqual(Object object, Object object2) {
        return object.equals(object2);
    }

    @Override
    public void reset() {
        this.nextRequest = null;
        this.requestInProgress = null;
    }
}

