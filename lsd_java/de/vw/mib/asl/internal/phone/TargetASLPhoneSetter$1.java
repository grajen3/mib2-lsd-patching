/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.api.carplay.ASLCarplayServicesCallState;
import de.vw.mib.asl.api.carplay.ASLCarplayServicesListener;
import de.vw.mib.asl.api.carplay.ASLCarplayServicesTelephonyState;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.TargetASLPhoneSetter;
import de.vw.mib.util.Util;

class TargetASLPhoneSetter$1
implements ASLCarplayServicesListener {
    private final /* synthetic */ TargetASLPhoneSetter this$0;

    TargetASLPhoneSetter$1(TargetASLPhoneSetter targetASLPhoneSetter) {
        this.this$0 = targetASLPhoneSetter;
    }

    @Override
    public void updateCarPlayRouteGuidanceActive(boolean bl) {
    }

    @Override
    public void updateCarPlayIsReady(boolean bl) {
    }

    @Override
    public void updateCarPlayCallStates(ASLCarplayServicesCallState[] aSLCarplayServicesCallStateArray) {
        ASLPhoneData.getInstance().carPlayCallActive = Util.isNullOrEmpty(aSLCarplayServicesCallStateArray) ? false : (aSLCarplayServicesCallStateArray.length == 1 ? aSLCarplayServicesCallStateArray[0].getStatus() != 0 : true);
    }

    @Override
    public void updateCarPlayActive(boolean bl) {
    }

    @Override
    public void updateCarPlaTelefonyState(ASLCarplayServicesTelephonyState aSLCarplayServicesTelephonyState) {
    }
}

