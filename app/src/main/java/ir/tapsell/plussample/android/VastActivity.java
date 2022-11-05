package ir.tapsell.plussample.android;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.api.ImaSdkFactory;
import com.google.ads.interactivemedia.v3.api.ImaSdkSettings;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ext.ima.ImaAdsLoader;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.util.ArrayList;

import ir.tapsell.plus.TapsellPlus;

public class VastActivity extends AppCompatActivity {

    private static final String TAG = "VastActivity";

    private TextView tvLog;
    private PlayerView playerView;
    private SimpleExoPlayer player;
    private ImaAdsLoader adsLoader;
    private ViewGroup companionViewGroup;
    private ImaSdkFactory sdkFactory;
    private ArrayList<CompanionAdSlot> companionAdSlots;
    private boolean isShowing=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vast);

//        initUI();
//
//        sdkFactory = ImaSdkFactory.getInstance();
//        ImaSdkSettings settings = sdkFactory.createImaSdkSettings();
//        settings.setLanguage("fa");
//
//        addCompanionAds();
//
//        // Create an AdsLoader.
//        adsLoader = new ImaAdsLoader.Builder(/* context= */ this)
//                .setImaSdkSettings(settings)
//                .setAdEventListener(this)
//                .setAdErrorListener(this)
//                .setCompanionAdSlots(companionAdSlots)
//                .build();
//    }
//
//    private void initUI() {
//
//        playerView = findViewById(R.id.player_view);
//        tvLog = findViewById(R.id.tvLog);
//        Button requestButton = findViewById(R.id.btnRequest);
//        requestButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (!isShowing){
//                    isShowing = true;
//                    prepareVideo();
//
//                }else {
//                    Toast.makeText(VastActivity.this, "wait for complete ALL ADS", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//
//    private void addCompanionAds() {
//
//        companionViewGroup = findViewById(R.id.companionAdSlot);
//        companionViewGroup.setVisibility(View.VISIBLE);
//        CompanionAdSlot companionAdSlot = sdkFactory.createCompanionAdSlot();
//        companionAdSlot.setContainer(companionViewGroup);
//        companionAdSlot.setSize(320, 50);
//        companionAdSlots = new ArrayList<>();
//        companionAdSlots.add(companionAdSlot);
//    }
//
//    private void prepareVideo() {
//
//        // Create the MediaItem to play, specifying the content URI and ad tag URI.
//        String tag = TapsellPlus.getVastTag(BuildConfig.TAPSELL_VAST_PREROLL);
//        Uri contentUri = Uri.parse("https://storage.backtory.com/tapsell-server/sdk/VASTContentVideo.mp4");
//        Uri adTagUri = Uri.parse(tag);
//        Log.e(TAG, "tag:"+ tag);
//        // Log.e(TAG, "contentUri:"+ contentUri);
//        Log.e(TAG, "adTagUri:"+ adTagUri);
//        MediaItem mediaItem = new MediaItem.Builder().setUri(contentUri).setAdTagUri(adTagUri).build();
//
//        // Prepare the content and ad to be played with the SimpleExoPlayer.
//        player.setMediaItem(mediaItem);
//        player.prepare();
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        if (Util.SDK_INT > 23) {
//            initializePlayer();
//            if (playerView != null) {
//                playerView.onResume();
//            }
//        }
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        if (Util.SDK_INT <= 23 || player == null) {
//            initializePlayer();
//            if (playerView != null) {
//                playerView.onResume();
//            }
//        }
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        if (Util.SDK_INT <= 23) {
//            if (playerView != null) {
//                playerView.onPause();
//            }
//            releasePlayer();
//        }
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (Util.SDK_INT > 23) {
//            if (playerView != null) {
//                playerView.onPause();
//            }
//            releasePlayer();
//        }
//    }
//
//    @Override
//    protected void onDestroy() {
//        adsLoader.release();
//
//        super.onDestroy();
//    }
//
//    private void releasePlayer() {
//        adsLoader.setPlayer(null);
//        playerView.setPlayer(null);
//        player.release();
//        player = null;
//    }
//
//    private void initializePlayer() {
//        // Set up the factory for media sources, passing the ads loader and ad view providers.
//        DataSource.Factory dataSourceFactory =
//                new DefaultDataSourceFactory(this, Util.getUserAgent(this, getString(R.string.app_name)));
//
//        MediaSourceFactory mediaSourceFactory =
//                new DefaultMediaSourceFactory(dataSourceFactory)
//                        .setAdsLoaderProvider(unusedAdTagUri -> adsLoader)
//                        .setAdViewProvider(playerView);
//
//        // Create a SimpleExoPlayer and set it as the player for content and ads.
//        player = new SimpleExoPlayer.Builder(this).setMediaSourceFactory(mediaSourceFactory).build();
//        playerView.setPlayer(player);
//        adsLoader.setPlayer(player);
//
//        // Set PlayWhenReady. If true, content and ads will autoplay.
//        player.setPlayWhenReady(true);
//    }
//
//    /**
//     * AdErrorListener implementation
//     **/
//    @Override
//    public void onAdError(AdErrorEvent event) {
//
//        tvLog.append(event.getError().getMessage() + "\n");
//        Log.e(TAG, "Ad Error: " + event.getError().getMessage());
//    }
//
//    /**
//     * AdEventListener implementation
//     **/
//    @Override
//    public void onAdEvent(AdEvent event) {
//        switch (event.getType()) {
//            case STARTED:
//                companionViewGroup.setVisibility(View.VISIBLE);
//            case AD_PROGRESS:
//                // Do nothing or else log are filled by these messages.
//                break;
//            case COMPLETED:
//            case SKIPPED:
//
//                // To hide companion ads after the ads finished
//                //companionViewGroup.setVisibility(View.GONE);
//                break;
//            case ALL_ADS_COMPLETED:
//                isShowing = false;
//                companionViewGroup.setVisibility(View.GONE);
//            default:
//                tvLog.append(event.getType().name() + "\n");
//                break;
//        }
//    }
}
}