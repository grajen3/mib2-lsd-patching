/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.phonetic;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.phonetic.DSIPhoneticConverterReply;
import de.esolutions.fw.comm.dsi.phonetic.impl.DSIPhoneticConverterProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.phonetic.DSIPhoneticConverter;
import org.osgi.framework.BundleContext;

public class DSIPhoneticConverterProvider
extends AbstractProvider
implements DSIPhoneticConverter {
    private static final int[] attributeIDs = new int[0];
    private DSIPhoneticConverterProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$phonetic$DSIPhoneticConverter;

    public DSIPhoneticConverterProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$phonetic$DSIPhoneticConverter == null ? (class$org$dsi$ifc$phonetic$DSIPhoneticConverter = DSIPhoneticConverterProvider.class$("org.dsi.ifc.phonetic.DSIPhoneticConverter")) : class$org$dsi$ifc$phonetic$DSIPhoneticConverter).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIPhoneticConverterProxy(this.instance, (DSIPhoneticConverterReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void hanziToPinYin(String string) {
        try {
            this.proxy.hanziToPinYin(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void hanziToZhuYin(String string) {
        try {
            this.proxy.hanziToZhuYin(string);
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

