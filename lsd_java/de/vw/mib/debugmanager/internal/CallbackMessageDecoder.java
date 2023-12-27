/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.debugmanager.internal.CallbackMessageDecoder$CallbackDecoderListener;

interface CallbackMessageDecoder {
    default public void decodeCallbackMessage(byte[] byArray) {
    }

    default public void register(CallbackMessageDecoder$CallbackDecoderListener callbackMessageDecoder$CallbackDecoderListener) {
    }
}

