/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.error.internal;

import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.debug.spi.DebugSPI;
import de.vw.mib.error.ErrorHandler;
import de.vw.mib.error.HMIDumpInformationProvider;
import de.vw.mib.error.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandlerImpl
implements ErrorHandler {
    private static final String LINEFEED;
    private static Logger logger;
    private CowArray providers = new CowArray();
    private final boolean ignoreRebootRequests = Boolean.getBoolean("de.vw.mib.error.ignoreRebootRequests");
    private final boolean showDsiErrors = Boolean.getBoolean("de.vw.mib.error.showDsiErrors") | Boolean.getBoolean("ErrorHandler.showDsiErrors");
    private final boolean showScriptErrors = Boolean.getBoolean("de.vw.mib.error.showScriptErrors");
    private final boolean showStartupErrors = Boolean.getBoolean("de.vw.mib.error.showStartupErrors") | Boolean.getBoolean("ErrorHandler.showStartupErrors");
    private ArrayList startupErrors = new ArrayList();
    byte[] reservedMemory = new byte[16384];
    private final DebugSPI debugSpi;

    ErrorHandlerImpl(DebugSPI debugSPI) {
        if (debugSPI == null) {
            throw new IllegalArgumentException("Argument >debugSpi< must not be null!");
        }
        this.debugSpi = debugSPI;
    }

    @Override
    public void addHMIDumpInformationProvider(HMIDumpInformationProvider hMIDumpInformationProvider) {
        this.providers.addIfNotAlreadyIn(hMIDumpInformationProvider);
    }

    @Override
    public void clearStartupErrors() {
        this.startupErrors.clear();
    }

    @Override
    public void dump() {
        this.printHMIDump();
    }

    @Override
    public List getStartupErrors() {
        return this.startupErrors;
    }

    @Override
    public void handleDsiError(Throwable throwable) {
        try {
            logger.error(2, "A DSI error occurs!", throwable);
            if (!this.showDsiErrors) {
                return;
            }
            if (ServiceManager.showErrorPopupExecutor == null) {
                logger.error(1, "no ShowErrorPopupExecutor service available!", throwable);
                return;
            }
            ServiceManager.showErrorPopupExecutor.showErrorPopup(throwable);
        }
        catch (Throwable throwable2) {
            System.err.println(new StringBuffer().append("Error while handling dsi error: ").append(throwable).toString());
            throwable.printStackTrace();
            System.err.println("Caused by:");
            throwable2.printStackTrace();
        }
    }

    @Override
    public void handleError(Throwable throwable) {
        try {
            if (throwable instanceof OutOfMemoryError) {
                this.handleOutOfMemoryError(throwable);
            } else {
                logger.error(1, "An error occurs!", throwable);
            }
        }
        catch (Throwable throwable2) {
            System.err.println(new StringBuffer().append("Error while handling error: ").append(throwable).toString());
            throwable.printStackTrace();
            System.err.println("Caused by:");
            throwable2.printStackTrace();
        }
    }

    @Override
    public void handleError(Throwable throwable, Thread thread) {
        try {
            if (throwable instanceof OutOfMemoryError) {
                this.handleOutOfMemoryError(throwable);
            } else {
                logger.error(1).append("An error occurs in ").append(thread).append("!").attachThrowable(throwable).log();
            }
        }
        catch (Throwable throwable2) {
            System.err.println(new StringBuffer().append("Error while handling error: ").append(throwable).toString());
            throwable.printStackTrace();
            System.err.println("Caused by:");
            throwable2.printStackTrace();
        }
    }

    @Override
    public void handleScriptError(Throwable throwable) {
        try {
            logger.error(16, "A script error occurs!", throwable);
            if (!this.showScriptErrors) {
                return;
            }
            if (ServiceManager.showErrorPopupExecutor == null) {
                logger.error(1, "no ShowErrorPopupExecutor service available!", throwable);
                return;
            }
            ServiceManager.showErrorPopupExecutor.showErrorPopup(throwable);
        }
        catch (Throwable throwable2) {
            System.err.println(new StringBuffer().append("Error while handling script error: ").append(throwable).toString());
            throwable.printStackTrace();
            System.err.println("Caused by:");
            throwable2.printStackTrace();
        }
    }

    @Override
    public void handleStartupError(Throwable throwable) {
        try {
            logger.error(4, "A startup error occurs!", throwable);
            if (this.showStartupErrors) {
                this.startupErrors.add(throwable);
            }
        }
        catch (Throwable throwable2) {
            System.err.println(new StringBuffer().append("Error while handling startup error: ").append(throwable).toString());
            throwable.printStackTrace();
            System.err.println("Caused by:");
            throwable2.printStackTrace();
        }
    }

    @Override
    public void handleStatemachineError(Throwable throwable, boolean bl) {
        try {
            logger.error(32, "A statemachine error occurs!", throwable);
            this.printHMIDump();
            if (!bl) {
                return;
            }
            if (ServiceManager.switchToMenuExecutor != null) {
                ServiceManager.switchToMenuExecutor.switchToMenu();
            } else {
                logger.error(1, "No SwitchToMenuExecutor service available!", throwable);
            }
        }
        catch (Throwable throwable2) {
            System.err.println(new StringBuffer().append("Error while handling statemachine error: ").append(throwable).toString());
            throwable.printStackTrace();
            System.err.println("Caused by:");
            throwable2.printStackTrace();
        }
    }

    @Override
    public void handleViewCreationError(Throwable throwable, boolean bl) {
        try {
            logger.error(64, "A view creation error occurs!", throwable);
            this.printHMIDump();
            if (throwable instanceof NoSuchMethodException) {
                this.logViewCreationError(throwable);
            }
            if (!bl) {
                return;
            }
            if (ServiceManager.switchToMenuExecutor != null) {
                ServiceManager.switchToMenuExecutor.switchToMenu();
            } else {
                logger.error(1, "No SwitchToMenuExecutor service available!", throwable);
            }
        }
        catch (Throwable throwable2) {
            System.err.println(new StringBuffer().append("Error while handling view creation error: ").append(throwable).toString());
            throwable.printStackTrace();
            System.err.println("Caused by:");
            throwable2.printStackTrace();
        }
    }

    private void logViewCreationError(Throwable throwable) {
        this.debugSpi.OSLogEvent(268, new StringBuffer().append("NoSuchMethodException: ").append(throwable.getMessage()).toString());
    }

    @Override
    public void rebootSystem(Throwable throwable) {
        try {
            logger.fatal(1, "A fatal error occurs! Reboot requested!", throwable);
            this.printHMIDump();
            if (this.ignoreRebootRequests) {
                logger.error(1, "Ignore reboot request due to the specified system property 'de.vw.mib.error.ignoreRebootRequests'!", throwable);
            } else if (ServiceManager.rebootExecutor != null) {
                ServiceManager.rebootExecutor.performSystemReboot();
            } else {
                logger.error(1, "No RebootExecutor service available!", throwable);
            }
        }
        catch (Throwable throwable2) {
            System.err.println(new StringBuffer().append("Error while requesting reboot for error: ").append(throwable).toString());
            throwable.printStackTrace();
            System.err.println("Caused by:");
            throwable2.printStackTrace();
        }
    }

    private void handleOutOfMemoryError(Throwable throwable) {
        this.reservedMemory = null;
        for (int i2 = 5; i2 >= 0; --i2) {
            System.err.println("[ErrorHandler] crash ahead!");
        }
        throwable.printStackTrace();
        this.printHMIDumpToConsole();
    }

    private void printHMIDump() {
        if (this.providers.size() == 0) {
            logger.error(8, "Couldn't create an hmi dump! No information provider available!");
            return;
        }
        LogMessage logMessage = logger.error(8);
        logMessage.append("HMI dump:").append("\n").append("\n");
        logMessage.log();
        Object[] objectArray = this.providers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            HMIDumpInformationProvider hMIDumpInformationProvider = (HMIDumpInformationProvider)objectArray[i2];
            try {
                logMessage = logger.error(8);
                String string = hMIDumpInformationProvider.getName();
                String[] stringArray = hMIDumpInformationProvider.getDumpInformation();
                if (stringArray.length == 0) continue;
                logMessage.append(string).append("\n");
                for (int i3 = 0; i3 < stringArray.length; ++i3) {
                    logMessage.append(stringArray[i3]).append("\n");
                }
            }
            catch (Exception exception) {
                logMessage.append("\n");
                logMessage.append("error while getting dump information from provider ").append(hMIDumpInformationProvider);
                logMessage.append("\n");
            }
            logMessage.append("\n");
            logMessage.log();
            hMIDumpInformationProvider.clearDumpInformation();
        }
    }

    private void printHMIDumpToConsole() {
        if (this.providers.size() == 0) {
            System.err.println("Couldn't create an hmi dump! No information provider available!");
            return;
        }
        System.err.println("HMI dump:");
        System.err.println();
        Object[] objectArray = this.providers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            HMIDumpInformationProvider hMIDumpInformationProvider = (HMIDumpInformationProvider)objectArray[i2];
            try {
                String string = hMIDumpInformationProvider.getName();
                String[] stringArray = hMIDumpInformationProvider.getDumpInformation();
                if (stringArray.length == 0) continue;
                System.err.println(string);
                for (int i3 = 0; i3 < stringArray.length; ++i3) {
                    System.err.println(stringArray[i3]);
                }
                System.err.println();
                continue;
            }
            catch (Exception exception) {
                System.err.println(new StringBuffer().append("error while getting dump information from provider ").append(hMIDumpInformationProvider).toString());
            }
        }
    }

    static {
        logger = ServiceManager.loggerFactory.getLogger(32);
    }
}

