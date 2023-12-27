/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.tollcollect;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.tollcollect.TCCardDateInformation;
import org.dsi.ifc.tollcollect.TCCardError;
import org.dsi.ifc.tollcollect.TCHardwareInformation;
import org.dsi.ifc.tollcollect.TCPaymentInfo;
import org.dsi.ifc.tollcollect.TCPaymentInfoDetails;

public final class DSITollCollectTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_TCCARDDATEINFORMATION;
    private static final int ID_TCCARDERROR;
    private static final int ID_TCHARDWAREINFORMATION;
    private static final int ID_TCPAYMENTINFO;
    private static final int ID_TCPAYMENTINFODETAILS;
    static /* synthetic */ Class class$org$dsi$ifc$tollcollect$TCCardDateInformation;
    static /* synthetic */ Class class$org$dsi$ifc$tollcollect$TCCardError;
    static /* synthetic */ Class class$org$dsi$ifc$tollcollect$TCHardwareInformation;
    static /* synthetic */ Class class$org$dsi$ifc$tollcollect$TCPaymentInfo;
    static /* synthetic */ Class class$org$dsi$ifc$tollcollect$TCPaymentInfoDetails;

    public DSITollCollectTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tollcollect$TCCardDateInformation == null ? (class$org$dsi$ifc$tollcollect$TCCardDateInformation = DSITollCollectTracer.class$("org.dsi.ifc.tollcollect.TCCardDateInformation")) : class$org$dsi$ifc$tollcollect$TCCardDateInformation, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tollcollect$TCCardError == null ? (class$org$dsi$ifc$tollcollect$TCCardError = DSITollCollectTracer.class$("org.dsi.ifc.tollcollect.TCCardError")) : class$org$dsi$ifc$tollcollect$TCCardError, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tollcollect$TCHardwareInformation == null ? (class$org$dsi$ifc$tollcollect$TCHardwareInformation = DSITollCollectTracer.class$("org.dsi.ifc.tollcollect.TCHardwareInformation")) : class$org$dsi$ifc$tollcollect$TCHardwareInformation, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tollcollect$TCPaymentInfo == null ? (class$org$dsi$ifc$tollcollect$TCPaymentInfo = DSITollCollectTracer.class$("org.dsi.ifc.tollcollect.TCPaymentInfo")) : class$org$dsi$ifc$tollcollect$TCPaymentInfo, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$tollcollect$TCPaymentInfoDetails == null ? (class$org$dsi$ifc$tollcollect$TCPaymentInfoDetails = DSITollCollectTracer.class$("org.dsi.ifc.tollcollect.TCPaymentInfoDetails")) : class$org$dsi$ifc$tollcollect$TCPaymentInfoDetails, 5);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceTCCardDateInformation(printWriter, (TCCardDateInformation)object);
                break;
            }
            case 2: {
                this.traceTCCardError(printWriter, (TCCardError)object);
                break;
            }
            case 3: {
                this.traceTCHardwareInformation(printWriter, (TCHardwareInformation)object);
                break;
            }
            case 4: {
                this.traceTCPaymentInfo(printWriter, (TCPaymentInfo)object);
                break;
            }
            case 5: {
                this.traceTCPaymentInfoDetails(printWriter, (TCPaymentInfoDetails)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceTCCardDateInformation(PrintWriter printWriter, TCCardDateInformation tCCardDateInformation) {
        if (tCCardDateInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, tCCardDateInformation.expirationDate);
        this.trace(printWriter, tCCardDateInformation.issueDate);
    }

    private void traceTCCardError(PrintWriter printWriter, TCCardError tCCardError) {
        if (tCCardError == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tCCardError.cardError);
        printWriter.print(tCCardError.errorCode);
    }

    private void traceTCHardwareInformation(PrintWriter printWriter, TCHardwareInformation tCHardwareInformation) {
        if (tCHardwareInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tCHardwareInformation.key);
        printWriter.print(tCHardwareInformation.value);
    }

    private void traceTCPaymentInfo(PrintWriter printWriter, TCPaymentInfo tCPaymentInfo) {
        if (tCPaymentInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tCPaymentInfo.paymentInfoID);
        this.trace(printWriter, tCPaymentInfo.timeStamp);
        this.trace(printWriter, tCPaymentInfo.tollAmount);
    }

    private void traceTCPaymentInfoDetails(PrintWriter printWriter, TCPaymentInfoDetails tCPaymentInfoDetails) {
        if (tCPaymentInfoDetails == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tCPaymentInfoDetails.entranceMotorwayName);
        printWriter.print(tCPaymentInfoDetails.entranceIC);
        printWriter.print(tCPaymentInfoDetails.exitMotorwayName);
        printWriter.print(tCPaymentInfoDetails.exitIC);
        printWriter.print(tCPaymentInfoDetails.isFlatRate);
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

