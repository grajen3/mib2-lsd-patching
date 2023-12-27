/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.startup;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.startup.DSIStartupReply;
import de.esolutions.fw.comm.dsi.startup.impl.DSIStartupReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.startup.DSIStartupListener;

public class DSIStartupDispatcher
extends AbstractDispatcher
implements DSIStartupReply {
    private DSIStartupReplyService service = new DSIStartupReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$startup$DSIStartupListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIStartupDispatcher(int n) {
        super(n, (class$org$dsi$ifc$startup$DSIStartupListener == null ? (class$org$dsi$ifc$startup$DSIStartupListener = DSIStartupDispatcher.class$("org.dsi.ifc.startup.DSIStartupListener")) : class$org$dsi$ifc$startup$DSIStartupListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateDomainStatusRoot(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(1, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusRoot(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusRoot(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusTuner(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(2, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusTuner(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusTuner(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusMedia(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(3, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusMedia(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusMedia(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusAddressbook(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(4, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusAddressbook(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusAddressbook(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusPhone(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(5, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusPhone(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusPhone(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusNav(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(6, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusNav(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusNav(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusInfo(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(7, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusInfo(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusInfo(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusCar(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(8, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusCar(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusCar(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusAudio(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(9, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusAudio(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusAudio(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusSDS(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(10, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusSDS(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusSDS(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusSWDL(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(11, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusSWDL(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusSWDL(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusEarlyApps(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(12, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusEarlyApps(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusEarlyApps(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusPostStartup(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(13, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusPostStartup(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusPostStartup(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusCommunication(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(14, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusCommunication(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusCommunication(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusIpServices(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(15, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusIpServices(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusIpServices(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusGEMMI(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(16, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusGEMMI(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusGEMMI(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusBapkombi(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(17, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusBapkombi(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusBapkombi(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusBluetooth(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(18, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusBluetooth(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusBluetooth(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusBrowser(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(19, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusBrowser(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusBrowser(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusExplorer(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(20, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusExplorer(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusExplorer(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusCalendar(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(21, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusCalendar(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusCalendar(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusPictureStore(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(22, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusPictureStore(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusPictureStore(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusStreetView(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(23, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusStreetView(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusStreetView(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusMobilityHorizon(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(24, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusMobilityHorizon(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusMobilityHorizon(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusExBoxM(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(25, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusExBoxM(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusExBoxM(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusMirrorLink(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(26, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusMirrorLink(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusMirrorLink(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusSFA(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(27, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusSFA(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusSFA(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusSearch(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(28, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusSearch(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusSearch(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusDiagnosis(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(29, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusDiagnosis(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusDiagnosis(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusAsiaLanguageSupport(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(30, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusAsiaLanguageSupport(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusAsiaLanguageSupport(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusExLAP(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(31, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusExLAP(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusExLAP(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusTVTuner(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(32, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusTVTuner(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusTVTuner(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusMediaOnline(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(33, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusMediaOnline(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusMediaOnline(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusMediaRouter(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(34, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusMediaRouter(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusMediaRouter(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusRadioDataServer(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(35, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusRadioDataServer(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusRadioDataServer(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusSmartphoneIntegration(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(36, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusSmartphoneIntegration(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusSmartphoneIntegration(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDomainStatusWirelessCharger(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    this.confirmNotificationListener(37, dSIStartupListener);
                    dSIStartupListener.updateDomainStatusWirelessCharger(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)iterator.next();
                    dSIStartupListener.updateDomainStatusWirelessCharger(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void startDomain(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)objectArray[i2];
                    dSIStartupListener.startDomain(n, n2);
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
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)objectArray[i2];
                    dSIStartupListener.asyncException(n, string, n2);
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
                    DSIStartupListener dSIStartupListener = (DSIStartupListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIStartupDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIStartupDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIStartupListener, new Object[]{string, string2});
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

