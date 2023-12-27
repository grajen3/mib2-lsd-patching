/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.slde;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.AbstractNavGatewayTarget;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiGetXt9LDBs;
import de.vw.mib.asl.internal.navigation.slde.SpellerDataChangedListener;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.SpellerData;
import java.util.Iterator;
import java.util.Vector;
import org.dsi.ifc.global.NavLocation;

public class SldeSpellerHandler
extends AbstractNavGatewayTarget {
    final boolean initXt9 = ServiceManager.configManagerDiag.isFeatureFlagSet(168) || ServiceManager.configManagerDiag.isFeatureFlagSet(111) || ServiceManager.configManagerDiag.isFeatureFlagSet(125);
    private int[] spellerEvents = new int[]{1237913664, 583602240, 600379456, 902369344, 919146560, 1221136448};
    private Vector spellerDataChangedListener = new Vector();
    private Vector spellerTextChangedListener = new Vector();
    private SpellerData currentSpellerData = new SpellerData();
    private static IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "SldeSpellerHandler");
    private static SldeSpellerHandler instance = null;

    public SldeSpellerHandler(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    public static SldeSpellerHandler getInstance() {
        if (instance == null) {
            try {
                instance = new SldeSpellerHandler(ServiceManager.eventMain, -750054400, "hsmtask");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return instance;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 101003: {
                this.addObservers(this.spellerEvents);
                break;
            }
            case 1074841890: 
            case 1074841929: {
                this.addCharacters(eventGeneric);
                break;
            }
            case 1074841891: {
                this.deleteCharacter();
                break;
            }
            case 1074841909: {
                this.deleteAllCharacters();
                break;
            }
            case 1074841910: {
                this.setCursorPosition(eventGeneric);
                break;
            }
            case 1074841928: {
                this.handleHwrSpellerModeEnabled(eventGeneric);
                break;
            }
        }
    }

    public void addSpellerDataChangedListener(SpellerDataChangedListener spellerDataChangedListener) {
        this.spellerDataChangedListener.add(spellerDataChangedListener);
    }

    public void removeSpellerDataChangedListener(SpellerDataChangedListener spellerDataChangedListener) {
        this.spellerDataChangedListener.remove(spellerDataChangedListener);
    }

    public void addSpellerTextChangedListener(SpellerDataChangedListener spellerDataChangedListener) {
        this.spellerTextChangedListener.add(spellerDataChangedListener);
    }

    public void removeSpellerTextChangedListener(SpellerDataChangedListener spellerDataChangedListener) {
        this.spellerTextChangedListener.remove(spellerDataChangedListener);
    }

    public boolean isSpellerTextEmpty() {
        return this.currentSpellerData.getEnteredText().length() == 0;
    }

    public SpellerData getSpellerData() {
        return this.currentSpellerData;
    }

    private void notifySpellerDataChangedListeners() {
        Iterator iterator = this.spellerDataChangedListener.iterator();
        while (iterator.hasNext()) {
            ((SpellerDataChangedListener)iterator.next()).spellerDataChanged(this.currentSpellerData);
        }
    }

    private void notifySpellerTextChangedListeners() {
        Iterator iterator = this.spellerTextChangedListener.iterator();
        while (iterator.hasNext()) {
            ((SpellerDataChangedListener)iterator.next()).spellerTextChanged(this.currentSpellerData);
        }
    }

    private void notifyInitXt9Finished() {
        Iterator iterator = this.spellerTextChangedListener.iterator();
        while (iterator.hasNext()) {
            ((SpellerDataChangedListener)iterator.next()).initXt9Finished();
        }
    }

    private void setSpellerData(String string, int n, String string2, String string3, int n2, int n3) {
        this.currentSpellerData.setEnteredText(string);
        this.currentSpellerData.setCursorPosition(n);
        this.currentSpellerData.setAvailableCharacters(string2);
        this.currentSpellerData.setMatchCompletion(string3);
        this.currentSpellerData.setSelectionStart(n2);
        this.currentSpellerData.setSelectionEnd(n3);
    }

    public void removeSuggestion() {
        this.currentSpellerData.setMatchCompletion("");
    }

    public void handleHwrSpellerModeEnabled(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1127358464, bl);
    }

    public void addCharacters(String string, int n, int n2) {
        String string2 = this.currentSpellerData.getEnteredText();
        if (this.currentSpellerData.getSelectionStart() != this.currentSpellerData.getSelectionEnd()) {
            this.currentSpellerData.setEnteredText(new StringBuffer().append(string2.substring(0, this.currentSpellerData.getSelectionStart())).append(string).append(string2.substring(this.currentSpellerData.getSelectionEnd())).toString());
            this.currentSpellerData.setCursorPosition(this.currentSpellerData.getSelectionStart() + string.length());
        } else if (!this.isSpellerTextEmpty() && string2.length() != this.currentSpellerData.getCursorPosition()) {
            String string3 = string2.substring(0, this.currentSpellerData.getCursorPosition());
            String string4 = string2.substring(this.currentSpellerData.getCursorPosition(), string2.length());
            this.setSpellerData(new StringBuffer().append(string3).append(string).append(string4).toString(), this.currentSpellerData.getCursorPosition() + string.length(), "\u0007", "", this.currentSpellerData.getSelectionStart(), this.currentSpellerData.getSelectionEnd());
        } else {
            this.setSpellerData(new StringBuffer().append(string2).append(string).toString(), this.currentSpellerData.getCursorPosition() + string.length(), "\u0007", "", this.currentSpellerData.getSelectionStart(), this.currentSpellerData.getSelectionEnd());
        }
        this.currentSpellerData.setSelectionStart(n);
        this.currentSpellerData.setSelectionEnd(n2);
        if (n != n2) {
            this.currentSpellerData.setCursorPosition(n2);
        }
        ServiceManager.aslPropertyManager.valueChangedSpellerData(1643122688, this.currentSpellerData);
        this.notifySpellerTextChangedListeners();
        this.notifySpellerDataChangedListeners();
    }

    public void addCharacters(EventGeneric eventGeneric) {
        String string = eventGeneric.getString(0);
        int n = eventGeneric.getInt(2);
        int n2 = eventGeneric.getInt(3);
        this.addCharacters(string, n, n2);
    }

    public void deleteCharacter() {
        if (this.currentSpellerData.getCursorPosition() > 0) {
            String string = this.currentSpellerData.getEnteredText().substring(0, this.currentSpellerData.getCursorPosition() - 1);
            if (this.currentSpellerData.getEnteredText().length() > this.currentSpellerData.getCursorPosition()) {
                String string2 = this.currentSpellerData.getEnteredText().substring(this.currentSpellerData.getCursorPosition());
                string = string.concat(string2);
            }
            if (string.length() == 0) {
                this.setSpellerData("", 0, "\u0007", "", 0, 0);
                ServiceManager.aslPropertyManager.valueChangedSpellerData(1643122688, this.currentSpellerData);
            } else if (string.length() > 0) {
                this.setSpellerData(string, this.currentSpellerData.getCursorPosition() - 1, "\u0007", "", 0, 0);
            }
            ServiceManager.aslPropertyManager.valueChangedSpellerData(1643122688, this.currentSpellerData);
            this.notifySpellerDataChangedListeners();
            this.notifySpellerTextChangedListeners();
        }
    }

    public void deleteAllCharacters() {
        SldeSpellerHandler.printTrace(new StringBuffer("SPELLER_DELETE_ALL_CHARS event received"));
        SpellerData spellerData = (SpellerData)this.currentSpellerData.clone();
        this.setSpellerData("", 0, "\u0007", "", 0, 0);
        ServiceManager.aslPropertyManager.valueChangedSpellerData(1643122688, this.currentSpellerData);
        if (!spellerData.equals(this.currentSpellerData)) {
            this.notifySpellerDataChangedListeners();
        }
        if (!spellerData.getEnteredText().equals(this.currentSpellerData.getEnteredText())) {
            this.notifySpellerTextChangedListeners();
        }
    }

    public void setCursorPosition(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        SpellerData spellerData = (SpellerData)this.currentSpellerData.clone();
        SldeSpellerHandler.printTrace(new StringBuffer("Got event: SET_CURSOR_POSITION. Set cursor to cursorPosition: ").append(n));
        if (n > this.currentSpellerData.getEnteredText().length()) {
            SldeSpellerHandler.printTrace(new StringBuffer(new StringBuffer().append("setCursorPosition: ").append(n).toString()));
            SldeSpellerHandler.printTrace(new StringBuffer(new StringBuffer().append("setCursorPosition: Taking over suggestion. Old text='").append(this.currentSpellerData.getEnteredText()).append("'").toString()));
            SldeSpellerHandler.printTrace(new StringBuffer(new StringBuffer().append("setCursorPosition: Taking over suggestion. Suggestion='").append(this.currentSpellerData.getMatchCompletion()).append("'").toString()));
            this.setSpellerData(new StringBuffer().append(this.currentSpellerData.getEnteredText()).append(this.currentSpellerData.getMatchCompletion()).toString(), this.currentSpellerData.getEnteredText().length() + this.currentSpellerData.getMatchCompletion().length(), "\u0007", "", 0, 0);
            SldeSpellerHandler.printTrace(new StringBuffer(new StringBuffer().append("setCursorPosition: Taking over suggestion. New text='").append(this.currentSpellerData.getEnteredText()).append("'").toString()));
        } else {
            this.currentSpellerData.setCursorPosition(n);
        }
        ServiceManager.aslPropertyManager.valueChangedSpellerData(1643122688, this.currentSpellerData);
        if (!spellerData.equals(this.currentSpellerData)) {
            this.notifySpellerDataChangedListeners();
        }
        if (!spellerData.getEnteredText().equals(this.currentSpellerData.getEnteredText())) {
            this.notifySpellerTextChangedListeners();
        }
    }

    public void clearSpellerData() {
        SpellerData spellerData = (SpellerData)this.currentSpellerData.clone();
        this.currentSpellerData = new SpellerData();
        ServiceManager.aslPropertyManager.valueChangedSpellerData(1643122688, this.currentSpellerData);
        if (!spellerData.equals(this.currentSpellerData)) {
            this.notifySpellerDataChangedListeners();
        }
        if (!spellerData.getEnteredText().equals(this.currentSpellerData.getEnteredText())) {
            this.notifySpellerTextChangedListeners();
        }
    }

    public void initXt9(NavLocation navLocation) {
        if (this.initXt9) {
            SldeSpellerHandler.printTrace(new StringBuffer("initXt9"));
            new CmdPoiGetXt9LDBs(this, navLocation, 3).execute();
        } else {
            SldeSpellerHandler.printTrace(new StringBuffer("don't send initXt9 on non-twn/chn/jp targets"));
            this.notifyInitXt9Finished();
        }
    }

    @Override
    public void handleCommandCmdPoiGetXt9LDBs(CmdPoiGetXt9LDBs cmdPoiGetXt9LDBs) {
        SldeSpellerHandler.printTrace("handleCommandCmdPoiGetXt9LDBs ", cmdPoiGetXt9LDBs.poiGetXt9LdbResult_xt9Databases);
        this.currentSpellerData.setWordDatabaseNames(cmdPoiGetXt9LDBs.poiGetXt9LdbResult_xt9Databases);
        ServiceManager.aslPropertyManager.valueChangedSpellerData(1643122688, this.currentSpellerData);
        this.notifyInitXt9Finished();
    }

    public void setMatchCompletion(String string) {
        SpellerData spellerData = (SpellerData)this.currentSpellerData.clone();
        this.currentSpellerData.setMatchCompletion(string);
        ServiceManager.aslPropertyManager.valueChangedSpellerData(1643122688, this.currentSpellerData);
        if (!spellerData.getEnteredText().equals(this.currentSpellerData.getEnteredText())) {
            this.notifySpellerTextChangedListeners();
        }
    }

    private static void printTrace(StringBuffer stringBuffer) {
        if (logger.isTraceEnabled()) {
            logger.makeTrace().append(stringBuffer.toString()).log();
        }
    }

    private static void printTrace(String string, String[] stringArray) {
        if (logger.isTraceEnabled()) {
            LogMessage logMessage = logger.makeTrace();
            logMessage.append(string).append(": ");
            if (stringArray != null) {
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    logMessage.append(stringArray[i2]).append(", ");
                }
            } else {
                logMessage.append(stringArray);
            }
            logMessage.log();
        }
    }

    public void clearSelection() {
        this.currentSpellerData.setSelectionStart(0);
        this.currentSpellerData.setSelectionEnd(0);
    }
}

