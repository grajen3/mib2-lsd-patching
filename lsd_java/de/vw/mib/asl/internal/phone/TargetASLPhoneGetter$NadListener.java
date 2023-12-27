/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.internal.phone.TargetASLPhoneGetter;
import de.vw.mib.asl.internal.phone.TargetASLPhoneGetter$1;
import de.vw.mib.asl.internal.phone.util.DefaultDSIMobileEquipmentListener;

class TargetASLPhoneGetter$NadListener
extends DefaultDSIMobileEquipmentListener {
    private final /* synthetic */ TargetASLPhoneGetter this$0;

    private TargetASLPhoneGetter$NadListener(TargetASLPhoneGetter targetASLPhoneGetter) {
        this.this$0 = targetASLPhoneGetter;
    }

    @Override
    public void updateNetworkType(int n, int n2) {
        if (TargetASLPhoneGetter.access$000(this.this$0)) {
            TargetASLPhoneGetter.access$102(this.this$0, n);
            TargetASLPhoneGetter.access$200(this.this$0);
        } else {
            TargetASLPhoneGetter.access$102(this.this$0, 0);
            TargetASLPhoneGetter.access$200(this.this$0);
        }
    }

    /* synthetic */ TargetASLPhoneGetter$NadListener(TargetASLPhoneGetter targetASLPhoneGetter, TargetASLPhoneGetter$1 targetASLPhoneGetter$1) {
        this(targetASLPhoneGetter);
    }
}

