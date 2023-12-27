/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.navigation.DSINavigation;
import de.esolutions.fw.comm.dsi.navigation.DSINavigationC;
import de.esolutions.fw.comm.dsi.navigation.DSINavigationReply;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$1;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$10;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$11;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$12;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$13;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$14;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$15;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$16;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$17;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$18;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$19;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$2;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$20;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$21;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$22;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$23;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$24;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$25;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$26;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$27;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$28;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$29;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$3;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$30;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$31;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$32;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$33;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$34;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$35;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$36;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$37;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$38;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$39;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$4;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$40;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$41;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$42;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$43;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$44;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$45;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$46;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$5;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$6;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$7;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$8;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationProxy$9;
import de.esolutions.fw.comm.dsi.navigation.impl.DSINavigationReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.NavLastDest;
import org.dsi.ifc.navigation.NavPoiInfoConfiguration;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.TryBestMatchData;
import org.dsi.ifc.navigation.TryMatchLocationData;

public class DSINavigationProxy
implements DSINavigation,
DSINavigationC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.navigation.DSINavigation");
    private Proxy proxy;

    public DSINavigationProxy(int n, DSINavigationReply dSINavigationReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("fe4268ba-8993-5832-ab71-812fc59e1c31", n, "84049221-98a0-5fc7-842c-507a5c41dade", "dsi.navigation.DSINavigation");
        DSINavigationReplyService dSINavigationReplyService = new DSINavigationReplyService(dSINavigationReply);
        this.proxy = new Proxy(serviceInstanceID, dSINavigationReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void afaRepeat(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)0, genericSerializable);
    }

    @Override
    public void createExportFile(String string, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void dmFlagDestinationSet(NavLocation navLocation) {
        DSINavigationProxy$1 dSINavigationProxy$1 = new DSINavigationProxy$1(this, navLocation);
        this.proxy.remoteCallMethod((short)12, dSINavigationProxy$1);
    }

    @Override
    public void dmFlagDestinationRemove() {
        this.proxy.remoteCallMethod((short)11, null);
    }

    @Override
    public void dmFlagDestinationSetName(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    @Override
    public void dmLastDestinationsAddList(NavLastDest[] navLastDestArray) {
        DSINavigationProxy$2 dSINavigationProxy$2 = new DSINavigationProxy$2(this, navLastDestArray);
        this.proxy.remoteCallMethod((short)322, dSINavigationProxy$2);
    }

    @Override
    public void dmLastDestinationsDelete(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

    @Override
    public void dmLastDestinationsDeleteAll() {
        this.proxy.remoteCallMethod((short)16, null);
    }

    @Override
    public void dmLastDestinationsGet(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    @Override
    public void dmLastDestinationsReplace(long l, NavLocation navLocation, String string) {
        DSINavigationProxy$3 dSINavigationProxy$3 = new DSINavigationProxy$3(this, l, navLocation, string);
        this.proxy.remoteCallMethod((short)19, dSINavigationProxy$3);
    }

    @Override
    public void dmRecentRoutesAdd(Route route, String string) {
        DSINavigationProxy$4 dSINavigationProxy$4 = new DSINavigationProxy$4(this, route, string);
        this.proxy.remoteCallMethod((short)20, dSINavigationProxy$4);
    }

    @Override
    public void dmRecentRoutesDelete(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
    }

    @Override
    public void dmRecentRoutesDeleteAll() {
        this.proxy.remoteCallMethod((short)22, null);
    }

    @Override
    public void dmRecentRoutesGet(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }

    @Override
    public void dmRecentRoutesReplace(long l, Route route, String string) {
        DSINavigationProxy$5 dSINavigationProxy$5 = new DSINavigationProxy$5(this, l, route, string);
        this.proxy.remoteCallMethod((short)25, dSINavigationProxy$5);
    }

    @Override
    public void enableRgStreetLists(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)39, genericSerializable);
    }

    @Override
    public void enableRgLaneGuidance(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)37, genericSerializable);
    }

    @Override
    public void enableRgPoiInfo(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)38, genericSerializable);
    }

    @Override
    public void etcGetCountryAbbreviation(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)40, genericSerializable);
    }

    @Override
    public void etcSetDemoMode(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)46, genericSerializable);
    }

    @Override
    public void etcSetDemoModeSpeed(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)47, genericSerializable);
    }

    @Override
    public void etcSetMetricSystem(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)48, genericSerializable);
    }

    @Override
    public void etcSelectDatabase(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)42, genericSerializable);
    }

    @Override
    public void etcSelectNavDataBase(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)43, genericSerializable);
    }

    @Override
    public void importFile(String string, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)51, genericSerializable);
    }

    @Override
    public void languageSpellableCharacters(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)54, genericSerializable);
    }

    @Override
    public void liGetCurrentState() {
        this.proxy.remoteCallMethod((short)58, null);
    }

    @Override
    public void liGetLastCityHistoryEntry(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)59, genericSerializable);
    }

    @Override
    public void liGetLastStreetHistoryEntry(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)63, genericSerializable);
    }

    @Override
    public void liGetLocationDescriptionTransform(NavLocation navLocation) {
        DSINavigationProxy$6 dSINavigationProxy$6 = new DSINavigationProxy$6(this, navLocation);
        this.proxy.remoteCallMethod((short)65, dSINavigationProxy$6);
    }

    @Override
    public void liGetLocationDescriptionTransformNearBy(NavLocation navLocation) {
        DSINavigationProxy$7 dSINavigationProxy$7 = new DSINavigationProxy$7(this, navLocation);
        this.proxy.remoteCallMethod((short)332, dSINavigationProxy$7);
    }

    @Override
    public void liGetState() {
        this.proxy.remoteCallMethod((short)69, null);
    }

    @Override
    public void liGetLastStateHistoryEntry(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)61, genericSerializable);
    }

    @Override
    public void liLastStateHistoryAdd(NavLocation navLocation, boolean bl, String string) {
        DSINavigationProxy$8 dSINavigationProxy$8 = new DSINavigationProxy$8(this, navLocation, bl, string);
        this.proxy.remoteCallMethod((short)79, dSINavigationProxy$8);
    }

    @Override
    public void liLastStateHistoryAddExtended(NavLocation navLocation, boolean bl, String string, LIExtData[] lIExtDataArray) {
        DSINavigationProxy$9 dSINavigationProxy$9 = new DSINavigationProxy$9(this, navLocation, bl, string, lIExtDataArray);
        this.proxy.remoteCallMethod((short)80, dSINavigationProxy$9);
    }

    @Override
    public void liLastStateHistoryDelete(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)81, genericSerializable);
    }

    @Override
    public void liLastStateHistoryDeleteAll() {
        this.proxy.remoteCallMethod((short)82, null);
    }

    @Override
    public void liLastCityHistoryAdd(NavLocation navLocation, boolean bl, String string) {
        DSINavigationProxy$10 dSINavigationProxy$10 = new DSINavigationProxy$10(this, navLocation, bl, string);
        this.proxy.remoteCallMethod((short)75, dSINavigationProxy$10);
    }

    @Override
    public void liLastCityHistoryAddExtended(NavLocation navLocation, boolean bl, String string, LIExtData[] lIExtDataArray) {
        DSINavigationProxy$11 dSINavigationProxy$11 = new DSINavigationProxy$11(this, navLocation, bl, string, lIExtDataArray);
        this.proxy.remoteCallMethod((short)76, dSINavigationProxy$11);
    }

    @Override
    public void liLastCityHistoryDelete(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)77, genericSerializable);
    }

    @Override
    public void liLastCityHistoryDeleteAll() {
        this.proxy.remoteCallMethod((short)78, null);
    }

    @Override
    public void liLastStreetHistoryAdd(NavLocation navLocation, String string) {
        DSINavigationProxy$12 dSINavigationProxy$12 = new DSINavigationProxy$12(this, navLocation, string);
        this.proxy.remoteCallMethod((short)83, dSINavigationProxy$12);
    }

    @Override
    public void liLastStreetHistoryAddExtended(NavLocation navLocation, String string, LIExtData[] lIExtDataArray) {
        DSINavigationProxy$13 dSINavigationProxy$13 = new DSINavigationProxy$13(this, navLocation, string, lIExtDataArray);
        this.proxy.remoteCallMethod((short)84, dSINavigationProxy$13);
    }

    @Override
    public void liLastStreetHistoryDelete(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)85, genericSerializable);
    }

    @Override
    public void liLastStreetHistoryDeleteAll() {
        this.proxy.remoteCallMethod((short)86, null);
    }

    @Override
    public void liRestoreState(LISpellerData lISpellerData) {
        DSINavigationProxy$14 dSINavigationProxy$14 = new DSINavigationProxy$14(this, lISpellerData);
        this.proxy.remoteCallMethod((short)87, dSINavigationProxy$14);
    }

    @Override
    public void liSetCountryForCityAndStreetHistory(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)91, genericSerializable);
    }

    @Override
    public void liSetHistory(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)94, genericSerializable);
    }

    @Override
    public void liSetStreetForCityHistory(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)284, genericSerializable);
    }

    @Override
    public void liDeleteHistory() {
        this.proxy.remoteCallMethod((short)57, null);
    }

    @Override
    public void liSetCurrentLD(NavLocation navLocation) {
        DSINavigationProxy$15 dSINavigationProxy$15 = new DSINavigationProxy$15(this, navLocation);
        this.proxy.remoteCallMethod((short)93, dSINavigationProxy$15);
    }

    @Override
    public void lispAddCharacter(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)116, genericSerializable);
    }

    @Override
    public void lispCancelSpeller() {
        this.proxy.remoteCallMethod((short)117, null);
    }

    @Override
    public void lispDeleteAllCharacters() {
        this.proxy.remoteCallMethod((short)118, null);
    }

    @Override
    public void lispRequestValueListByListIndex(int n, boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)119, genericSerializable);
    }

    @Override
    public void lispSelectListItem(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)122, genericSerializable);
    }

    @Override
    public void lispSelectItemFromLocation(NavLocation navLocation) {
        DSINavigationProxy$16 dSINavigationProxy$16 = new DSINavigationProxy$16(this, navLocation);
        this.proxy.remoteCallMethod((short)121, dSINavigationProxy$16);
    }

    @Override
    public void lispSelectByCategoryUid(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)120, genericSerializable);
    }

    @Override
    public void lispSelectByMultipleCategoryUids(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)275, genericSerializable);
    }

    @Override
    public void lispSetInput(String string, boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)124, genericSerializable);
    }

    @Override
    public void lispGetMatchingNVC(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)319, genericSerializable);
    }

    @Override
    public void lispUndoCharacter() {
        this.proxy.remoteCallMethod((short)125, null);
    }

    @Override
    public void liStartMultiCriteriaSpeller(int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putBool(bl);
            genericSerializable.putBool(bl2);
            genericSerializable.putBool(bl3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)95, genericSerializable);
    }

    @Override
    public void liStartSpeller(int n, boolean bl, boolean bl2, boolean bl3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
            genericSerializable.putBool(bl2);
            genericSerializable.putBool(bl3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)96, genericSerializable);
    }

    @Override
    public void liTryBestMatch(TryBestMatchData tryBestMatchData) {
        DSINavigationProxy$17 dSINavigationProxy$17 = new DSINavigationProxy$17(this, tryBestMatchData);
        this.proxy.remoteCallMethod((short)108, dSINavigationProxy$17);
    }

    @Override
    public void liValueListFilename(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)112, genericSerializable);
    }

    @Override
    public void liValueListOutputMethod(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)114, genericSerializable);
    }

    @Override
    public void locationToStream(NavLocation navLocation) {
        DSINavigationProxy$18 dSINavigationProxy$18 = new DSINavigationProxy$18(this, navLocation);
        this.proxy.remoteCallMethod((short)127, dSINavigationProxy$18);
    }

    @Override
    public void poiSelectSelectionCriteria(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)129, genericSerializable);
    }

    @Override
    public void poiSetContext(NavLocation navLocation) {
        DSINavigationProxy$19 dSINavigationProxy$19 = new DSINavigationProxy$19(this, navLocation);
        this.proxy.remoteCallMethod((short)130, dSINavigationProxy$19);
    }

    @Override
    public void poiSetSortOrder2(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)131, genericSerializable);
    }

    @Override
    public void poiStartSpellerAlongRoute(int n, long l, long l2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt64(l);
            genericSerializable.putInt64(l2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)133, genericSerializable);
    }

    @Override
    public void poiStartSpellerAlongRouteAdvanced(int n, long l, long l2, long l3, boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt64(l);
            genericSerializable.putInt64(l2);
            genericSerializable.putInt64(l3);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)276, genericSerializable);
    }

    @Override
    public void requestSoPosPositionDescriptionVehicle() {
        this.proxy.remoteCallMethod((short)138, null);
    }

    @Override
    public void rgCalculateRoute(Route route, int n) {
        DSINavigationProxy$20 dSINavigationProxy$20 = new DSINavigationProxy$20(this, route, n);
        this.proxy.remoteCallMethod((short)140, dSINavigationProxy$20);
    }

    @Override
    public void rgSetPosition(NavLocation navLocation) {
        DSINavigationProxy$21 dSINavigationProxy$21 = new DSINavigationProxy$21(this, navLocation);
        this.proxy.remoteCallMethod((short)144, dSINavigationProxy$21);
    }

    @Override
    public void rgSetRouteGuidanceMode(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)145, genericSerializable);
    }

    @Override
    public void rgSetRouteOptions(RouteOptions routeOptions) {
        DSINavigationProxy$22 dSINavigationProxy$22 = new DSINavigationProxy$22(this, routeOptions);
        this.proxy.remoteCallMethod((short)147, dSINavigationProxy$22);
    }

    @Override
    public void rgStartGuidanceCalculatedRoute(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)148, genericSerializable);
    }

    @Override
    public void rgStopGuidance() {
        this.proxy.remoteCallMethod((short)152, null);
    }

    @Override
    public void rmMakeRoutePersistent(Route route) {
        DSINavigationProxy$23 dSINavigationProxy$23 = new DSINavigationProxy$23(this, route);
        this.proxy.remoteCallMethod((short)156, dSINavigationProxy$23);
    }

    @Override
    public void rmRouteAdd(int n, Route route, String string) {
        DSINavigationProxy$24 dSINavigationProxy$24 = new DSINavigationProxy$24(this, n, route, string);
        this.proxy.remoteCallMethod((short)158, dSINavigationProxy$24);
    }

    @Override
    public void rmRouteDelete(int n, long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)160, genericSerializable);
    }

    @Override
    public void rmRouteDeleteAll(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)161, genericSerializable);
    }

    @Override
    public void rmRouteGet(int n, long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)164, genericSerializable);
    }

    @Override
    public void rmRouteRename(int n, long l, String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt64(l);
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)166, genericSerializable);
    }

    @Override
    public void rrdStartCalculationByListIndex(int n, long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)170, genericSerializable);
    }

    @Override
    public void rrdStartCalculationForPosition(NavLocationWgs84[] navLocationWgs84Array) {
        DSINavigationProxy$25 dSINavigationProxy$25 = new DSINavigationProxy$25(this, navLocationWgs84Array);
        this.proxy.remoteCallMethod((short)171, dSINavigationProxy$25);
    }

    @Override
    public void rrdStopCalculation() {
        this.proxy.remoteCallMethod((short)172, null);
    }

    @Override
    public void setLanguage(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)173, genericSerializable);
    }

    @Override
    public void streamToLocation(byte[] byArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt8VarArray(byArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)189, genericSerializable);
    }

    @Override
    public void translateRoute(Route route) {
        DSINavigationProxy$26 dSINavigationProxy$26 = new DSINavigationProxy$26(this, route);
        this.proxy.remoteCallMethod((short)204, dSINavigationProxy$26);
    }

    @Override
    public void trCreateWaypoint() {
        this.proxy.remoteCallMethod((short)191, null);
    }

    @Override
    public void trDeleteAllTraces() {
        this.proxy.remoteCallMethod((short)192, null);
    }

    @Override
    public void trDeleteTrace(NavSegmentID navSegmentID) {
        DSINavigationProxy$27 dSINavigationProxy$27 = new DSINavigationProxy$27(this, navSegmentID);
        this.proxy.remoteCallMethod((short)194, dSINavigationProxy$27);
    }

    @Override
    public void trRenameTrace(NavSegmentID navSegmentID, String string) {
        DSINavigationProxy$28 dSINavigationProxy$28 = new DSINavigationProxy$28(this, navSegmentID, string);
        this.proxy.remoteCallMethod((short)196, dSINavigationProxy$28);
    }

    @Override
    public void trStartTraceRecording(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)198, genericSerializable);
    }

    @Override
    public void trStopTraceRecording() {
        this.proxy.remoteCallMethod((short)200, null);
    }

    @Override
    public void trStoreTrace(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)202, genericSerializable);
    }

    @Override
    public void liStripLocation(NavLocation navLocation, int n) {
        DSINavigationProxy$29 dSINavigationProxy$29 = new DSINavigationProxy$29(this, navLocation, n);
        this.proxy.remoteCallMethod((short)98, dSINavigationProxy$29);
    }

    @Override
    public void liSetNVCRange(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)318, genericSerializable);
    }

    @Override
    public void liValueListWindowSize(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)274, genericSerializable);
    }

    @Override
    public void requestAudioTrigger(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)135, genericSerializable);
    }

    @Override
    public void liThesaurusHistoryAdd(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)100, genericSerializable);
    }

    @Override
    public void liThesaurusHistoryGetEntry(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)106, genericSerializable);
    }

    @Override
    public void liThesaurusHistoryDelete(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)102, genericSerializable);
    }

    @Override
    public void liThesaurusHistoryDeleteAll() {
        this.proxy.remoteCallMethod((short)103, null);
    }

    @Override
    public void ehGetAllCategories(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)29, genericSerializable);
    }

    @Override
    public void ehGetAllBrandsOfCategory(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)27, genericSerializable);
    }

    @Override
    public void ehSetCategoryVisibility(int n, int[] nArray, boolean[] blArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalInt32VarArray(nArray);
            genericSerializable.putOptionalBoolVarArray(blArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)36, genericSerializable);
    }

    @Override
    public void ehSetCategoryVisibilityToDefault(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)273, genericSerializable);
    }

    @Override
    public void ehSetCategoryAudioWarning(int n, int[] nArray, boolean[] blArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalInt32VarArray(nArray);
            genericSerializable.putOptionalBoolVarArray(blArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)34, genericSerializable);
    }

    @Override
    public void ehSetCategoryMonitoring(int[] nArray, boolean[] blArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
            genericSerializable.putOptionalBoolVarArray(blArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)35, genericSerializable);
    }

    @Override
    public void ehSetBrandVisibility(int n, int[] nArray, boolean[] blArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalInt32VarArray(nArray);
            genericSerializable.putOptionalBoolVarArray(blArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)33, genericSerializable);
    }

    @Override
    public void ehSetBrandPreference(int n, int[] nArray, boolean[] blArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalInt32VarArray(nArray);
            genericSerializable.putOptionalBoolVarArray(blArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)32, genericSerializable);
    }

    @Override
    public void setRemainingRangeOfVehicle(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)178, genericSerializable);
    }

    @Override
    public void setUserDefinedPOIs(NavLocation[] navLocationArray) {
        DSINavigationProxy$30 dSINavigationProxy$30 = new DSINavigationProxy$30(this, navLocationArray);
        this.proxy.remoteCallMethod((short)182, dSINavigationProxy$30);
    }

    @Override
    public void setTrailerStatus(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)180, genericSerializable);
    }

    @Override
    public void requestCountryInfo(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)136, genericSerializable);
    }

    @Override
    public void jumpToNextManeuver() {
        this.proxy.remoteCallMethod((short)53, null);
    }

    @Override
    public void liGetViaPointCountryList() {
        this.proxy.remoteCallMethod((short)283, null);
    }

    @Override
    public void liSetViaPointCountry(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)285, genericSerializable);
    }

    @Override
    public void liGetViaPointList(int n, int n2, int n3, int n4) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
            genericSerializable.putInt32(n4);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)71, genericSerializable);
    }

    @Override
    public void liSelectViaPoint(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)89, genericSerializable);
    }

    @Override
    public void rgStartGuidanceCalculatedRouteByUID(NavSegmentID navSegmentID) {
        DSINavigationProxy$31 dSINavigationProxy$31 = new DSINavigationProxy$31(this, navSegmentID);
        this.proxy.remoteCallMethod((short)149, dSINavigationProxy$31);
    }

    @Override
    public void liGetSpellableCharacters(NavLocation navLocation, int n) {
        DSINavigationProxy$32 dSINavigationProxy$32 = new DSINavigationProxy$32(this, navLocation, n);
        this.proxy.remoteCallMethod((short)67, dSINavigationProxy$32);
    }

    @Override
    public void liStopSpeller() {
        this.proxy.remoteCallMethod((short)97, null);
    }

    @Override
    public void liValueListMaximumLength(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)113, genericSerializable);
    }

    @Override
    public void setPathsToPersonalPOIDataBases(String[] stringArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalStringVarArray(stringArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)177, genericSerializable);
    }

    @Override
    public void deletePersonalPOIDataBases(String[] stringArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalStringVarArray(stringArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    @Override
    public void rgStopRouteCalculation() {
        this.proxy.remoteCallMethod((short)153, null);
    }

    @Override
    public void rgSwitchToNextPossibleRoad() {
        this.proxy.remoteCallMethod((short)154, null);
    }

    @Override
    public void setVehicleFuelType(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)186, genericSerializable);
    }

    @Override
    public void createNavLocationOfPOIUID(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void lispSelectListItemByIdent(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)123, genericSerializable);
    }

    @Override
    public void rmRouteReplace(int n, long l, Route route) {
        DSINavigationProxy$33 dSINavigationProxy$33 = new DSINavigationProxy$33(this, n, l, route);
        this.proxy.remoteCallMethod((short)168, dSINavigationProxy$33);
    }

    @Override
    public void setNavInternalDataToFactorySettings() {
        this.proxy.remoteCallMethod((short)277, null);
    }

    @Override
    public void liTryMatchLocation(TryMatchLocationData tryMatchLocationData) {
        DSINavigationProxy$34 dSINavigationProxy$34 = new DSINavigationProxy$34(this, tryMatchLocationData);
        this.proxy.remoteCallMethod((short)324, dSINavigationProxy$34);
    }

    @Override
    public void trImportTrails(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)306, genericSerializable);
    }

    @Override
    public void trExportTrails(NavSegmentID[] navSegmentIDArray, String string) {
        DSINavigationProxy$35 dSINavigationProxy$35 = new DSINavigationProxy$35(this, navSegmentIDArray, string);
        this.proxy.remoteCallMethod((short)304, dSINavigationProxy$35);
    }

    @Override
    public void rgSkipNextWayPoints(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)300, genericSerializable);
    }

    @Override
    public void rgReverseTrailDirection() {
        this.proxy.remoteCallMethod((short)298, null);
    }

    @Override
    public void rgPrepareRubberbandManipulation(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)296, genericSerializable);
    }

    @Override
    public void rgStartRubberbandManipulation(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)301, genericSerializable);
    }

    @Override
    public void rgSetRubberbandPosition(NavLocationWgs84 navLocationWgs84) {
        DSINavigationProxy$36 dSINavigationProxy$36 = new DSINavigationProxy$36(this, navLocationWgs84);
        this.proxy.remoteCallMethod((short)299, dSINavigationProxy$36);
    }

    @Override
    public void rgGetRouteBoundingRectangle(boolean bl, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)294, genericSerializable);
    }

    @Override
    public void rgGetLocationOnRoute(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)292, genericSerializable);
    }

    @Override
    public void rgStopRubberbandManipulation() {
        this.proxy.remoteCallMethod((short)303, null);
    }

    @Override
    public void rgDeleteCalculatedRubberbandPoint() {
        this.proxy.remoteCallMethod((short)312, null);
    }

    @Override
    public void rgGetRubberBandPointPosition() {
        this.proxy.remoteCallMethod((short)313, null);
    }

    @Override
    public void rgEnableEnhancedSignPostInfo(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)291, genericSerializable);
    }

    @Override
    public void lispGetLocationFromLiValueListElement(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)325, genericSerializable);
    }

    @Override
    public void rgSetTurnListMode(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)342, genericSerializable);
    }

    @Override
    public void liHistoryAddLocation(NavLocation navLocation) {
        DSINavigationProxy$37 dSINavigationProxy$37 = new DSINavigationProxy$37(this, navLocation);
        this.proxy.remoteCallMethod((short)334, dSINavigationProxy$37);
    }

    @Override
    public void liLastCityHistorySetStreet(NavLocation navLocation) {
        DSINavigationProxy$38 dSINavigationProxy$38 = new DSINavigationProxy$38(this, navLocation);
        this.proxy.remoteCallMethod((short)335, dSINavigationProxy$38);
    }

    @Override
    public void liLastStreetHistorySetCity(NavLocation navLocation) {
        DSINavigationProxy$39 dSINavigationProxy$39 = new DSINavigationProxy$39(this, navLocation);
        this.proxy.remoteCallMethod((short)336, dSINavigationProxy$39);
    }

    @Override
    public void enableRgMotorwayInfo(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)331, genericSerializable);
    }

    @Override
    public void rgTriggerRCCIUpdate() {
        this.proxy.remoteCallMethod((short)343, null);
    }

    @Override
    public void poiGetXt9LDBs(NavLocation navLocation, int n) {
        DSINavigationProxy$40 dSINavigationProxy$40 = new DSINavigationProxy$40(this, navLocation, n);
        this.proxy.remoteCallMethod((short)338, dSINavigationProxy$40);
    }

    @Override
    public void poiSetListStyle(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)340, genericSerializable);
    }

    @Override
    public void etcGetPositionTimeInfo(NavLocationWgs84 navLocationWgs84) {
        DSINavigationProxy$41 dSINavigationProxy$41 = new DSINavigationProxy$41(this, navLocationWgs84);
        this.proxy.remoteCallMethod((short)352, dSINavigationProxy$41);
    }

    @Override
    public void poiGetCategoryTypesFromUId(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)354, genericSerializable);
    }

    @Override
    public void rgDeletePersistedRouteData() {
        this.proxy.remoteCallMethod((short)357, null);
    }

    @Override
    public void rgCalculate1stRouteAndPostponeRemaining(Route route, int n, boolean bl) {
        DSINavigationProxy$42 dSINavigationProxy$42 = new DSINavigationProxy$42(this, route, n, bl);
        this.proxy.remoteCallMethod((short)356, dSINavigationProxy$42);
    }

    @Override
    public void liDisambiguateLocation(NavLocation navLocation) {
        DSINavigationProxy$43 dSINavigationProxy$43 = new DSINavigationProxy$43(this, navLocation);
        this.proxy.remoteCallMethod((short)365, dSINavigationProxy$43);
    }

    @Override
    public void triggerEventAudioMessage(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)374, genericSerializable);
    }

    @Override
    public void lispAddStroke(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)370, genericSerializable);
    }

    @Override
    public void lispRequestNVCList(int n, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)371, genericSerializable);
    }

    @Override
    public void poiConfigureContext(String string, int n, NavLocation navLocation, int[] nArray) {
        DSINavigationProxy$44 dSINavigationProxy$44 = new DSINavigationProxy$44(this, string, n, navLocation, nArray);
        this.proxy.remoteCallMethod((short)373, dSINavigationProxy$44);
    }

    @Override
    public void etcTriggerNavigationRestart(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)376, genericSerializable);
    }

    @Override
    public void rmImportToursFromGpxFile(int n, String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)384, genericSerializable);
    }

    @Override
    public void rmAbortImportToursFromGpxFile() {
        this.proxy.remoteCallMethod((short)383, null);
    }

    @Override
    public void importRouteFromGpxFile(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)381, genericSerializable);
    }

    @Override
    public void poiRequestExtendedInfo(NavLocation navLocation) {
        DSINavigationProxy$45 dSINavigationProxy$45 = new DSINavigationProxy$45(this, navLocation);
        this.proxy.remoteCallMethod((short)392, dSINavigationProxy$45);
    }

    @Override
    public void rgConfigurePoiInfo(NavPoiInfoConfiguration navPoiInfoConfiguration) {
        DSINavigationProxy$46 dSINavigationProxy$46 = new DSINavigationProxy$46(this, navPoiInfoConfiguration);
        this.proxy.remoteCallMethod((short)394, dSINavigationProxy$46);
    }

    @Override
    public void trClearRecordedTraceCache() {
        this.proxy.remoteCallMethod((short)404, null);
    }

    @Override
    public void setVirtualRouteGuidance(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)410, genericSerializable);
    }

    @Override
    public void profileChange(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)396, genericSerializable);
    }

    @Override
    public void profileCopy(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)399, genericSerializable);
    }

    @Override
    public void profileReset(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)400, genericSerializable);
    }

    @Override
    public void profileResetAll() {
        this.proxy.remoteCallMethod((short)402, null);
    }

    @Override
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)175, genericSerializable);
    }

    @Override
    public void setNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)176, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)174, null);
    }

    @Override
    public void clearNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void clearNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)2, null);
    }

    @Override
    public void yySet(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)272, genericSerializable);
    }
}

