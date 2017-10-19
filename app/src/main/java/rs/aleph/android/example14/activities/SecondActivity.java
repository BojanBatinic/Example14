package rs.aleph.android.example14.activities;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

import rs.aleph.android.example14.R;
import rs.aleph.android.example14.model.Jelo;

// Each activity extends Activity class
public class SecondActivity extends Activity {

    private int position = 0;

    private Jelo[] jela = new Jelo[]{
            new Jelo("sopska.jpg", "Sopska salata 400g", "Osvezavajuca salata od svezeg povrca i sira", "Zelena paprika, krastavac, paradajza, luk, ljuta papričica i punomsani sir.", 190.00, 300.00),
            new Jelo("cezar.jpg", "Cezar salata 400g", "Obrok salata od svezeg povrca i mesa", "Tost hleb u kockicama, pileće belo meso u trakama, zelena salata, beli luk, jaje i parmezan", 210.00, 350.00),
            new Jelo("tuna.jpg", "Tuna salata 400g", "Obrok salata od svezeg povrca i tunjevine", "Zelena salata, makaroni, kukuruz, crveni pasulj, tuna u komadićima, zelene masline i crveni luk.", 230.00, 320.00),
            new Jelo("vegeterijana.jpg", "Vegeterijanska salata 400g", "Osvezavajuca salata od svezeg povrca", "Paradajiz, krastavac, paprika, tikvice i patlidzan.", 170.00, 280.00)
    };

    // onCreate method is a lifecycle method called when he activity is starting
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Each lifecycle method should call the method it overrides
        super.onCreate(savedInstanceState);
        // setContentView method draws UI
        setContentView(R.layout.activity_second);

        // Shows a toast message (a pop-up message)
        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onCreate()", Toast.LENGTH_SHORT);
        toast.show();

        // Loads an URL into the WebView
        final int position = getIntent().getIntExtra("position", 0);

        // Finds "tvName" TextView and sets "text" property
        TextView tvNaziv = (TextView) findViewById(R.id.tv_naziv);
        tvNaziv.setText(jela[position].getNaziv());

        // Finds "tvDescription" TextView and sets "text" property
        TextView tvOpis = (TextView) findViewById(R.id.tv_opis);
        tvOpis.setText(jela[position].getOpis());

        TextView tvSastojci = (TextView) findViewById(R.id.tv_sastojci);
        tvSastojci.setText(jela[position].getSastojci());

        TextView tvKalorijskaVrednost = (TextView) findViewById(R.id.tv_kalorijskaVrednost);
        tvKalorijskaVrednost.setText(jela[position].getKalorijskaVrednost() + "");

        TextView tvCena = (TextView) findViewById(R.id.tv_cena);
        tvCena.setText(jela[position].getCena() + "");



        // Finds "ivImage" ImageView and sets "imageDrawable" property
        ImageView ivImage = (ImageView) findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getAssets().open(jela[position].getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Finds "btnBuy" Button and sets "onClickListener" listener
        Button btnBuy = (Button) findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "Kupili ste " + jela[position].getNaziv() + "!", Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }

    // onStart method is a lifecycle method called after onCreate (or after onRestart when the
    // activity had been stopped, but is now again being displayed to the user)
    @Override
    protected void onStart() {
        super.onStart();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onStart()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onRestart method is a lifecycle method called after onStop when the current activity is
    // being re-displayed to the user
    @Override
    protected void onRestart() {
        super.onRestart();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onRestart()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onResume method is a lifecycle method called after onRestoreInstanceState, onRestart, or
    // onPause, for your activity to start interacting with the user
    @Override
    protected void onResume() {
        super.onResume();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onResume()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onPause method is a lifecycle method called when an activity is going into the background,
    // but has not (yet) been killed
    @Override
    protected void onPause() {
        super.onPause();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onPause()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onStop method is a lifecycle method called when the activity are no longer visible to the user
    @Override
    protected void onStop() {
        super.onStop();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onStop()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onDestroy method is a lifecycle method that perform any final cleanup before an activity is destroyed
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onDestroy()", Toast.LENGTH_SHORT);
        toast.show();
    }
}
