/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.azure.management.notificationhubs.models;

/**
* Description of a NotificationHub BaiduCredential.
*/
public class BaiduCredential {
    private String baiduApiKey;
    
    /**
    * Optional. Get or Set Baidu Api Key.
    * @return The BaiduApiKey value.
    */
    public String getBaiduApiKey() {
        return this.baiduApiKey;
    }
    
    /**
    * Optional. Get or Set Baidu Api Key.
    * @param baiduApiKeyValue The BaiduApiKey value.
    */
    public void setBaiduApiKey(final String baiduApiKeyValue) {
        this.baiduApiKey = baiduApiKeyValue;
    }
    
    private String baiduEndPoint;
    
    /**
    * Optional. Get or Set Baidu Endpoint.
    * @return The BaiduEndPoint value.
    */
    public String getBaiduEndPoint() {
        return this.baiduEndPoint;
    }
    
    /**
    * Optional. Get or Set Baidu Endpoint.
    * @param baiduEndPointValue The BaiduEndPoint value.
    */
    public void setBaiduEndPoint(final String baiduEndPointValue) {
        this.baiduEndPoint = baiduEndPointValue;
    }
    
    private String baiduSecretKey;
    
    /**
    * Optional. Get or Set Baidu Secret Key
    * @return The BaiduSecretKey value.
    */
    public String getBaiduSecretKey() {
        return this.baiduSecretKey;
    }
    
    /**
    * Optional. Get or Set Baidu Secret Key
    * @param baiduSecretKeyValue The BaiduSecretKey value.
    */
    public void setBaiduSecretKey(final String baiduSecretKeyValue) {
        this.baiduSecretKey = baiduSecretKeyValue;
    }
}
