/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.organizer;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbSetupReply;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbSetupProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.osgi.framework.BundleContext;

public class DSIAdbSetupProvider
extends AbstractProvider
implements DSIAdbSetup {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4};
    private DSIAdbSetupProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetup;

    public DSIAdbSetupProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = DSIAdbSetupProvider.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIAdbSetupProxy(this.instance, (DSIAdbSetupReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setLanguage(String string) {
        try {
            this.proxy.setLanguage(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSortOrder(int n) {
        try {
            this.proxy.setSortOrder(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPublicProfileVisibility(boolean bl) {
        try {
            this.proxy.setPublicProfileVisibility(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resetToFactorySettings() {
        try {
            this.proxy.resetToFactorySettings();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resetTopDestination() {
        try {
            this.proxy.resetTopDestination();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void createBackupFile(String string) {
        try {
            this.proxy.createBackupFile(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void importBackupFile(String string) {
        try {
            this.proxy.importBackupFile(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPictureVisibility(boolean bl) {
        try {
            this.proxy.setPictureVisibility(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setContextSpecificVisibility(boolean bl) {
        try {
            this.proxy.setContextSpecificVisibility(bl);
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

