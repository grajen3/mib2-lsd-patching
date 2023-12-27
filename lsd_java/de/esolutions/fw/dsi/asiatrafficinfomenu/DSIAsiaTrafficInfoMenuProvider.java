/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.asiatrafficinfomenu;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuReply;
import de.esolutions.fw.comm.dsi.asiatrafficinfomenu.impl.DSIAsiaTrafficInfoMenuProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu;
import org.osgi.framework.BundleContext;

public class DSIAsiaTrafficInfoMenuProvider
extends AbstractProvider
implements DSIAsiaTrafficInfoMenu {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    private DSIAsiaTrafficInfoMenuProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu;

    public DSIAsiaTrafficInfoMenuProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu = DSIAsiaTrafficInfoMenuProvider.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIAsiaTrafficInfoMenuProxy(this.instance, (DSIAsiaTrafficInfoMenuReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void requestResourceInformation(int n) {
        try {
            this.proxy.requestResourceInformation(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestTrafficInformationDetails(int n) {
        try {
            this.proxy.requestTrafficInformationDetails(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPrefectureSetting(String string, boolean bl) {
        try {
            this.proxy.setPrefectureSetting(string, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setProbeDataSetting(boolean bl) {
        try {
            this.proxy.setProbeDataSetting(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
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

