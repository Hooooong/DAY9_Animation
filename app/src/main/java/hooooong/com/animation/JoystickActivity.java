package hooooong.com.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class JoystickActivity extends AppCompatActivity implements View.OnClickListener{

    private FrameLayout frameLayout;
    private Button btnUp;
    private Button btnDown;
    private Button btnLeft;
    private Button btnRight;
    private Button btnPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joystick);
        initView();
        initListener();
    }

    /**
     * View 초기화
     */
    public void initView(){
        frameLayout = (FrameLayout)findViewById(R.id.frameLayout) ;
        btnUp = (Button)findViewById(R.id.btnUp);
        btnDown = (Button)findViewById(R.id.btnDown);
        btnLeft = (Button)findViewById(R.id.btnLeft);
        btnRight = (Button)findViewById(R.id.btnRight);
        btnPlayer = (Button)findViewById(R.id.btnPlayer);
    }

    /**
     * Listener 초기화
     */
    public void initListener(){
        btnUp.setOnClickListener(this);
        btnDown.setOnClickListener(this);
        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);
    }

    /**
     * Click 이벤트
     *
     * @param view
     */
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnUp:
                up();
                break;
            case R.id.btnDown:
                down();
                break;
            case R.id.btnLeft:
                left();
                break;
            case R.id.btnRight:
                right();
                break;
        }
    }

    int playerX = 0;
    int playerY = 0;

    private void up() {
        playerY -= 100;
        move();
    }

    private void down() {
        playerY += 100;
        move();
    }

    private void left() {
        playerX -= 100;
        move();
    }

    private void right() {
        playerX += 100;
        move();
    }

    /**
     * button 이동 애니메이션 처리
     */
    private void move(){

        ObjectAnimator aniY = ObjectAnimator.ofFloat(
                btnPlayer, "translationY" , playerY
        );
        ObjectAnimator aniX = ObjectAnimator.ofFloat(
                btnPlayer, "translationX" , playerX
        );

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(aniX, aniY);
        animatorSet.start();
    }
}
