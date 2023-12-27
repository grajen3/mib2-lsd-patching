/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence.PersistenceReadCallback;
import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.framework.internal.persistence.internal.db.ApiPersDb;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ModuleDescriptorPriorityComparator;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistableService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceKeyProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceKeyUtil;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptor;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptorRegistry;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleRegistrationWaitOperation;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.NamespaceKeyPair;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableReader;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableServiceImpl$1;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableServiceImpl$2;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableServiceImpl$3;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableServiceImpl$4;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableServiceImpl$5;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableWriter;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PreChangeOperation;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.AwaitChangeDone;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.AwaitDsiReady;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.AwaitPreparationDone;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Task;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.UpdateDescriptorProfil;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.asl.framework.internal.persistence.internal.startup.PersistenceStartupServiceImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.util.Preconditions;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectMultimap;
import de.vw.mib.genericevents.GenericEventException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public final class PersistableServiceImpl
implements PersistableService {
    private static final String LOG_PREFIX;
    private final IntObjectMultimap typeSortedGlobalProfileChangeListeners = new IntObjectMultimap();
    private final Map mapModuleName2Module = new HashMap();
    private final ApiPersDb apiPersDb;
    private byte currentProfile = 1;
    private boolean initialProfileSet;
    final Set pendingDataToLoad = new HashSet();
    private final HashMap persistable2MetaInfo = new HashMap();
    private final PersistenceKeyProvider persistenceKeys;
    private PreChangeOperation postChangePreparationOperation;
    private final PersistenceServices services;
    private final ModuleDescriptorRegistry moduleRegistry;
    private boolean isProfileSwitchOngoing;
    private final PersistableReader reader;
    private final PersistableWriter writer;
    private static final boolean DEBUG_FLAG_WAIT_FOR_DSI;

    public PersistableServiceImpl(PersistenceServices persistenceServices) {
        this.services = persistenceServices;
        this.persistenceKeys = persistenceServices.getPersistenceKeyProvider();
        this.apiPersDb = persistenceServices.getApiPersDb();
        this.moduleRegistry = persistenceServices.getModuleDescriptorRegistry();
        this.reader = new PersistableReader(persistenceServices, this.persistable2MetaInfo);
        this.writer = new PersistableWriter(persistenceServices, this.persistable2MetaInfo);
    }

    @Override
    public void activateProfile(byte by) {
        this.services.getPersistenceLogger().trace(new StringBuffer().append("Profile change is requested. Requested profile: ").append(by).toString());
        this.warnIfProfileWasNotSet("activateProfile");
        if (this.currentProfile != by) {
            this.postChangePreparationOperation = null;
            this.internalActivateProfile(by);
        }
    }

    @Override
    public void addGlobalProfileChangeListener(GlobalProfileChangeListener globalProfileChangeListener, int n) {
        this.typeSortedGlobalProfileChangeListeners.put(n, globalProfileChangeListener);
    }

    @Override
    public void addProfileChangeListener(PersistenceModule persistenceModule, ProfileChangeListener profileChangeListener) {
        if (persistenceModule.isUserSpecific()) {
            ModuleDescriptor moduleDescriptor = this.moduleRegistry.getOrCreateDescriptor(persistenceModule);
            moduleDescriptor.addProfileChangeListener(profileChangeListener);
        }
    }

    @Override
    public byte getActiveProfile() {
        this.warnIfProfileWasNotSet("getActiveProfile");
        return this.currentProfile;
    }

    @Override
    public int getCurrentAction() {
        if (this.postChangePreparationOperation != null) {
            return this.postChangePreparationOperation.getCurrentAction();
        }
        return this.isProfileSwitchOngoing() ? 1 : 0;
    }

    @Override
    public boolean isProfileSwitchOngoing() {
        return this.isProfileSwitchOngoing;
    }

    @Override
    public Persistable loadPersistable(PersistenceModule persistenceModule, int n) {
        this.checkModuleInstance(persistenceModule);
        return this.reader.loadPersistable(persistenceModule, n, this.currentProfile);
    }

    @Override
    public void removeGlobalProfileChangeListener(GlobalProfileChangeListener globalProfileChangeListener) {
        IntIterator intIterator = this.typeSortedGlobalProfileChangeListeners.keyIterator();
        while (intIterator.hasNext()) {
            Object object = this.typeSortedGlobalProfileChangeListeners.removeValue(intIterator.next(), globalProfileChangeListener);
            if (object == null) continue;
            return;
        }
    }

    @Override
    public void removeProfileChangeListener(PersistenceModule persistenceModule, ProfileChangeListener profileChangeListener) {
        ModuleDescriptor moduleDescriptor = this.moduleRegistry.getOrCreateDescriptor(persistenceModule);
        if (moduleDescriptor == null) {
            return;
        }
        moduleDescriptor.removeProfileChangeListener(profileChangeListener);
    }

    @Override
    public void setupInitialProfile(byte by) {
        Preconditions.checkState(!this.initialProfileSet, "Inital profile was already set and must only be set once.");
        this.services.getPersistenceLogger().info(new StringBuffer().append("PersistenceService: Initial profile was set to ").append(by).toString());
        this.services.getPerfService().performanceLogProfileChange(0, by);
        ((PersistenceStartupServiceImpl)this.services.getPersistenceStartupService()).notifyInitialStartupProfileSet();
        this.currentProfile = by;
        this.initialProfileSet = true;
    }

    @Override
    public void updateProfile(PreChangeOperation preChangeOperation) {
        this.services.getPersistenceLogger().trace("Profile update is requested.");
        this.warnIfProfileWasNotSet("updateProfile");
        this.postChangePreparationOperation = preChangeOperation;
        this.internalActivateProfile(this.currentProfile);
    }

    @Override
    public void writeDirtyRecords() {
        this.writer.writeDirtyPersistables(this.persistable2MetaInfo);
    }

    @Override
    public byte getInitialProfile() {
        this.warnIfProfileWasNotSet("getInitialProfile");
        return this.currentProfile;
    }

    void changeProfileForLoadedModules(byte by) {
        this.services.getPersistenceLogger().trace(new StringBuffer().append("Changing profile for loaded moules to profile ").append(by).toString());
        this.currentProfile = by;
        this.invalidateUserSpecificPersistables();
        this.performProfileSwitchForModules(by);
    }

    void performProfileSwitchForModules(byte by) {
        TreeSet treeSet = new TreeSet(ModuleDescriptorPriorityComparator.COMPERATOR);
        treeSet.addAll(this.moduleRegistry.getDescriptors());
        Iterator iterator = treeSet.iterator();
        this.performProfileSwitch(by, iterator);
    }

    void performProfileSwitch(byte by, Iterator iterator) {
        if (iterator.hasNext()) {
            ModuleDescriptor moduleDescriptor = (ModuleDescriptor)iterator.next();
            this.performProfileChange(moduleDescriptor, by, iterator);
        } else {
            this.finishProfileSwitch();
        }
    }

    void performProfileChange(PersistenceModule persistenceModule, byte by, Iterator iterator) {
        ModuleDescriptor moduleDescriptor = this.moduleRegistry.getOrCreateDescriptor(persistenceModule);
        Collection collection = moduleDescriptor.getProfileChangeListeners();
        ProfileChanger profileChanger = new ProfileChanger(this.services, persistenceModule, collection);
        if (collection.isEmpty()) {
            profileChanger.appendTask(this.logProfileChangeSkipped());
        } else {
            if (DEBUG_FLAG_WAIT_FOR_DSI) {
                profileChanger.appendTask(new AwaitDsiReady());
            }
            profileChanger.appendTask(new UpdateDescriptorProfil(by));
            profileChanger.appendTask(new AwaitPreparationDone());
            profileChanger.appendTask(new AwaitChangeDone(this.persistable2MetaInfo, this.postChangePreparationOperation));
        }
        profileChanger.appendTask(this.changeNextModule(by, iterator));
        profileChanger.run();
    }

    void finishProfileSwitch() {
        this.isProfileSwitchOngoing = false;
        this.postChangePreparationOperation = null;
        if (!this.checkIsStartupChangeModeActive()) {
            this.notifyGlobalProfileChangeListenersCompleted(10);
        }
        this.notifyGlobalProfileChangeListenersCompleted(0);
        this.services.getPerfService().performanceLogProfileChange(2, this.currentProfile);
        this.services.getPersistenceLogger().info("Profile switch is completed.");
    }

    private ProfileChanger$Task logProfileChangeSkipped() {
        return new PersistableServiceImpl$1(this);
    }

    private void invalidateUserSpecificPersistables() {
        this.reader.evictUserSpecificPersistables();
    }

    private void performProfileChange(ModuleDescriptor moduleDescriptor, byte by, Iterator iterator) {
        int n = moduleDescriptor.getNamespace();
        Runnable runnable = this.changeProfileForRegisteredModule(moduleDescriptor, by, iterator);
        Runnable runnable2 = this.changeNextProfile(by, iterator);
        ModuleRegistrationWaitOperation moduleRegistrationWaitOperation = new ModuleRegistrationWaitOperation(this.services, n, runnable, runnable2);
        moduleRegistrationWaitOperation.run();
    }

    private Runnable changeProfileForRegisteredModule(ModuleDescriptor moduleDescriptor, byte by, Iterator iterator) {
        return new PersistableServiceImpl$2(this, moduleDescriptor, by, iterator);
    }

    private Runnable changeNextProfile(byte by, Iterator iterator) {
        return new PersistableServiceImpl$3(this, by, iterator);
    }

    private void checkModuleInstance(PersistenceModule persistenceModule) {
        if (!this.mapModuleName2Module.containsKey(persistenceModule.getName())) {
            String string = persistenceModule.getName();
            this.mapModuleName2Module.put(string, persistenceModule);
        }
        if (this.mapModuleName2Module.get(persistenceModule.getName()) != persistenceModule) {
            this.services.getPersistenceLogger().error(new StringBuffer().append("[PersistableServiceImpl] Multiple instances of persistence modules are not supported, however they are created for module ").append(persistenceModule.getName()).toString(), new Exception("Invoked from:"));
        }
    }

    private void assureNoProfileChangeIsRunning() {
        if (this.isProfileSwitchOngoing()) {
            String string = "Cannot activate an other profile since a profile switch is already ongoing.";
            this.services.getPersistenceLogger().error(string);
            throw new IllegalStateException(string);
        }
    }

    private Iterator getGlobalListenerIterator(int n) {
        return this.typeSortedGlobalProfileChangeListeners.getAll(n).iterator();
    }

    private void internalActivateProfile(byte by) {
        this.assureNoProfileChangeIsRunning();
        this.services.getPersistenceLogger().info(new StringBuffer().append("Changing profile from ").append(this.getActiveProfile()).append(" to ").append(by).append(". Startup change mode active: ").append(this.checkIsStartupChangeModeActive()).toString());
        this.services.getPerfService().performanceLogProfileChange(1, by);
        this.isProfileSwitchOngoing = true;
        this.notifyGlobalProfileChangeListenersStart(0);
        if (!this.checkIsStartupChangeModeActive()) {
            this.notifyGlobalProfileChangeListenersStart(10);
        }
        this.registerVariantPersistableNamespaces();
        this.loadUserSpecificDataFromDsi(by);
    }

    private void registerVariantPersistableNamespaces() {
        int[] nArray = this.services.getAslStartupApi().getVariantPersistenceNamespaceIds();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            this.moduleRegistry.getOrCreateDescriptor(n);
        }
    }

    private void loadUserSpecificDataFromDsi(byte by) {
        this.services.getPersistenceLogger().trace(new StringBuffer().append("Loading user specific data from DSI for profile ").append(by).toString());
        this.collectDataToRead(by);
        this.readDataFromDsi(by);
    }

    private void collectDataToRead(byte by) {
        int[] nArray = this.persistenceKeys.retrieveNamespaceIds();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            int[] nArray2 = this.persistenceKeys.retrieveUserSpecificPersistableIds(n);
            for (int i3 = 0; i3 < nArray2.length; ++i3) {
                int n2 = nArray2[i3];
                long l = PersistenceKeyUtil.calcUserKey(n2, by);
                boolean bl = this.apiPersDb.isDataLoaded(n, l);
                if (bl) continue;
                this.pendingDataToLoad.add(new NamespaceKeyPair(n, l));
            }
        }
    }

    private void readDataFromDsi(byte by) {
        if (this.pendingDataToLoad.isEmpty()) {
            this.changeProfileForLoadedModules(by);
            return;
        }
        PersistenceReadCallback persistenceReadCallback = this.createPersistenceReadCallback(by);
        Iterator iterator = this.pendingDataToLoad.iterator();
        while (iterator.hasNext()) {
            NamespaceKeyPair namespaceKeyPair = (NamespaceKeyPair)iterator.next();
            try {
                this.services.getAslPersistenceAsyncApi().readByteArray(persistenceReadCallback, namespaceKeyPair.getNamespace(), namespaceKeyPair.getKey());
            }
            catch (GenericEventException genericEventException) {
                this.services.getPersistenceLogger().error("Error while reading data from dsi", genericEventException);
            }
        }
    }

    private PersistenceReadCallback createPersistenceReadCallback(byte by) {
        PersistenceServices persistenceServices = this.services;
        return new PersistableServiceImpl$4(this, persistenceServices, by);
    }

    private void notifyGlobalProfileChangeListenersCompleted(int n) {
        Iterator iterator = this.getGlobalListenerIterator(n);
        while (iterator.hasNext()) {
            GlobalProfileChangeListener globalProfileChangeListener = (GlobalProfileChangeListener)iterator.next();
            this.services.getPersistenceLogger().trace(new StringBuffer().append("notifyGlobalProfileChangeListenersCompleted on: ").append(globalProfileChangeListener).toString());
            globalProfileChangeListener.onProfileChangeCompleted();
        }
    }

    private void notifyGlobalProfileChangeListenersStart(int n) {
        Iterator iterator = this.getGlobalListenerIterator(n);
        while (iterator.hasNext()) {
            GlobalProfileChangeListener globalProfileChangeListener = (GlobalProfileChangeListener)iterator.next();
            globalProfileChangeListener.onProfileChangeStarted();
        }
    }

    private ProfileChanger$Task changeNextModule(byte by, Iterator iterator) {
        return new PersistableServiceImpl$5(this, by, iterator);
    }

    private void warnIfProfileWasNotSet(String string) {
        if (!this.initialProfileSet) {
            this.services.getPersistenceLogger().warning(new StringBuffer().append("PersistenceService#").append(string).append("() was invoked before the initial profile was set.").toString());
        }
    }

    private boolean checkIsStartupChangeModeActive() {
        return this.services.getPersistenceStartupService().getProfileChangeMode() == 0;
    }

    static {
        String string = System.getProperty("de.vw.mib.system.persistence.waitForDsi", "true");
        DEBUG_FLAG_WAIT_FOR_DSI = Boolean.getBoolean(string);
    }
}

