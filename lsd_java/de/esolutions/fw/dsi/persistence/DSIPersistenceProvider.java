/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.persistence;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.persistence.DSIPersistenceReply;
import de.esolutions.fw.comm.dsi.persistence.impl.DSIPersistenceProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.persistence.DSIPersistence;
import org.osgi.framework.BundleContext;

public class DSIPersistenceProvider
extends AbstractProvider
implements DSIPersistence {
    private static final int[] attributeIDs = new int[]{1};
    private DSIPersistenceProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$persistence$DSIPersistence;

    public DSIPersistenceProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$persistence$DSIPersistence == null ? (class$org$dsi$ifc$persistence$DSIPersistence = DSIPersistenceProvider.class$("org.dsi.ifc.persistence.DSIPersistence")) : class$org$dsi$ifc$persistence$DSIPersistence).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIPersistenceProxy(this.instance, (DSIPersistenceReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void writeInt(int n, long l, int n2) {
        try {
            this.proxy.writeInt(n, l, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void readInt(int n, long l) {
        try {
            this.proxy.readInt(n, l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void readIntTimeout(int n, long l, int n2) {
        try {
            this.proxy.readIntTimeout(n, l, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void writeBuffer(int n, long l, byte[] byArray) {
        try {
            this.proxy.writeBuffer(n, l, byArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void readBuffer(int n, long l) {
        try {
            this.proxy.readBuffer(n, l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void readBufferTimeout(int n, long l, int n2) {
        try {
            this.proxy.readBufferTimeout(n, l, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void writeString(int n, long l, String string) {
        try {
            this.proxy.writeString(n, l, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void readString(int n, long l) {
        try {
            this.proxy.readString(n, l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void readStringTimeout(int n, long l, int n2) {
        try {
            this.proxy.readStringTimeout(n, l, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void writeArray(int n, long l, int[] nArray) {
        try {
            this.proxy.writeArray(n, l, nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void readArray(int n, long l) {
        try {
            this.proxy.readArray(n, l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void readArrayTimeout(int n, long l, int n2) {
        try {
            this.proxy.readArrayTimeout(n, l, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void writeStringArray(int n, long l, String[] stringArray) {
        try {
            this.proxy.writeStringArray(n, l, stringArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void readStringArray(int n, long l) {
        try {
            this.proxy.readStringArray(n, l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void readStringArrayTimeout(int n, long l, int n2) {
        try {
            this.proxy.readStringArrayTimeout(n, l, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void enterEngineeringSession(int n) {
        try {
            this.proxy.enterEngineeringSession(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void exitEngineeringSession(int n) {
        try {
            this.proxy.exitEngineeringSession(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getVisibleSystemLanguages() {
        try {
            this.proxy.getVisibleSystemLanguages();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void flushSQLDatabase() {
        try {
            this.proxy.flushSQLDatabase();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSQLDatabaseMedium(int n) {
        try {
            this.proxy.setSQLDatabaseMedium(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void beginTransaction(int n) {
        try {
            this.proxy.beginTransaction(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void endTransaction(int n, boolean bl) {
        try {
            this.proxy.endTransaction(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void subscribe(int n, int[] nArray, long[] lArray, int n2) {
        try {
            this.proxy.subscribe(n, nArray, lArray, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void unsubscribe(int n, int[] nArray, long[] lArray) {
        try {
            this.proxy.unsubscribe(n, nArray, lArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void unsubscribeAll(int n) {
        try {
            this.proxy.unsubscribeAll(n);
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

