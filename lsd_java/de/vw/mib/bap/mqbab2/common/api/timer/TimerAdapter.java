/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.timer;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.timer.TimerService;
import de.vw.mib.bap.mqbab2.common.timer.TimerObj;

public class TimerAdapter
implements TimerService {
    private APIFactoryInterface apiFactory;

    public TimerAdapter(APIFactoryInterface aPIFactoryInterface) {
        this.apiFactory = aPIFactoryInterface;
    }

    @Override
    public Timer createTimer(TimerNotifier timerNotifier, int n) {
        return new TimerObj(timerNotifier, n);
    }
}

