/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem;

import de.vw.mib.asl.api.speechengine.vde.VoiceDestinationEntry;
import de.vw.mib.asl.internal.speechengine.dialogsystem.CommandLoader;
import de.vw.mib.asl.internal.speechengine.dialogsystem.PromptSystem;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialog;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogConfiguration;
import de.vw.mib.asl.internal.speechengine.dialogsystem.nbest.SubItemRequest;

public interface SpeechDialogSystem
extends PromptSystem {
    default public CommandLoader getCommandLoader() {
    }

    default public SpeechDialog createSpeechDialog(SpeechDialogConfiguration speechDialogConfiguration) {
    }

    default public VoiceDestinationEntry getVoiceDestinationEntry() {
    }

    default public SubItemRequest getSubItemRequest() {
    }
}

