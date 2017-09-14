package hooooong.com.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnMove;
    Button btnRotate;
    Button btnScale;
    Button btnAlpha;
    Button btnObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView(){
        btnMove = (Button)findViewById(R.id.btnMove);
        btnRotate = (Button)findViewById(R.id.btnRotate);
        btnScale = (Button)findViewById(R.id.btnScale);
        btnAlpha = (Button)findViewById(R.id.btnAlpha);
        btnObject = (Button)findViewById(R.id.btnObject);
    }

    private void initListener(){
        btnMove.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnScale.setOnClickListener(this);
        btnAlpha.setOnClickListener(this);
        btnObject.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnMove:
                move();
                break;
            case R.id.btnRotate:
                rotate();
                break;
            case R.id.btnScale:
                scale();
                break;
            case R.id.btnAlpha:
                alpha();
                break;
            case R.id.btnObject:
                Intent propAniActivity = new Intent(getBaseContext(), PropAniActivity.class);
                startActivity(propAniActivity);
                break;
        }
    }

    // btnMove 버튼에서 호출되는 함수 정의
    private void move() {
        // View 애니메이션 실행
        // 1. 애니메이션 XML 정의
        // 2. AnimationUtil로 정의된 애니메이션을 로드
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move);
        // 3. 로드된 애니메이션을 실제 위젯에 적용한다.
        btnObject.startAnimation(animation);

        // OR

        // 1. Animation 객체 생성
        // Animation 객체는
        // AlphaAnimation, TranslateAnimation, RotateAnimation, ScaleAnimation 이 있다.
        //Animation animation = new AlphaAnimation(0.1F, 0.1F);
        // 2. Animation 속성 정의
        //animation.setDuration(3000);
        // 3. 애니메이션을 실제 위젯에 적용한다.
        //btnObject.startAnimation(animation);
    }

    private void rotate() {
        // 1. 애니메이션 XML 정의
        // 2. AnimationUtil로 정의된 애니메이션을 로드
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        // 3. 로드된 애니메이션을 실제 위젯에 적용한다.
        btnObject.startAnimation(animation);
    }
    private void scale() {
        // 1. 애니메이션 XML 정의
        // 2. AnimationUtil로 정의된 애니메이션을 로드
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale);
        // 3. 로드된 애니메이션을 실제 위젯에 적용한다.
        btnObject.startAnimation(animation);
    }
    private void alpha() {
        // 1. 애니메이션 XML 정의
        // 2. AnimationUtil로 정의된 애니메이션을 로드
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        // 3. 로드된 애니메이션을 실제 위젯에 적용한다.
        btnObject.startAnimation(animation);
    }
}
