/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.gridmenu;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.gridmenu.persistence.GridMenu;
import de.vw.mib.asl.gridmenu.persistence.GridMenuPersistenceService;
import de.vw.mib.asl.internal.gridmenu.api.impl.GridMenuServices;
import de.vw.mib.asl.internal.impl.gridmenu.AbstractGridMenuTarget;
import de.vw.mib.asl.internal.impl.gridmenu.MainMenuTarget$1;
import de.vw.mib.asl.internal.impl.gridmenu.MainMenuTarget$2;
import de.vw.mib.asl.internal.impl.gridmenu.MainMenuTarget$3;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioRegistrationListener;
import de.vw.mib.collections.longs.LongArrayList;
import de.vw.mib.collections.longs.LongIterator;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import java.util.ArrayList;
import java.util.Iterator;

public class MainMenuTarget
extends AbstractGridMenuTarget {
    private static final String LOGGER_PREFIX;
    GridMenu gridMenuPersistable;
    private final LongObjectOptHashMap intentIdsToIntentMap = new LongObjectOptHashMap();
    private ASLList mainMenuAslApiList;
    private final ArrayList orderedIntents = new ArrayList();
    private final GridMenuServices services;

    public MainMenuTarget(GridMenuServices gridMenuServices) {
        super(gridMenuServices.getGenericEvents(), gridMenuServices.getLogger(), -714794496);
        this.services = gridMenuServices;
        this.processPowerOn();
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1078541827: {
                this.moveApp(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 1078541826: {
                this.dispatchGridMenuEntry(eventGeneric.getInt(0));
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.logTrace(new StringBuffer().append("Received unexpected event+ ").append(eventGeneric.toString()).toString());
            }
        }
    }

    void addGridMenuEntryIntent(CioIntent cioIntent) {
        this.intentIdsToIntentMap.put(cioIntent.getCioIntentId(), cioIntent);
        this.orderedIntents.add(cioIntent);
        this.sendGridMenu();
    }

    void dispatchGridMenuEntry(int n) {
        if (this.isInvalidAppIndex(n)) {
            this.logError(new StringBuffer().append("Given app entry position is out of bounds: ").append(n).toString());
            return;
        }
        CioIntent cioIntent = (CioIntent)this.orderedIntents.get(n);
        CioDispatcher cioDispatcher = this.services.getCioDispatcher();
        cioDispatcher.dispatch(cioIntent);
    }

    void reinitalizeMenu() {
        this.loadPersistence();
        this.initGridMenuEntries();
        this.sendGridMenu();
    }

    void removeGridMenuEntryIntent(CioIntent cioIntent) {
        this.intentIdsToIntentMap.remove(cioIntent.getCioIntentId());
        this.orderedIntents.remove(cioIntent);
        this.sendGridMenu();
    }

    private void addCiosFromIds(LongArrayList longArrayList) {
        LongIterator longIterator = longArrayList.iterator();
        while (longIterator.hasNext()) {
            long l = longIterator.next();
            this.orderedIntents.add(this.intentIdsToIntentMap.get(l));
        }
    }

    private void addMissingCios(LongArrayList longArrayList, Object[] objectArray) {
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            CioIntent cioIntent = (CioIntent)objectArray[i2];
            if (longArrayList.contains(cioIntent.getCioIntentId())) continue;
            this.orderedIntents.add(cioIntent);
        }
    }

    private FactoryResetParticipant createFactoryResetParticipant() {
        return new MainMenuTarget$1(this);
    }

    private CioRegistrationListener createGridMenuEntryRegistrationListener() {
        return new MainMenuTarget$2(this);
    }

    private void retrieveAslList() {
        this.mainMenuAslApiList = this.services.getAslListManager().getASLList(308627712);
    }

    private LongArrayList getExistingCioIds(LongArrayList longArrayList) {
        LongArrayList longArrayList2 = new LongArrayList();
        LongIterator longIterator = longArrayList.iterator();
        while (longIterator.hasNext()) {
            long l = longIterator.next();
            if (!this.intentIdsToIntentMap.containsKey(l)) continue;
            longArrayList2.add(l);
        }
        return longArrayList2;
    }

    private void initGridMenuEntries() {
        CioDictionary cioDictionary = this.services.getCioDictionary();
        this.intentIdsToIntentMap.clear();
        this.orderedIntents.clear();
        CioIntent[] cioIntentArray = cioDictionary.getCioIntents("MenuAction", "GridMenuAction");
        if (cioIntentArray == null) {
            this.logWarning("No grid menu entries available.");
        } else {
            for (int i2 = 0; i2 < cioIntentArray.length; ++i2) {
                CioIntent cioIntent = cioIntentArray[i2];
                this.intentIdsToIntentMap.put(cioIntent.getCioIntentId(), cioIntent);
                this.orderedIntents.add(cioIntent);
            }
        }
        this.orderEntriesByPersistence();
    }

    private boolean isInvalidAppIndex(int n) {
        return n < 0 || n >= this.orderedIntents.size();
    }

    private boolean isTraceEnabled() {
        return this.getLogger().isTraceEnabled(2048);
    }

    private void loadPersistence() {
        GridMenuPersistenceService gridMenuPersistenceService = this.services.getPersistenceService();
        this.gridMenuPersistable = gridMenuPersistenceService.loadGridMenu();
    }

    private void logError(String string) {
        this.getLogger().error(2048).append("[GridMenuMainMenuTarget] ").append(string).log();
    }

    private void logTrace(String string) {
        this.getLogger().trace(2048).append("[GridMenuMainMenuTarget] ").append(string).log();
    }

    private void logWarning(String string) {
        this.getLogger().warn(2048).append("[GridMenuMainMenuTarget] ").append(string).log();
    }

    private void moveApp(int n, int n2) {
        if (this.isInvalidAppIndex(n) || this.isInvalidAppIndex(n2)) {
            this.logError(new StringBuffer().append("Invalid app move order (from/to)").append(n).append("/").append(n2).toString());
            return;
        }
        CioIntent cioIntent = (CioIntent)this.orderedIntents.remove(n);
        this.orderedIntents.add(n2, cioIntent);
        this.sendGridMenu();
    }

    private void orderEntriesByPersistence() {
        LongArrayList longArrayList = this.gridMenuPersistable.getMainMenuEntryCioIds();
        LongArrayList longArrayList2 = this.getExistingCioIds(longArrayList);
        Object[] objectArray = this.orderedIntents.toArray();
        this.orderedIntents.clear();
        this.addCiosFromIds(longArrayList2);
        this.addMissingCios(longArrayList2, objectArray);
    }

    private void processPowerOn() {
        this.retrieveAslList();
        this.registerListeners();
        this.registerProfileChangeListener();
        this.registerFactoryResetListener();
        this.reinitalizeMenu();
    }

    private void registerFactoryResetListener() {
        FactoryResetService factoryResetService = this.services.getSystemAPI().getFactoryResetService();
        FactoryResetParticipant factoryResetParticipant = this.createFactoryResetParticipant();
        factoryResetService.addParticipant(factoryResetParticipant, FactoryResetComponents.SYSTEM);
        factoryResetService.addParticipant(factoryResetParticipant, FactoryResetComponents.PERSONALIZATION);
    }

    private void registerListeners() {
        CioDictionary cioDictionary = this.services.getCioDictionary();
        cioDictionary.addCioRegistrationListener("MenuAction", this.createGridMenuEntryRegistrationListener());
        this.addObserver(37636416);
        this.addObserver(54413632);
    }

    private void registerProfileChangeListener() {
        GridMenuPersistenceService gridMenuPersistenceService = this.services.getPersistenceService();
        gridMenuPersistenceService.addProfileChangeListener(new MainMenuTarget$3(this));
    }

    private void saveIntentOrderToPersistence() {
        LongArrayList longArrayList = this.gridMenuPersistable.getMainMenuEntryCioIds();
        longArrayList.clear();
        Iterator iterator = this.orderedIntents.iterator();
        while (iterator.hasNext()) {
            CioIntent cioIntent = (CioIntent)iterator.next();
            longArrayList.add(cioIntent.getCioIntentId());
        }
    }

    private void sendGridMenu() {
        this.mainMenuAslApiList.updateList(this.orderedIntents.toArray());
        this.saveIntentOrderToPersistence();
    }
}

