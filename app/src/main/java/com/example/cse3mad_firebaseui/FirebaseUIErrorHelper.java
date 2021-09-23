package com.example.cse3mad_firebaseui;

import com.firebase.ui.auth.ErrorCodes;

public class FirebaseUIErrorHelper {

    public static String getErrorDefinition(int errorCode) {
        String errorString = "undefined error code";
        switch (errorCode) {

            case ErrorCodes.UNKNOWN_ERROR:
                errorString = "Unknown error.";
                break;

            case ErrorCodes.NO_NETWORK:
                errorString = "No network.";
                break;

            case ErrorCodes.PLAY_SERVICES_UPDATE_CANCELLED:
                errorString = "A required update to Play Services was cancelled by the user.";
                break;

            case ErrorCodes.DEVELOPER_ERROR:
                errorString = "A sign-in operation couldn't be completed due to a developer error";
                break;

            case ErrorCodes.PROVIDER_ERROR:
                errorString = "An external sign-in provider error occurred.";
                break;

            case ErrorCodes.ANONYMOUS_UPGRADE_MERGE_CONFLICT:
                errorString = "Anonymous account linking failed.";
                break;

            case ErrorCodes.EMAIL_MISMATCH_ERROR:
                errorString = "Signing in with a different email in the WelcomeBackIdp flow or email link flow.";
                break;

            case ErrorCodes.INVALID_EMAIL_LINK_ERROR:
                errorString = "Attempting to sign in with an invalid email link";
                break;

            case ErrorCodes.EMAIL_LINK_WRONG_DEVICE_ERROR:
                errorString = "Attempting to open an email link from a different device.";
                break;

            case ErrorCodes.EMAIL_LINK_PROMPT_FOR_EMAIL_ERROR:
                errorString = "We need to prompt the user for their email.";
                break;

            case ErrorCodes.EMAIL_LINK_CROSS_DEVICE_LINKING_ERROR:
                errorString = "Cross device linking flow - we need to ask the user if they want to continue linking or just sign in.";
                break;

            case ErrorCodes.EMAIL_LINK_DIFFERENT_ANONYMOUS_USER_ERROR:
                errorString = "Attempting to open an email link from the same device, with anonymous upgrade enabled, but the underlying anonymous user has been changed.";
                break;

            case ErrorCodes.ERROR_USER_DISABLED:
                errorString = "Attempting to auth with account that is currently disabled in the Firebase console.";
                break;

            case ErrorCodes.ERROR_GENERIC_IDP_RECOVERABLE_ERROR:
                errorString = "Recoverable error occurred during the Generic IDP flow.";
                break;
        }
        return errorString;
    }
}
