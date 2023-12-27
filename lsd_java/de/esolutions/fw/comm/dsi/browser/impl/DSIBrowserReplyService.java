/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.browser.DSIBrowserReply;
import de.esolutions.fw.comm.dsi.browser.impl.HistoryEntrySerializer;
import de.esolutions.fw.comm.dsi.browser.impl.KeyboardInfoSerializer;
import de.esolutions.fw.comm.dsi.browser.impl.SelectionEntrySerializer;
import de.esolutions.fw.comm.dsi.browser.impl.TimePeriodSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.browser.HistoryEntry;
import org.dsi.ifc.browser.KeyboardInfo;
import org.dsi.ifc.browser.SelectionEntry;
import org.dsi.ifc.browser.TimePeriod;

public class DSIBrowserReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.browser.DSIBrowser");
    private static int dynamicHandle = 0;
    private DSIBrowserReply p_DSIBrowserReply;

    public DSIBrowserReplyService(DSIBrowserReply dSIBrowserReply) {
        super(new ServiceInstanceID("b9025762-f046-5aaa-bcde-0e6654d49868", DSIBrowserReplyService.nextDynamicHandle(), "a9cab10b-fbea-5364-a0dc-125101f3dcef", "dsi.browser.DSIBrowser"));
        this.p_DSIBrowserReply = dSIBrowserReply;
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
                case 56: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIBrowserReply.updateBrowserState(n, n2);
                    break;
                }
                case 60: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserReply.updatePageTitle(string, n);
                    break;
                }
                case 55: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserReply.updateActiveUrl(string, n);
                    break;
                }
                case 66: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIBrowserReply.updateZoomFactor(n, n3);
                    break;
                }
                case 65: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserReply.updateVirtualKeyboardStatus(bl, n);
                    break;
                }
                case 58: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserReply.updateEncryption(bl, n);
                    break;
                }
                case 59: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserReply.updateHasFocus(bl, n);
                    break;
                }
                case 57: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIBrowserReply.updateButtonState(n, n4, n5);
                    break;
                }
                case 61: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIBrowserReply.updateProgress(n, n6);
                    break;
                }
                case 62: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIBrowserReply.updateScrollbarX(n, n7, n8, n9);
                    break;
                }
                case 63: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIBrowserReply.updateScrollbarY(n, n10, n11, n12);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIBrowserReply.getPreferenceResult(n, n13, string);
                    break;
                }
                case 44: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserReply.resumeBrowserResult(n);
                    break;
                }
                case 28: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIBrowserReply.indicateEfiUrl(string);
                    break;
                }
                case 30: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIBrowserReply.indicateUnknownMimeType(string, string2);
                    break;
                }
                case 27: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIBrowserReply.indicateDownloadUrl(string);
                    break;
                }
                case 29: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIBrowserReply.indicatePopup(string);
                    break;
                }
                case 26: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserReply.indicateDownloadProgress(string, string3, n);
                    break;
                }
                case 34: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIBrowserReply.javascriptAlert(string);
                    break;
                }
                case 35: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIBrowserReply.javascriptConfirm(string);
                    break;
                }
                case 36: {
                    String string = iDeserializer.getOptionalString();
                    String string4 = iDeserializer.getOptionalString();
                    this.p_DSIBrowserReply.javascriptPrompt(string, string4);
                    break;
                }
                case 64: {
                    SelectionEntry[] selectionEntryArray = SelectionEntrySerializer.getOptionalSelectionEntryVarArray(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserReply.updateSelectionListContent(selectionEntryArray, bl, n);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserReply.exportBrowserDataResult(n);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserReply.importBrowserDataResult(n);
                    break;
                }
                case 18: {
                    TimePeriod timePeriod = TimePeriodSerializer.getOptionalTimePeriod(iDeserializer);
                    HistoryEntry[] historyEntryArray = HistoryEntrySerializer.getOptionalHistoryEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserReply.getHistoryResult(timePeriod, historyEntryArray, n);
                    break;
                }
                case 70: {
                    boolean bl = iDeserializer.getBool();
                    KeyboardInfo keyboardInfo = KeyboardInfoSerializer.getOptionalKeyboardInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIBrowserReply.updateKeyboardDisplay(bl, keyboardInfo, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSIBrowserReply.asyncException(n, string, n14);
                    break;
                }
                case 67: {
                    String string = iDeserializer.getOptionalString();
                    String string5 = iDeserializer.getOptionalString();
                    this.p_DSIBrowserReply.yyIndication(string, string5);
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

