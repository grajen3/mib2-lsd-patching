/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.careco;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.careco.DSICarEcoReply;
import de.esolutions.fw.comm.dsi.careco.impl.DSICarEcoProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.DSICarEco;
import org.dsi.ifc.careco.StartStopListUpdateInfo;
import org.osgi.framework.BundleContext;

public class DSICarEcoProvider
extends AbstractProvider
implements DSICarEco {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 34, 35, 36, 37, 38, 39, 40, 41, 5, 6, 7, 8, 9, 10, 11, 12, 49, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 42, 43, 44, 47, 48, 45, 46};
    private DSICarEcoProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEco;

    public DSICarEcoProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$careco$DSICarEco == null ? (class$org$dsi$ifc$careco$DSICarEco = DSICarEcoProvider.class$("org.dsi.ifc.careco.DSICarEco")) : class$org$dsi$ifc$careco$DSICarEco).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSICarEcoProxy(this.instance, (DSICarEcoReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void requestBCmEConsumerList(BCmEListUpdateInfo bCmEListUpdateInfo) {
        try {
            this.proxy.requestBCmEConsumerList(bCmEListUpdateInfo);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBCmELiveTip(int n, boolean bl) {
        try {
            this.proxy.setBCmELiveTip(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBcmeSetFactoryDefault() {
        try {
            this.proxy.setBcmeSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestStartStopProhibitList(StartStopListUpdateInfo startStopListUpdateInfo) {
        try {
            this.proxy.requestStartStopProhibitList(startStopListUpdateInfo);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestStartStopRestartList(StartStopListUpdateInfo startStopListUpdateInfo) {
        try {
            this.proxy.requestStartStopRestartList(startStopListUpdateInfo);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestStartStopRestartProhibitList(StartStopListUpdateInfo startStopListUpdateInfo) {
        try {
            this.proxy.requestStartStopRestartProhibitList(startStopListUpdateInfo);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestBCmEConsumerListConsumption(BCmEListUpdateInfo bCmEListUpdateInfo) {
        try {
            this.proxy.requestBCmEConsumerListConsumption(bCmEListUpdateInfo);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestBCmEConsumerListRange(BCmEListUpdateInfo bCmEListUpdateInfo) {
        try {
            this.proxy.requestBCmEConsumerListRange(bCmEListUpdateInfo);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRDSetFactoryDefault() {
        try {
            this.proxy.setRDSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setEASystem(boolean bl) {
        try {
            this.proxy.setEASystem(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setEAPedalJerk(boolean bl) {
        try {
            this.proxy.setEAPedalJerk(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setEASetFactoryDefault() {
        try {
            this.proxy.setEASetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setEAFreeWheeling(boolean bl) {
        try {
            this.proxy.setEAFreeWheeling(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setEAStartStop(boolean bl) {
        try {
            this.proxy.setEAStartStop(bl);
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

