/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.esam.CloseEsamMemberHandler;
import de.vw.mib.app.esam.EsamChangeListener;
import de.vw.mib.app.framework.internal.EsamRuleEngine$EsamRuleEngineDiagService;
import de.vw.mib.app.framework.internal.EsamRuleEngine$EsamVisibilityGrant;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.configuration.EsamDefinitionDataService;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

final class EsamRuleEngine {
    final CioDispatcher cioDispatcher;
    private final CowArray esamChangeListeners;
    private final EsamDefinitionDataService esamDefinitionDataService;
    private final Logger logger;
    private final ArrayList visibleEsamMembers;
    private final ArrayList visibleMembersToClose;

    EsamRuleEngine(Logger logger, EsamDefinitionDataService esamDefinitionDataService, CioDispatcher cioDispatcher) {
        this.logger = logger;
        this.esamDefinitionDataService = esamDefinitionDataService;
        this.cioDispatcher = cioDispatcher;
        this.esamChangeListeners = new CowArray();
        this.visibleEsamMembers = new ArrayList();
        this.visibleMembersToClose = new ArrayList();
    }

    synchronized void clearScreen(EsamRuleEngine$EsamRuleEngineDiagService esamRuleEngine$EsamRuleEngineDiagService, String string) {
        String string2 = this.esamDefinitionDataService.getEsamCategoryName(string);
        esamRuleEngine$EsamRuleEngineDiagService.onHideAllEsamMembersRequest(string, string2);
        this.visibleMembersToClose.addAll(this.visibleEsamMembers);
        this.displaceVisibleMembers(this.visibleMembersToClose, string, string2);
        this.notifyEsamChangeListeners();
    }

    Map getEsamMembersAndCategories() {
        return this.esamDefinitionDataService.getEsamMembersAndCategories();
    }

    int getVisibleEsamMemberCount() {
        return this.visibleEsamMembers.size();
    }

    synchronized Set getVisibleEsamMembers() {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.visibleEsamMembers.size(); ++i2) {
            EsamRuleEngine$EsamVisibilityGrant esamRuleEngine$EsamVisibilityGrant = (EsamRuleEngine$EsamVisibilityGrant)this.visibleEsamMembers.get(i2);
            String string = esamRuleEngine$EsamVisibilityGrant.esamMemberName;
            hashSet.add(string);
        }
        return hashSet;
    }

    synchronized boolean isEsamMemberVisible(String string) {
        for (int i2 = 0; i2 < this.visibleEsamMembers.size(); ++i2) {
            EsamRuleEngine$EsamVisibilityGrant esamRuleEngine$EsamVisibilityGrant = (EsamRuleEngine$EsamVisibilityGrant)this.visibleEsamMembers.get(i2);
            String string2 = esamRuleEngine$EsamVisibilityGrant.esamMemberName;
            if (!string2.equals(string)) continue;
            return true;
        }
        return false;
    }

    synchronized boolean isEsamMemberExclusivelyVisible(String string) {
        return this.getVisibleEsamMemberCount() == 1 && this.isEsamMemberVisible(string);
    }

    void registerEsamChangeListener(EsamChangeListener esamChangeListener) {
        this.esamChangeListeners.addIfNotAlreadyIn(esamChangeListener);
    }

    synchronized void releaseVisibility(EsamRuleEngine$EsamRuleEngineDiagService esamRuleEngine$EsamRuleEngineDiagService, String string) {
        String string2 = this.esamDefinitionDataService.getEsamCategoryName(string);
        esamRuleEngine$EsamRuleEngineDiagService.onEsamVisibilityRelease(string, string2);
        EsamRuleEngine$EsamVisibilityGrant esamRuleEngine$EsamVisibilityGrant = null;
        for (int i2 = 0; i2 < this.visibleEsamMembers.size(); ++i2) {
            esamRuleEngine$EsamVisibilityGrant = (EsamRuleEngine$EsamVisibilityGrant)this.visibleEsamMembers.get(i2);
            if (esamRuleEngine$EsamVisibilityGrant.esamMemberName.equals(string)) break;
            esamRuleEngine$EsamVisibilityGrant = null;
        }
        if (esamRuleEngine$EsamVisibilityGrant == null) {
            return;
        }
        if (this.logger.isTraceEnabled(2048)) {
            this.logger.trace(2048).append("Hide esam member '").append(string).append("'!").log();
        }
        this.visibleEsamMembers.remove(esamRuleEngine$EsamVisibilityGrant);
        this.notifyEsamChangeListeners();
    }

    synchronized boolean requestVisibility(EsamRuleEngine$EsamRuleEngineDiagService esamRuleEngine$EsamRuleEngineDiagService, String string, CloseEsamMemberHandler closeEsamMemberHandler) {
        String string2 = this.esamDefinitionDataService.getEsamCategoryName(string);
        esamRuleEngine$EsamRuleEngineDiagService.onEsamVisibilityRequest(string, string2);
        if (closeEsamMemberHandler == null) {
            this.logger.warn(2048).append("Couldn't show esam member '").append(string).append("'! No close esam member handler specified!").log();
            esamRuleEngine$EsamRuleEngineDiagService.onEsamVisibilityDenied(string, string2, "No close esam member handler specified!");
            return false;
        }
        return this.requestVisibility(new EsamRuleEngine$EsamVisibilityGrant(this, esamRuleEngine$EsamRuleEngineDiagService, string, string2, closeEsamMemberHandler));
    }

    synchronized boolean requestVisibility(EsamRuleEngine$EsamRuleEngineDiagService esamRuleEngine$EsamRuleEngineDiagService, String string, CioIntent cioIntent) {
        String string2 = this.esamDefinitionDataService.getEsamCategoryName(string);
        esamRuleEngine$EsamRuleEngineDiagService.onEsamVisibilityRequest(string, string2);
        if (cioIntent == null) {
            this.logger.warn(2048).append("Couldn't show esam member '").append(string).append("'! No close esam member cio intent specified!").log();
            esamRuleEngine$EsamRuleEngineDiagService.onEsamVisibilityDenied(string, string2, "No close esam member cio intent specified!");
            return false;
        }
        return this.requestVisibility(new EsamRuleEngine$EsamVisibilityGrant(this, esamRuleEngine$EsamRuleEngineDiagService, string, string2, cioIntent));
    }

    void unregisterEsamChangeListener(EsamChangeListener esamChangeListener) {
        this.esamChangeListeners.remove(esamChangeListener);
    }

    private void displaceVisibleMembers(ArrayList arrayList, String string, String string2) {
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            EsamRuleEngine$EsamVisibilityGrant esamRuleEngine$EsamVisibilityGrant = (EsamRuleEngine$EsamVisibilityGrant)arrayList.get(i2);
            if (this.logger.isTraceEnabled(2048)) {
                this.logger.trace(2048).append("Hide esam member '").append(esamRuleEngine$EsamVisibilityGrant.esamMemberName).append("'!").log();
            }
            String string3 = esamRuleEngine$EsamVisibilityGrant.esamMemberName;
            String string4 = esamRuleEngine$EsamVisibilityGrant.esamCategory;
            esamRuleEngine$EsamVisibilityGrant.diagService.onEsamVisibilityRevoked(string3, string4, string, string2);
            this.visibleEsamMembers.remove(esamRuleEngine$EsamVisibilityGrant);
            esamRuleEngine$EsamVisibilityGrant.closeEsamMemberHandler.closeEsamMember(string3);
        }
        arrayList.clear();
    }

    private void notifyEsamChangeListeners() {
        Object[] objectArray = this.esamChangeListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EsamChangeListener)objectArray[i2]).onEsamChanged();
        }
    }

    private boolean requestVisibility(EsamRuleEngine$EsamVisibilityGrant esamRuleEngine$EsamVisibilityGrant) {
        EsamRuleEngine$EsamRuleEngineDiagService esamRuleEngine$EsamRuleEngineDiagService = esamRuleEngine$EsamVisibilityGrant.diagService;
        String string = esamRuleEngine$EsamVisibilityGrant.esamMemberName;
        String string2 = esamRuleEngine$EsamVisibilityGrant.esamCategory;
        for (int i2 = 0; i2 < this.visibleEsamMembers.size(); ++i2) {
            EsamRuleEngine$EsamVisibilityGrant esamRuleEngine$EsamVisibilityGrant2 = (EsamRuleEngine$EsamVisibilityGrant)this.visibleEsamMembers.get(i2);
            String string3 = esamRuleEngine$EsamVisibilityGrant2.esamMemberName;
            String string4 = esamRuleEngine$EsamVisibilityGrant2.esamCategory;
            if (string3.equals(string)) {
                this.logger.warn(2048).append("Couldn't show esam member '").append(string).append("'! Esam member is already visible!").log();
                this.visibleMembersToClose.clear();
                esamRuleEngine$EsamRuleEngineDiagService.onEsamVisibilityDenied(string, string2, "Esam member is already visible!");
                return false;
            }
            if (this.esamDefinitionDataService.isEsamCategoryBlockedBy(string2, string4)) {
                if (this.logger.isTraceEnabled(2048)) {
                    this.logger.trace(2048).append("Couldn't show esam member '").append(string).append("'! Esam member is blocked by '").append(string3).append("'!").log();
                }
                this.visibleMembersToClose.clear();
                esamRuleEngine$EsamRuleEngineDiagService.onEsamVisibilityDenied(string, string2, string3, string4);
                return false;
            }
            if (!this.esamDefinitionDataService.isEsamCategoryClosing(string2, string4)) continue;
            this.visibleMembersToClose.add(esamRuleEngine$EsamVisibilityGrant2);
        }
        this.displaceVisibleMembers(this.visibleMembersToClose, string, string2);
        if (this.logger.isTraceEnabled(2048)) {
            this.logger.trace(2048).append("Show esam member '").append(string).append("'!").log();
        }
        this.visibleEsamMembers.add(esamRuleEngine$EsamVisibilityGrant);
        this.notifyEsamChangeListeners();
        esamRuleEngine$EsamRuleEngineDiagService.onEsamVisibilityGranted(string, string2);
        return true;
    }
}

