/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.organizer;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbInitReply;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbInitProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.organizer.DSIAdbInit;
import org.osgi.framework.BundleContext;

public class DSIAdbInitProvider
extends AbstractProvider
implements DSIAdbInit {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7};
    private DSIAdbInitProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbInit;

    public DSIAdbInitProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$organizer$DSIAdbInit == null ? (class$org$dsi$ifc$organizer$DSIAdbInit = DSIAdbInitProvider.class$("org.dsi.ifc.organizer.DSIAdbInit")) : class$org$dsi$ifc$organizer$DSIAdbInit).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIAdbInitProxy(this.instance, (DSIAdbInitReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setDefaultPublicProfileVisibility(boolean bl) {
        try {
            this.proxy.setDefaultPublicProfileVisibility(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMaxLocalEntries(int n) {
        try {
            this.proxy.setMaxLocalEntries(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMaxPhoneEntries(int n) {
        try {
            this.proxy.setMaxPhoneEntries(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMaxTopDestEntries(int n) {
        try {
            this.proxy.setMaxTopDestEntries(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMaxSpeedDialEntries(int n) {
        try {
            this.proxy.setMaxSpeedDialEntries(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNumericalSpellerEnabled(boolean bl) {
        try {
            this.proxy.setNumericalSpellerEnabled(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAutoProfileAllocation(boolean bl) {
        try {
            this.proxy.setAutoProfileAllocation(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void finalizeConfiguration() {
        try {
            this.proxy.finalizeConfiguration();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSpeedDialType(int n) {
        try {
            this.proxy.setSpeedDialType(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setProfileHandlingType(int n) {
        try {
            this.proxy.setProfileHandlingType(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDefaultSortOrder(int n) {
        try {
            this.proxy.setDefaultSortOrder(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setOnlineDestinationEnabled(boolean bl) {
        try {
            this.proxy.setOnlineDestinationEnabled(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDefaultSOSButton(boolean bl) {
        try {
            this.proxy.setDefaultSOSButton(bl);
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

