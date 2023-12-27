/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carhybrid;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carhybrid.DSICarHybridReply;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA0;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA1;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA2;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRAE;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA0;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA1;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA2;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA3;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA4;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA5;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA6;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA7;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;
import org.dsi.ifc.carhybrid.DSICarHybrid;
import org.osgi.framework.BundleContext;

public class DSICarHybridProvider
extends AbstractProvider
implements DSICarHybrid {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};
    private DSICarHybridProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$DSICarHybrid;

    public DSICarHybridProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$carhybrid$DSICarHybrid == null ? (class$org$dsi$ifc$carhybrid$DSICarHybrid = DSICarHybridProvider.class$("org.dsi.ifc.carhybrid.DSICarHybrid")) : class$org$dsi$ifc$carhybrid$DSICarHybrid).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSICarHybridProxy(this.instance, (DSICarHybridReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setBatteryControlImmediately(int n, int n2) {
        try {
            this.proxy.setBatteryControlImmediately(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBatteryControlTimerState(BatteryControlProgrammedTimer batteryControlProgrammedTimer) {
        try {
            this.proxy.setBatteryControlTimerState(batteryControlProgrammedTimer);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBatteryControlTimer(int n, int n2, int n3, int n4, int n5, int n6, BatteryControlWeekdays batteryControlWeekdays, int n7) {
        try {
            this.proxy.setBatteryControlTimer(n, n2, n3, n4, n5, n6, batteryControlWeekdays, n7);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBatteryControlSetFactoryDefault() {
        try {
            this.proxy.setBatteryControlSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHybridTargetRange(short s, int n) {
        try {
            this.proxy.setHybridTargetRange(s, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHybridEnergyAssistControl(boolean bl) {
        try {
            this.proxy.setHybridEnergyAssistControl(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestBatteryControlProfileList(BatteryControlProfilesAH batteryControlProfilesAH) {
        try {
            this.proxy.requestBatteryControlProfileList(batteryControlProfilesAH);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBatteryControlProfileListRA0(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA0[] batteryControlProfileRA0Array) {
        try {
            this.proxy.setBatteryControlProfileListRA0(batteryControlProfilesAH, batteryControlProfileRA0Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBatteryControlProfileListRA1(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA1[] batteryControlProfileRA1Array) {
        try {
            this.proxy.setBatteryControlProfileListRA1(batteryControlProfilesAH, batteryControlProfileRA1Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBatteryControlProfileListRA2(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA2[] batteryControlProfileRA2Array) {
        try {
            this.proxy.setBatteryControlProfileListRA2(batteryControlProfilesAH, batteryControlProfileRA2Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBatteryControlProfileListRA3(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA3[] batteryControlProfileRA3Array) {
        try {
            this.proxy.setBatteryControlProfileListRA3(batteryControlProfilesAH, batteryControlProfileRA3Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBatteryControlProfileListRA4(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA4[] batteryControlProfileRA4Array) {
        try {
            this.proxy.setBatteryControlProfileListRA4(batteryControlProfilesAH, batteryControlProfileRA4Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBatteryControlProfileListRA5(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA5[] batteryControlProfileRA5Array) {
        try {
            this.proxy.setBatteryControlProfileListRA5(batteryControlProfilesAH, batteryControlProfileRA5Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBatteryControlProfileListRA6(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA6[] batteryControlProfileRA6Array) {
        try {
            this.proxy.setBatteryControlProfileListRA6(batteryControlProfilesAH, batteryControlProfileRA6Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBatteryControlProfileListRA7(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA7[] batteryControlProfileRA7Array) {
        try {
            this.proxy.setBatteryControlProfileListRA7(batteryControlProfilesAH, batteryControlProfileRA7Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBatteryControlProfileListRAF(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray) {
        try {
            this.proxy.setBatteryControlProfileListRAF(batteryControlProfilesAH, nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBatteryControlPowerProviderRA0(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array) {
        try {
            this.proxy.setBatteryControlPowerProviderRA0(batteryControlPowerProviderAH, batteryControlPowerProviderRA0Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBatteryControlPowerProviderRA1(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array) {
        try {
            this.proxy.setBatteryControlPowerProviderRA1(batteryControlPowerProviderAH, batteryControlPowerProviderRA1Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBatteryControlPowerProviderRA2(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array) {
        try {
            this.proxy.setBatteryControlPowerProviderRA2(batteryControlPowerProviderAH, batteryControlPowerProviderRA2Array);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBatteryControlPowerProviderRAE(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray) {
        try {
            this.proxy.setBatteryControlPowerProviderRAE(batteryControlPowerProviderAH, batteryControlPowerProviderRAEArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBatteryControlPowerProviderRAF(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray) {
        try {
            this.proxy.setBatteryControlPowerProviderRAF(batteryControlPowerProviderAH, nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestBatteryControlPowerProviderList(BatteryControlPowerProviderAH batteryControlPowerProviderAH) {
        try {
            this.proxy.requestBatteryControlPowerProviderList(batteryControlPowerProviderAH);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBatteryControlPastErrorReason(int n) {
        try {
            this.proxy.setBatteryControlPastErrorReason(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBatteryControlRemainingChargeTime(int n, short s, int n2, short s2) {
        try {
            this.proxy.setBatteryControlRemainingChargeTime(n, s, n2, s2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHybridActivePedal(boolean bl) {
        try {
            this.proxy.setHybridActivePedal(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int[] nArray) {
        try {
            this.proxy.setNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int n) {
        try {
            this.proxy.setNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification() {
        try {
            this.proxy.setNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int[] nArray) {
        try {
            this.proxy.clearNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int n) {
        try {
            this.proxy.clearNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification() {
        try {
            this.proxy.clearNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void yySet(String string, String string2) {
        try {
            this.proxy.yySet(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

