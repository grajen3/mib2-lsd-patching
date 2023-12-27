/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl$DataStrategyWindowing;
import de.vw.mib.asl.clientapi.list.impl.ASLClientListImpl$UpdateBucket;
import de.vw.mib.list.HMIListDataManipulator;
import de.vw.mib.list.StringIndex;

class ASLClientListImpl$DataStrategyWindowing$InternalManipulator
implements HMIListDataManipulator {
    private final ASLClientListImpl$UpdateBucket bucket;
    private final /* synthetic */ ASLClientListImpl$DataStrategyWindowing this$1;

    ASLClientListImpl$DataStrategyWindowing$InternalManipulator(ASLClientListImpl$DataStrategyWindowing aSLClientListImpl$DataStrategyWindowing, ASLClientListImpl$UpdateBucket aSLClientListImpl$UpdateBucket) {
        this.this$1 = aSLClientListImpl$DataStrategyWindowing;
        this.bucket = aSLClientListImpl$UpdateBucket;
    }

    @Override
    public void clear() {
        this.this$1.executeClear(this.bucket);
    }

    @Override
    public void refresh(int n, int n2) {
        this.this$1.executeRefresh(this.bucket, n, n2);
    }

    @Override
    public void setContent(Object[] objectArray) {
        this.this$1.executeSetContent(this.bucket, objectArray);
    }

    @Override
    public void setFocus(int n) {
        this.this$1.executeSetFocus(this.bucket, n);
    }

    @Override
    public void setSize(int n) {
        this.this$1.executeSetSize(this.bucket, n);
    }

    @Override
    public void setState(int n) {
        this.this$1.executeSetState(this.bucket, n);
    }

    @Override
    public void setStringIndex(StringIndex stringIndex) {
        this.this$1.executeSetStringIndex(this.bucket, stringIndex);
    }

    @Override
    public void update(int n, Object[] objectArray) {
        this.this$1.executeUpdate(this.bucket, n, objectArray);
    }
}

