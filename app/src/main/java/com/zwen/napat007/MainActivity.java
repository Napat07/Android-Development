package com.zwen.napat007;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private TextSwitcher simpleTextSwitcher;
    Button btnNext;


    // Array of String to Show In TextSwitcher
    String strings[] = {"ข้อ 1 ประเทศไทยมีกี่จังหวัด ?", "ตอบ 77 จังหวัด", " ข้อ 2 สุนัขสามารถกินอาหารของมนุษย์ได้หรือไม่ ?", "ตอบ กินได้ แต่ต้องคำนึงถึงโภชนการที่สุนัขได้รับ ", " ข้อ 3 มะเร็งตับมักพบที่ไหน " , "ตอบ ตับ"};
    int messageCount = strings.length;
    // to keep current Index of textID array
    int currentIndex = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // get The references if Button and TextSwitcher
        btnNext = (Button) findViewById(R.id.buttonNext);
        simpleTextSwitcher = (TextSwitcher) findViewById(R.id.simpleTextSwitcher);
        // Set the ViewFactory of the TextSwitcher that will create TextView object when asked
        simpleTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub
                // create a TextView
                TextView t = new TextView(MainActivity.this);
                // set the gravity of text to top and center horizontal
                t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                // set displayed text size
                t.setTextSize(36);
                return t;
            }
        });

        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        // set the animation type to TextSwitcher
        simpleTextSwitcher.setInAnimation(in);
        simpleTextSwitcher.setOutAnimation(out);

        //text appear on start
        simpleTextSwitcher.setCurrentText("คลิกเพื่อเข้าสู่คำถาม");
        // ClickListener for NEXT button
        // When clicked on Button TextSwitcher will switch between labels
        // The current label will go out and next label will come in with specified animation
        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                currentIndex++;
                // If index reaches maximum then reset it
                if (currentIndex == messageCount)
                    currentIndex = 0;
                simpleTextSwitcher.setText(strings[currentIndex]); // set Text in TextSwitcher
            }
        });

    }

}

