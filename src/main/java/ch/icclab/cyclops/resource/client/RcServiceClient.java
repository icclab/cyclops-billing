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

package ch.icclab.cyclops.resource.client;

import ch.icclab.cyclops.model.RcServiceResponse;
import ch.icclab.cyclops.util.Load;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.Client;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.io.IOException;

/**
 * Author: Srikanta
 * Created on: 26-May-15
 * Description: The RC client class for connecting to the CYCLOPS RC Service
 */
public class RcServiceClient extends ClientResource {
    private String url = Load.configuration.get("RcServiceUrl");

    /**
     * Connects to the RC Service and requests for the CDRs for a user between a time period
     *
     * @param from String
     * @param to String
     * @param userId String
     * @return String
     */
    public String getCdr(String userId, String from, String to) {
        JSONObject resultArray = null;
        RcServiceResponse chargeDataRecords = null;
        ObjectMapper mapper = new ObjectMapper();
        Client client = new Client(Protocol.HTTP);

        ClientResource resource = new ClientResource(url + "/charge");
        resource.getReference().addQueryParameter("userid", userId);
        resource.getReference().addQueryParameter("from", from);
        resource.getReference().addQueryParameter("to", to);
        resource.get(MediaType.APPLICATION_JSON);
        Representation output = resource.getResponseEntity();
        try {
            resultArray = new JSONObject(output.getText());
            chargeDataRecords = mapper.readValue(resultArray.toString(), RcServiceResponse.class);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultArray.toString();
    }
}
