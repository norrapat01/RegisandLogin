package freelance.service.freelanceservice.History;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepositoryFreelance extends JpaRepository<HistoryFreelance,Long>{

    List<HistoryFreelance> findByName(String name);
    
}
