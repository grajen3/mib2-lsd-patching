/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.bap.dispatcher;

import de.vw.mib.asl.api.bap.lcu.BAPLogicalControlUnit;
import de.vw.mib.asl.api.bap.timer.Timer;
import de.vw.mib.asl.api.bap.timer.TimerNotifier;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import java.util.ArrayList;
import org.dsi.ifc.bap.DSIBAP;

public interface BAPDispatcher {
    default public DSIBAP getServiceProvider() {
    }

    default public void processDatapoolChange(int n, int n2, int n3) {
    }

    default public void processDatapoolChangeWithThreadChange(int n, int n2, int n3) {
    }

    default public void processStageOutputValue(int n, int n2) {
    }

    default public void processStageOutputValueWithThreadChange(int n, int n2) {
    }

    default public void informThatAllBapDatapoolValuesAreValid(int n) {
    }

    default public void informHmiLanguageChange(int n, int n2) {
    }

    default public void informPersistenceAvailability() {
    }

    default public void transmitData(int n, int n2, int n3, Object object) {
    }

    default public void observeHMIEvents(int n, int n2, int[] nArray) {
    }

    default public void registerForPersistenceAvailability(int n, int n2) {
    }

    default public Timer createTimer(TimerNotifier timerNotifier, int n, int n2, int n3, long l) {
    }

    default public void initialize(GenericEvents genericEvents, EventFactory eventFactory) {
    }

    default public void registerLogicalControlUnits(ArrayList arrayList, boolean bl) {
    }

    default public void uninitialize(int n) {
    }

    default public BAPLogicalControlUnit getLogicalControlUnit(int n) {
    }
}

