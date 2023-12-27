/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.connectedradio;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.connectedradio.RadioStation;
import org.dsi.ifc.connectedradio.RadioStationLogo;
import org.dsi.ifc.connectedradio.RadioStationStream;

public final class DSIConnectedradioTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_RADIOSTATION;
    private static final int ID_RADIOSTATIONLOGO;
    private static final int ID_RADIOSTATIONSTREAM;
    static /* synthetic */ Class class$org$dsi$ifc$connectedradio$RadioStation;
    static /* synthetic */ Class class$org$dsi$ifc$connectedradio$RadioStationLogo;
    static /* synthetic */ Class class$org$dsi$ifc$connectedradio$RadioStationStream;

    public DSIConnectedradioTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$connectedradio$RadioStation == null ? (class$org$dsi$ifc$connectedradio$RadioStation = DSIConnectedradioTracer.class$("org.dsi.ifc.connectedradio.RadioStation")) : class$org$dsi$ifc$connectedradio$RadioStation, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$connectedradio$RadioStationLogo == null ? (class$org$dsi$ifc$connectedradio$RadioStationLogo = DSIConnectedradioTracer.class$("org.dsi.ifc.connectedradio.RadioStationLogo")) : class$org$dsi$ifc$connectedradio$RadioStationLogo, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$connectedradio$RadioStationStream == null ? (class$org$dsi$ifc$connectedradio$RadioStationStream = DSIConnectedradioTracer.class$("org.dsi.ifc.connectedradio.RadioStationStream")) : class$org$dsi$ifc$connectedradio$RadioStationStream, 3);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceRadioStation(printWriter, (RadioStation)object);
                break;
            }
            case 2: {
                this.traceRadioStationLogo(printWriter, (RadioStationLogo)object);
                break;
            }
            case 3: {
                this.traceRadioStationStream(printWriter, (RadioStationStream)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceRadioStation(PrintWriter printWriter, RadioStation radioStation) {
        int n;
        int n2;
        if (radioStation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(radioStation.id);
        printWriter.print(radioStation.shortName);
        printWriter.print(radioStation.mediumName);
        printWriter.print(radioStation.longName);
        printWriter.print(radioStation.title);
        printWriter.print(radioStation.description);
        if (radioStation.genres == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = radioStation.genres.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(radioStation.genres[n]);
            }
        }
        printWriter.print(radioStation.pi);
        printWriter.print(radioStation.frequency);
        printWriter.print(radioStation.eid);
        printWriter.print(radioStation.sid);
        printWriter.print(radioStation.scids);
        printWriter.print(radioStation.isoCountryCode);
        printWriter.print(radioStation.ecc);
        printWriter.print(radioStation.gcc);
        printWriter.print(radioStation.country);
        printWriter.print(radioStation.broadcastCountryCode);
        printWriter.print(radioStation.radioVISPort);
        printWriter.print(radioStation.radioVISUrl);
        printWriter.print(radioStation.radioVISText);
        this.trace(printWriter, radioStation.radioVISCurrentImage);
        if (radioStation.streams == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = radioStation.streams.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, radioStation.streams[n]);
            }
        }
        if (radioStation.logos == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = radioStation.logos.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, radioStation.logos[n]);
            }
        }
    }

    private void traceRadioStationLogo(PrintWriter printWriter, RadioStationLogo radioStationLogo) {
        if (radioStationLogo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(radioStationLogo.width);
        printWriter.print(radioStationLogo.height);
        this.trace(printWriter, radioStationLogo.pathToFile);
    }

    private void traceRadioStationStream(PrintWriter printWriter, RadioStationStream radioStationStream) {
        if (radioStationStream == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(radioStationStream.requestURL);
        printWriter.print(radioStationStream.qualityType);
        printWriter.print(radioStationStream.offset);
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

