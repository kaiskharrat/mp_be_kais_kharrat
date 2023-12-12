package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import soa.entities.Client;
import soa.repository.ClientRepository;

import java.util.List;

@RestController // pour déclarer un service web de type REST
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/clients") // http://localhost:8080/clients
public class ClientRESTController {
    @Autowired // pour l'injection de dépendances
    private ClientRepository clientRepos;
    // Message d'accueil
    // http://localhost:8080/produits/index (GET)
    @GetMapping(value ="/index" )
    public String accueil() {
        return "Client 1 : Kais kharrat";
    }
    // Afficher la liste des clients
    // http://localhost:8080/clients/ (GET)
    @GetMapping(
            // spécifier le path de la méthode
            value= "/",
// spécifier le format de retour en XML
            produces = {MediaType.APPLICATION_XML_VALUE , MediaType.APPLICATION_JSON_VALUE })

    public List<Client> getAllClients() {
        return clientRepos.findAll();
    }

    // Supprimer un produit par 'id' avec la méthode 'GET'
// http://localhost:8080/clients/delete/{id} (GET)


    @GetMapping(
// spécifier le path de la méthode
            value = "/delete/{id}")
    public void deleteClient(@PathVariable Long id)
    {
        clientRepos.deleteById(id);
    }
    // modifier un produit avec la méthode "PUT"
// http://localhost:8080/clients/ (PUT)
    @PutMapping(
// spécifier le path de la méthode
            value = "/" ,
//spécifier le format de retour
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Client updateClient(@RequestBody Client c)
    {
        return clientRepos.save(c);
    }

    // Supprimer un produit avec la méthode 'DELETE'
// http://localhost:8080/produits/ (DELETE)
    @PostMapping(
// spécifier le path de la méthode
            value = "/" ,
//spécifier le format de retour
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public Client ajouterClient(@RequestBody Client c)
    {
        return clientRepos.save(c);
    }

    // Supprimer un produit avec la méthode 'DEXLETE'
// http://localhost:8080/produits/ (DELETE)
    @DeleteMapping(
// spécifier le path de la méthode
            value = "/")
    public void deleteClient(@RequestBody Client c)
    {
        clientRepos.delete(c);
    }
//----------------------------------------------------------------------------------
@GetMapping(value = "/searchNum", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
public List<Client> findByNum(@RequestParam(name = "num") int num) {
    return clientRepos.findByNum(num);
}
    //----------------------------------------------------------------------------------
    @GetMapping(value = "/searchNom", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<Client> findByNom(@RequestParam(name = "nom") String nom) {
        return clientRepos.findByNom(nom);
    }

    //----------------------------------------------------------------------------------
    @GetMapping(value = "/searchPrenom", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<Client> findByPrenom(@RequestParam(name = "prenom") String prenom) {
        return clientRepos.findByPrenom(prenom);
    }
}
