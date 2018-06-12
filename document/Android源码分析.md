## Android源码相关分析

#### 如何设置Dialog的size

* 描述:

通常我们在自定义Dialog的时候, 都会有这个感觉, 在布局里设置with和height为MATCH_PARENT, 但是显示的时候都呈现的WRAP_CONTENT的效果

* 原因:

在我们自定义Dialog的时候, 会给dialog设置setContentView, 来看setContentView的原码

    ```
        // Dialog#setContentView
        public void setContentView(@LayoutRes int layoutResID) {
            mWindow.setContentView(layoutResID);
        }

        // PhoneWindow#setContentView
         @Override
         public void setContentView(int layoutResID) {
                ...
                 installDecor();    // 执行这里的installDecor()方法
                ...
           }

           // PhoneWindow#installDecor
           private void installDecor() {
                   ....
                   if (mContentParent == null) {
                       mContentParent = generateLayout(mDecor);

                       // Set up decor part of UI to ignore fitsSystemWindows if appropriate.
                       mDecor.makeOptionalFitsSystemWindows();
                       ....
                       }

                ....
            }

            // PhoneWindow#generateLayout()
            protected ViewGroup generateLayout(DecorView decor) {
                   ....
                    if (mIsFloating) {
                        setLayout(WRAP_CONTENT, WRAP_CONTENT);// 这里
                        setFlags(0, flagsToUpdate);
                    } else {
                        setFlags(FLAG_LAYOUT_IN_SCREEN|FLAG_LAYOUT_INSET_DECOR, flagsToUpdate);
                    }
            }

    ```

* 解决方法:
    1. 在setContentView后再设置Dialog宽和高
    2. 在dialog_layout.xml里直接包裹一层指定了宽高值得容器布局
    3.