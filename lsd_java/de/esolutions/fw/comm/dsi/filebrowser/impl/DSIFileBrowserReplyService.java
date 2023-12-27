/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.filebrowser.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.filebrowser.DSIFileBrowserReply;
import de.esolutions.fw.comm.dsi.filebrowser.impl.BrowsedFileSetSerializer;
import de.esolutions.fw.comm.dsi.filebrowser.impl.PathSerializer;
import de.esolutions.fw.comm.dsi.filebrowser.impl.PreviewInfoSerializer;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.filebrowser.PreviewInfo;
import org.dsi.ifc.global.ResourceLocator;

public class DSIFileBrowserReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.filebrowser.DSIFileBrowser");
    private static int dynamicHandle = 0;
    private DSIFileBrowserReply p_DSIFileBrowserReply;

    public DSIFileBrowserReplyService(DSIFileBrowserReply dSIFileBrowserReply) {
        super(new ServiceInstanceID("d35f3761-409f-5775-9bad-3b4fe05de089", DSIFileBrowserReplyService.nextDynamicHandle(), "b7f8fe20-4d06-5071-980e-4b9f1153f7d1", "dsi.filebrowser.DSIFileBrowser"));
        this.p_DSIFileBrowserReply = dSIFileBrowserReply;
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
                case 41: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    Path path = PathSerializer.getOptionalPath(iDeserializer);
                    this.p_DSIFileBrowserReply.startResult(n, n2, path);
                    break;
                }
                case 36: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIFileBrowserReply.setFileExtensionFilterResult(n, n3);
                    break;
                }
                case 38: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIFileBrowserReply.setFileTypeFilterResult(n, n4);
                    break;
                }
                case 34: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    BrowsedFileSet browsedFileSet = BrowsedFileSetSerializer.getOptionalBrowsedFileSet(iDeserializer);
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIFileBrowserReply.getViewWindowResult(n, n5, n6, browsedFileSet, n7);
                    break;
                }
                case 53: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    BrowsedFileSet browsedFileSet = BrowsedFileSetSerializer.getOptionalBrowsedFileSet(iDeserializer);
                    PreviewInfo[] previewInfoArray = PreviewInfoSerializer.getOptionalPreviewInfoVarArray(iDeserializer);
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIFileBrowserReply.getViewWindowWithPreviewsResult(n, n8, n9, browsedFileSet, previewInfoArray, n10);
                    break;
                }
                case 31: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
                    int n13 = iDeserializer.getInt32();
                    this.p_DSIFileBrowserReply.getResourceLocatorWindowResult(n, n11, n12, resourceLocatorArray, n13);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSIFileBrowserReply.indicateSelectionResult(n, n14, n15);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    Path path = PathSerializer.getOptionalPath(iDeserializer);
                    this.p_DSIFileBrowserReply.changeFolderResult(n, n16, path);
                    break;
                }
                case 33: {
                    int n = iDeserializer.getInt32();
                    int n17 = iDeserializer.getInt32();
                    int n18 = iDeserializer.getInt32();
                    this.p_DSIFileBrowserReply.getSelectedFilesResult(n, n17, n18);
                    break;
                }
                case 32: {
                    int n = iDeserializer.getInt32();
                    int n19 = iDeserializer.getInt32();
                    ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
                    this.p_DSIFileBrowserReply.getResourceLocatorsResult(n, n19, resourceLocatorArray);
                    break;
                }
                case 29: {
                    int n = iDeserializer.getInt32();
                    int n20 = iDeserializer.getInt32();
                    int n21 = iDeserializer.getInt32();
                    this.p_DSIFileBrowserReply.getFileCountResult(n, n20, n21);
                    break;
                }
                case 30: {
                    int n = iDeserializer.getInt32();
                    int n22 = iDeserializer.getInt32();
                    int n23 = iDeserializer.getInt32();
                    int n24 = iDeserializer.getInt32();
                    this.p_DSIFileBrowserReply.getFileCountWithFileTypeFilterResult(n, n22, n23, n24);
                    break;
                }
                case 40: {
                    int n = iDeserializer.getInt32();
                    int n25 = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIFileBrowserReply.spellerResult(n, n25, string, string2);
                    break;
                }
                case 39: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIFileBrowserReply.setLanguageResult(n, string);
                    break;
                }
                case 46: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIFileBrowserReply.setFileTypeActiveResult(n);
                    break;
                }
                case 44: {
                    int n = iDeserializer.getInt32();
                    int n26 = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_DSIFileBrowserReply.validateSpellerCharsResult(n, n26, string, string3);
                    break;
                }
                case 50: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    ResourceLocator resourceLocator2 = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIFileBrowserReply.createPreviewImageResult(resourceLocator, resourceLocator2, n);
                    break;
                }
                case 48: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIFileBrowserReply.cancelPreviewCreationResult(n);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n27 = iDeserializer.getInt32();
                    this.p_DSIFileBrowserReply.asyncException(n, string, n27);
                    break;
                }
                case 42: {
                    String string = iDeserializer.getOptionalString();
                    String string4 = iDeserializer.getOptionalString();
                    this.p_DSIFileBrowserReply.yyIndication(string, string4);
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

