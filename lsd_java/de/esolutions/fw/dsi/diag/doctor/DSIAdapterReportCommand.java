/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diag.doctor;

import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.dsi.admin.DSIAdmin;
import de.esolutions.fw.dsi.diag.DiagnosisReportGenerator;
import de.esolutions.fw.dsi.diag.doctor.AbstractDSIAdapterDiagnosisCommand;
import java.io.PrintStream;

public class DSIAdapterReportCommand
extends AbstractDSIAdapterDiagnosisCommand {
    public DSIAdapterReportCommand(DSIAdmin dSIAdmin) {
        super(dSIAdmin);
    }

    @Override
    public String[] getNames() {
        return new String[]{"dsi_diagnosis_report", "dsir"};
    }

    @Override
    public String getDescription() {
        return "generate a dsiadapter diagnosis report";
    }

    @Override
    protected void handleWithDSIAdapterDiagnosis(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
        DiagnosisReportGenerator diagnosisReportGenerator = new DiagnosisReportGenerator(printStream, false);
        diagnosisReportGenerator.generateFullReport(this.getDiagnosis());
    }
}

