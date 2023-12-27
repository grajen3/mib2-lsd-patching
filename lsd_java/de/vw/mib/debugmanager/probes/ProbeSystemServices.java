/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.probes;

import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServiceListener;
import de.vw.mib.log4mib.BinaryMessage;
import de.vw.mib.log4mib.Logger;

public interface ProbeSystemServices {
    default public Logger getLogger(int n) {
    }

    default public long getTimestamp() {
    }

    default public BinaryMessage createMessage() {
    }

    default public BinaryMessage createConfigurationMessage() {
    }

    default public void registerService(String string, Object object) {
    }

    default public void unregisterService(String string, Object object) {
    }

    default public void registerServiceListener(String string, ProbeSystemServiceListener probeSystemServiceListener) {
    }

    default public void unregisterServiceListener(String string, ProbeSystemServiceListener probeSystemServiceListener) {
    }

    default public Object getService(String string) {
    }

    default public DebugProbeConfiguration getConfiguration() {
    }

    default public AbstractProbeCodec borrowCodec() {
    }

    default public void releaseCodec(AbstractProbeCodec abstractProbeCodec) {
    }
}

