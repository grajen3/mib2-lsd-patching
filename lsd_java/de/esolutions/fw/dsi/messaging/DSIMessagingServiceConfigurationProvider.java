/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.messaging;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.messaging.DSIMessagingServiceConfigurationReply;
import de.esolutions.fw.comm.dsi.messaging.impl.DSIMessagingServiceConfigurationProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.messaging.DSIMessagingServiceConfiguration;
import org.osgi.framework.BundleContext;

public class DSIMessagingServiceConfigurationProvider
extends AbstractProvider
implements DSIMessagingServiceConfiguration {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private DSIMessagingServiceConfigurationProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration;

    public DSIMessagingServiceConfigurationProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration == null ? (class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration = DSIMessagingServiceConfigurationProvider.class$("org.dsi.ifc.messaging.DSIMessagingServiceConfiguration")) : class$org$dsi$ifc$messaging$DSIMessagingServiceConfiguration).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIMessagingServiceConfigurationProxy(this.instance, (DSIMessagingServiceConfigurationReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setPhoneSystemRingingVolumeRequest(int n) {
        try {
            this.proxy.setPhoneSystemRingingVolumeRequest(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPhoneSystemRingingTypeRequest(int n) {
        try {
            this.proxy.setPhoneSystemRingingTypeRequest(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSMSCNumberRequest(String string) {
        try {
            this.proxy.setSMSCNumberRequest(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void activateSmsDeliveryReportRequest(boolean bl) {
        try {
            this.proxy.activateSmsDeliveryReportRequest(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void activateStoreSmsOnSentRequest(boolean bl) {
        try {
            this.proxy.activateStoreSmsOnSentRequest(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setShortMessageValidityPeriodRequest(int n) {
        try {
            this.proxy.setShortMessageValidityPeriodRequest(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void activateEmailIncludeOldMailInReplyRequest(boolean bl) {
        try {
            this.proxy.activateEmailIncludeOldMailInReplyRequest(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void activateEmailEmptySubjectNotificationRequest(boolean bl) {
        try {
            this.proxy.activateEmailEmptySubjectNotificationRequest(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void changeFolderViewModeRequest(int n) {
        try {
            this.proxy.changeFolderViewModeRequest(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void restoreFactorySettingsRequest() {
        try {
            this.proxy.restoreFactorySettingsRequest();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAccountPreferences(int n, String string) {
        try {
            this.proxy.setAccountPreferences(n, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetSmsIndications(boolean bl) {
        try {
            this.proxy.requestSetSmsIndications(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetEmailIndications(boolean bl) {
        try {
            this.proxy.requestSetEmailIndications(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetPushSms(boolean bl) {
        try {
            this.proxy.requestSetPushSms(bl);
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

