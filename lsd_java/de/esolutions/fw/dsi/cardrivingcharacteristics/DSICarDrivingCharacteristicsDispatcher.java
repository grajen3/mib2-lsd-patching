/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.cardrivingcharacteristics;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.DSICarDrivingCharacteristicsReply;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.DSICarDrivingCharacteristicsReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener;
import org.dsi.ifc.cardrivingcharacteristics.SoundViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerState;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlActuatorInfo;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlAirProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlDRCProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlHeightInfo;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlOperationMessages;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControleABCPreview;
import org.dsi.ifc.cardrivingcharacteristics.TADVehicleInfo;
import org.dsi.ifc.cardrivingcharacteristics.TADViewOptions;

public class DSICarDrivingCharacteristicsDispatcher
extends AbstractDispatcher
implements DSICarDrivingCharacteristicsReply {
    private DSICarDrivingCharacteristicsReplyService service = new DSICarDrivingCharacteristicsReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICarDrivingCharacteristicsDispatcher(int n) {
        super(n, (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener == null ? (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener = DSICarDrivingCharacteristicsDispatcher.class$("org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener")) : class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateSuspensionControlViewOptions(SuspensionControlViewOptions suspensionControlViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(1, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlViewOptions(suspensionControlViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlViewOptions(suspensionControlViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSuspensionControlLiftMode(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(2, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlLiftMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlLiftMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSuspensionControlCarJackMode(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(3, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlCarJackMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlCarJackMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSuspensionControlTrailerMode(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(4, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlTrailerMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlTrailerMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSuspensionControlLoadingMode(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(5, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlLoadingMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlLoadingMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSuspensionControlActiveProfile(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(6, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlActiveProfile(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlActiveProfile(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSuspensionControlAccessibleAirProfiles(SuspensionControlAirProfiles suspensionControlAirProfiles, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(7, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlAccessibleAirProfiles(suspensionControlAirProfiles, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlAccessibleAirProfiles(suspensionControlAirProfiles, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSuspensionControlAccessibleDRCProfiles(SuspensionControlDRCProfiles suspensionControlDRCProfiles, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(8, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlAccessibleDRCProfiles(suspensionControlDRCProfiles, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlAccessibleDRCProfiles(suspensionControlDRCProfiles, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSuspensionControlVehicleStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(9, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlVehicleStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlVehicleStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSuspensionControlCurrentLevel(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(29, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlCurrentLevel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlCurrentLevel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSuspensionControlTargetLevel(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(30, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlTargetLevel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlTargetLevel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSuspensionControlHeightInfo(SuspensionControlHeightInfo suspensionControlHeightInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(31, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlHeightInfo(suspensionControlHeightInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlHeightInfo(suspensionControlHeightInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSuspensionControlOperationMessages(SuspensionControlOperationMessages suspensionControlOperationMessages, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(32, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlOperationMessages(suspensionControlOperationMessages, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlOperationMessages(suspensionControlOperationMessages, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSuspensionControlSnowChainMode(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(39, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlSnowChainMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlSnowChainMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSuspensionControlVehicleStateControl(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(40, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlVehicleStateControl(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlVehicleStateControl(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSuspensionControlActiveMode(int n, boolean bl, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(46, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlActiveMode(n, bl, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlActiveMode(n, bl, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateeABCEasyEntry(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(47, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateeABCEasyEntry(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateeABCEasyEntry(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateeABCPitchControl(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(48, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateeABCPitchControl(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateeABCPitchControl(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateeABCSpecialPosition(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(49, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateeABCSpecialPosition(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateeABCSpecialPosition(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateeABCPreview(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(50, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateeABCPreview(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateeABCPreview(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateeABCPreviewState(SuspensionControleABCPreview suspensionControleABCPreview, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(51, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateeABCPreviewState(suspensionControleABCPreview, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateeABCPreviewState(suspensionControleABCPreview, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSuspensionControlActuatorInfo(SuspensionControlActuatorInfo suspensionControlActuatorInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(52, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlActuatorInfo(suspensionControlActuatorInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSuspensionControlActuatorInfo(suspensionControlActuatorInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCharismaViewOptions(CharismaViewOptions charismaViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(12, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateCharismaViewOptions(charismaViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateCharismaViewOptions(charismaViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCharismaActiveProfile(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(13, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateCharismaActiveProfile(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateCharismaActiveProfile(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCharismaActiveOperationMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(28, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateCharismaActiveOperationMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateCharismaActiveOperationMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCharismaListUpdateInfo(CharismaListUpdateInfo charismaListUpdateInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(14, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateCharismaListUpdateInfo(charismaListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateCharismaListUpdateInfo(charismaListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCharismaContent(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(15, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateCharismaContent(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateCharismaContent(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCharismaTrailerDetection(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(16, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateCharismaTrailerDetection(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateCharismaTrailerDetection(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCharismaTrailerSetting(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(17, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateCharismaTrailerSetting(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateCharismaTrailerSetting(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCharismaProgButton(CharismaProgButton charismaProgButton, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(18, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateCharismaProgButton(charismaProgButton, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateCharismaProgButton(charismaProgButton, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseCharismaListWithOptionMask(int n, int n2, int n3, CharismaSetupTableWithOptionMask[] charismaSetupTableWithOptionMaskArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)objectArray[i2];
                    dSICarDrivingCharacteristicsListener.responseCharismaListWithOptionMask(n, n2, n3, charismaSetupTableWithOptionMaskArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseCharismaListWithoutOptionMask(int n, int n2, int n3, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)objectArray[i2];
                    dSICarDrivingCharacteristicsListener.responseCharismaListWithoutOptionMask(n, n2, n3, charismaSetupTableWithoutOptionMaskArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestCharismaPopup(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)objectArray[i2];
                    dSICarDrivingCharacteristicsListener.requestCharismaPopup(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeCharismaPopup(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)objectArray[i2];
                    dSICarDrivingCharacteristicsListener.acknowledgeCharismaPopup(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeCharismaSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)objectArray[i2];
                    dSICarDrivingCharacteristicsListener.acknowledgeCharismaSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCharismaSound(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(45, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateCharismaSound(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateCharismaSound(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTADViewOptions(TADViewOptions tADViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(19, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateTADViewOptions(tADViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateTADViewOptions(tADViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTADContent(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(20, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateTADContent(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateTADContent(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestTADPopup(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)objectArray[i2];
                    dSICarDrivingCharacteristicsListener.requestTADPopup(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeTADPopup(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)objectArray[i2];
                    dSICarDrivingCharacteristicsListener.acknowledgeTADPopup(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeTADSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)objectArray[i2];
                    dSICarDrivingCharacteristicsListener.acknowledgeTADSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeTADMaxMinAngleReset(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)objectArray[i2];
                    dSICarDrivingCharacteristicsListener.acknowledgeTADMaxMinAngleReset(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTADVehicleInfo(TADVehicleInfo tADVehicleInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(21, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateTADVehicleInfo(tADVehicleInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateTADVehicleInfo(tADVehicleInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTADCurrentRollAngle(float f2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(22, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateTADCurrentRollAngle(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateTADCurrentRollAngle(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTADCurrentPitchAngle(float f2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(23, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateTADCurrentPitchAngle(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateTADCurrentPitchAngle(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTADPosMaxRollAngle(float f2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(24, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateTADPosMaxRollAngle(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateTADPosMaxRollAngle(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTADNegMaxRollAngle(float f2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(25, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateTADNegMaxRollAngle(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateTADNegMaxRollAngle(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTADPosMaxPitchAngle(float f2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(26, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateTADPosMaxPitchAngle(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateTADPosMaxPitchAngle(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTADNegMaxPitchAngle(float f2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(27, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateTADNegMaxPitchAngle(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateTADNegMaxPitchAngle(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSpoilerViewOptions(SpoilerViewOptions spoilerViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(33, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSpoilerViewOptions(spoilerViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSpoilerViewOptions(spoilerViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSpoilerPositionSelection(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(34, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSpoilerPositionSelection(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSpoilerPositionSelection(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSpoilerState(SpoilerState spoilerState, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(35, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSpoilerState(spoilerState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSpoilerState(spoilerState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSpoilerActuation(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(36, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSpoilerActuation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSpoilerActuation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSpoilerMessages(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(37, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSpoilerMessages(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSpoilerMessages(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSpoilerSystemOnOff(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(38, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSpoilerSystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSpoilerSystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeSpoilerSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)objectArray[i2];
                    dSICarDrivingCharacteristicsListener.acknowledgeSpoilerSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoundViewOptions(SoundViewOptions soundViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(41, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSoundViewOptions(soundViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSoundViewOptions(soundViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoundStyle(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(44, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSoundStyle(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSoundStyle(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoundSystemOnOff(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(42, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSoundSystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSoundSystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoundOnOff(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    this.confirmNotificationListener(43, dSICarDrivingCharacteristicsListener);
                    dSICarDrivingCharacteristicsListener.updateSoundOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)iterator.next();
                    dSICarDrivingCharacteristicsListener.updateSoundOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeSoundSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)objectArray[i2];
                    dSICarDrivingCharacteristicsListener.acknowledgeSoundSetFactoryDefault(bl);
                    continue;
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
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)objectArray[i2];
                    dSICarDrivingCharacteristicsListener.asyncException(n, string, n2);
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
                    DSICarDrivingCharacteristicsListener dSICarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICarDrivingCharacteristicsDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICarDrivingCharacteristicsDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICarDrivingCharacteristicsListener, new Object[]{string, string2});
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

