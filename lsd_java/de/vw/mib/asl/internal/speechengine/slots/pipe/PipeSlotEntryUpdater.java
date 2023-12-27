/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots.pipe;

import de.vw.mib.asl.api.speechengine.slots.SlotEntry;
import de.vw.mib.asl.api.speechengine.slots.SlotUpdater;
import de.vw.mib.asl.internal.speechengine.slots.pipe.SlotEntryDefault;
import de.vw.mib.asl.internal.speechengine.slots.pipe.SlotHashList;
import de.vw.mib.asl.internal.speechengine.slots.pipe.SlotLoader;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.SlotPipeline;
import de.vw.mib.asl.internal.speechengine.slots.pipe.lines.SlotPipelineFactory;
import de.vw.mib.asl.internal.speechengine.slots.start.SlotUpdaterParameters;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.log4mib.LogMessage;

public class PipeSlotEntryUpdater
extends SlotUpdater {
    private IntObjectMap slots = new IntObjectOptHashMap();
    private final SlotPipeline growUpdateStrategy;
    private final SlotPipeline defaultUpdateStrategy;
    private final SlotPipeline immediateUpdateStrategy;
    private final SlotLoader slotLoader;
    private final SlotUpdaterParameters slotUpdaterParameters;
    private final AbstractClassifiedLogger logger;

    public PipeSlotEntryUpdater(SlotPipelineFactory slotPipelineFactory, SlotLoader slotLoader, SlotUpdaterParameters slotUpdaterParameters) {
        this.logger = slotUpdaterParameters.getLogger();
        this.slotUpdaterParameters = slotUpdaterParameters;
        this.growUpdateStrategy = slotPipelineFactory.getGrowSlotUpdatePipeline();
        this.defaultUpdateStrategy = slotPipelineFactory.getDefaultSlotUpdatePipeline();
        this.immediateUpdateStrategy = slotPipelineFactory.getImmediateSlotUpdatePipeline();
        this.slotLoader = slotLoader;
    }

    @Override
    public void updateSlotData(int n, int n2, SlotEntry[] slotEntryArray) {
        SlotHashList slotHashList = this.getList(n);
        SlotEntry[] slotEntryArray2 = this.checkNewSlotEntries(n, slotEntryArray);
        switch (n2) {
            case 2: {
                this.growUpdateStrategy.startUpdate(slotHashList, slotEntryArray2);
                break;
            }
            case 1: {
                this.defaultUpdateStrategy.startUpdate(slotHashList, slotEntryArray2);
                break;
            }
            case 3: {
                this.immediateUpdateStrategy.startUpdate(slotHashList, slotEntryArray2);
                break;
            }
            default: {
                LogMessage logMessage = this.logger.error();
                logMessage.append("updateSlotData() called with invalid strategy. slotId:");
                logMessage.append(n);
                logMessage.append(" strategy:");
                logMessage.append(n2);
                logMessage.log();
                break;
            }
        }
    }

    private SlotHashList getList(int n) {
        SlotHashList slotHashList;
        if (!this.slots.containsKey(n)) {
            if (this.logger.isTraceEnabled()) {
                LogMessage logMessage = this.slotUpdaterParameters.getLogger().trace();
                logMessage.append("updateSlotData() First update for slotId:");
                logMessage.append(n);
                logMessage.log();
            }
            slotHashList = new SlotHashList(n, this.slotLoader);
            this.slots.put(n, slotHashList);
        } else {
            slotHashList = (SlotHashList)this.slots.get(n);
        }
        return slotHashList;
    }

    private SlotEntry[] checkNewSlotEntries(int n, SlotEntry[] slotEntryArray) {
        SlotEntry[] slotEntryArray2 = slotEntryArray == null ? new SlotEntry[]{} : slotEntryArray;
        this.checkNewSlotEntriesLog(n, slotEntryArray2);
        return slotEntryArray2;
    }

    private void checkNewSlotEntriesLog(int n, SlotEntry[] slotEntryArray) {
        if (this.logger.isTraceEnabled()) {
            LogMessage logMessage = this.logger.trace();
            logMessage.append("updateSlotData() Update slots for slotId:");
            logMessage.append(n);
            logMessage.append(" newSlotsSize:");
            logMessage.append(slotEntryArray.length);
            if (this.slotUpdaterParameters.getConfigurationManagerDiag().isDevelopmentBuild()) {
                logMessage.append(" entries: [");
                for (int i2 = 0; i2 < slotEntryArray.length; ++i2) {
                    SlotEntry slotEntry = slotEntryArray[i2];
                    logMessage.append(slotEntry.getSpeakableText());
                    logMessage.append(":");
                    logMessage.append(slotEntry.getObjectId());
                    logMessage.append(",");
                }
                logMessage.append("]");
            } else {
                logMessage.append(" not logging content of slot because release build is present.");
            }
            logMessage.log();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String convertToUnqualifiedName(String string) {
        String string2;
        block6: {
            if (string == null) {
                return "";
            }
            int n = string.lastIndexOf(46);
            string2 = string;
            try {
                if (n >= 0) {
                    string2 = string.substring(n + 1);
                    break block6;
                }
                string2 = string;
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                string2 = "";
            }
        }
        return string2;
    }

    @Override
    public SlotEntry createSlotEntry(long l, String string) {
        return new SlotEntryDefault(string, l);
    }
}

