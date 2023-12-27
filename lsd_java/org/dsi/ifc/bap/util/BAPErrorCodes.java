/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bap.util;

public class BAPErrorCodes {
    public static String stringFromErrorCode(int n) {
        switch (n) {
            case 17: {
                return "Transport medium not accessible";
            }
            case 18: {
                return "Received a sequence message without the start message";
            }
            case 19: {
                return "Received unexpected sequence number during segmentation";
            }
            case 20: {
                return "Time out occured while waiting for next segmented message";
            }
            case 21: {
                return "The received segmented message doesn't fit inside the receive buffer";
            }
            case 22: {
                return "Incorrect message length received";
            }
            case 23: {
                return "Overflow of receive buffer";
            }
            case 33: {
                return "Time out for occurred while waiting for the heartbeat message";
            }
            case 34: {
                return "Retry time-out occurred - all retry messages weren't successful";
            }
            case 35: {
                return "Request could not be processed because the retry timer is running";
            }
            case 36: {
                return "Request could not be send to vehicle bus and the number of retries is reached";
            }
            case 50: {
                return "The protocol version of function control unit (FSG) is not the same as the version of display control unit (ASG)";
            }
            case 51: {
                return "The data specification of function control unit (FSG) is not the same as of display control unit (ASG)";
            }
            case 52: {
                return "Either GetAll message corrupted, send buffers of FSG not initialized or BAP cache invalid";
            }
            case 53: {
                return "The BAP stack for given logical control unit is in a wrong state";
            }
            case 54: {
                return "There is no cache available for given logical control unit";
            }
            case 55: {
                return "One of the given parameters for given logical control unit is invalid";
            }
            case 65: {
                return "The data to send or to receive are out of range";
            }
            case 66: {
                return "Either the method is not implemented or is temporary not available";
            }
            case 67: {
                return "The given request or a received message is exceed the specified data length";
            }
            case 68: {
                return "The units between the function and display control unit are ambiguous";
            }
            case 80: {
                return "The method was successfully aborted by the function control unit (FSG)";
            }
        }
        return "Unknown BAP error error code received";
    }

    public static boolean isStandardizedErrorCode(int n) {
        return n > 0 && n <= 127;
    }
}

