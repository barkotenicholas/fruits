package com.example.fruitsbenefits;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;

public class FruitDetailswithPhotos extends AppCompatActivity {

    String details;
    String headingDetails;
    int headingImage;
    TextView textView;
    TextView fruitsHeading;
    ImageView detailsFruitsImage;
    Button button;
    private BillingProcessor billingProcessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_detailswith_photos);

//        Here goes Get Intent method calling from Main Activity for Put Extra method.

        textView = findViewById(R.id.detailsTextViewId);
        fruitsHeading = findViewById(R.id.detailsHeadingId);
        detailsFruitsImage = findViewById(R.id.detailsImageId);
        button = findViewById(R.id.button);

        billingProcessor = new BillingProcessor(this,"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAimYOGnBuxZXnU5GCiXsaWdSFW3ToKhiEOB25l1GvbGAVKdOksfAfkWFbi3aFz39Xpl61Ef7K/0kmUcb2yYBA4olyW8rFhlpRtIi1s4oIm1ZIaWUZ730jnejctr8XWVEFFCtnLbh9gS1wuzB4txu5xM1mjs3rQAZ1jO7NL96s1wwoFm30a9iNPxsUcEHTF/Dho+ufvXKnAGu8/SqVm3erQFzL0sTST/AY4Yw4o2ViDxqqe2l69GlJgYu9T7ccf/ZahQM25bS4v71iD5LrRMwQjDc4528UbWn6iqJCsKeS8cCICc3Oj5CLTJ/Pb12DbvfKkbdf0/LwQpn8HDguH9zhCQIDAQAB" , null, new BillingProcessor.IBillingHandler() {
            @Override
            public void onProductPurchased(String productId, TransactionDetails details) {
                Toast.makeText(FruitDetailswithPhotos.this,"purchased",Toast.LENGTH_LONG);

            }

            @Override
            public void onPurchaseHistoryRestored() {

            }

            @Override
            public void onBillingError(int errorCode, Throwable error) {

            }

            @Override
            public void onBillingInitialized() {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                billingProcessor.subscribe(FruitDetailswithPhotos.this,"acup");

            }
        });

        details = getIntent().getStringExtra("fruits");
        headingDetails = getIntent().getStringExtra("fruitsDetailsHeading");
        headingImage = getIntent().getIntExtra("fruitsImage",0);
        fruitsHeading.setText(headingDetails);
        detailsFruitsImage.setImageResource(headingImage);
        textView.setText(details);
    }
}
