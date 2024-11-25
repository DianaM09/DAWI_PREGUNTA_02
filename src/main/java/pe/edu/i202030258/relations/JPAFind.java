package pe.edu.i202030258.relations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202030258.entity.country;

public class JPAFind {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("worldPU");
        EntityManager em = emf.createEntityManager();

        country peru = em.find(country.class, "PER");
        if (peru != null) {
            peru.getCities().stream()
                    .filter(city -> city.getPopulation() > 700000)
                    .forEach(city -> System.out.println("Ciudad: " + city.getName() + ", Población: " + city.getPopulation()));
        } else {
            System.out.println("El país con código 'PER' no fue encontrado.");
        }
        em.close();
        emf.close();
    }
}
