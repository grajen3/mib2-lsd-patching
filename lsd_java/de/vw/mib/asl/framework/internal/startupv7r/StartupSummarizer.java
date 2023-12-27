/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r;

import de.vw.mib.asl.framework.internal.startupv7r.StartupSummarizer$WorkUnitSummary;
import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;
import de.vw.mib.collections.ObjectObjectMap;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class StartupSummarizer {
    private final List logs = new ArrayList();
    private final ObjectObjectMap mapWorkUnit2Summary = new ObjectObjectOptHashMap();
    private final IntObjectMap mapWorker2StartingWorkUnit = new IntObjectOptHashMap();
    private int workerCount;

    public void printSummary(Logger logger) {
        this.workerCount = this.findWorkerCount();
        logger.info(1, "===== STARTUP SUMMARY =====");
        this.printWorkUnits(logger);
        logger.info(1, "===== END OF STARTUP SUMMARY =====");
    }

    public void logWorkUnitStart(AbstractWorkUnit abstractWorkUnit, int n) {
        Preconditions.checkArgument(!this.checkIsWorkerInUse(n), "The given worker is already in use");
        StartupSummarizer$WorkUnitSummary startupSummarizer$WorkUnitSummary = new StartupSummarizer$WorkUnitSummary(abstractWorkUnit, n, this.mapWorker2StartingWorkUnit.values());
        this.logs.add(startupSummarizer$WorkUnitSummary);
        this.mapWorker2StartingWorkUnit.put(n, abstractWorkUnit);
        this.mapWorkUnit2Summary.put(abstractWorkUnit, startupSummarizer$WorkUnitSummary);
    }

    public void logWorkUnitCompleted(AbstractWorkUnit abstractWorkUnit) {
        Preconditions.checkArgument(this.mapWorker2StartingWorkUnit.values().contains(abstractWorkUnit), "Work Unit hasn't been started or was completed before");
        int n = this.mapWorker2StartingWorkUnit.getOneKeyByValue(abstractWorkUnit);
        this.mapWorker2StartingWorkUnit.remove(n);
    }

    public void logAdditionalMessage(AbstractWorkUnit abstractWorkUnit, String string) {
        Preconditions.checkArgument(this.mapWorkUnit2Summary.containsKey(abstractWorkUnit), "Work unit was not started");
        StartupSummarizer$WorkUnitSummary startupSummarizer$WorkUnitSummary = (StartupSummarizer$WorkUnitSummary)this.mapWorkUnit2Summary.get(abstractWorkUnit);
        startupSummarizer$WorkUnitSummary.getAdditionalMessages().add(string);
    }

    private void printWorkUnits(Logger logger) {
        Iterator iterator = this.logs.iterator();
        while (iterator.hasNext()) {
            StartupSummarizer$WorkUnitSummary startupSummarizer$WorkUnitSummary = (StartupSummarizer$WorkUnitSummary)iterator.next();
            logger.info(1, new StringBuffer().append(this.printWorker(startupSummarizer$WorkUnitSummary)).append(" ").append(startupSummarizer$WorkUnitSummary.getWorkUnit().getName()).toString());
            this.printAdditionalMessages(logger, startupSummarizer$WorkUnitSummary);
        }
    }

    private void printAdditionalMessages(Logger logger, StartupSummarizer$WorkUnitSummary startupSummarizer$WorkUnitSummary) {
        Iterator iterator = startupSummarizer$WorkUnitSummary.getAdditionalMessages().iterator();
        while (iterator.hasNext()) {
            logger.info(1, new StringBuffer().append("  >> ").append(iterator.next()).toString());
        }
    }

    private int findWorkerCount() {
        int n = 0;
        Iterator iterator = this.logs.iterator();
        while (iterator.hasNext()) {
            StartupSummarizer$WorkUnitSummary startupSummarizer$WorkUnitSummary = (StartupSummarizer$WorkUnitSummary)iterator.next();
            n = Math.max(n, startupSummarizer$WorkUnitSummary.getWorker());
        }
        return n + 1;
    }

    private String printWorker(StartupSummarizer$WorkUnitSummary startupSummarizer$WorkUnitSummary) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        this.printWorkerUsage(stringBuilder, startupSummarizer$WorkUnitSummary);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private void printWorkerUsage(StringBuilder stringBuilder, StartupSummarizer$WorkUnitSummary startupSummarizer$WorkUnitSummary) {
        for (int i2 = 0; i2 < this.workerCount; ++i2) {
            if (this.checkIsWorkerInUse(i2, startupSummarizer$WorkUnitSummary.getActiveWorkUnits())) {
                stringBuilder.append("V");
                continue;
            }
            if (i2 == startupSummarizer$WorkUnitSummary.getWorker()) {
                stringBuilder.append(i2);
                continue;
            }
            stringBuilder.append(" ");
        }
    }

    private boolean checkIsWorkerInUse(int n) {
        return this.mapWorker2StartingWorkUnit.containsKey(n);
    }

    private boolean checkIsWorkerInUse(int n, Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            AbstractWorkUnit abstractWorkUnit = (AbstractWorkUnit)iterator.next();
            StartupSummarizer$WorkUnitSummary startupSummarizer$WorkUnitSummary = (StartupSummarizer$WorkUnitSummary)this.mapWorkUnit2Summary.get(abstractWorkUnit);
            if (startupSummarizer$WorkUnitSummary.getWorker() != n) continue;
            return true;
        }
        return false;
    }
}

