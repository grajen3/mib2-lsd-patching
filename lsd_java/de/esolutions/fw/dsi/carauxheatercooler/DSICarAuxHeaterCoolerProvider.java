/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carauxheatercooler;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carauxheatercooler.DSICarAuxHeaterCoolerReply;
import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.DSICarAuxHeaterCoolerProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;
import org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler;
import org.osgi.framework.BundleContext;

public class DSICarAuxHeaterCoolerProvider
extends AbstractProvider
implements DSICarAuxHeaterCooler {
    private static final int[] attributeIDs = new int[]{1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
    private DSICarAuxHeaterCoolerProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCooler;

    public DSICarAuxHeaterCoolerProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCooler == null ? (class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCooler = DSICarAuxHeaterCoolerProvider.class$("org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler")) : class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCooler).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSICarAuxHeaterCoolerProxy(this.instance, (DSICarAuxHeaterCoolerReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setAuxHeaterCoolerOnOff(boolean bl) {
        try {
            this.proxy.setAuxHeaterCoolerOnOff(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAuxHeaterCoolerRunningTime(short s) {
        try {
            this.proxy.setAuxHeaterCoolerRunningTime(s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAuxHeaterCoolerMode(int n) {
        try {
            this.proxy.setAuxHeaterCoolerMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAuxHeaterCoolerDefaultStartMode(int n) {
        try {
            this.proxy.setAuxHeaterCoolerDefaultStartMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAuxHeaterCoolerEngineHeater(boolean bl) {
        try {
            this.proxy.setAuxHeaterCoolerEngineHeater(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAuxHeaterCoolerActiveTimer(int n) {
        try {
            this.proxy.setAuxHeaterCoolerActiveTimer(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAuxHeaterCoolerTimer1(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        try {
            this.proxy.setAuxHeaterCoolerTimer1(auxHeaterCoolerTimer);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAuxHeaterCoolerTimer2(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        try {
            this.proxy.setAuxHeaterCoolerTimer2(auxHeaterCoolerTimer);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAuxHeaterCoolerTimer3(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        try {
            this.proxy.setAuxHeaterCoolerTimer3(auxHeaterCoolerTimer);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAuxHeaterCoolerPopup(int n) {
        try {
            this.proxy.setAuxHeaterCoolerPopup(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAuxHeaterSetFactoryDefault() {
        try {
            this.proxy.setAuxHeaterSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAuxHeaterCoolerExtendedConditioning(AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning) {
        try {
            this.proxy.setAuxHeaterCoolerExtendedConditioning(auxHeaterCoolerExtendedConditioning);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAuxHeaterCoolerWindowHeating(boolean bl) {
        try {
            this.proxy.setAuxHeaterCoolerWindowHeating(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAuxHeaterCoolerUnlockClimating(int n) {
        try {
            this.proxy.setAuxHeaterCoolerUnlockClimating(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAuxHeaterCoolerTargetTemperature(float f2) {
        try {
            this.proxy.setAuxHeaterCoolerTargetTemperature(f2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAuxHeaterCoolerAirQuality(boolean bl) {
        try {
            this.proxy.setAuxHeaterCoolerAirQuality(bl);
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

