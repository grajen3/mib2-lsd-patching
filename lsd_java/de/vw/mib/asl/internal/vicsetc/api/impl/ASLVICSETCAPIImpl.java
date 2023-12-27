/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.api.impl;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.vicsetc.ASLVICSETCAPI;
import de.vw.mib.asl.api.vicsetc.ASLVICSETCAsiaTrafficMenuListener;
import de.vw.mib.asl.api.vicsetc.ASLVicsEtcListener;
import de.vw.mib.asl.api.vicsetc.ITunerData;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.internal.vicsetc.EtcTarget;
import de.vw.mib.asl.internal.vicsetc.VicsTarget;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ASLVICSETCAPIImpl
implements ASLVICSETCAPI {
    private VicsTarget vicsTarget;
    private EtcTarget etcTarget;
    private static List aslVicsEtcListeners;
    private static List aslVicsEtcAsiaTrafficInfoMenuListeners;

    public VicsTarget getVicsTarget() {
        return this.vicsTarget;
    }

    public void setVicsTarget(VicsTarget vicsTarget) {
        this.vicsTarget = vicsTarget;
    }

    public EtcTarget getEtcTarget() {
        return this.etcTarget;
    }

    public void setEtcTarget(EtcTarget etcTarget) {
        this.etcTarget = etcTarget;
    }

    @Override
    public void registerVicsEtcListener(ASLVicsEtcListener aSLVicsEtcListener) {
        aslVicsEtcListeners.add(aSLVicsEtcListener);
    }

    @Override
    public void registerVicsEtcListener(ASLVICSETCAsiaTrafficMenuListener aSLVICSETCAsiaTrafficMenuListener) {
        aslVicsEtcAsiaTrafficInfoMenuListeners.add(aSLVICSETCAsiaTrafficMenuListener);
    }

    @Override
    public void unregisterVicsEtcListener(ASLVicsEtcListener aSLVicsEtcListener) {
        aslVicsEtcListeners.remove(aSLVicsEtcListener);
    }

    @Override
    public void unregisterVicsEtcListener(ASLVICSETCAsiaTrafficMenuListener aSLVICSETCAsiaTrafficMenuListener) {
        aslVicsEtcAsiaTrafficInfoMenuListeners.remove(aSLVICSETCAsiaTrafficMenuListener);
    }

    public static void notifyEtcCardStateAndPaymentAmount(int n, int n2) {
        for (int i2 = 0; i2 < aslVicsEtcListeners.size(); ++i2) {
            ((ASLVicsEtcListener)aslVicsEtcListeners.get(i2)).updateEtcCardStateAndPaymentAmount(n, n2);
        }
    }

    public static void notifyVicsStatusListenerToUpdateControlBar(int n, int n2, int n3) {
        for (int i2 = 0; i2 < aslVicsEtcListeners.size(); ++i2) {
            ((ASLVicsEtcListener)aslVicsEtcListeners.get(i2)).updateVicsStatusBarInfo(n, n2, n3);
        }
    }

    public static void notifyVicsStatusListenerToUpdateReceivableStations(ITunerData[] iTunerDataArray, boolean bl) {
        for (int i2 = 0; i2 < aslVicsEtcAsiaTrafficInfoMenuListeners.size(); ++i2) {
            ((ASLVICSETCAsiaTrafficMenuListener)aslVicsEtcAsiaTrafficInfoMenuListeners.get(i2)).updateReceivableStations(iTunerDataArray, bl);
        }
    }

    @Override
    public long getCurrentSystemTime() {
        return ASLSystemFactory.getSystemApi().getCurrentTimestamp();
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(0, 606673664, 1653307392, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 589896448, 1636530176, true);
        aslVicsEtcListeners = Collections.synchronizedList(new ArrayList());
        aslVicsEtcAsiaTrafficInfoMenuListeners = Collections.synchronizedList(new ArrayList());
    }
}

