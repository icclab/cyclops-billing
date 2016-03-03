package ch.icclab.cyclops.resource.impl;

import ch.icclab.cyclops.resource.client.RcServiceClient;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * @author Manu
 *         Created on 04.12.15.
 */
public class RevenueSharingReportResource extends ServerResource {
    /**
     * Connects to the RC Service and requests for the CDRs. Fetches the tax and SLA penalties.
     * Constructs the bill response
     *
     * @return String
     */
    @Get
    public String generateRevenueSharing(){
        String response;
        RcServiceClient client = new RcServiceClient();
        String virtualFunctionProvider = getQueryValue("vfpId");
        String serviceProvider = getQueryValue("spId");
        String fromDate = getQueryValue("from");
        String toDate = getQueryValue("to");

        response = client.getCdrForRevenueSharingReport(virtualFunctionProvider, serviceProvider,fromDate,toDate);

        // Consider the discount
        // Add Tax and other charges
        // Construct the response

        return response;
    }
}
