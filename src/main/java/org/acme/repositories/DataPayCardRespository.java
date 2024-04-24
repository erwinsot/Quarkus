
package org.acme.repositories;
import org.acme.models.DataPayCard;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class DataPayCardRespository implements PanacheRepository <DataPayCard>{
    
}
