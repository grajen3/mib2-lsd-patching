/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.speechrec;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.speechrec.DictionaryEntry;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.GrammarStateInfo;
import org.dsi.ifc.speechrec.GraphemicGroup;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.NBestListEntry;
import org.dsi.ifc.speechrec.NBestSlot;
import org.dsi.ifc.speechrec.PhoneticEntry;
import org.dsi.ifc.speechrec.VDECapabilities;

public final class DSISpeechRecTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_DICTIONARYENTRY;
    private static final int ID_GRAMMAR;
    private static final int ID_GRAMMARINFO;
    private static final int ID_GRAMMARSTATEINFO;
    private static final int ID_GRAPHEMICGROUP;
    private static final int ID_NBESTLIST;
    private static final int ID_NBESTLISTENTRY;
    private static final int ID_NBESTSLOT;
    private static final int ID_PHONETICENTRY;
    private static final int ID_VDECAPABILITIES;
    static /* synthetic */ Class class$org$dsi$ifc$speechrec$DictionaryEntry;
    static /* synthetic */ Class class$org$dsi$ifc$speechrec$Grammar;
    static /* synthetic */ Class class$org$dsi$ifc$speechrec$GrammarInfo;
    static /* synthetic */ Class class$org$dsi$ifc$speechrec$GrammarStateInfo;
    static /* synthetic */ Class class$org$dsi$ifc$speechrec$GraphemicGroup;
    static /* synthetic */ Class class$org$dsi$ifc$speechrec$NBestList;
    static /* synthetic */ Class class$org$dsi$ifc$speechrec$NBestListEntry;
    static /* synthetic */ Class class$org$dsi$ifc$speechrec$NBestSlot;
    static /* synthetic */ Class class$org$dsi$ifc$speechrec$PhoneticEntry;
    static /* synthetic */ Class class$org$dsi$ifc$speechrec$VDECapabilities;

    public DSISpeechRecTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$speechrec$DictionaryEntry == null ? (class$org$dsi$ifc$speechrec$DictionaryEntry = DSISpeechRecTracer.class$("org.dsi.ifc.speechrec.DictionaryEntry")) : class$org$dsi$ifc$speechrec$DictionaryEntry, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$speechrec$Grammar == null ? (class$org$dsi$ifc$speechrec$Grammar = DSISpeechRecTracer.class$("org.dsi.ifc.speechrec.Grammar")) : class$org$dsi$ifc$speechrec$Grammar, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$speechrec$GrammarInfo == null ? (class$org$dsi$ifc$speechrec$GrammarInfo = DSISpeechRecTracer.class$("org.dsi.ifc.speechrec.GrammarInfo")) : class$org$dsi$ifc$speechrec$GrammarInfo, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$speechrec$GrammarStateInfo == null ? (class$org$dsi$ifc$speechrec$GrammarStateInfo = DSISpeechRecTracer.class$("org.dsi.ifc.speechrec.GrammarStateInfo")) : class$org$dsi$ifc$speechrec$GrammarStateInfo, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$speechrec$GraphemicGroup == null ? (class$org$dsi$ifc$speechrec$GraphemicGroup = DSISpeechRecTracer.class$("org.dsi.ifc.speechrec.GraphemicGroup")) : class$org$dsi$ifc$speechrec$GraphemicGroup, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$speechrec$NBestList == null ? (class$org$dsi$ifc$speechrec$NBestList = DSISpeechRecTracer.class$("org.dsi.ifc.speechrec.NBestList")) : class$org$dsi$ifc$speechrec$NBestList, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$speechrec$NBestListEntry == null ? (class$org$dsi$ifc$speechrec$NBestListEntry = DSISpeechRecTracer.class$("org.dsi.ifc.speechrec.NBestListEntry")) : class$org$dsi$ifc$speechrec$NBestListEntry, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$speechrec$NBestSlot == null ? (class$org$dsi$ifc$speechrec$NBestSlot = DSISpeechRecTracer.class$("org.dsi.ifc.speechrec.NBestSlot")) : class$org$dsi$ifc$speechrec$NBestSlot, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$speechrec$PhoneticEntry == null ? (class$org$dsi$ifc$speechrec$PhoneticEntry = DSISpeechRecTracer.class$("org.dsi.ifc.speechrec.PhoneticEntry")) : class$org$dsi$ifc$speechrec$PhoneticEntry, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$speechrec$VDECapabilities == null ? (class$org$dsi$ifc$speechrec$VDECapabilities = DSISpeechRecTracer.class$("org.dsi.ifc.speechrec.VDECapabilities")) : class$org$dsi$ifc$speechrec$VDECapabilities, 10);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceDictionaryEntry(printWriter, (DictionaryEntry)object);
                break;
            }
            case 2: {
                this.traceGrammar(printWriter, (Grammar)object);
                break;
            }
            case 3: {
                this.traceGrammarInfo(printWriter, (GrammarInfo)object);
                break;
            }
            case 4: {
                this.traceGrammarStateInfo(printWriter, (GrammarStateInfo)object);
                break;
            }
            case 5: {
                this.traceGraphemicGroup(printWriter, (GraphemicGroup)object);
                break;
            }
            case 6: {
                this.traceNBestList(printWriter, (NBestList)object);
                break;
            }
            case 7: {
                this.traceNBestListEntry(printWriter, (NBestListEntry)object);
                break;
            }
            case 8: {
                this.traceNBestSlot(printWriter, (NBestSlot)object);
                break;
            }
            case 9: {
                this.tracePhoneticEntry(printWriter, (PhoneticEntry)object);
                break;
            }
            case 10: {
                this.traceVDECapabilities(printWriter, (VDECapabilities)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceDictionaryEntry(PrintWriter printWriter, DictionaryEntry dictionaryEntry) {
        if (dictionaryEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dictionaryEntry.orthography);
        printWriter.print(dictionaryEntry.ttsTransIndex);
        if (dictionaryEntry.phoneticList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = dictionaryEntry.phoneticList.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, dictionaryEntry.phoneticList[i2]);
            }
        }
    }

    private void traceGrammar(PrintWriter printWriter, Grammar grammar) {
        int n;
        int n2;
        if (grammar == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(grammar.grammarType);
        printWriter.print(grammar.commandHierarchy);
        printWriter.print(grammar.publicGrammar);
        if (grammar.listData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = grammar.listData.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(grammar.listData[n]);
            }
        }
        if (grammar.listIdData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = grammar.listIdData.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(grammar.listIdData[n]);
            }
        }
        printWriter.print(grammar.listSourceId);
        printWriter.print(grammar.grammarId);
        printWriter.print(grammar.grammarText);
        printWriter.print(grammar.nBestGraphemicGroupIndex);
        printWriter.print(grammar.nBestListID);
    }

    private void traceGrammarInfo(PrintWriter printWriter, GrammarInfo grammarInfo) {
        if (grammarInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(grammarInfo.id);
        printWriter.print(grammarInfo.commandHieratchy);
    }

    private void traceGrammarStateInfo(PrintWriter printWriter, GrammarStateInfo grammarStateInfo) {
        if (grammarStateInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(grammarStateInfo.grammarStatus);
        if (grammarStateInfo.slotIds == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = grammarStateInfo.slotIds.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(grammarStateInfo.slotIds[i2]);
            }
        }
    }

    private void traceGraphemicGroup(PrintWriter printWriter, GraphemicGroup graphemicGroup) {
        if (graphemicGroup == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(graphemicGroup.groupText);
        printWriter.print(graphemicGroup.graphemicGroupSize);
        if (graphemicGroup.slots == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = graphemicGroup.slots.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, graphemicGroup.slots[i2]);
            }
        }
    }

    private void traceNBestList(PrintWriter printWriter, NBestList nBestList) {
        int n;
        int n2;
        if (nBestList == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        if (nBestList.graphemicGroups == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = nBestList.graphemicGroups.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, nBestList.graphemicGroups[n]);
            }
        }
        if (nBestList.entries == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = nBestList.entries.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, nBestList.entries[n]);
            }
        }
        printWriter.print(nBestList.nBestListID);
    }

    private void traceNBestListEntry(PrintWriter printWriter, NBestListEntry nBestListEntry) {
        if (nBestListEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(nBestListEntry.grammarId);
        printWriter.print(nBestListEntry.recognizedString);
        printWriter.print(nBestListEntry.recognizedTag);
        printWriter.print(nBestListEntry.confidence);
        printWriter.print(nBestListEntry.commandHierarchie);
        printWriter.print(nBestListEntry.grammarType);
        printWriter.print(nBestListEntry.graphemicGroupIndex);
        if (nBestListEntry.slots == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = nBestListEntry.slots.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, nBestListEntry.slots[i2]);
            }
        }
    }

    private void traceNBestSlot(PrintWriter printWriter, NBestSlot nBestSlot) {
        if (nBestSlot == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(nBestSlot.id);
        printWriter.print(nBestSlot.recognizedString);
        printWriter.print(nBestSlot.objectId);
        printWriter.print(nBestSlot.index);
        printWriter.print(nBestSlot.objectStringId);
    }

    private void tracePhoneticEntry(PrintWriter printWriter, PhoneticEntry phoneticEntry) {
        if (phoneticEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(phoneticEntry.alphabet);
        printWriter.print(phoneticEntry.language);
        printWriter.print(phoneticEntry.transcription);
    }

    private void traceVDECapabilities(PrintWriter printWriter, VDECapabilities vDECapabilities) {
        int n;
        int n2;
        if (vDECapabilities == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(vDECapabilities.countryAbbreviation);
        printWriter.print(vDECapabilities.oneShot);
        printWriter.print(vDECapabilities.fullWord);
        printWriter.print(vDECapabilities.spelling);
        printWriter.print(vDECapabilities.poiFuzzy);
        printWriter.print(vDECapabilities.flexVDE);
        if (vDECapabilities.grammarLanguage == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = vDECapabilities.grammarLanguage.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(vDECapabilities.grammarLanguage[n]);
            }
        }
        if (vDECapabilities.flexVDELanguage == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = vDECapabilities.flexVDELanguage.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(vDECapabilities.flexVDELanguage[n]);
            }
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

