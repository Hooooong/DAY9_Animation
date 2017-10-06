package hooooong.com.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

public class PropAniActivity extends AppCompatActivity {


    Button btnJoystick;
    Button btnMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prop_ani);
        initView();
    }

    public void initView(){
        btnJoystick = (Button)findViewById(R.id.btnJoystick);
        btnMove = (Button)findViewById(R.id.btnMove);
    }


    float y = 0;

    public void move(View view){

        y = y +100;

        //1. 대상을 정의한다
        //2. 애니메이터를 설정한다.( 소수점 단위로 실행하는 ofFloat() )
        // ofFloat( 움직일 대상,
        ObjectAnimator aniY = ObjectAnimator.ofFloat(
                btnJoystick,        // 가. 움직일 대상
                "translationY",     // 나. 애니메이션 속성( 움직임)
                y                   // 다. 속성에 대한 값 ( 위치일 경우는 거리가 된다 )
        );
        ObjectAnimator aniX = ObjectAnimator.ofFloat(
                btnJoystick,        // 가. 움직일 대상
                "translationY",     // 나. 애니메이션 속성( 움직임)
                100                 // 다. 속성에 대한 값 ( 위치일 경우는 거리가 된다 )
        );

        ObjectAnimator aniRotate = ObjectAnimator.ofFloat(
                btnJoystick,        // 가. 움직일 대상
                "rotation",         // 나. 애니메이션 속성( 움직임)
                0F, 360F            // 다. 속성에 대한 값 ( 위치일 경우는 거리가 된다 )
        );

        //OR

        // 1. 애니메이션 XML(anim 이 아닌 animator resource) 정의
        // 2. AnimatorInflater.loadAnimator 로 정의된 애니메이션을 로드
        //ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.move);

        //3. 애니메이터를 실행한다.( 복합 애니메이션은 AnimatorSet 에 넣어서 한다. )
        AnimatorSet animatorSet = new AnimatorSet();

        animatorSet.playTogether(aniX, aniY);       // set 에 넣어 동시에 실행하게 한다.

        animatorSet.playSequentially(aniX, aniY);   // set 에 넣어 순차적으로 실행하게 한다. aniX 를 완료한 후 aniY를 실행
        animatorSet.setDuration(3000);              // 속성도 추가할 수 있다.

        // Interpolator : 가속도 개념
        animatorSet.setInterpolator(new LinearInterpolator());
        // 속도가 동일하게 이동 : linear_interpolator
        // 점점 빠르게 이동 : accerlerate_interpolator
        // 점점 느리게 이동 : decelerate_interpolator
        // 위 둘을 동시에 : accerlerate_decelerate_interpolator
        // 시작위치에서 조금 뒤로 당겼다 이동 : anticipate__interpolator
        // 도착위치를 조금 지나쳤다가 도착위치로 이동 : overshoot_interpolator
        // 위 둘을 동시에 : anticipate_overshoot_interpolator
        // 도착위치에서 튕김 : bounce_interpolator

        // 연속적으로 애니메이션을 실행시키기 위한 메소드
        // AnimatorSet 객체.playSequentially(Animator 객체, Animator 객체);

        // AnimationSet 시작
        animatorSet.start();

        // 애니메이션의 각종 상태를 확인할 수 있는 리스너
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                // 애니메이션 시작시
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                // 애니메이션 종료시
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                // 애니메이션 취소시
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                // 애니메이션 반복시
            }
        });
    }

    public void goJoystick(View view){

        Intent joystickActivity = new Intent(getBaseContext(), JoystickActivity.class);
        startActivity(joystickActivity);

    }
}
