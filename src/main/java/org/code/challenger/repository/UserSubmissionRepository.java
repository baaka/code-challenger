package org.code.challenger.repository;

import org.code.challenger.domain.UserSubmission;
import org.code.challenger.model.dto.UserSubmissionTopDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserSubmissionRepository extends JpaRepository<UserSubmission, Long> {

    UserSubmission findByUserNameAndSuccessAndTaskId(String userName, boolean success, long taskId);

    @Query("select new org.code.challenger.model.dto.UserSubmissionTopDto(count(us.id),us.userName) from UserSubmission us where us.success = true group by us.userName order by max(us.id) asc, count(us.id) desc")
    Page<UserSubmissionTopDto> findTopSuccessfulSubmissionsWithPagination(Pageable pageable);

    List<UserSubmission> findAllByUserNameAndSuccess(String userName, boolean success);
}
