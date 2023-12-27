/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio;

import de.vw.mib.asl.framework.internal.framework.dsi.DSIInterceptor;
import org.dsi.ifc.diagnose.DSIDiagnoseSystemListener;
import org.dsi.ifc.navservicesapi.DSINavServicesAPIListener;
import org.dsi.ifc.navservicesapi.TunerData;

public class TestInterceptor
extends DSIInterceptor {
    static /* synthetic */ Class class$org$dsi$ifc$navservicesapi$DSINavServicesAPIListener;
    static /* synthetic */ Class class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener;

    public void updateReceivableStations() {
        TunerData[] tunerDataArray = new TunerData[]{new TunerData("Name80000", 0), new TunerData("Name80100", 0), new TunerData("Name80200", 0), new TunerData("Name80300", 0)};
        this.updateReceivableStations(tunerDataArray, 1);
    }

    public void updateReceivableStations(TunerData[] tunerDataArray, int n) {
        DSINavServicesAPIListener dSINavServicesAPIListener = (DSINavServicesAPIListener)this.getNotificationListener(class$org$dsi$ifc$navservicesapi$DSINavServicesAPIListener == null ? (class$org$dsi$ifc$navservicesapi$DSINavServicesAPIListener = TestInterceptor.class$("org.dsi.ifc.navservicesapi.DSINavServicesAPIListener")) : class$org$dsi$ifc$navservicesapi$DSINavServicesAPIListener);
        dSINavServicesAPIListener.updateReceivableStations(tunerDataArray, n);
    }

    public void requestActuatorTest(int n, int n2, int n3, int n4, int[] nArray) {
        DSIDiagnoseSystemListener dSIDiagnoseSystemListener = (DSIDiagnoseSystemListener)this.getResponseListener(class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener == null ? (class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener = TestInterceptor.class$("org.dsi.ifc.diagnose.DSIDiagnoseSystemListener")) : class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener);
        dSIDiagnoseSystemListener.requestActuatorTest(n, n2, n3, n4, nArray);
    }

    public void requestRoutine(int n, int n2, int n3, int[] nArray) {
        DSIDiagnoseSystemListener dSIDiagnoseSystemListener = (DSIDiagnoseSystemListener)this.getResponseListener(class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener == null ? (class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener = TestInterceptor.class$("org.dsi.ifc.diagnose.DSIDiagnoseSystemListener")) : class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener);
        dSIDiagnoseSystemListener.requestRoutine(n, n2, n3, nArray);
    }

    public void updateDiagnosticValueChangedGeneric(int n, long l, int n2) {
        DSIDiagnoseSystemListener dSIDiagnoseSystemListener = (DSIDiagnoseSystemListener)this.getNotificationListener(class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener == null ? (class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener = TestInterceptor.class$("org.dsi.ifc.diagnose.DSIDiagnoseSystemListener")) : class$org$dsi$ifc$diagnose$DSIDiagnoseSystemListener);
        dSIDiagnoseSystemListener.updateDiagnosticValueChanged(n, l, n2);
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

