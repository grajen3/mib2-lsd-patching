/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.organizer;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbUserProfileReply;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbUserProfileProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.organizer.DSIAdbUserProfile;
import org.osgi.framework.BundleContext;

public class DSIAdbUserProfileProvider
extends AbstractProvider
implements DSIAdbUserProfile {
    private static final int[] attributeIDs = new int[]{2, 3, 5, 6, 7, 8, 9, 10};
    private DSIAdbUserProfileProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfile;

    public DSIAdbUserProfileProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = DSIAdbUserProfileProvider.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIAdbUserProfileProxy(this.instance, (DSIAdbUserProfileReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void downloadToProfile(int n) {
        try {
            this.proxy.downloadToProfile(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void restartDownload() {
        try {
            this.proxy.restartDownload();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setProfileName(String string) {
        try {
            this.proxy.setProfileName(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteProfiles(int[] nArray) {
        try {
            this.proxy.deleteProfiles(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void commonEntryCount() {
        try {
            this.proxy.commonEntryCount();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void entryMeter() {
        try {
            this.proxy.entryMeter();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPairingCode(String string) {
        try {
            this.proxy.setPairingCode(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHomeId(long l) {
        try {
            this.proxy.setHomeId(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSOSButton(boolean bl) {
        try {
            this.proxy.setSOSButton(bl);
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

