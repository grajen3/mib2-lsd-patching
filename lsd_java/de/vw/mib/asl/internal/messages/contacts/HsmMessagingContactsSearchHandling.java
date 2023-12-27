/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.contacts;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.messages.AbstractASLHsmMessagesTarget;
import de.vw.mib.asl.internal.messages.contacts.StateContactsSearchHandlingInit;
import de.vw.mib.asl.internal.messages.contacts.StateContactsSearchHandlingRemoveCharacter;
import de.vw.mib.asl.internal.messages.contacts.StateContactsSearchHandlingSearchHandling;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.speller.filter.SpellerFilter;
import de.vw.mib.speller.filter.SpellerFilterListener;
import de.vw.mib.util.StringUtil;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Properties;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DataSet;

public class HsmMessagingContactsSearchHandling
extends AbstractASLHsmMessagesTarget
implements SpellerFilter {
    protected DSIAdbList dsiAdbList;
    protected DSIListener dsiAdbListListener;
    final HsmState stateInit;
    final HsmState stateContactsSearchHandling;
    final HsmState stateRemoveCharacter;
    SpellerData spellerData = new SpellerData();
    protected int phoneContactsSize = 0;
    protected boolean restartSpeller = false;
    protected int restartSpellerMode = 0;
    protected boolean operationPending = false;
    protected SpellerFilterListener spellerFilterListener;
    protected ArrayList cachedCharacters = new ArrayList();
    protected int invalidCharacters = 0;
    protected String validChars = "";
    protected String uniqueChars = "";
    protected String southsideValidChars = "";
    protected String southsideUniqueChars = "";
    protected DataSet[] southsideDataSets = null;
    protected int southsideTotalHits = 0;
    protected int addedCharacterIndex = 0;
    protected boolean isHWRActive = false;
    protected int selectionStart = 0;
    protected int selectionEnd = 0;
    protected int cursorPosition = 0;
    protected String replaceChar = "";
    private boolean alreadyRegistered = false;
    static /* synthetic */ Class class$de$vw$mib$speller$filter$SpellerFilter;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;

    public HsmMessagingContactsSearchHandling(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.stateInit = new StateContactsSearchHandlingInit(this, genericEvents, this.hsm, "MessagingContactsSearchHandlingTop", this.getWorkStateParent());
        this.stateContactsSearchHandling = new StateContactsSearchHandlingSearchHandling(this, genericEvents, this.hsm, "MessagingContactsSearchHandlingSearchHandling", this.stateInit);
        this.stateRemoveCharacter = new StateContactsSearchHandlingRemoveCharacter(this, genericEvents, this.hsm, "MessagingContactsSearchHandlingRemoveCharacter", this.stateInit);
    }

    @Override
    public int getDefaultTargetId() {
        return 5282;
    }

    protected void registerSpellerFilter() {
        Properties properties = new Properties();
        properties.put("FilterId", String.valueOf(2));
        ServiceManager.bundleContext.registerService((class$de$vw$mib$speller$filter$SpellerFilter == null ? (class$de$vw$mib$speller$filter$SpellerFilter = HsmMessagingContactsSearchHandling.class$("de.vw.mib.speller.filter.SpellerFilter")) : class$de$vw$mib$speller$filter$SpellerFilter).getName(), (Object)this, (Dictionary)properties);
        HsmMessagingContactsSearchHandling.writeBooleanToDatapool(-578611968, true);
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiAdbList = (DSIAdbList)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = HsmMessagingContactsSearchHandling.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 1);
            this.dsiAdbListListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = HsmMessagingContactsSearchHandling.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = HsmMessagingContactsSearchHandling.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 1, this.dsiAdbListListener);
            this.addObserver(-1296364224);
            this.addObserver(-1480913600);
            this.addObserver(-1497690816);
            this.addObserver(-1464136384);
            this.addObserver(-1447359168);
            this.addObserver(-1397027520);
            this.addObserver(-1514468032);
            this.addObserver(-1279587008);
            this.addObserver(-1262809792);
            this.addObserver(-519438272);
            this.addObserver(-502661056);
            this.registerSpellerFilter();
        }
        this.alreadyRegistered = true;
    }

    protected void setNotification() {
        this.dsiAdbList.setNotification(1, this.dsiAdbListListener);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public void filterCharacters(String[] stringArray) {
        if (this.isHWRActive) {
            if (this.spellerFilterListener != null && stringArray != null) {
                ArrayList arrayList = new ArrayList(stringArray.length);
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    if (stringArray[i2] != null) {
                        String string;
                        if (stringArray[i2].length() > 1) {
                            this.warn("recognized character contains more than one character. It will be truncated.");
                        }
                        if (arrayList.contains(string = stringArray[i2].substring(0, 1).toLowerCase())) continue;
                        arrayList.add(string);
                        continue;
                    }
                    this.error("one of the recognized characters is null!");
                }
                this.spellerFilterListener.setFilteredCharacters(StringUtil.filterStringList((String[])arrayList.toArray(new String[arrayList.size()]), this.validChars));
            }
        } else {
            this.spellerFilterListener.setFilteredCharacters(stringArray);
        }
    }

    @Override
    public void initFilter(SpellerFilterListener spellerFilterListener) {
        this.spellerFilterListener = spellerFilterListener;
    }

    @Override
    public void releaseFilter() {
        this.spellerFilterListener = null;
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

