/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.target;

import de.vw.mib.asl.api.speechengine.messenger.indicator.IndicatorStateConsumer;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.smartphoneintegration.target.ASLHandler;

class ASLHandler$1
implements IndicatorStateConsumer {
    private final /* synthetic */ ASLHandler this$0;

    ASLHandler$1(ASLHandler aSLHandler) {
        this.this$0 = aSLHandler;
    }

    @Override
    public void onIndicatorStateChange(int n) {
        if (ASLHandler.access$000(this.this$0).isTraceEnabled()) {
            ASLHandler.access$000(this.this$0).trace().append(this.this$0.classname).append(".onIndicatorStateChange( speechstate: ").append(n).append(")").log();
        }
        switch (n) {
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(1197943808, 0);
                ASLHandler.access$000(this.this$0).triggerObserver(1041521920, null);
                break;
            }
            case 4: {
                ServiceManager.aslPropertyManager.valueChangedInteger(1197943808, 2);
                ASLHandler.access$000(this.this$0).triggerObserver(1058299136, null);
                break;
            }
            default: {
                ServiceManager.aslPropertyManager.valueChangedInteger(1197943808, 1);
                ASLHandler.access$000(this.this$0).triggerObserver(1075076352, null);
            }
        }
    }
}

