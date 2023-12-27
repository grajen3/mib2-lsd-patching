/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.generalvehiclestates;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.generalvehiclestates.DSIGeneralVehicleStatesReply;
import de.esolutions.fw.comm.dsi.generalvehiclestates.impl.DSIGeneralVehicleStatesReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.generalvehiclestates.AirbagData;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener;
import org.dsi.ifc.generalvehiclestates.TLOViewOptions;
import org.dsi.ifc.generalvehiclestates.TankInfo;
import org.dsi.ifc.global.CarViewOption;

public class DSIGeneralVehicleStatesDispatcher
extends AbstractDispatcher
implements DSIGeneralVehicleStatesReply {
    private DSIGeneralVehicleStatesReplyService service = new DSIGeneralVehicleStatesReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIGeneralVehicleStatesDispatcher(int n) {
        super(n, (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = DSIGeneralVehicleStatesDispatcher.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateAirbagData(AirbagData airbagData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(2, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateAirbagData(airbagData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateAirbagData(airbagData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTankInfo(TankInfo tankInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(4, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateTankInfo(tankInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateTankInfo(tankInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDimmedHeadlight(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(5, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateDimmedHeadlight(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateDimmedHeadlight(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAcousticParkingSystem(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(6, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateAcousticParkingSystem(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateAcousticParkingSystem(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateReverseGear(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(20, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateReverseGear(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateReverseGear(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVehicleStandstill(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(22, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateVehicleStandstill(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateVehicleStandstill(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCarVelocityThreshold(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(7, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateCarVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateCarVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTVVelocityThreshold(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(8, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateTVVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateTVVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHDDVelocityThreshold(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(9, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateHDDVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateHDDVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBrowserSlideShowVelocityThreshold(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(10, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateBrowserSlideShowVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateBrowserSlideShowVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBrowserBordBookVelocityThreshold(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(11, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateBrowserBordBookVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateBrowserBordBookVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBrowserTravelAgentVelocityThreshold(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(12, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateBrowserTravelAgentVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateBrowserTravelAgentVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBrowserWebVelocityThreshold(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(13, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateBrowserWebVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateBrowserWebVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBWSVelocityThreshold(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(14, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateBWSVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateBWSVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRadiotextVelocityThreshold(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(15, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateRadiotextVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateRadiotextVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDisplayDayNightDesign(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(16, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateDisplayDayNightDesign(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateDisplayDayNightDesign(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBTBondingVelocityThreshold(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(17, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateBTBondingVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateBTBondingVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMessagingVelocityThreshold(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(18, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateMessagingVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateMessagingVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDestinationInputVelocityThreshold(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(19, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateDestinationInputVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateDestinationInputVelocityThreshold(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDSSSViewOption(CarViewOption carViewOption, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(21, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateDSSSViewOption(carViewOption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateDSSSViewOption(carViewOption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateServiceKeyData(byte[] byArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(23, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateServiceKeyData(byArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateServiceKeyData(byArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateServiceKeyViewOption(CarViewOption carViewOption, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(24, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateServiceKeyViewOption(carViewOption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateServiceKeyViewOption(carViewOption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePersonalizationStatus(boolean bl, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(25, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updatePersonalizationStatus(bl, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updatePersonalizationStatus(bl, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTLOViewOptions(TLOViewOptions tLOViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(26, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateTLOViewOptions(tLOViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateTLOViewOptions(tLOViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEmergencyAssistVolLowering(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(27, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateEmergencyAssistVolLowering(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateEmergencyAssistVolLowering(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateParkingBrake(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(28, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateParkingBrake(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateParkingBrake(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAppConnectTrigger(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(30, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateAppConnectTrigger(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateAppConnectTrigger(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSTPState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(31, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateSTPState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateSTPState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAutomaticGearShiftTransMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    this.confirmNotificationListener(32, dSIGeneralVehicleStatesListener);
                    dSIGeneralVehicleStatesListener.updateAutomaticGearShiftTransMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)iterator.next();
                    dSIGeneralVehicleStatesListener.updateAutomaticGearShiftTransMode(n, n2);
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
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)objectArray[i2];
                    dSIGeneralVehicleStatesListener.asyncException(n, string, n2);
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
                    DSIGeneralVehicleStatesListener dSIGeneralVehicleStatesListener = (DSIGeneralVehicleStatesListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIGeneralVehicleStatesDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIGeneralVehicleStatesDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIGeneralVehicleStatesListener, new Object[]{string, string2});
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

