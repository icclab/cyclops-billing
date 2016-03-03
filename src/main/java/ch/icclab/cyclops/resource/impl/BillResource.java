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

package ch.icclab.cyclops.resource.impl;

import ch.icclab.cyclops.resource.client.RcServiceClient;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Author: Srikanta
 * Created on: 26-May-15
 * Description: Creates the bill by combining the CDRs along with the tax and SLA details
 */
public class BillResource extends ServerResource {
    /**
     * Connects to the RC Service and requests for the CDRs. Fetches the tax and SLA penalties.
     * Constructs the bill response
     *
     * @return String
     */
    @Get
    public String generateBill(){
        String response;
        RcServiceClient client = new RcServiceClient();
        String userid = getQueryValue("userId");
        String fromDate = getQueryValue("from");
        String toDate = getQueryValue("to");

        response = client.getCdr(userid,fromDate,toDate);

        // Consider the discount
        // Add Tax and other charges
        // Construct the response

        return response;
    }

}
