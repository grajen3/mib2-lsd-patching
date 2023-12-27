/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.proxy;

import de.vw.mib.reflection.AbstractProxy;
import de.vw.mib.reflection.InvocationHandler;
import de.vw.mib.reflection.RuntimeUtil;
import de.vw.mib.reflection.pool.ObjArrayPool;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.DSIRadioTaggingListener;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.DSIMessagingListener;
import org.dsi.ifc.messaging.ExtractedItem;
import org.dsi.ifc.messaging.FolderEntry;
import org.dsi.ifc.messaging.ListChangedInformation;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessagingAccount;
import org.dsi.ifc.messaging.RecipientList;
import org.dsi.ifc.messaging.StatusInformation;
import org.dsi.ifc.messaging.Template;

public final class LR5d68b7de7
extends AbstractProxy
implements DSIRadioTaggingListener,
DSIMessagingListener {
    private static final Method[] JMS = new Method[30];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5d68b7de7(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void tagResult(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d68b7de7.gjm(0, "org.dsi.ifc.media.DSIRadioTaggingListener", -858085275, 1687814400), 0, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateCompatibleDevAvail(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5d68b7de7.gjm(1, "org.dsi.ifc.media.DSIRadioTaggingListener", -323505802, 1676164096), 1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void groupTagsResult(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5d68b7de7.gjm(2, "org.dsi.ifc.media.DSIRadioTaggingListener", -357312187, 1676164096), 2, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5d68b7de7.gjm(3, "org.dsi.ifc.media.DSIRadioTaggingListener", -1459926625, 1276482132), -1, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void indicateMessageStatus(StatusInformation statusInformation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = statusInformation;
            this.h.invoke(this, LR5d68b7de7.gjm(4, "org.dsi.ifc.messaging.DSIMessagingListener", 367482361, 2132702180), 4, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void indicateFolderInformation(FolderEntry folderEntry) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = folderEntry;
            this.h.invoke(this, LR5d68b7de7.gjm(5, "org.dsi.ifc.messaging.DSIMessagingListener", -1696570774, 1238458065), 5, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void indicateListChanged(ListChangedInformation listChangedInformation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = listChangedInformation;
            this.h.invoke(this, LR5d68b7de7.gjm(6, "org.dsi.ifc.messaging.DSIMessagingListener", 843982828, 1535763889), 6, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateSynchInProgress(boolean bl, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d68b7de7.gjm(7, "org.dsi.ifc.messaging.DSIMessagingListener", -348817293, -1665395196), 7, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void updateMessagingAccounts(MessagingAccount[] messagingAccountArray, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = messagingAccountArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d68b7de7.gjm(8, "org.dsi.ifc.messaging.DSIMessagingListener", -1230547979, 84514416), 8, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void indicateNewMessage(boolean bl, String string, int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(bl);
            objectArray[1] = string;
            objectArray[2] = RuntimeUtil.valueOf(n);
            objectArray[3] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5d68b7de7.gjm(9, "org.dsi.ifc.messaging.DSIMessagingListener", 1426071559, 738365589), 9, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void listEntriesResponse(int n, int n2, ListEntry[] listEntryArray, int n3, int n4, int n5) {
        try {
            Object[] objectArray = this.p.borrowArray(6);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = listEntryArray;
            objectArray[3] = RuntimeUtil.valueOf(n3);
            objectArray[4] = RuntimeUtil.valueOf(n4);
            objectArray[5] = RuntimeUtil.valueOf(n5);
            this.h.invoke(this, LR5d68b7de7.gjm(10, "org.dsi.ifc.messaging.DSIMessagingListener", -395960423, 674953789), 10, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getPositionOfMessageResponse(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5d68b7de7.gjm(11, "org.dsi.ifc.messaging.DSIMessagingListener", 662711659, 1676164096), 11, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getPositionOfFolderResponse(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5d68b7de7.gjm(12, "org.dsi.ifc.messaging.DSIMessagingListener", -1164201281, 1676164096), 12, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void changeFolderResponse(FolderEntry folderEntry, int n) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = folderEntry;
            objectArray[1] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d68b7de7.gjm(13, "org.dsi.ifc.messaging.DSIMessagingListener", 351605607, 1210030801), 13, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void deleteMessageResponse(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5d68b7de7.gjm(14, "org.dsi.ifc.messaging.DSIMessagingListener", -1303741429, 1043255048), 14, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void sendMessageResponse(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5d68b7de7.gjm(15, "org.dsi.ifc.messaging.DSIMessagingListener", 896269974, 1676164096), 15, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getMessageContentsResponse(int n, MessageDetails messageDetails) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = messageDetails;
            this.h.invoke(this, LR5d68b7de7.gjm(16, "org.dsi.ifc.messaging.DSIMessagingListener", -505840282, 1877749075), 16, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void setMessageReadStatusResponse(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d68b7de7.gjm(17, "org.dsi.ifc.messaging.DSIMessagingListener", 591329258, 1687814400), 17, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void parseVCardResponse(int n, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            this.h.invoke(this, LR5d68b7de7.gjm(18, "org.dsi.ifc.messaging.DSIMessagingListener", -1987485266, 1909456715), 18, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void saveAsDraftResponse(int n, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            this.h.invoke(this, LR5d68b7de7.gjm(19, "org.dsi.ifc.messaging.DSIMessagingListener", 687171833, 1909456715), 19, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void extractInformationResponse(int n, ExtractedItem[] extractedItemArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = extractedItemArray;
            this.h.invoke(this, LR5d68b7de7.gjm(20, "org.dsi.ifc.messaging.DSIMessagingListener", -1049268619, -979540257), 20, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void changeTemplateResponse(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5d68b7de7.gjm(21, "org.dsi.ifc.messaging.DSIMessagingListener", 539343862, 1676164096), 21, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getTemplateResponse(int n, Template template) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = template;
            this.h.invoke(this, LR5d68b7de7.gjm(22, "org.dsi.ifc.messaging.DSIMessagingListener", -963332705, -1976980843), 22, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void getTemplatesResponse(int n, Template[] templateArray) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = templateArray;
            this.h.invoke(this, LR5d68b7de7.gjm(23, "org.dsi.ifc.messaging.DSIMessagingListener", 1501343454, -1730033871), 23, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void deleteTemplateResponse(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d68b7de7.gjm(24, "org.dsi.ifc.messaging.DSIMessagingListener", 457299211, 1687814400), 24, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void indicatePushMessageFailed(int n, int n2, int n3, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(4);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = string;
            this.h.invoke(this, LR5d68b7de7.gjm(25, "org.dsi.ifc.messaging.DSIMessagingListener", -422909134, -1008715669), 25, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void indicateSendMessage(int[] nArray, int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(8);
            objectArray[0] = nArray;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = RuntimeUtil.valueOf(n2);
            objectArray[3] = recipientList;
            objectArray[4] = string;
            objectArray[5] = string2;
            objectArray[6] = attachmentInformationArray;
            objectArray[7] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5d68b7de7.gjm(26, "org.dsi.ifc.messaging.DSIMessagingListener", 1527888342, 2025746114), 26, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void deleteSimCardMessagesResponse(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5d68b7de7.gjm(27, "org.dsi.ifc.messaging.DSIMessagingListener", -1638862026, 1687814400), 27, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public void decodeAttachmentResponse(int n, ResourceLocator resourceLocator) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = resourceLocator;
            this.h.invoke(this, LR5d68b7de7.gjm(28, "org.dsi.ifc.messaging.DSIMessagingListener", -2014321182, -2018418629), 28, objectArray);
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }
}

