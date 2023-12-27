/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.sdars;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.sdars.DSISDARSSeekReply;
import de.esolutions.fw.comm.dsi.sdars.impl.DSISDARSSeekReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.sdars.DSISDARSSeekListener;
import org.dsi.ifc.sdars.LeagueEntry;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.TeamEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

public class DSISDARSSeekDispatcher
extends AbstractDispatcher
implements DSISDARSSeekReply {
    private DSISDARSSeekReplyService service = new DSISDARSSeekReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$sdars$DSISDARSSeekListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSISDARSSeekDispatcher(int n) {
        super(n, (class$org$dsi$ifc$sdars$DSISDARSSeekListener == null ? (class$org$dsi$ifc$sdars$DSISDARSSeekListener = DSISDARSSeekDispatcher.class$("org.dsi.ifc.sdars.DSISDARSSeekListener")) : class$org$dsi$ifc$sdars$DSISDARSSeekListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateSeekPossibility(SeekPossibility seekPossibility, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)iterator.next();
                    this.confirmNotificationListener(1, dSISDARSSeekListener);
                    dSISDARSSeekListener.updateSeekPossibility(seekPossibility, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)iterator.next();
                    dSISDARSSeekListener.updateSeekPossibility(seekPossibility, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeekList(SeekEntry[] seekEntryArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)iterator.next();
                    this.confirmNotificationListener(2, dSISDARSSeekListener);
                    dSISDARSSeekListener.updateSeekList(seekEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)iterator.next();
                    dSISDARSSeekListener.updateSeekList(seekEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLeagueList(LeagueEntry[] leagueEntryArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)iterator.next();
                    this.confirmNotificationListener(4, dSISDARSSeekListener);
                    dSISDARSSeekListener.updateLeagueList(leagueEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)iterator.next();
                    dSISDARSSeekListener.updateLeagueList(leagueEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTrafficWeatherList(TrafficWxEntry[] trafficWxEntryArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)iterator.next();
                    this.confirmNotificationListener(6, dSISDARSSeekListener);
                    dSISDARSSeekListener.updateTrafficWeatherList(trafficWxEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)iterator.next();
                    dSISDARSSeekListener.updateTrafficWeatherList(trafficWxEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSeekAlert(SeekAlert seekAlert, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)iterator.next();
                    this.confirmNotificationListener(3, dSISDARSSeekListener);
                    dSISDARSSeekListener.updateSeekAlert(seekAlert, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)iterator.next();
                    dSISDARSSeekListener.updateSeekAlert(seekAlert, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setSeekCommandResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)objectArray[i2];
                    dSISDARSSeekListener.setSeekCommandResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void manageSeekResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)objectArray[i2];
                    dSISDARSSeekListener.manageSeekResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void teamsOfLeague(TeamEntry[] teamEntryArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)objectArray[i2];
                    dSISDARSSeekListener.teamsOfLeague(teamEntryArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void leagues(LeagueEntry[] leagueEntryArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)objectArray[i2];
                    dSISDARSSeekListener.leagues(leagueEntryArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRegisteredTeams(TeamEntry[] teamEntryArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)iterator.next();
                    this.confirmNotificationListener(7, dSISDARSSeekListener);
                    dSISDARSSeekListener.updateRegisteredTeams(teamEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)iterator.next();
                    dSISDARSSeekListener.updateRegisteredTeams(teamEntryArray, n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)iterator.next();
                    this.confirmNotificationListener(8, dSISDARSSeekListener);
                    dSISDARSSeekListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)iterator.next();
                    dSISDARSSeekListener.updateProfileState(n, n2, n3);
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
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)objectArray[i2];
                    dSISDARSSeekListener.profileChanged(n, n2);
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
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)objectArray[i2];
                    dSISDARSSeekListener.profileCopied(n, n2, n3);
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
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)objectArray[i2];
                    dSISDARSSeekListener.profileReset(n, n2);
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
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)objectArray[i2];
                    dSISDARSSeekListener.profileResetAll(n);
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
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)objectArray[i2];
                    dSISDARSSeekListener.asyncException(n, string, n2);
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
                    DSISDARSSeekListener dSISDARSSeekListener = (DSISDARSSeekListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSISDARSSeekDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSISDARSSeekDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSISDARSSeekListener, new Object[]{string, string2});
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

