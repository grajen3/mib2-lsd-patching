/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.browser.DSIBrowserBookmark;
import de.esolutions.fw.comm.dsi.browser.DSIBrowserBookmarkC;
import de.esolutions.fw.comm.dsi.browser.DSIBrowserBookmarkReply;
import de.esolutions.fw.comm.dsi.browser.impl.DSIBrowserBookmarkProxy$1;
import de.esolutions.fw.comm.dsi.browser.impl.DSIBrowserBookmarkProxy$2;
import de.esolutions.fw.comm.dsi.browser.impl.DSIBrowserBookmarkProxy$3;
import de.esolutions.fw.comm.dsi.browser.impl.DSIBrowserBookmarkProxy$4;
import de.esolutions.fw.comm.dsi.browser.impl.DSIBrowserBookmarkProxy$5;
import de.esolutions.fw.comm.dsi.browser.impl.DSIBrowserBookmarkProxy$6;
import de.esolutions.fw.comm.dsi.browser.impl.DSIBrowserBookmarkReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.PathInfo;

public class DSIBrowserBookmarkProxy
implements DSIBrowserBookmark,
DSIBrowserBookmarkC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.browser.DSIBrowserBookmark");
    private Proxy proxy;

    public DSIBrowserBookmarkProxy(int n, DSIBrowserBookmarkReply dSIBrowserBookmarkReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("7b902419-3574-5aa6-8aaa-831e12ba2e89", n, "e25ea6e0-fb0e-57a2-908a-03c8634b8e94", "dsi.browser.DSIBrowserBookmark");
        DSIBrowserBookmarkReplyService dSIBrowserBookmarkReplyService = new DSIBrowserBookmarkReplyService(dSIBrowserBookmarkReply);
        this.proxy = new Proxy(serviceInstanceID, dSIBrowserBookmarkReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void listBookmarks(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
    }

    @Override
    public void addBookmark(Bookmark bookmark) {
        DSIBrowserBookmarkProxy$1 dSIBrowserBookmarkProxy$1 = new DSIBrowserBookmarkProxy$1(this, bookmark);
        this.proxy.remoteCallMethod((short)0, dSIBrowserBookmarkProxy$1);
    }

    @Override
    public void editBookmark(Bookmark bookmark, Bookmark bookmark2) {
        DSIBrowserBookmarkProxy$2 dSIBrowserBookmarkProxy$2 = new DSIBrowserBookmarkProxy$2(this, bookmark, bookmark2);
        this.proxy.remoteCallMethod((short)13, dSIBrowserBookmarkProxy$2);
    }

    @Override
    public void deleteBookmark(Bookmark bookmark) {
        DSIBrowserBookmarkProxy$3 dSIBrowserBookmarkProxy$3 = new DSIBrowserBookmarkProxy$3(this, bookmark);
        this.proxy.remoteCallMethod((short)9, dSIBrowserBookmarkProxy$3);
    }

    @Override
    public void createFolder(Bookmark bookmark) {
        DSIBrowserBookmarkProxy$4 dSIBrowserBookmarkProxy$4 = new DSIBrowserBookmarkProxy$4(this, bookmark);
        this.proxy.remoteCallMethod((short)7, dSIBrowserBookmarkProxy$4);
    }

    @Override
    public void deleteFolder(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    @Override
    public void renameFolder(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }

    @Override
    public void exportBookmarks(PathInfo pathInfo) {
        DSIBrowserBookmarkProxy$5 dSIBrowserBookmarkProxy$5 = new DSIBrowserBookmarkProxy$5(this, pathInfo);
        this.proxy.remoteCallMethod((short)15, dSIBrowserBookmarkProxy$5);
    }

    @Override
    public void importBookmarks(PathInfo pathInfo, boolean bl, boolean bl2) {
        DSIBrowserBookmarkProxy$6 dSIBrowserBookmarkProxy$6 = new DSIBrowserBookmarkProxy$6(this, pathInfo, bl, bl2);
        this.proxy.remoteCallMethod((short)19, dSIBrowserBookmarkProxy$6);
    }

    @Override
    public void getQuotaInformation() {
        this.proxy.remoteCallMethod((short)17, null);
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
        this.proxy.remoteCallMethod((short)26, genericSerializable);
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
        this.proxy.remoteCallMethod((short)27, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)25, null);
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
        this.proxy.remoteCallMethod((short)5, genericSerializable);
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
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)4, null);
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
        this.proxy.remoteCallMethod((short)31, genericSerializable);
    }
}

