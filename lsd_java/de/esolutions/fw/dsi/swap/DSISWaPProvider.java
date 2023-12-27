/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.swap;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.swap.DSISWaPReply;
import de.esolutions.fw.comm.dsi.swap.impl.DSISWaPProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.swap.DSISWaP;
import org.osgi.framework.BundleContext;

public class DSISWaPProvider
extends AbstractProvider
implements DSISWaP {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    private DSISWaPProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$swap$DSISWaP;

    public DSISWaPProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$swap$DSISWaP == null ? (class$org$dsi$ifc$swap$DSISWaP = DSISWaPProvider.class$("org.dsi.ifc.swap.DSISWaP")) : class$org$dsi$ifc$swap$DSISWaP).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSISWaPProxy(this.instance, (DSISWaPReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void encryptFile(String string, String string2, byte[] byArray) {
        try {
            this.proxy.encryptFile(string, string2, byArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void checkSignature(String string, short[] sArray, int n, long l) {
        try {
            this.proxy.checkSignature(string, sArray, n, l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getPublicKey() {
        try {
            this.proxy.getPublicKey();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void checkSingleFsc(int n) {
        try {
            this.proxy.checkSingleFsc(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void decryptFile(String string, String string2, byte[] byArray) {
        try {
            this.proxy.decryptFile(string, string2, byArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getFscDetails(int n, int n2, int n3) {
        try {
            this.proxy.getFscDetails(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void triggerSoftwareEnabling() {
        try {
            this.proxy.triggerSoftwareEnabling();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void importFSCs(int n) {
        try {
            this.proxy.importFSCs(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void exportCCD(int n) {
        try {
            this.proxy.exportCCD(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getHistory() {
        try {
            this.proxy.getHistory();
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

