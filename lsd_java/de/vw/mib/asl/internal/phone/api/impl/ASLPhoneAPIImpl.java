/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.api.impl;

import de.vw.mib.asl.api.media.AlphabeticalScrollBarInfo;
import de.vw.mib.asl.api.phone.ASLPhoneAPI;
import de.vw.mib.asl.api.phone.PhonePersistence;
import de.vw.mib.asl.api.phone.PhoneService;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.api.impl.PhoneServiceImpl;
import de.vw.mib.asl.internal.phone.contacts.PhoneSearchFetcher;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.phone.contacts.transformer.PhoneContactsSelectedContactCollector;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.PhoneData;
import org.dsi.ifc.telephoneng.ActivationStateStruct;

public class ASLPhoneAPIImpl
implements ASLPhoneAPI {
    @Override
    public AddressData[] ripADBAddressData(AddressData[] addressDataArray) {
        return PhoneUtil.ripADBAddressData(addressDataArray);
    }

    @Override
    public int convertPhoneTypeDSI2ASLCombined(int n) {
        return PhoneUtil.convertPhoneTypeDSI2ASLCombined(n);
    }

    @Override
    public EventGeneric createSingleEntryEvent(int n, int n2, long l) {
        return PhoneUtil.createSingleEntryEvent(n, n2, l);
    }

    @Override
    public PhoneData[] ripADBPhoneData(PhoneData[] phoneDataArray) {
        return PhoneUtil.ripADBPhoneData(phoneDataArray);
    }

    @Override
    public int getRequestedPhoneAudioConnection() {
        return ASLPhoneData.getInstance().activePhoneAudioConnection;
    }

    @Override
    public int getTelMode() {
        return ASLPhoneData.getInstance().telMode;
    }

    @Override
    public int getTelModeNad() {
        return ASLPhoneData.getInstance().telModeNad;
    }

    @Override
    public ActivationStateStruct getActivationStateNad() {
        return ASLPhoneData.getInstance().activationStateNad;
    }

    @Override
    public int getLockState() {
        return ASLPhoneData.getInstance().lockState;
    }

    @Override
    public int getPhoneFetcherSpellerHandle() {
        return PhoneSearchFetcher.spellerHandle;
    }

    @Override
    public boolean isCallsActive() {
        return ASLPhoneData.getInstance().isCallsAvailable;
    }

    @Override
    public boolean isToggleOtherPINRequested() {
        return ASLPhoneData.getInstance().isToggleOtherPINrequested;
    }

    @Override
    public PhonePersistence getPersistence() {
        return ASLPhoneData.persistence;
    }

    @Override
    public AlphabeticalScrollBarInfo getDefaultCharacterInfo() {
        return ASLPhoneData.getInstance().defaultCharacterInfo;
    }

    @Override
    public AlphabeticalScrollBarInfo getCharacterInfos() {
        return ASLPhoneData.getInstance().characterInfos;
    }

    @Override
    public ResourceLocator contactPictureFromSelectedContacts(long l) {
        PhoneContactsSelectedContactCollector phoneContactsSelectedContactCollector;
        if (ListManager.getGenericASLList(1188).isValidItem(ListManager.getGenericASLList(1188).getListItemByIdCacheOnly(l)) && (phoneContactsSelectedContactCollector = (PhoneContactsSelectedContactCollector)ListManager.getGenericASLList(1188).getListItemByIdCacheOnly(l)) != null) {
            return phoneContactsSelectedContactCollector.phone_contacts_selected_contact_picture;
        }
        return null;
    }

    @Override
    public boolean isPhoneReminderPopupRequired() {
        ASLPhoneData aSLPhoneData = ASLPhoneData.getInstance();
        return aSLPhoneData.phoneReminderSetting && (aSLPhoneData.btPhoneConnected || aSLPhoneData.adrdlConnected || aSLPhoneData.carPlayConnected);
    }

    @Override
    public PhoneService getPhoneService() {
        return PhoneServiceImpl.getInstance();
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(0, 5258, -1813105152);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5250, -1527892480, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5250, -1511115264, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5250, -1494338048, true);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5250, -147102144);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5252, -2047986176);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5252, -1477560832);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5254, -2047986176);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5252, -2031208960);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5254, -2031208960);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5263, -2064763392);
        PreRegisteredIds.addServiceOrObserverToArray(0, 1922634752, -1578224128, true);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5257, 1862467648);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5257, 285868096);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5257, 2114125888);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5257, -2130509760);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5257, 2130903104);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5257, -2147286976);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5257, 2080571456);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5257, 2097348672);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5257, 2013462592);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5257, -2113732544);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5257, -1358495680);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5257, -1745996288, true);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5259, 1879244864);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5259, 2063794240);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5259, 319488064);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5259, 1896022080);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5259, 1912799296);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5259, 1845690432);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5259, 1963130944);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5259, -2013069248);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5259, 1996685376);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5259, 2013462592);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5259, -570228672);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5259, -100204480);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5259, 302645312);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5259, -284557248);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5259, -396618432);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5259, -1813105152);
        PreRegisteredIds.addServiceOrObserverToArray(1, 5259, -1712441856);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5259, -1544669696, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5259, -1427229184, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5259, -2098317824);
        PreRegisteredIds.addServiceOrObserverToArray(1, 5259, -2115095040);
        PreRegisteredIds.addServiceOrObserverToArray(1, 5259, -1595001344);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5259, -1393674752);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -1610416064);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -1492516800);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -1475739584);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -430172864);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -1067707072);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -1560084416);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -1543307200);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -1492975552);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -1526529984);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -1375535040);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -1409089472);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5254, -1392312256);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -1509752768);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5254, -1341980608);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5254, -1291648960);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5254, -1542848448);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5254, -1258094528);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5254, -748939968);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5254, -1207762880);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5254, -1325203392);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5254, -1308426176);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5254, -1190985664);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5254, -1174208448);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -1174208448);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5254, -883157696);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5254, -163879360);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5254, -1459421120);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5254, -1476198336);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5254, -1358757824);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -1627193280);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, 1711472704);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -1425866688);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -1017375424);
        PreRegisteredIds.addServiceOrObserverToArray(1, 1922634752, -1695664640);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -331651520);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -314874304);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -298097088);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -281319872);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -264542656);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -247765440);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -230988224);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, -214211008);
        PreRegisteredIds.addServiceOrObserverToArray(2, 1922634752, 520699136);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5254, -429443840);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5261, -1006436288);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5261, -972881856);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5261, -989659072);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5261, -1023213504);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5261, -933489344);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5261, -429443840);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5264, -670891968);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5264, -687669184);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5264, -368508864);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5264, -654114752);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5264, -413395648);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5264, -446950080);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5264, -849603264);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5264, 0x440B0040);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5264, 1124794432);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5264, -698608320);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5264, 1108017216);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5264, 1175126080);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5264, -180656576);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5264, -381983168);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5264, -398760384);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5264, -2098317824);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5262, 671350848);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5262, 654573632);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5262, 520355904);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5262, 688128064);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5262, 553910336);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5262, -2047986176);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5262, -2031208960);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5262, 369704192);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5262, 386481408);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5251, 336199744);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5251, 352976960);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5251, -788332480);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5251, -754778048);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5251, -738000832);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5251, -547613376);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5251, -530836160);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5252, 554982656);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5252, 571759872);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5252, 622091520);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5252, 638868736);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5251, -1030070784);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5251, -1013293568);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5251, 1024744704);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5251, -1662110208, true);
        PreRegisteredIds.addServiceOrObserverToArray(1, 5251, -1628555776);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5251, -1611778560, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5251, -1460783616, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5251, -1444006400, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5251, -1410451968, true);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5251, -1393674752);
    }
}

