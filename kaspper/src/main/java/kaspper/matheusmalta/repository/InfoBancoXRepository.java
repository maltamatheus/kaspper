package kaspper.matheusmalta.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kaspper.matheusmalta.model.InfoBancoX;

@Repository
public interface InfoBancoXRepository extends CrudRepository<InfoBancoX, Long>{
	
	

}
