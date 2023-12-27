/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup.knowledge;

import de.vw.mib.asl.api.navigation.NavigationDefinitions;
import de.vw.mib.asl.internal.navigation.startup.groups.StartupGroup;
import de.vw.mib.asl.internal.navigation.startup.knowledge.KnowledgeBaseObserver;
import de.vw.mib.genericevents.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;
import java.util.ArrayList;

public class KnowledgeBase {
    private boolean aslStartupDone = false;
    private boolean firstStartupDone = false;
    private StartupGroup[] groups;
    private boolean mainMapReady = false;
    private boolean mapInMapReady = false;
    private boolean mainMapDrawn = false;
    private int navDomainState = 1;
    private int navStateOfOperation = 0;
    private ArrayList observers = new ArrayList(30);
    private static KnowledgeBase mpInstance = new KnowledgeBase();

    public static KnowledgeBase getInstance() {
        return mpInstance;
    }

    private KnowledgeBase() {
    }

    public int getGroupState(int n) {
        try {
            return this.groups[n].getTrafficLightState();
        }
        catch (Exception exception) {
            return -1;
        }
    }

    public int getNavDomainState() {
        return this.navDomainState;
    }

    public int getNavStateOfOperation() {
        return this.navStateOfOperation;
    }

    public boolean isAslStartupDone() {
        return this.aslStartupDone;
    }

    public boolean isFirstStartupDone() {
        return this.firstStartupDone;
    }

    public boolean isGreen(int n) {
        return this.getGroupState(n) == 3;
    }

    public boolean isMainMapDrawn() {
        return this.mainMapDrawn;
    }

    public boolean isMainMapReady() {
        return this.mainMapReady;
    }

    public boolean isMapInMapReady() {
        return this.mapInMapReady;
    }

    public boolean isNaviRunning() {
        return this.isGreen(4);
    }

    public boolean isRed(int n) {
        return this.getGroupState(n) == 1;
    }

    public boolean isYellow(int n) {
        return this.getGroupState(n) == 2;
    }

    public void notifyObserver() {
        if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
            LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
            logMessage.append("NAVI-STARTUP: Notifying observer:\n");
            logMessage.append(this);
            logMessage.log();
        }
        for (int i2 = 0; i2 < this.observers.size(); ++i2) {
            ((KnowledgeBaseObserver)this.observers.get(i2)).changed(this);
        }
    }

    private void onKnowledgeBaseChange() {
        this.notifyObserver();
    }

    public void registerObserver(KnowledgeBaseObserver knowledgeBaseObserver) {
        this.observers.add(knowledgeBaseObserver);
    }

    public void resetKnowledgeBase() {
        this.navStateOfOperation = 0;
        this.navDomainState = 1;
        this.mapInMapReady = false;
        this.firstStartupDone = false;
        this.aslStartupDone = false;
        try {
            this.notifyObserver();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setAslStartupDone(boolean bl) {
        if (bl != this.aslStartupDone) {
            this.aslStartupDone = bl;
            this.onKnowledgeBaseChange();
        }
    }

    public void setFirstStartupDone(boolean bl) {
        if (bl != this.firstStartupDone) {
            this.firstStartupDone = bl;
            this.onKnowledgeBaseChange();
        }
    }

    public void setGroups(StartupGroup[] startupGroupArray) {
        this.groups = startupGroupArray;
    }

    public void setMainMapDrawn(boolean bl) {
        if (bl != this.mainMapDrawn) {
            this.mainMapDrawn = bl;
            this.onKnowledgeBaseChange();
        }
    }

    public void setMainMapReady(boolean bl) {
        if (this.mainMapReady != bl) {
            this.mainMapReady = bl;
            this.onKnowledgeBaseChange();
        }
    }

    public void setMapInMapReady(boolean bl) {
        if (bl != this.mapInMapReady) {
            this.mapInMapReady = bl;
            this.onKnowledgeBaseChange();
        }
    }

    public void setNavDomainState(int n) {
        if (this.navDomainState != n) {
            this.navDomainState = n;
            this.onKnowledgeBaseChange();
        }
    }

    public void setNavStateOfOperation(int n) {
        if (this.navStateOfOperation != n) {
            this.navStateOfOperation = n;
            this.onKnowledgeBaseChange();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append("Domain: ");
        stringBuffer.append(this.navDomainState);
        stringBuffer.append(" / NavState: ");
        stringBuffer.append(this.navStateOfOperation);
        stringBuffer.append(" / MapReady: ");
        stringBuffer.append(this.mainMapReady);
        stringBuffer.append(" / MapInMapReady: ");
        stringBuffer.append(this.mapInMapReady);
        stringBuffer.append(" / FirstStartupDone: ");
        stringBuffer.append(this.firstStartupDone);
        stringBuffer.append(" / AslStartupDone: ");
        stringBuffer.append(this.aslStartupDone);
        stringBuffer.append("\n");
        for (int i2 = 0; i2 < this.groups.length; ++i2) {
            StartupGroup startupGroup = this.groups[i2];
            stringBuffer.append(startupGroup.getName());
            stringBuffer.append(": ");
            stringBuffer.append(startupGroup.getTrafficLightState());
            if (startupGroup.getTrafficLightState() == -2) {
                stringBuffer.append(" ");
                stringBuffer.append(startupGroup.getTransitionOldState());
                stringBuffer.append(" -> ");
                stringBuffer.append(startupGroup.getTransitionNewState());
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }
}

