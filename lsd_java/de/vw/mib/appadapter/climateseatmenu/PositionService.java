/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.climateseatmenu;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.seat.SeatAdjustment;
import de.vw.mib.asl.api.car.seat.SeatService;
import de.vw.mib.asl.api.car.seat.SeatServiceListenerAdaptor;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.appadapter.climateseatmenu.PositionModelApiService;

public class PositionService
extends SeatServiceListenerAdaptor
implements PositionModelApiService {
    private AppAdapterSystemServices systemServices;
    private SeatService climateSeatService;
    private int seatZone;
    private Logger logger;

    public PositionService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
        this.climateSeatService = ASLCarFactory.getSeatApi().getSeatService();
        this.seatZone = appAdapterSystemServices.getAppInstanceId() == 0 ? 0 : 1;
        this.logger = this.systemServices.createLogger(256);
    }

    public void start() {
        ASLCarFactory.getSeatApi().addSeatServiceListener(this);
    }

    @Override
    public void _mda_buttonCursorLeftReleased() {
    }

    @Override
    public void _mda_buttonCursorRightReleased() {
    }

    @Override
    public void _mda_decreasePressed(int n) {
        this.logger.info(256, new StringBuffer().append("_mda_decreasePressed() called, position option= ").append(n).toString());
        if (n + 1 == 2) {
            this.logger.info(256, "(positionOption + 1) == SeatAdjustment.ENUM_SEAT_SETTING_LATERAL_CUSHION");
            this.logger.info(256, new StringBuffer().append("climateSeatService= ").append(this.climateSeatService).toString());
            this.logger.info(256, new StringBuffer().append("climateSeatService.getSeatValueFactory()= ").append(this.climateSeatService.getSeatValueFactory()).toString());
            SeatAdjustment seatAdjustment = this.climateSeatService.getSeatValueFactory().creatSeatAdjustment(this.seatZone, n + 1, 4, true);
            this.logger.info(256, new StringBuffer().append("seatAdjustment= ").append(seatAdjustment).toString());
            this.climateSeatService.changeSeatAdjustment(seatAdjustment);
        } else {
            this.logger.info(256, "else of :(positionOption + 1) == SeatAdjustment.ENUM_SEAT_SETTING_LATERAL_CUSHION");
            SeatAdjustment seatAdjustment = this.climateSeatService.getSeatValueFactory().creatSeatAdjustment(this.seatZone, n + 1, 2, true);
            this.logger.info(256, new StringBuffer().append("seatAdjustment= ").append(seatAdjustment.toString()).toString());
            this.climateSeatService.changeSeatAdjustment(seatAdjustment);
        }
    }

    @Override
    public void _mda_decreaseReleased(int n) {
        if (n + 1 == 2) {
            SeatAdjustment seatAdjustment = this.climateSeatService.getSeatValueFactory().creatSeatAdjustment(this.seatZone, n + 1, 4, false);
            this.climateSeatService.changeSeatAdjustment(seatAdjustment);
        } else {
            SeatAdjustment seatAdjustment = this.climateSeatService.getSeatValueFactory().creatSeatAdjustment(this.seatZone, n + 1, 2, false);
            this.climateSeatService.changeSeatAdjustment(seatAdjustment);
        }
    }

    @Override
    public void _mda_increasePressed(int n) {
        if (n + 1 == 2) {
            SeatAdjustment seatAdjustment = this.climateSeatService.getSeatValueFactory().creatSeatAdjustment(this.seatZone, n + 1, 3, true);
            this.climateSeatService.changeSeatAdjustment(seatAdjustment);
        } else {
            SeatAdjustment seatAdjustment = this.climateSeatService.getSeatValueFactory().creatSeatAdjustment(this.seatZone, n + 1, 1, true);
            this.climateSeatService.changeSeatAdjustment(seatAdjustment);
        }
    }

    @Override
    public void _mda_increaseReleased(int n) {
        if (n + 1 == 2) {
            SeatAdjustment seatAdjustment = this.climateSeatService.getSeatValueFactory().creatSeatAdjustment(this.seatZone, n + 1, 3, false);
            this.climateSeatService.changeSeatAdjustment(seatAdjustment);
        } else {
            SeatAdjustment seatAdjustment = this.climateSeatService.getSeatValueFactory().creatSeatAdjustment(this.seatZone, n + 1, 1, false);
            this.climateSeatService.changeSeatAdjustment(seatAdjustment);
        }
    }
}

