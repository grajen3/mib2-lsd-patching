/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.trafficregulation;

import org.dsi.ifc.base.DSIBase;

public interface DSITrafficRegulation
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_COUNTRYSPEEDINFORMATION;
    public static final int ATTR_CURRENTTRAFFICSIGN;
    public static final int ATTR_TRAFFICSIGNONROUTE;
    public static final int ATTR_TRAILERSTATUS;
    public static final int RT_SETSPEEDLIMITWARNING;
    public static final int RT_REQUESTROADCLASSSPEEDINFOFORCOUNTRY;
    public static final int RT_SETTRAILERSTATUS;
    public static final int RT_SETWARNINGSTATUS;
    public static final int RP_REQUESTROADCLASSSPEEDINFOFORCOUNTRYRESULT;
    public static final int RESULTCODE_OK;
    public static final int RESULTCODE_ERROR;
    public static final int RESULTCODE_UNSUPPORTED;
    public static final int INFORMATION_TEXT_NO_TEXT;
    public static final int PRIO_ON_SIGN_NA_OR_INITIAL_OR_ERROR_VALUE;
    public static final int PRIO_ON_SIGN_1;
    public static final int PRIO_ON_SIGN_2;
    public static final int PRIO_ON_SIGN_3;
    public static final int TRAFFICSIGNWARNING_DISABLED;
    public static final int TRAFFICSIGNWARNING_ENABLED;
    public static final int TRAFFICSIGNTYPE_NO_SIGN;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_NO_VALUE;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_5;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_10;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_15;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_20;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_25;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_30;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_35;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_40;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_45;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_50;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_55;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_60;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_65;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_70;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_75;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_80;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_85;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_90;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_95;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_100;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_110;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_120;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_130;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_140;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_150;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_160;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_200;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_VARIABLE_250;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_DYN;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_NO_VALUE;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_5;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_10;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_15;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_20;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_25;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_30;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_35;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_40;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_45;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_50;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_55;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_60;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_65;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_70;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_75;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_80;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_85;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_90;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_95;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_100;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_110;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_120;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_130;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_140;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_150;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_160;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_200;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_VARIABLE_250;
    public static final int TRAFFICSIGNTYPE_OVERTAKE_RESTRICTION;
    public static final int TRAFFICSIGNTYPE_OVERTAKE_RESTRICTION_TRUCKS;
    public static final int TRAFFICSIGNTYPE_OVERTAKE_RESTRICTION_VARIABLE;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_NO_VALUE;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_5;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_10;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_15;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_20;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_25;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_30;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_35;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_40;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_45;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_50;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_55;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_60;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_65;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_70;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_75;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_80;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_85;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_90;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_95;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_100;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_110;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_120;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_130;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_140;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_150;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_160;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_200;
    public static final int TRAFFICSIGNTYPE_SPEED_LIMIT_END_250;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_NO_VALUE;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_5;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_10;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_15;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_20;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_25;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_30;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_35;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_40;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_45;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_50;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_55;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_60;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_65;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_70;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_75;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_80;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_85;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_90;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_95;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_100;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_110;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_120;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_130;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_140;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_150;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_160;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_200;
    public static final int TRAFFICSIGNTYPE_VARIABLE_MESSAGESIGNTYPE_SPEED_LIMIT_END_250;
    public static final int TRAFFICSIGNTYPE_OVERTAKE_RESTRICTION_END;
    public static final int TRAFFICSIGNTYPE_OVERTAKE_RESTRICTION_TRUCKS_END;
    public static final int TRAFFICSIGNTYPE_OVERTAKE_RESTRICTION_END_VARIABLE;
    public static final int TRAFFICSIGNTYPE_END_OF_ALL_RESTIRCTIONS;
    public static final int TRAFFICSIGNTYPE_END_OF_ALL_RESTIRCTIONS_VARIABLE;
    public static final int TRAFFICSIGNTYPE_ADDITIONAL_NA_OR_INITAL_OR_ERROR;
    public static final int TRAFFICSIGNTYPE_ADDITIONAL_EMPTY;
    public static final int TRAFFICSIGNTYPE_ADDITIONAL_WET;
    public static final int TRAFFICSIGNTYPE_ADDITIONAL_RAIN;
    public static final int TRAFFICSIGNTYPE_ADDITIONAL_TEMP_CONDITION;
    public static final int TRAFFICSIGNTYPE_ADDITIONAL_ONLY_FOR_PASSENGER_CAR;
    public static final int TRAFFICSIGNTYPE_ADDITIONAL_VEHICLE_WITH_TRAILER;
    public static final int TRAFFICSIGNTYPE_ADDITIONAL_ONLY_VEHICLES_TURNING_RIGHT;
    public static final int TRAFFICSIGNTYPE_ADDITIONAL_ONLY_VEHICLES_TURNING_LEFT;
    public static final int TRAFFICSIGNTYPE_OVERLAY_SPEED_WARNING;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_NO_VALUE;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_5;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_10;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_15;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_20;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_25;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_30;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_35;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_40;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_45;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_50;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_55;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_60;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_65;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_70;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_75;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_80;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_85;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_90;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_95;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_100;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_110;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_120;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_130;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_140;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_150;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_160;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_200;
    public static final int TRAFFICSIGNTYPE_RECOMMENDED_SPEED_VARIABLE_250;
    public static final int TRAFFICSIGNTYPE_WARNING_RAILWAY_CROSSING_PROTECTED;
    public static final int TRAFFICSIGNTYPE_WARNING_RAILWAY_CROSSING_UNPROTECTED;
    public static final int TRAFFICSIGNTYPE_WARNING_SHARP_TURN_LEFT;
    public static final int TRAFFICSIGNTYPE_WARNING_SHARP_TURN_RIGHT;
    public static final int TRAFFICSIGNTYPE_WARNING_FALLING_ROCKS;
    public static final int TRAFFICSIGNTYPE_WARNING_MERGING_TRAFFIC_LEFT;
    public static final int TRAFFICSIGNTYPE_WARNING_MERGING_TRAFFIC_RIGHT;
    public static final int TRAFFICSIGNTYPE_WARNING_REDUCTION_OF_LANES;
    public static final int TRAFFICSIGNTYPE_WARNING_NO_PASSING;
    public static final int TRAFFICSIGNTYPE_WARNING_MERGING_TRAFFIC_BOTHSIDES;
    public static final int TRAFFICSIGNTYPE_WARNING_TURN_RIGHT;
    public static final int TRAFFICSIGNTYPE_WARNING_TURN_LEFT;
    public static final int TRAFFICSIGNTYPE_WARNING_REDUCTION_OF_LANES_RIGHT;
    public static final int TRAFFICSIGNTYPE_WARNING_REDUCTION_OF_LANES_LEFT;
    public static final int TRAFFICSIGNTYPE_WARNING_EXCLUSIVELANE_RIGHTTURNONLY;
    public static final int TRAFFICSIGNTYPE_WARNING_EXCLUSIVELANE_LEFTTURNONLY;
    public static final int TRAFFICSIGNTYPE_WARNING_EXCLUSIVELANE_RIGHTLEFTTURNONLY;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_NOVALUE;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_END_NOVALUE;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_5;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_10;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_15;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_20;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_25;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_30;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_35;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_40;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_45;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_50;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_55;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_60;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_65;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_70;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_75;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_80;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_85;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_90;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_95;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_100;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_110;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_120;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_130;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_140;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_150;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_160;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_170;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_VARIABLE_180;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_NOVALUE;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_5;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_10;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_15;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_20;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_25;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_30;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_35;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_40;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_45;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_50;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_55;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_60;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_65;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_70;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_75;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_80;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_85;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_90;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_95;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_100;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_110;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_120;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_130;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_140;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_150;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_160;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_170;
    public static final int TRAFFICSIGNTYPE_WARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_180;
    public static final int TRAFFICSIGNTYPEWARNING_EMPTY;
    public static final int TRAFFICSIGNTYPEWARNING_RAILWAY_CROSSING_PROTECTED;
    public static final int TRAFFICSIGNTYPEWARNING_RAILWAY_CROSSING_UNPROTECTED;
    public static final int TRAFFICSIGNTYPEWARNING_SHARP_TURN_LEFT;
    public static final int TRAFFICSIGNTYPEWARNING_SHARP_TURN_RIGHT;
    public static final int TRAFFICSIGNTYPEWARNING_FALLING_ROCKS;
    public static final int TRAFFICSIGNTYPEWARNING_MERGING_TRAFFIC_LEFT;
    public static final int TRAFFICSIGNTYPEWARNING_MERGING_TRAFFIC_RIGHT;
    public static final int TRAFFICSIGNTYPEWARNING_REDUCTION_OF_LANES;
    public static final int TRAFFICSIGNTYPEWARNING_NO_PASSING;
    public static final int TRAFFICSIGNTYPEWARNING_MERGING_TRAFFIC_BOTHSIDES;
    public static final int TRAFFICSIGNTYPEWARNING_TURN_RIGHT;
    public static final int TRAFFICSIGNTYPEWARNING_TURN_LEFT;
    public static final int TRAFFICSIGNTYPEWARNING_REDUCTION_OF_LANES_RIGHT;
    public static final int TRAFFICSIGNTYPEWARNING_REDUCTION_OF_LANES_LEFT;
    public static final int TRAFFICSIGNTYPEWARNING_EXCLUSIVELANE_RIGHTTURNONLY;
    public static final int TRAFFICSIGNTYPEWARNING_EXCLUSIVELANE_LEFTTURNONLY;
    public static final int TRAFFICSIGNTYPEWARNING_EXCLUSIVELANE_RIGHTLEFTTURNONLY;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_NOVALUE;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_END_NOVALUE;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_5;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_10;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_15;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_20;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_25;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_30;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_35;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_40;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_45;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_50;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_55;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_60;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_65;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_70;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_75;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_80;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_85;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_90;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_95;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_100;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_110;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_120;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_130;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_140;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_150;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_160;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_170;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_VARIABLE_180;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_NOVALUE;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_5;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_10;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_15;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_20;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_25;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_30;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_35;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_40;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_45;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_50;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_55;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_60;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_65;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_70;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_75;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_80;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_85;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_90;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_95;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_100;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_110;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_120;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_130;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_140;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_150;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_160;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_170;
    public static final int TRAFFICSIGNTYPEWARNING_SPEEDCAMERA_STARTPOINT_VARIABLE_180;
    public static final int SPEEDUNIT_METRIC;
    public static final int SPEEDUNIT_IMPERIAL;
    public static final int ROADCLASSTYPE_RURAL_ROAD;
    public static final int ROADCLASSTYPE_MOTORWAY;
    public static final int ROADCLASSTYPE_INNERCITY;
    public static final int ROADCLASSTYPE_OUTERCITY;
    public static final int ROADCLASSTYPE_RURAL_ROAD_MAXSPEED;
    public static final int ROADCLASSTYPE_MOTORWAY_ROAD_MAXSPEED;
    public static final int ROADCLASSTYPE_INNERCITY_ROAD_MAXSPEED;
    public static final int ROADCLASSTYPE_OUTERCITY_ROAD_MAXSPEED;
    public static final int ROADCLASSTYPE_RURAL_ROAD_RECOMMENDEDPEED;
    public static final int ROADCLASSTYPE_MOTORWAY_ROAD_RECOMMENDEDSPEED;
    public static final int ROADCLASSTYPE_INNERCITY_ROAD_RECOMMENDEDSPEED;
    public static final int ROADCLASSTYPE_OUTERCITY_ROAD_RECOMMENDEDSPEED;
    public static final int TRAILERSTATUS_NOTRAILER;
    public static final int TRAILERSTATUS_TRAILER;
    public static final int TRAILERSTATUS_UNSUPPORTED;
    public static final int SPEEDLIMITTYPE_UNDEFINED;
    public static final int SPEEDLIMITTYPE_CONVENTIONAL;
    public static final int SPEEDLIMITTYPE_RECOMMENDEDSPEED;
    public static final int WARNINGTYPE_UNDEFINED;
    public static final int WARNINGTYPE_CURVYROAD;
    public static final int WARNINGTYPE_RAILROAD;
    public static final int WARNINGTYPE_LANEGUIDANCE;
    public static final int WARNINGTYPE_JOINROADS;
    public static final int WARNINGTYPE_LASTEXIT;
    public static final int WARNINGTYPE_SPEEDCAMERA;
    public static final int TRAFFICSIGNSOURCE_UNDEFINED;
    public static final int TRAFFICSIGNSOURCE_NAVDBRAWDATA;
    public static final int TRAFFICSIGNSOURCE_VZO_OFFLINE;
    public static final int TRAFFICSIGNSOURCE_VZO_ONLINE;
    public static final int TRAFFICSIGNVARIANT_DEFAULT;

    default public void setSpeedLimitWarning(boolean bl, boolean bl2, int n) {
    }

    default public void requestRoadClassSpeedInfoForCountry(String string) {
    }

    default public void setTrailerStatus(boolean bl) {
    }

    default public void setWarningStatus(int n, boolean bl, boolean bl2, int n2) {
    }
}
