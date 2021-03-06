package storagemanage;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface StoragemanageRepository extends PagingAndSortingRepository<Storagemanage, Long>{
	//Optional<Storagemanage> findBycustel( String getcustel);
}