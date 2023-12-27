/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.search;

import de.vw.mib.asl.api.navigation.NavigationConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.navigation.memory.search.MemorySearchDataPool;
import de.vw.mib.asl.internal.navigation.memory.search.StateMSAddSpellerChar;
import de.vw.mib.asl.internal.navigation.memory.search.StateMSDeleteSpellerChar;
import de.vw.mib.asl.internal.navigation.memory.search.StateMSInit;
import de.vw.mib.asl.internal.navigation.memory.search.StateMSLastDestMemMode;
import de.vw.mib.asl.internal.navigation.memory.search.StateMSMain;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.Dictionary;
import java.util.Properties;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbList;

public final class HsmTargetMemorySearch
extends AbstractASLHsmTarget
implements ASLListElementFetcher {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[HsmTargetMemorySearch]");
    DSIAdbList dsiAdbList;
    DSIListener adbListListener;
    private final StateMSInit stateInit = new StateMSInit(this, "StateMSInit", this.getWorkStateParent());
    private final StateMSMain stateMain;
    private final StateMSDeleteSpellerChar stateDeleteSpellerChar;
    private final StateMSAddSpellerChar stateAddSpellerChar;
    private final StateMSLastDestMemMode stateLastDestMem = new StateMSLastDestMemMode(this, "StateMSLastDestMemMode", (HsmState)this.stateInit);
    static /* synthetic */ Class class$de$vw$mib$speller$filter$SpellerFilter;

    public HsmTargetMemorySearch(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.stateMain = new StateMSMain(this, "StateMSMain", (HsmState)this.stateInit);
        this.stateDeleteSpellerChar = new StateMSDeleteSpellerChar(this, "StateMSDeleteSpellerChar", (HsmState)this.stateMain);
        this.stateAddSpellerChar = new StateMSAddSpellerChar(this, "StateMSAddSpellerChar", (HsmState)this.stateMain);
        this.enableHWRModeIfRequired();
    }

    private void enableHWRModeIfRequired() {
        if (NavigationConfiguration.LOCATIONINPUT_CHN_FEATURES_AVAILABLE || ServiceManager.configManagerDiag.isFeatureFlagSet(75)) {
            Properties properties = new Properties();
            int n = 200;
            properties.put("FilterId", String.valueOf(n));
            ServiceManager.bundleContext.registerService((class$de$vw$mib$speller$filter$SpellerFilter == null ? (class$de$vw$mib$speller$filter$SpellerFilter = HsmTargetMemorySearch.class$("de.vw.mib.speller.filter.SpellerFilter")) : class$de$vw$mib$speller$filter$SpellerFilter).getName(), (Object)this.getDataPool().getSpellerFilter(), (Dictionary)properties);
            HsmTargetMemorySearch.writeBooleanToDatapool(-578611968, true);
        }
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    protected void transStateInit() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("transStateInit()");
        }
        this.getHsm().trans(this.stateInit);
    }

    protected void transStateInitAndForwardEvent(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("transStateInitAndForwardEvent()");
        }
        GenericEventFactory genericEventFactory = new GenericEventFactory();
        EventGeneric eventGeneric2 = genericEventFactory.newEvent(eventGeneric);
        this.getHsm().trans(this.stateInit);
        eventGeneric2.setReceiverTargetId(this.getTargetId());
        this.send(eventGeneric2);
    }

    protected void transStateMain() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("transStateMain()");
        }
        this.getHsm().trans(this.stateMain);
    }

    protected void transStateAddSpellerChar(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("transStateAddSpellerChar()");
        }
        this.stateAddSpellerChar.setAddCharEvent(eventGeneric);
        this.getHsm().trans(this.stateAddSpellerChar);
    }

    protected void transStateDeleteSpellerChar(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("transStateDeleteSpellerChar()");
        }
        this.stateDeleteSpellerChar.setDeleteCharEvent(eventGeneric);
        this.getHsm().trans(this.stateDeleteSpellerChar);
    }

    protected void transStateLastDestMem() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("transStateLastDestMem()");
        }
        this.getHsm().trans(this.stateLastDestMem);
    }

    MemorySearchDataPool getDataPool() {
        return MemorySearchDataPool.getInstance();
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmTargetMemorySearch - fetchItems() [viewType=").append(this.getDataPool().getLastUsedSearchType()).append(", index=").append(n).append(", count=").append(n2).append("]").log();
        }
        if (this.getDataPool().getSpellerHandle() != -2) {
            int n3 = n == 0 ? 4 : 6;
            this.dsiAdbList.getSpellerViewWindow(this.getDataPool().getSpellerHandle(), n, n3, this.getDataPool().getLastUsedSearchType(), n2);
        }
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
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

