/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carlight;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.carlight.DSICarLightReply;
import de.esolutions.fw.comm.dsi.carlight.impl.DSICarLightReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.carlight.DSICarLightListener;
import org.dsi.ifc.carlight.ExtLightLampErrorDetectionState;
import org.dsi.ifc.carlight.ExtLightLampErrorDetectionStateTrailer;
import org.dsi.ifc.carlight.ExtLightSensorErrorDetectionState;
import org.dsi.ifc.carlight.ExtLightViewOptions;
import org.dsi.ifc.carlight.IntLightBrightness;
import org.dsi.ifc.carlight.IntLightRGBColorListRA0;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBValues;
import org.dsi.ifc.carlight.IntLightViewOptions;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;
import org.dsi.ifc.carlight.TimeState;

public class DSICarLightDispatcher
extends AbstractDispatcher
implements DSICarLightReply {
    private DSICarLightReplyService service = new DSICarLightReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$carlight$DSICarLightListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICarLightDispatcher(int n) {
        super(n, (class$org$dsi$ifc$carlight$DSICarLightListener == null ? (class$org$dsi$ifc$carlight$DSICarLightListener = DSICarLightDispatcher.class$("org.dsi.ifc.carlight.DSICarLightListener")) : class$org$dsi$ifc$carlight$DSICarLightListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateIntLightViewOptions(IntLightViewOptions intLightViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(1, dSICarLightListener);
                    dSICarLightListener.updateIntLightViewOptions(intLightViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightViewOptions(intLightViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightIlluminationSet1(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(29, dSICarLightListener);
                    dSICarLightListener.updateIntLightIlluminationSet1(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightIlluminationSet1(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightIlluminationSet2(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(30, dSICarLightListener);
                    dSICarLightListener.updateIntLightIlluminationSet2(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightIlluminationSet2(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightIlluminationSet3(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(31, dSICarLightListener);
                    dSICarLightListener.updateIntLightIlluminationSet3(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightIlluminationSet3(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightIlluminationSet4(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(32, dSICarLightListener);
                    dSICarLightListener.updateIntLightIlluminationSet4(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightIlluminationSet4(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightIlluminationSet5(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(33, dSICarLightListener);
                    dSICarLightListener.updateIntLightIlluminationSet5(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightIlluminationSet5(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightIlluminationSet6(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(34, dSICarLightListener);
                    dSICarLightListener.updateIntLightIlluminationSet6(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightIlluminationSet6(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightIlluminationSet7(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(35, dSICarLightListener);
                    dSICarLightListener.updateIntLightIlluminationSet7(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightIlluminationSet7(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightIlluminationSet8(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(36, dSICarLightListener);
                    dSICarLightListener.updateIntLightIlluminationSet8(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightIlluminationSet8(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightTemperature(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(11, dSICarLightListener);
                    dSICarLightListener.updateIntLightTemperature(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightTemperature(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightColour(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(7, dSICarLightListener);
                    dSICarLightListener.updateIntLightColour(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightColour(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(8, dSICarLightListener);
                    dSICarLightListener.updateIntLightState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightEnvironment(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(9, dSICarLightListener);
                    dSICarLightListener.updateIntLightEnvironment(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightEnvironment(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightSpeed(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(10, dSICarLightListener);
                    dSICarLightListener.updateIntLightSpeed(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightSpeed(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightBrightness(IntLightBrightness intLightBrightness, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(27, dSICarLightListener);
                    dSICarLightListener.updateIntLightBrightness(intLightBrightness, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightBrightness(intLightBrightness, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightIlluminationProfile1(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(37, dSICarLightListener);
                    dSICarLightListener.updateIntLightIlluminationProfile1(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightIlluminationProfile1(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightIlluminationProfile2(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(38, dSICarLightListener);
                    dSICarLightListener.updateIntLightIlluminationProfile2(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightIlluminationProfile2(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightIlluminationProfile3(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(39, dSICarLightListener);
                    dSICarLightListener.updateIntLightIlluminationProfile3(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightIlluminationProfile3(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightIlluminationProfile4(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(40, dSICarLightListener);
                    dSICarLightListener.updateIntLightIlluminationProfile4(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightIlluminationProfile4(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightIlluminationProfile5(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(41, dSICarLightListener);
                    dSICarLightListener.updateIntLightIlluminationProfile5(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightIlluminationProfile5(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightIlluminationProfile6(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(42, dSICarLightListener);
                    dSICarLightListener.updateIntLightIlluminationProfile6(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightIlluminationProfile6(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightIlluminationProfile7(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(43, dSICarLightListener);
                    dSICarLightListener.updateIntLightIlluminationProfile7(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightIlluminationProfile7(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightIlluminationProfile8(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(44, dSICarLightListener);
                    dSICarLightListener.updateIntLightIlluminationProfile8(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightIlluminationProfile8(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightActiveProfile(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(45, dSICarLightListener);
                    dSICarLightListener.updateIntLightActiveProfile(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightActiveProfile(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightAmbientLightColor(IntLightRGBValues intLightRGBValues, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(46, dSICarLightListener);
                    dSICarLightListener.updateIntLightAmbientLightColor(intLightRGBValues, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightAmbientLightColor(intLightRGBValues, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightContourLightColor(IntLightRGBValues intLightRGBValues, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(47, dSICarLightListener);
                    dSICarLightListener.updateIntLightContourLightColor(intLightRGBValues, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightContourLightColor(intLightRGBValues, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightFollowUpTime(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(48, dSICarLightListener);
                    dSICarLightListener.updateIntLightFollowUpTime(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightFollowUpTime(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightDoorContact(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(52, dSICarLightListener);
                    dSICarLightListener.updateIntLightDoorContact(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightDoorContact(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightRGBColorListUpdateInfo(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(49, dSICarLightListener);
                    dSICarLightListener.updateIntLightRGBColorListUpdateInfo(intLightRGBColorListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightRGBColorListUpdateInfo(intLightRGBColorListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntLightRGBColorListTotalNumberOfElements(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(50, dSICarLightListener);
                    dSICarLightListener.updateIntLightRGBColorListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateIntLightRGBColorListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseIntLightRGBColorListRA0(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, IntLightRGBColorListRA0[] intLightRGBColorListRA0Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)objectArray[i2];
                    dSICarLightListener.responseIntLightRGBColorListRA0(intLightRGBColorListUpdateInfo, intLightRGBColorListRA0Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseIntLightRGBColorListRAF(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)objectArray[i2];
                    dSICarLightListener.responseIntLightRGBColorListRAF(intLightRGBColorListUpdateInfo, nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateExtLightComingHome(TimeState timeState, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(13, dSICarLightListener);
                    dSICarLightListener.updateExtLightComingHome(timeState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateExtLightComingHome(timeState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateExtLightLeavingHome(TimeState timeState, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(14, dSICarLightListener);
                    dSICarLightListener.updateExtLightLeavingHome(timeState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateExtLightLeavingHome(timeState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateExtLightSwitchOnSensitivity(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(15, dSICarLightListener);
                    dSICarLightListener.updateExtLightSwitchOnSensitivity(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateExtLightSwitchOnSensitivity(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateExtLightDaylight(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(16, dSICarLightListener);
                    dSICarLightListener.updateExtLightDaylight(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateExtLightDaylight(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateExtLightTourist(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(17, dSICarLightListener);
                    dSICarLightListener.updateExtLightTourist(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateExtLightTourist(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateExtLightAdaptive(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(18, dSICarLightListener);
                    dSICarLightListener.updateExtLightAdaptive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateExtLightAdaptive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateExtLightHeadLightSystem(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(19, dSICarLightListener);
                    dSICarLightListener.updateExtLightHeadLightSystem(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateExtLightHeadLightSystem(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateExtLightGlidingSystem(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(20, dSICarLightListener);
                    dSICarLightListener.updateExtLightGlidingSystem(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateExtLightGlidingSystem(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateExtLightViewOptions(ExtLightViewOptions extLightViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(12, dSICarLightListener);
                    dSICarLightListener.updateExtLightViewOptions(extLightViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateExtLightViewOptions(extLightViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateExtLightMotorwayBlinking(MotorwayBlinkingSettings motorwayBlinkingSettings, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(21, dSICarLightListener);
                    dSICarLightListener.updateExtLightMotorwayBlinking(motorwayBlinkingSettings, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateExtLightMotorwayBlinking(motorwayBlinkingSettings, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateExtLightMaskedHighBeam(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(22, dSICarLightListener);
                    dSICarLightListener.updateExtLightMaskedHighBeam(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateExtLightMaskedHighBeam(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateExtLightLampErrorDetection(ExtLightLampErrorDetectionState[] extLightLampErrorDetectionStateArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(23, dSICarLightListener);
                    dSICarLightListener.updateExtLightLampErrorDetection(extLightLampErrorDetectionStateArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateExtLightLampErrorDetection(extLightLampErrorDetectionStateArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateExtLightLampErrorDetectionTrailer(ExtLightLampErrorDetectionStateTrailer[] extLightLampErrorDetectionStateTrailerArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(24, dSICarLightListener);
                    dSICarLightListener.updateExtLightLampErrorDetectionTrailer(extLightLampErrorDetectionStateTrailerArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateExtLightLampErrorDetectionTrailer(extLightLampErrorDetectionStateTrailerArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateExtLightSensorErrorDetection(ExtLightSensorErrorDetectionState[] extLightSensorErrorDetectionStateArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(25, dSICarLightListener);
                    dSICarLightListener.updateExtLightSensorErrorDetection(extLightSensorErrorDetectionStateArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateExtLightSensorErrorDetection(extLightSensorErrorDetectionStateArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateExtLightAutomaticLight(boolean bl, boolean bl2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(28, dSICarLightListener);
                    dSICarLightListener.updateExtLightAutomaticLight(bl, bl2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateExtLightAutomaticLight(bl, bl2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeIntLightSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)objectArray[i2];
                    dSICarLightListener.acknowledgeIntLightSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeExtLightSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)objectArray[i2];
                    dSICarLightListener.acknowledgeExtLightSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateExtLightLaserLight(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(51, dSICarLightListener);
                    dSICarLightListener.updateExtLightLaserLight(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateExtLightLaserLight(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateExtLightSignatureLight(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(53);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(53, dSICarLightListener);
                    dSICarLightListener.updateExtLightSignatureLight(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(53);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateExtLightSignatureLight(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateExtLightHeadlightRange(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    this.confirmNotificationListener(54, dSICarLightListener);
                    dSICarLightListener.updateExtLightHeadlightRange(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)iterator.next();
                    dSICarLightListener.updateExtLightHeadlightRange(n, n2);
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
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)objectArray[i2];
                    dSICarLightListener.asyncException(n, string, n2);
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
                    DSICarLightListener dSICarLightListener = (DSICarLightListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICarLightDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICarLightDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICarLightListener, new Object[]{string, string2});
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

