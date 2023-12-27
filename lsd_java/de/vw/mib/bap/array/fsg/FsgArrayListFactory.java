/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.fsg;

import de.vw.mib.bap.array.fsg.FSGArrayListDelegate;
import de.vw.mib.bap.array.fsg.FsgArrayList;
import de.vw.mib.bap.array.fsg.FsgArrayListComplete;
import de.vw.mib.bap.array.fsg.FsgArrayListGenericIdGenerator;
import de.vw.mib.bap.array.fsg.FsgArrayListIdGenerator;
import de.vw.mib.bap.array.fsg.FsgArrayListWindowed;
import de.vw.mib.bap.array.fsg.FsgArrayMessageBlockingRequestTracker;
import de.vw.mib.bap.array.fsg.FsgArrayObjectIdGenerator;
import de.vw.mib.bap.array.timer.TimerFactory;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;

public class FsgArrayListFactory {
    private static FsgArrayListFactory fsgArrayListFactory = null;
    private static final int MIN_8_BIT_BAP_ID;
    private static final int MAX_8_BIT_BAP_ID;
    private static final int MIN_16_BIT_BAP_ID;
    private static final int MAX_16_BIT_BAP_ID;

    public FsgArrayList createCompleteFsgArrayList(FsgArrayListIdGenerator fsgArrayListIdGenerator) {
        return new FsgArrayListComplete(fsgArrayListIdGenerator);
    }

    public FsgArrayList createCompleteFsgArrayList(boolean bl) {
        return bl ? this.createCompleteFsgArrayList(new FsgArrayListGenericIdGenerator(-65536, 1)) : this.createCompleteFsgArrayList(new FsgArrayListGenericIdGenerator(255, 1));
    }

    public FsgArrayList createFsgArrayListWindowed(int n, FsgArrayObjectIdGenerator fsgArrayObjectIdGenerator, FSGArrayListDelegate fSGArrayListDelegate) {
        FsgArrayListWindowed fsgArrayListWindowed = new FsgArrayListWindowed(n, fSGArrayListDelegate);
        fsgArrayListWindowed.setObjectIdGenerator(fsgArrayObjectIdGenerator);
        fsgArrayListWindowed.setArrayListIDGenerator(new FsgArrayListGenericIdGenerator(-65536, 1));
        fsgArrayListWindowed.initialize();
        return fsgArrayListWindowed;
    }

    public FsgArrayMessageBlockingRequestTracker createMessageBlockingRequestTracker(Array array, ArrayListener arrayListener, TimerFactory timerFactory) {
        return new FsgArrayMessageBlockingRequestTracker(array, arrayListener, timerFactory);
    }

    public static FsgArrayListFactory getInstance() {
        if (fsgArrayListFactory == null) {
            fsgArrayListFactory = new FsgArrayListFactory();
        }
        return fsgArrayListFactory;
    }
}

