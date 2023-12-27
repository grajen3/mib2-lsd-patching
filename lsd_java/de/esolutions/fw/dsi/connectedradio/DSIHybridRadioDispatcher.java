/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.connectedradio;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.connectedradio.DSIHybridRadioReply;
import de.esolutions.fw.comm.dsi.connectedradio.impl.DSIHybridRadioReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.connectedradio.DSIHybridRadioListener;
import org.dsi.ifc.connectedradio.RadioStation;

public class DSIHybridRadioDispatcher
extends AbstractDispatcher
implements DSIHybridRadioReply {
    private DSIHybridRadioReplyService service = new DSIHybridRadioReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$connectedradio$DSIHybridRadioListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIHybridRadioDispatcher(int n) {
        super(n, (class$org$dsi$ifc$connectedradio$DSIHybridRadioListener == null ? (class$org$dsi$ifc$connectedradio$DSIHybridRadioListener = DSIHybridRadioDispatcher.class$("org.dsi.ifc.connectedradio.DSIHybridRadioListener")) : class$org$dsi$ifc$connectedradio$DSIHybridRadioListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void getOnlineRadioAvailabilityResult(int n, int n2, RadioStation[] radioStationArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIHybridRadioListener dSIHybridRadioListener = (DSIHybridRadioListener)objectArray[i2];
                    dSIHybridRadioListener.getOnlineRadioAvailabilityResult(n, n2, radioStationArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getRadioStationLogoResult(int n, int n2, RadioStation[] radioStationArray, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIHybridRadioListener dSIHybridRadioListener = (DSIHybridRadioListener)objectArray[i2];
                    dSIHybridRadioListener.getRadioStationLogoResult(n, n2, radioStationArray, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicateRadioStationLogoResult(int n, int n2, RadioStation[] radioStationArray, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIHybridRadioListener dSIHybridRadioListener = (DSIHybridRadioListener)objectArray[i2];
                    dSIHybridRadioListener.indicateRadioStationLogoResult(n, n2, radioStationArray, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getStreamResult(int n, int n2, RadioStation radioStation) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIHybridRadioListener dSIHybridRadioListener = (DSIHybridRadioListener)objectArray[i2];
                    dSIHybridRadioListener.getStreamResult(n, n2, radioStation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void startSlideshowResult(int n, int n2, RadioStation radioStation) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIHybridRadioListener dSIHybridRadioListener = (DSIHybridRadioListener)objectArray[i2];
                    dSIHybridRadioListener.startSlideshowResult(n, n2, radioStation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void stopSlideshowResult(int n, int n2, RadioStation radioStation) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIHybridRadioListener dSIHybridRadioListener = (DSIHybridRadioListener)objectArray[i2];
                    dSIHybridRadioListener.stopSlideshowResult(n, n2, radioStation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSlideshow(int n, RadioStation radioStation, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIHybridRadioListener dSIHybridRadioListener = (DSIHybridRadioListener)iterator.next();
                    this.confirmNotificationListener(1, dSIHybridRadioListener);
                    dSIHybridRadioListener.updateSlideshow(n, radioStation, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIHybridRadioListener dSIHybridRadioListener = (DSIHybridRadioListener)iterator.next();
                    dSIHybridRadioListener.updateSlideshow(n, radioStation, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRadioText(int n, RadioStation radioStation, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIHybridRadioListener dSIHybridRadioListener = (DSIHybridRadioListener)iterator.next();
                    this.confirmNotificationListener(2, dSIHybridRadioListener);
                    dSIHybridRadioListener.updateRadioText(n, radioStation, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIHybridRadioListener dSIHybridRadioListener = (DSIHybridRadioListener)iterator.next();
                    dSIHybridRadioListener.updateRadioText(n, radioStation, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void cancelGetRadioStationLogoResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIHybridRadioListener dSIHybridRadioListener = (DSIHybridRadioListener)objectArray[i2];
                    dSIHybridRadioListener.cancelGetRadioStationLogoResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIHybridRadioListener dSIHybridRadioListener = (DSIHybridRadioListener)iterator.next();
                    this.confirmNotificationListener(3, dSIHybridRadioListener);
                    dSIHybridRadioListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIHybridRadioListener dSIHybridRadioListener = (DSIHybridRadioListener)iterator.next();
                    dSIHybridRadioListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileChanged(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIHybridRadioListener dSIHybridRadioListener = (DSIHybridRadioListener)objectArray[i2];
                    dSIHybridRadioListener.profileChanged(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIHybridRadioListener dSIHybridRadioListener = (DSIHybridRadioListener)objectArray[i2];
                    dSIHybridRadioListener.profileCopied(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileReset(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIHybridRadioListener dSIHybridRadioListener = (DSIHybridRadioListener)objectArray[i2];
                    dSIHybridRadioListener.profileReset(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileResetAll(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIHybridRadioListener dSIHybridRadioListener = (DSIHybridRadioListener)objectArray[i2];
                    dSIHybridRadioListener.profileResetAll(n);
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
                    DSIHybridRadioListener dSIHybridRadioListener = (DSIHybridRadioListener)objectArray[i2];
                    dSIHybridRadioListener.asyncException(n, string, n2);
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
                    DSIHybridRadioListener dSIHybridRadioListener = (DSIHybridRadioListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIHybridRadioDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIHybridRadioDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIHybridRadioListener, new Object[]{string, string2});
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

