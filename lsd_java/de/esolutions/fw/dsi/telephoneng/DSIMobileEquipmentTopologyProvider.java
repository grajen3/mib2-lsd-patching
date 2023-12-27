/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.telephoneng;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.telephoneng.DSIMobileEquipmentTopologyReply;
import de.esolutions.fw.comm.dsi.telephoneng.impl.DSIMobileEquipmentTopologyProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology;
import org.osgi.framework.BundleContext;

public class DSIMobileEquipmentTopologyProvider
extends AbstractProvider
implements DSIMobileEquipmentTopology {
    private static final int[] attributeIDs = new int[]{1, 2};
    private DSIMobileEquipmentTopologyProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology;

    public DSIMobileEquipmentTopologyProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology = DSIMobileEquipmentTopologyProvider.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentTopology")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentTopology).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIMobileEquipmentTopologyProxy(this.instance, (DSIMobileEquipmentTopologyReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void requestChangeTopology(int[] nArray) {
        try {
            this.proxy.requestChangeTopology(nArray);
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

