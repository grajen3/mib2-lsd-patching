/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.debug.spi.DebugSPI;
import de.vw.mib.debugmanager.dump.DumpService;
import de.vw.mib.debugmanager.dump.HmiDumpInformationProvider;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

final class DumpServices
implements DumpService {
    private static final String LINEFEED;
    private final DebugSPI debugSpi;
    private final Logger logger;
    private final CowArray providers = new CowArray();

    DumpServices(Logger logger, DebugSPI debugSPI) {
        this.logger = logger;
        this.debugSpi = debugSPI;
    }

    @Override
    public void triggerHmiDump() {
        if (this.providers.size() == 0) {
            this.logger.error(8, "Couldn't create an hmi dump! No information provider available!");
            return;
        }
        this.printHMIDump();
    }

    @Override
    public void triggerHmiDumpToConsole() {
        if (this.providers.size() == 0) {
            System.err.println("Couldn't create an hmi dump! No information provider available!");
            return;
        }
        this.printHMIDumpToConsole();
    }

    @Override
    public synchronized void triggerThreadDumpToConsole() {
        this.logger.info(1, "thread dump triggered");
        this.debugSpi.dumpAllThreadStacks();
    }

    void register(HmiDumpInformationProvider hmiDumpInformationProvider) {
        this.providers.addIfNotAlreadyIn(hmiDumpInformationProvider);
    }

    void unregister(HmiDumpInformationProvider hmiDumpInformationProvider) {
        this.providers.remove(hmiDumpInformationProvider);
    }

    private synchronized void printHMIDump() {
        LogMessage logMessage = this.logger.error(8);
        logMessage.append("HMI dump:").append("\n").append("\n");
        logMessage.log();
        Object[] objectArray = this.providers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            HmiDumpInformationProvider hmiDumpInformationProvider = (HmiDumpInformationProvider)objectArray[i2];
            try {
                logMessage = this.logger.error(8);
                String string = hmiDumpInformationProvider.getName();
                String[] stringArray = hmiDumpInformationProvider.getDumpInformation();
                if (stringArray.length == 0) continue;
                logMessage.append(string).append("\n");
                for (int i3 = 0; i3 < stringArray.length; ++i3) {
                    logMessage.append(stringArray[i3]).append("\n");
                }
            }
            catch (Exception exception) {
                logMessage.append("\n");
                logMessage.append("error while getting dump information from provider ").append(hmiDumpInformationProvider);
                logMessage.append("\n");
            }
            logMessage.append("\n");
            logMessage.log();
            hmiDumpInformationProvider.clearDumpInformation();
        }
    }

    private synchronized void printHMIDumpToConsole() {
        System.err.println("HMI dump:");
        System.err.println();
        Object[] objectArray = this.providers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            HmiDumpInformationProvider hmiDumpInformationProvider = (HmiDumpInformationProvider)objectArray[i2];
            try {
                String string = hmiDumpInformationProvider.getName();
                String[] stringArray = hmiDumpInformationProvider.getDumpInformation();
                if (stringArray.length == 0) continue;
                System.err.println(string);
                for (int i3 = 0; i3 < stringArray.length; ++i3) {
                    System.err.println(stringArray[i3]);
                }
                System.err.println();
            }
            catch (Exception exception) {
                System.err.println(new StringBuffer().append("error while getting dump information from provider ").append(hmiDumpInformationProvider).toString());
            }
            hmiDumpInformationProvider.clearDumpInformation();
        }
    }
}

