package it.jaschke.alexandria;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by ishan on 09/10/15.
 */
public class SimpleScannerActivity extends Activity implements ZXingScannerView.ResultHandler {

    private static final String TAG = "SimpleScannerActivity";
    private ZXingScannerView mScannerView;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }


    @Override
    public void handleResult(Result rawResult) {
        mScannerView.stopCamera();
//        Intent data = new Intent(MainActivity.MESSAGE_EVENT);
//        data.putExtra(MainActivity.MESSAGE_KEY, rawResult.getText());
//        LocalBroadcastManager.getInstance(SimpleScannerActivity.this).sendBroadcast(data);
//
        Intent data = new Intent();
        data.putExtra(MainActivity.MESSAGE_KEY, rawResult.getText());
        if (getParent() == null) {
            setResult(Activity.RESULT_OK, data);
        } else {
            getParent().setResult(Activity.RESULT_OK, data);
        }
        finish();
        // Do something with the result here
    }
}
