package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.test.ActivityUnitTestCase;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by MahmoudAhmed on 11/19/2017.
 */
public class NetworkTest extends ActivityUnitTestCase{

    Context context;

    public NetworkTest(Class activityClass) {
        super(activityClass);
    }

    @Test
    public void testNetworking() throws Throwable {

        context= InstrumentationRegistry.getContext();
        final CountDownLatch signal = new CountDownLatch(1);

        Network network=new Network(){


            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                assertNotNull(result);
                if(result == null )
                    return;

                assertTrue(result.length() > 0 );
                signal.countDown();
            }
        };
        network.execute(context);

        signal.await();
        signal.await(10, TimeUnit.SECONDS);
    }


}
