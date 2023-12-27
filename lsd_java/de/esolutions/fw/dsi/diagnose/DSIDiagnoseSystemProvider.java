/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diagnose;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.diagnose.DSIDiagnoseSystemReply;
import de.esolutions.fw.comm.dsi.diagnose.impl.DSIDiagnoseSystemProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.diagnose.DSIDiagnoseSystem;
import org.osgi.framework.BundleContext;

public class DSIDiagnoseSystemProvider
extends AbstractProvider
implements DSIDiagnoseSystem {
    private static final int[] attributeIDs = new int[]{20};
    private DSIDiagnoseSystemProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$diagnose$DSIDiagnoseSystem;

    public DSIDiagnoseSystemProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$diagnose$DSIDiagnoseSystem == null ? (class$org$dsi$ifc$diagnose$DSIDiagnoseSystem = DSIDiagnoseSystemProvider.class$("org.dsi.ifc.diagnose.DSIDiagnoseSystem")) : class$org$dsi$ifc$diagnose$DSIDiagnoseSystem).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIDiagnoseSystemProxy(this.instance, (DSIDiagnoseSystemReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void acknowledgeRoutine(int n, int n2, int n3, int n4) {
        try {
            this.proxy.acknowledgeRoutine(n, n2, n3, n4);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resultRoutine(int n, int n2, int n3, int n4, int n5) {
        try {
            this.proxy.resultRoutine(n, n2, n3, n4, n5);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void acknowledgeActuatorTest(int n, int n2, int n3, int n4, int[] nArray, int n5) {
        try {
            this.proxy.acknowledgeActuatorTest(n, n2, n3, n4, nArray, n5);
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

