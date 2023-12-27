/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.internal;

import java.util.ArrayList;
import org.dsi.ifc.internal.ConnectorType;
import org.dsi.ifc.internal.LocationHelper;
import org.elektrobit.json.simple.JSONArray;
import org.elektrobit.json.simple.JSONObject;
import org.elektrobit.json.simple.parser.JSONParser;
import org.elektrobit.json.simple.parser.ParseException;

public class ChargingStation {
    public static final String[] chargeCapacityMapping = new String[]{"", "BATTERY_EXCHANGE", "INDUCTIVE_CHARGE", "10A", "12A", "16A", "10A", "12A", "13A", "15A", "16A", "32A", "63A", "16A", "32A", "63A", "200A"};
    public static final String[] powerFeedTypeMapping = new String[]{"", "Level 1", "Level 2", "Level 3", "Level 1", "Level 2", "Level 3 AC"};
    public static final String[] chargeModeMapping = new String[]{"", "Mode 2", "Mode 2", "Mode 3", "Mode 4"};
    public static final int[] connectorTypeMapping = new int[]{32, 33, 42, 43, 31, 15, 41};
    private boolean valid = false;
    private LocationHelper m_Helper = null;
    private int pay = -1;
    private int noOfConnectorTypes = -1;
    private int subscription = -1;
    private int open24H = -1;
    private int onSitePayment = -1;
    private int access = -1;
    private String provider = "";
    private ArrayList connectors = new ArrayList();

    public ChargingStation(LocationHelper locationHelper) {
        this.m_Helper = locationHelper;
    }

    int getPay() {
        if (!this.valid) {
            this.parseJson();
        }
        return this.pay;
    }

    int getNoOfConnectorTypes() {
        if (!this.valid) {
            this.parseJson();
        }
        return this.noOfConnectorTypes;
    }

    int getSubscription() {
        if (!this.valid) {
            this.parseJson();
        }
        return this.subscription;
    }

    int getOpen24H() {
        if (!this.valid) {
            this.parseJson();
        }
        return this.open24H;
    }

    int getOnSitePayment() {
        if (!this.valid) {
            this.parseJson();
        }
        return this.onSitePayment;
    }

    int getAccess() {
        if (!this.valid) {
            this.parseJson();
        }
        return this.access;
    }

    String getProvider() {
        if (!this.valid) {
            this.parseJson();
        }
        return this.provider;
    }

    ConnectorType getConnector(int n) {
        if (!this.valid) {
            this.parseJson();
        }
        return (ConnectorType)this.connectors.get(n);
    }

    void parseJson() {
        this.valid = true;
        String string = this.m_Helper.getDataOfSelectionCriterion(1281);
        if (string.length() > 0) {
            JSONParser jSONParser = new JSONParser();
            try {
                Object object = jSONParser.parse(string);
                JSONObject jSONObject = (JSONObject)object;
                this.pay = this.getIntValue(jSONObject, "p");
                this.access = this.getIntValue(jSONObject, "a");
                this.provider = this.getStringValue(jSONObject, "pr");
                this.open24H = this.getIntValue(jSONObject, "open24H");
                JSONObject jSONObject2 = (JSONObject)jSONObject.get("pm");
                this.subscription = this.getIntValue(jSONObject2, "s");
                this.onSitePayment = this.pay > 0 ? (this.getStringValue(jSONObject2, "cct").length() > 0 ? 1 : (this.getIntValue(jSONObject2, "ca") > 0 ? 1 : (this.getIntValue(jSONObject2, "ep") > 0 ? 1 : (this.getIntValue(jSONObject2, "et") > 0 ? 1 : (this.getIntValue(jSONObject2, "mp") > 0 ? 1 : (this.getStringValue(jSONObject2, "0").length() > 0 ? 1 : (this.getIntValue(jSONObject2, "ca") > 0 ? 0 : -1))))))) : -1;
                JSONArray jSONArray = (JSONArray)jSONObject.get("ct");
                this.noOfConnectorTypes = jSONArray.size();
                for (int i2 = 0; i2 < this.noOfConnectorTypes; ++i2) {
                    ConnectorType connectorType = new ConnectorType();
                    JSONObject jSONObject3 = (JSONObject)jSONArray.get(i2);
                    connectorType.countAvailable = this.getIntValue(jSONObject3, "n");
                    connectorType.chargeMode = this.mapIdxToString(jSONObject3, "cm", chargeModeMapping);
                    connectorType.chargeLevel = this.mapIdxToString(jSONObject3, "pft", powerFeedTypeMapping);
                    connectorType.name = this.getStringValue(jSONObject3, "ccn");
                    connectorType.type = this.mapIdxToEnum(jSONObject3, "vi", connectorTypeMapping);
                    connectorType.fuseProtection = this.mapIdxToString(jSONObject3, "cc", chargeCapacityMapping);
                    connectorType.powerOutput = Float.parseFloat(this.getStringValue(jSONObject3, "mpl"));
                    this.connectors.add(connectorType);
                }
            }
            catch (ParseException parseException) {
                System.out.println(parseException);
            }
        }
    }

    int getIntValue(JSONObject jSONObject, String string) {
        String string2;
        int n = -1;
        Object object = jSONObject.get(string);
        if (object != null && (string2 = object.toString()).length() > 0) {
            n = Integer.parseInt(string2);
        }
        return n;
    }

    String getStringValue(JSONObject jSONObject, String string) {
        String string2 = "";
        Object object = jSONObject.get(string);
        if (object != null) {
            string2 = object.toString();
        }
        return string2;
    }

    String mapIdxToString(JSONObject jSONObject, String string, String[] stringArray) {
        String string2 = "not available";
        int n = this.getIntValue(jSONObject, string);
        if (n < 0) {
            n = 0;
        }
        try {
            string2 = stringArray[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println(indexOutOfBoundsException);
            return "value unkonown";
        }
        return string2;
    }

    int mapIdxToEnum(JSONObject jSONObject, String string, int[] nArray) {
        int n = -1;
        int n2 = this.getIntValue(jSONObject, string);
        if (n2 >= 0) {
            try {
                n = nArray[n2];
            }
            catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                System.out.println(indexOutOfBoundsException);
            }
        }
        return n;
    }
}

