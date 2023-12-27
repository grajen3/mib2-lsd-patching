/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.messaging;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.messaging.DSIMessagingReply;
import de.esolutions.fw.comm.dsi.messaging.impl.DSIMessagingProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.DSIMessaging;
import org.dsi.ifc.messaging.RecipientList;
import org.osgi.framework.BundleContext;

public class DSIMessagingProvider
extends AbstractProvider
implements DSIMessaging {
    private static final int[] attributeIDs = new int[]{4, 5};
    private DSIMessagingProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$DSIMessaging;

    public DSIMessagingProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$messaging$DSIMessaging == null ? (class$org$dsi$ifc$messaging$DSIMessaging = DSIMessagingProvider.class$("org.dsi.ifc.messaging.DSIMessaging")) : class$org$dsi$ifc$messaging$DSIMessaging).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIMessagingProxy(this.instance, (DSIMessagingReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void changeFolderRequest(int n, int n2, int n3, int n4, int n5) {
        try {
            this.proxy.changeFolderRequest(n, n2, n3, n4, n5);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void listEntriesRequest(int n, int n2, int n3) {
        try {
            this.proxy.listEntriesRequest(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getPositionOfMessageRequest(String string) {
        try {
            this.proxy.getPositionOfMessageRequest(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getPositionOfFolderRequest(int n) {
        try {
            this.proxy.getPositionOfFolderRequest(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteMessageRequest(String[] stringArray, boolean bl) {
        try {
            this.proxy.deleteMessageRequest(stringArray, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void sendMessageRequest(int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
        try {
            this.proxy.sendMessageRequest(n, n2, recipientList, string, string2, attachmentInformationArray, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getMessageContentsRequest(int n, String string, int n2) {
        try {
            this.proxy.getMessageContentsRequest(n, string, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMessageReadStatusRequest(String string, boolean bl) {
        try {
            this.proxy.setMessageReadStatusRequest(string, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void saveAsDraftRequest(String string, int n, RecipientList recipientList, String string2, String string3, int n2, AttachmentInformation[] attachmentInformationArray) {
        try {
            this.proxy.saveAsDraftRequest(string, n, recipientList, string2, string3, n2, attachmentInformationArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void extractInformationRequest(String string) {
        try {
            this.proxy.extractInformationRequest(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void changeTemplateRequest(int n, String string) {
        try {
            this.proxy.changeTemplateRequest(n, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getTemplateRequest(int n) {
        try {
            this.proxy.getTemplateRequest(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getTemplatesRequest() {
        try {
            this.proxy.getTemplatesRequest();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteTemplateRequest(int[] nArray) {
        try {
            this.proxy.deleteTemplateRequest(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteSimCardMessagesRequest(int n, int n2) {
        try {
            this.proxy.deleteSimCardMessagesRequest(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void decodeAttachmentRequest(AttachmentInformation attachmentInformation) {
        try {
            this.proxy.decodeAttachmentRequest(attachmentInformation);
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

