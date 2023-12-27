/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.messaging.DSIMessaging;
import de.esolutions.fw.comm.dsi.messaging.DSIMessagingC;
import de.esolutions.fw.comm.dsi.messaging.DSIMessagingReply;
import de.esolutions.fw.comm.dsi.messaging.impl.DSIMessagingProxy$1;
import de.esolutions.fw.comm.dsi.messaging.impl.DSIMessagingProxy$2;
import de.esolutions.fw.comm.dsi.messaging.impl.DSIMessagingProxy$3;
import de.esolutions.fw.comm.dsi.messaging.impl.DSIMessagingReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.RecipientList;

public class DSIMessagingProxy
implements DSIMessaging,
DSIMessagingC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.messaging.DSIMessaging");
    private Proxy proxy;

    public DSIMessagingProxy(int n, DSIMessagingReply dSIMessagingReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("743aa6c3-086a-5919-a112-d5e85bae6883", n, "07a18825-a105-59a1-ac0a-b9c70be30a21", "dsi.messaging.DSIMessaging");
        DSIMessagingReplyService dSIMessagingReplyService = new DSIMessagingReplyService(dSIMessagingReply);
        this.proxy = new Proxy(serviceInstanceID, dSIMessagingReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void changeFolderRequest(int n, int n2, int n3, int n4, int n5) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
            genericSerializable.putInt32(n4);
            genericSerializable.putInt32(n5);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)1, genericSerializable);
    }

    @Override
    public void listEntriesRequest(int n, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)51, genericSerializable);
    }

    @Override
    public void getPositionOfMessageRequest(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)65, genericSerializable);
    }

    @Override
    public void getPositionOfFolderRequest(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)63, genericSerializable);
    }

    @Override
    public void deleteMessageRequest(String[] stringArray, boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalStringVarArray(stringArray);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)57, genericSerializable);
    }

    @Override
    public void sendMessageRequest(int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
        DSIMessagingProxy$1 dSIMessagingProxy$1 = new DSIMessagingProxy$1(this, n, n2, recipientList, string, string2, attachmentInformationArray, n3);
        this.proxy.remoteCallMethod((short)75, dSIMessagingProxy$1);
    }

    @Override
    public void getMessageContentsRequest(int n, String string, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)61, genericSerializable);
    }

    @Override
    public void setMessageReadStatusRequest(String string, boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)77, genericSerializable);
    }

    @Override
    public void saveAsDraftRequest(String string, int n, RecipientList recipientList, String string2, String string3, int n2, AttachmentInformation[] attachmentInformationArray) {
        DSIMessagingProxy$2 dSIMessagingProxy$2 = new DSIMessagingProxy$2(this, string, n, recipientList, string2, string3, n2, attachmentInformationArray);
        this.proxy.remoteCallMethod((short)73, dSIMessagingProxy$2);
    }

    @Override
    public void extractInformationRequest(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)60, genericSerializable);
    }

    @Override
    public void changeTemplateRequest(int n, String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void getTemplateRequest(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    @Override
    public void getTemplatesRequest() {
        this.proxy.remoteCallMethod((short)20, null);
    }

    @Override
    public void deleteTemplateRequest(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    @Override
    public void deleteSimCardMessagesRequest(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)58, genericSerializable);
    }

    @Override
    public void decodeAttachmentRequest(AttachmentInformation attachmentInformation) {
        DSIMessagingProxy$3 dSIMessagingProxy$3 = new DSIMessagingProxy$3(this, attachmentInformation);
        this.proxy.remoteCallMethod((short)79, dSIMessagingProxy$3);
    }

    @Override
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)33, genericSerializable);
    }

    @Override
    public void setNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)34, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)32, null);
    }

    @Override
    public void clearNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void clearNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)5, null);
    }

    @Override
    public void yySet(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)42, genericSerializable);
    }
}

