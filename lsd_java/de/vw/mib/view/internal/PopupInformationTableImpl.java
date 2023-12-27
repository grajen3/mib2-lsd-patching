/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.hmi.utils.BitArray;
import de.vw.mib.hmi.utils.MagicNumber;
import de.vw.mib.hmi.utils.PerfectSlotHash;
import de.vw.mib.hmi.utils.ResData;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.view.internal.PopupInfoResDataAccess;
import de.vw.mib.viewmanager.internal.popup.PopupInformationTable;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.io.File;

public class PopupInformationTableImpl
implements PopupInformationTable {
    private static final int HEADER_COUNT;
    private static final int HEADER_SDS_NOTIFY_ON;
    private static final int HEADER_SDS_NOTIFY_OFF;
    private static final int END_OF_LIST;
    private static final String[] NO_STRINGS;
    private final Logger logger;
    private final int CHECKSUM;
    private final int SDS_NOTIFY_ON;
    private final int SDS_NOTIFY_OFF;
    private final int POPUPINFO_COUNT;
    private final short[] POPUPINFO_PRIORITY;
    private final int[] POPUPINFO_TIMEOUT;
    private final int[] POPUPINFO_TIMEMIN;
    private final int[] POPUPINFO_TIMERESTART;
    private final BitArray POPUPINFO_GLOBAL;
    private final BitArray POPUPINFO_MOVETOHOMECONTEXTBYHK;
    private final BitArray POPUPINFO_CLOSEONMOVE2HOMECTX;
    private final BitArray POPUPINFO_CLOSEWHENSUPERSEDED;
    private final BitArray POPUPINFO_ACTIVEINUSERPERCEIVEOFFMODE;
    private final BitArray POPUPINFO_CLOSEONTOUCH;
    private final BitArray POPUPINFO_CLOSEONHK;
    private final short[] POPUPINFO_CLOSEONHKEXCEPTIONS;
    private final BitArray POPUPINFO_CLOSEONPROXIMITY;
    private final BitArray POPUPINFO_FORWARDTOUCHEVENT;
    private final BitArray POPUPINFO_ACTIVEDURINGSPEECHDIALOG;
    private final BitArray POPUPINFO_INVISIBLEINUSERPERCEIVEDOFFMODE;
    private final BitArray POPUPINFO_SPEAKTHROUGH;
    private final BitArray POPUPINFO_STOPSSPEECH;
    private final String[] POPUPINFO_HOMECONTEXT;
    private final BitArray POPUPINFO_INVISIBLEINACTIVEAREA;
    private final BitArray POPUPINFO_SHOWDURINGEXBOX;
    private final short[] POPUPINFO_CONSUMEEVENTS;
    private final int[][] POPUPINFO_CONSUMEEVENTS_SPLIT;
    private final short[] EVENTLIST;
    private final PerfectSlotHash HARDKEY_HASH;
    private final String[][] HARDKEY_HOMECONTEXTS;

    public PopupInformationTableImpl(int n, LoggerFactory loggerFactory) {
        this.logger = loggerFactory.getLogger(1024);
        PopupInfoResDataAccess popupInfoResDataAccess = this.loadData();
        this.CHECKSUM = n;
        this.SDS_NOTIFY_ON = popupInfoResDataAccess.getHeader()[4];
        this.SDS_NOTIFY_OFF = popupInfoResDataAccess.getHeader()[5];
        this.POPUPINFO_COUNT = popupInfoResDataAccess.getHeader()[3];
        this.POPUPINFO_PRIORITY = popupInfoResDataAccess.getPopupInfo_Priority();
        this.POPUPINFO_TIMEOUT = popupInfoResDataAccess.getPopupInfo_TimeOut();
        this.POPUPINFO_TIMEMIN = popupInfoResDataAccess.getPopupInfo_TimeMin();
        this.POPUPINFO_TIMERESTART = popupInfoResDataAccess.getPopupInfo_TimeRestart();
        this.POPUPINFO_GLOBAL = popupInfoResDataAccess.newPopupInfo_Global();
        this.POPUPINFO_MOVETOHOMECONTEXTBYHK = popupInfoResDataAccess.newPopupInfo_MoveToHomeContextByHK();
        this.POPUPINFO_CLOSEONMOVE2HOMECTX = popupInfoResDataAccess.newPopupInfo_CloseWhenMoveToHomeContext();
        this.POPUPINFO_CLOSEWHENSUPERSEDED = popupInfoResDataAccess.newPopupInfo_CloseWhenSuperseded();
        this.POPUPINFO_ACTIVEINUSERPERCEIVEOFFMODE = popupInfoResDataAccess.newPopupInfo_ActiveInUserPerceiveOffMode();
        this.POPUPINFO_INVISIBLEINUSERPERCEIVEDOFFMODE = popupInfoResDataAccess.newPopupInfo_InvisibleInUserPerceivedOffMode();
        this.POPUPINFO_CLOSEONTOUCH = popupInfoResDataAccess.newPopupInfo_CloseOnTouch();
        this.POPUPINFO_CLOSEONHK = popupInfoResDataAccess.newPopupInfo_CloseOnHK();
        this.POPUPINFO_CLOSEONHKEXCEPTIONS = popupInfoResDataAccess.getPopupInfo_CloseOnHKExceptions();
        this.POPUPINFO_CLOSEONPROXIMITY = popupInfoResDataAccess.newPopupInfo_CloseOnProximity();
        this.POPUPINFO_FORWARDTOUCHEVENT = popupInfoResDataAccess.newPopupInfo_ForwardTouchEvent();
        this.POPUPINFO_ACTIVEDURINGSPEECHDIALOG = popupInfoResDataAccess.newPopupInfo_ActiveDuringSpeechDialog();
        this.POPUPINFO_SPEAKTHROUGH = popupInfoResDataAccess.newPopupInfo_SpeakThrough();
        this.POPUPINFO_STOPSSPEECH = popupInfoResDataAccess.newPopupInfo_StopsSpeech();
        this.POPUPINFO_INVISIBLEINACTIVEAREA = popupInfoResDataAccess.newPopupInfo_InvisibleInactiveArea();
        this.POPUPINFO_SHOWDURINGEXBOX = popupInfoResDataAccess.newPopupInfo_ShowDuringExBox();
        this.POPUPINFO_HOMECONTEXT = this.map(popupInfoResDataAccess.getPopupInfo_HomeContext(), popupInfoResDataAccess.getHomeContextList());
        this.map(popupInfoResDataAccess.getPopupInfo_HomeContext(), this.splits(popupInfoResDataAccess.getHomeContextList()));
        this.POPUPINFO_CONSUMEEVENTS = popupInfoResDataAccess.getPopupInfo_ConsumeEvents();
        this.EVENTLIST = popupInfoResDataAccess.getEventList();
        this.POPUPINFO_CONSUMEEVENTS_SPLIT = new int[this.EVENTLIST.length][];
        this.HARDKEY_HASH = popupInfoResDataAccess.newHardKey_slothash();
        this.HARDKEY_HOMECONTEXTS = this.splits(popupInfoResDataAccess.getHardKey_HomeContext());
    }

    private PopupInfoResDataAccess loadData() {
        File file = ResData.getResFile(ServiceManagerCommon.configurationManager, "popupinfo.res");
        Object[] objectArray = ResData.loadAndCheck(ServiceManagerCommon.fileManager, file, MagicNumber.POPUPINFO_RES, this.CHECKSUM, -802178237, this.logger, 4);
        return new PopupInfoResDataAccess(objectArray);
    }

    private String[][] splits(String[] stringArray) {
        String[][] stringArray2 = new String[stringArray.length][];
        Object[] objectArray = new String[10];
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string = stringArray[i2];
            if (string.length() == 0) {
                stringArray2[i2] = NO_STRINGS;
                continue;
            }
            int n = 0;
            int n2 = 0;
            int n3 = string.indexOf(44);
            while (n3 >= 0) {
                objectArray = n < objectArray.length ? objectArray : (String[])Arrays.copyOf(objectArray, objectArray.length * 2);
                objectArray[n++] = string.substring(n2, n3).intern();
                n2 = n3 + 1;
                n3 = string.indexOf(44, n2);
            }
            objectArray = n < objectArray.length ? objectArray : (String[])Arrays.copyOf(objectArray, objectArray.length * 2);
            objectArray[n++] = string.substring(n2).intern();
            stringArray2[i2] = (String[])Arrays.copyOf(objectArray, n);
        }
        return stringArray2;
    }

    private String[] map(short[] sArray, String[] stringArray) {
        String[] stringArray2 = new String[sArray.length];
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            stringArray2[i2] = stringArray[sArray[i2]];
        }
        return stringArray2;
    }

    private String[][] map(short[] sArray, String[][] stringArray) {
        String[][] stringArray2 = new String[sArray.length][];
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            stringArray2[i2] = stringArray[sArray[i2]];
        }
        return stringArray2;
    }

    private boolean containsEvent(int n, int n2) {
        int n3 = n;
        while (this.EVENTLIST[n3] != -1) {
            if (this.EVENTLIST[n3] == n2) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    private boolean checkId(int n) {
        return n >= 0 && n < this.POPUPINFO_COUNT;
    }

    @Override
    public int getPriority(int n) {
        return this.checkId(n) ? this.POPUPINFO_PRIORITY[n] : 0;
    }

    @Override
    public int getTimeout(int n) {
        return this.checkId(n) ? this.POPUPINFO_TIMEOUT[n] : 0;
    }

    @Override
    public int getTimeMin(int n) {
        return this.checkId(n) ? this.POPUPINFO_TIMEMIN[n] : 0;
    }

    @Override
    public int getTimeRestart(int n) {
        return this.checkId(n) ? this.POPUPINFO_TIMERESTART[n] : 0;
    }

    @Override
    public boolean isGlobalPopup(int n) {
        return this.checkId(n) ? this.POPUPINFO_GLOBAL.get(n) : false;
    }

    @Override
    public boolean shallMoveToHomeContext(int n) {
        return this.checkId(n) ? this.POPUPINFO_MOVETOHOMECONTEXTBYHK.get(n) : false;
    }

    @Override
    public boolean shallCloseWhenMovedToHomeContext(int n) {
        return this.checkId(n) ? this.POPUPINFO_CLOSEONMOVE2HOMECTX.get(n) : false;
    }

    @Override
    public boolean shallCloseWhenSuperseded(int n) {
        return this.checkId(n) ? this.POPUPINFO_CLOSEWHENSUPERSEDED.get(n) : false;
    }

    @Override
    public boolean isActiveInUserPerceivedOffMode(int n) {
        return this.checkId(n) ? this.POPUPINFO_ACTIVEINUSERPERCEIVEOFFMODE.get(n) : false;
    }

    @Override
    public boolean isVisibleInUserPerceivedOffMode(int n) {
        return this.checkId(n) ? this.POPUPINFO_ACTIVEINUSERPERCEIVEOFFMODE.get(n) && !this.POPUPINFO_INVISIBLEINUSERPERCEIVEDOFFMODE.get(n) : false;
    }

    @Override
    public boolean shallCloseOnTouch(int n) {
        return this.checkId(n) ? this.POPUPINFO_CLOSEONTOUCH.get(n) : false;
    }

    private boolean shallCloseOnHk(int n) {
        return this.checkId(n) ? this.POPUPINFO_CLOSEONHK.get(n) : false;
    }

    @Override
    public boolean shallCloseOnHk(int n, int n2) {
        return this.shallCloseOnHk(n) && !this.containsEvent(this.POPUPINFO_CLOSEONHKEXCEPTIONS[n], n2);
    }

    @Override
    public boolean shallCloseOnProximity(int n) {
        return this.checkId(n) ? this.POPUPINFO_CLOSEONPROXIMITY.get(n) : false;
    }

    @Override
    public boolean shallForwardTouchEvent(int n) {
        return this.checkId(n) ? this.POPUPINFO_FORWARDTOUCHEVENT.get(n) : false;
    }

    @Override
    public boolean isActiveDuringSpeechDialog(int n) {
        return this.checkId(n) ? this.POPUPINFO_ACTIVEDURINGSPEECHDIALOG.get(n) : false;
    }

    @Override
    public boolean isSpeakThrough(int n) {
        return this.checkId(n) ? this.POPUPINFO_SPEAKTHROUGH.get(n) : false;
    }

    @Override
    public boolean isStopsSpeech(int n) {
        return this.checkId(n) ? this.POPUPINFO_STOPSSPEECH.get(n) : false;
    }

    @Override
    public String getHomeContextId(int n) {
        return this.checkId(n) ? this.POPUPINFO_HOMECONTEXT[n] : "";
    }

    @Override
    public boolean hasInvisibleInactiveArea(int n) {
        return this.checkId(n) ? this.POPUPINFO_INVISIBLEINACTIVEAREA.get(n) : false;
    }

    @Override
    public boolean shallShowDuringExBox(int n) {
        return this.checkId(n) ? this.POPUPINFO_SHOWDURINGEXBOX.get(n) : false;
    }

    @Override
    public int getConsumeEventId(int n) {
        return this.checkId(n) ? this.EVENTLIST[this.POPUPINFO_CONSUMEEVENTS[n]] : -1;
    }

    @Override
    public int[] getConsumeEventIds(int n) {
        return this.checkId(n) ? this.getSplit(this.POPUPINFO_CONSUMEEVENTS[n]) : this.getSplit(0);
    }

    private int[] getSplit(int n) {
        int[] nArray = this.POPUPINFO_CONSUMEEVENTS_SPLIT[n];
        if (nArray == null) {
            int n2 = n;
            while (this.EVENTLIST[n2] != -1) {
                ++n2;
            }
            nArray = new int[n2 - n];
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                nArray[i2] = this.EVENTLIST[n + i2];
            }
            this.POPUPINFO_CONSUMEEVENTS_SPLIT[n] = nArray;
        }
        return nArray;
    }

    @Override
    public boolean isConsumeEventId(int n, int n2) {
        return this.checkId(n) ? this.containsEvent(this.POPUPINFO_CONSUMEEVENTS[n], n2) : false;
    }

    @Override
    public String[] getHomeContextIdsByEventId(int n) {
        int n2 = this.HARDKEY_HASH.getSlot(n);
        return n2 < 0 ? NO_STRINGS : this.HARDKEY_HOMECONTEXTS[n2];
    }

    @Override
    public int getId4SdsNotifyViewManagerSdsOn() {
        return this.SDS_NOTIFY_ON;
    }

    @Override
    public int getId4SdsNotifyViewManagerSdsOff() {
        return this.SDS_NOTIFY_OFF;
    }

    static {
        NO_STRINGS = new String[0];
    }
}

