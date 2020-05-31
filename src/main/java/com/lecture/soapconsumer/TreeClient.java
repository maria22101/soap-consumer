package com.lecture.soapconsumer;

import com.soap.consuming.wsdl.GetTreeRequest;
import com.soap.consuming.wsdl.GetTreeResponse;
import com.soap.consuming.wsdl.ObjectFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class TreeClient extends WebServiceGatewaySupport {

    public GetTreeResponse getTree(int id){
        GetTreeRequest request = new ObjectFactory().createGetTreeRequest();

        request.setId(id);

        GetTreeResponse response = (GetTreeResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8081/ws/trees", request,
                        new SoapActionCallback("http://soapService.tutorial/getTreeRequest"));

        return response;
    }
}

