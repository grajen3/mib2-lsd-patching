/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.vicsetc;

import de.vw.mib.asl.api.vicsetc.ASLVICSETCAsiaTrafficMenuListener;
import de.vw.mib.asl.api.vicsetc.ASLVicsEtcListener;

public interface ASLVICSETCAPI {
    public static final int ETC_CARD_STATE_NOTAVAILABLE;
    public static final int ETC_CARD_STATE_AVAILABLE;
    public static final int ETC_CARD_STATE_ERROR;
    public static final int ETC_CARD_STATE_PAYMENT;
    public static final int ETC_CARD_STATE_DEFAULT;

    default public void registerVicsEtcListener(ASLVicsEtcListener aSLVicsEtcListener) {
    }

    default public void unregisterVicsEtcListener(ASLVicsEtcListener aSLVicsEtcListener) {
    }

    default public void registerVicsEtcListener(ASLVICSETCAsiaTrafficMenuListener aSLVICSETCAsiaTrafficMenuListener) {
    }

    default public void unregisterVicsEtcListener(ASLVICSETCAsiaTrafficMenuListener aSLVICSETCAsiaTrafficMenuListener) {
    }

    default public long getCurrentSystemTime() {
    }
}

