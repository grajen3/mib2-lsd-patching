/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.seats;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.car.seats.SeatMainController;
import de.vw.mib.asl.internal.car.seats.SeatTargetService;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class HsmTargetSeats
extends AbstractASLTarget
implements SeatTargetService {
    private SeatMainController seatMainController;

    public HsmTargetSeats(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return -1823534592;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    private void registerModelEvents() {
        this.addObservers(new int[]{1393295424, 1410072640, 1426849856, 1041039424, 1057816640});
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.registerModelEvents();
                if (this.seatMainController != null) break;
                this.seatMainController = new SeatMainController(this);
                break;
            }
            case 1073744979: {
                this.seatMainController.toggleBeltTensionerFront(0);
                break;
            }
            case 1073744980: {
                this.seatMainController.toggleBeltTensionerFront(1);
                break;
            }
            case 1073744981: {
                this.seatMainController.toggleDriverSeatPositionStorage();
                break;
            }
            case 1073745214: {
                this.seatMainController.toggleEasyEntryExitDriverSeat();
                break;
            }
            case 1073745215: {
                this.seatMainController.toggleEasyEntryExitPassengerSeat();
                break;
            }
        }
    }

    @Override
    public void writeToLog(int n, Object object) {
        if (this.isTraceEnabled()) {
            switch (n) {
                case 0: {
                    this.trace().append(object).log();
                    break;
                }
                case 3: {
                    break;
                }
            }
        }
    }
}

