/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.sdars.DSISDARSSeekReply;
import de.esolutions.fw.comm.dsi.sdars.impl.LeagueEntrySerializer;
import de.esolutions.fw.comm.dsi.sdars.impl.SeekAlertSerializer;
import de.esolutions.fw.comm.dsi.sdars.impl.SeekEntrySerializer;
import de.esolutions.fw.comm.dsi.sdars.impl.SeekPossibilitySerializer;
import de.esolutions.fw.comm.dsi.sdars.impl.TeamEntrySerializer;
import de.esolutions.fw.comm.dsi.sdars.impl.TrafficWxEntrySerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.sdars.LeagueEntry;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.TeamEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

public class DSISDARSSeekReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.sdars.DSISDARSSeek");
    private static int dynamicHandle = 0;
    private DSISDARSSeekReply p_DSISDARSSeekReply;

    public DSISDARSSeekReplyService(DSISDARSSeekReply dSISDARSSeekReply) {
        super(new ServiceInstanceID("aad0da89-00fe-53a6-9ddd-4c4d8882a364", DSISDARSSeekReplyService.nextDynamicHandle(), "22be2a53-fa6a-58fd-a5af-f425ae6fb99c", "dsi.sdars.DSISDARSSeek"));
        this.p_DSISDARSSeekReply = dSISDARSSeekReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 15: {
                    SeekPossibility seekPossibility = SeekPossibilitySerializer.getOptionalSeekPossibility(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSSeekReply.updateSeekPossibility(seekPossibility, n);
                    break;
                }
                case 14: {
                    SeekEntry[] seekEntryArray = SeekEntrySerializer.getOptionalSeekEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSSeekReply.updateSeekList(seekEntryArray, n);
                    break;
                }
                case 12: {
                    LeagueEntry[] leagueEntryArray = LeagueEntrySerializer.getOptionalLeagueEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSSeekReply.updateLeagueList(leagueEntryArray, n);
                    break;
                }
                case 17: {
                    TrafficWxEntry[] trafficWxEntryArray = TrafficWxEntrySerializer.getOptionalTrafficWxEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSSeekReply.updateTrafficWeatherList(trafficWxEntryArray, n);
                    break;
                }
                case 13: {
                    SeekAlert seekAlert = SeekAlertSerializer.getOptionalSeekAlert(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSSeekReply.updateSeekAlert(seekAlert, n);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSSeekReply.setSeekCommandResult(n);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSSeekReply.manageSeekResult(n);
                    break;
                }
                case 24: {
                    TeamEntry[] teamEntryArray = TeamEntrySerializer.getOptionalTeamEntryVarArray(iDeserializer);
                    this.p_DSISDARSSeekReply.teamsOfLeague(teamEntryArray);
                    break;
                }
                case 22: {
                    LeagueEntry[] leagueEntryArray = LeagueEntrySerializer.getOptionalLeagueEntryVarArray(iDeserializer);
                    this.p_DSISDARSSeekReply.leagues(leagueEntryArray);
                    break;
                }
                case 25: {
                    TeamEntry[] teamEntryArray = TeamEntrySerializer.getOptionalTeamEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSSeekReply.updateRegisteredTeams(teamEntryArray, n);
                    break;
                }
                case 34: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSISDARSSeekReply.updateProfileState(n, n2, n3);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSISDARSSeekReply.profileChanged(n, n4);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSISDARSSeekReply.profileCopied(n, n5, n6);
                    break;
                }
                case 31: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSISDARSSeekReply.profileReset(n, n7);
                    break;
                }
                case 33: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSSeekReply.profileResetAll(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSISDARSSeekReply.asyncException(n, string, n8);
                    break;
                }
                case 18: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSISDARSSeekReply.yyIndication(string, string2);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

