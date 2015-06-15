/*
 * Copyright (c) 2015. Zuercher Hochschule fuer Angewandte Wissenschaften
 *  All Rights Reserved.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License"); you may
 *     not use this file except in compliance with the License. You may obtain
 *     a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *     WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *     License for the specific language governing permissions and limitations
 *     under the License.
 */

package ch.icclab.cyclops.model;

import java.util.HashMap;

/**
 * Author: Srikanta
 * Created on: 26-May-15
 * Description: The POJO class for receiving the response form the RC Service
 */
public class RcServiceResponse {
    private String userid;
    private HashMap time;
    private HashMap charge;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public HashMap getTime() {
        return time;
    }

    public void setTime(HashMap time) {
        this.time = time;
    }

    public HashMap getCharge() {
        return charge;
    }

    public void setCharge(HashMap charge) {
        this.charge = charge;
    }
}
