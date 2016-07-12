package org.tonykuo.service.util;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.junit.Test;

public class HttpUtilTester {

    /**
     * TEST URL https://httpbin.org/
     * 
     * @throws ClientProtocolException
     * @throws IOException
     */
    @Test
    public void testHttpClient() throws ClientProtocolException, IOException {
        //
        System.out.println(Request.Post("https://httpbin.org/post").bodyString("{key:123}", ContentType.APPLICATION_JSON).execute().returnContent());
    }

    /**
     * 
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     */
    @Test
    public void testSSLHttpClient() throws ClientProtocolException, IOException, KeyManagementException,
            KeyStoreException, NoSuchAlgorithmException {
        
        Executor executor = Executor.newInstance(HttpUtil.newConnectionSocketFactory(true));
        
        System.out.println(executor.execute(Request.Post("https://192.168.197.140:8443/test/index")).returnContent());
    }

}
