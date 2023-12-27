/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.recorder;

public class MediaRecorderHelper {
    public static String getImportStatusStr(int n) {
        String string = "unknown";
        switch (n) {
            case 0: {
                string = "idle";
                break;
            }
            case 1: {
                string = "importing";
                break;
            }
            case 2: {
                string = "pre_processing";
                break;
            }
            case 3: {
                string = "post_processing";
                break;
            }
            case 4: {
                string = "success";
                break;
            }
            case 5: {
                string = "aborted";
                break;
            }
            case 6: {
                string = "suspend";
                break;
            }
            case 7: {
                string = "ready_for_selection";
                break;
            }
            case 8: {
                string = "ready_for_resume";
                break;
            }
        }
        return string;
    }

    public static String getDeleteStatusStr(int n) {
        String string = "unknown";
        switch (n) {
            case 5: {
                string = "aborted";
                break;
            }
            case 1: {
                string = "deleting";
                break;
            }
            case 6: {
                string = "finished with errors";
                break;
            }
            case 0: {
                string = "idle";
                break;
            }
            case 3: {
                string = "post processing";
                break;
            }
            case 2: {
                string = "pre processing";
                break;
            }
            case 7: {
                string = "ready for selection";
                break;
            }
            case 4: {
                string = "success";
                break;
            }
        }
        return string;
    }
}

