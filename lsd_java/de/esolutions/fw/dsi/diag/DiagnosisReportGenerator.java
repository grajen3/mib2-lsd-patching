/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diag;

import de.esolutions.fw.comm.agent.diag.IInfoBase;
import de.esolutions.fw.comm.agent.diag.InfoStream;
import de.esolutions.fw.comm.agent.diag.InfoUtils;
import de.esolutions.fw.dsi.diag.DispatcherInfo;
import de.esolutions.fw.dsi.diag.IAdapterDiagnosis;
import de.esolutions.fw.dsi.diag.IAdapterErrorLog;
import de.esolutions.fw.dsi.diag.IAdapterSnapshot;
import de.esolutions.fw.dsi.diag.ProviderInfo;
import de.esolutions.fw.util.tracing.util.TraceTimeStamp;
import java.io.PrintStream;
import java.util.Vector;

public class DiagnosisReportGenerator {
    private final PrintStream outStream;
    private final boolean brief;

    public DiagnosisReportGenerator(PrintStream printStream, boolean bl) {
        this.outStream = printStream;
        this.brief = bl;
    }

    public void generateFullReport(IAdapterDiagnosis iAdapterDiagnosis) {
        InfoStream infoStream = new InfoStream(this.outStream, this.brief);
        infoStream.begin("DSIAdapter Diagnosis ");
        if (iAdapterDiagnosis == null) {
            infoStream.print("No Diagnosis found! ");
            return;
        }
        IAdapterSnapshot iAdapterSnapshot = iAdapterDiagnosis.createSnapshot();
        if (iAdapterSnapshot != null) {
            TraceTimeStamp traceTimeStamp = new TraceTimeStamp(iAdapterSnapshot.getTimeStamp());
            infoStream.begin(new StringBuffer().append("Snapshot @").append(traceTimeStamp.toUTCTimeString(true)).toString());
            IInfoBase[] iInfoBaseArray = iAdapterSnapshot.getAllProviders();
            if (iInfoBaseArray != null && iInfoBaseArray.length > 0) {
                InfoUtils.printInfos(iInfoBaseArray, infoStream);
            } else {
                infoStream.print("No Providers found!");
            }
            IInfoBase[] iInfoBaseArray2 = iAdapterSnapshot.getAllDispatchers();
            if (iInfoBaseArray2 != null && iInfoBaseArray2.length > 0) {
                InfoUtils.printInfos(iInfoBaseArray2, infoStream);
            } else {
                infoStream.print("No Dispatchers found!");
            }
            infoStream.end();
        }
        infoStream.end();
        this.generateErrorLog(iAdapterDiagnosis.getErrorLog(), infoStream);
    }

    public void generateProvidersReport(IAdapterDiagnosis iAdapterDiagnosis, int[] nArray) {
        InfoStream infoStream = new InfoStream(this.outStream, this.brief);
        if (iAdapterDiagnosis == null) {
            infoStream.print("No Diagnosis found! ");
            return;
        }
        IAdapterSnapshot iAdapterSnapshot = iAdapterDiagnosis.createSnapshot();
        if (iAdapterSnapshot != null) {
            IInfoBase[] iInfoBaseArray = iAdapterSnapshot.getAllProviders();
            if (nArray.length > 0) {
                iInfoBaseArray = this.getProviders(nArray, (ProviderInfo[])iInfoBaseArray);
            }
            if (iInfoBaseArray != null && iInfoBaseArray.length > 0) {
                InfoUtils.printInfos(iInfoBaseArray, infoStream);
            } else {
                infoStream.print("No Providers found!");
            }
        }
    }

    private ProviderInfo[] getProviders(int[] nArray, ProviderInfo[] providerInfoArray) {
        int n;
        Vector vector = new Vector();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            n = nArray[i2];
            if (n < 0 || n > providerInfoArray.length) continue;
            vector.add(providerInfoArray[n]);
        }
        ProviderInfo[] providerInfoArray2 = new ProviderInfo[vector.size()];
        for (n = 0; n < providerInfoArray2.length; ++n) {
            providerInfoArray2[n] = (ProviderInfo)vector.get(n);
        }
        return providerInfoArray2;
    }

    public void generateDispatchersReport(IAdapterDiagnosis iAdapterDiagnosis, int[] nArray) {
        InfoStream infoStream = new InfoStream(this.outStream, this.brief);
        if (iAdapterDiagnosis == null) {
            infoStream.print("No Diagnosis found! ");
            return;
        }
        IAdapterSnapshot iAdapterSnapshot = iAdapterDiagnosis.createSnapshot();
        if (iAdapterSnapshot != null) {
            IInfoBase[] iInfoBaseArray = iAdapterSnapshot.getAllDispatchers();
            if (iInfoBaseArray != null && iInfoBaseArray.length > 0) {
                InfoUtils.printInfos(iInfoBaseArray, infoStream);
            } else {
                infoStream.print("No Dispatchers found!");
            }
        }
    }

    public void generateDispatcherReport(IAdapterDiagnosis iAdapterDiagnosis, int[] nArray) {
        InfoStream infoStream = new InfoStream(this.outStream, this.brief);
        if (iAdapterDiagnosis == null) {
            infoStream.print("No Diagnosis found! ");
            return;
        }
        IAdapterSnapshot iAdapterSnapshot = iAdapterDiagnosis.createSnapshot();
        if (iAdapterSnapshot != null) {
            IInfoBase[] iInfoBaseArray = iAdapterSnapshot.getAllDispatchers();
            if (nArray.length > 0) {
                iInfoBaseArray = this.getDispatchers(nArray, (DispatcherInfo[])iInfoBaseArray);
            }
            if (iInfoBaseArray != null && iInfoBaseArray.length > 0) {
                InfoUtils.printInfos(iInfoBaseArray, infoStream);
            } else {
                infoStream.print("No Dispatchers found!");
            }
        }
    }

    private DispatcherInfo[] getDispatchers(int[] nArray, DispatcherInfo[] dispatcherInfoArray) {
        int n;
        Vector vector = new Vector();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            n = nArray[i2];
            if (n < 0 || n > dispatcherInfoArray.length) continue;
            vector.add(dispatcherInfoArray[n]);
        }
        DispatcherInfo[] dispatcherInfoArray2 = new DispatcherInfo[vector.size()];
        for (n = 0; n < dispatcherInfoArray2.length; ++n) {
            dispatcherInfoArray2[n] = (DispatcherInfo)vector.get(n);
        }
        return dispatcherInfoArray2;
    }

    public void generateErrorLog(IAdapterDiagnosis iAdapterDiagnosis) {
        InfoStream infoStream = new InfoStream(this.outStream, this.brief);
        infoStream.begin("DSIAdapter Diagnosis !!");
        this.generateErrorLog(iAdapterDiagnosis.getErrorLog(), infoStream);
    }

    private void generateErrorLog(IAdapterErrorLog iAdapterErrorLog, InfoStream infoStream) {
        if (iAdapterErrorLog != null) {
            IInfoBase[] iInfoBaseArray;
            infoStream.begin("ErrorLog");
            IInfoBase[] iInfoBaseArray2 = iAdapterErrorLog.getDispatcherErrors();
            if (iInfoBaseArray2 != null) {
                InfoUtils.printInfos(iInfoBaseArray2, infoStream);
            } else {
                infoStream.print("No dispatchers errors reported.");
            }
            int n = iAdapterErrorLog.getNumDroppedDispatcherErrors();
            if (n > 0) {
                infoStream.print(new StringBuffer().append("Dispatcher errors dropped: ").append(n).toString());
            }
            if ((iInfoBaseArray = iAdapterErrorLog.getProviderErrors()) != null) {
                InfoUtils.printInfos(iInfoBaseArray, infoStream);
            } else {
                infoStream.print("No provider errors reported.");
            }
            n = iAdapterErrorLog.getNumDroppedProviderErrors();
            if (n > 0) {
                infoStream.print(new StringBuffer().append("Provider errors dropped: ").append(n).toString());
            }
            infoStream.end();
        }
    }
}

