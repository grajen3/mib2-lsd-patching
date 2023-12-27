/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.startup;

import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.DSIAdapter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.GenericEventsAdapter;
import de.vw.mib.asl.internal.speechengine.task.AbstractTask;
import de.vw.mib.log4mib.Logger;

public class ConnectCommunications
extends AbstractTask {
    private final GenericEventsAdapter genericEventsAdapter;
    private final DSIAdapter dsiAdapter;
    private final int TRACE_CLASSIFIER;

    public ConnectCommunications(Logger logger, GenericEventsAdapter genericEventsAdapter, DSIAdapter dSIAdapter, int n) {
        super(logger);
        this.genericEventsAdapter = genericEventsAdapter;
        this.dsiAdapter = dSIAdapter;
        this.TRACE_CLASSIFIER = n;
    }

    @Override
    public void execute() {
        try {
            this.dsiAdapter.initDSIProxy();
            this.genericEventsAdapter.registerEvents();
            this.notifyFinishedSuccessful();
        }
        catch (Exception exception) {
            this.taskLogger.fatal(this.TRACE_CLASSIFIER, "Exception while executing task 'ConnectCommunications'. ", exception);
            this.notifyFinishedFlawed();
        }
    }

    @Override
    public void abort() {
    }

    @Override
    public void terminate() {
    }
}

