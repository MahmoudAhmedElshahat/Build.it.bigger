package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by MahmoudAhmed on 11/19/2017.
 */
@RunWith(AndroidJUnit4.class)
public class NetworkTest {

    Context context;

    @Test
    public void testNetworking() throws Throwable {

        context= InstrumentationRegistry.getContext();
        final CountDownLatch signal = new CountDownLatch(1);

        Network network=new Network(){


            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                if(result == null )
                    return;

                assertTrue(result.length() > 0 );
                signal.countDown();
            }
        };
        network.execute(context);
        signal.await();
    }


}
