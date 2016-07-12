package org.tonykuo.service.util;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;

/**
 * 
 * @author tony
 *
 */
public class HttpUtil {

    /**
     * 
     * @param isSSL
     * @return
     * @throws KeyStoreException
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     */
    public static HttpClient newConnectionSocketFactory(final boolean isSSL)
            throws KeyStoreException, KeyManagementException, NoSuchAlgorithmException {

        final TrustStrategy allTrust = new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] certificate, String authType) throws CertificateException {
                return true;
            }
        };
        
        HostnameVerifier hostnameVerifier = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
        
        final RequestConfig defaultRequestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000).build();
        final HttpClientBuilder httpClientBuilder = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig);

        if (isSSL) {
            final SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(allTrust).build();
            final SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
            httpClientBuilder.setSSLSocketFactory(sslsf);
        }

        return httpClientBuilder.build();
    }

}
