/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.debug;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.sdars.debug.namedb.INameDb;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.SeekInformation;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.StationInfo;

public final class SatLogHandler {
    private static final int PRINT_CHANNEL_STAT_ALL;
    private static final int PRINT_BC;
    private static final String STR;
    private INameDb mNameDb;
    private final SatDb mDb;
    private int mLogCount = 0;
    private boolean mLogBcActive = false;
    private static final int VERSION;
    private static final String DELIVER;
    private static final String ARBEITSPAKET;
    private static long mTimestampFirstChannellist;
    private static int mChannelListUpdateCount;

    public SatLogHandler(SatDb satDb) {
        this.mDb = satDb;
    }

    public void initialize(INameDb iNameDb) {
        this.mNameDb = iNameDb;
    }

    public void printUnusedEvent(EventGeneric eventGeneric) {
        LogMessage logMessage = this.getLogMsg();
        if (logMessage != null && this.mNameDb != null) {
            logMessage.append("Event: -").append(this.mNameDb.getName(10, eventGeneric.getReceiverEventId())).log();
        }
    }

    public void printChannelStatistic() {
        LogMessage logMessage;
        if (mTimestampFirstChannellist == 0L) {
            mTimestampFirstChannellist = ServiceManager.timerManager.getSystemTimeMillis();
        }
        if ((++mChannelListUpdateCount == 1 || mChannelListUpdateCount % 20 == 0) && (logMessage = this.getLogMsg()) != null) {
            long l = (ServiceManager.timerManager.getSystemTimeMillis() - mTimestampFirstChannellist) / 0;
            long l2 = l != 0L ? (long)mChannelListUpdateCount / l : 1L;
            logMessage.append("ChannelUpdates: ").append(mChannelListUpdateCount).append(" times in ").append(l).append(" seconds ( ").append(l2).append(" per second )").log();
        }
    }

    public LogMessage dumpChannel(LogMessage logMessage, StationInfo stationInfo) {
        return logMessage.append("Channel ").append(stationInfo.stationNumber).append(": ").append(stationInfo.fullLabel).append(" (Cat=").append(stationInfo.categoryNumber).append(")");
    }

    public void logChannelList(StationInfo[] stationInfoArray) {
        LogMessage logMessage = this.getLogMsg();
        if (logMessage != null) {
            logMessage.append("RADIO_SAT_CHANNEL_LIST_ITEM_INFO: ").log();
            for (int i2 = 0; i2 < stationInfoArray.length; ++i2) {
                logMessage = this.getLogMsg();
                if (logMessage == null) continue;
                this.dumpChannel(logMessage, stationInfoArray[i2]).log();
            }
        }
    }

    public LogMessage dumpCategory(LogMessage logMessage, CategoryInfo categoryInfo) {
        return logMessage.append("Category ").append(categoryInfo.categoryNumber).append(": ").append(categoryInfo.fullLabel);
    }

    public void logChannel(SatDb satDb, String string, StationInfo stationInfo) {
        SatLogHandler satLogHandler = satDb.getLogHandler();
        LogMessage logMessage = satLogHandler.getLogMsg();
        if (logMessage != null) {
            logMessage.append(string);
            logMessage.append(": Station: [ID=");
            logMessage.append(stationInfo.stationNumber);
            logMessage.append("][Full=");
            logMessage.append(stationInfo.fullLabel);
            logMessage.append("][Short=");
            logMessage.append(stationInfo.shortLabel);
            logMessage.append("][Category=");
            logMessage.append(stationInfo.categoryNumber);
            String string2 = satDb.getCategories().getLabel(stationInfo.getCategoryNumber());
            if (string2 != null) {
                logMessage.append("(");
                logMessage.append(string2);
                logMessage.append(")");
            }
            logMessage.append("][Subsc.=");
            logMessage.append(stationInfo.subscription);
            logMessage.append("][SID=");
            logMessage.append(stationInfo.sID);
            logMessage.append("]");
            logMessage.log();
        }
    }

    public void simpleTrace(String string) {
        LogMessage logMessage = this.getLogMsg();
        if (logMessage != null) {
            logMessage.append(string).log();
        }
    }

    public LogMessage getLogMsg() {
        Logger logger = SatDb.getLogger();
        if (logger != null && logger.isTraceEnabled(512)) {
            if (!this.mLogBcActive) {
                ++this.mLogCount;
                if (this.mLogCount % 50 == 0) {
                    this.logBC();
                }
            }
            return logger.trace(512).append("||--SDARS: ");
        }
        return null;
    }

    public LogMessage logError() {
        return SatDb.getLogger().error(512).append("||--SDARS: ");
    }

    private void logSeekInfoType(SeekInformation seekInformation, LogMessage logMessage) {
        int n = seekInformation.getSeekInfo();
        String string = this.mNameDb == null ? "" : this.mNameDb.getName(4, n);
        logMessage.append(" --- Type=").append(string).append(" \"").append(seekInformation.getSeekText()).append("\"");
    }

    public void logSeekPossibilities(SeekPossibility seekPossibility) {
        LogMessage logMessage = this.getLogMsg();
        if (logMessage != null) {
            logMessage.append("DSI UPDATE SEEK POSSIBILITY:");
            if (seekPossibility == null) {
                logMessage.append(" null!");
            } else {
                SeekInformation[] seekInformationArray = seekPossibility.getSeekInformation();
                if (seekInformationArray == null || seekInformationArray.length == 0) {
                    logMessage.append(" null!");
                } else {
                    for (int i2 = 0; i2 < seekInformationArray.length; ++i2) {
                        if (seekInformationArray[i2] == null) continue;
                        this.logSeekInfoType(seekInformationArray[i2], logMessage);
                    }
                }
            }
            logMessage.log();
        }
    }

    public void logBC() {
        this.mLogBcActive = true;
        LogMessage logMessage = this.getLogMsg();
        if (logMessage != null) {
            logMessage.append("----------------------------").log();
        }
        if ((logMessage = this.getLogMsg()) != null) {
            logMessage.append("SDARS-Version=").append(1003).append(", LastDeliverDate=").append("06.08.2013").append(", Arbeitspaket=").append("AP_ASL-Radio_3054").log();
        }
        if ((logMessage = this.getLogMsg()) != null) {
            logMessage.append("----------------------------").log();
        }
        this.mLogBcActive = false;
    }

    public void logSeekAlert(SeekAlert seekAlert) {
        LogMessage logMessage = this.getLogMsg();
        if (logMessage != null) {
            logMessage.append("DSI UPDATE SEEK ALERT:");
            if (seekAlert == null) {
                logMessage.append(" null!");
            } else {
                logMessage.append(" AlertType=");
                String string = this.mNameDb == null ? "" : this.mNameDb.getName(3, seekAlert.getAlertType());
                logMessage.append(string);
                logMessage.append(" SeekID=");
                logMessage.append(seekAlert.seekID);
            }
            logMessage.log();
        }
    }

    public void logSeekList(SeekEntry[] seekEntryArray) {
        LogMessage logMessage = this.getLogMsg();
        if (logMessage != null) {
            logMessage.append("DSI UPDATE SEEK LIST:");
            if (seekEntryArray == null || seekEntryArray.length == 0) {
                logMessage.append(" null!");
            } else {
                for (int i2 = 0; i2 < seekEntryArray.length; ++i2) {
                    if (seekEntryArray[i2] == null) {
                        logMessage.append(" [null]");
                        continue;
                    }
                    logMessage.append(" [ID=");
                    logMessage.append(seekEntryArray[i2].seekID);
                    logMessage.append(",");
                    String string = this.mNameDb == null ? "" : this.mNameDb.getName(5, seekEntryArray[i2].typeOfContent);
                    logMessage.append(string);
                    logMessage.append(",");
                    logMessage.append(seekEntryArray[i2].seekActive ? "active" : "inactive");
                    logMessage.append(",\"");
                    logMessage.append(seekEntryArray[i2].title1);
                    logMessage.append("\",\"");
                    logMessage.append(seekEntryArray[i2].title2);
                    logMessage.append("\",lnk=");
                    logMessage.append(seekEntryArray[i2].contentLink);
                    logMessage.append("]");
                }
            }
            logMessage.log();
        }
    }

    static {
        mChannelListUpdateCount = 0;
    }
}

