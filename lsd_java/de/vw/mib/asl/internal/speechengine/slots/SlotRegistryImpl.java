/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.slots;

import de.vw.mib.asl.api.speechengine.slots.SlotDefinition;
import de.vw.mib.asl.api.speechengine.slots.SlotRegistry;
import de.vw.mib.asl.internal.speechengine.slots.SlotDefinitionImpl;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.Iterator;

public class SlotRegistryImpl
implements SlotRegistry {
    private IntObjectOptHashMap slotIdMap = new IntObjectOptHashMap();

    @Override
    public SlotDefinition getSlot(int n) {
        return (SlotDefinition)this.getSlotIdMap().get(n);
    }

    @Override
    public SlotDefinition getSlot(String string) {
        Iterator iterator = this.getSlotIdMap().valueIterator();
        while (iterator.hasNext()) {
            SlotDefinition slotDefinition = (SlotDefinition)iterator.next();
            if (!slotDefinition.getSlotName().equals(string)) continue;
            return slotDefinition;
        }
        return null;
    }

    public SlotDefinition[] getAllSlots() {
        Object[] objectArray = new SlotDefinition[this.getSlotIdMap().size()];
        this.getSlotIdMap().valuesToArray(objectArray);
        return objectArray;
    }

    private void put(SlotDefinitionImpl slotDefinitionImpl) {
        this.getSlotIdMap().put(slotDefinitionImpl.getSlotId(), slotDefinitionImpl);
    }

    public SlotRegistryImpl() {
        this.put(new SlotDefinitionImpl("AVDC.Audio.CD_DA.tracknumbers", 1, 2, false, false, false, 0, "supplier grammar of all track numbers for the active CD-DA. The elements must be identifiable by a unique ID."));
        this.put(new SlotDefinitionImpl("AVDC.Audio.CompressedAudio.Albums", 2, 1, true, false, true, 0, "supplier grammar of all album names for the active media source. The elements must be identifiable by a unique ID."));
        this.put(new SlotDefinitionImpl("AVDC.Audio.CompressedAudio.Artists", 3, 1, true, false, true, 0, "supplier grammar of all artist names for the active media source. The elements must be identifiable by a unique ID."));
        this.put(new SlotDefinitionImpl("AVDC.Audio.CompressedAudio.Genres", 4, 1, true, false, true, 0, "supplier grammar of all genre names for the active media source. The elements must be identifiable by a unique ID."));
        this.put(new SlotDefinitionImpl("AVDC.Audio.CompressedAudio.Titles", 5, 1, true, false, true, 0, "supplier grammar of all title names for the active media source. The elements must be identifiable by a unique ID."));
        this.put(new SlotDefinitionImpl("Navigation.DestInput.Housenumber", 10, 1, false, false, false, 3, "list with matching housenumbers when entering a destination address DSINavigation.liStartSpeller(SELCRITDES_HOUSENUMBER) This list is the current view from navigation to spellerResult with crossings. To get the entries of this list, get the current speller list ExampleView: NAV_NEW_ADR_HN_LIST,"));
        this.put(new SlotDefinitionImpl("Navigation.DestInput.HousenumberList", 11, 1, true, false, false, 3, "supplier grammar to recognize housenumber names, filtered by navcore"));
        this.put(new SlotDefinitionImpl("Navigation.DestInput.PostalCodeList", 12, 1, true, false, false, 3, "list with matching zip codes when entering a destination address DSINavigation.liStartSpeller(SELCRITDES_ZIP_CODE) This list is the current view from navigation to spellerResult with crossings. To get the entries of this list, get the current speller list,"));
        this.put(new SlotDefinitionImpl("Navigation.Memory.LastDestMemList", 14, 0, true, false, false, 0, "list of last destinations"));
        this.put(new SlotDefinitionImpl("Navigation.POI.OneShotCategoryList", 15, 1, true, false, false, 0, "static grammar with all POI categories and group categories to search for identified by long CATEGORY_UID; also including brand names DSICall to get the whole list (initialized and set by ASL-Navi): DSINavigation.liStartSpeller(SELCRITDES_POI_CATEGORY_BY_UID) Postfiltering to get the categories of the current selected CategoryGroup: DSICall lispSelectListItem, will set by ASL-Navi. Postfiltering have to be used for every recognition of this grammar. This list will used in NAV_POI_SEARCH_CATEGORY_LIST View."));
        this.put(new SlotDefinitionImpl("Navigation.Speech.CityList", 16, 1, true, true, false, 4, "supplier grammar to recognize city names at destination input for current selected country DSINavigation.liStartSpeller(SELCRITDES_TOWN) Used for VDE to enter a city View: NAV_NEW_DEST_ADR,"));
        this.put(new SlotDefinitionImpl("Navigation.Speech.Combined.NARCountryList", 27, 1, true, false, false, 4, "supplier grammar to recognize country names at location input in NAR"));
        this.put(new SlotDefinitionImpl("Navigation.Speech.Combined.NARStateList", 28, 1, true, false, false, 3, "supplier grammar to recognize state names at location input in NAR"));
        this.put(new SlotDefinitionImpl("Navigation.Speech.CountryList", 18, 1, true, false, false, 4, "supplier grammar to recognize country names at destination input DSINavigation.liStartSpeller(SELCRITDES_COUNTRY) View: NAV_NEW_DEST_ADR,"));
        this.put(new SlotDefinitionImpl("Navigation.Speech.CrossingList", 19, 1, true, true, false, 4, "supplier grammar to recognize street names at destination input for current selected city DSINavigation.liStartSpeller(SELCRITDES_STREET) Used for VDE to enter a crossing,"));
        this.put(new SlotDefinitionImpl("Navigation.Speech.Oneshot.City", 20, 1, true, false, false, 4, "supplier grammar to recognize city names at destination input for current selected country DSINavigation.liStartSpeller(SELCRITDES_TOWN) Used for VDE to enter a city View: NAV_NEW_DEST_ADR,"));
        this.put(new SlotDefinitionImpl("Navigation.Speech.Oneshot.HouseNumber", 22, 1, true, false, false, 3, "list with matching housenumbers when entering a destination address DSINavigation.liStartSpeller(SELCRITDES_HOUSENUMBER) This list is the current view from navigation to spellerResult with crossings. To get the entries of this list, get the current speller list ExampleView: NAV_NEW_ADR_HN_LIST,"));
        this.put(new SlotDefinitionImpl("Navigation.Speech.Oneshot.Street", 24, 1, true, false, false, 4, "supplier grammar to recognize street names at destination input for current selected city DSINavigation.liStartSpeller(SELCRITDES_STREET) Used for VDE to enter a street,"));
        this.put(new SlotDefinitionImpl("Navigation.Speech.StateList", 26, 1, true, false, false, 0, "supplier grammar to recognize prefecture names (used for japan destination selection)"));
        this.put(new SlotDefinitionImpl("Navigation.Speech.StreetList", 25, 1, true, true, false, 4, "supplier grammar to recognize street names at destination input for current selected city DSINavigation.liStartSpeller(SELCRITDES_STREET) Used for VDE to enter a street,"));
        this.put(new SlotDefinitionImpl("Online.Oneshot", 29, 1, true, false, false, 0, "grammar to recognize all online search keywords. The recognized keyword is saved on south side and is used for OnlinePOIVoiceSearch."));
        this.put(new SlotDefinitionImpl("Phone.Callstacks.MixedCalls.mixedCalls", 30, 0, true, false, true, 0, "callstack list of accepted, missed and dialed calls"));
        this.put(new SlotDefinitionImpl("Phone.Callstacks.MissedCalls.missedCalls", 31, 0, true, false, true, 0, "callstack list of missed calls"));
        this.put(new SlotDefinitionImpl("Phone.Callstacks.AcceptedCalls.acceptedCalls", 32, 0, true, false, true, 0, "callstack list of accepted calls"));
        this.put(new SlotDefinitionImpl("Phone.Callstacks.DialedCalls.dialedCalls", 33, 0, true, false, true, 0, "callstack list of dialed calls"));
        this.put(new SlotDefinitionImpl("Phone.Contacts.selectedContactNumbers", 35, 0, false, false, false, 0, "returns the phone numbers of the contacts shown in the detail view"));
        this.put(new SlotDefinitionImpl("Phone.Speech.getPhoneNumberSpeller", 36, 1, false, false, false, 3, "supplier grammar to spell numbers from 0-999 and + and * and # ,"));
        this.put(new SlotDefinitionImpl("Radio.DABServiceListItemInfo_Command", 41, 0, true, false, false, 0, "DAB services speakable by name"));
        this.put(new SlotDefinitionImpl("Radio.FMStationListInfo_Command", 42, 0, true, false, false, 0, "FM stations speakable by name"));
        this.put(new SlotDefinitionImpl("Radio.SAT.ChannelListInfo_Command", 52, 0, true, false, false, 0, "Sirius channels speakable by name"));
        this.put(new SlotDefinitionImpl("Radio.getFrequencyAM_AUS", 43, 2, false, false, false, 3, "includes the grammar used for manual tuning in AUS variant: bandlimits/ tuneable frequency: 522-1710 stepwidth 9 fe.: 522 1710 ..."));
        this.put(new SlotDefinitionImpl("Radio.getFrequencyAM_EU_RdW", 44, 2, false, false, false, 3, "includes the grammar used for manual tuning in eu and RDW variant: bandlimits/ tuneable frequency: 531-1602 stepwidth 9 validity RdW, CN, SA, (KOR) fe.: 531 700 1600 ..."));
        this.put(new SlotDefinitionImpl("Radio.getFrequencyAM_JP", 45, 2, false, false, false, 3, "includes the grammar used for manual tuning in JP variant: bandlimits/ tuneable frequency: 522-1629 stepwidth 9  fe.: 522 1629 ..."));
        this.put(new SlotDefinitionImpl("Radio.getFrequencyAM_NAR", 46, 2, false, false, false, 3, "includes the grammar used for manual tuning in NAR variant: bandlimits/ tuneable frequency: 530-1710 stepwidth 10 validity NAR + SAR fe.: 530 700 1600 ..."));
        this.put(new SlotDefinitionImpl("Radio.getFrequencyFM_CHN", 47, 2, false, false, false, 3, "includes the grammar used for manual tuning in CHN variant bandlimits/ tuneable frequency: 87.5-108.0 MHz stepwidth 100 kHz 87.5 87,5 108.0 108,0 ..."));
        this.put(new SlotDefinitionImpl("Radio.getFrequencyFM_EU_RdW", 48, 2, false, false, false, 3, "includes the grammar used for manual tuning in EU + RDW variant bandlimits/ tuneable frequency: 87.5-108.0 MHz stepwidth 100 kHz validity: RdW, CM, AUS, SA  101.4 101,4 89.0 89,0 89 ..."));
        this.put(new SlotDefinitionImpl("Radio.getFrequencyFM_JP", 49, 2, false, false, false, 3, "includes the grammar used for manual tuning in JP variant bandlimits/ tuneable frequency: 76.0-90.0 MHz stepwidth 100 kHz 76.0 76,0 76.1 76,1 90 ..."));
        this.put(new SlotDefinitionImpl("Radio.getFrequencyFM_KOR", 50, 2, false, false, false, 3, "includes the grammar used for manual tuning in KOR variant bandlimits/ tuneable frequency: 87.5-107.9 MHz stepwidth 200 kHz 87.5 87,5 107.9 107,9 ..."));
        this.put(new SlotDefinitionImpl("Radio.getFrequencyFM_NAR", 51, 2, false, false, false, 3, "includes the grammar used for manual tuning in NAR variant bandlimits/ tuneable frequency: 87.75-107.9 MHz stepwidth 200 kHz, 1.step 150kHz validity: SAR 107.9 107.9 87.75 87,75 87.9 87,9 ..."));
        this.put(new SlotDefinitionImpl("Speech.Input.RowNumber", true, 60, 2, false, false, false, 1, "supplier grammar with numbers to identfiy the spoken list row. Numbers are 0 -9 (Grammar could look like: $rownumber=1|2|3|4|5|6|7|8|9; ) This is a static number grammar."));
        this.put(new SlotDefinitionImpl("Speech.Input.VoiceRecognitionResult", 61, 1, false, false, false, -1, "defines the grammar for loading the nBest list commands."));
        this.put(new SlotDefinitionImpl("Organizer.contactCards", 39, 1, true, false, false, 0, "supplier grammar to phone contact names (the whole unfiltered contact list of adress book).", 1, "org.dsi.ifc.organizer.Constants.VIEWTYPE_ADB_ALL", 0));
        this.put(new SlotDefinitionImpl("Phone.Speech.ContactNames", 80, 1, true, false, false, 0, "supplier grammar to phone contact names (the whole unfiltered contact list of adress book but only the contacts with phone numbers)", 1, "org.dsi.ifc.organizer.Constants.VIEWTYPE_ADB_PHONE", 1));
        this.put(new SlotDefinitionImpl("Navigation.Speech.ContactNames", 81, 1, true, false, false, 0, "w/o changing Viewtype - supplier grammar to navigation contact names (the whole unfiltered contact list of adress book of public and private profile)", 2, "org.dsi.ifc.organizer.Constants.VIEWTYPE_ADB_COMBINED_NAVI", 14));
        this.put(new SlotDefinitionImpl("Navigation.Speech.AI1CP.Oneshot.State", 70, 1, true, false, false, 4, "supplier grammar to recognize prefecture names at one shot destination input. Used for SUI to enter a prefecture supplier grammar to recognize city names at one shot destination input. Used for SUI to enter a city"));
        this.put(new SlotDefinitionImpl("Navigation.Speech.AI1CP.Oneshot.City", 71, 1, true, false, false, 4, "supplier grammar to recognize city names at one shot destination input. Used for SUI to enter a city"));
        this.put(new SlotDefinitionImpl("Navigation.Speech.AI1CP.Oneshot.CityPart", 72, 1, true, false, false, 4, "supplier grammar to recognize city-part names at one shot destination input. Used for SUI to enter a city part"));
        this.put(new SlotDefinitionImpl("Navigation.Speech.AI1CP.Oneshot.Street", 73, 1, true, false, false, 4, "supplier grammar to recognize street names at one shot destination input. Used for SUI to enter a street"));
        this.put(new SlotDefinitionImpl("Navigation.Speech.AI1CP.Oneshot.HouseNumber", 74, 1, true, false, false, 3, "supplier grammar to recognize house numbers at one shot destination input. Used for SUI to enter a house number"));
        this.put(new SlotDefinitionImpl("Navigation.Speech.AI1CP.Contacts", 75, 1, true, false, true, 0, "supplier grammar to recognize contacts. Used for SUI to enter a contact", 2, "org.dsi.ifc.organizer.Constants.VIEWTYPE_ADB_COMBINED_NAVI", 14));
        this.put(new SlotDefinitionImpl("Navigation.Speech.AI1CP.POICategory", 76, 1, true, false, false, 0, "static grammar with all POI categories and group categories to search for identified by long CATEGORY_UID; also including brand names. Used for SUI to enter a POI category"));
        this.put(new SlotDefinitionImpl("Navigation.Speech.Oneshot.State", 23, 1, true, false, false, 4, "supplier grammar to recognize prefecture names at one shot destination input. Used for OneShot-VDE to enter a prefecture"));
        this.put(new SlotDefinitionImpl("Navigation.Speech.Oneshot.CityPart", 21, 1, true, false, false, 4, "supplier grammar to recognize city-part names at one shot destination input. Used for OneShot-VDE to enter a city-part"));
        this.put(new SlotDefinitionImpl("Navigation.Speech.StateList", 26, 1, true, false, false, 0, "supplier grammar to recognize prefecture names at destination input. Used for VDE to enter a prefecture"));
        this.put(new SlotDefinitionImpl("Navigation.Speech.CityPartList", 17, 1, true, false, false, 4, "supplier grammar to recognize city-part names for current seleceted town at destination input. Used for VDE to enter a city-part"));
        this.put(new SlotDefinitionImpl("Online.Streaming", 82, 1, true, false, false, 4, "grammar to recognize all online search keywords. The recognized keyword is saved on south side and is used for OnlinePOIVoiceSearch in multistep."));
        this.put(new SlotDefinitionImpl("NLU.phone_dial_contact.CONTACT_NM", 100, 3, true, false, true, -1, "NLU equivalent for Phone.Speech.ContactNames"));
        this.put(new SlotDefinitionImpl("NLU.phone_dial_contact.PHONETYPE_NM", 101, 3, false, false, false, -1, "NLU equivalent for contact loc/type tags used in BNF carrier grammar"));
        this.put(new SlotDefinitionImpl("NLU.phone_mailbox", 102, 3, false, false, false, -1, "NLU equivalent for the BNF carrier grammar CMD_DIAL_MAILBOX"));
    }

    public IntObjectOptHashMap getSlotIdMap() {
        return this.slotIdMap;
    }
}

