/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.speech;

import de.vw.mib.asl.api.speechengine.SpeechEngine;
import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettings;
import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettingsListener;
import de.vw.mib.asl.api.speechengine.messenger.application.ApplicationStateConsumer;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateConsumer;
import de.vw.mib.asl.api.speechengine.messenger.indicator.IndicatorStateConsumer;
import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterData;
import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterTextEntry;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.bap.mqbab2.common.api.APIFactory;
import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.asl.HMIRelevantASLDataPoolAdapter;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechASLDataAdapter$1;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechService;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechServiceListener;
import de.vw.mib.bap.mqbab2.common.api.speech.datatypes.SpeechCommandImpl;
import de.vw.mib.bap.mqbab2.common.api.speech.listener.SpeechEngineTeleprompterDataListener;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SpeechASLDataAdapter
extends HMIRelevantASLDataPoolAdapter
implements SpeechService,
IndicatorStateConsumer,
ApplicationStateConsumer,
DialogStateConsumer,
SpeechSettingsListener,
ServiceTrackerCustomizer {
    private APIFactoryInterface apiFactory;
    private SpeechEngine speechEngine;
    private SpeechEngineMaster speechEngineMaster;
    private static final int SPEECH_CLIENT_BAP;
    private static final int[] SPEECH_ASL_PROPERTY_IDS_TO_LISTEN_TO;
    private static final int[] SPEECH_ASL_LIST_ITEM_IDS_TO_LISTEN_TO;
    private static final int[] SPEECH_HMI_EVENT_IDS_TO_LISTEN_TO;
    private static final String EMPTY_STRING;
    private static final List EMPTY_LIST;
    private static final String COMMAND_LINE_BREAK_TOKEN;
    private static final int MAX_NUMBER_OF_COMMANDS;
    private List splittedSpeechCommands;
    private boolean speechActive = false;
    boolean isSdsSdInMenuActive = false;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngine;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$common$api$speech$SpeechService;

    public SpeechASLDataAdapter(APIFactoryInterface aPIFactoryInterface, ASLDatapool aSLDatapool) {
        super(aSLDatapool);
        this.apiFactory = aPIFactoryInterface;
        this.apiFactory.getHMIEventService().addHMIEventListener(this, SPEECH_HMI_EVENT_IDS_TO_LISTEN_TO);
        this.register();
        ServiceTracker serviceTracker = new ServiceTracker(ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext(), (class$de$vw$mib$asl$api$speechengine$SpeechEngine == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngine = SpeechASLDataAdapter.class$("de.vw.mib.asl.api.speechengine.SpeechEngine")) : class$de$vw$mib$asl$api$speechengine$SpeechEngine).getName(), (ServiceTrackerCustomizer)this);
        serviceTracker.open();
        ServiceTracker serviceTracker2 = new ServiceTracker(ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext(), (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster = SpeechASLDataAdapter.class$("de.vw.mib.asl.api.speechengine.SpeechEngineMaster")) : class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster).getName(), (ServiceTrackerCustomizer)new SpeechASLDataAdapter$1(this));
        serviceTracker2.open();
    }

    protected APIFactoryInterface getAPIFactory() {
        return this.apiFactory;
    }

    public static Class getServiceClass() {
        return class$de$vw$mib$bap$mqbab2$common$api$speech$SpeechService == null ? (class$de$vw$mib$bap$mqbab2$common$api$speech$SpeechService = SpeechASLDataAdapter.class$("de.vw.mib.bap.mqbab2.common.api.speech.SpeechService")) : class$de$vw$mib$bap$mqbab2$common$api$speech$SpeechService;
    }

    private List getSpeechCommandSplitList() {
        if (this.splittedSpeechCommands == null) {
            this.splittedSpeechCommands = new ArrayList(3);
        }
        return this.splittedSpeechCommands;
    }

    private void splitSpeechCommands(List list) {
        boolean bl = APIFactory.getAPIFactory().getPersistenceService().getInstrumentClusterDisplaySize() != 0;
        int n = bl ? 4 : 3;
        List list2 = this.getSpeechCommandSplitList();
        list2.clear();
        int n2 = 0;
        for (int i2 = 0; i2 < list.size() && n2 < n; ++i2) {
            TeleprompterTextEntry teleprompterTextEntry = (TeleprompterTextEntry)list.get(i2);
            String[] stringArray = StringUtil.split(teleprompterTextEntry.getText(), "\\n");
            if (n2 + stringArray.length > n) continue;
            for (int i3 = 0; i3 < stringArray.length; ++i3) {
                list2.add(n2, new SpeechCommandImpl(stringArray[i3], teleprompterTextEntry.containsDynamicParts()));
                ++n2;
            }
        }
        if (!list.isEmpty() && bl) {
            list2.add(0, new SpeechCommandImpl("", false));
        }
    }

    @Override
    public boolean isSpeechDomainAvailable() {
        return this.speechEngine != null;
    }

    @Override
    public int getIndicatorState() {
        return this.speechEngine != null ? this.speechEngine.getIndicatorStateRouter().getIndicatorState() : 1;
    }

    @Override
    public int getSpeechApplicationState() {
        return this.speechEngine != null ? this.speechEngine.getApplicationStateRouter().getApplicationState() : 0;
    }

    @Override
    public boolean isSpeechActive() {
        return this.speechActive;
    }

    @Override
    public void performingBAPAction(int n) {
        if (this.speechEngineMaster != null) {
            this.speechEngineMaster.getDialogManager(15).endSession(true);
        }
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                SpeechServiceListener speechServiceListener = (SpeechServiceListener)iterator.next();
                speechServiceListener.updateSpeechData(this, n);
            }
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return SPEECH_ASL_PROPERTY_IDS_TO_LISTEN_TO;
    }

    @Override
    protected int[] getListIds() {
        return SPEECH_ASL_LIST_ITEM_IDS_TO_LISTEN_TO;
    }

    @Override
    protected void listValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    public void addSpeechServiceListener(SpeechServiceListener speechServiceListener, int[] nArray) {
        this.registerServiceListener((Object)speechServiceListener, nArray);
    }

    @Override
    public void removeSpeechServiceListener(SpeechServiceListener speechServiceListener, int[] nArray) {
        this.removeServiceListener(speechServiceListener, nArray);
    }

    @Override
    public void onIndicatorStateChange(int n) {
        this._notifyServiceDelegates(-402456448);
    }

    @Override
    public void onApplicationStateChanged(int n) {
        this._notifyServiceDelegates(-385679232);
    }

    @Override
    public void onDialogStateChanged(int n) {
        if (n == 2) {
            this.speechActive = true;
            this._notifyServiceDelegates(-368902016);
        } else if (n == 3) {
            this.speechActive = false;
            this._notifyServiceDelegates(-368902016);
        }
    }

    public void onTeleprompterDataChanged(TeleprompterData teleprompterData) {
        this.splitSpeechCommands(teleprompterData.getCommandExamples());
        this._notifyServiceDelegates(-352124800);
    }

    @Override
    public int getTeleprompterType() {
        if (this.speechEngine != null && this.speechEngine.getTeleprompterDataManager(15).getTeleprompterData() != null) {
            return this.speechEngine.getTeleprompterDataManager(15).getTeleprompterData().getTeleprompterType();
        }
        return 1;
    }

    @Override
    public String getHeadline() {
        if (this.speechEngine != null && this.speechEngine.getTeleprompterDataManager(15).getTeleprompterData() != null && this.speechEngine.getTeleprompterDataManager(15).getTeleprompterData().getHeadlineTitle() != null) {
            return this.speechEngine.getTeleprompterDataManager(15).getTeleprompterData().getHeadlineTitle().getText();
        }
        return "";
    }

    @Override
    public boolean isHeadlineDynamic() {
        if (this.speechEngine != null && this.speechEngine.getTeleprompterDataManager(15).getTeleprompterData() != null && this.speechEngine.getTeleprompterDataManager(15).getTeleprompterData().getHeadlineTitle() != null) {
            return this.speechEngine.getTeleprompterDataManager(15).getTeleprompterData().getHeadlineTitle().containsDynamicParts();
        }
        return false;
    }

    @Override
    public List getCommands() {
        if (this.speechEngine != null && this.speechEngine.getTeleprompterDataManager(15).getTeleprompterData() != null) {
            return this.getSpeechCommandSplitList();
        }
        return EMPTY_LIST;
    }

    @Override
    public void onSpeechSettingsUpdated(SpeechSettings speechSettings) {
        if (this.isSdsSdInMenuActive != speechSettings.isDisplayAvailableCommandsOnICActivated()) {
            this.isSdsSdInMenuActive = speechSettings.isDisplayAvailableCommandsOnICActivated();
            this._notifyServiceDelegates(-335347584);
        }
    }

    @Override
    public boolean isSdsSdInMenuActive() {
        if (this.speechEngine != null && this.speechEngine.getSpeechConfigurator(15).getSpeechSettingsManager().getSpeechSettings() != null) {
            return this.speechEngine.getSpeechConfigurator(15).getSpeechSettingsManager().getSpeechSettings().isDisplayAvailableCommandsOnICActivated();
        }
        return true;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext().getService(serviceReference);
        this.speechEngine = (SpeechEngine)object;
        this.speechEngine.getApplicationStateRouter().register(this);
        this.speechEngine.getIndicatorStateRouter().register(this);
        this.speechEngine.getDialogStateRouter().register(this);
        this.speechEngine.getTeleprompterDataManager(15).register(new SpeechEngineTeleprompterDataListener(this));
        this.speechEngine.getSpeechConfigurator(15).getSpeechSettingsManager().register(this);
        this._notifyServiceDelegates(-419233664);
        return object;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ SpeechEngineMaster access$002(SpeechASLDataAdapter speechASLDataAdapter, SpeechEngineMaster speechEngineMaster) {
        speechASLDataAdapter.speechEngineMaster = speechEngineMaster;
        return speechASLDataAdapter.speechEngineMaster;
    }

    static /* synthetic */ SpeechEngineMaster access$000(SpeechASLDataAdapter speechASLDataAdapter) {
        return speechASLDataAdapter.speechEngineMaster;
    }

    static {
        SPEECH_ASL_PROPERTY_IDS_TO_LISTEN_TO = new int[0];
        SPEECH_ASL_LIST_ITEM_IDS_TO_LISTEN_TO = new int[0];
        SPEECH_HMI_EVENT_IDS_TO_LISTEN_TO = new int[]{352};
        EMPTY_LIST = new ArrayList();
    }
}

