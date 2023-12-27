/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.diag;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.impl.ASLListItemDummyCacheImpl;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.system.AslTargetSystemFeaturesAndCoding;
import de.vw.mib.asl.internal.system.SystemAccessor;
import de.vw.mib.asl.internal.system.diag.AslDiagGenericFetcher;
import de.vw.mib.asl.internal.system.diag.DiagDataListCollector;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import java.util.Iterator;

public final class AslDiagDataFetcher
implements ASLListElementFetcher {
    private static final String LOGGING_DELIM;
    private final AslTargetSystemFeaturesAndCoding mTarget;
    ArrayList mFetcher = new ArrayList();
    DiagDataListCollector[] allCollectors = null;
    protected GenericASLList diagList = null;
    protected static final int WINDOW_SIZE;
    private int totalListSize = 0;
    private int logWriterPointer = 0;
    public static final int EV_LOG_WRITER;
    private static final int EV_LOG_WRITER_TIMEOUT;
    private static final int LOG_WRITER_BLOCK_SIZE;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$diagnosis$config$Coding;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$diagnosis$config$Adaptation;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$diagnosis$config$CarFuncAdap;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$diagnosis$config$LoadSpeedThreshold;

    private void updateList() {
        Object object;
        Object object2;
        Iterator iterator = this.mFetcher.iterator();
        while (iterator.hasNext()) {
            object2 = (AslDiagGenericFetcher)iterator.next();
            object = ((AslDiagGenericFetcher)object2).getCollector();
            if (object == null) continue;
            this.totalListSize += ((DiagDataListCollector[])object).length;
        }
        this.allCollectors = new DiagDataListCollector[this.totalListSize];
        int n = 0;
        object2 = this.mFetcher.iterator();
        while (object2.hasNext()) {
            object = (AslDiagGenericFetcher)object2.next();
            DiagDataListCollector[] diagDataListCollectorArray = ((AslDiagGenericFetcher)object).getCollector();
            if (diagDataListCollectorArray == null) continue;
            System.arraycopy((Object)diagDataListCollectorArray, 0, (Object)this.allCollectors, n, diagDataListCollectorArray.length);
            n += diagDataListCollectorArray.length;
        }
        this.diagList.setSize(this.totalListSize);
    }

    public AslDiagDataFetcher() {
        this.mTarget = SystemAccessor.getFeaturesAndCodingTarget();
        this.diagList = ListManager.getGenericASLList(3566);
        this.diagList.disableWindowing();
        this.diagList.enableWindowing(new ASLListItemDummyCacheImpl(), this, 4, 1);
        ConfigurationManagerDiag configurationManagerDiag = ServiceManager.configManagerDiag;
        this.mFetcher.add(new AslDiagGenericFetcher(configurationManagerDiag.getConfigurationFilePath("coding.swap"), class$de$vw$mib$asl$framework$api$diagnosis$config$Coding == null ? (class$de$vw$mib$asl$framework$api$diagnosis$config$Coding = AslDiagDataFetcher.class$("de.vw.mib.asl.framework.api.diagnosis.config.Coding")) : class$de$vw$mib$asl$framework$api$diagnosis$config$Coding, this.mTarget.getCodingData()));
        this.mFetcher.add(new AslDiagGenericFetcher(configurationManagerDiag.getConfigurationFilePath("adaptation.swap"), class$de$vw$mib$asl$framework$api$diagnosis$config$Adaptation == null ? (class$de$vw$mib$asl$framework$api$diagnosis$config$Adaptation = AslDiagDataFetcher.class$("de.vw.mib.asl.framework.api.diagnosis.config.Adaptation")) : class$de$vw$mib$asl$framework$api$diagnosis$config$Adaptation, this.mTarget.getAdaptationData()));
        this.mFetcher.add(new AslDiagGenericFetcher(configurationManagerDiag.getConfigurationFilePath("adaptation2.swap"), class$de$vw$mib$asl$framework$api$diagnosis$config$CarFuncAdap == null ? (class$de$vw$mib$asl$framework$api$diagnosis$config$CarFuncAdap = AslDiagDataFetcher.class$("de.vw.mib.asl.framework.api.diagnosis.config.CarFuncAdap")) : class$de$vw$mib$asl$framework$api$diagnosis$config$CarFuncAdap, this.mTarget.getCarFuncAdap()));
        this.mFetcher.add(new AslDiagGenericFetcher(configurationManagerDiag.getConfigurationFilePath("threshold.swap"), class$de$vw$mib$asl$framework$api$diagnosis$config$LoadSpeedThreshold == null ? (class$de$vw$mib$asl$framework$api$diagnosis$config$LoadSpeedThreshold = AslDiagDataFetcher.class$("de.vw.mib.asl.framework.api.diagnosis.config.LoadSpeedThreshold")) : class$de$vw$mib$asl$framework$api$diagnosis$config$LoadSpeedThreshold, this.mTarget.getLoadSpeedThreshold()));
        this.updateList();
        this.mFetcher = null;
    }

    public void close() {
        if (this.diagList != null) {
            this.diagList.setSize(0);
        }
    }

    public void writeDataToConsole() {
        this.mTarget.info().append("[AslDiagDataFetcher] ").append("writeDataToConsole").log();
        this.writeBlockToConsole();
    }

    public void writeBlockToConsole() {
        int n = this.logWriterPointer + 20;
        if (n > this.totalListSize) {
            n = this.totalListSize;
        }
        for (int i2 = this.logWriterPointer; i2 < n; ++i2) {
            this.mTarget.info(this.allCollectors[i2].toString());
        }
        if (n < this.totalListSize) {
            this.logWriterPointer = n;
            this.mTarget.startTimer(-1585053440, (long)0, false);
        } else {
            this.logWriterPointer = 0;
            this.mTarget.resetWritingDiagDataToConsole();
        }
    }

    private DiagDataListCollector[] getWindow(int n, int n2) {
        DiagDataListCollector[] diagDataListCollectorArray = new DiagDataListCollector[n2];
        for (int i2 = 0; i2 < diagDataListCollectorArray.length; ++i2) {
            diagDataListCollectorArray[i2] = this.allCollectors[n + i2];
        }
        return diagDataListCollectorArray;
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        if (this.mTarget.isTraceEnabled()) {
            this.mTarget.trace().append("[AslDiagDataFetcher] ").append("fetchItems index ").append(n).log();
        }
        Object[] objectArray = this.getWindow(n, n2);
        aSLCachedWindowList.updateListItems(n, objectArray);
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
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

