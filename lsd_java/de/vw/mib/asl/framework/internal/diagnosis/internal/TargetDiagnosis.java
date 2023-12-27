/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.internal;

import de.vw.mib.asl.framework.api.diagnosis.AdaptionApi;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.internal.diagnosis.DiagnosisDataProvider;
import de.vw.mib.asl.framework.internal.diagnosis.EventWrappingAdaptionResponse;
import de.vw.mib.asl.framework.internal.diagnosis.api.impl.DiagnosisServicesImpl;
import de.vw.mib.asl.framework.internal.diagnosis.api.impl.DiagnosisServicesProvider;
import de.vw.mib.asl.framework.internal.diagnosis.config.DiagnosisMetaInformationProvider;
import de.vw.mib.asl.framework.internal.diagnosis.config.PropertyFileManager;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.ClassWarehouse;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.Engine;
import de.vw.mib.asl.framework.internal.diagnosis.diagmode.DiagnosisServices;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public final class TargetDiagnosis
extends AbstractTarget
implements AdaptionApi,
DiagnosisMetaInformationProvider {
    private static final String LOGGING_DELIM;
    private static final int KEY_SLOT_INDEX_COUNT;
    public static final int EV_DIAG_MODE_VALUE_CHANGED;
    private final PropertyFileManager mPropertyFileManager;
    private ClassWarehouse mClassWarehouse;
    private DiagnosisDataProvider diagnosisDataProvider;
    private final int[] mConfigArray = new int[]{10, 1308643072, 1409304576, 1090539008, 0x44004C00, 0x45004400, 10, 1459638784, 1325420032, 1191203584, 1409302784, 0x54004500, 9, 1157650432, 1124091136, 0x50005400, 1224756992, 78, 13, 1459638784, 1325420032, 1191203584, 1275088640, 0x54005400, 0x59005000, 69, 8, 1308643072, 1409304064, 1325421824, 0x4E004400, 8, 1308643072, 1593855744, 1459637760, 1157648896, 14, 1426083328, 1258311168, 1325422336, 1308647168, 1409302784, 1375749888, 0x45005400, 15, 1426083328, 1258311168, 1325422336, 1308647168, 1392526592, 1375753728, 1224753920, 69, 13, 1308643072, 1409310464, 0x53005500, 0x50005000, 1325421056, 0x54004500, 68, 15, 1459638784, 1325420032, 1191206656, 1090540032, 1191204096, 1291863296, 1308644352, 83, 6, 1124090112, 1308640000, 1157647360, 5, 1157648896, 1375751936, 82, 18, 1090538496, 1375749376, 0x41004400, 1493196544, 1375749376, 1191201024, 1392530432, 1157648896, 0x45004400, 12, 1660969216, 1912626944, 1711305984, 1845519104, 1946183936, 1862299136, 16, 1660969216, 1912626944, 1711305984, 1845519104, 1946183936, 1862299136, 1593860608, 1627418624, 16, 1660969216, 1912626944, 1711305984, 1845519104, 1946183936, 1862299136, 1593860864, 1627418112, 10, 1627415552, 1627418624, 1946181888, 1946183936, 1862299136, 23, 1979738368, 1912632320, 1962959104, 1811963648, 1660969216, 1828742400, 1912627456, 1593864192, 1862300416, 1761637376, 1761636096, 110, 24, 1677746432, 1929406464, 1644195584, 1627419136, 1677745920, 1677748480, 0x73007000, 1811964160, 2030067456, 1660972800, 0x6E006600, 1761634048, 27, 1744858368, 1761632000, 1711305984, 1845519104, 1946183936, 1862299136, 1593860608, 1811967744, 1660971776, 1761635840, 1728077568, 1946181888, 1644194816, 101, 0, 101, 0, 103, 0, 102, 0, 100, 0, 104, 0, 106, 0, 105, 22, 128, 128, 164, 2, 172, 6, 128, 128, 166, 3, 162, 1, 170, 5, 128, 128, 160, 0, 168, 4, 128, 128, 1, 1131879168, 6, 1660972800, 1677748480, 1845520128, 0, 1, 4, 203, 7, 128, 128, 14, 1761633280, 1694526976, 1946183936, 0x66006900, 1660969216, 1946183936, 1862299136, 0, 400, 4, 218, 8, 128, 128, 17, 1761635840, 0x66006F00, 1912630528, 1627419648, 1761636096, 1845518080, 1879074048, 1912632064, 111, 0, 21, 4, 235, 9, 128, 128, 9, 0x73007000, 0x65006500, 1677745920, 1660974336, 116, 9, 1811964160, 1845520128, 1962959104, 1728079104, 115, 12, 1711305984, 1912632320, 1744856320, 1912626944, 1677746432, 1946181888, 7, 1694524160, 1862295296, 1744858368, 105, 20, 1761635840, 1593860864, 1627419136, 1593860864, 1862298880, 1828746496, 1845520640, 1660969216, 1946183936, 1862299136, 0, 200, 0, 201, 0, 202, 0, 205, 0, 209, 14, 128, 128, 283, 13, 277, 10, 281, 12, 285, 14, 128, 128, 279, 11, 11, 1912628480, 1728080128, 1862299136, 1593860864, 1862296576, 101, 0, 100664512, 4, 309, 15, 128, 128, 14, -536825343, 174, 906042371, 287, -687821311, 205, 553765890, 220, 0, 311, 128, 128, -1945800920, 237, 34, 0, 88, 13, 261, 9, 225, 5, 132, 1, 95, 14, 266, 10, 242, 6, 145, 2, 104, 15, 302, 11, 248, 7, 199, 3, 113, 128, 128, 12, 254, 8, 210, 4, 119, 4, 7, 197, 128, 128, 34, 128, 128, 13, 78, 9, 53, 5, 26, 1, 0, 128, 128, 10, 61, 6, 31, 2, 6, 128, 128, 11, 70, 7, 36, 3, 12, 128, 128, 12, 74, 8, 44, 4, 18, 316, 331, 366, 371, 406};
    private final Engine mEngine = new Engine(this.mConfigArray);
    private EventFactory eventFactory;
    private EventDispatcherHSM eventDispatcher;

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    public TargetDiagnosis(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.mPropertyFileManager = PropertyFileManager.fromFile();
        if (this.mPropertyFileManager != null) {
            this.info().append("DIAGNOSTIC [TargetDiagnosis] ").append("diagApi.properties has been read!").log();
        } else {
            this.info().append("DIAGNOSTIC [TargetDiagnosis] ").append("diagApi.properties has not been read!");
        }
        this.mClassWarehouse = null;
        genericEvents.getEventDispatcher().registerTarget(7300, this, "hsmtask");
        DiagnosisServices diagnosisServices = DiagnosisServicesProvider.getServices();
        this.eventFactory = diagnosisServices.getEventFactory();
        this.eventDispatcher = diagnosisServices.getEventDispatcher();
        this.diagnosisDataProvider = new DiagnosisDataProvider(diagnosisServices, this, this.getClassWarehouse(), this.mPropertyFileManager);
    }

    private ClassWarehouse getClassWarehouse() {
        if (this.mClassWarehouse == null) {
            String string = ServiceManager.configManagerDiag.getDiagClassName();
            this.mClassWarehouse = (ClassWarehouse)this.newInstance(string);
        }
        return this.mClassWarehouse;
    }

    private int getContext(int n, long l) {
        int n2 = this.mEngine.getInt();
        n2 = this.mEngine.getInt(n2);
        n2 = this.mEngine.getInt(n2, n);
        n2 = this.mEngine.getInt(n2, l);
        return n2;
    }

    private String getString(int n) {
        int n2 = this.mEngine.getInt();
        n2 = this.mEngine.getInt(n2 + 1);
        n2 = this.mEngine.getInt(n2, n);
        return this.mEngine.getString(n2);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.processPowerOn();
                break;
            }
            case 100003: {
                this.processDiagValueChangedEvent(eventGeneric);
                break;
            }
        }
    }

    private void processPowerOn() {
        ServiceManager.adaptionApi = this;
        ((DiagnosisServicesImpl)DiagnosisServicesProvider.getServices()).setAdaptionApi(this);
    }

    private void processDiagValueChangedEvent(EventGeneric eventGeneric) {
        this.diagnosisDataProvider.clearCache();
        int n = eventGeneric.getInt(2);
        long l = eventGeneric.getLong(3);
        int n2 = this.getContext(n, l);
        eventGeneric.setResult(0);
        if (n2 >= 0 && n2 < 16) {
            EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(-2075192832);
            eventGeneric2.setInt(2, n);
            eventGeneric2.setLong(3, l);
            this.getEventDispatcher().send(eventGeneric2);
        }
    }

    @Override
    public void requestConfigManagerPersCarFuncAdap(int n, int n2) {
        this.requestCarFuncAdap(new EventWrappingAdaptionResponse(-536825343, 0, n, n2, this.eventFactory, this.eventDispatcher));
    }

    @Override
    public void requestCarFuncAdap(AdaptionResponse adaptionResponse) {
        this.diagnosisDataProvider.requestData(-536825343, 0, adaptionResponse);
    }

    @Override
    public void requestConfigManagerPersCarFuncListBap(int n, int n2) {
        this.requestCarFuncListBap(new EventWrappingAdaptionResponse(-536825343, 0, n, n2, this.eventFactory, this.eventDispatcher));
    }

    @Override
    public void requestCarFuncListBap(AdaptionResponse adaptionResponse) {
        this.diagnosisDataProvider.requestData(-536825343, 0, adaptionResponse);
    }

    @Override
    public void requestConfigManagerPersCarFuncListCan(int n, int n2) {
        this.requestCarFuncListCan(new EventWrappingAdaptionResponse(-536825343, 0, n, n2, this.eventFactory, this.eventDispatcher));
    }

    @Override
    public void requestCarFuncListCan(AdaptionResponse adaptionResponse) {
        this.diagnosisDataProvider.requestData(-536825343, 0, adaptionResponse);
    }

    @Override
    public void requestConfigManagerPersCoding(int n, int n2) {
        this.requestCoding(new EventWrappingAdaptionResponse(-687821311, 1L, n, n2, this.eventFactory, this.eventDispatcher));
    }

    @Override
    public void requestCoding(AdaptionResponse adaptionResponse) {
        this.diagnosisDataProvider.requestData(-687821311, 1L, adaptionResponse);
    }

    @Override
    public void requestConfigManagerVirtualCamPos(int n, int n2) {
        this.requestVirtualCamPos(new EventWrappingAdaptionResponse(-536825343, 0, n, n2, this.eventFactory, this.eventDispatcher));
    }

    @Override
    public void requestVirtualCamPos(AdaptionResponse adaptionResponse) {
        this.diagnosisDataProvider.requestData(-536825343, 0, adaptionResponse);
    }

    @Override
    public void requestConfigManagerHmiFuncBlockTbl(int n, int n2) {
        this.requestHmiFuncBlockTbl(new EventWrappingAdaptionResponse(-536825343, 0, n, n2, this.eventFactory, this.eventDispatcher));
    }

    @Override
    public void requestHmiFuncBlockTbl(AdaptionResponse adaptionResponse) {
        this.diagnosisDataProvider.requestData(-536825343, 0, adaptionResponse);
    }

    @Override
    public void requestConfigManagerPersAdaptation(int n, int n2) {
        this.requestAdaptation(new EventWrappingAdaptionResponse(-536825343, 0, n, n2, this.eventFactory, this.eventDispatcher));
    }

    @Override
    public void requestAdaptation(AdaptionResponse adaptionResponse) {
        this.diagnosisDataProvider.requestData(-536825343, 0, adaptionResponse);
    }

    @Override
    public void requestAdaptationLate(AdaptionResponse adaptionResponse) {
        this.diagnosisDataProvider.requestData(-536825343, 0, adaptionResponse);
    }

    @Override
    public void requestConfigManagerPersLoadSpeedThreshold(int n, int n2) {
        this.requestLoadSpeedThreshold(new EventWrappingAdaptionResponse(906042371, 0, n, n2, this.eventFactory, this.eventDispatcher));
    }

    @Override
    public void requestLoadSpeedThreshold(AdaptionResponse adaptionResponse) {
        this.diagnosisDataProvider.requestData(906042371, 0, adaptionResponse);
    }

    @Override
    public void requestConfigManagerPersLoadSystemLanguages(int n, int n2) {
        this.requestLoadSystemLanguages(new EventWrappingAdaptionResponse(906042371, 0, n, n2, this.eventFactory, this.eventDispatcher));
    }

    @Override
    public void requestLoadSystemLanguages(AdaptionResponse adaptionResponse) {
        this.diagnosisDataProvider.requestData(906042371, 0, adaptionResponse);
    }

    @Override
    public void requestConfigManagerPersLoadFurtherData(int n, int n2) {
        this.requestLoadFurtherData(new EventWrappingAdaptionResponse(906042371, 0, n, n2, this.eventFactory, this.eventDispatcher));
    }

    @Override
    public void requestLoadFurtherData(AdaptionResponse adaptionResponse) {
        this.diagnosisDataProvider.requestData(906042371, 0, adaptionResponse);
    }

    @Override
    public void requestConfigManagerPersLoadEcoHmi(int n, int n2) {
        this.requestEcoHmi(new EventWrappingAdaptionResponse(906042371, 0, n, n2, this.eventFactory, this.eventDispatcher));
    }

    @Override
    public void requestEcoHmi(AdaptionResponse adaptionResponse) {
        this.diagnosisDataProvider.requestData(906042371, 0, adaptionResponse);
    }

    @Override
    public void requestConfigManagerPersLoadInCarCommunication(int n, int n2) {
        this.requestInCarCommunication(new EventWrappingAdaptionResponse(906042371, 0, n, n2, this.eventFactory, this.eventDispatcher));
    }

    @Override
    public void requestInCarCommunication(AdaptionResponse adaptionResponse) {
        this.diagnosisDataProvider.requestData(906042371, 0, adaptionResponse);
    }

    @Override
    public void requestConfigManagerPersLoadDashboardDisplayConfig(int n, int n2) {
        this.requestDashboardDisplayConfig(new EventWrappingAdaptionResponse(-536825343, 0, n, n2, this.eventFactory, this.eventDispatcher));
    }

    @Override
    public void requestDashboardDisplayConfig(AdaptionResponse adaptionResponse) {
        this.diagnosisDataProvider.requestData(-536825343, 0, adaptionResponse);
    }

    @Override
    public void requestConfigManagerPersIdentification(int n, int n2) {
        this.requestIdentification(new EventWrappingAdaptionResponse(553765890, 0, n, n2, this.eventFactory, this.eventDispatcher));
    }

    @Override
    public void requestIdentification(AdaptionResponse adaptionResponse) {
        this.diagnosisDataProvider.requestData(553765890, 0, adaptionResponse);
    }

    @Override
    public void requestConfigManagerPersInformation(int n, int n2) {
        this.requestInformation(new EventWrappingAdaptionResponse(-1945800920, 0, n, n2, this.eventFactory, this.eventDispatcher));
    }

    @Override
    public void requestInformation(AdaptionResponse adaptionResponse) {
        this.diagnosisDataProvider.requestData(-1945800920, 0, adaptionResponse);
    }

    @Override
    public void requestConfigManagerPersRegionCode(int n, int n2) {
        this.requestRegionCode(new EventWrappingAdaptionResponse(0, 0, n, n2, this.eventFactory, this.eventDispatcher));
    }

    @Override
    public void requestRegionCode(AdaptionResponse adaptionResponse) {
        this.diagnosisDataProvider.requestData(0, 0, adaptionResponse);
    }

    @Override
    public boolean checkIsValidDiagnosisData(int n, long l) {
        int n2 = this.getContext(n, l);
        return n2 >= 0 && n2 < 16;
    }

    @Override
    public String retrieveName(int n, long l) {
        if (!this.checkIsValidDiagnosisData(n, l)) {
            throw new IllegalArgumentException(new StringBuffer().append("No valid diagnosis data set: Namespace = ").append(n).append(", Key = ").append(l).toString());
        }
        int n2 = this.getContext(n, l);
        return this.getString(n2);
    }

    private Object newInstance(String string) {
        try {
            Class clazz = Class.forName(string);
            try {
                Object object = clazz.newInstance();
                return object;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new RuntimeException("Couldn't instantiate the given class", illegalArgumentException);
            }
            catch (InstantiationException instantiationException) {
                throw new RuntimeException("Couldn't instantiate the given class", instantiationException);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new RuntimeException("Couldn't instantiate the given class", illegalAccessException);
            }
            catch (SecurityException securityException) {
                throw new RuntimeException("Couldn't find the right constructor for the given class", securityException);
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException("Couldn't find the given class", classNotFoundException);
        }
    }
}

