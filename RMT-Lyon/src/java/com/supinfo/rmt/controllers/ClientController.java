package com.supinfo.rmt.controllers;

import com.supinfo.rmt.entities.Client;
import com.supinfo.rmt.services.ClientService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

/**
 *
 * @author Francois
 */
@ManagedBean
public class ClientController {
    
    @EJB
    private ClientService clientService;
    private Client client;
    
    public String create(){
        clientService.create(client);
        return "";
    }
    
    public List<SelectItem> getClientItems(){
        List<Client> clients = clientService.getAll();
        List<SelectItem> items = new ArrayList<SelectItem>();
        for (Client client : clients) {
            items.add(new SelectItem(client, client.getName()));
        }
        return items;
    }

    public Client getClient() {
        if(client == null){
            client = new Client();
        }
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    
}
