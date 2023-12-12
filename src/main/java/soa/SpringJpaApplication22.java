package soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import soa.entities.Client;
import soa.metier.ClientMetierInterface;

@SpringBootApplication
public class SpringJpaApplication22 {
    static ClientMetierInterface clientMetier;
    public static void main(String[] args) {
        System.out.println("---------Dependency Injection----------");
        ApplicationContext context = SpringApplication.run(SpringJpaApplication22.class, args);
        clientMetier = context.getBean(ClientMetierInterface.class);

        // Insérer un produit sans catégorie et sans stock
        System.out.println("Insérer un clients");
        Client Client1 =new Client(null,"Kharrat", "Kais", 26539478, "Manzel cheker" );
        Client Client2 =new Client(null,"Werdi", "Jihen", 24100810, "Route Gremda km 12" );
        Client Client3 =new Client(null,"fairouz", "raouin", 22312111, "Route Mahdia km2.5" );
        clientMetier.ajouterClient(Client1);
        clientMetier.ajouterClient(Client2);
        clientMetier.ajouterClient(Client3);
        System.out.println("3 clients Insérer ");

        System.out.println("La Liste Des Clients");
      System.out.println(clientMetier.listeClients()) ;



    }
}
