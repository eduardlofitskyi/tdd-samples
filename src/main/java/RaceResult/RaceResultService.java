package RaceResult;
;

import java.util.*;

/**
 * Created by eduard on 1/4/16.
 */
public class RaceResultService {

    private Collection<Client> clients = new HashSet<>();
    private Map<CATEGORIES, Set<Client>> clientsWithCategory = new HashMap<>();
    public enum CATEGORIES  {F1, HORSE, RALLY}

    {
        clientsWithCategory.put(CATEGORIES.F1, new HashSet<>());
        clientsWithCategory.put(CATEGORIES.HORSE, new HashSet<>());
        clientsWithCategory.put(CATEGORIES.RALLY, new HashSet<>());
    }

    public void addSubscriber(Client client) {
        this.clients.add(client);
    }

    public void addSubscriber(Client client, CATEGORIES category) {
        clientsWithCategory.get(category).add(client);
    }
    public void send(Message message) {
        for (Client client: clients){
            client.receive(message);
        }
    }

    public void send(Message message, CATEGORIES category) {
        for (Client client: clientsWithCategory.get(category)){
            client.receive(message);
        }
    }

    public void removeSubscriber(Client client) {
        if (!clients.remove(client)) throw new IllegalArgumentException();
    }
}
