package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.v4.util.Pair;
import android.test.ActivityInstrumentationTestCase2;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class JokeTest extends ActivityInstrumentationTestCase2<MainActivity> {

    String outputString = null;
    Exception mError = null;
    CountDownLatch signal = null;

    public JokeTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    public void testJokeNotEmpty() throws InterruptedException {

        EndpointsAsyncTask task = new EndpointsAsyncTask();
        task.setListener(new EndpointsAsyncResponse() {
            @Override
            public void processFinish(String o) {
                outputString = o;
                signal.countDown();
            }
        }).execute(new Pair<Context, String>(new MainActivity(), ""));
        signal.await();

        assertNull(mError);
        assertFalse(TextUtils.isEmpty(outputString));

    }
}