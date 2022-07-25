package dh.meli.relationships.repository;

import dh.meli.relationships.dto.AuthorDTO;
import dh.meli.relationships.model.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends CrudRepository<Author, Long> {
    @Query("select a from Author a where a.id = ?1")
    AuthorDTO getById(long id);

    @Query(value = "select * from author where id = ?1", nativeQuery = true)
    Author getNativeById(long id);

    // Para mudar a forma de consulta(fetch)
    // no nativo ficaria:
    // select a from Author a left join Address ad on a.id = ad.id_author where id = :id
    @Query("select a " +
            "from Author a left join fetch a.address " + // o fetch é responsável por fazer o join imediato
            "where a.id = :id")
    AuthorDTO getDtoEagle(long id);
}
