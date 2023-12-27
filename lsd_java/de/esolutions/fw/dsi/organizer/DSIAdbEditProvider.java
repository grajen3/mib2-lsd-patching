/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.organizer;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbEditReply;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbEditProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.osgi.framework.BundleContext;

public class DSIAdbEditProvider
extends AbstractProvider
implements DSIAdbEdit {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5};
    private DSIAdbEditProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;

    public DSIAdbEditProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = DSIAdbEditProvider.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIAdbEditProxy(this.instance, (DSIAdbEditReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void insertEntry(AdbEntry adbEntry, int n) {
        try {
            this.proxy.insertEntry(adbEntry, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getEntries(long[] lArray, int n, int n2) {
        try {
            this.proxy.getEntries(lArray, n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getEntryDataSets(long[] lArray, int n, int n2) {
        try {
            this.proxy.getEntryDataSets(lArray, n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void changeEntry(AdbEntry adbEntry, int n) {
        try {
            this.proxy.changeEntry(adbEntry, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void copyEntry(long l) {
        try {
            this.proxy.copyEntry(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteEntries(long[] lArray, int n, int n2) {
        try {
            this.proxy.deleteEntries(lArray, n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSpeedDial(AdbEntry adbEntry) {
        try {
            this.proxy.setSpeedDial(adbEntry);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteSpeedDial(int n) {
        try {
            this.proxy.deleteSpeedDial(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getEntryByReferenceId(String string) {
        try {
            this.proxy.getEntryByReferenceId(string);
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

