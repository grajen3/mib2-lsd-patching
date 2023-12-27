/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.search;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.ASLListItemSoftCacheImpl;
import de.vw.mib.asl.internal.navigation.memory.search.AbstractMSState;
import de.vw.mib.asl.internal.navigation.memory.search.HsmTargetMemorySearch;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.organizer.DataSet;

public final class StateMSInit
extends AbstractMSState {
    private static final int[] REGISTERED_SERVICES = new int[]{1795293248, 2030174272, 2046951488, 2013397056, 1979842624, 248057920, 399052864, 1895956544, 415830080};
    public static final int SPELLERSEARCHMODE_SINGLE_FIELD;
    public static final int SPELLERSEARCHMODE_SINGLE_FIELD_PHONETIC;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetup;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetupListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;

    public StateMSInit(HsmTargetMemorySearch hsmTargetMemorySearch, String string, HsmState hsmState) {
        super(hsmTargetMemorySearch, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleInitTarget();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 1073742443: {
                this.handleInitSearchSpeller(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleInitTarget() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleInitTarget()");
        }
        this.target.addObservers(REGISTERED_SERVICES);
        this.initDSI();
        this.getDataPool().setAdbSearchMode(0);
        this.getDataPool().getResultList().updateList(new Object[0]);
        this.getDataPool().getResultList().enableWindowing(new ASLListItemSoftCacheImpl(), this.target, 10, 0);
        this.getDataPool().getResultList().setColumn4ObjectId(1);
    }

    private void handleInitSearchSpeller(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleInitSearchSpeller()");
        }
        this.prepareInitSearchSpeller(eventGeneric);
        switch (this.getDataPool().getSearchType()) {
            case 1: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Init search speller for type: LASTDESTMEM");
                }
                this.target.transStateLastDestMem();
                break;
            }
            case 2: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Init search speller for type: TOPDEST");
                }
                this.getDataPool().setLastUsedSearchType(15);
                this.restartSpeller(false);
                this.target.transStateMain();
                break;
            }
            case 3: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Init search speller for type: DESTMEM");
                }
                this.getDataPool().setLastUsedSearchType(6);
                this.restartSpeller(false);
                this.target.transStateMain();
                break;
            }
            case 4: 
            case 5: {
                this.logger.warn("Init search speller for type: VCARD or GPSPIC. Not handled!");
                this.target.transStateMain();
                break;
            }
            case 6: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Init search speller for type: CONTACTS");
                }
                this.initPhoneContactsSearch(0);
                break;
            }
            case 7: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Init search speller for type: ONLINE DESTINATIONS");
                }
                this.getDataPool().setLastUsedSearchType(18);
                this.restartSpeller(false);
                this.target.transStateMain();
                break;
            }
            case 8: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Init search speller for type: CONTACT DEST MEM LIST PHONETIC");
                }
                this.initPhoneContactsSearch(1);
                break;
            }
            default: {
                this.logger.warn("Init search speller for type: DEFAULT. Not handled!");
            }
        }
        this.getDataPool().setSpellerHandle(-2);
        this.getDataPool().storeSpellerData();
        this.target.sendHMIEvent(101);
        ServiceManager.aslPropertyManager.valueChangedInteger(2762, 0);
    }

    private void initPhoneContactsSearch(int n) {
        boolean bl = false;
        switch (n) {
            case 0: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Initializing phone contact search for SINGLE_FIELD");
                }
                this.getDataPool().setAdbSearchMode(0);
                this.getDataPool().setLastUsedSearchType(2);
                this.restartSpeller(bl);
                break;
            }
            case 1: {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("Initializing phone contact search for SINGLE_FIELD_PHONETIC");
                }
                this.getDataPool().setAdbSearchMode(1);
                this.getDataPool().setLastUsedSearchType(2);
                this.restartSpeller(bl);
                break;
            }
            default: {
                if (!this.logger.isTraceEnabled()) break;
                this.logger.warn("Speller search mode is unknown!");
            }
        }
    }

    public HsmState dsiAdbSetupUpdateAdbState(int n, int n2) {
        if (n == 2) {
            this.initOrganizerDSI();
            this.target.transStateMain();
        } else {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            dSIProxy.removeResponseListener(this.target, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = StateMSInit.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 2, this.target.adbListListener);
        }
        return null;
    }

    public HsmState dsiAdbListStopSpellerResult(int n, int n2) {
        if (this.getDataPool().getSpellerHandle() == n2) {
            this.getDataPool().setSpellerHandle(-2);
        }
        this.getDataPool().setSpellerStopped(false);
        this.getDataPool().setInvalidCharactersCount(0);
        this.target.transStateMain();
        return null;
    }

    @Override
    public HsmState dsiAdbListSpellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("StateMSInit.dsiAdbListSpellerResult");
        }
        if (n == 0 && !this.getDataPool().isSpellerStopped()) {
            this.onUpdateSpellerChar(n, n2, dataSetArray, n3, string, string2);
            this.target.transStateMain();
        }
        return null;
    }

    private void initDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        DSIAdbSetup dSIAdbSetup = (DSIAdbSetup)dSIProxy.getService(this.target, class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = StateMSInit.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup);
        DSIListener dSIListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = StateMSInit.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener);
        dSIAdbSetup.setNotification(1, dSIListener);
    }

    private void initOrganizerDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.target.dsiAdbList = (DSIAdbList)dSIProxy.getService(this.target, class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = StateMSInit.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 2);
        this.target.adbListListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.target.getHsm(), class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = StateMSInit.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener);
        dSIProxy.addResponseListener(this.target, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = StateMSInit.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 2, this.target.adbListListener);
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

