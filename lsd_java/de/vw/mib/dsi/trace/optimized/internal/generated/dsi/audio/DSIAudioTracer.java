/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.audio;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.audio.AmplifierCapabilities;

public final class DSIAudioTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_AMPLIFIERCAPABILITIES;
    static /* synthetic */ Class class$org$dsi$ifc$audio$AmplifierCapabilities;

    public DSIAudioTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$audio$AmplifierCapabilities == null ? (class$org$dsi$ifc$audio$AmplifierCapabilities = DSIAudioTracer.class$("org.dsi.ifc.audio.AmplifierCapabilities")) : class$org$dsi$ifc$audio$AmplifierCapabilities, 1);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceAmplifierCapabilities(printWriter, (AmplifierCapabilities)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceAmplifierCapabilities(PrintWriter printWriter, AmplifierCapabilities amplifierCapabilities) {
        if (amplifierCapabilities == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(amplifierCapabilities.amplifier);
        printWriter.print(amplifierCapabilities.balance);
        printWriter.print(amplifierCapabilities.fader);
        printWriter.print(amplifierCapabilities.subwoofer);
        printWriter.print(amplifierCapabilities.equalizer);
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

