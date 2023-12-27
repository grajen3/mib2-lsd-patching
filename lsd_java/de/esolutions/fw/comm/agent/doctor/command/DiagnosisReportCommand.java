/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.doctor.command;

import de.esolutions.fw.comm.agent.diag.DiagnosisReportGenerator;
import de.esolutions.fw.comm.agent.doctor.DoctorShell;
import de.esolutions.fw.comm.agent.doctor.command.AbstractAgentDiagnosisCommand;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DiagnosisReportCommand
extends AbstractAgentDiagnosisCommand {
    @Override
    public String[] getNames() {
        return new String[]{"diagnosis_report", "dr"};
    }

    @Override
    public String getDescription() {
        return "generate a diagnosis report";
    }

    @Override
    public String getUsage() {
        return "['brief'] ['size'] ['zip'] [<output_file>]";
    }

    @Override
    protected void handleWithAgentDiagnosis(DoctorShell doctorShell, String[] stringArray, PrintStream printStream) {
        Object object;
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        String string = null;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            object = stringArray[i2];
            if ("brief".equals(object)) {
                bl = true;
                continue;
            }
            if ("size".equals(object)) {
                bl2 = true;
                continue;
            }
            if ("zip".equals(object)) {
                bl3 = true;
                continue;
            }
            string = object;
        }
        if (bl2 || bl3 || string != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                object = null;
                Object object2 = byteArrayOutputStream;
                if (bl3) {
                    object2 = object = new ZipOutputStream((OutputStream)object2);
                    ((ZipOutputStream)object).putNextEntry(new ZipEntry("DiagnosisReport.txt"));
                }
                long l = System.currentTimeMillis();
                PrintStream printStream2 = new PrintStream((OutputStream)object2);
                DiagnosisReportGenerator diagnosisReportGenerator = new DiagnosisReportGenerator(printStream2, bl);
                diagnosisReportGenerator.generate(this.getDiagnosis());
                long l2 = System.currentTimeMillis();
                long l3 = l2 - l;
                if (object != null) {
                    ((ZipOutputStream)object).closeEntry();
                }
                printStream2.close();
                byte[] byArray = byteArrayOutputStream.toByteArray();
                printStream.println(new StringBuffer().append("report size: generated ").append(byArray.length).append(" bytes in ").append(l3).append(" ms").toString());
                if (string != null) {
                    printStream.println(new StringBuffer().append("writing to '").append(string).append("'").toString());
                    FileOutputStream fileOutputStream = new FileOutputStream(string);
                    fileOutputStream.write(byArray);
                    fileOutputStream.close();
                }
            }
            catch (IOException iOException) {
                printStream.println(new StringBuffer().append("ERROR writing file: ").append(iOException).toString());
            }
        } else {
            DiagnosisReportGenerator diagnosisReportGenerator = new DiagnosisReportGenerator(printStream, bl);
            diagnosisReportGenerator.generate(this.getDiagnosis());
        }
    }
}

