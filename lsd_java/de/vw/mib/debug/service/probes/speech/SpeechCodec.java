/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.speech;

import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.log4mib.BinaryMessage;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.GraphemicGroup;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.NBestListEntry;
import org.dsi.ifc.speechrec.NBestSlot;
import org.dsi.ifc.tts.DynamicTTSPromptPart;
import org.dsi.ifc.tts.TTSPrompt;

public final class SpeechCodec
extends AbstractProbeCodec {
    private byte messageCount;

    public SpeechCodec(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    public void encodeUnloadGrammar(GrammarInfo[] grammarInfoArray) {
        BinaryMessage binaryMessage = this.createMessage((byte)3);
        byte by = this.messageCount;
        this.messageCount = (byte)(by + 1);
        binaryMessage.append(by);
        this.writeGrammarInfoArray(binaryMessage, grammarInfoArray);
        binaryMessage.send();
    }

    public void encodeLoadGrammar(Grammar[] grammarArray) {
        BinaryMessage binaryMessage = this.createMessage((byte)2);
        byte by = this.messageCount;
        this.messageCount = (byte)(by + 1);
        binaryMessage.append(by);
        this.writeGrammarArray(binaryMessage, grammarArray);
        binaryMessage.send();
    }

    public void encodeResponseWaitForResults(int n, NBestList nBestList) {
        BinaryMessage binaryMessage = this.createMessage((byte)4);
        byte by = this.messageCount;
        this.messageCount = (byte)(by + 1);
        binaryMessage.append(by);
        binaryMessage.append(n);
        this.writeNBestList(binaryMessage, nBestList);
        binaryMessage.send();
    }

    public void encodeRequestPlayTone(short s, int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)5);
        byte by = this.messageCount;
        this.messageCount = (byte)(by + 1);
        binaryMessage.append(by);
        binaryMessage.append(s);
        binaryMessage.append(n);
        binaryMessage.send();
    }

    public void encodeSpeakPrompt(short s, TTSPrompt tTSPrompt) {
        BinaryMessage binaryMessage = this.createMessage((byte)6);
        byte by = this.messageCount;
        this.messageCount = (byte)(by + 1);
        binaryMessage.append(by);
        binaryMessage.append(s);
        this.writeTTSPrompt(binaryMessage, tTSPrompt);
        binaryMessage.send();
    }

    public void encodeWarn(String string) {
        BinaryMessage binaryMessage = this.createMessage((byte)8);
        byte by = this.messageCount;
        this.messageCount = (byte)(by + 1);
        binaryMessage.append(by);
        this.writeString(binaryMessage, string);
        binaryMessage.send();
    }

    public void encodeError(String string) {
        BinaryMessage binaryMessage = this.createMessage((byte)9);
        byte by = this.messageCount;
        this.messageCount = (byte)(by + 1);
        binaryMessage.append(by);
        this.writeString(binaryMessage, string);
        binaryMessage.send();
    }

    public void encodeInfo(String string) {
        BinaryMessage binaryMessage = this.createMessage((byte)7);
        byte by = this.messageCount;
        this.messageCount = (byte)(by + 1);
        binaryMessage.append(by);
        this.writeString(binaryMessage, string);
        binaryMessage.send();
    }

    public void encodeChangedDialogManagerState(int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)10);
        byte by = this.messageCount;
        this.messageCount = (byte)(by + 1);
        binaryMessage.append(by);
        binaryMessage.append(n);
        binaryMessage.send();
    }

    public void encodeChangedSlotState(int n, int n2) {
        BinaryMessage binaryMessage = this.createMessage((byte)11);
        byte by = this.messageCount;
        this.messageCount = (byte)(by + 1);
        binaryMessage.append(by);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.send();
    }

    public void encodeChangedBackStack(String string) {
        BinaryMessage binaryMessage = this.createMessage((byte)12);
        byte by = this.messageCount;
        this.messageCount = (byte)(by + 1);
        binaryMessage.append(by);
        binaryMessage.append(string);
        binaryMessage.send();
    }

    private void writeLongArray(BinaryMessage binaryMessage, long[] lArray) {
        if (lArray != null) {
            binaryMessage.append(true);
            binaryMessage.append(lArray.length);
            for (int i2 = 0; i2 < lArray.length; ++i2) {
                binaryMessage.append(lArray[i2]);
            }
        } else {
            binaryMessage.append(false);
        }
    }

    private void writeStringArray(BinaryMessage binaryMessage, String[] stringArray) {
        if (stringArray != null) {
            binaryMessage.append(true);
            binaryMessage.append(stringArray.length);
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                this.writeString(binaryMessage, stringArray[i2]);
            }
        } else {
            binaryMessage.append(false);
        }
    }

    private void writeString(BinaryMessage binaryMessage, String string) {
        if (string != null) {
            binaryMessage.append(true);
            binaryMessage.append(string);
        } else {
            binaryMessage.append(false);
        }
    }

    private void writeGrammar(BinaryMessage binaryMessage, Grammar grammar) {
        if (grammar != null) {
            binaryMessage.append(true);
            binaryMessage.append(grammar.grammarType);
            binaryMessage.append(grammar.commandHierarchy);
            binaryMessage.append(grammar.publicGrammar);
            this.writeStringArray(binaryMessage, grammar.listData);
            this.writeLongArray(binaryMessage, grammar.listIdData);
            binaryMessage.append(grammar.listSourceId);
            binaryMessage.append(grammar.grammarId);
            this.writeString(binaryMessage, grammar.grammarText);
            binaryMessage.append(grammar.nBestGraphemicGroupIndex);
            binaryMessage.append(grammar.nBestListID);
        } else {
            binaryMessage.append(false);
        }
    }

    private void writeGrammarInfo(BinaryMessage binaryMessage, GrammarInfo grammarInfo) {
        if (grammarInfo != null) {
            binaryMessage.append(true);
            binaryMessage.append(grammarInfo.id);
            binaryMessage.append(grammarInfo.commandHieratchy);
        } else {
            binaryMessage.append(false);
        }
    }

    private void writeGrammarArray(BinaryMessage binaryMessage, Grammar[] grammarArray) {
        if (grammarArray != null) {
            binaryMessage.append(true);
            binaryMessage.append(grammarArray.length);
            for (int i2 = 0; i2 < grammarArray.length; ++i2) {
                this.writeGrammar(binaryMessage, grammarArray[i2]);
            }
        } else {
            binaryMessage.append(false);
        }
    }

    private void writeGrammarInfoArray(BinaryMessage binaryMessage, GrammarInfo[] grammarInfoArray) {
        if (grammarInfoArray != null) {
            binaryMessage.append(true);
            binaryMessage.append(grammarInfoArray.length);
            for (int i2 = 0; i2 < grammarInfoArray.length; ++i2) {
                this.writeGrammarInfo(binaryMessage, grammarInfoArray[i2]);
            }
        } else {
            binaryMessage.append(false);
        }
    }

    private void writeNBestSlot(BinaryMessage binaryMessage, NBestSlot nBestSlot) {
        if (nBestSlot != null) {
            binaryMessage.append(true);
            binaryMessage.append(nBestSlot.id);
            binaryMessage.append(nBestSlot.index);
            binaryMessage.append(nBestSlot.objectId);
            this.writeString(binaryMessage, nBestSlot.objectStringId);
            this.writeString(binaryMessage, nBestSlot.recognizedString);
        } else {
            binaryMessage.append(false);
        }
    }

    private void writeNBestListEntry(BinaryMessage binaryMessage, NBestListEntry nBestListEntry) {
        if (nBestListEntry != null) {
            binaryMessage.append(true);
            binaryMessage.append(nBestListEntry.commandHierarchie);
            binaryMessage.append(nBestListEntry.confidence);
            binaryMessage.append(nBestListEntry.grammarId);
            binaryMessage.append(nBestListEntry.grammarType);
            binaryMessage.append(nBestListEntry.graphemicGroupIndex);
            this.writeString(binaryMessage, nBestListEntry.recognizedString);
            this.writeString(binaryMessage, nBestListEntry.recognizedTag);
            this.writeNBestSlotArray(binaryMessage, nBestListEntry.slots);
        } else {
            binaryMessage.append(false);
        }
    }

    private void writeNBestSlotArray(BinaryMessage binaryMessage, NBestSlot[] nBestSlotArray) {
        if (nBestSlotArray != null) {
            binaryMessage.append(true);
            binaryMessage.append(nBestSlotArray.length);
            for (int i2 = 0; i2 < nBestSlotArray.length; ++i2) {
                this.writeNBestSlot(binaryMessage, nBestSlotArray[i2]);
            }
        } else {
            binaryMessage.append(false);
        }
    }

    private void writeGraphemicGroup(BinaryMessage binaryMessage, GraphemicGroup graphemicGroup) {
        if (graphemicGroup != null) {
            binaryMessage.append(true);
            this.writeString(binaryMessage, graphemicGroup.groupText);
            binaryMessage.append(graphemicGroup.graphemicGroupSize);
            this.writeNBestSlotArray(binaryMessage, graphemicGroup.slots);
        } else {
            binaryMessage.append(false);
        }
    }

    private void writeGraphemicGroupArray(BinaryMessage binaryMessage, GraphemicGroup[] graphemicGroupArray) {
        if (graphemicGroupArray != null) {
            binaryMessage.append(true);
            binaryMessage.append(graphemicGroupArray.length);
            for (int i2 = 0; i2 < graphemicGroupArray.length; ++i2) {
                this.writeGraphemicGroup(binaryMessage, graphemicGroupArray[i2]);
            }
        } else {
            binaryMessage.append(false);
        }
    }

    private void writeNbestListEntryArray(BinaryMessage binaryMessage, NBestListEntry[] nBestListEntryArray) {
        if (nBestListEntryArray != null) {
            binaryMessage.append(true);
            binaryMessage.append(nBestListEntryArray.length);
            for (int i2 = 0; i2 < nBestListEntryArray.length; ++i2) {
                this.writeNBestListEntry(binaryMessage, nBestListEntryArray[i2]);
            }
        } else {
            binaryMessage.append(false);
        }
    }

    private void writeNBestList(BinaryMessage binaryMessage, NBestList nBestList) {
        if (nBestList != null) {
            binaryMessage.append(true);
            this.writeGraphemicGroupArray(binaryMessage, nBestList.graphemicGroups);
            this.writeNbestListEntryArray(binaryMessage, nBestList.entries);
            binaryMessage.append(nBestList.nBestListID);
        } else {
            binaryMessage.append(false);
        }
    }

    private void writeDynamicTTSPromptPart(BinaryMessage binaryMessage, DynamicTTSPromptPart dynamicTTSPromptPart) {
        if (dynamicTTSPromptPart != null) {
            binaryMessage.append(true);
            this.writeString(binaryMessage, dynamicTTSPromptPart.key);
            this.writeString(binaryMessage, dynamicTTSPromptPart.value);
            this.writeString(binaryMessage, dynamicTTSPromptPart.alternativeText);
        } else {
            binaryMessage.append(false);
        }
    }

    private void writeIntArray(BinaryMessage binaryMessage, int[] nArray) {
        if (nArray != null) {
            binaryMessage.append(true);
            binaryMessage.append(nArray.length);
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                binaryMessage.append(nArray[i2]);
            }
        } else {
            binaryMessage.append(false);
        }
    }

    private void writeDynamicPromptPartArray(BinaryMessage binaryMessage, DynamicTTSPromptPart[] dynamicTTSPromptPartArray) {
        if (dynamicTTSPromptPartArray != null) {
            binaryMessage.append(true);
            binaryMessage.append(dynamicTTSPromptPartArray.length);
            for (int i2 = 0; i2 < dynamicTTSPromptPartArray.length; ++i2) {
                this.writeDynamicTTSPromptPart(binaryMessage, dynamicTTSPromptPartArray[i2]);
            }
        } else {
            binaryMessage.append(false);
        }
    }

    private void writeTTSPrompt(BinaryMessage binaryMessage, TTSPrompt tTSPrompt) {
        if (tTSPrompt != null) {
            binaryMessage.append(true);
            binaryMessage.append(tTSPrompt.promptType);
            this.writeStringArray(binaryMessage, tTSPrompt.promptPartTexts);
            this.writeIntArray(binaryMessage, tTSPrompt.promptPartIds);
            this.writeDynamicPromptPartArray(binaryMessage, tTSPrompt.dynamicParts);
        } else {
            binaryMessage.append(false);
        }
    }

    @Override
    protected byte getCodecVersion() {
        return -8;
    }

    @Override
    protected short getConfigurationMessageType() {
        return 57;
    }

    @Override
    protected short getMessageType() {
        return 274;
    }
}

