/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.media;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.media.DSIRadioTaggingReply;
import de.esolutions.fw.comm.dsi.media.impl.DSIRadioTaggingProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.media.DSIRadioTagging;
import org.dsi.ifc.media.TagInformation;
import org.osgi.framework.BundleContext;

public class DSIRadioTaggingProvider
extends AbstractProvider
implements DSIRadioTagging {
    private static final int[] attributeIDs = new int[]{1};
    private DSIRadioTaggingProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIRadioTagging;

    public DSIRadioTaggingProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$media$DSIRadioTagging == null ? (class$org$dsi$ifc$media$DSIRadioTagging = DSIRadioTaggingProvider.class$("org.dsi.ifc.media.DSIRadioTagging")) : class$org$dsi$ifc$media$DSIRadioTagging).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIRadioTaggingProxy(this.instance, (DSIRadioTaggingReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void tagSong(TagInformation tagInformation) {
        try {
            this.proxy.tagSong(tagInformation);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void tagAmbiguousSong(TagInformation tagInformation, TagInformation tagInformation2) {
        try {
            this.proxy.tagAmbiguousSong(tagInformation, tagInformation2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void groupTags(int n) {
        try {
            this.proxy.groupTags(n);
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

