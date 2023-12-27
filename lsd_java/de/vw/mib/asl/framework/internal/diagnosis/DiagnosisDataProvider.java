/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis;

import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceAPI;
import de.vw.mib.asl.framework.api.persistence.PersistenceReadCallback;
import de.vw.mib.asl.framework.internal.diagnosis.DiagnosisDataProvider$1;
import de.vw.mib.asl.framework.internal.diagnosis.config.DiagnosisMetaInformationProvider;
import de.vw.mib.asl.framework.internal.diagnosis.config.PropertyFileManager;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.ClassWarehouse;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.Identifier;
import de.vw.mib.asl.framework.internal.diagnosis.diagmode.DiagnosisServices;
import de.vw.mib.collections.ObjectCollection;
import de.vw.mib.collections.ObjectObjectMap;
import de.vw.mib.collections.ObjectObjectMultimap;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.perf.service.PerfService;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DiagnosisDataProvider {
    private final ObjectObjectMultimap mapDiagnosisIdentifier2PendingCallbacks = new ObjectObjectMultimap();
    private final ObjectObjectMap mapDiagnosisIdentifier2CachedData = new ObjectObjectOptHashMap();
    private final Set requestedDiagnosisData = new HashSet();
    private final DiagnosisMetaInformationProvider diagnosisMetaInformationProvider;
    private final ASLPersistenceAPI persistenceApi;
    private final Logger logger;
    private final ClassWarehouse classWarehouse;
    private final PerfService perfService;
    private final PropertyFileManager propertyFileManager;

    public DiagnosisDataProvider(DiagnosisServices diagnosisServices, DiagnosisMetaInformationProvider diagnosisMetaInformationProvider, ClassWarehouse classWarehouse, PropertyFileManager propertyFileManager) {
        this.persistenceApi = diagnosisServices.getAslPersistenceApi();
        this.logger = diagnosisServices.getLogger();
        this.perfService = diagnosisServices.getPerfService();
        this.classWarehouse = classWarehouse;
        this.propertyFileManager = propertyFileManager;
        this.diagnosisMetaInformationProvider = diagnosisMetaInformationProvider;
    }

    public void requestData(int n, long l, AdaptionResponse adaptionResponse) {
        Identifier identifier = new Identifier(n, l);
        if (this.mapDiagnosisIdentifier2CachedData.containsKey(identifier)) {
            Access access = (Access)this.mapDiagnosisIdentifier2CachedData.get(identifier);
            adaptionResponse.onSuccess(access);
        } else if (this.requestedDiagnosisData.contains(identifier)) {
            this.mapDiagnosisIdentifier2PendingCallbacks.put(identifier, adaptionResponse);
        } else if (this.diagnosisMetaInformationProvider.checkIsValidDiagnosisData(n, l)) {
            this.mapDiagnosisIdentifier2PendingCallbacks.put(identifier, adaptionResponse);
            this.requestedDiagnosisData.add(identifier);
            this.persistenceApi.readByteArray(n, l, this.createCallback());
            this.perfService.performanceLogDiagnosis(n, 0);
        } else {
            this.logger.error(16384, new StringBuffer().append("Invalid diagnosis data set was requested (namespace = ").append(n).append(", key = ").append(l).append(")").toString());
            adaptionResponse.onError();
        }
    }

    void onDataRead(int n, long l, int n2, byte[] byArray) {
        this.logResponse(n, l, n2);
        byArray = this.mergeData(n, l, byArray);
        Identifier identifier = new Identifier(n, l);
        Access access = this.classWarehouse.createAccessObject(n, l, byArray);
        this.mapDiagnosisIdentifier2CachedData.put(identifier, access);
        this.repondToPendingRequests(identifier, access);
    }

    private void logResponse(int n, long l, int n2) {
        if (n2 != 0) {
            this.logger.error(16384, new StringBuffer().append("Diagnosis data could not be read (namespace = ").append(n).append(", key = ").append(l).append(", error code = ").append(n2).append("). Will use default values instead.").toString());
        }
        this.perfService.performanceLogDiagnosis(n, 1);
    }

    private byte[] mergeData(int n, long l, byte[] byArray) {
        String string = this.diagnosisMetaInformationProvider.retrieveName(n, l);
        byArray = this.propertyFileManager.merge(string, byArray);
        return byArray;
    }

    private void repondToPendingRequests(Identifier identifier, Access access) {
        ObjectCollection objectCollection = this.mapDiagnosisIdentifier2PendingCallbacks.getAll(identifier);
        Iterator iterator = objectCollection.iterator();
        while (iterator.hasNext()) {
            AdaptionResponse adaptionResponse = (AdaptionResponse)iterator.next();
            adaptionResponse.onSuccess(access);
        }
    }

    private PersistenceReadCallback createCallback() {
        return new DiagnosisDataProvider$1(this);
    }

    public void clearCache() {
        this.mapDiagnosisIdentifier2PendingCallbacks.clear();
        this.mapDiagnosisIdentifier2CachedData.clear();
        this.requestedDiagnosisData.clear();
    }
}

