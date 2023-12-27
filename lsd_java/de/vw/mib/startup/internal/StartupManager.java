/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.startup.internal;

import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.event.StartupEvent;
import de.vw.mib.event.consumer.StartupManagerEventConsumer;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.osgi.MIBOsgi;
import de.vw.mib.startup.StartupManagerService;
import de.vw.mib.startup.StartupManagerServiceListener;
import de.vw.mib.startup.internal.ServiceManager;
import de.vw.mib.startup.internal.StartupManager$1;

final class StartupManager
implements StartupManagerService,
StartupManagerEventConsumer {
    static Logger logger = ServiceManager.loggerFactory.getLogger(16384);
    private boolean datapoolUpdatesEnabled = false;
    private boolean dispatcherStarted = false;
    private final CowArray listeners = new CowArray();
    private boolean lumReady = false;
    private boolean skinReady = false;
    private boolean speechUIReady;
    private boolean startUpGUIReady;
    boolean bundlesStarted = false;
    final MIBOsgi mibOsgi = MIBOsgi.getInstance();

    StartupManager() {
    }

    @Override
    public void addStartupManagerServiceListener(StartupManagerServiceListener startupManagerServiceListener) {
        this.listeners.addIfNotAlreadyIn(startupManagerServiceListener);
    }

    @Override
    public void consumeEvent(StartupEvent startupEvent) {
        switch (startupEvent.getEventId()) {
            case 2: {
                logger.trace(4, "SKIN_READY event received");
                this.skinReady = true;
                this.startEventDispatcherIfReady();
                break;
            }
            case 3: {
                logger.trace(4, "LUM_READY event received");
                this.lumReady = true;
                this.startEventDispatcherIfReady();
                break;
            }
            case 4: {
                logger.trace(4, "START_EVENT_DISPATCHER event received");
                ServiceManager.eventDispatcherManager.startMainDispatchingThread();
                logger.info(4, "UI thread started!");
                break;
            }
            case 6: {
                logger.trace(4, "SPEECH_BUNDLES_READY event received");
                ServiceManager.frameworkEventDispatcher.createAndSubmitStartupEvent(7);
                break;
            }
            case 7: {
                logger.trace(4, "SPEECH_UI_READY event received");
                this.speechUIReady = true;
                if (!this.startUpGUIReady) break;
                ServiceManager.eventDispatcherManager.stopStartupDispatchingThread();
                break;
            }
            case 8: {
                logger.trace(4, "GUI ready event received");
                this.startUpGUIReady = true;
                this.startLateloadBundles();
                if (!this.speechUIReady) break;
                ServiceManager.eventDispatcherManager.stopStartupDispatchingThread();
                break;
            }
        }
    }

    @Override
    public boolean isDatapoolUpdatesEnabled() {
        return this.datapoolUpdatesEnabled;
    }

    @Override
    public void removeStartupManagerServiceListener(StartupManagerServiceListener startupManagerServiceListener) {
        this.listeners.remove(startupManagerServiceListener);
    }

    private void startDatapoolUpdates() {
        this.datapoolUpdatesEnabled = true;
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((StartupManagerServiceListener)objectArray[i2]).datapoolUpdatesEnabled(this.datapoolUpdatesEnabled);
        }
    }

    private void startEventDispatcherIfReady() {
        if (this.dispatcherStarted) {
            return;
        }
        if (!this.skinReady) {
            logger.trace(4, "initial skin change has not finished yet");
            return;
        }
        if (!this.lumReady) {
            logger.trace(4, "LUM has not finished yet");
            return;
        }
        if (!this.bundlesStarted) {
            logger.trace(4, "bundles startup has not finished yet");
            return;
        }
        logger.trace(4, "Start EventDispatcher thread ...");
        this.startDatapoolUpdates();
        this.dispatcherStarted = true;
        ServiceManager.startupEventDispatcher.createAndSubmitStartupEvent(0);
        ServiceManager.startupEventDispatcher.createAndSubmitStartupEvent(10);
        ServiceManager.startupEventDispatcher.createAndSubmitStartupEvent(4);
    }

    private void startLateloadBundles() {
        ServiceManager.threadManager.createThread(5, new StartupManager$1(this)).start();
    }

    void startManagedBundles() {
        this.mibOsgi.startManagedBundles();
        this.bundlesStarted = true;
        this.startEventDispatcherIfReady();
    }
}

