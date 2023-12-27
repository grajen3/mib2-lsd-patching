/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carseat;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.carseat.DSICarSeatReply;
import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.carseat.DSICarSeatListener;
import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.RestSeatStatus;
import org.dsi.ifc.carseat.SeatAdjustment;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatPneumaticViewOptions;
import org.dsi.ifc.carseat.SeatSpecialPosition;
import org.dsi.ifc.carseat.SeatViewOptions;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;

public class DSICarSeatDispatcher
extends AbstractDispatcher
implements DSICarSeatReply {
    private DSICarSeatReplyService service = new DSICarSeatReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$carseat$DSICarSeatListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICarSeatDispatcher(int n) {
        super(n, (class$org$dsi$ifc$carseat$DSICarSeatListener == null ? (class$org$dsi$ifc$carseat$DSICarSeatListener = DSICarSeatDispatcher.class$("org.dsi.ifc.carseat.DSICarSeatListener")) : class$org$dsi$ifc$carseat$DSICarSeatListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateSeatViewOptions(SeatViewOptions seatViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(1, dSICarSeatListener);
                    dSICarSeatListener.updateSeatViewOptions(seatViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatViewOptions(seatViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatRadioKeyAutomatic(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(2, dSICarSeatListener);
                    dSICarSeatListener.updateSeatRadioKeyAutomatic(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatRadioKeyAutomatic(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatSpecialPosition(SeatSpecialPosition seatSpecialPosition, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(3, dSICarSeatListener);
                    dSICarSeatListener.updateSeatSpecialPosition(seatSpecialPosition, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatSpecialPosition(seatSpecialPosition, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatSpecialPositionRearCoDriver(SeatSpecialPosition seatSpecialPosition, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(52, dSICarSeatListener);
                    dSICarSeatListener.updateSeatSpecialPositionRearCoDriver(seatSpecialPosition, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatSpecialPositionRearCoDriver(seatSpecialPosition, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatFrontLeftStopButton(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(4, dSICarSeatListener);
                    dSICarSeatListener.updateSeatFrontLeftStopButton(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatFrontLeftStopButton(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatFrontRightStopButton(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(5, dSICarSeatListener);
                    dSICarSeatListener.updateSeatFrontRightStopButton(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatFrontRightStopButton(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatRearLeftStopButton(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(36, dSICarSeatListener);
                    dSICarSeatListener.updateSeatRearLeftStopButton(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatRearLeftStopButton(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatRearRightStopButton(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(37, dSICarSeatListener);
                    dSICarSeatListener.updateSeatRearRightStopButton(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatRearRightStopButton(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatCodriverSettingsFromDriver(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(6, dSICarSeatListener);
                    dSICarSeatListener.updateSeatCodriverSettingsFromDriver(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatCodriverSettingsFromDriver(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatCodriverSettingsFromRear(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(7, dSICarSeatListener);
                    dSICarSeatListener.updateSeatCodriverSettingsFromRear(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatCodriverSettingsFromRear(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatMassageData1RL(MassageData massageData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(8, dSICarSeatListener);
                    dSICarSeatListener.updateSeatMassageData1RL(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatMassageData1RL(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatMassageData1RR(MassageData massageData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(9, dSICarSeatListener);
                    dSICarSeatListener.updateSeatMassageData1RR(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatMassageData1RR(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatMassageData2RL(MassageData massageData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(38, dSICarSeatListener);
                    dSICarSeatListener.updateSeatMassageData2RL(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatMassageData2RL(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatMassageData2RR(MassageData massageData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(39, dSICarSeatListener);
                    dSICarSeatListener.updateSeatMassageData2RR(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatMassageData2RR(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatSwitcherDataUp1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(10, dSICarSeatListener);
                    dSICarSeatListener.updateSeatSwitcherDataUp1RL(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatSwitcherDataUp1RL(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatSwitcherDataDown1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(11, dSICarSeatListener);
                    dSICarSeatListener.updateSeatSwitcherDataDown1RL(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatSwitcherDataDown1RL(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatSwitcherDataForward1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(12, dSICarSeatListener);
                    dSICarSeatListener.updateSeatSwitcherDataForward1RL(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatSwitcherDataForward1RL(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatSwitcherDataBack1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(13, dSICarSeatListener);
                    dSICarSeatListener.updateSeatSwitcherDataBack1RL(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatSwitcherDataBack1RL(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatSwitcherDataUp1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(14, dSICarSeatListener);
                    dSICarSeatListener.updateSeatSwitcherDataUp1RR(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatSwitcherDataUp1RR(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatSwitcherDataDown1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(15, dSICarSeatListener);
                    dSICarSeatListener.updateSeatSwitcherDataDown1RR(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatSwitcherDataDown1RR(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatSwitcherDataForward1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(16, dSICarSeatListener);
                    dSICarSeatListener.updateSeatSwitcherDataForward1RR(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatSwitcherDataForward1RR(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatSwitcherDataBack1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(17, dSICarSeatListener);
                    dSICarSeatListener.updateSeatSwitcherDataBack1RR(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatSwitcherDataBack1RR(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatSwitcherDataUp2RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(40, dSICarSeatListener);
                    dSICarSeatListener.updateSeatSwitcherDataUp2RL(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatSwitcherDataUp2RL(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatSwitcherDataDown2RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(41, dSICarSeatListener);
                    dSICarSeatListener.updateSeatSwitcherDataDown2RL(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatSwitcherDataDown2RL(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatSwitcherDataForward2RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(42, dSICarSeatListener);
                    dSICarSeatListener.updateSeatSwitcherDataForward2RL(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatSwitcherDataForward2RL(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatSwitcherDataBack2RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(43, dSICarSeatListener);
                    dSICarSeatListener.updateSeatSwitcherDataBack2RL(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatSwitcherDataBack2RL(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatSwitcherDataUp2RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(44, dSICarSeatListener);
                    dSICarSeatListener.updateSeatSwitcherDataUp2RR(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatSwitcherDataUp2RR(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatSwitcherDataDown2RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(45, dSICarSeatListener);
                    dSICarSeatListener.updateSeatSwitcherDataDown2RR(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatSwitcherDataDown2RR(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatSwitcherDataForward2RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(46, dSICarSeatListener);
                    dSICarSeatListener.updateSeatSwitcherDataForward2RR(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatSwitcherDataForward2RR(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatSwitcherDataBack2RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(47, dSICarSeatListener);
                    dSICarSeatListener.updateSeatSwitcherDataBack2RR(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatSwitcherDataBack2RR(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatContent(SeatContent seatContent, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(18, dSICarSeatListener);
                    dSICarSeatListener.updateSeatContent(seatContent, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatContent(seatContent, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatEasyEntryFrontLeft(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(19, dSICarSeatListener);
                    dSICarSeatListener.updateSeatEasyEntryFrontLeft(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatEasyEntryFrontLeft(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatEasyEntryFrontRight(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(20, dSICarSeatListener);
                    dSICarSeatListener.updateSeatEasyEntryFrontRight(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatEasyEntryFrontRight(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatEasyEntryRearLeft(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(21, dSICarSeatListener);
                    dSICarSeatListener.updateSeatEasyEntryRearLeft(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatEasyEntryRearLeft(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatEasyEntryRearRight(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(22, dSICarSeatListener);
                    dSICarSeatListener.updateSeatEasyEntryRearRight(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatEasyEntryRearRight(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestSeatPopup(SeatContent seatContent) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)objectArray[i2];
                    dSICarSeatListener.requestSeatPopup(seatContent);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeSeatPopup(SeatContent seatContent) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)objectArray[i2];
                    dSICarSeatListener.acknowledgeSeatPopup(seatContent);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPneumaticViewOptions(SeatPneumaticViewOptions seatPneumaticViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(23, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPneumaticViewOptions(seatPneumaticViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPneumaticViewOptions(seatPneumaticViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPneumaticCodriverSettingsFromDriver(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(24, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPneumaticCodriverSettingsFromDriver(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPneumaticCodriverSettingsFromDriver(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPneumaticMassageData1RL(MassageData massageData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(25, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPneumaticMassageData1RL(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPneumaticMassageData1RL(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPneumaticMassageData1RR(MassageData massageData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(26, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPneumaticMassageData1RR(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPneumaticMassageData1RR(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataUp1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(27, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPneumaticSwitcherDataUp1RL(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPneumaticSwitcherDataUp1RL(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataDown1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(28, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPneumaticSwitcherDataDown1RL(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPneumaticSwitcherDataDown1RL(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataForward1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(29, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPneumaticSwitcherDataForward1RL(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPneumaticSwitcherDataForward1RL(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataBack1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(30, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPneumaticSwitcherDataBack1RL(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPneumaticSwitcherDataBack1RL(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataUp1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(31, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPneumaticSwitcherDataUp1RR(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPneumaticSwitcherDataUp1RR(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataDown1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(32, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPneumaticSwitcherDataDown1RR(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPneumaticSwitcherDataDown1RR(switcherDataUpDown, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataForward1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(33, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPneumaticSwitcherDataForward1RR(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPneumaticSwitcherDataForward1RR(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPneumaticSwitcherDataBack1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(34, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPneumaticSwitcherDataBack1RR(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPneumaticSwitcherDataBack1RR(switcherDataBackForward, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPneumaticContent(SeatPneumaticContent seatPneumaticContent, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(35, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPneumaticContent(seatPneumaticContent, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPneumaticContent(seatPneumaticContent, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)objectArray[i2];
                    dSICarSeatListener.requestSeatPneumaticPopup(seatPneumaticContent);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)objectArray[i2];
                    dSICarSeatListener.acknowledgeSeatPneumaticPopup(seatPneumaticContent);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeSeatSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)objectArray[i2];
                    dSICarSeatListener.acknowledgeSeatSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeSeatPneumaticSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)objectArray[i2];
                    dSICarSeatListener.acknowledgeSeatPneumaticSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeSeatDeleteSpecialPosition(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)objectArray[i2];
                    dSICarSeatListener.acknowledgeSeatDeleteSpecialPosition(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeSeatMoveRearSeatDisplay(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)objectArray[i2];
                    dSICarSeatListener.acknowledgeSeatMoveRearSeatDisplay(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatAdjustment1RL(SeatAdjustment seatAdjustment, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(48, dSICarSeatListener);
                    dSICarSeatListener.updateSeatAdjustment1RL(seatAdjustment, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatAdjustment1RL(seatAdjustment, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatAdjustment1RR(SeatAdjustment seatAdjustment, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(49, dSICarSeatListener);
                    dSICarSeatListener.updateSeatAdjustment1RR(seatAdjustment, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatAdjustment1RR(seatAdjustment, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatAdjustment2RL(SeatAdjustment seatAdjustment, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(50, dSICarSeatListener);
                    dSICarSeatListener.updateSeatAdjustment2RL(seatAdjustment, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatAdjustment2RL(seatAdjustment, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatAdjustment2RR(SeatAdjustment seatAdjustment, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(51, dSICarSeatListener);
                    dSICarSeatListener.updateSeatAdjustment2RR(seatAdjustment, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatAdjustment2RR(seatAdjustment, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatCoDriverSettingsFromRearActivation(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(53);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(53, dSICarSeatListener);
                    dSICarSeatListener.updateSeatCoDriverSettingsFromRearActivation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(53);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatCoDriverSettingsFromRearActivation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatRestSeatStatus(RestSeatStatus restSeatStatus, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(54, dSICarSeatListener);
                    dSICarSeatListener.updateSeatRestSeatStatus(restSeatStatus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatRestSeatStatus(restSeatStatus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatFoldHeadRestRearDriver(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(55);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(55, dSICarSeatListener);
                    dSICarSeatListener.updateSeatFoldHeadRestRearDriver(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(55);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatFoldHeadRestRearDriver(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatFoldHeadRestRearCoDriver(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(56);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(56, dSICarSeatListener);
                    dSICarSeatListener.updateSeatFoldHeadRestRearCoDriver(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(56);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatFoldHeadRestRearCoDriver(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPremiumMassageData1RL(MassageData massageData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(57);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(57, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPremiumMassageData1RL(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(57);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPremiumMassageData1RL(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPremiumMassageData1RR(MassageData massageData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(58);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(58, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPremiumMassageData1RR(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(58);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPremiumMassageData1RR(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPremiumMassageData2RL(MassageData massageData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(59);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(59, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPremiumMassageData2RL(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(59);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPremiumMassageData2RL(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPremiumMassageData2RR(MassageData massageData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(60);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(60, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPremiumMassageData2RR(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(60);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPremiumMassageData2RR(massageData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPremiumMassageSwitcher1RL(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(61);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(61, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPremiumMassageSwitcher1RL(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(61);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPremiumMassageSwitcher1RL(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPremiumMassageSwitcher1RR(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(62);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(62, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPremiumMassageSwitcher1RR(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(62);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPremiumMassageSwitcher1RR(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPremiumMassageSwitcher2RL(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(63);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(63, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPremiumMassageSwitcher2RL(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(63);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPremiumMassageSwitcher2RL(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatPremiumMassageSwitcher2RR(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(64);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(64, dSICarSeatListener);
                    dSICarSeatListener.updateSeatPremiumMassageSwitcher2RR(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(64);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatPremiumMassageSwitcher2RR(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatMassageSwitcher1RL(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(65);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(65, dSICarSeatListener);
                    dSICarSeatListener.updateSeatMassageSwitcher1RL(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(65);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatMassageSwitcher1RL(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatMassageSwitcher1RR(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(66);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(66, dSICarSeatListener);
                    dSICarSeatListener.updateSeatMassageSwitcher1RR(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(66);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatMassageSwitcher1RR(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatMassageSwitcher2RL(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(67);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(67, dSICarSeatListener);
                    dSICarSeatListener.updateSeatMassageSwitcher2RL(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(67);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatMassageSwitcher2RL(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeatMassageSwitcher2RR(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(68);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    this.confirmNotificationListener(68, dSICarSeatListener);
                    dSICarSeatListener.updateSeatMassageSwitcher2RR(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(68);
            while (iterator.hasNext()) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)iterator.next();
                    dSICarSeatListener.updateSeatMassageSwitcher2RR(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)objectArray[i2];
                    dSICarSeatListener.asyncException(n, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void yyIndication(String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarSeatListener dSICarSeatListener = (DSICarSeatListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICarSeatDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICarSeatDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICarSeatListener, new Object[]{string, string2});
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

