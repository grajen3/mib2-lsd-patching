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
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIRadioTagging;
import org.dsi.ifc.media.TagInformation;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.DSIMessaging;
import org.dsi.ifc.messaging.RecipientList;

public final class LR5516e6557
extends AbstractProxy
implements DSIMessaging,
DSIRadioTagging {
    private static final Method[] JMS = new Method[31];
    private static final Object[] ZOA = new Object[0];
    private final ObjArrayPool p;
    private final InvocationHandler h;

    private static Method gjm(int n, String string, int n2, int n3) {
        return RuntimeUtil.getMethod(n, JMS, string, n2, n3);
    }

    public LR5516e6557(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        this.p = objArrayPool;
        this.h = invocationHandler;
    }

    @Override
    public void changeFolderRequest(int n, int n2, int n3, int n4, int n5) {
        try {
            Object[] objectArray = this.p.borrowArray(5);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            objectArray[3] = RuntimeUtil.valueOf(n4);
            objectArray[4] = RuntimeUtil.valueOf(n5);
            this.h.invoke(this, LR5516e6557.gjm(0, "org.dsi.ifc.messaging.DSIMessaging", -422392491, 148318748), 0, objectArray);
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
    public void listEntriesRequest(int n, int n2, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5516e6557.gjm(1, "org.dsi.ifc.messaging.DSIMessaging", -1831443914, 1043255048), 1, objectArray);
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
    public void getPositionOfMessageRequest(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR5516e6557.gjm(2, "org.dsi.ifc.messaging.DSIMessaging", 1931058443, -633848249), 2, objectArray);
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
    public void getPositionOfFolderRequest(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5516e6557.gjm(3, "org.dsi.ifc.messaging.DSIMessaging", -2134962971, 1687814400), 3, objectArray);
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
    public void deleteMessageRequest(String[] stringArray, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = stringArray;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5516e6557.gjm(4, "org.dsi.ifc.messaging.DSIMessaging", -2007935678, -160227418), 4, objectArray);
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
    public void sendMessageRequest(int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
        try {
            Object[] objectArray = this.p.borrowArray(7);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            objectArray[2] = recipientList;
            objectArray[3] = string;
            objectArray[4] = string2;
            objectArray[5] = attachmentInformationArray;
            objectArray[6] = RuntimeUtil.valueOf(n3);
            this.h.invoke(this, LR5516e6557.gjm(5, "org.dsi.ifc.messaging.DSIMessaging", -1516987553, 1652632588), 5, objectArray);
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
    public void getMessageContentsRequest(int n, String string, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(3);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            objectArray[2] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5516e6557.gjm(6, "org.dsi.ifc.messaging.DSIMessaging", 2040552872, 1276482132), 6, objectArray);
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
    public void setMessageReadStatusRequest(String string, boolean bl) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(bl);
            this.h.invoke(this, LR5516e6557.gjm(7, "org.dsi.ifc.messaging.DSIMessaging", -139729484, 372504021), 7, objectArray);
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
    public void saveAsDraftRequest(String string, int n, RecipientList recipientList, String string2, String string3, int n2, AttachmentInformation[] attachmentInformationArray) {
        try {
            Object[] objectArray = this.p.borrowArray(7);
            objectArray[0] = string;
            objectArray[1] = RuntimeUtil.valueOf(n);
            objectArray[2] = recipientList;
            objectArray[3] = string2;
            objectArray[4] = string3;
            objectArray[5] = RuntimeUtil.valueOf(n2);
            objectArray[6] = attachmentInformationArray;
            this.h.invoke(this, LR5516e6557.gjm(8, "org.dsi.ifc.messaging.DSIMessaging", 1384156795, -1475107342), 8, objectArray);
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
    public void extractInformationRequest(String string) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = string;
            this.h.invoke(this, LR5516e6557.gjm(9, "org.dsi.ifc.messaging.DSIMessaging", -1727464916, -633848249), 9, objectArray);
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
    public void changeTemplateRequest(int n, String string) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = string;
            this.h.invoke(this, LR5516e6557.gjm(10, "org.dsi.ifc.messaging.DSIMessaging", 1517402755, 1909456715), 10, objectArray);
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
    public void getTemplateRequest(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5516e6557.gjm(11, "org.dsi.ifc.messaging.DSIMessaging", -193691437, 1687814400), 11, objectArray);
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
    public void getTemplatesRequest() {
        try {
            this.h.invoke(this, LR5516e6557.gjm(12, "org.dsi.ifc.messaging.DSIMessaging", 30397182, 17), 12, ZOA);
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
    public void deleteTemplateRequest(int[] nArray) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = nArray;
            this.h.invoke(this, LR5516e6557.gjm(13, "org.dsi.ifc.messaging.DSIMessaging", -9879585, 3523), 13, objectArray);
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
    public void deleteSimCardMessagesRequest(int n, int n2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = RuntimeUtil.valueOf(n2);
            this.h.invoke(this, LR5516e6557.gjm(14, "org.dsi.ifc.messaging.DSIMessaging", 484323090, 1676164096), 14, objectArray);
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
    public void decodeAttachmentRequest(AttachmentInformation attachmentInformation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = attachmentInformation;
            this.h.invoke(this, LR5516e6557.gjm(15, "org.dsi.ifc.messaging.DSIMessaging", 322857421, -1375448439), 15, objectArray);
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
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR5516e6557.gjm(16, "org.dsi.ifc.messaging.DSIMessaging", -501696838, -904616957), -1, objectArray);
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
    public void setNotification(int n, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR5516e6557.gjm(17, "org.dsi.ifc.messaging.DSIMessaging", -501696838, 1805755651), -1, objectArray);
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
    public void setNotification(DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dSIListener;
            this.h.invoke(this, LR5516e6557.gjm(18, "org.dsi.ifc.messaging.DSIMessaging", -501696838, -864245041), -1, objectArray);
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
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = nArray;
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR5516e6557.gjm(19, "org.dsi.ifc.messaging.DSIMessaging", 1300919239, -904616957), -1, objectArray);
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
    public void clearNotification(int n, DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = RuntimeUtil.valueOf(n);
            objectArray[1] = dSIListener;
            this.h.invoke(this, LR5516e6557.gjm(20, "org.dsi.ifc.messaging.DSIMessaging", 1300919239, 1805755651), -1, objectArray);
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
    public void clearNotification(DSIListener dSIListener) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = dSIListener;
            this.h.invoke(this, LR5516e6557.gjm(21, "org.dsi.ifc.messaging.DSIMessaging", 1300919239, -864245041), -1, objectArray);
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
    public void tagSong(TagInformation tagInformation) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = tagInformation;
            this.h.invoke(this, LR5516e6557.gjm(22, "org.dsi.ifc.media.DSIRadioTagging", 1154395043, -1746074298), 22, objectArray);
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
    public void tagAmbiguousSong(TagInformation tagInformation, TagInformation tagInformation2) {
        try {
            Object[] objectArray = this.p.borrowArray(2);
            objectArray[0] = tagInformation;
            objectArray[1] = tagInformation2;
            this.h.invoke(this, LR5516e6557.gjm(23, "org.dsi.ifc.media.DSIRadioTagging", 1017541641, -180231836), 23, objectArray);
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
    public void groupTags(int n) {
        try {
            Object[] objectArray = this.p.borrowArray(1);
            objectArray[0] = RuntimeUtil.valueOf(n);
            this.h.invoke(this, LR5516e6557.gjm(24, "org.dsi.ifc.media.DSIRadioTagging", -1387684953, 1687814400), 24, objectArray);
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

