/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.browser.DSIBrowserBookmarkReply;
import de.esolutions.fw.comm.dsi.browser.impl.BookmarkSerializer;
import de.esolutions.fw.comm.dsi.browser.impl.ImportReportSerializer;
import de.esolutions.fw.comm.dsi.browser.impl.PathInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.ImportReport;
import org.dsi.ifc.browser.PathInfo;

public class DSIBrowserBookmarkReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.browser.DSIBrowserBookmark");
    private static int dynamicHandle = 0;
    private DSIBrowserBookmarkReply p_DSIBrowserBookmarkReply;

    public DSIBrowserBookmarkReplyService(DSIBrowserBookmarkReply dSIBrowserBookmarkReply) {
        super(new ServiceInstanceID("86539966-2a35-53bb-8c25-e66e780f75eb", DSIBrowserBookmarkReplyService.nextDynamicHandle(), "c2fe38b4-9c45-5465-b247-db69a6a5f0e2", "dsi.browser.DSIBrowserBookmark"));
        this.p_DSIBrowserBookmarkReply = dSIBrowserBookmarkReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 22: {
                    String string = iDeserializer.getOptionalString();
                    Bookmark[] bookmarkArray = BookmarkSerializer.getOptionalBookmarkVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserBookmarkReply.listBookmarksResult(string, bookmarkArray, n);
                    break;
                }
                case 3: {
                    this.p_DSIBrowserBookmarkReply.bookmarkListInvalid();
                    break;
                }
                case 1: {
                    Bookmark bookmark = BookmarkSerializer.getOptionalBookmark(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserBookmarkReply.addBookmarkResult(bookmark, n);
                    break;
                }
                case 14: {
                    Bookmark bookmark = BookmarkSerializer.getOptionalBookmark(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserBookmarkReply.editBookmarkResult(bookmark, n);
                    break;
                }
                case 10: {
                    Bookmark bookmark = BookmarkSerializer.getOptionalBookmark(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserBookmarkReply.deleteBookmarkResult(bookmark, n);
                    break;
                }
                case 8: {
                    Bookmark bookmark = BookmarkSerializer.getOptionalBookmark(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserBookmarkReply.createFolderResult(bookmark, n);
                    break;
                }
                case 12: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserBookmarkReply.deleteFolderResult(string, n);
                    break;
                }
                case 24: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserBookmarkReply.renameFolderResult(string, n);
                    break;
                }
                case 16: {
                    PathInfo pathInfo = PathInfoSerializer.getOptionalPathInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserBookmarkReply.exportBookmarksResult(pathInfo, n);
                    break;
                }
                case 28: {
                    PathInfo pathInfo = PathInfoSerializer.getOptionalPathInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIBrowserBookmarkReply.updateExportBookmarksProgress(pathInfo, n, n2);
                    break;
                }
                case 20: {
                    PathInfo pathInfo = PathInfoSerializer.getOptionalPathInfo(iDeserializer);
                    ImportReport importReport = ImportReportSerializer.getOptionalImportReport(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserBookmarkReply.importBookmarksResult(pathInfo, importReport, n);
                    break;
                }
                case 29: {
                    PathInfo pathInfo = PathInfoSerializer.getOptionalPathInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIBrowserBookmarkReply.updateImportBookmarksProgress(pathInfo, n, n3);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIBrowserBookmarkReply.getQuotaInformationResult(n, n4, n5);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIBrowserBookmarkReply.asyncException(n, string, n6);
                    break;
                }
                case 30: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIBrowserBookmarkReply.yyIndication(string, string2);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

