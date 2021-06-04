package com.esrc.android.xwalk;

import android.os.Bundle;
import android.widget.Toast;

import com.esrc.sdk.android.ESRC;
import com.esrc.sdk.android.ESRCException;
import com.esrc.sdk.android.ESRCLicense;
import com.esrc.sdk.android.ESRCType;

import org.xwalk.core.XWalkActivity;
import org.xwalk.core.XWalkView;

public class MainActivity extends XWalkActivity {
    private XWalkView mXWalkView;

    private static final String APP_ID = "BAB7933D-C0D6-476F-8165-F26BC4C53B82";  // Application ID.
    private static final boolean ENABLE_HRV = true;  // Enablement of HRV analysis.
    private static final boolean ENABLE_DRAW = false;  // Enablement of visualzation.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mXWalkView = (XWalkView) findViewById(R.id.xwalk_view);

        // Initialize ESRC
        ESRC.init(APP_ID, this, new ESRCLicense.ESRCLicenseHandler() {
            @Override
            public void onValidatedLicense() {
                // Start
                start();
            }

            @Override
            public void onInvalidatedLicense() {
                Toast.makeText(getApplicationContext(), "Invalid license", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onXWalkReady() {
        mXWalkView.load("https://www.esrc.co.kr", null);
    }

    @Override
    protected void onDestroy() {
        // Stop
        stop();

        super.onDestroy();
    }

    /**
     * Starts ESRC process.
     */
    private void start() {


        // Start ESRC
        ESRC.start(ENABLE_HRV, ENABLE_DRAW, new ESRC.ESRCHandler() {
            @Override
            public void onDetectedFace(ESRCType.Face face, ESRCException e) {

            }

            @Override
            public void onNotDetectedFace(ESRCException e) {

            }

            @Override
            public void onDetectedFacialLandmark(ESRCType.FacialLandmark facialLandmark, ESRCException e) {

            }

            @Override
            public void onAnalyzedFacialActionUnit(ESRCType.FacialActionUnit facialActionUnit, ESRCException e) {

            }

            @Override
            public void onRecognizedFacialExpression(ESRCType.FacialExpression facialExpression, ESRCException e) {

            }

            @Override
            public void onEstimatedHeadPose(ESRCType.HeadPose headPose, ESRCException e) {

            }

            @Override
            public void onRecognizedAttention(ESRCType.Attention attention, ESRCException e) {

            }

            @Override
            public void didChangedProgressRatioOnRemoteHR(ESRCType.ProgressRatio progressRatio, ESRCException e) {

            }

            @Override
            public void onEstimatedRemoteHR(ESRCType.RemoteHR remoteHR, ESRCException e) {

            }

            @Override
            public void didChangedProgressRatioOnHRV(ESRCType.ProgressRatio progressRatio, ESRCException e) {

            }

            @Override
            public void onAnalyzedHRV(ESRCType.HRV hrv, ESRCException e) {

            }

            @Override
            public void onRecognizedEngagement(ESRCType.Engagement engagement, ESRCException e) {

            }

            @Override
            public void onRecognizedEngagement2(ESRCType.Engagement2 engagement2, ESRCException e) {

            }
        });
    }

    /**
     * Stop ESRC process.
     */
    private void stop() {
        // Stop ESRC
        ESRC.stop();
    }
}
