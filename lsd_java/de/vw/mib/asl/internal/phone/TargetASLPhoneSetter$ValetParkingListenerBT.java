/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListenerAdapter;
import de.vw.mib.asl.internal.phone.TargetASLPhoneSetter;
import de.vw.mib.asl.internal.phone.TargetASLPhoneSetter$1;

class TargetASLPhoneSetter$ValetParkingListenerBT
extends ValetParkingListenerAdapter {
    private final /* synthetic */ TargetASLPhoneSetter this$0;

    private TargetASLPhoneSetter$ValetParkingListenerBT(TargetASLPhoneSetter targetASLPhoneSetter) {
        this.this$0 = targetASLPhoneSetter;
    }

    @Override
    public void notifyValetParkingStateChanged(boolean bl, ValetParkingCallback valetParkingCallback) {
        boolean bl2;
        boolean bl3 = bl2 = TargetASLPhoneSetter.access$100(this.this$0) == 0;
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("TargetASLPhoneSetter.ValetParkingListenerBT.notifyValetParkingStateChanged() ").append(bl).append(", pre VP BT state = ").append(ASLPhoneFactory.getPhoneApi().getPersistence().getPreValetParkingBtState()).append(", btState = ").append(bl2).append(valetParkingCallback == null ? ", callback == null" : "").log();
        }
        if (bl) {
            if (ASLPhoneFactory.getPhoneApi().getPersistence().getPreValetParkingBtState() == -1) {
                ASLPhoneFactory.getPhoneApi().getPersistence().setPreValetParkingBtState(bl2 ? 1 : 0);
                if (bl2) {
                    this.this$0.valetParkingCallback = valetParkingCallback;
                    TargetASLPhoneSetter.access$200(this.this$0, false);
                } else if (valetParkingCallback != null) {
                    valetParkingCallback.notifyValetParkingTransitionFinished(true);
                    this.this$0.valetParkingCallback = null;
                }
            } else if (valetParkingCallback != null) {
                valetParkingCallback.notifyValetParkingTransitionFinished(true);
                this.this$0.valetParkingCallback = null;
            }
        } else {
            if (ASLPhoneFactory.getPhoneApi().getPersistence().getPreValetParkingBtState() == 1) {
                this.this$0.valetParkingCallback = valetParkingCallback;
                TargetASLPhoneSetter.access$200(this.this$0, true);
            } else if (valetParkingCallback != null) {
                valetParkingCallback.notifyValetParkingTransitionFinished(true);
                this.this$0.valetParkingCallback = null;
            }
            ASLPhoneFactory.getPhoneApi().getPersistence().setPreValetParkingBtState(-1);
        }
    }

    /* synthetic */ TargetASLPhoneSetter$ValetParkingListenerBT(TargetASLPhoneSetter targetASLPhoneSetter, TargetASLPhoneSetter$1 targetASLPhoneSetter$1) {
        this(targetASLPhoneSetter);
    }
}

