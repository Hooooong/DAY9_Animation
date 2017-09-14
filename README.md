Android Programing
----------------------------------------------------
#### 2017.09.14 3일차

###### 예제
____________________________________________________

  - [Button Animation 예제]()
  - [SpreadCubes 예제]()

###### 공부정리
____________________________________________________

  - Animation 이란?

    > 안드로이드는 View 의 간단한 변형에 관련된 애니메이션 처리를 지원한다. 위치 이동, 회전, 크기 변환, 투명도 변환이 있다.

        1. View

            >  View 자체가 이동하는것이 아니라 애니메이션을 적용한 View는 그대로 있고, 보이는 화면에서만 이동을 한다.( 예를 들면 버튼의 이미지는 이동하지만 클릭은 이동하기 전 영역에서 할 수 있다.)

        2. Property

            > View 자체가 이동한다.

  - Animation 사용 방법

    - View 적용 방법

        ```java
        // View 애니메이션 실행
        // 1. 애니메이션 XML 정의
        // 2. AnimationUtil로 정의된 애니메이션을 로드
        Animation animation = AnimationUtils.loadAnimation(this, xml파일이름);
        // 3. 로드된 애니메이션을 실제 위젯에 적용한다.
        View객체.startAnimation(animation);

        // OR

        // 1. Animation 객체 생성
        // Animation 객체는
        // AlphaAnimation, TranslateAnimation, RotateAnimation, ScaleAnimation 이 있다.
        Animation animation = new AlphaAnimation(0.1F, 0.1F);
        // 2. Animation 속성 정의
        animation.setDuration(3000);
        // 3. 애니메이션을 실제 위젯에 적용한다.
        View객체.startAnimation(animation);
        ```

    - Property 적용 방법

        ```java
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
                "rotation",         // 나. 애니메이션 속성(회전)
                0F, 360F            // 다. 속성에 대한 값 ( 위치일 경우는 거리가 된다 )
        );

        //3. 애니메이터를 실행한다.( 복합 애니메이션은 AnimatorSet 에 넣어서 한다. )
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(aniX, aniY);       // set 에 넣어 동시에 실행하게 한다.
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

        animatorSet.start();
        ```

  - Animation 종류

    - __MOVE__

        - View 의 대상을 움직이는 애니메이션

        - XML 코드

            ```xml
            <?xml version="1.0" encoding="utf-8"?>
            <!--
                translate 의 주요 속성

                formXDelta : X 좌표의 시작 위치
                formYDelta : Y 좌표의 시작 위치 ( 양수이면 y는 -로 이동한다. )
                toXDelta : 이동할 X 좌표 위치
                toYDelta : 이동할 Y 좌표 위치 ( 양수이면 y는 -로 이동한다. )
                duration : 애니메이션의 동작하는 시간(1/1000 단위)
                fillAfter : 고정(true)할지 안할지(false)
                            true : 애니메이션의 종료위치에 고정
                            false : 원래위치로 복귀 ( default : false)
            -->
            <translate
                xmlns:android="http://schemas.android.com/apk/res/android"
                android:fromXDelta="0"
                android:fromYDelta="0"
                android:toXDelta="100"
                android:toYDelta="300"
                android:duration="3000"
                android:fillAfter="true"
                >
            </translate>            
            ```

    - __ROTATE__

        - View 의 대상을 회전하는 애니메이션

        - XML 코드

            ```XML
            <?xml version="1.0" encoding="utf-8"?>
            <!--
                rotate 의 주요 속성

                fromDegrees : X 좌표의 시작 위치
                toDegrees : Y 좌표의 시작 위치 ( 양수이면 y는 -로 이동한다. )

                pivotX : 회전할 기준의 X 좌표 ( % 로 )
                pivotY : 회전할 기준의 Y 좌표 ( % 로 )

                duration : 애니메이션의 동작하는 시간(1/1000 단위)
                fillAfter : 고정(true)할지 안할지(false)
                            true : 애니메이션의 종료위치에 고정
                            false : 원래위치로 복귀 ( default : false)
            -->
            <rotate
                xmlns:android="http://schemas.android.com/apk/res/android"
                android:fromDegrees="0"
                android:toDegrees="270"

                android:pivotX="50%"
                android:pivotY="50%"

                android:duration="3000"
                android:fillAfter="true"
                >
            </rotate>
            ```

    - __SCALE__

        - View 의 대상을 확장하는 애니메이션

        - XML 코드

            ```XML
            <?xml version="1.0" encoding="utf-8"?>

            <!--
                scale 의 주요 속성

                fromXScale : X 축의 시작 길이
                fromYScale : Y 축의 시작 길이
                toXScale : 확장할 X 축 길이
                toYScale : 확장할 Y 축 길이
                duration : 애니메이션의 동작하는 시간(1/1000 단위)
                fillAfter : 고정(true)할지 안할지(false)
                            true : 애니메이션의 종료위치에 고정
                            false : 원래위치로 복귀 ( default : false)
            -->

            <scale
                xmlns:android="http://schemas.android.com/apk/res/android"
                android:fromXScale="100dp"
                android:fromYScale="100dp"
                android:toXScale="300dp"
                android:toYScale="300dp"
                android:duration="3000"
                android:fillAfter="true"
                >
            </scale>            
            ```

    - __ALPHA__

        - View 의 대상의 투명도를 조절하는 애니메이션

        - XML 코드

            ```XML
            <?xml version="1.0" encoding="utf-8"?>
            <!--
                scale 의 주요 속성

                fromAlpha : 투명도 시작값 (0.0 ~ 1.0)
                toAlpha : 투명도 종료값 (0.0 ~ 1.0)
                duration : 애니메이션의 동작하는 시간(1/1000 단위)
                fillAfter : 고정(true)할지 안할지(false)
                            true : 애니메이션의 종료위치에 고정
                            false : 원래위치로 복귀 ( default : false)
            -->
            <alpha
                xmlns:android="http://schemas.android.com/apk/res/android"
                android:fromAlpha="0.0"
                android:toAlpha="1.0"
                android:duration="3000"
                android:fillAfter="true"
                >
            </alpha>            
            ```
